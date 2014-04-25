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
   
   public void printEnv(Vector<SymbolTable> env) {
      int i = 0;
      for(SymbolTable st : env) {
         printSymbolTable(st);
      }
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
 
   Vector<SymbolTable> env;
   StructTypes stypes;
   Vector<BasicBlock> cfgs = new Vector<BasicBlock>();
   int regCounter = 0;
   int labelCounter = 1;

   String getLabel() {
      return "L" + labelCounter++;
   }
}

generate [Vector<SymbolTable> symTableIn, StructTypes stypesIn] returns [Vector<BasicBlock> cfGraph]
   @init {
      env = symTableIn;
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
         System.out.println("---------Successfully Created Control Flow Graph!---------");
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
      regCounter = 0;
      BasicBlock newFunBlk = new BasicBlock("tempLabel");
   }
   :  {
         RegisterTable regTable = new RegisterTable();
      }
      ^(FUN funID=ID params[regTable, newFunBlk] ^(RETTYPE rettype) declarations[regTable] retSLBlock=statement_list[regTable, newFunBlk])
      {
          newFunBlk.label = $funID.text;
          BasicBlock funExitBlk = new BasicBlock(getLabel());
          funExitBlk.instructions.add(new RetInst());
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
         $retBlock = $prevBlock;
      }
   |  RETURN { $retBlock = $prevBlock; }
   ;

arguments [String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  retArgBlock = arg_list[callID, regTable, prevBlock]
      {
         $retBlock = $retArgBlock.retBlock;
      }
   ;

arg_list [String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
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
         prevBlock.instructions.add(new CallInst($callID, argCounter));
         $retBlock = $prevBlock;
      }
   |  ARGS { $retBlock = $prevBlock; }
   ;

conditional [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   @init {
      BasicBlock trueBlockIn = new BasicBlock(getLabel());
      BasicBlock falseBlockIn = new BasicBlock(getLabel());
      addBlockRel(prevBlock, trueBlockIn);
   }
   :  ^(IF guardReg=expression[regTable, prevBlock] trueBlock=block[regTable, trueBlockIn] (
      {
         addBlockRel(prevBlock, falseBlockIn);
         prevBlock.instructions.add(new CompImmInst($guardReg.regNum, 1));
      }
      falseBlock=block[regTable, falseBlockIn])?)
      {
         BasicBlock convergeBlock = new BasicBlock(getLabel());
         addBlockRel($trueBlock.retBlock, convergeBlock);
         
         if ($falseBlock.retBlock != null) {
            addBlockRel($falseBlock.retBlock, convergeBlock);
            prevBlock.instructions.add(new CBRNEInst($falseBlock.retBlock.label, $trueBlock.retBlock.label));
         } else {
            addBlockRel(falseBlockIn, convergeBlock);
            prevBlock.instructions.add(new CBRNEInst(falseBlockIn.label, $trueBlock.retBlock.label));
         }
         $retBlock = convergeBlock;
      }
   ;

invocation [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum]
   :  ^(INVOKE funcId=ID arguments[$funcId.text, regTable, prevBlock])
   {
      prevBlock.instructions.add(new LoadRetInst(regCounter));
      $regNum = regCounter++;
   }
   ;

loop [RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock]
   :  {
         String trueLabel = getLabel();
         BasicBlock bodyBlock = new BasicBlock(trueLabel); 
      }
      ^(WHILE guardReg=expression[regTable, prevBlock] retBodyBlock=block[regTable, bodyBlock] guardReg2=expression[regTable, bodyBlock])
      {
         String falseLabel = getLabel();
         BasicBlock loopExitBlock = new BasicBlock(falseLabel);
         addBlockRel($prevBlock, bodyBlock);
         addBlockRel(bodyBlock, loopExitBlock);
         prevBlock.instructions.add(new CompImmInst($guardReg.regNum, 1));
         prevBlock.instructions.add(new CBRNEInst(falseLabel, trueLabel));
         bodyBlock.instructions.add(new CompImmInst($guardReg2.regNum, 1));
         bodyBlock.instructions.add(new CBRNEInst(falseLabel, trueLabel));
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
   :  ^(ASSIGN retExpReg=expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum])
      {
         $retBlock = prevBlock;
      }
   ;

expression [RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum = null]
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
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveLEInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  ^(EQ regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveEQInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  ^(LT regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveLTInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  ^(GT regNum1=expression[regTable, prevBlock] regNum2=expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveGTInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  ^(NE expression[regTable, prevBlock] expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveNEInst(1, regCounter));
         $regNum = regCounter++;
      }
   |  ^(GE expression[regTable, prevBlock] expression[regTable, prevBlock])
      {
         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
         prevBlock.instructions.add(new CompInst($regNum1.regNum, $regNum2.regNum));
         prevBlock.instructions.add(new MoveNEInst(1, regCounter));
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
         prevBlock.instructions.add(new LoadAIInst($retReg.regNum, $calledId.text, regCounter));
         $regNum = new Integer(regCounter++);
      }
   |  newId = ID
      {
         Integer varReg = regTable.get($newId.text);
         if (varReg == null) {
            prevBlock.instructions.add(new ComputeGlobalAddrInst($newId.text, regCounter));
            $regNum = new Integer(regCounter++);
         } else {
             prevBlock.instructions.add(new MoveInst(varReg, regCounter));
             $regNum = new Integer(regCounter++);
         }
      }
   |  intVal=INTEGER
      {
         prevBlock.instructions.add(new ImmInst(Integer.valueOf($intVal.text), regCounter));
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
         prevBlock.instructions.add(new NewInst($addrId.text, regCounter));
         $regNum = regCounter++;
      }
   |  ^(NEG returnReg=expression[regTable, prevBlock]) 
      {
         prevBlock.instructions.add(new ImmInst(-1, regCounter));
         prevBlock.instructions.add(new MultiplyInst(regCounter++, $returnReg.regNum, regCounter));
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
         prevBlock.instructions.add(new MoveInst($assReg, regTable.get($retId.text)));
         $regNum = regTable.get($retId.text);
      }
   |  ^(DOT retReg=lvalueLoad[regTable, prevBlock] newId=ID)
      {
         prevBlock.instructions.add(new StoreImmInst($assReg, $retReg.regNum, $newId.text));
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
            prevBlock.instructions.add(new LoadGlobalInst($retId.text, regCounter));
            $regNum = regCounter++;
         }
      }
   |  ^(DOT retReg=lvalueLoad[regTable, prevBlock] newId=ID)
      {
         prevBlock.instructions.add(new LoadAIInst($retReg.regNum, $newId.text, regCounter));
         $regNum = regCounter++;
      }
   ; 

rettype
   :  type
   |  VOID
   ;

params [RegisterTable regTable, BasicBlock prevBlock]
   @init {
      int paramNum = 0;
   }
   :  ^(PARAMS (declRetID=decl
      {
         $regTable.put($declRetID.id, regCounter);
         prevBlock.instructions.add(new LoadInArgumentInst($declRetID.id, paramNum++, regCounter++));
      })*)
   ;
