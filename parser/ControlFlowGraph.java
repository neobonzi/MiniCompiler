// $ANTLR 3.5.2 ControlFlowGraph.g 2014-05-14 10:27:08

   import java.util.Map;
   import java.util.HashMap;
   import java.util.Vector;
   import java.lang.String;
   import java.util.Iterator;
   import jbilous.support.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


@SuppressWarnings("all")
public class ControlFlowGraph extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARGS", "ASSIGN", "BLOCK", 
		"BOOL", "COMMA", "COMMENT", "DECL", "DECLLIST", "DECLS", "DELETE", "DIVIDE", 
		"DOT", "ELSE", "ENDL", "EQ", "FALSE", "FUN", "FUNCS", "GE", "GT", "ID", 
		"IF", "INT", "INTEGER", "INVOKE", "LBRACE", "LE", "LPAREN", "LT", "MINUS", 
		"NE", "NEG", "NEW", "NOT", "NULL", "OR", "PARAMS", "PLUS", "PRINT", "PROGRAM", 
		"RBRACE", "READ", "RETTYPE", "RETURN", "RPAREN", "SEMI", "STMTS", "STRUCT", 
		"TIMES", "TRUE", "TYPE", "TYPES", "VOID", "WHILE", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ARGS=5;
	public static final int ASSIGN=6;
	public static final int BLOCK=7;
	public static final int BOOL=8;
	public static final int COMMA=9;
	public static final int COMMENT=10;
	public static final int DECL=11;
	public static final int DECLLIST=12;
	public static final int DECLS=13;
	public static final int DELETE=14;
	public static final int DIVIDE=15;
	public static final int DOT=16;
	public static final int ELSE=17;
	public static final int ENDL=18;
	public static final int EQ=19;
	public static final int FALSE=20;
	public static final int FUN=21;
	public static final int FUNCS=22;
	public static final int GE=23;
	public static final int GT=24;
	public static final int ID=25;
	public static final int IF=26;
	public static final int INT=27;
	public static final int INTEGER=28;
	public static final int INVOKE=29;
	public static final int LBRACE=30;
	public static final int LE=31;
	public static final int LPAREN=32;
	public static final int LT=33;
	public static final int MINUS=34;
	public static final int NE=35;
	public static final int NEG=36;
	public static final int NEW=37;
	public static final int NOT=38;
	public static final int NULL=39;
	public static final int OR=40;
	public static final int PARAMS=41;
	public static final int PLUS=42;
	public static final int PRINT=43;
	public static final int PROGRAM=44;
	public static final int RBRACE=45;
	public static final int READ=46;
	public static final int RETTYPE=47;
	public static final int RETURN=48;
	public static final int RPAREN=49;
	public static final int SEMI=50;
	public static final int STMTS=51;
	public static final int STRUCT=52;
	public static final int TIMES=53;
	public static final int TRUE=54;
	public static final int TYPE=55;
	public static final int TYPES=56;
	public static final int VOID=57;
	public static final int WHILE=58;
	public static final int WS=59;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public ControlFlowGraph(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ControlFlowGraph(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ControlFlowGraph.tokenNames; }
	@Override public String getGrammarFileName() { return "ControlFlowGraph.g"; }


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
	   Vector<BasicBlock> cfgs = new Vector<BasicBlock>();
	   int regCounter = 17;
	   int numParams = 0;
	   int labelCounter = 1;

	   String getLabel() {
	      return "L" + labelCounter++;
	   }


	public static class generate_return extends TreeRuleReturnScope {
		public Vector<BasicBlock> cfGraph;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "generate"
	// ControlFlowGraph.g:71:1: generate[HashMap<String, SymbolTable> symTableIn, StructTypes stypesIn] returns [Vector<BasicBlock> cfGraph] : ( program EOF |);
	public final ControlFlowGraph.generate_return generate(HashMap<String, SymbolTable> symTableIn, StructTypes stypesIn) throws RecognitionException {
		ControlFlowGraph.generate_return retval = new ControlFlowGraph.generate_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree EOF2=null;
		TreeRuleReturnScope program1 =null;

		CommonTree EOF2_tree=null;


		      env = symTableIn;
		      globals = env.get("globals");
		      stypes = stypesIn;
		   
		try {
			// ControlFlowGraph.g:77:4: ( program EOF |)
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==PROGRAM) ) {
				alt1=1;
			}
			else if ( (LA1_0==EOF) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ControlFlowGraph.g:77:7: program EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_program_in_generate71);
					program1=program();
					state._fsp--;

					adaptor.addChild(root_0, program1.getTree());

					_last = (CommonTree)input.LT(1);
					EOF2=(CommonTree)match(input,EOF,FOLLOW_EOF_in_generate73); 
					EOF2_tree = (CommonTree)adaptor.dupNode(EOF2);


					adaptor.addChild(root_0, EOF2_tree);


					         retval.cfGraph = cfgs;
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:81:7: 
					{
					root_0 = (CommonTree)adaptor.nil();


					 error(0, "EOF Not Found!"); 
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "generate"


	public static class program_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// ControlFlowGraph.g:84:1: program : ^( PROGRAM . . functions ) ;
	public final ControlFlowGraph.program_return program() throws RecognitionException {
		ControlFlowGraph.program_return retval = new ControlFlowGraph.program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PROGRAM3=null;
		CommonTree wildcard4=null;
		CommonTree wildcard5=null;
		TreeRuleReturnScope functions6 =null;

		CommonTree PROGRAM3_tree=null;
		CommonTree wildcard4_tree=null;
		CommonTree wildcard5_tree=null;

		try {
			// ControlFlowGraph.g:85:4: ( ^( PROGRAM . . functions ) )
			// ControlFlowGraph.g:85:7: ^( PROGRAM . . functions )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PROGRAM3=(CommonTree)match(input,PROGRAM,FOLLOW_PROGRAM_in_program103); 
			PROGRAM3_tree = (CommonTree)adaptor.dupNode(PROGRAM3);


			root_1 = (CommonTree)adaptor.becomeRoot(PROGRAM3_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			wildcard4=(CommonTree)input.LT(1);
			matchAny(input); 
			wildcard4_tree = (CommonTree)adaptor.dupTree(wildcard4);
			adaptor.addChild(root_1, wildcard4_tree);

			_last = (CommonTree)input.LT(1);
			wildcard5=(CommonTree)input.LT(1);
			matchAny(input); 
			wildcard5_tree = (CommonTree)adaptor.dupTree(wildcard5);
			adaptor.addChild(root_1, wildcard5_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_functions_in_program109);
			functions6=functions();
			state._fsp--;

			adaptor.addChild(root_1, functions6.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			  
			          System.out.println("~~~~~~CONGRATZ U HAZ CREATED CONTROL FLOW GRAPH!~~~~~~");
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"


	public static class types_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "types"
	// ControlFlowGraph.g:91:1: types : ( ^( TYPES types_sub ) | TYPES );
	public final ControlFlowGraph.types_return types() throws RecognitionException {
		ControlFlowGraph.types_return retval = new ControlFlowGraph.types_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree TYPES7=null;
		CommonTree TYPES9=null;
		TreeRuleReturnScope types_sub8 =null;

		CommonTree TYPES7_tree=null;
		CommonTree TYPES9_tree=null;

		try {
			// ControlFlowGraph.g:92:4: ( ^( TYPES types_sub ) | TYPES )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==TYPES) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					alt2=1;
				}
				else if ( (LA2_1==EOF) ) {
					alt2=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ControlFlowGraph.g:92:8: ^( TYPES types_sub )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					TYPES7=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types136); 
					TYPES7_tree = (CommonTree)adaptor.dupNode(TYPES7);


					root_1 = (CommonTree)adaptor.becomeRoot(TYPES7_tree, root_1);

					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_types_sub_in_types138);
						types_sub8=types_sub();
						state._fsp--;

						adaptor.addChild(root_1, types_sub8.getTree());

						match(input, Token.UP, null); 
					}
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 2 :
					// ControlFlowGraph.g:93:8: TYPES
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TYPES9=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types148); 
					TYPES9_tree = (CommonTree)adaptor.dupNode(TYPES9);


					adaptor.addChild(root_0, TYPES9_tree);

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "types"


	public static class types_sub_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "types_sub"
	// ControlFlowGraph.g:96:1: types_sub : ( type_decl types_sub |);
	public final ControlFlowGraph.types_sub_return types_sub() throws RecognitionException {
		ControlFlowGraph.types_sub_return retval = new ControlFlowGraph.types_sub_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope type_decl10 =null;
		TreeRuleReturnScope types_sub11 =null;


		try {
			// ControlFlowGraph.g:97:4: ( type_decl types_sub |)
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==STRUCT) ) {
				alt3=1;
			}
			else if ( (LA3_0==UP) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ControlFlowGraph.g:97:7: type_decl types_sub
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_decl_in_types_sub164);
					type_decl10=type_decl();
					state._fsp--;

					adaptor.addChild(root_0, type_decl10.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_types_sub_in_types_sub166);
					types_sub11=types_sub();
					state._fsp--;

					adaptor.addChild(root_0, types_sub11.getTree());

					}
					break;
				case 2 :
					// ControlFlowGraph.g:99:4: 
					{
					root_0 = (CommonTree)adaptor.nil();


					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "types_sub"


	public static class type_decl_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type_decl"
	// ControlFlowGraph.g:101:1: type_decl : ^( STRUCT ^id= ID nested_decl ) ;
	public final ControlFlowGraph.type_decl_return type_decl() throws RecognitionException {
		ControlFlowGraph.type_decl_return retval = new ControlFlowGraph.type_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree STRUCT12=null;
		TreeRuleReturnScope nested_decl13 =null;

		CommonTree id_tree=null;
		CommonTree STRUCT12_tree=null;

		try {
			// ControlFlowGraph.g:102:4: ( ^( STRUCT ^id= ID nested_decl ) )
			// ControlFlowGraph.g:102:7: ^( STRUCT ^id= ID nested_decl )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STRUCT12=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type_decl190); 
			STRUCT12_tree = (CommonTree)adaptor.dupNode(STRUCT12);


			root_1 = (CommonTree)adaptor.becomeRoot(STRUCT12_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_decl195); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_decl_in_type_decl197);
			nested_decl13=nested_decl();
			state._fsp--;

			adaptor.addChild(root_1, nested_decl13.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type_decl"


	public static class nested_decl_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_decl"
	// ControlFlowGraph.g:105:1: nested_decl : ( decl )+ ;
	public final ControlFlowGraph.nested_decl_return nested_decl() throws RecognitionException {
		ControlFlowGraph.nested_decl_return retval = new ControlFlowGraph.nested_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decl14 =null;


		try {
			// ControlFlowGraph.g:106:4: ( ( decl )+ )
			// ControlFlowGraph.g:106:7: ( decl )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ControlFlowGraph.g:106:7: ( decl )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DECL) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ControlFlowGraph.g:106:7: decl
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_decl_in_nested_decl218);
					decl14=decl();
					state._fsp--;

					adaptor.addChild(root_0, decl14.getTree());

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "nested_decl"


	public static class decl_return extends TreeRuleReturnScope {
		public String id;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "decl"
	// ControlFlowGraph.g:109:1: decl returns [String id] : ^( DECL ^( TYPE type ) myId= ID ) ;
	public final ControlFlowGraph.decl_return decl() throws RecognitionException {
		ControlFlowGraph.decl_return retval = new ControlFlowGraph.decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree myId=null;
		CommonTree DECL15=null;
		CommonTree TYPE16=null;
		TreeRuleReturnScope type17 =null;

		CommonTree myId_tree=null;
		CommonTree DECL15_tree=null;
		CommonTree TYPE16_tree=null;

		try {
			// ControlFlowGraph.g:110:4: ( ^( DECL ^( TYPE type ) myId= ID ) )
			// ControlFlowGraph.g:110:7: ^( DECL ^( TYPE type ) myId= ID )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECL15=(CommonTree)match(input,DECL,FOLLOW_DECL_in_decl243); 
			DECL15_tree = (CommonTree)adaptor.dupNode(DECL15);


			root_1 = (CommonTree)adaptor.becomeRoot(DECL15_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE16=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decl246); 
			TYPE16_tree = (CommonTree)adaptor.dupNode(TYPE16);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE16_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decl248);
			type17=type();
			state._fsp--;

			adaptor.addChild(root_2, type17.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			myId=(CommonTree)match(input,ID,FOLLOW_ID_in_decl253); 
			myId_tree = (CommonTree)adaptor.dupNode(myId);


			adaptor.addChild(root_1, myId_tree);

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         retval.id = (myId!=null?myId.getText():null);
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decl"


	public static class declarations_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declarations"
	// ControlFlowGraph.g:116:1: declarations[RegisterTable regTable] : ^( DECLS ( declaration[regTable] )* ) ;
	public final ControlFlowGraph.declarations_return declarations(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.declarations_return retval = new ControlFlowGraph.declarations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLS18=null;
		TreeRuleReturnScope declaration19 =null;

		CommonTree DECLS18_tree=null;

		try {
			// ControlFlowGraph.g:117:4: ( ^( DECLS ( declaration[regTable] )* ) )
			// ControlFlowGraph.g:117:7: ^( DECLS ( declaration[regTable] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLS18=(CommonTree)match(input,DECLS,FOLLOW_DECLS_in_declarations285); 
			DECLS18_tree = (CommonTree)adaptor.dupNode(DECLS18);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLS18_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:117:15: ( declaration[regTable] )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==DECLLIST) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// ControlFlowGraph.g:117:15: declaration[regTable]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_declaration_in_declarations287);
						declaration19=declaration(regTable);
						state._fsp--;

						adaptor.addChild(root_1, declaration19.getTree());

						}
						break;

					default :
						break loop5;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declarations"


	public static class declaration_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// ControlFlowGraph.g:120:1: declaration[RegisterTable regTable] : decllist[regTable] ;
	public final ControlFlowGraph.declaration_return declaration(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.declaration_return retval = new ControlFlowGraph.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decllist20 =null;


		try {
			// ControlFlowGraph.g:121:4: ( decllist[regTable] )
			// ControlFlowGraph.g:121:7: decllist[regTable]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_decllist_in_declaration309);
			decllist20=decllist(regTable);
			state._fsp--;

			adaptor.addChild(root_0, decllist20.getTree());

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class type_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// ControlFlowGraph.g:124:1: type : ( INT | BOOL | ^( STRUCT ID ) );
	public final ControlFlowGraph.type_return type() throws RecognitionException {
		ControlFlowGraph.type_return retval = new ControlFlowGraph.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree INT21=null;
		CommonTree BOOL22=null;
		CommonTree STRUCT23=null;
		CommonTree ID24=null;

		CommonTree INT21_tree=null;
		CommonTree BOOL22_tree=null;
		CommonTree STRUCT23_tree=null;
		CommonTree ID24_tree=null;

		try {
			// ControlFlowGraph.g:125:4: ( INT | BOOL | ^( STRUCT ID ) )
			int alt6=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt6=1;
				}
				break;
			case BOOL:
				{
				alt6=2;
				}
				break;
			case STRUCT:
				{
				alt6=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}
			switch (alt6) {
				case 1 :
					// ControlFlowGraph.g:125:7: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT21=(CommonTree)match(input,INT,FOLLOW_INT_in_type327); 
					INT21_tree = (CommonTree)adaptor.dupNode(INT21);


					adaptor.addChild(root_0, INT21_tree);

					}
					break;
				case 2 :
					// ControlFlowGraph.g:126:7: BOOL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOL22=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_type335); 
					BOOL22_tree = (CommonTree)adaptor.dupNode(BOOL22);


					adaptor.addChild(root_0, BOOL22_tree);

					}
					break;
				case 3 :
					// ControlFlowGraph.g:127:7: ^( STRUCT ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					STRUCT23=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type345); 
					STRUCT23_tree = (CommonTree)adaptor.dupNode(STRUCT23);


					root_1 = (CommonTree)adaptor.becomeRoot(STRUCT23_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					ID24=(CommonTree)match(input,ID,FOLLOW_ID_in_type347); 
					ID24_tree = (CommonTree)adaptor.dupNode(ID24);


					adaptor.addChild(root_1, ID24_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "type"


	public static class decllist_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "decllist"
	// ControlFlowGraph.g:130:1: decllist[RegisterTable regTable] : ^( DECLLIST ^( TYPE type ) id_list[regTable] ) ;
	public final ControlFlowGraph.decllist_return decllist(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.decllist_return retval = new ControlFlowGraph.decllist_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLLIST25=null;
		CommonTree TYPE26=null;
		TreeRuleReturnScope type27 =null;
		TreeRuleReturnScope id_list28 =null;

		CommonTree DECLLIST25_tree=null;
		CommonTree TYPE26_tree=null;

		try {
			// ControlFlowGraph.g:131:4: ( ^( DECLLIST ^( TYPE type ) id_list[regTable] ) )
			// ControlFlowGraph.g:131:7: ^( DECLLIST ^( TYPE type ) id_list[regTable] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLLIST25=(CommonTree)match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist367); 
			DECLLIST25_tree = (CommonTree)adaptor.dupNode(DECLLIST25);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLLIST25_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE26=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decllist370); 
			TYPE26_tree = (CommonTree)adaptor.dupNode(TYPE26);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE26_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decllist372);
			type27=type();
			state._fsp--;

			adaptor.addChild(root_2, type27.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_id_list_in_decllist375);
			id_list28=id_list(regTable);
			state._fsp--;

			adaptor.addChild(root_1, id_list28.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "decllist"


	public static class id_list_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id_list"
	// ControlFlowGraph.g:134:1: id_list[RegisterTable regTable] : (decId= ID )+ ;
	public final ControlFlowGraph.id_list_return id_list(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.id_list_return retval = new ControlFlowGraph.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree decId=null;

		CommonTree decId_tree=null;

		try {
			// ControlFlowGraph.g:135:4: ( (decId= ID )+ )
			// ControlFlowGraph.g:135:7: (decId= ID )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ControlFlowGraph.g:135:7: (decId= ID )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==ID) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// ControlFlowGraph.g:135:8: decId= ID
					{
					_last = (CommonTree)input.LT(1);
					decId=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list398); 
					decId_tree = (CommonTree)adaptor.dupNode(decId);


					adaptor.addChild(root_0, decId_tree);


					         regTable.put((decId!=null?decId.getText():null), new Integer(regCounter++));
					      
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "id_list"


	public static class functions_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "functions"
	// ControlFlowGraph.g:141:1: functions : ^( FUNCS (retFunBlock= function )* ) ;
	public final ControlFlowGraph.functions_return functions() throws RecognitionException {
		ControlFlowGraph.functions_return retval = new ControlFlowGraph.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FUNCS29=null;
		TreeRuleReturnScope retFunBlock =null;

		CommonTree FUNCS29_tree=null;

		try {
			// ControlFlowGraph.g:142:4: ( ^( FUNCS (retFunBlock= function )* ) )
			// ControlFlowGraph.g:142:7: ^( FUNCS (retFunBlock= function )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUNCS29=(CommonTree)match(input,FUNCS,FOLLOW_FUNCS_in_functions428); 
			FUNCS29_tree = (CommonTree)adaptor.dupNode(FUNCS29);


			root_1 = (CommonTree)adaptor.becomeRoot(FUNCS29_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:142:15: (retFunBlock= function )*
				loop8:
				while (true) {
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==FUN) ) {
						alt8=1;
					}

					switch (alt8) {
					case 1 :
						// ControlFlowGraph.g:142:16: retFunBlock= function
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_function_in_functions433);
						retFunBlock=function();
						state._fsp--;

						adaptor.addChild(root_1, retFunBlock.getTree());


						         cfgs.add((retFunBlock!=null?((ControlFlowGraph.function_return)retFunBlock).retBlock:null));
						      
						}
						break;

					default :
						break loop8;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "functions"


	public static class function_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function"
	// ControlFlowGraph.g:148:1: function returns [BasicBlock retBlock] : ^( FUN funID= ID paramRet= params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] ) ;
	public final ControlFlowGraph.function_return function() throws RecognitionException {
		ControlFlowGraph.function_return retval = new ControlFlowGraph.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree funID=null;
		CommonTree FUN30=null;
		CommonTree RETTYPE31=null;
		TreeRuleReturnScope paramRet =null;
		TreeRuleReturnScope retSLBlock =null;
		TreeRuleReturnScope rettype32 =null;
		TreeRuleReturnScope declarations33 =null;

		CommonTree funID_tree=null;
		CommonTree FUN30_tree=null;
		CommonTree RETTYPE31_tree=null;


		      regCounter = 17;
		      BasicBlock newFunBlk = new BasicBlock("tempLabel");
		      newFunBlk.funEntrance = true;
		   
		try {
			// ControlFlowGraph.g:154:4: ( ^( FUN funID= ID paramRet= params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] ) )
			// ControlFlowGraph.g:154:7: ^( FUN funID= ID paramRet= params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] )
			{
			root_0 = (CommonTree)adaptor.nil();



			         RegisterTable regTable = new RegisterTable();
			      
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUN30=(CommonTree)match(input,FUN,FOLLOW_FUN_in_function480); 
			FUN30_tree = (CommonTree)adaptor.dupNode(FUN30);


			root_1 = (CommonTree)adaptor.becomeRoot(FUN30_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			funID=(CommonTree)match(input,ID,FOLLOW_ID_in_function484); 
			funID_tree = (CommonTree)adaptor.dupNode(funID);


			adaptor.addChild(root_1, funID_tree);


			         curEnv = env.get((funID!=null?funID.getText():null));
			      
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_params_in_function499);
			paramRet=params(regTable, newFunBlk);
			state._fsp--;

			adaptor.addChild(root_1, paramRet.getTree());


			         numParams = (paramRet!=null?((ControlFlowGraph.params_return)paramRet).numParams:0);
			         newFunBlk.numParams = numParams;
			      
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			RETTYPE31=(CommonTree)match(input,RETTYPE,FOLLOW_RETTYPE_in_function512); 
			RETTYPE31_tree = (CommonTree)adaptor.dupNode(RETTYPE31);


			root_2 = (CommonTree)adaptor.becomeRoot(RETTYPE31_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rettype_in_function514);
			rettype32=rettype();
			state._fsp--;

			adaptor.addChild(root_2, rettype32.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_function517);
			declarations33=declarations(regTable);
			state._fsp--;

			adaptor.addChild(root_1, declarations33.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_function522);
			retSLBlock=statement_list(regTable, newFunBlk);
			state._fsp--;

			adaptor.addChild(root_1, retSLBlock.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			          newFunBlk.label = "_" + (funID!=null?funID.getText():null);
			          BasicBlock funExitBlk = new BasicBlock(getLabel());
			          funExitBlk.funExit = true;
			          funExitBlk.funLabel = "_" + (funID!=null?funID.getText():null);
			          funExitBlk.instructions.add(new RetInst());
			          funExitBlk.numParams = numParams;
			          addBlockRel((retSLBlock!=null?((ControlFlowGraph.statement_list_return)retSLBlock).retBlock:null), funExitBlk);
			          retval.retBlock =newFunBlk;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class statement_list_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement_list"
	// ControlFlowGraph.g:177:1: statement_list[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* ) ;
	public final ControlFlowGraph.statement_list_return statement_list(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.statement_list_return retval = new ControlFlowGraph.statement_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STMTS34=null;
		TreeRuleReturnScope retStmtBlock =null;

		CommonTree STMTS34_tree=null;

		try {
			// ControlFlowGraph.g:178:4: ( ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* ) )
			// ControlFlowGraph.g:178:7: ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STMTS34=(CommonTree)match(input,STMTS,FOLLOW_STMTS_in_statement_list555); 
			STMTS34_tree = (CommonTree)adaptor.dupNode(STMTS34);


			root_1 = (CommonTree)adaptor.becomeRoot(STMTS34_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:178:15: (retStmtBlock= statement[regTable, prevBlock] )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= ASSIGN && LA9_0 <= BLOCK)||LA9_0==DELETE||LA9_0==IF||LA9_0==INVOKE||LA9_0==PRINT||LA9_0==READ||LA9_0==RETURN||LA9_0==WHILE) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// ControlFlowGraph.g:178:16: retStmtBlock= statement[regTable, prevBlock]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_statement_list560);
						retStmtBlock=statement(regTable, prevBlock);
						state._fsp--;

						adaptor.addChild(root_1, retStmtBlock.getTree());


						         prevBlock = (retStmtBlock!=null?((ControlFlowGraph.statement_return)retStmtBlock).retBlock:null);
						      
						}
						break;

					default :
						break loop9;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         if ((retStmtBlock!=null?((ControlFlowGraph.statement_return)retStmtBlock).retBlock:null) != null) {
			            retval.retBlock = (retStmtBlock!=null?((ControlFlowGraph.statement_return)retStmtBlock).retBlock:null);
			         } else {
			            retval.retBlock = prevBlock;
			         }
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement_list"


	public static class statement_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// ControlFlowGraph.g:192:1: statement[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : (blockReturnBlock= block[regTable, blockBlock] |retAssBlock= assignment[regTable, prevBlock] |retCondBlock= conditional[regTable, condBlock] |retLoopBlock= loop[regTable, prevBlock] | invocation[regTable, prevBlock] |retReturnBlock= ret[regTable, prevBlock] |retReadBlock= read[regTable, prevBlock] |retPrintBlock= print[regTable, prevBlock] |retDeleteBlock= delete[regTable, prevBlock] );
	public final ControlFlowGraph.statement_return statement(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.statement_return retval = new ControlFlowGraph.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope blockReturnBlock =null;
		TreeRuleReturnScope retAssBlock =null;
		TreeRuleReturnScope retCondBlock =null;
		TreeRuleReturnScope retLoopBlock =null;
		TreeRuleReturnScope retReturnBlock =null;
		TreeRuleReturnScope retReadBlock =null;
		TreeRuleReturnScope retPrintBlock =null;
		TreeRuleReturnScope retDeleteBlock =null;
		TreeRuleReturnScope invocation35 =null;


		try {
			// ControlFlowGraph.g:193:4: (blockReturnBlock= block[regTable, blockBlock] |retAssBlock= assignment[regTable, prevBlock] |retCondBlock= conditional[regTable, condBlock] |retLoopBlock= loop[regTable, prevBlock] | invocation[regTable, prevBlock] |retReturnBlock= ret[regTable, prevBlock] |retReadBlock= read[regTable, prevBlock] |retPrintBlock= print[regTable, prevBlock] |retDeleteBlock= delete[regTable, prevBlock] )
			int alt10=9;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				alt10=1;
				}
				break;
			case ASSIGN:
				{
				alt10=2;
				}
				break;
			case IF:
				{
				alt10=3;
				}
				break;
			case WHILE:
				{
				alt10=4;
				}
				break;
			case INVOKE:
				{
				alt10=5;
				}
				break;
			case RETURN:
				{
				alt10=6;
				}
				break;
			case READ:
				{
				alt10=7;
				}
				break;
			case PRINT:
				{
				alt10=8;
				}
				break;
			case DELETE:
				{
				alt10=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// ControlFlowGraph.g:193:7: blockReturnBlock= block[regTable, blockBlock]
					{
					root_0 = (CommonTree)adaptor.nil();



					         BasicBlock blockBlock = new BasicBlock(getLabel());
					         addBlockRel(prevBlock, blockBlock);
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_statement616);
					blockReturnBlock=block(regTable, blockBlock);
					state._fsp--;

					adaptor.addChild(root_0, blockReturnBlock.getTree());


					         retval.retBlock = (blockReturnBlock!=null?((ControlFlowGraph.block_return)blockReturnBlock).retBlock:null);
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:201:7: retAssBlock= assignment[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assignment_in_statement635);
					retAssBlock=assignment(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retAssBlock.getTree());


					         retval.retBlock = (retAssBlock!=null?((ControlFlowGraph.assignment_return)retAssBlock).retBlock:null);
					      
					}
					break;
				case 3 :
					// ControlFlowGraph.g:205:7: retCondBlock= conditional[regTable, condBlock]
					{
					root_0 = (CommonTree)adaptor.nil();



					         BasicBlock condBlock = new BasicBlock(getLabel());
					         addBlockRel(prevBlock, condBlock);
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_conditional_in_statement662);
					retCondBlock=conditional(regTable, condBlock);
					state._fsp--;

					adaptor.addChild(root_0, retCondBlock.getTree());


					         retval.retBlock = (retCondBlock!=null?((ControlFlowGraph.conditional_return)retCondBlock).retBlock:null);
					      
					}
					break;
				case 4 :
					// ControlFlowGraph.g:213:7: retLoopBlock= loop[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_loop_in_statement681);
					retLoopBlock=loop(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retLoopBlock.getTree());


					         retval.retBlock = (retLoopBlock!=null?((ControlFlowGraph.loop_return)retLoopBlock).retBlock:null);
					      
					}
					break;
				case 5 :
					// ControlFlowGraph.g:217:7: invocation[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_statement698);
					invocation35=invocation(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, invocation35.getTree());


					         retval.retBlock = prevBlock;
					      
					}
					break;
				case 6 :
					// ControlFlowGraph.g:221:7: retReturnBlock= ret[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_ret_in_statement717);
					retReturnBlock=ret(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retReturnBlock.getTree());


					         retval.retBlock = (retReturnBlock!=null?((ControlFlowGraph.ret_return)retReturnBlock).retBlock:null);
					      
					}
					break;
				case 7 :
					// ControlFlowGraph.g:225:7: retReadBlock= read[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_read_in_statement736);
					retReadBlock=read(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retReadBlock.getTree());


					         retval.retBlock = (retReadBlock!=null?((ControlFlowGraph.read_return)retReadBlock).retBlock:null);
					      
					}
					break;
				case 8 :
					// ControlFlowGraph.g:229:7: retPrintBlock= print[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_print_in_statement755);
					retPrintBlock=print(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retPrintBlock.getTree());


					         retval.retBlock = (retPrintBlock!=null?((ControlFlowGraph.print_return)retPrintBlock).retBlock:null);
					      
					}
					break;
				case 9 :
					// ControlFlowGraph.g:233:7: retDeleteBlock= delete[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_delete_in_statement774);
					retDeleteBlock=delete(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retDeleteBlock.getTree());


					         retval.retBlock = (retDeleteBlock!=null?((ControlFlowGraph.delete_return)retDeleteBlock).retBlock:null);
					      
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class read_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "read"
	// ControlFlowGraph.g:239:1: read[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( READ retReg= lvalueRead[regTable, prevBlock] ) ;
	public final ControlFlowGraph.read_return read(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.read_return retval = new ControlFlowGraph.read_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree READ36=null;
		TreeRuleReturnScope retReg =null;

		CommonTree READ36_tree=null;

		try {
			// ControlFlowGraph.g:240:4: ( ^( READ retReg= lvalueRead[regTable, prevBlock] ) )
			// ControlFlowGraph.g:240:7: ^( READ retReg= lvalueRead[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			READ36=(CommonTree)match(input,READ,FOLLOW_READ_in_read806); 
			READ36_tree = (CommonTree)adaptor.dupNode(READ36);


			root_1 = (CommonTree)adaptor.becomeRoot(READ36_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalueRead_in_read810);
			retReg=lvalueRead(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, retReg.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         prevBlock.instructions.add(new ReadInst((retReg!=null?((ControlFlowGraph.lvalueRead_return)retReg).regNum:null)));
			         retval.retBlock = prevBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "read"


	public static class delete_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "delete"
	// ControlFlowGraph.g:247:1: delete[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( DELETE delRetReg= expression[regTable, prevBlock] ) ;
	public final ControlFlowGraph.delete_return delete(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.delete_return retval = new ControlFlowGraph.delete_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DELETE37=null;
		TreeRuleReturnScope delRetReg =null;

		CommonTree DELETE37_tree=null;

		try {
			// ControlFlowGraph.g:248:4: ( ^( DELETE delRetReg= expression[regTable, prevBlock] ) )
			// ControlFlowGraph.g:248:6: ^( DELETE delRetReg= expression[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DELETE37=(CommonTree)match(input,DELETE,FOLLOW_DELETE_in_delete842); 
			DELETE37_tree = (CommonTree)adaptor.dupNode(DELETE37);


			root_1 = (CommonTree)adaptor.becomeRoot(DELETE37_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_delete846);
			delRetReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, delRetReg.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         prevBlock.instructions.add(new DeleteInst((delRetReg!=null?((ControlFlowGraph.expression_return)delRetReg).regNum:null)));
			         retval.retBlock = prevBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "delete"


	public static class print_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "print"
	// ControlFlowGraph.g:255:1: print[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? ) ;
	public final ControlFlowGraph.print_return print(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.print_return retval = new ControlFlowGraph.print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PRINT38=null;
		CommonTree ENDL39=null;
		TreeRuleReturnScope returnReg =null;

		CommonTree PRINT38_tree=null;
		CommonTree ENDL39_tree=null;

		try {
			// ControlFlowGraph.g:256:4: ( ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? ) )
			// ControlFlowGraph.g:256:7: ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PRINT38=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print879); 
			PRINT38_tree = (CommonTree)adaptor.dupNode(PRINT38);


			root_1 = (CommonTree)adaptor.becomeRoot(PRINT38_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_print883);
			returnReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, returnReg.getTree());

			// ControlFlowGraph.g:256:57: ( ENDL )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ENDL) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// ControlFlowGraph.g:256:57: ENDL
					{
					_last = (CommonTree)input.LT(1);
					ENDL39=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print886); 
					ENDL39_tree = (CommonTree)adaptor.dupNode(ENDL39);


					adaptor.addChild(root_1, ENDL39_tree);

					}
					break;

			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         prevBlock.instructions.add(new PrintInst((returnReg!=null?((ControlFlowGraph.expression_return)returnReg).regNum:null)));
			         retval.retBlock = prevBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "print"


	public static class ret_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret"
	// ControlFlowGraph.g:263:1: ret[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ( ^( RETURN returnReg= expression[regTable, prevBlock] ) | RETURN );
	public final ControlFlowGraph.ret_return ret(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.ret_return retval = new ControlFlowGraph.ret_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree RETURN40=null;
		CommonTree RETURN41=null;
		TreeRuleReturnScope returnReg =null;

		CommonTree RETURN40_tree=null;
		CommonTree RETURN41_tree=null;

		try {
			// ControlFlowGraph.g:264:4: ( ^( RETURN returnReg= expression[regTable, prevBlock] ) | RETURN )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==RETURN) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==DOWN) ) {
					alt12=1;
				}
				else if ( (LA12_1==UP||(LA12_1 >= ASSIGN && LA12_1 <= BLOCK)||LA12_1==DELETE||LA12_1==IF||LA12_1==INVOKE||LA12_1==PRINT||LA12_1==READ||LA12_1==RETURN||LA12_1==WHILE) ) {
					alt12=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// ControlFlowGraph.g:264:7: ^( RETURN returnReg= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					RETURN40=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret919); 
					RETURN40_tree = (CommonTree)adaptor.dupNode(RETURN40);


					root_1 = (CommonTree)adaptor.becomeRoot(RETURN40_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_ret925);
					returnReg=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, returnReg.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ReturnInst((returnReg!=null?((ControlFlowGraph.expression_return)returnReg).regNum:null)));
					         retval.retBlock = prevBlock;
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:269:7: RETURN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RETURN41=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret943); 
					RETURN41_tree = (CommonTree)adaptor.dupNode(RETURN41);


					adaptor.addChild(root_0, RETURN41_tree);

					 retval.retBlock = prevBlock; 
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "ret"


	public static class arguments_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "arguments"
	// ControlFlowGraph.g:272:1: arguments[String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : retArgBlock= arg_list[callID, regTable, prevBlock] ;
	public final ControlFlowGraph.arguments_return arguments(String callID, RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.arguments_return retval = new ControlFlowGraph.arguments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope retArgBlock =null;


		try {
			// ControlFlowGraph.g:273:4: (retArgBlock= arg_list[callID, regTable, prevBlock] )
			// ControlFlowGraph.g:273:7: retArgBlock= arg_list[callID, regTable, prevBlock]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arg_list_in_arguments971);
			retArgBlock=arg_list(callID, regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_0, retArgBlock.getTree());


			         retval.retBlock = (retArgBlock!=null?((ControlFlowGraph.arg_list_return)retArgBlock).retBlock:null);
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arguments"


	public static class arg_list_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "arg_list"
	// ControlFlowGraph.g:279:1: arg_list[String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ( ^( ARGS (retArg= expression[regTable, prevBlock] )+ ) | ARGS );
	public final ControlFlowGraph.arg_list_return arg_list(String callID, RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.arg_list_return retval = new ControlFlowGraph.arg_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ARGS42=null;
		CommonTree ARGS43=null;
		TreeRuleReturnScope retArg =null;

		CommonTree ARGS42_tree=null;
		CommonTree ARGS43_tree=null;


		      int argCounter = 0;
		      Vector<Instruction> storeCache = new Vector<Instruction>();
		   
		try {
			// ControlFlowGraph.g:284:4: ( ^( ARGS (retArg= expression[regTable, prevBlock] )+ ) | ARGS )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==ARGS) ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1==DOWN) ) {
					alt14=1;
				}
				else if ( (LA14_1==UP) ) {
					alt14=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// ControlFlowGraph.g:284:7: ^( ARGS (retArg= expression[regTable, prevBlock] )+ )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					ARGS42=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list1011); 
					ARGS42_tree = (CommonTree)adaptor.dupNode(ARGS42);


					root_1 = (CommonTree)adaptor.becomeRoot(ARGS42_tree, root_1);

					match(input, Token.DOWN, null); 
					// ControlFlowGraph.g:284:14: (retArg= expression[regTable, prevBlock] )+
					int cnt13=0;
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==AND||(LA13_0 >= DIVIDE && LA13_0 <= DOT)||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= GE && LA13_0 <= ID)||(LA13_0 >= INTEGER && LA13_0 <= INVOKE)||LA13_0==LE||(LA13_0 >= LT && LA13_0 <= OR)||LA13_0==PLUS||(LA13_0 >= TIMES && LA13_0 <= TRUE)) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// ControlFlowGraph.g:284:15: retArg= expression[regTable, prevBlock]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expression_in_arg_list1016);
							retArg=expression(regTable, prevBlock);
							state._fsp--;

							adaptor.addChild(root_1, retArg.getTree());


							         storeCache.add(new StoreOutInst((retArg!=null?((ControlFlowGraph.expression_return)retArg).regNum:null), argCounter++));
							      
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							throw eee;
						}
						cnt13++;
					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         for(Instruction inst : storeCache) {
					            prevBlock.instructions.add(inst);
					         }
					         prevBlock.instructions.add(new CallInst("_" + callID, argCounter));
					         retval.retBlock = prevBlock;
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:295:7: ARGS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ARGS43=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list1044); 
					ARGS43_tree = (CommonTree)adaptor.dupNode(ARGS43);


					adaptor.addChild(root_0, ARGS43_tree);

					 retval.retBlock = prevBlock; 
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "arg_list"


	public static class conditional_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditional"
	// ControlFlowGraph.g:298:1: conditional[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? ) ;
	public final ControlFlowGraph.conditional_return conditional(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.conditional_return retval = new ControlFlowGraph.conditional_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IF44=null;
		TreeRuleReturnScope guardReg =null;
		TreeRuleReturnScope trueBlock =null;
		TreeRuleReturnScope falseBlock =null;

		CommonTree IF44_tree=null;


		      BasicBlock trueBlockIn = new BasicBlock(getLabel());
		      BasicBlock falseBlockIn = new BasicBlock(getLabel());
		      addBlockRel(prevBlock, trueBlockIn);
		   
		try {
			// ControlFlowGraph.g:304:4: ( ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? ) )
			// ControlFlowGraph.g:304:7: ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			IF44=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional1077); 
			IF44_tree = (CommonTree)adaptor.dupNode(IF44);


			root_1 = (CommonTree)adaptor.becomeRoot(IF44_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_conditional1081);
			guardReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, guardReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_conditional1086);
			trueBlock=block(regTable, trueBlockIn);
			state._fsp--;

			adaptor.addChild(root_1, trueBlock.getTree());

			// ControlFlowGraph.g:304:92: (falseBlock= block[regTable, falseBlockIn] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BLOCK) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// ControlFlowGraph.g:305:7: falseBlock= block[regTable, falseBlockIn]
					{

					         addBlockRel(prevBlock, falseBlockIn);
					         prevBlock.instructions.add(new CompImmInst((guardReg!=null?((ControlFlowGraph.expression_return)guardReg).regNum:null), 1));
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_conditional1107);
					falseBlock=block(regTable, falseBlockIn);
					state._fsp--;

					adaptor.addChild(root_1, falseBlock.getTree());

					}
					break;

			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         BasicBlock convergeBlock = new BasicBlock(getLabel());
			         addBlockRel((trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null), convergeBlock);
			         
			         if ((falseBlock!=null?((ControlFlowGraph.block_return)falseBlock).retBlock:null) != null) {
			            addBlockRel((falseBlock!=null?((ControlFlowGraph.block_return)falseBlock).retBlock:null), convergeBlock);
			            prevBlock.instructions.add(new CBRNEInst((falseBlock!=null?((ControlFlowGraph.block_return)falseBlock).retBlock:null).label, (trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null).label));
			            (falseBlock!=null?((ControlFlowGraph.block_return)falseBlock).retBlock:null).instructions.add(new BranchInst(convergeBlock.label));
			            (trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null).instructions.add(new BranchInst(convergeBlock.label));

			         } else {
			            addBlockRel(falseBlockIn, convergeBlock);
			            prevBlock.instructions.add(new CBRNEInst(falseBlockIn.label, (trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null).label));
			            (trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null).instructions.add(new BranchInst(convergeBlock.label));
			         }
			         retval.retBlock = convergeBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "conditional"


	public static class invocation_return extends TreeRuleReturnScope {
		public Integer regNum;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "invocation"
	// ControlFlowGraph.g:329:1: invocation[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] ) ;
	public final ControlFlowGraph.invocation_return invocation(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.invocation_return retval = new ControlFlowGraph.invocation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree funcId=null;
		CommonTree INVOKE45=null;
		TreeRuleReturnScope arguments46 =null;

		CommonTree funcId_tree=null;
		CommonTree INVOKE45_tree=null;

		try {
			// ControlFlowGraph.g:330:4: ( ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] ) )
			// ControlFlowGraph.g:330:7: ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			INVOKE45=(CommonTree)match(input,INVOKE,FOLLOW_INVOKE_in_invocation1142); 
			INVOKE45_tree = (CommonTree)adaptor.dupNode(INVOKE45);


			root_1 = (CommonTree)adaptor.becomeRoot(INVOKE45_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			funcId=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1146); 
			funcId_tree = (CommonTree)adaptor.dupNode(funcId);


			adaptor.addChild(root_1, funcId_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arguments_in_invocation1148);
			arguments46=arguments((funcId!=null?funcId.getText():null), regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, arguments46.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			      prevBlock.instructions.add(new LoadRetInst(regCounter));
			      retval.regNum = regCounter++;
			   
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "invocation"


	public static class loop_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "loop"
	// ControlFlowGraph.g:337:1: loop[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] ) ;
	public final ControlFlowGraph.loop_return loop(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.loop_return retval = new ControlFlowGraph.loop_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree WHILE47=null;
		TreeRuleReturnScope guardReg =null;
		TreeRuleReturnScope retBodyBlock =null;
		TreeRuleReturnScope guardReg2 =null;

		CommonTree WHILE47_tree=null;

		try {
			// ControlFlowGraph.g:338:4: ( ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] ) )
			// ControlFlowGraph.g:338:7: ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();



			         String trueLabel = getLabel();
			         BasicBlock bodyBlock = new BasicBlock(trueLabel); 
			      
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			WHILE47=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop1186); 
			WHILE47_tree = (CommonTree)adaptor.dupNode(WHILE47);


			root_1 = (CommonTree)adaptor.becomeRoot(WHILE47_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop1190);
			guardReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, guardReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_loop1195);
			retBodyBlock=block(regTable, bodyBlock);
			state._fsp--;

			adaptor.addChild(root_1, retBodyBlock.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop1200);
			guardReg2=expression(regTable, bodyBlock);
			state._fsp--;

			adaptor.addChild(root_1, guardReg2.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         String falseLabel = getLabel();
			         BasicBlock loopExitBlock = new BasicBlock(falseLabel);
			         addBlockRel(prevBlock, bodyBlock);
			         addBlockRel(bodyBlock, loopExitBlock);
			         prevBlock.instructions.add(new CompImmInst((guardReg!=null?((ControlFlowGraph.expression_return)guardReg).regNum:null), 1));
			         prevBlock.instructions.add(new CBRNEInst(falseLabel, trueLabel));
			         bodyBlock.instructions.add(new CompImmInst((guardReg2!=null?((ControlFlowGraph.expression_return)guardReg2).regNum:null), 1));
			         bodyBlock.instructions.add(new CBRNEInst(falseLabel, trueLabel));
			         retval.retBlock = loopExitBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "loop"


	public static class block_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// ControlFlowGraph.g:356:1: block[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] ) ;
	public final ControlFlowGraph.block_return block(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.block_return retval = new ControlFlowGraph.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BLOCK48=null;
		TreeRuleReturnScope returnSLBlock =null;

		CommonTree BLOCK48_tree=null;

		try {
			// ControlFlowGraph.g:357:4: ( ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] ) )
			// ControlFlowGraph.g:357:7: ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BLOCK48=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block1233); 
			BLOCK48_tree = (CommonTree)adaptor.dupNode(BLOCK48);


			root_1 = (CommonTree)adaptor.becomeRoot(BLOCK48_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_block1237);
			returnSLBlock=statement_list(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, returnSLBlock.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			          retval.retBlock = (returnSLBlock!=null?((ControlFlowGraph.statement_list_return)returnSLBlock).retBlock:null);
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "block"


	public static class assignment_return extends TreeRuleReturnScope {
		public BasicBlock retBlock;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// ControlFlowGraph.g:363:1: assignment[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] ) ;
	public final ControlFlowGraph.assignment_return assignment(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.assignment_return retval = new ControlFlowGraph.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASSIGN49=null;
		TreeRuleReturnScope retExpReg =null;
		TreeRuleReturnScope lvalue50 =null;

		CommonTree ASSIGN49_tree=null;

		try {
			// ControlFlowGraph.g:364:4: ( ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] ) )
			// ControlFlowGraph.g:364:7: ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ASSIGN49=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1270); 
			ASSIGN49_tree = (CommonTree)adaptor.dupNode(ASSIGN49);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSIGN49_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_assignment1274);
			retExpReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, retExpReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_assignment1277);
			lvalue50=lvalue(regTable, prevBlock, (retExpReg!=null?((ControlFlowGraph.expression_return)retExpReg).regNum:null));
			state._fsp--;

			adaptor.addChild(root_1, lvalue50.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         retval.retBlock = prevBlock;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class expression_return extends TreeRuleReturnScope {
		public Integer regNum = null;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// ControlFlowGraph.g:370:1: expression[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum = null] : (invRetReg= invocation[regTable, prevBlock] | ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NOT expression[regTable, prevBlock] ) | ^( DOT retReg= expression[regTable, prevBlock] calledId= ID ) |newId= ID |intVal= INTEGER | TRUE | FALSE | ^( NEW addrId= ID ) | ^( NEG returnReg= expression[regTable, prevBlock] ) | NULL );
	public final ControlFlowGraph.expression_return expression(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.expression_return retval = new ControlFlowGraph.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree calledId=null;
		CommonTree newId=null;
		CommonTree intVal=null;
		CommonTree addrId=null;
		CommonTree AND51=null;
		CommonTree OR52=null;
		CommonTree LE53=null;
		CommonTree EQ54=null;
		CommonTree LT55=null;
		CommonTree GT56=null;
		CommonTree NE57=null;
		CommonTree GE60=null;
		CommonTree PLUS63=null;
		CommonTree MINUS64=null;
		CommonTree TIMES65=null;
		CommonTree DIVIDE66=null;
		CommonTree NOT67=null;
		CommonTree DOT69=null;
		CommonTree TRUE70=null;
		CommonTree FALSE71=null;
		CommonTree NEW72=null;
		CommonTree NEG73=null;
		CommonTree NULL74=null;
		TreeRuleReturnScope invRetReg =null;
		TreeRuleReturnScope regNum1 =null;
		TreeRuleReturnScope regNum2 =null;
		TreeRuleReturnScope retReg =null;
		TreeRuleReturnScope returnReg =null;
		TreeRuleReturnScope expression58 =null;
		TreeRuleReturnScope expression59 =null;
		TreeRuleReturnScope expression61 =null;
		TreeRuleReturnScope expression62 =null;
		TreeRuleReturnScope expression68 =null;

		CommonTree calledId_tree=null;
		CommonTree newId_tree=null;
		CommonTree intVal_tree=null;
		CommonTree addrId_tree=null;
		CommonTree AND51_tree=null;
		CommonTree OR52_tree=null;
		CommonTree LE53_tree=null;
		CommonTree EQ54_tree=null;
		CommonTree LT55_tree=null;
		CommonTree GT56_tree=null;
		CommonTree NE57_tree=null;
		CommonTree GE60_tree=null;
		CommonTree PLUS63_tree=null;
		CommonTree MINUS64_tree=null;
		CommonTree TIMES65_tree=null;
		CommonTree DIVIDE66_tree=null;
		CommonTree NOT67_tree=null;
		CommonTree DOT69_tree=null;
		CommonTree TRUE70_tree=null;
		CommonTree FALSE71_tree=null;
		CommonTree NEW72_tree=null;
		CommonTree NEG73_tree=null;
		CommonTree NULL74_tree=null;

		try {
			// ControlFlowGraph.g:371:4: (invRetReg= invocation[regTable, prevBlock] | ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NOT expression[regTable, prevBlock] ) | ^( DOT retReg= expression[regTable, prevBlock] calledId= ID ) |newId= ID |intVal= INTEGER | TRUE | FALSE | ^( NEW addrId= ID ) | ^( NEG returnReg= expression[regTable, prevBlock] ) | NULL )
			int alt16=22;
			switch ( input.LA(1) ) {
			case INVOKE:
				{
				alt16=1;
				}
				break;
			case AND:
				{
				alt16=2;
				}
				break;
			case OR:
				{
				alt16=3;
				}
				break;
			case LE:
				{
				alt16=4;
				}
				break;
			case EQ:
				{
				alt16=5;
				}
				break;
			case LT:
				{
				alt16=6;
				}
				break;
			case GT:
				{
				alt16=7;
				}
				break;
			case NE:
				{
				alt16=8;
				}
				break;
			case GE:
				{
				alt16=9;
				}
				break;
			case PLUS:
				{
				alt16=10;
				}
				break;
			case MINUS:
				{
				alt16=11;
				}
				break;
			case TIMES:
				{
				alt16=12;
				}
				break;
			case DIVIDE:
				{
				alt16=13;
				}
				break;
			case NOT:
				{
				alt16=14;
				}
				break;
			case DOT:
				{
				alt16=15;
				}
				break;
			case ID:
				{
				alt16=16;
				}
				break;
			case INTEGER:
				{
				alt16=17;
				}
				break;
			case TRUE:
				{
				alt16=18;
				}
				break;
			case FALSE:
				{
				alt16=19;
				}
				break;
			case NEW:
				{
				alt16=20;
				}
				break;
			case NEG:
				{
				alt16=21;
				}
				break;
			case NULL:
				{
				alt16=22;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// ControlFlowGraph.g:371:7: invRetReg= invocation[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_expression1311);
					invRetReg=invocation(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, invRetReg.getTree());


					         retval.regNum = (invRetReg!=null?((ControlFlowGraph.invocation_return)invRetReg).regNum:null);
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:375:7: ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					AND51=(CommonTree)match(input,AND,FOLLOW_AND_in_expression1329); 
					AND51_tree = (CommonTree)adaptor.dupNode(AND51);


					root_1 = (CommonTree)adaptor.becomeRoot(AND51_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1333);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1338);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new AndInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 3 :
					// ControlFlowGraph.g:380:7: ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					OR52=(CommonTree)match(input,OR,FOLLOW_OR_in_expression1357); 
					OR52_tree = (CommonTree)adaptor.dupNode(OR52);


					root_1 = (CommonTree)adaptor.becomeRoot(OR52_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1361);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1366);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new OrInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 4 :
					// ControlFlowGraph.g:385:7: ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					LE53=(CommonTree)match(input,LE,FOLLOW_LE_in_expression1385); 
					LE53_tree = (CommonTree)adaptor.dupNode(LE53);


					root_1 = (CommonTree)adaptor.becomeRoot(LE53_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1389);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1394);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveLEInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 5 :
					// ControlFlowGraph.g:393:7: ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					EQ54=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expression1413); 
					EQ54_tree = (CommonTree)adaptor.dupNode(EQ54);


					root_1 = (CommonTree)adaptor.becomeRoot(EQ54_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1417);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1422);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveEQInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 6 :
					// ControlFlowGraph.g:401:7: ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					LT55=(CommonTree)match(input,LT,FOLLOW_LT_in_expression1441); 
					LT55_tree = (CommonTree)adaptor.dupNode(LT55);


					root_1 = (CommonTree)adaptor.becomeRoot(LT55_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1445);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1450);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveLTInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 7 :
					// ControlFlowGraph.g:409:7: ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					GT56=(CommonTree)match(input,GT,FOLLOW_GT_in_expression1469); 
					GT56_tree = (CommonTree)adaptor.dupNode(GT56);


					root_1 = (CommonTree)adaptor.becomeRoot(GT56_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1473);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1478);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveGTInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 8 :
					// ControlFlowGraph.g:417:7: ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NE57=(CommonTree)match(input,NE,FOLLOW_NE_in_expression1497); 
					NE57_tree = (CommonTree)adaptor.dupNode(NE57);


					root_1 = (CommonTree)adaptor.becomeRoot(NE57_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1499);
					expression58=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression58.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1502);
					expression59=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression59.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveNEInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 9 :
					// ControlFlowGraph.g:425:7: ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					GE60=(CommonTree)match(input,GE,FOLLOW_GE_in_expression1521); 
					GE60_tree = (CommonTree)adaptor.dupNode(GE60);


					root_1 = (CommonTree)adaptor.becomeRoot(GE60_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1523);
					expression61=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression61.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1526);
					expression62=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression62.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         prevBlock.instructions.add(new MoveGEInst(regCounter++, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 10 :
					// ControlFlowGraph.g:433:7: ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					PLUS63=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expression1545); 
					PLUS63_tree = (CommonTree)adaptor.dupNode(PLUS63);


					root_1 = (CommonTree)adaptor.becomeRoot(PLUS63_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1549);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1554);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					      prevBlock.instructions.add(new AddInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					      retval.regNum = regCounter++;
					   
					}
					break;
				case 11 :
					// ControlFlowGraph.g:438:7: ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					MINUS64=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression1570); 
					MINUS64_tree = (CommonTree)adaptor.dupNode(MINUS64);


					root_1 = (CommonTree)adaptor.becomeRoot(MINUS64_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1574);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1579);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new SubtractInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 12 :
					// ControlFlowGraph.g:443:7: ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					TIMES65=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expression1598); 
					TIMES65_tree = (CommonTree)adaptor.dupNode(TIMES65);


					root_1 = (CommonTree)adaptor.becomeRoot(TIMES65_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1602);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1607);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new MultiplyInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 13 :
					// ControlFlowGraph.g:448:7: ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DIVIDE66=(CommonTree)match(input,DIVIDE,FOLLOW_DIVIDE_in_expression1626); 
					DIVIDE66_tree = (CommonTree)adaptor.dupNode(DIVIDE66);


					root_1 = (CommonTree)adaptor.becomeRoot(DIVIDE66_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1630);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1635);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new DivideInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 14 :
					// ControlFlowGraph.g:453:7: ^( NOT expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT67=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1654); 
					NOT67_tree = (CommonTree)adaptor.dupNode(NOT67);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT67_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1656);
					expression68=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression68.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 15 :
					// ControlFlowGraph.g:454:7: ^( DOT retReg= expression[regTable, prevBlock] calledId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT69=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1667); 
					DOT69_tree = (CommonTree)adaptor.dupNode(DOT69);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT69_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1671);
					retReg=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					calledId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1676); 
					calledId_tree = (CommonTree)adaptor.dupNode(calledId);


					adaptor.addChild(root_1, calledId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					 
					         LoadAIInst inst = new LoadAIInst((retReg!=null?((ControlFlowGraph.expression_return)retReg).regNum:null), (calledId!=null?calledId.getText():null), regCounter);
					         inst.offset = curStruct.memberCounts.get((calledId!=null?calledId.getText():null));
					         if(curStruct.get((calledId!=null?calledId.getText():null)) instanceof StructType) {
					            curStruct = (StructType)curStruct.get((calledId!=null?calledId.getText():null));
					         }
					         prevBlock.instructions.add(inst);
					         retval.regNum = new Integer(regCounter++);
					      
					}
					break;
				case 16 :
					// ControlFlowGraph.g:464:7: newId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1697); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_0, newId_tree);


					         Integer varReg = regTable.get((newId!=null?newId.getText():null));
					         if (varReg == null) {
					            ComputeGlobalAddrInst globInst = new ComputeGlobalAddrInst((newId!=null?newId.getText():null), regCounter);
					            globInst.type = globals.get((newId!=null?newId.getText():null));
					            if(globInst.type instanceof StructType) {
					               curStruct = (StructType)globInst.type;
					            }
					            prevBlock.instructions.add(globInst);
					            retval.regNum = new Integer(regCounter++);
					         } else {
					             prevBlock.instructions.add(new MoveInst(varReg, regCounter));
					             retval.regNum = new Integer(regCounter++);
					         }
					      
					}
					break;
				case 17 :
					// ControlFlowGraph.g:480:7: intVal= INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					intVal=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression1715); 
					intVal_tree = (CommonTree)adaptor.dupNode(intVal);


					adaptor.addChild(root_0, intVal_tree);


					         prevBlock.instructions.add(new ImmInst(Integer.valueOf((intVal!=null?intVal.getText():null)), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 18 :
					// ControlFlowGraph.g:485:7: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE70=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_expression1731); 
					TRUE70_tree = (CommonTree)adaptor.dupNode(TRUE70);


					adaptor.addChild(root_0, TRUE70_tree);


					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 19 :
					// ControlFlowGraph.g:490:7: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE71=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_expression1748); 
					FALSE71_tree = (CommonTree)adaptor.dupNode(FALSE71);


					adaptor.addChild(root_0, FALSE71_tree);


					         prevBlock.instructions.add(new ImmInst(0, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 20 :
					// ControlFlowGraph.g:495:7: ^( NEW addrId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEW72=(CommonTree)match(input,NEW,FOLLOW_NEW_in_expression1765); 
					NEW72_tree = (CommonTree)adaptor.dupNode(NEW72);


					root_1 = (CommonTree)adaptor.becomeRoot(NEW72_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					addrId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1769); 
					addrId_tree = (CommonTree)adaptor.dupNode(addrId);


					adaptor.addChild(root_1, addrId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         NewInst newInst = new NewInst((addrId!=null?addrId.getText():null), regCounter);
					         newInst.assReg = regCounter;
					         StructType newStruct = (StructType)stypes.get((addrId!=null?addrId.getText():null));
					         newInst.size = newStruct.memberCount * 8;
					         prevBlock.instructions.add(newInst);
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 21 :
					// ControlFlowGraph.g:504:7: ^( NEG returnReg= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEG73=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expression1787); 
					NEG73_tree = (CommonTree)adaptor.dupNode(NEG73);


					root_1 = (CommonTree)adaptor.becomeRoot(NEG73_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1791);
					returnReg=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, returnReg.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(-1, regCounter));
					         prevBlock.instructions.add(new MultiplyInst(regCounter++, (returnReg!=null?((ControlFlowGraph.expression_return)returnReg).regNum:null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 22 :
					// ControlFlowGraph.g:510:7: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL74=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression1810); 
					NULL74_tree = (CommonTree)adaptor.dupNode(NULL74);


					adaptor.addChild(root_0, NULL74_tree);


					         prevBlock.instructions.add(new ImmInst(0, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class lvalue_return extends TreeRuleReturnScope {
		public Integer regNum;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// ControlFlowGraph.g:517:1: lvalue[RegisterTable regTable, BasicBlock prevBlock, Integer assReg] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalue_return lvalue(RegisterTable regTable, BasicBlock prevBlock, Integer assReg) throws RecognitionException {
		ControlFlowGraph.lvalue_return retval = new ControlFlowGraph.lvalue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree retId=null;
		CommonTree newId=null;
		CommonTree DOT75=null;
		TreeRuleReturnScope retReg =null;

		CommonTree retId_tree=null;
		CommonTree newId_tree=null;
		CommonTree DOT75_tree=null;

		try {
			// ControlFlowGraph.g:518:4: (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) )
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==ID) ) {
				alt17=1;
			}
			else if ( (LA17_0==DOT) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
				case 1 :
					// ControlFlowGraph.g:518:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1845); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         prevBlock.instructions.add(new MoveInst(assReg, regTable.get((retId!=null?retId.getText():null))));
					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:523:7: ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT75=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalue1862); 
					DOT75_tree = (CommonTree)adaptor.dupNode(DOT75);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT75_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueLoad_in_lvalue1866);
					retReg=lvalueLoad(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1871); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_1, newId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         StoreImmInst inst = new StoreImmInst(assReg, (retReg!=null?((ControlFlowGraph.lvalueLoad_return)retReg).regNum:null), (newId!=null?newId.getText():null));
					         inst.offset = curStruct.memberCounts.get((newId!=null?newId.getText():null));
					         prevBlock.instructions.add(inst);
					      
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lvalue"


	public static class lvalueRead_return extends TreeRuleReturnScope {
		public Integer regNum;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lvalueRead"
	// ControlFlowGraph.g:531:1: lvalueRead[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalueRead_return lvalueRead(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.lvalueRead_return retval = new ControlFlowGraph.lvalueRead_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree retId=null;
		CommonTree newId=null;
		CommonTree DOT76=null;
		TreeRuleReturnScope retReg =null;

		CommonTree retId_tree=null;
		CommonTree newId_tree=null;
		CommonTree DOT76_tree=null;

		try {
			// ControlFlowGraph.g:532:4: (retId= ID | ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==ID) ) {
				alt18=1;
			}
			else if ( (LA18_0==DOT) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// ControlFlowGraph.g:532:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueRead1904); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:536:7: ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT76=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalueRead1921); 
					DOT76_tree = (CommonTree)adaptor.dupNode(DOT76);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT76_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueRead_in_lvalueRead1925);
					retReg=lvalueRead(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueRead1930); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_1, newId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new LoadAIInst((retReg!=null?((ControlFlowGraph.lvalueRead_return)retReg).regNum:null), (newId!=null?newId.getText():null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lvalueRead"


	public static class lvalueLoad_return extends TreeRuleReturnScope {
		public Integer regNum;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lvalueLoad"
	// ControlFlowGraph.g:543:1: lvalueLoad[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalueLoad_return lvalueLoad(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.lvalueLoad_return retval = new ControlFlowGraph.lvalueLoad_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree retId=null;
		CommonTree newId=null;
		CommonTree DOT77=null;
		TreeRuleReturnScope retReg =null;

		CommonTree retId_tree=null;
		CommonTree newId_tree=null;
		CommonTree DOT77_tree=null;

		try {
			// ControlFlowGraph.g:544:4: (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==ID) ) {
				alt19=1;
			}
			else if ( (LA19_0==DOT) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// ControlFlowGraph.g:544:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueLoad1963); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					         if (retval.regNum == null) {
					            LoadGlobalInst inst = new LoadGlobalInst((retId!=null?retId.getText():null), regCounter);
					            curStruct = (StructType)globals.get((retId!=null?retId.getText():null));
					            prevBlock.instructions.add(inst);
					            retval.regNum = regCounter++;
					         }
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:554:7: ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT77=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalueLoad1980); 
					DOT77_tree = (CommonTree)adaptor.dupNode(DOT77);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT77_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueLoad_in_lvalueLoad1984);
					retReg=lvalueLoad(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueLoad1989); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_1, newId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         LoadAIInst inst = new LoadAIInst((retReg!=null?((ControlFlowGraph.lvalueLoad_return)retReg).regNum:null), (newId!=null?newId.getText():null), regCounter);
					         inst.offset = curStruct.memberCounts.get((newId!=null?newId.getText():null));
					         curStruct = (StructType)curStruct.get((newId!=null?newId.getText():null));
					         prevBlock.instructions.add(inst);
					         retval.regNum = regCounter++;
					      
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lvalueLoad"


	public static class rettype_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rettype"
	// ControlFlowGraph.g:564:1: rettype : ( type | VOID );
	public final ControlFlowGraph.rettype_return rettype() throws RecognitionException {
		ControlFlowGraph.rettype_return retval = new ControlFlowGraph.rettype_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree VOID79=null;
		TreeRuleReturnScope type78 =null;

		CommonTree VOID79_tree=null;

		try {
			// ControlFlowGraph.g:565:4: ( type | VOID )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==BOOL||LA20_0==INT||LA20_0==STRUCT) ) {
				alt20=1;
			}
			else if ( (LA20_0==VOID) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// ControlFlowGraph.g:565:7: type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_rettype2015);
					type78=type();
					state._fsp--;

					adaptor.addChild(root_0, type78.getTree());

					}
					break;
				case 2 :
					// ControlFlowGraph.g:566:7: VOID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					VOID79=(CommonTree)match(input,VOID,FOLLOW_VOID_in_rettype2023); 
					VOID79_tree = (CommonTree)adaptor.dupNode(VOID79);


					adaptor.addChild(root_0, VOID79_tree);

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rettype"


	public static class params_return extends TreeRuleReturnScope {
		public int numParams;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "params"
	// ControlFlowGraph.g:569:1: params[RegisterTable regTable, BasicBlock prevBlock] returns [int numParams] : ^( PARAMS (declRetID= decl )* ) ;
	public final ControlFlowGraph.params_return params(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.params_return retval = new ControlFlowGraph.params_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARAMS80=null;
		TreeRuleReturnScope declRetID =null;

		CommonTree PARAMS80_tree=null;


		      int paramNum = 0;
		   
		try {
			// ControlFlowGraph.g:573:4: ( ^( PARAMS (declRetID= decl )* ) )
			// ControlFlowGraph.g:573:7: ^( PARAMS (declRetID= decl )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARAMS80=(CommonTree)match(input,PARAMS,FOLLOW_PARAMS_in_params2054); 
			PARAMS80_tree = (CommonTree)adaptor.dupNode(PARAMS80);


			root_1 = (CommonTree)adaptor.becomeRoot(PARAMS80_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:573:16: (declRetID= decl )*
				loop21:
				while (true) {
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==DECL) ) {
						alt21=1;
					}

					switch (alt21) {
					case 1 :
						// ControlFlowGraph.g:573:17: declRetID= decl
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_params2059);
						declRetID=decl();
						state._fsp--;

						adaptor.addChild(root_1, declRetID.getTree());


						         regTable.put((declRetID!=null?((ControlFlowGraph.decl_return)declRetID).id:null), regCounter);
						         prevBlock.instructions.add(new LoadInArgumentInst((declRetID!=null?((ControlFlowGraph.decl_return)declRetID).id:null), paramNum++, regCounter++));
						      
						}
						break;

					default :
						break loop21;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			         retval.numParams = paramNum;
			      
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "params"

	// Delegated rules



	public static final BitSet FOLLOW_program_in_generate71 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_generate73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_functions_in_program109 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types136 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_types_sub_in_types138 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_decl_in_types_sub164 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_types_sub_in_types_sub166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type_decl190 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type_decl195 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_nested_decl_in_type_decl197 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_in_nested_decl218 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_DECL_in_decl243 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decl246 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decl248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_decl253 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLS_in_declarations285 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_declarations287 = new BitSet(new long[]{0x0000000000001008L});
	public static final BitSet FOLLOW_decllist_in_declaration309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type345 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type347 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist367 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decllist370 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decllist372 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_id_list_in_decllist375 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_id_list398 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_FUNCS_in_functions428 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_function_in_functions433 = new BitSet(new long[]{0x0000000000200008L});
	public static final BitSet FOLLOW_FUN_in_function480 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function484 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_params_in_function499 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RETTYPE_in_function512 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rettype_in_function514 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_declarations_in_function517 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_statement_list_in_function522 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STMTS_in_statement_list555 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_statement_list560 = new BitSet(new long[]{0x04014800240040C8L});
	public static final BitSet FOLLOW_block_in_statement616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_loop_in_statement681 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_invocation_in_statement698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_in_statement717 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_in_statement736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_statement755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_statement774 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read806 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueRead_in_read810 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DELETE_in_delete842 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_delete846 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_print879 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_print883 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_ENDL_in_print886 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret919 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ret925 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_list_in_arguments971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARGS_in_arg_list1011 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_arg_list1016 = new BitSet(new long[]{0x006005FEB3998018L});
	public static final BitSet FOLLOW_ARGS_in_arg_list1044 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional1077 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_conditional1081 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_conditional1086 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_block_in_conditional1107 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INVOKE_in_invocation1142 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_invocation1146 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_arguments_in_invocation1148 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_loop1186 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_loop1190 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_loop1195 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_loop1200 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1233 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_list_in_block1237 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment1270 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_assignment1274 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_lvalue_in_assignment1277 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_invocation_in_expression1311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_expression1329 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1333 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1338 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression1357 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1361 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1366 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LE_in_expression1385 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1389 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1394 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression1413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1417 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1422 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression1441 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1445 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1450 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression1469 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1473 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1478 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NE_in_expression1497 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1499 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1502 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GE_in_expression1521 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1523 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1526 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression1545 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1549 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1554 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1570 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1574 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1579 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TIMES_in_expression1598 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1602 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1607 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIVIDE_in_expression1626 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1630 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1635 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expression1654 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1656 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_expression1667 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1671 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_expression1676 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expression1697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_expression1715 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expression1731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expression1748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_expression1765 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expression1769 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEG_in_expression1787 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1791 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_expression1810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lvalue1845 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalue1862 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueLoad_in_lvalue1866 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalue1871 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_lvalueRead1904 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalueRead1921 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueRead_in_lvalueRead1925 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalueRead1930 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_lvalueLoad1963 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalueLoad1980 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueLoad_in_lvalueLoad1984 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalueLoad1989 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_type_in_rettype2015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_rettype2023 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAMS_in_params2054 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_params2059 = new BitSet(new long[]{0x0000000000000808L});
}
