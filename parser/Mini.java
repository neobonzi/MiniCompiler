import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;

import java.io.*;
import java.util.Vector;
import java.util.HashMap;
import jbilous.support.*;
import jbilous.support.assembly.*;
import jbilous.support.assembly.AssemblyRegister;

public class Mini
{
   public static void main(String[] args)
   {
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
      writer.println(String.format("%10s:", block.label));
      if (block.instructions.size() == 0){
         return;
      }
      for (Instruction inst : block.instructions) {
         writer.println(String.format("%15s %s", "", inst.toString()));
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
      writer.println(String.format("%10s:", block.label));
      if (block.assemInstructions.size() == 0){
         return;
      }
      for (AssemblyInstruction inst : block.assemInstructions) {
         writer.println(String.format("%15s %s", "", inst.toString()));
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
      cfgBlock.assemInstructions.add(new PushQ(AssemblyRegister.RBP));
      cfgBlock.assemInstructions.add(new MovQ(AssemblyRegister.RSP, AssemblyRegister.RBP));
   }

   private static void addEpilogue(BasicBlock cfgBlock) {
      cfgBlock.assemInstructions.add(new PopQ(AssemblyRegister.RBP));
      cfgBlock.assemInstructions.add(new Ret());
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

   private static void genCFG(TypeCheck tchecker, CommonTree tree, CommonTokenStream tokens)
   {
      try
      {
         CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
         ControlFlowGraph cfg = new ControlFlowGraph(nodes);
         ControlFlowGraph cfgAss = new ControlFlowGraph(nodes);

         ControlFlowGraph.generate_return cfgRet = cfg.generate(tchecker.getSymTable(), tchecker.getStructTypes());
         nodes.reset();
         ControlFlowGraph.generate_return cfgAssRet = cfg.generate(tchecker.getSymTable(), tchecker.getStructTypes());

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

         if (_dumpAss) {
            String assFile = _inputFile.replace(".mini", ".s");
            try{
               PrintWriter writer = new PrintWriter(assFile);
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
