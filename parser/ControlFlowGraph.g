tree grammar ControlFlowGraph;

options
{
   tokenVocab=Mini;
   ASTLabelType=CommonTree;
   output=AST;
}

@header
{
   import java.util.Map;
   import java.util.HashMap;
   import java.util.Vector;
   import java.lang.String;
   import java.util.Iterator;
   import jbilous.support.*;
}

@members
{
   public void error(int id, String errorText) {
      throw new RuntimeException("Error at line " + id + ": " + errorText);
   }
   
   public void error(String errorText) {
      throw new RuntimeException(errorText);
   }
   
   public void printSymbolTable(SymbolTable st) {
      for (Map.Entry entry : st.symbols.entrySet()) {
         System.out.println(entry.getKey() + ", " + entry.getValue());
      }
   }

   public Type lookupType(String id, Vector<SymbolTable> env) {
      Type retType = null;
      Iterator it;
         for(SymbolTable st : env) {
         it = st.symbols.entrySet().iterator();
            while(it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            if(pairs.getKey().toString().compareTo(id) == 0) {
                  retType = (Type)pairs.getValue();
            }
         }
      }
         return retType;
   }

   void addBlockRel(BasicBlock parent, BasicBlock child) {
      parent.descendants.add(child);
      child.ancestors.add(parent);
   }
 
   HashMap<String, SymbolTable> env;
   StructTypes stypes;
   StructType curStruct;
   SymbolTable curEnv;
   SymbolTable globals;
   BasicBlock funExitBlk;
   Vector<BasicBlock> cfgs = new Vector<BasicBlock>();
   int regCounter;
   int numParams;
   int labelCounter;

   String getLabel() {
      return "L" + labelCounter++;
   }
}

generate [HashMap<String, SymbolTable> symTableIn, StructTypes stypesIn] returns [Vector<BasicBlock> cfGraph]
   @init {
      cfgs = new Vector<BasicBlock>();
      env = symTableIn;
      regCounter = 17;
      numParams = 0;
      labelCounter = 1;

      globals = env.get("globals");
      stypes = stypesIn;
   }
   :  program EOF
      {
         $cfGraph = cfgs;
      }
   |  { error(0, "EOF Not Found!"); }
;

program
   :  ^(PROGRAM . . functions)
      {  
          System.out.println("~~~~~~CONGRATZ U HAZ CREATED CONTROL FLOW GRAPH!~~~~~~");
      }
   ;

types
   :   ^(TYPES types_sub)
   |   TYPES
   ;

types_sub
   :  type_decl types_sub
   |  
   ;

type_decl
   :  ^(STRUCT^ id=ID nested_decl)
   ;
    
nested_decl
   :  decl+
   ;
   
decl returns [String id]
   :  ^(DECL ^(TYPE type) myId=ID)
      {
         $id = $myId.text;
      } 
   ;

declarations [RegisterTable regTable]
   :  ^(DECLS declaration[regTable]*) 
   ;

declaration [RegisterTable regTable]
   :  decllist [regTable]
   ;

type
   :  INT
   |  BOOL 
   |  ^(STRUCT ID)
   ;

decllist [RegisterTable regTable]
   :  ^(DECLLIST ^(TYPE type) id_list[regTable])
   ;

id_list [RegisterTable regTable]
   :  (decId=ID
      {
         $regTable.put($decId.text, new Integer(regCounter++));
      })+
   ;
   
functions
   :  ^(FUNCS (retFunBlock=function
      {
         cfgs.add($retFunBlock.retBlock);
      })*)
   ;

function returns [BasicBlock retBlock]
   @init{
      regCounter = 17;
      BasicBlock newFunBlk = new BasicBlock("tempLabel");
      newFunBlk.funEntrance = true;
      funExitBlk = new BasicBlock(getLabel());
   }
   :  {
         RegisterTable regTable = new RegisterTable();
      }
      ^(FUN funID=ID {
         curEnv = env.get($funID.text);
      }
         paramRet=params[regTable, newFunBlk] {
         numParams = $paramRet.numParams;
         newFunBlk.numParams = numParams;
      } 
      ^(RETTYPE rettype) declarations[regTable] retSLBlock=statement_list[regTable, newFunBlk])
      {
          newFunBlk.label = "_" + $funID.text;
          funExitBlk.funExit = true;
          funExitBlk.funLabel = "_" + $funID.text;
          funExitBlk.numParams = numParams;
          addBlockRel($retSLBlock.retBlock, funExitBlk);
          $retBlock=newFunBlk;
      }
   ;

statement_list [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(STMTS (retStmtBlock=statement[regTable, prevBlock]
      {
         $prevBlock = $retStmtBlock.retBlock;
      })*)
      {
         if ($retStmtBlock.retBlock != null) {
            $retBlock = $retStmtBlock.retBlock;
         } else {
            $retBlock = $prevBlock;
         }
      }
   ;
   

statement [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  {
         BasicBlock blockBlock = new BasicBlock(getLabel());
         addBlockRel(prevBlock, blockBlock);
      }
      blockReturnBlock=block[regTable, blockBlock]
      {
         $retBlock = $blockReturnBlock.retBlock;
      }
   |  retAssBlock=assignment[regTable, prevBlock]
      {
         $retBlock = $retAssBlock.retBlock;
      }
   |  {
         BasicBlock condBlock = new BasicBlock(getLabel());
         addBlockRel(prevBlock, condBlock);
      }
      retCondBlock=conditional[regTable, condBlock]
      {
         $retBlock = $retCondBlock.retBlock;
      }
   |  retLoopBlock=loop[regTable, prevBlock]
      {
         $retBlock = $retLoopBlock.retBlock;
      }
   |  invocation[regTable, prevBlock]
      {
         $retBlock = $prevBlock;
      }
   |  retReturnBlock=ret[regTable, prevBlock]
      {
         $retBlock = $retReturnBlock.retBlock;
      }
   |  retReadBlock=read[regTable, prevBlock]
      {
         $retBlock = $retReadBlock.retBlock;
      }
   |  retPrintBlock=print[regTable, prevBlock]
      {
         $retBlock = $retPrintBlock.retBlock;
      }
   |  retDeleteBlock=delete[regTable, prevBlock]
      {
         $retBlock = $retDeleteBlock.retBlock;
      }
   ;

read [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(READ retReg=lvalueRead[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ReadInst($retReg.regNum));
         $retBlock = $prevBlock;
      }
   ;

delete [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   : ^(DELETE delRetReg=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new DeleteInst($delRetReg.regNum));
         $retBlock = $prevBlock;
      }
   ;

print [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(PRINT returnReg=expression[regTable, prevBlock] ENDL?)
      {
         prevBlock.instructions.add(new PrintInst($returnReg.regNum));
         $retBlock = $prevBlock;
      }
   ;

ret [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(RETURN returnReg = expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ReturnInst($returnReg.regNum));
         prevBlock.instructions.add(new BranchInst(funExitBlk.label));
         $retBlock = $prevBlock;
      }
   |  RETURN 
      { 
         prevBlock.instructions.add(new BranchInst(funExitBlk.label));
         $retBlock = $prevBlock; 
      }
   ;

arguments [String callID, RegisterTable regTable, BasicBlock prevBlock] returns [Integer numArgs]
   :  retNumArgs = arg_list[callID, regTable, prevBlock]
      {
         $numArgs = $retNumArgs.numArgs;
      }
   ;

arg_list [String callID, RegisterTable regTable, BasicBlock prevBlock] returns [Integer numArgs]
   @init {
      int argCounter = 0;
      Vector<Instruction> storeCache = new Vector<Instruction>();
   }
   :  ^(ARGS (retArg=expression[regTable, prevBlock]
      {
         storeCache.add(new StoreOutInst($retArg.regNum, argCounter++));
      })+)
      {
         for(Instruction inst : storeCache) {
            prevBlock.instructions.add(inst);
         }
         $numArgs = argCounter;
      }
   |  ARGS {$numArgs = new Integer(0); }
   ;

conditional [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   @init {
      BasicBlock trueBlockIn = new BasicBlock(getLabel());
      BasicBlock falseBlockIn = new BasicBlock(getLabel());
      addBlockRel(prevBlock, trueBlockIn);
      addBlockRel(prevBlock, falseBlockIn);
   }
   :  ^(IF guardReg=expression[regTable, prevBlock] trueBlock=block[regTable, trueBlockIn] (falseBlock=block[regTable, falseBlockIn])?)
      {
         BasicBlock convergeBlock = new BasicBlock(getLabel());
         addBlockRel($trueBlock.retBlock, convergeBlock);
         prevBlock.instructions.add(new CompImmInst(1, $guardReg.regNum));
         prevBlock.instructions.add(new BRNEInst(falseBlockIn.label, trueBlockIn.label));

         if ($falseBlock.retBlock != null) {
            addBlockRel($falseBlock.retBlock, convergeBlock);
            $falseBlock.retBlock.instructions.add(new BranchInst(convergeBlock.label));
            $trueBlock.retBlock.instructions.add(new BranchInst(convergeBlock.label));
         } else {
            addBlockRel(falseBlockIn, convergeBlock);
            falseBlockIn.instructions.add(new BranchInst(convergeBlock.label));
            $trueBlock.retBlock.instructions.add(new BranchInst(convergeBlock.label));
         }
         $retBlock = convergeBlock;
      }
   ;

invocation [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum]
   :  ^(INVOKE funcId=ID retNumArgs=arguments[$funcId.text, regTable, prevBlock])
   {
      prevBlock.instructions.add(new CallInst("_" + $funcId.text, $retNumArgs.numArgs));
      prevBlock.instructions.add(new LoadRetInst(regCounter));
      $regNum = regCounter++;
   }
   ;

loop [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   @init {
      String trueLabel = getLabel();
      String falseLabel = getLabel();
      BasicBlock bodyBlock = new BasicBlock(trueLabel); 
   }
   :  ^(WHILE guardReg=expression[regTable, prevBlock] retBodyBlock=block[regTable, bodyBlock] guardReg2=expression[regTable, $retBodyBlock.retBlock])
      {
         prevBlock.instructions.add(new CompImmInst(1, $guardReg.regNum));
         prevBlock.instructions.add(new BRNEInst(falseLabel, trueLabel));
         BasicBlock loopExitBlock = new BasicBlock(falseLabel);
         $retBodyBlock.retBlock.instructions.add(new CompImmInst(1, $guardReg2.regNum));
         $retBodyBlock.retBlock.instructions.add(new BRNEInst(falseLabel, trueLabel));

         addBlockRel($prevBlock, bodyBlock);
         addBlockRel(bodyBlock, loopExitBlock);
         $retBlock = loopExitBlock;
      }
   ;

block [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(BLOCK returnSLBlock=statement_list[regTable, prevBlock])
      {
          $retBlock = $returnSLBlock.retBlock;
      }
   ;

assignment [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  ^(ASSIGN retExpReg=expression[regTable, prevBlock] retLvalueReg=lvalue[regTable, prevBlock, $retExpReg.regNum])
      {
         $retBlock = prevBlock;
      }
   ;

expression [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum = null, Integer retInt = null]
   :  invRetReg=invocation[regTable, prevBlock]
      {
         $regNum = $invRetReg.regNum;
      }
   |  ^(AND regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new AndInst($regNum1.regNum, $regNum2.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  ^(OR regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new OrInst($regNum1.regNum, $regNum2.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  ^(LE regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveLEImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(EQ regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveEQImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(LT regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveLTImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(GT regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveGTImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(NE regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveNEImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(GE regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         ImmInst immInst = new ImmInst(new Integer(0), regCounter);
         immInst.isCritical = true;
         prevBlock.instructions.add(immInst);
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveGEImmInst(new Integer(1), regCounter));
         $regNum = regCounter++;
      }
   |  ^(PLUS regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
   {
      prevBlock.instructions.add(new AddInst($regNum1.regNum, $regNum2.regNum, regCounter));
      $regNum = regCounter++;
   }
   |  ^(MINUS regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new SubtractInst($regNum1.regNum, $regNum2.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  ^(TIMES regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new MultiplyInst($regNum1.regNum, $regNum2.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  ^(DIVIDE regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new DivideInst($regNum1.regNum, $regNum2.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  ^(NOT expression[regTable, prevBlock])
   |  ^(DOT retReg=expression[regTable, prevBlock] calledId=ID)
      { 
         LoadAIInst inst = new LoadAIInst($retReg.regNum, $calledId.text, regCounter);
         inst.offset = curStruct.memberCounts.get($calledId.text);
         if(curStruct.get($calledId.text) instanceof StructType) {
            curStruct = (StructType)curStruct.get($calledId.text);
         }
         prevBlock.instructions.add(inst);
         $regNum = new Integer(regCounter++);
      }
   |  newId = ID
      {
         Integer varReg = regTable.get($newId.text);
         if (varReg == null) {
            ComputeGlobalAddrInst globInst = new ComputeGlobalAddrInst($newId.text, regCounter);
            globInst.type = globals.get($newId.text);
            if(globInst.type instanceof StructType) {
               curStruct = (StructType)globInst.type;
            }
            prevBlock.instructions.add(globInst);
            $regNum = new Integer(regCounter++);
         } else {
            System.out.println("--> Found" + $newId.text + " at " + varReg);
             prevBlock.instructions.add(new MoveInst(varReg, regCounter));
             $regNum = new Integer(regCounter++);
         }
      }
   |  intVal=INTEGER
      {
         prevBlock.instructions.add(new ImmInst(Integer.valueOf($intVal.text), regCounter));
         $retInt = new Integer($intVal.text);
         $regNum = regCounter++;
      }
   |  TRUE 
      {
         prevBlock.instructions.add(new ImmInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  FALSE
      {
         prevBlock.instructions.add(new ImmInst(0, regCounter));
         $regNum = regCounter++;
      }
   |  ^(NEW addrId=ID)
      {
         NewInst newInst = new NewInst($addrId.text, regCounter);
         newInst.assReg = regCounter;
         StructType newStruct = (StructType)stypes.get($addrId.text);
         newInst.size = newStruct.memberCount * 8;
         prevBlock.instructions.add(newInst);
         $regNum = regCounter++;
      }
   |  ^(NEG returnReg=expression[regTable, prevBlock]) 
      {
         prevBlock.instructions.add(new ImmInst(-1, regCounter));
         prevBlock.instructions.add(new MultiplyInst(regCounter, $returnReg.regNum, regCounter));
         $regNum = regCounter++;
      }
   |  NULL
      {
         prevBlock.instructions.add(new ImmInst(0, regCounter));
         $regNum = regCounter++;
      }
   ;
   
lvalue [RegisterTable regTable, BasicBlock prevBlock, Integer assReg] returns [Integer regNum]
   :  retId=ID
      {
         if(curEnv.get($retId.text) instanceof StructType)
         {
            curStruct = (StructType)curEnv.get($retId.text);
         }
         prevBlock.instructions.add(new MoveInst($assReg, regTable.get($retId.text)));
         $regNum = regTable.get($retId.text);
      }
   |  ^(DOT retReg=lvalueLoad[regTable, prevBlock] newId=ID)
      {
         System.out.println("Store for " + $newId.text);
         // Generate the appropriate instruction depending on the member type

         StoreImmInst inst = new StoreImmInst($assReg, $retReg.regNum, $newId.text);
         inst.offset = curStruct.memberCounts.get($newId.text);
         System.out.println("member count for " + $newId.text + " is " + inst.offset);
         prevBlock.instructions.add(inst);
      }
   ;

lvalueRead [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum]
   :  retId=ID
      {
         $regNum = regTable.get($retId.text);
      }
   |  ^(DOT retReg=lvalueRead[regTable, prevBlock] newId=ID)
      {
         prevBlock.instructions.add(new LoadAIInst($retReg.regNum, $newId.text, regCounter));
         $regNum = regCounter++;
      }
   ;

lvalueLoad [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum]
   :  retId=ID
      {
         $regNum = regTable.get($retId.text);
         if ($regNum == null) {
            LoadGlobalInst inst = new LoadGlobalInst($retId.text, regCounter);
            curStruct = (StructType)globals.get($retId.text);
            prevBlock.instructions.add(inst);
            $regNum = regCounter++;
         }
      }
   |  ^(DOT retReg=lvalueLoad[regTable, prevBlock] newId=ID)
      {
         LoadAIInst inst = new LoadAIInst($retReg.regNum, $newId.text, regCounter);
         inst.offset = curStruct.memberCounts.get($newId.text);
         curStruct = (StructType)curStruct.get($newId.text);
         prevBlock.instructions.add(inst);
         $regNum = regCounter++;
      }
   ; 

rettype
   :  type
   |  VOID
   ;

params [RegisterTable regTable, BasicBlock prevBlock] returns [int numParams]
   @init {
      int paramNum = 0;
   }
   :  ^(PARAMS (declRetID=decl
      {
         $regTable.put($declRetID.id, regCounter);
         prevBlock.instructions.add(new LoadInArgumentInst($declRetID.id, paramNum++, regCounter++));
      })*)
      {
         $numParams = paramNum;
      }
   ;
