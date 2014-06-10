import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

import java.io.*;
import java.util.Vector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Stack;
import jbilous.support.copyprop.*;
import java.util.BitSet;
import jbilous.support.*;
import java.util.ArrayList;
import jbilous.support.assembly.*;
import jbilous.support.assembly.AssemblyRegister;
import jbilous.support.lva.LVABlock;
import jbilous.support.lva.LVAIBlock;
import jbilous.support.graph.*;

public class GimmeCompilez
{
   public static void main(String[] args)
   {
      System.out.println("~~~~~~I CAN HAZ COMPILE?~~~~~~");
      parseParameters(args);

      CommonTokenStream tokens = new CommonTokenStream(createLexer());
      MiniParser parser = new MiniParser(tokens);
      CommonTree tree = parse(parser);

      if (_displayAST && tree != null)
      {
         DOTTreeGenerator gen = new DOTTreeGenerator();
         StringTemplate st = gen.toDOT(tree);
         System.out.println(st);
      }
      else if (!parser.hasErrors())
      {
         // To use a different tree parser, modify the code within validate.
         TypeCheck tcheck = validate(tree, tokens);
         genCFG(tcheck, tree, tokens);
      }
      System.out.println("~~~~~~CONGRATZ U HAZ COMPILE!~~~~~~");
   }

   private static final String DISPLAYAST = "-displayAST";
   private static final String DUMPIL = "-dumpIL";
    private static final String COPYPROP = "-copyPROP";  
   private static final String DUMPASS = "-dumpASS";
   private static final String REMUSELESS = "-removeUSELESS";
   private static HashMap<String, BasicBlock> printedBlocks = new HashMap<String, BasicBlock>();
   private static HashMap<String, BasicBlock> transformedBlocks = new HashMap<String, BasicBlock>();
   private static String _inputFile = null;
   private static int numSpills = 0;
   private static BasicBlock funExit;
   private static boolean copyUpdated = true;
   private static boolean _dumpAss = false;
   private static boolean _displayAST = false;
   private static boolean _dumpIL = false;
   private static boolean _remUSELESS = false;
   private static int curOffset = 0;
   private static boolean _copyPROP = false;

   private static void parseParameters(String [] args)
   {
      for (int i = 0; i < args.length; i++)
      {
         if (args[i].equals(DISPLAYAST))
         {
            _displayAST = true;
         }
         else if(args[i].equals(COPYPROP)) 
         {
            _copyPROP = true;
         }
         else if (args[i].equals(DUMPIL))
         {
            _dumpIL = true;
         }
         else if (args[i].equals(REMUSELESS))
         {
            _remUSELESS = true;
         }
         else if (args[i].equals(DUMPASS))
         {
            _dumpAss = true;
         }
         else if (args[i].charAt(0) == '-')
         {
            System.err.println("unexpected option: " + args[i]);
            System.exit(1);
         }
         else if (_inputFile != null)
        {
            System.err.println("too many files specified");
            System.exit(1);
         }
         else
         {
            _inputFile = args[i];
         }
      }
   }

   private static void printBlock(PrintWriter writer, BasicBlock block) {
      writer.println(String.format("%6s:", block.label));
      if (block.instructions.size() == 0){
         return;
      }
      for (Instruction inst : block.instructions) {
         writer.println(String.format("%9s %s", "",  inst.toString()));
      }
   }

   private static void printCFG(PrintWriter writer, BasicBlock cfgBlock) {
      if(!printedBlocks.containsKey(cfgBlock.label)) {
         printedBlocks.put(cfgBlock.label, cfgBlock);
         printBlock(writer, cfgBlock);
         if (cfgBlock.descendants.size() > 0) {
            int i = 0;
            for (BasicBlock descBlock : cfgBlock.descendants) {
               printCFG(writer, descBlock);
            }
         }
      }
   }
   private static void printBlockAssem(PrintWriter writer, BasicBlock block) {
      writer.println(String.format("%6s:", block.label));
      if (block.assemInstructions.size() == 0){
         return;
      }
      for (AssemblyInstruction inst : block.assemInstructions) {
         writer.println(String.format("%6s %s", "", inst.toString()));
         System.out.println(String.format("%6s %s", "", inst.toString()));
      }
   }
   private static void printCFGAssem(PrintWriter writer, BasicBlock cfgBlock) {
      if(!printedBlocks.containsKey(cfgBlock.label)) {
         printedBlocks.put(cfgBlock.label, cfgBlock);
         printBlockAssem(writer, cfgBlock);
         if (cfgBlock.descendants.size() > 0) {
            int i = 0;
            for (BasicBlock descBlock : cfgBlock.descendants) {
               printCFGAssem(writer, descBlock);
            }
         }
      }
   }

   private static void addPreamble(BasicBlock cfgBlock, boolean isMain) {
      cfgBlock.assemInstructions.add(new MovQ(new AssemblyRegister(x86_64Reg.RSP), new AssemblyRegister(x86_64Reg.RBP)));
      if(!isMain)
      {
         MovQ rbxMove = new MovQ(new AssemblyRegister(x86_64Reg.RBX), new AssemblyRegister(x86_64Reg.RBP));
         MovQ r12Move = new MovQ(new AssemblyRegister(x86_64Reg.R12), new AssemblyRegister(x86_64Reg.RBP));
         MovQ r13Move = new MovQ(new AssemblyRegister(x86_64Reg.R13), new AssemblyRegister(x86_64Reg.RBP));
         MovQ r14Move = new MovQ(new AssemblyRegister(x86_64Reg.R14), new AssemblyRegister(x86_64Reg.RBP));
         MovQ r15Move = new MovQ(new AssemblyRegister(x86_64Reg.R15), new AssemblyRegister(x86_64Reg.RBP));
         rbxMove.toMem = true;
         rbxMove.stackPos = -8;
         r12Move.toMem = true;
         r12Move.stackPos = -16;
         r13Move.toMem = true;
         r13Move.stackPos = -24;
         r14Move.toMem = true;
         r14Move.stackPos = -32;
         r15Move.toMem = true;
         r15Move.stackPos = -40;
         cfgBlock.assemInstructions.add(rbxMove);
         cfgBlock.assemInstructions.add(r12Move);
         cfgBlock.assemInstructions.add(r13Move);
         cfgBlock.assemInstructions.add(r14Move);
         cfgBlock.assemInstructions.add(r15Move);
      }
   }

   private static void addEpilogue(BasicBlock cfgBlock, boolean isMain) {
      if(!isMain)
      {
         MovQ rbxMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.RBX));
         MovQ r12Move = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R12));
         MovQ r13Move = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R13));
         MovQ r14Move = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R14));
         MovQ r15Move = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R15));
         rbxMove.stackPos = -1;
         r12Move.stackPos = -2;
         r13Move.stackPos = -3;
         r14Move.stackPos = -4;
         r15Move.stackPos = -5; 
         rbxMove.fromMem = true;
         r12Move.fromMem = true;
         r13Move.fromMem = true;
         r14Move.fromMem = true;
         r15Move.fromMem = true;
         cfgBlock.assemInstructions.add(rbxMove);
         cfgBlock.assemInstructions.add(r12Move);
         cfgBlock.assemInstructions.add(r13Move);
         cfgBlock.assemInstructions.add(r14Move);
         cfgBlock.assemInstructions.add(r15Move);
      }
      cfgBlock.assemInstructions.add(new PopQ(new AssemblyRegister(x86_64Reg.RBP)));
      cfgBlock.assemInstructions.add(new Ret());
      //cfgBlock.assemInstructions.add(new FuncSize(cfgBlock.funLabel));
   }

   private static void transformBlock(BasicBlock cfgBlock) {
      if (cfgBlock.instructions.size() == 0) {
         return;
      } else {
         for (Instruction ins : cfgBlock.instructions) {
            try{
               cfgBlock.assemInstructions.addAll(ins.genAssembly());
            } catch (Exception e) {
               System.out.println("woops" + ins);
            }
         }
      }
   }

   private static void transformCFG(BasicBlock cfgBlock, boolean isMain) {
      if(!transformedBlocks.containsKey(cfgBlock.label)) {
         transformedBlocks.put(cfgBlock.label, cfgBlock);
         if(cfgBlock.funEntrance) {
            addPreamble(cfgBlock, cfgBlock.label.equals("_main"));
         }

         if(cfgBlock.funExit) {
            funExit = cfgBlock;
         }

         transformBlock(cfgBlock);
         if (cfgBlock.descendants.size() > 0) {
            int i = 0;
            for (BasicBlock descBlock : cfgBlock.descendants) {
               transformCFG(descBlock, isMain);
               if(descBlock.funExit) {

                  addEpilogue(descBlock, isMain);
               }
            }
         }
      }
   }

private static void adaptLVAILiveOuts(HashMap<String, LVAIBlock> lvaHash, Vector<BasicBlock> blockList) {
      int changedCount;
      System.out.println("SIZE : " + blockList.size());
      do {
         changedCount = 0;
         for(BasicBlock blk : blockList) {
            // System.out.println("adapting " + blk.label);
            LVAIBlock lvaBlock = lvaHash.get(blk.label);
            Vector<LVAIBlock> descLVAList = new Vector<LVAIBlock>();
            for(BasicBlock anc : blk.descendants) {
               // System.out.println(anc.label + " is a descendent of " + blk.label);
               descLVAList.add(lvaHash.get(anc.label));
            }
            // System.out.println("DESCSIZE: " + descLVAList.size());
            boolean changed = lvaBlock.adaptLiveOut(descLVAList);
            if(changed) {
               changedCount++;
            }
            //System.out.println(lvaBlock.toString());
         }
         // System.out.println("changed count " + changedCount);
         //System.out.println(changedCount + " : " + blockList.size());
      } while(changedCount != 0);
}

   private static void adaptLiveOuts(HashMap<String, LVABlock> lvaHash, Vector<BasicBlock> blockList) {
      int changedCount;
      do {
         changedCount = 0;
         for(BasicBlock blk : blockList) {
            LVABlock lvaBlock = lvaHash.get(blk.label);
            Vector<LVABlock> descLVAList = new Vector<LVABlock>();
            for(BasicBlock desc : blk.descendants) {
               descLVAList.add(lvaHash.get(desc.label));
            }
            boolean changed = lvaBlock.adaptLiveOut(descLVAList);
            if(changed) {
               changedCount++;
            }
            //System.out.println(lvaBlock.toString());
         }
         //System.out.println(changedCount + " : " + blockList.size());
      } while(changedCount != 0);
   }

   private static void propogateLiveOuts(HashMap<String, LVABlock> lvaHash, Vector<BasicBlock> blockList, InterferenceGraph intGraph) {
      for(BasicBlock block : blockList) {
         LVABlock curBlock = lvaHash.get(block.label);
         BitSet liveNow = (BitSet)curBlock.getLiveOut().clone();
         Vector<AssemblyInstruction> instructions = (Vector<AssemblyInstruction>)block.assemInstructions.clone();
         Collections.reverse(instructions);

         for(AssemblyInstruction i : instructions) {
            // System.out.println("processing " + i + " with a livenow of " + liveNow);
            i.updateGraph(liveNow, intGraph);
         }
      }
   }

   private static void calcGenKills(BasicBlock entryBlock, HashMap<String, LVABlock> lvaHash, Vector<BasicBlock> blockList) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);
         blockList.add(entryBlock);
         LVABlock lvaBlock = new LVABlock(entryBlock.label);
         Vector<AssemblyInstruction> instructions = (Vector<AssemblyInstruction>)entryBlock.assemInstructions.clone();
         Collections.reverse(instructions);
         for (AssemblyInstruction i : instructions) {
            i.updateLVA(lvaBlock);
         }
         lvaHash.put(entryBlock.label, lvaBlock);
         for (BasicBlock desc : entryBlock.descendants) {
            calcGenKills(desc, lvaHash, blockList);
         }
      }
   }

   private static void calcGenKillsILOC(BasicBlock entryBlock, HashMap<String, LVAIBlock> lvaiHash, Vector<BasicBlock> blockList) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);
         blockList.add(entryBlock);
         LVAIBlock lvaiBlock = new LVAIBlock(entryBlock.label);
         Vector<Instruction> instructions = (Vector<Instruction>)entryBlock.instructions.clone();
         for (Instruction i : instructions) {
            i.updateILLVA(lvaiBlock);
         }
         lvaiHash.put(entryBlock.label, lvaiBlock);
         for (BasicBlock desc : entryBlock.descendants) {
            calcGenKillsILOC(desc, lvaiHash, blockList);
         }
         System.out.println("Gen kills for ILOC " + lvaiBlock.label);
         System.out.println(lvaiBlock.getGenSet() + " " + lvaiBlock.getKillSet());
      }
   }

   private static void colorGraph(InterferenceGraph graph) {
      Stack<IntGraphNode> nodeStack = new Stack<IntGraphNode>();
      Vector<IntGraphNode> graphNodes = graph.getNodes();

      // While graph not empty
      while(!graphNodes.isEmpty()) {
         //Collections.sort(graphNodes, cmp);
         // Remove node with least edges and put in stack
         nodeStack.push(graph.removeNode(graphNodes.remove(0)));
         System.out.println("put " + nodeStack.peek() + " on stack");
      }

      //Color Graph
      while(!nodeStack.empty()) {
         graph.reconstructNode(nodeStack.pop().getRegister());
      }
   }

   private static void addAssIntro(PrintWriter writer, String fileName, SymbolTable globals) {
      writer.println(String.format("%6s.file   \"" + fileName + ".c\"", ""));
      writer.println(String.format("%6s.section    __TEXT,__cstring,cstring_literals", ""));
      writer.println("L_.str:");
      writer.println("      .asciz   \"%ld\\n\\0\"");
      writer.println("      .text");
      writer.println("      .globl _main");
      writer.println("L2_.str:");
      writer.println("      .asciz   \"%ld\\0\"");
      writer.println("      .text");
      writer.println("      .globl _main");
      for (String key : globals.symbols.keySet()) {
         if(!(globals.symbols.get(key) instanceof FunctionType)) {
            String comm = new String(".comm   " + key + ",8,8");
            writer.println(String.format("%6s%s","", comm));
         }
      }
   }

   private static Integer allocateRegisters(InterferenceGraph intGraph, BasicBlock cfgBlock, HashMap<Integer, Integer> stackVarMap) {
      if(!transformedBlocks.containsKey(cfgBlock.label)) {
 
         for(int instNum = 0; instNum < cfgBlock.assemInstructions.size(); instNum++) {
            AssemblyInstruction inst = cfgBlock.assemInstructions.get(instNum);
            BitSet result = inst.updateRegisters(intGraph);
            boolean spilledOne = false;

            if(inst instanceof LeaQ)
            {
               LeaQ loadInst = (LeaQ)inst;
               if(loadInst.setMe)
               {
                  Integer loadOffset = curOffset * -1;
                  System.out.println("Offset " + loadOffset);
                  loadInst.varOffset =  loadOffset.toString();
                  curOffset += 8;
               }
            } 
            else if (inst instanceof MovQ)
            {
               MovQ moveInst = (MovQ)inst;
               if(moveInst.relatedLoad != null)
               {
                  moveInst.varOffset =  moveInst.relatedLoad.varOffset;
               }
            }

            if(result.get(0)) {
               // Spilled Source 1
               spilledOne = true;
               MovQ loadMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R10));
               if(inst.getSource() instanceof VirtualRegister)
               {
                  VirtualRegister vr = (VirtualRegister)inst.getSource();
                  System.out.println("Found Source: " + vr + " stack pos: " + stackVarMap.get(vr.getRegNum()).toString());
                  loadMove.varOffset = "-" + stackVarMap.get(vr.getRegNum()).toString();
               }
               loadMove.fromMem = true;
               cfgBlock.assemInstructions.add(instNum, loadMove);
               inst.setSource(new AssemblyRegister(x86_64Reg.R10));
            }
            if(result.get(1)) {
               AssemblyRegister sourceReg2;
               // Spilled Source 2
               sourceReg2 = new AssemblyRegister(x86_64Reg.R11);
               MovQ loadMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), sourceReg2);
               if(inst.getSource2() instanceof VirtualRegister)
               {
                  VirtualRegister vr = (VirtualRegister)inst.getSource2();
                  System.out.println("Found Source: " + vr + " stack pos: " + stackVarMap.get(vr.getRegNum()).toString());
                  loadMove.varOffset = "-" + stackVarMap.get(vr.getRegNum()).toString();
               }
               loadMove.fromMem = true;
               cfgBlock.assemInstructions.add(instNum, loadMove);
               inst.setSource2(sourceReg2);
            }
            if(result.get(2)) {
               AssemblyRegister targetReg;
               if(spilledOne)
               {
                  targetReg = new AssemblyRegister(x86_64Reg.R10);
               } 
               else
               {
                  targetReg = new AssemblyRegister(x86_64Reg.R11);
               }
               // Spilled Target - sub out for R11
               // Create a move after insturction that copies target to memory
               MovQ storeMove = new MovQ(targetReg, new AssemblyRegister(x86_64Reg.RBP));
               storeMove.toMem = true;
               if(inst.getTarget() instanceof VirtualRegister)
               {
                  VirtualRegister vr = (VirtualRegister)inst.getTarget();
                  //Check if its already been spilled
                  if(stackVarMap.containsKey(vr.getRegNum()))
                  {
                     storeMove.stackPos = -1 * stackVarMap.get(vr.getRegNum());
                     System.out.println("Spilled target: " + vr + " stack pos: " + stackVarMap.get(vr.getRegNum()).toString());
                  }
                  else
                  {
                     curOffset += 8;
                     storeMove.stackPos = curOffset * -1;
                     stackVarMap.put(vr.getRegNum(), curOffset);
                     System.out.println("Spilled target: " + vr + " stack pos: " + stackVarMap.get(vr.getRegNum()).toString());
                  }
               }
               cfgBlock.assemInstructions.add(instNum + 1, storeMove);
               inst.setTarget(targetReg);
            }
         }
         for (AssemblyInstruction i : cfgBlock.assemInstructions) {
            i.updateRegisters(intGraph);
         }

         transformedBlocks.put(cfgBlock.label, cfgBlock);

         for (BasicBlock descBlock : cfgBlock.descendants) {
            allocateRegisters(intGraph, descBlock, stackVarMap);
         }
      }
      return 0;
   }

   private static void copyProp(BasicBlock entryBlock) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);

         ArrayList<CPPair> cpIn = new ArrayList<CPPair>();
         ArrayList<CPPair> oldCpIn = entryBlock.copyIn;
         boolean intSet = false;

         for(BasicBlock predBlock : entryBlock.ancestors) {
            ArrayList<CPPair> predCpIn = predBlock.copyIn;
            ArrayList<Integer> predKill = predBlock.copyKill;
            ArrayList<CPPair> predGen = (ArrayList<CPPair>)predBlock.copyGen.clone();

            for(CPPair pair : predCpIn) {
               if(predKill.indexOf(pair.getTarget()) == -1 && predKill.indexOf(pair.getSource()) == -1)
               {
                  if(predGen.indexOf(pair) == -1) {
                     predGen.add(pair);
                  }
               }
            }
            if(!intSet) {
               cpIn.addAll(predGen);
               intSet = true;
            } else {
               for(Iterator<CPPair> it = cpIn.iterator(); it.hasNext();) {
                  CPPair pair = it.next();
                  if(!predGen.contains(pair)) {
                     it.remove();
                  }
               }
            }
         }

         if(!oldCpIn.equals(cpIn)) {
            entryBlock.copyIn = cpIn;
            copyUpdated = true;
         }

         // System.out.println("Copy set for " + entryBlock.label);
         // for(CPPair pair : cpIn) {
         //    System.out.print(pair + " ");
         // }

         for (BasicBlock descBlock : entryBlock.descendants) {
            copyProp(descBlock);
         }
      }
   }

   private static void replaceCopies(BasicBlock entryBlock, BasicBlock assBlock) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);
         Vector<Instruction> instructions = (Vector<Instruction>)entryBlock.instructions;
         Vector<Instruction> assInstructions = (Vector<Instruction>)assBlock.instructions;
         ArrayList<CPPair> copyIn = entryBlock.copyIn;
         // System.out.println("CopyIn set for " + entryBlock.label + " was :");
         // for(CPPair pair : copyIn) {
         //    System.out.print(pair + " ");
         // }
         // System.out.println("");
         for(int i = 0; i < instructions.size(); i++) {
            Instruction inst = instructions.get(i);
            Instruction assInst = assInstructions.get(i);
            for(CPPair pair : copyIn) {
            
               if(inst.getILSource() != null && inst.getILSource().equals(pair.getTarget())) {
                  inst.setILSource(pair.getSource());
                  assInst.setILSource(pair.getSource());
               }

               if(inst.getILSource2() != null && inst.getILSource2().equals(pair.getTarget())) {
                  inst.setILSource2(pair.getSource());
                  assInst.setILSource2(pair.getSource());
               }
            }
            
            // Remove killed stuff
            for(Iterator<CPPair> it = copyIn.iterator(); it.hasNext();) {
               CPPair pair = it.next();
               if(inst.getILTarget() != null && !inst.isCritical &&  (pair.getSource().equals(inst.getILTarget()) || pair.getTarget().equals(inst.getILTarget()))) { 
                  // System.out.println("Removing " + pair + " because of " + inst.getILTarget());
                  it.remove();
               }
            }

            if(inst instanceof MoveInst) {
               MoveInst movInst = (MoveInst)inst;
               CPPair newPair = new CPPair(movInst.getILSource(), movInst.getILTarget());
               if(!copyIn.contains(newPair)) {
                  copyIn.add(newPair);
               }
            }
            
         }
         
         // System.out.println("CopyIn set for " + entryBlock.label + "is now:");
         // for(CPPair pair : copyIn) {
         //    System.out.print(pair);
         // }
         // System.out.println("");

         for (int j = 0; j < entryBlock.descendants.size(); j++) {
            BasicBlock descBlock = entryBlock.descendants.get(j);
            BasicBlock descAssBlock = assBlock.descendants.get(j);
            replaceCopies(descBlock, descAssBlock);
         }
      }
   }

   private static void genCopyProp(BasicBlock entryBlock) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);

         Vector<Instruction> instructions = (Vector<Instruction>)entryBlock.instructions.clone();
         ArrayList<Integer> killSet = entryBlock.copyKill;
         Collections.reverse(instructions);

         for (Instruction inst : instructions) {
            if(inst instanceof MoveInst) {
               MoveInst moveInst = (MoveInst)inst;
               if(killSet.indexOf(moveInst.getILSource()) == -1 && killSet.indexOf(moveInst.getILTarget()) == -1) {
                  entryBlock.copyGen.add(new CPPair(moveInst.getILSource(), moveInst.getILTarget()));
                  killSet.add(moveInst.getILTarget());
               }
            } else {
               Integer targetReg = inst.getILTarget();
               if(targetReg != null && killSet.indexOf(targetReg) == -1) {
                  killSet.add(targetReg);
               }
            }
         }

         for (BasicBlock descBlock : entryBlock.descendants) {
            genCopyProp(descBlock);
         }
      }
   }

   private static void removeUseless(BasicBlock entryBlock, BasicBlock assBlock, HashMap<String, LVAIBlock> lvaiHash) {
      if(!transformedBlocks.containsKey(entryBlock.label)) {
         transformedBlocks.put(entryBlock.label, entryBlock);

         Vector<Instruction> instructions = (Vector<Instruction>)entryBlock.instructions;
         Vector<Instruction> assInstructions = (Vector<Instruction>)assBlock.instructions;
         LVAIBlock lvaiBlock = lvaiHash.get(entryBlock.label);
         ArrayList<Instruction> toRemove = new ArrayList<Instruction>();
         ArrayList<Instruction> toRemoveAss = new ArrayList<Instruction>();
         BitSet liveNow = (BitSet)lvaiBlock.getLiveOut().clone();
         // System.out.println("Removing shit from " + entryBlock.label + " and heres whats used after me " + lvaiBlock.getLiveOut());
         for(int j = instructions.size() - 1; j >= 0; j--)
         {
            // System.out.println("instruction " + j + " of " + instructions.size());
            Instruction inst = instructions.get(j);
            // System.out.println("Checking " + inst + " exists in " + liveNow);
            if(inst.getILTarget() != null && !inst.isCritical && !liveNow.get(inst.getILTarget()))
            {
               toRemove.add(inst);
               toRemoveAss.add(assInstructions.get(j));
            } else {
               if(inst.getILTarget() != null) {
                  liveNow.clear(inst.getILTarget());
               }
               if(inst.getILSource() != null)
               {
                  liveNow.set(inst.getILSource());
               }

               if(inst.getILSource2() != null)
               {
                  liveNow.set(inst.getILSource2());
               }
            }
         }

         instructions.removeAll(toRemove);
         assInstructions.removeAll(toRemoveAss);

         for (int i = 0; i < entryBlock.descendants.size(); i++) {
            removeUseless(entryBlock.descendants.get(i), assBlock.descendants.get(i), lvaiHash);
         }
      }
   }

   private static void genCFG(TypeCheck tchecker, CommonTree tree, CommonTokenStream tokens)
   {
      try
      {
         CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
         ControlFlowGraph cfg = new ControlFlowGraph(nodes);
         ControlFlowGraph cfgAss = new ControlFlowGraph(nodes);

         ControlFlowGraph.generate_return cfgRet = cfg.generate(tchecker.getEnvMap(), tchecker.getStructTypes());
         nodes.reset();
         ControlFlowGraph.generate_return cfgAssRet = cfg.generate(tchecker.getEnvMap(), tchecker.getStructTypes());

         Vector<BasicBlock> cfgBlocks = cfgRet.cfGraph;
         Vector<BasicBlock> cfgAssBlocks = cfgAssRet.cfGraph;
         transformedBlocks = new HashMap<String, BasicBlock>();

         if(_copyPROP) {
            transformedBlocks.clear();
            for(BasicBlock cfgBlock : cfgBlocks) {
               genCopyProp(cfgBlock);
            }

            for(BasicBlock cfgBlock : cfgBlocks) {
               while(copyUpdated) {
                  copyUpdated = false;
                  transformedBlocks.clear();
                  copyProp(cfgBlock);
               }
            }

            transformedBlocks.clear();
            for(int i = 0; i < cfgBlocks.size(); i++)
            {
               BasicBlock cfgBlock = cfgBlocks.get(i);
               BasicBlock cfgAssBlock = cfgAssBlocks.get(i);
               replaceCopies(cfgBlock, cfgAssBlock);
            }
         }

         if(_remUSELESS) {
            // System.out.println("removing useless");
            HashMap<String, LVAIBlock> lvaiHash = new HashMap<String, LVAIBlock>();
            for (int i = 0; i < cfgBlocks.size(); i++) {
               Vector<BasicBlock> blockList = new Vector<BasicBlock>();
               BasicBlock cfgBlock = cfgBlocks.get(i);
               BasicBlock assBlock = cfgAssBlocks.get(i);
               transformedBlocks.clear();
               calcGenKillsILOC(cfgBlock, lvaiHash, blockList);
               transformedBlocks.clear();
               adaptLVAILiveOuts(lvaiHash, blockList);
               transformedBlocks.clear();
               removeUseless(cfgBlock, assBlock, lvaiHash);
            }
         }

         if (_dumpIL) {
            String ilFile = _inputFile.replace(".mini", ".il");
            try{
               PrintWriter writer = new PrintWriter(ilFile);
               for(BasicBlock cfgBlock : cfgBlocks) {
                  printCFG(writer, cfgBlock);
               }
               writer.flush();
               writer.close();
            } catch(FileNotFoundException e) {
               System.out.println("File not found");
            }
         }

         //Apply LVA
         HashMap<String, InterferenceGraph> intGraphHash = new HashMap<String, InterferenceGraph>();

         for (BasicBlock cfgBlock : cfgAssBlocks) {
            HashMap<String, LVABlock> lvaHash = new HashMap<String, LVABlock>();
            curOffset = 0;
            if(!cfgBlock.label.equals("_main"))
            {
               curOffset = 48;
            } else {
               curOffset = 8;
            }
            HashMap<Integer, Integer> stackVarHash = new HashMap<Integer, Integer>();
            Vector<BasicBlock> blockList = new Vector<BasicBlock>();
            transformedBlocks.clear();

            cfgBlock.assemInstructions.add(new PushQ(new AssemblyRegister(x86_64Reg.RBP)));
            if(cfgBlock.label.equals("_main"))
            {
               transformCFG(cfgBlock, true);
            }
            else
            {
               transformCFG(cfgBlock, false);
            }

            transformedBlocks.clear();
            //Calculate Gen/Kill sets
            calcGenKills(cfgBlock, lvaHash, blockList);
            //System.out.println(blockList.size());
            //Loop and update Live Out Sets
            transformedBlocks.clear();
            adaptLiveOuts(lvaHash, blockList);
            // Create Interference Graph
            InterferenceGraph intGraph = new InterferenceGraph();
            intGraph.addEdge(2, 3);
            intGraph.addEdge(2, 4);
            intGraph.addEdge(2, 5);
            intGraph.addEdge(2, 8);
            intGraph.addEdge(2, 9);
            intGraph.addEdge(3, 4);
            intGraph.addEdge(3, 5);
            intGraph.addEdge(3, 8);
            intGraph.addEdge(3, 9);
            intGraph.addEdge(4, 5);
            intGraph.addEdge(4, 8);
            intGraph.addEdge(4, 9);
            intGraph.addEdge(5, 8);
            intGraph.addEdge(5, 9);
            intGraph.addEdge(8, 9);
            transformedBlocks.clear();
            propogateLiveOuts(lvaHash, blockList, intGraph);
            //intGraph.printGraph();
            colorGraph(intGraph);
            intGraph.printColors();
            transformedBlocks.clear();
            allocateRegisters(intGraph, cfgBlock, stackVarHash);
            Integer finalStackOffset = 80 + curOffset;
            // I HATE YOU MAC DIE DIE DIE.
            finalStackOffset = (((int)Math.ceil(curOffset / 128.0)) * 128); 
            cfgBlock.assemInstructions.add(2, new SubQ(new ImmediateRegister(finalStackOffset), new AssemblyRegister(x86_64Reg.RSP)));
            funExit.assemInstructions.add(funExit.assemInstructions.size() - 2, new AddQ(new ImmediateRegister(finalStackOffset), new AssemblyRegister(x86_64Reg.RSP)));
         }

         if (_dumpAss) {
            String assFile = _inputFile.replace(".mini", ".s");
            try{
               PrintWriter writer = new PrintWriter(assFile);
               BasicBlock funExit = cfgAssBlocks.get(0);
               //Get Globals
               SymbolTable globals = tchecker.getEnvMap().get("globals");
               addAssIntro(writer, _inputFile.replace(".mini", ""), globals);
               printedBlocks = new HashMap<String, BasicBlock>();
               for(BasicBlock cfgBlock : cfgAssBlocks) {
                  // System.out.println("transforming and printing " + cfgBlock.label);
                  printCFGAssem(writer, cfgBlock);
               }
               writer.close();
            } catch(FileNotFoundException e) {
               System.out.println("File not found");
            }
         }
      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }
   }


   private static CommonTree parse(MiniParser parser)
   {
      try
      {
         MiniParser.program_return ret = parser.program();

         return (CommonTree)ret.getTree();
      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }
      catch (Exception e)
      {
         System.exit(-1);
      }

      return null;
   }

   private static TypeCheck validate(CommonTree tree, CommonTokenStream tokens)
   {
      TypeCheck tparser = null;
      try
      {
         CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
         nodes.setTokenStream(tokens);
         tparser = new TypeCheck(nodes);
         tparser.verify();
         return tparser;
      }
      catch (org.antlr.runtime.RecognitionException e)
      {
         error(e.toString());
      }
      return tparser;
   }

   private static void error(String msg)
   {
      System.err.println(msg);
      System.exit(1);
   }

   private static MiniLexer createLexer()
   {
      try
      {
         ANTLRInputStream input;
         if (_inputFile == null)
         {
            input = new ANTLRInputStream(System.in);
         }
         else
         {
            input = new ANTLRInputStream(
               new BufferedInputStream(new FileInputStream(_inputFile)));
         }
         return new MiniLexer(input);
      }
      catch (java.io.IOException e)
      {
         System.err.println("file not found: " + _inputFile);
         System.exit(1);
         return null;
      }
   }
}
