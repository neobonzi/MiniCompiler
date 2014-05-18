import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

import java.io.*;
import java.util.Vector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import java.util.BitSet;
import jbilous.support.*;
import jbilous.support.assembly.*;
import jbilous.support.assembly.AssemblyRegister;
import jbilous.support.lva.LVABlock;
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
   private static final String DUMPASS = "-dumpASS";
   private static HashMap<String, BasicBlock> printedBlocks = new HashMap<String, BasicBlock>();
   private static HashMap<String, BasicBlock> transformedBlocks = new HashMap<String, BasicBlock>();
   private static String _inputFile = null;
   private static boolean _dumpAss = false;
   private static boolean _displayAST = false;
   private static boolean _dumpIL = false;

   private static void parseParameters(String [] args)
   {
      for (int i = 0; i < args.length; i++)
      {
         if (args[i].equals(DISPLAYAST))
         {
            _displayAST = true;
         }
         else if (args[i].equals(DUMPIL))
         {
            _dumpIL = true;
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

   private static void colorGraph(InterferenceGraph graph) {
      Stack<IntGraphNode> nodeStack = new Stack<IntGraphNode>();
      Vector<IntGraphNode> graphNodes = graph.getNodes();

      // While graph not empty
      while(!graphNodes.isEmpty()) {
         Collections.sort(graphNodes);
         // Remove node with least edges and put in stack
         nodeStack.push(graph.removeNode(graphNodes.remove(0)));
      }

      //Color Graph
      while(!nodeStack.empty()) {
         System.out.println("coloring " + nodeStack.peek().getRegister());
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

   private static void allocateRegisters(InterferenceGraph intGraph, BasicBlock cfgBlock) {
      if(!transformedBlocks.containsKey(cfgBlock.label)) {
 
         for(int instNum = 0; instNum < cfgBlock.assemInstructions.size(); instNum++) {
            AssemblyInstruction inst = cfgBlock.assemInstructions.get(instNum);
            BitSet result = inst.updateRegisters(intGraph);
            boolean spilledOne = false;

            if(result.get(0)) {
               // Spilled Source 1
               spilledOne = true;
               MovQ loadMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.R10));
               loadMove.varOffset = "8";
               loadMove.fromMem = true;
               cfgBlock.assemInstructions.add(instNum, loadMove);
               inst.setSource(new AssemblyRegister(x86_64Reg.R10));
            }
            if(result.get(1)) {
               AssemblyRegister targetReg;
               // Spilled Source 2
               if(spilledOne) {
                  targetReg = new AssemblyRegister(x86_64Reg.R11);
               } else {
                  targetReg = new AssemblyRegister(x86_64Reg.R10);
               }
               MovQ loadMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), targetReg);
               loadMove.varOffset = "8";
               loadMove.fromMem = true;
               cfgBlock.assemInstructions.add(instNum, loadMove);
               inst.setSource(targetReg);
            }
            if(result.get(2)) {
               AssemblyRegister sourceReg;
               // Spilled Source 2
               if(spilledOne) {
                  sourceReg = new AssemblyRegister(x86_64Reg.R11);
               } else {
                  sourceReg = new AssemblyRegister(x86_64Reg.R10);
               }
               // Spilled Target - sub out for R11
               // Create a move after insturction that copies target to memory
               MovQ storeMove = new MovQ(sourceReg, new AssemblyRegister(x86_64Reg.RBP));
               storeMove.toMem = true;
               storeMove.varOffset = "8";
               cfgBlock.assemInstructions.add(instNum + 1, storeMove);
               inst.setSource2(sourceReg);
            }
         }
         for (AssemblyInstruction i : cfgBlock.assemInstructions) {
            i.updateRegisters(intGraph);
         }

         transformedBlocks.put(cfgBlock.label, cfgBlock);

         for (BasicBlock descBlock : cfgBlock.descendants) {
            allocateRegisters(intGraph, descBlock);
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

         if (_dumpIL) {
            String ilFile = _inputFile.replace(".mini", ".il");
            try{
               PrintWriter writer = new PrintWriter(ilFile);
               for(BasicBlock cfgBlock : cfgBlocks) {
                  printCFG(writer, cfgBlock);
               }
               writer.close();
            } catch(FileNotFoundException e) {
               System.out.println("File not found");
            }
         }

         //Apply LVA
         HashMap<String, HashMap<String, LVABlock>> funcLVABlocks = new HashMap<String, HashMap<String, LVABlock>>();
         HashMap<String, InterferenceGraph> intGraphHash = new HashMap<String, InterferenceGraph>();
         transformedBlocks = new HashMap<String, BasicBlock>();
         for (BasicBlock cfgBlock : cfgAssBlocks) {
            HashMap<String, LVABlock> lvaHash = new HashMap<String, LVABlock>();
            Vector<BasicBlock> blockList = new Vector<BasicBlock>();
            transformedBlocks.clear();
            transformCFG(cfgBlock);
            transformedBlocks.clear();
            //Calculate Gen/Kill sets
            calcGenKills(cfgBlock, lvaHash, blockList);
            //System.out.println(blockList.size());
            //Loop and update Live Out Sets
            adaptLiveOuts(lvaHash, blockList);
            // Create Interference Graph
            InterferenceGraph intGraph = new InterferenceGraph();
            propogateLiveOuts(lvaHash, blockList, intGraph);
            intGraphHash.put(cfgBlock.label, intGraph);
            //intGraph.printGraph();
            colorGraph(intGraph);
            //intGraph.printColors();
            transformedBlocks.clear();
            allocateRegisters(intGraph, cfgBlock);
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
