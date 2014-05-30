import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

import java.io.*;
import java.util.Vector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
   private static boolean copyUpdated = true;
   private static boolean _dumpAss = false;
   private static boolean _displayAST = false;
   private static boolean _dumpIL = false;
   private static boolean _remUSELESS = false;
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

   private static void addPreamble(BasicBlock cfgBlock) {
      Register ar = new AssemblyRegister(x86_64Reg.RBP);
      cfgBlock.assemInstructions.add(new PushQ(ar));
      cfgBlock.assemInstructions.add(new MovQ(new AssemblyRegister(x86_64Reg.RSP), new AssemblyRegister(x86_64Reg.RBP)));
   }

   private static void addEpilogue(BasicBlock cfgBlock) {
      Register ar = new AssemblyRegister(x86_64Reg.RBP);
      cfgBlock.assemInstructions.add(new PopQ(ar));
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
            } catch (NoSuchMethodError e) {

            }
         }
      }
   }

   private static void transformCFG(BasicBlock cfgBlock) {
      if(!transformedBlocks.containsKey(cfgBlock.label)) {
         transformedBlocks.put(cfgBlock.label, cfgBlock);
         if(cfgBlock.funEntrance) {
            addPreamble(cfgBlock);
         }
         transformBlock(cfgBlock);
         if (cfgBlock.descendants.size() > 0) {
            int i = 0;
            for (BasicBlock descBlock : cfgBlock.descendants) {
               transformCFG(descBlock);
               if(descBlock.funExit) {
                  addEpilogue(descBlock);
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
            System.out.println("adapting " + blk.label);
            LVAIBlock lvaBlock = lvaHash.get(blk.label);
            Vector<LVAIBlock> descLVAList = new Vector<LVAIBlock>();
            for(BasicBlock anc : blk.descendants) {
               System.out.println(anc.label + " is a descendent of " + blk.label);
               descLVAList.add(lvaHash.get(anc.label));
            }
            System.out.println("DESCSIZE: " + descLVAList.size());
            boolean changed = lvaBlock.adaptLiveOut(descLVAList);
            if(changed) {
               changedCount++;
            }
            //System.out.println(lvaBlock.toString());
         }
         System.out.println("changed count " + changedCount);
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
            System.out.println("processing " + i + " with a livenow of " + liveNow);
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
         Collections.sort(graphNodes);
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
      writer.println("      .asciz   \"%d\\n\\0\"");
      writer.println("      .text");
      writer.println("      .globl _main");
      for (String key : globals.symbols.keySet()) {
         if(!(globals.symbols.get(key) instanceof FunctionType)) {
            String comm = new String(".comm   " + key + ",8,8");
            writer.println(String.format("%6s%s","", comm));
         }
      }
   }

   private static void allocateRegisters(InterferenceGraph intGraph, BasicBlock cfgBlock, HashMap<Integer, Integer> stackVarMap, Integer curOffset) {
      if(!transformedBlocks.containsKey(cfgBlock.label)) {
 
         for(int instNum = 0; instNum < cfgBlock.assemInstructions.size(); instNum++) {
            AssemblyInstruction inst = cfgBlock.assemInstructions.get(instNum);
            BitSet result = inst.updateRegisters(intGraph);
            boolean spilledOne = false;

            if(result.get(0)) {
               // Spilled Source 1
               spilledOne = true;
               MovQ loadMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R10));
               if(inst.getSource() instanceof VirtualRegister)
               {
                  VirtualRegister vr = (VirtualRegister)inst.getSource();
                  loadMove.varOffset = stackVarMap.get(vr.getRegNum()).toString();
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
                  loadMove.varOffset = stackVarMap.get(vr.getRegNum()).toString();
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
               storeMove.stackPos = curOffset;
               if(inst.getTarget() instanceof VirtualRegister)
               {
                  VirtualRegister vr = (VirtualRegister)inst.getTarget();
                  stackVarMap.put(vr.getRegNum(), curOffset);
               }
               cfgBlock.assemInstructions.add(instNum + 1, storeMove);
               inst.setTarget(targetReg);
               curOffset += 8;
            }
         }
         for (AssemblyInstruction i : cfgBlock.assemInstructions) {
            i.updateRegisters(intGraph);
         }

         transformedBlocks.put(cfgBlock.label, cfgBlock);

         for (BasicBlock descBlock : cfgBlock.descendants) {
            allocateRegisters(intGraph, descBlock, stackVarMap, curOffset);
         }
      }
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

         System.out.println("Copy set for " + entryBlock.label);
         for(CPPair pair : cpIn) {
            System.out.print(pair + " ");
         }

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
         System.out.println("CopyIn set for " + entryBlock.label + " was :");
         for(CPPair pair : copyIn) {
            System.out.print(pair + " ");
         }
         System.out.println("");
         for(int i = 0; i < instructions.size(); i++) {
            Instruction inst = instructions.get(i);
            Instruction assInst = assInstructions.get(i);
            for(CPPair pair : copyIn) {
            
               if(inst.getILSource() != null && inst.getILSource().equals(pair.getTarget())) {
                  inst.setILSource(pair.getSource());
                  assInst.setILSource(pair.getSource());
               }

               if(inst.getILSource1() != null && inst.getILSource1().equals(pair.getTarget())) {
                  inst.setILSource1(pair.getSource());
                  assInst.setILSource1(pair.getSource());
               }

               if(inst.getILSource2() != null && inst.getILSource2().equals(pair.getTarget())) {
                  inst.setILSource2(pair.getSource());
                  assInst.setILSource2(pair.getSource());
               }
            }
            
            // Remove killed stuff
            for(Iterator<CPPair> it = copyIn.iterator(); it.hasNext();) {
               CPPair pair = it.next();
               if(inst.getILTarget() != null && (pair.getSource().equals(inst.getILTarget()) || pair.getTarget().equals(inst.getILTarget()))) { 
                  System.out.println("Removing " + pair + " because of " + inst.getILTarget());
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
         
         System.out.println("CopyIn set for " + entryBlock.label + "is now:");
         for(CPPair pair : copyIn) {
            System.out.print(pair);
         }
         System.out.println("");

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
         System.out.println("Removing shit from " + entryBlock.label + " and heres whats used after me " + lvaiBlock.getLiveOut());
         for(int j = instructions.size() - 1; j >= 0; j--)
         {
            System.out.println("instruction " + j + " of " + instructions.size());
            Instruction inst = instructions.get(j);
            System.out.println("Checking " + inst + " exists in " + liveNow);
            if(inst.getILTarget() != null && !liveNow.get(inst.getILTarget()))
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

               if(inst.getILSource1() != null)
               {
                  liveNow.set(inst.getILSource1());
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
            System.out.println("removing useless");
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
            Integer stackVarPos = 8;
            HashMap<Integer, Integer> stackVarHash = new HashMap<Integer, Integer>();
            Vector<BasicBlock> blockList = new Vector<BasicBlock>();
            transformedBlocks.clear();
            transformCFG(cfgBlock);
            transformedBlocks.clear();
            //Calculate Gen/Kill sets
            calcGenKills(cfgBlock, lvaHash, blockList);
            //System.out.println(blockList.size());
            //Loop and update Live Out Sets
            transformedBlocks.clear();
            adaptLiveOuts(lvaHash, blockList);
            // Create Interference Graph
            InterferenceGraph intGraph = new InterferenceGraph();
            transformedBlocks.clear();
            propogateLiveOuts(lvaHash, blockList, intGraph);
            //intGraph.printGraph();
            colorGraph(intGraph);
            intGraph.printColors();
            transformedBlocks.clear();
            allocateRegisters(intGraph, cfgBlock, stackVarHash, stackVarPos);
            cfgBlock.assemInstructions.add(2, new SubQ(new ImmediateRegister(stackVarPos + 8), new AssemblyRegister(x86_64Reg.RSP)));
         }

         if (_dumpAss) {
            String assFile = _inputFile.replace(".mini", ".s");
            try{
               PrintWriter writer = new PrintWriter(assFile);
               //Get Globals
               SymbolTable globals = tchecker.getEnvMap().get("globals");
               addAssIntro(writer, _inputFile.replace(".mini", ""), globals);
               printedBlocks = new HashMap<String, BasicBlock>();
               for(BasicBlock cfgBlock : cfgAssBlocks) {
                  transformCFG(cfgBlock);
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
