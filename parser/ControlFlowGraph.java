// $ANTLR 3.5.2 ControlFlowGraph.g 2014-04-25 10:27:37

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


	public static class generate_return extends TreeRuleReturnScope {
		public Vector<BasicBlock> cfGraph;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "generate"
	// ControlFlowGraph.g:75:1: generate[Vector<SymbolTable> symTableIn, StructTypes stypesIn] returns [Vector<BasicBlock> cfGraph] : ( program EOF |);
	public final ControlFlowGraph.generate_return generate(Vector<SymbolTable> symTableIn, StructTypes stypesIn) throws RecognitionException {
		ControlFlowGraph.generate_return retval = new ControlFlowGraph.generate_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree EOF2=null;
		TreeRuleReturnScope program1 =null;

		CommonTree EOF2_tree=null;


		      env = symTableIn;
		      stypes = stypesIn;
		   
		try {
			// ControlFlowGraph.g:80:4: ( program EOF |)
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
					// ControlFlowGraph.g:80:7: program EOF
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
					// ControlFlowGraph.g:84:7: 
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
	// ControlFlowGraph.g:87:1: program : ^( PROGRAM . . functions ) ;
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
			// ControlFlowGraph.g:88:4: ( ^( PROGRAM . . functions ) )
			// ControlFlowGraph.g:88:7: ^( PROGRAM . . functions )
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


			  
			         System.out.println("---------Successfully Created Control Flow Graph!---------");
			      
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
	// ControlFlowGraph.g:94:1: types : ( ^( TYPES types_sub ) | TYPES );
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
			// ControlFlowGraph.g:95:4: ( ^( TYPES types_sub ) | TYPES )
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
					// ControlFlowGraph.g:95:8: ^( TYPES types_sub )
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
					// ControlFlowGraph.g:96:8: TYPES
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
	// ControlFlowGraph.g:99:1: types_sub : ( type_decl types_sub |);
	public final ControlFlowGraph.types_sub_return types_sub() throws RecognitionException {
		ControlFlowGraph.types_sub_return retval = new ControlFlowGraph.types_sub_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope type_decl10 =null;
		TreeRuleReturnScope types_sub11 =null;


		try {
			// ControlFlowGraph.g:100:4: ( type_decl types_sub |)
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
					// ControlFlowGraph.g:100:7: type_decl types_sub
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
					// ControlFlowGraph.g:102:4: 
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
	// ControlFlowGraph.g:104:1: type_decl : ^( STRUCT ^id= ID nested_decl ) ;
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
			// ControlFlowGraph.g:105:4: ( ^( STRUCT ^id= ID nested_decl ) )
			// ControlFlowGraph.g:105:7: ^( STRUCT ^id= ID nested_decl )
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
	// ControlFlowGraph.g:108:1: nested_decl : ( decl )+ ;
	public final ControlFlowGraph.nested_decl_return nested_decl() throws RecognitionException {
		ControlFlowGraph.nested_decl_return retval = new ControlFlowGraph.nested_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decl14 =null;


		try {
			// ControlFlowGraph.g:109:4: ( ( decl )+ )
			// ControlFlowGraph.g:109:7: ( decl )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ControlFlowGraph.g:109:7: ( decl )+
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
					// ControlFlowGraph.g:109:7: decl
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
	// ControlFlowGraph.g:112:1: decl returns [String id] : ^( DECL ^( TYPE type ) myId= ID ) ;
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
			// ControlFlowGraph.g:113:4: ( ^( DECL ^( TYPE type ) myId= ID ) )
			// ControlFlowGraph.g:113:7: ^( DECL ^( TYPE type ) myId= ID )
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
	// ControlFlowGraph.g:119:1: declarations[RegisterTable regTable] : ^( DECLS ( declaration[regTable] )* ) ;
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
			// ControlFlowGraph.g:120:4: ( ^( DECLS ( declaration[regTable] )* ) )
			// ControlFlowGraph.g:120:7: ^( DECLS ( declaration[regTable] )* )
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
				// ControlFlowGraph.g:120:15: ( declaration[regTable] )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==DECLLIST) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// ControlFlowGraph.g:120:15: declaration[regTable]
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
	// ControlFlowGraph.g:123:1: declaration[RegisterTable regTable] : decllist[regTable] ;
	public final ControlFlowGraph.declaration_return declaration(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.declaration_return retval = new ControlFlowGraph.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decllist20 =null;


		try {
			// ControlFlowGraph.g:124:4: ( decllist[regTable] )
			// ControlFlowGraph.g:124:7: decllist[regTable]
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
	// ControlFlowGraph.g:127:1: type : ( INT | BOOL | ^( STRUCT ID ) );
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
			// ControlFlowGraph.g:128:4: ( INT | BOOL | ^( STRUCT ID ) )
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
					// ControlFlowGraph.g:128:7: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT21=(CommonTree)match(input,INT,FOLLOW_INT_in_type327); 
					INT21_tree = (CommonTree)adaptor.dupNode(INT21);


					adaptor.addChild(root_0, INT21_tree);

					}
					break;
				case 2 :
					// ControlFlowGraph.g:129:7: BOOL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOL22=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_type335); 
					BOOL22_tree = (CommonTree)adaptor.dupNode(BOOL22);


					adaptor.addChild(root_0, BOOL22_tree);

					}
					break;
				case 3 :
					// ControlFlowGraph.g:130:7: ^( STRUCT ID )
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
	// ControlFlowGraph.g:133:1: decllist[RegisterTable regTable] : ^( DECLLIST ^( TYPE type ) id_list[regTable] ) ;
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
			// ControlFlowGraph.g:134:4: ( ^( DECLLIST ^( TYPE type ) id_list[regTable] ) )
			// ControlFlowGraph.g:134:7: ^( DECLLIST ^( TYPE type ) id_list[regTable] )
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
	// ControlFlowGraph.g:137:1: id_list[RegisterTable regTable] : (decId= ID )+ ;
	public final ControlFlowGraph.id_list_return id_list(RegisterTable regTable) throws RecognitionException {
		ControlFlowGraph.id_list_return retval = new ControlFlowGraph.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree decId=null;

		CommonTree decId_tree=null;

		try {
			// ControlFlowGraph.g:138:4: ( (decId= ID )+ )
			// ControlFlowGraph.g:138:7: (decId= ID )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ControlFlowGraph.g:138:7: (decId= ID )+
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
					// ControlFlowGraph.g:138:8: decId= ID
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
	// ControlFlowGraph.g:144:1: functions : ^( FUNCS (retFunBlock= function )* ) ;
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
			// ControlFlowGraph.g:145:4: ( ^( FUNCS (retFunBlock= function )* ) )
			// ControlFlowGraph.g:145:7: ^( FUNCS (retFunBlock= function )* )
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
				// ControlFlowGraph.g:145:15: (retFunBlock= function )*
				loop8:
				while (true) {
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==FUN) ) {
						alt8=1;
					}

					switch (alt8) {
					case 1 :
						// ControlFlowGraph.g:145:16: retFunBlock= function
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
	// ControlFlowGraph.g:151:1: function returns [BasicBlock retBlock] : ^( FUN funID= ID params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] ) ;
	public final ControlFlowGraph.function_return function() throws RecognitionException {
		ControlFlowGraph.function_return retval = new ControlFlowGraph.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree funID=null;
		CommonTree FUN30=null;
		CommonTree RETTYPE32=null;
		TreeRuleReturnScope retSLBlock =null;
		TreeRuleReturnScope params31 =null;
		TreeRuleReturnScope rettype33 =null;
		TreeRuleReturnScope declarations34 =null;

		CommonTree funID_tree=null;
		CommonTree FUN30_tree=null;
		CommonTree RETTYPE32_tree=null;


		      regCounter = 0;
		      BasicBlock newFunBlk = new BasicBlock("tempLabel");
		   
		try {
			// ControlFlowGraph.g:156:4: ( ^( FUN funID= ID params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] ) )
			// ControlFlowGraph.g:156:7: ^( FUN funID= ID params[regTable, newFunBlk] ^( RETTYPE rettype ) declarations[regTable] retSLBlock= statement_list[regTable, newFunBlk] )
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

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_params_in_function486);
			params31=params(regTable, newFunBlk);
			state._fsp--;

			adaptor.addChild(root_1, params31.getTree());

			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			RETTYPE32=(CommonTree)match(input,RETTYPE,FOLLOW_RETTYPE_in_function490); 
			RETTYPE32_tree = (CommonTree)adaptor.dupNode(RETTYPE32);


			root_2 = (CommonTree)adaptor.becomeRoot(RETTYPE32_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rettype_in_function492);
			rettype33=rettype();
			state._fsp--;

			adaptor.addChild(root_2, rettype33.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_function495);
			declarations34=declarations(regTable);
			state._fsp--;

			adaptor.addChild(root_1, declarations34.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_function500);
			retSLBlock=statement_list(regTable, newFunBlk);
			state._fsp--;

			adaptor.addChild(root_1, retSLBlock.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			          newFunBlk.label = (funID!=null?funID.getText():null);
			          BasicBlock funExitBlk = new BasicBlock(getLabel());
			          funExitBlk.instructions.add(new RetInst());
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
	// ControlFlowGraph.g:169:1: statement_list[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* ) ;
	public final ControlFlowGraph.statement_list_return statement_list(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.statement_list_return retval = new ControlFlowGraph.statement_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STMTS35=null;
		TreeRuleReturnScope retStmtBlock =null;

		CommonTree STMTS35_tree=null;

		try {
			// ControlFlowGraph.g:170:4: ( ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* ) )
			// ControlFlowGraph.g:170:7: ^( STMTS (retStmtBlock= statement[regTable, prevBlock] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STMTS35=(CommonTree)match(input,STMTS,FOLLOW_STMTS_in_statement_list533); 
			STMTS35_tree = (CommonTree)adaptor.dupNode(STMTS35);


			root_1 = (CommonTree)adaptor.becomeRoot(STMTS35_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:170:15: (retStmtBlock= statement[regTable, prevBlock] )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= ASSIGN && LA9_0 <= BLOCK)||LA9_0==DELETE||LA9_0==IF||LA9_0==INVOKE||LA9_0==PRINT||LA9_0==READ||LA9_0==RETURN||LA9_0==WHILE) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// ControlFlowGraph.g:170:16: retStmtBlock= statement[regTable, prevBlock]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_statement_list538);
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
	// ControlFlowGraph.g:184:1: statement[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : (blockReturnBlock= block[regTable, blockBlock] |retAssBlock= assignment[regTable, prevBlock] |retCondBlock= conditional[regTable, condBlock] |retLoopBlock= loop[regTable, prevBlock] | invocation[regTable, prevBlock] |retReturnBlock= ret[regTable, prevBlock] |retReadBlock= read[regTable, prevBlock] |retPrintBlock= print[regTable, prevBlock] |retDeleteBlock= delete[regTable, prevBlock] );
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
		TreeRuleReturnScope invocation36 =null;


		try {
			// ControlFlowGraph.g:185:4: (blockReturnBlock= block[regTable, blockBlock] |retAssBlock= assignment[regTable, prevBlock] |retCondBlock= conditional[regTable, condBlock] |retLoopBlock= loop[regTable, prevBlock] | invocation[regTable, prevBlock] |retReturnBlock= ret[regTable, prevBlock] |retReadBlock= read[regTable, prevBlock] |retPrintBlock= print[regTable, prevBlock] |retDeleteBlock= delete[regTable, prevBlock] )
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
					// ControlFlowGraph.g:185:7: blockReturnBlock= block[regTable, blockBlock]
					{
					root_0 = (CommonTree)adaptor.nil();



					         BasicBlock blockBlock = new BasicBlock(getLabel());
					         addBlockRel(prevBlock, blockBlock);
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_statement594);
					blockReturnBlock=block(regTable, blockBlock);
					state._fsp--;

					adaptor.addChild(root_0, blockReturnBlock.getTree());


					         retval.retBlock = (blockReturnBlock!=null?((ControlFlowGraph.block_return)blockReturnBlock).retBlock:null);
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:193:7: retAssBlock= assignment[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assignment_in_statement613);
					retAssBlock=assignment(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retAssBlock.getTree());


					         retval.retBlock = (retAssBlock!=null?((ControlFlowGraph.assignment_return)retAssBlock).retBlock:null);
					      
					}
					break;
				case 3 :
					// ControlFlowGraph.g:197:7: retCondBlock= conditional[regTable, condBlock]
					{
					root_0 = (CommonTree)adaptor.nil();



					         BasicBlock condBlock = new BasicBlock(getLabel());
					         addBlockRel(prevBlock, condBlock);
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_conditional_in_statement640);
					retCondBlock=conditional(regTable, condBlock);
					state._fsp--;

					adaptor.addChild(root_0, retCondBlock.getTree());


					         retval.retBlock = (retCondBlock!=null?((ControlFlowGraph.conditional_return)retCondBlock).retBlock:null);
					      
					}
					break;
				case 4 :
					// ControlFlowGraph.g:205:7: retLoopBlock= loop[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_loop_in_statement659);
					retLoopBlock=loop(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retLoopBlock.getTree());


					         retval.retBlock = (retLoopBlock!=null?((ControlFlowGraph.loop_return)retLoopBlock).retBlock:null);
					      
					}
					break;
				case 5 :
					// ControlFlowGraph.g:209:7: invocation[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_statement676);
					invocation36=invocation(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, invocation36.getTree());


					         retval.retBlock = prevBlock;
					      
					}
					break;
				case 6 :
					// ControlFlowGraph.g:213:7: retReturnBlock= ret[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_ret_in_statement695);
					retReturnBlock=ret(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retReturnBlock.getTree());


					         retval.retBlock = (retReturnBlock!=null?((ControlFlowGraph.ret_return)retReturnBlock).retBlock:null);
					      
					}
					break;
				case 7 :
					// ControlFlowGraph.g:217:7: retReadBlock= read[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_read_in_statement714);
					retReadBlock=read(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retReadBlock.getTree());


					         retval.retBlock = (retReadBlock!=null?((ControlFlowGraph.read_return)retReadBlock).retBlock:null);
					      
					}
					break;
				case 8 :
					// ControlFlowGraph.g:221:7: retPrintBlock= print[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_print_in_statement733);
					retPrintBlock=print(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, retPrintBlock.getTree());


					         retval.retBlock = (retPrintBlock!=null?((ControlFlowGraph.print_return)retPrintBlock).retBlock:null);
					      
					}
					break;
				case 9 :
					// ControlFlowGraph.g:225:7: retDeleteBlock= delete[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_delete_in_statement752);
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
	// ControlFlowGraph.g:231:1: read[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( READ retReg= lvalueRead[regTable, prevBlock] ) ;
	public final ControlFlowGraph.read_return read(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.read_return retval = new ControlFlowGraph.read_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree READ37=null;
		TreeRuleReturnScope retReg =null;

		CommonTree READ37_tree=null;

		try {
			// ControlFlowGraph.g:232:4: ( ^( READ retReg= lvalueRead[regTable, prevBlock] ) )
			// ControlFlowGraph.g:232:7: ^( READ retReg= lvalueRead[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			READ37=(CommonTree)match(input,READ,FOLLOW_READ_in_read784); 
			READ37_tree = (CommonTree)adaptor.dupNode(READ37);


			root_1 = (CommonTree)adaptor.becomeRoot(READ37_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalueRead_in_read788);
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
	// ControlFlowGraph.g:239:1: delete[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( DELETE delRetReg= expression[regTable, prevBlock] ) ;
	public final ControlFlowGraph.delete_return delete(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.delete_return retval = new ControlFlowGraph.delete_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DELETE38=null;
		TreeRuleReturnScope delRetReg =null;

		CommonTree DELETE38_tree=null;

		try {
			// ControlFlowGraph.g:240:4: ( ^( DELETE delRetReg= expression[regTable, prevBlock] ) )
			// ControlFlowGraph.g:240:6: ^( DELETE delRetReg= expression[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DELETE38=(CommonTree)match(input,DELETE,FOLLOW_DELETE_in_delete820); 
			DELETE38_tree = (CommonTree)adaptor.dupNode(DELETE38);


			root_1 = (CommonTree)adaptor.becomeRoot(DELETE38_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_delete824);
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
	// ControlFlowGraph.g:247:1: print[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? ) ;
	public final ControlFlowGraph.print_return print(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.print_return retval = new ControlFlowGraph.print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PRINT39=null;
		CommonTree ENDL40=null;
		TreeRuleReturnScope returnReg =null;

		CommonTree PRINT39_tree=null;
		CommonTree ENDL40_tree=null;

		try {
			// ControlFlowGraph.g:248:4: ( ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? ) )
			// ControlFlowGraph.g:248:7: ^( PRINT returnReg= expression[regTable, prevBlock] ( ENDL )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PRINT39=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print857); 
			PRINT39_tree = (CommonTree)adaptor.dupNode(PRINT39);


			root_1 = (CommonTree)adaptor.becomeRoot(PRINT39_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_print861);
			returnReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, returnReg.getTree());

			// ControlFlowGraph.g:248:57: ( ENDL )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ENDL) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// ControlFlowGraph.g:248:57: ENDL
					{
					_last = (CommonTree)input.LT(1);
					ENDL40=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print864); 
					ENDL40_tree = (CommonTree)adaptor.dupNode(ENDL40);


					adaptor.addChild(root_1, ENDL40_tree);

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
	// ControlFlowGraph.g:255:1: ret[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ( ^( RETURN returnReg= expression[regTable, prevBlock] ) | RETURN );
	public final ControlFlowGraph.ret_return ret(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.ret_return retval = new ControlFlowGraph.ret_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree RETURN41=null;
		CommonTree RETURN42=null;
		TreeRuleReturnScope returnReg =null;

		CommonTree RETURN41_tree=null;
		CommonTree RETURN42_tree=null;

		try {
			// ControlFlowGraph.g:256:4: ( ^( RETURN returnReg= expression[regTable, prevBlock] ) | RETURN )
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
					// ControlFlowGraph.g:256:7: ^( RETURN returnReg= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					RETURN41=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret897); 
					RETURN41_tree = (CommonTree)adaptor.dupNode(RETURN41);


					root_1 = (CommonTree)adaptor.becomeRoot(RETURN41_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_ret903);
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
					// ControlFlowGraph.g:261:7: RETURN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RETURN42=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret921); 
					RETURN42_tree = (CommonTree)adaptor.dupNode(RETURN42);


					adaptor.addChild(root_0, RETURN42_tree);

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
	// ControlFlowGraph.g:264:1: arguments[String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : retArgBlock= arg_list[callID, regTable, prevBlock] ;
	public final ControlFlowGraph.arguments_return arguments(String callID, RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.arguments_return retval = new ControlFlowGraph.arguments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope retArgBlock =null;


		try {
			// ControlFlowGraph.g:265:4: (retArgBlock= arg_list[callID, regTable, prevBlock] )
			// ControlFlowGraph.g:265:7: retArgBlock= arg_list[callID, regTable, prevBlock]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arg_list_in_arguments949);
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
	// ControlFlowGraph.g:271:1: arg_list[String callID, RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ( ^( ARGS (retArg= expression[regTable, prevBlock] )+ ) | ARGS );
	public final ControlFlowGraph.arg_list_return arg_list(String callID, RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.arg_list_return retval = new ControlFlowGraph.arg_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ARGS43=null;
		CommonTree ARGS44=null;
		TreeRuleReturnScope retArg =null;

		CommonTree ARGS43_tree=null;
		CommonTree ARGS44_tree=null;


		      int argCounter = 0;
		      Vector<Instruction> storeCache = new Vector<Instruction>();
		   
		try {
			// ControlFlowGraph.g:276:4: ( ^( ARGS (retArg= expression[regTable, prevBlock] )+ ) | ARGS )
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
					// ControlFlowGraph.g:276:7: ^( ARGS (retArg= expression[regTable, prevBlock] )+ )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					ARGS43=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list989); 
					ARGS43_tree = (CommonTree)adaptor.dupNode(ARGS43);


					root_1 = (CommonTree)adaptor.becomeRoot(ARGS43_tree, root_1);

					match(input, Token.DOWN, null); 
					// ControlFlowGraph.g:276:14: (retArg= expression[regTable, prevBlock] )+
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
							// ControlFlowGraph.g:276:15: retArg= expression[regTable, prevBlock]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expression_in_arg_list994);
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
					         prevBlock.instructions.add(new CallInst(callID, argCounter));
					         retval.retBlock = prevBlock;
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:287:7: ARGS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ARGS44=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list1022); 
					ARGS44_tree = (CommonTree)adaptor.dupNode(ARGS44);


					adaptor.addChild(root_0, ARGS44_tree);

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
	// ControlFlowGraph.g:290:1: conditional[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? ) ;
	public final ControlFlowGraph.conditional_return conditional(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.conditional_return retval = new ControlFlowGraph.conditional_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IF45=null;
		TreeRuleReturnScope guardReg =null;
		TreeRuleReturnScope trueBlock =null;
		TreeRuleReturnScope falseBlock =null;

		CommonTree IF45_tree=null;


		      BasicBlock trueBlockIn = new BasicBlock(getLabel());
		      BasicBlock falseBlockIn = new BasicBlock(getLabel());
		      addBlockRel(prevBlock, trueBlockIn);
		   
		try {
			// ControlFlowGraph.g:296:4: ( ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? ) )
			// ControlFlowGraph.g:296:7: ^( IF guardReg= expression[regTable, prevBlock] trueBlock= block[regTable, trueBlockIn] (falseBlock= block[regTable, falseBlockIn] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			IF45=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional1055); 
			IF45_tree = (CommonTree)adaptor.dupNode(IF45);


			root_1 = (CommonTree)adaptor.becomeRoot(IF45_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_conditional1059);
			guardReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, guardReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_conditional1064);
			trueBlock=block(regTable, trueBlockIn);
			state._fsp--;

			adaptor.addChild(root_1, trueBlock.getTree());

			// ControlFlowGraph.g:296:92: (falseBlock= block[regTable, falseBlockIn] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BLOCK) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// ControlFlowGraph.g:297:7: falseBlock= block[regTable, falseBlockIn]
					{

					         addBlockRel(prevBlock, falseBlockIn);
					         prevBlock.instructions.add(new CompImmInst((guardReg!=null?((ControlFlowGraph.expression_return)guardReg).regNum:null), 1));
					      
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_conditional1085);
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
			         } else {
			            addBlockRel(falseBlockIn, convergeBlock);
			            prevBlock.instructions.add(new CBRNEInst(falseBlockIn.label, (trueBlock!=null?((ControlFlowGraph.block_return)trueBlock).retBlock:null).label));
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
	// ControlFlowGraph.g:317:1: invocation[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] ) ;
	public final ControlFlowGraph.invocation_return invocation(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.invocation_return retval = new ControlFlowGraph.invocation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree funcId=null;
		CommonTree INVOKE46=null;
		TreeRuleReturnScope arguments47 =null;

		CommonTree funcId_tree=null;
		CommonTree INVOKE46_tree=null;

		try {
			// ControlFlowGraph.g:318:4: ( ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] ) )
			// ControlFlowGraph.g:318:7: ^( INVOKE funcId= ID arguments[$funcId.text, regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			INVOKE46=(CommonTree)match(input,INVOKE,FOLLOW_INVOKE_in_invocation1120); 
			INVOKE46_tree = (CommonTree)adaptor.dupNode(INVOKE46);


			root_1 = (CommonTree)adaptor.becomeRoot(INVOKE46_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			funcId=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation1124); 
			funcId_tree = (CommonTree)adaptor.dupNode(funcId);


			adaptor.addChild(root_1, funcId_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arguments_in_invocation1126);
			arguments47=arguments((funcId!=null?funcId.getText():null), regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, arguments47.getTree());

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
	// ControlFlowGraph.g:325:1: loop[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] ) ;
	public final ControlFlowGraph.loop_return loop(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.loop_return retval = new ControlFlowGraph.loop_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree WHILE48=null;
		TreeRuleReturnScope guardReg =null;
		TreeRuleReturnScope retBodyBlock =null;
		TreeRuleReturnScope guardReg2 =null;

		CommonTree WHILE48_tree=null;

		try {
			// ControlFlowGraph.g:326:4: ( ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] ) )
			// ControlFlowGraph.g:326:7: ^( WHILE guardReg= expression[regTable, prevBlock] retBodyBlock= block[regTable, bodyBlock] guardReg2= expression[regTable, bodyBlock] )
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
			WHILE48=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop1164); 
			WHILE48_tree = (CommonTree)adaptor.dupNode(WHILE48);


			root_1 = (CommonTree)adaptor.becomeRoot(WHILE48_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop1168);
			guardReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, guardReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_loop1173);
			retBodyBlock=block(regTable, bodyBlock);
			state._fsp--;

			adaptor.addChild(root_1, retBodyBlock.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop1178);
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
	// ControlFlowGraph.g:344:1: block[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] ) ;
	public final ControlFlowGraph.block_return block(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.block_return retval = new ControlFlowGraph.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BLOCK49=null;
		TreeRuleReturnScope returnSLBlock =null;

		CommonTree BLOCK49_tree=null;

		try {
			// ControlFlowGraph.g:345:4: ( ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] ) )
			// ControlFlowGraph.g:345:7: ^( BLOCK returnSLBlock= statement_list[regTable, prevBlock] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BLOCK49=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block1211); 
			BLOCK49_tree = (CommonTree)adaptor.dupNode(BLOCK49);


			root_1 = (CommonTree)adaptor.becomeRoot(BLOCK49_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_block1215);
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
	// ControlFlowGraph.g:351:1: assignment[RegisterTable regTable, BasicBlock prevBlock] returns [BasicBlock retBlock] : ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] ) ;
	public final ControlFlowGraph.assignment_return assignment(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.assignment_return retval = new ControlFlowGraph.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASSIGN50=null;
		TreeRuleReturnScope retExpReg =null;
		TreeRuleReturnScope lvalue51 =null;

		CommonTree ASSIGN50_tree=null;

		try {
			// ControlFlowGraph.g:352:4: ( ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] ) )
			// ControlFlowGraph.g:352:7: ^( ASSIGN retExpReg= expression[regTable, prevBlock] lvalue[regTable, prevBlock, $retExpReg.regNum] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ASSIGN50=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment1248); 
			ASSIGN50_tree = (CommonTree)adaptor.dupNode(ASSIGN50);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSIGN50_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_assignment1252);
			retExpReg=expression(regTable, prevBlock);
			state._fsp--;

			adaptor.addChild(root_1, retExpReg.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_assignment1255);
			lvalue51=lvalue(regTable, prevBlock, (retExpReg!=null?((ControlFlowGraph.expression_return)retExpReg).regNum:null));
			state._fsp--;

			adaptor.addChild(root_1, lvalue51.getTree());

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
	// ControlFlowGraph.g:358:1: expression[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum = null] : (invRetReg= invocation[regTable, prevBlock] | ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NOT expression[regTable, prevBlock] ) | ^( DOT retReg= expression[regTable, prevBlock] calledId= ID ) |newId= ID |intVal= INTEGER | TRUE | FALSE | ^( NEW addrId= ID ) | ^( NEG returnReg= expression[regTable, prevBlock] ) | NULL );
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
		CommonTree AND52=null;
		CommonTree OR53=null;
		CommonTree LE54=null;
		CommonTree EQ55=null;
		CommonTree LT56=null;
		CommonTree GT57=null;
		CommonTree NE58=null;
		CommonTree GE61=null;
		CommonTree PLUS64=null;
		CommonTree MINUS65=null;
		CommonTree TIMES66=null;
		CommonTree DIVIDE67=null;
		CommonTree NOT68=null;
		CommonTree DOT70=null;
		CommonTree TRUE71=null;
		CommonTree FALSE72=null;
		CommonTree NEW73=null;
		CommonTree NEG74=null;
		CommonTree NULL75=null;
		TreeRuleReturnScope invRetReg =null;
		TreeRuleReturnScope regNum1 =null;
		TreeRuleReturnScope regNum2 =null;
		TreeRuleReturnScope retReg =null;
		TreeRuleReturnScope returnReg =null;
		TreeRuleReturnScope expression59 =null;
		TreeRuleReturnScope expression60 =null;
		TreeRuleReturnScope expression62 =null;
		TreeRuleReturnScope expression63 =null;
		TreeRuleReturnScope expression69 =null;

		CommonTree calledId_tree=null;
		CommonTree newId_tree=null;
		CommonTree intVal_tree=null;
		CommonTree addrId_tree=null;
		CommonTree AND52_tree=null;
		CommonTree OR53_tree=null;
		CommonTree LE54_tree=null;
		CommonTree EQ55_tree=null;
		CommonTree LT56_tree=null;
		CommonTree GT57_tree=null;
		CommonTree NE58_tree=null;
		CommonTree GE61_tree=null;
		CommonTree PLUS64_tree=null;
		CommonTree MINUS65_tree=null;
		CommonTree TIMES66_tree=null;
		CommonTree DIVIDE67_tree=null;
		CommonTree NOT68_tree=null;
		CommonTree DOT70_tree=null;
		CommonTree TRUE71_tree=null;
		CommonTree FALSE72_tree=null;
		CommonTree NEW73_tree=null;
		CommonTree NEG74_tree=null;
		CommonTree NULL75_tree=null;

		try {
			// ControlFlowGraph.g:359:4: (invRetReg= invocation[regTable, prevBlock] | ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] ) | ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] ) | ^( NOT expression[regTable, prevBlock] ) | ^( DOT retReg= expression[regTable, prevBlock] calledId= ID ) |newId= ID |intVal= INTEGER | TRUE | FALSE | ^( NEW addrId= ID ) | ^( NEG returnReg= expression[regTable, prevBlock] ) | NULL )
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
					// ControlFlowGraph.g:359:7: invRetReg= invocation[regTable, prevBlock]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_expression1289);
					invRetReg=invocation(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_0, invRetReg.getTree());


					         retval.regNum = (invRetReg!=null?((ControlFlowGraph.invocation_return)invRetReg).regNum:null);
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:363:7: ^( AND regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					AND52=(CommonTree)match(input,AND,FOLLOW_AND_in_expression1307); 
					AND52_tree = (CommonTree)adaptor.dupNode(AND52);


					root_1 = (CommonTree)adaptor.becomeRoot(AND52_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1311);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1316);
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
					// ControlFlowGraph.g:368:7: ^( OR regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					OR53=(CommonTree)match(input,OR,FOLLOW_OR_in_expression1335); 
					OR53_tree = (CommonTree)adaptor.dupNode(OR53);


					root_1 = (CommonTree)adaptor.becomeRoot(OR53_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1339);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1344);
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
					// ControlFlowGraph.g:373:7: ^( LE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					LE54=(CommonTree)match(input,LE,FOLLOW_LE_in_expression1363); 
					LE54_tree = (CommonTree)adaptor.dupNode(LE54);


					root_1 = (CommonTree)adaptor.becomeRoot(LE54_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1367);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1372);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveLEInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 5 :
					// ControlFlowGraph.g:380:7: ^( EQ regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					EQ55=(CommonTree)match(input,EQ,FOLLOW_EQ_in_expression1391); 
					EQ55_tree = (CommonTree)adaptor.dupNode(EQ55);


					root_1 = (CommonTree)adaptor.becomeRoot(EQ55_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1395);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1400);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveEQInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 6 :
					// ControlFlowGraph.g:387:7: ^( LT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					LT56=(CommonTree)match(input,LT,FOLLOW_LT_in_expression1419); 
					LT56_tree = (CommonTree)adaptor.dupNode(LT56);


					root_1 = (CommonTree)adaptor.becomeRoot(LT56_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1423);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1428);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveLTInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 7 :
					// ControlFlowGraph.g:394:7: ^( GT regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					GT57=(CommonTree)match(input,GT,FOLLOW_GT_in_expression1447); 
					GT57_tree = (CommonTree)adaptor.dupNode(GT57);


					root_1 = (CommonTree)adaptor.becomeRoot(GT57_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1451);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1456);
					regNum2=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveGTInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 8 :
					// ControlFlowGraph.g:401:7: ^( NE expression[regTable, prevBlock] expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NE58=(CommonTree)match(input,NE,FOLLOW_NE_in_expression1475); 
					NE58_tree = (CommonTree)adaptor.dupNode(NE58);


					root_1 = (CommonTree)adaptor.becomeRoot(NE58_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1477);
					expression59=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression59.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1480);
					expression60=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression60.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveNEInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 9 :
					// ControlFlowGraph.g:408:7: ^( GE expression[regTable, prevBlock] expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					GE61=(CommonTree)match(input,GE,FOLLOW_GE_in_expression1499); 
					GE61_tree = (CommonTree)adaptor.dupNode(GE61);


					root_1 = (CommonTree)adaptor.becomeRoot(GE61_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1501);
					expression62=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression62.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1504);
					expression63=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression63.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new ImmInst(new Integer(0), regCounter));
					         prevBlock.instructions.add(new CompInst((regNum1!=null?((ControlFlowGraph.expression_return)regNum1).regNum:null), (regNum2!=null?((ControlFlowGraph.expression_return)regNum2).regNum:null)));
					         prevBlock.instructions.add(new MoveNEInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 10 :
					// ControlFlowGraph.g:415:7: ^( PLUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					PLUS64=(CommonTree)match(input,PLUS,FOLLOW_PLUS_in_expression1523); 
					PLUS64_tree = (CommonTree)adaptor.dupNode(PLUS64);


					root_1 = (CommonTree)adaptor.becomeRoot(PLUS64_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1527);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1532);
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
					// ControlFlowGraph.g:420:7: ^( MINUS regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					MINUS65=(CommonTree)match(input,MINUS,FOLLOW_MINUS_in_expression1548); 
					MINUS65_tree = (CommonTree)adaptor.dupNode(MINUS65);


					root_1 = (CommonTree)adaptor.becomeRoot(MINUS65_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1552);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1557);
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
					// ControlFlowGraph.g:425:7: ^( TIMES regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					TIMES66=(CommonTree)match(input,TIMES,FOLLOW_TIMES_in_expression1576); 
					TIMES66_tree = (CommonTree)adaptor.dupNode(TIMES66);


					root_1 = (CommonTree)adaptor.becomeRoot(TIMES66_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1580);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1585);
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
					// ControlFlowGraph.g:430:7: ^( DIVIDE regNum1= expression[regTable, prevBlock] regNum2= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DIVIDE67=(CommonTree)match(input,DIVIDE,FOLLOW_DIVIDE_in_expression1604); 
					DIVIDE67_tree = (CommonTree)adaptor.dupNode(DIVIDE67);


					root_1 = (CommonTree)adaptor.becomeRoot(DIVIDE67_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1608);
					regNum1=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, regNum1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1613);
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
					// ControlFlowGraph.g:435:7: ^( NOT expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT68=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1632); 
					NOT68_tree = (CommonTree)adaptor.dupNode(NOT68);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT68_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1634);
					expression69=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, expression69.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 15 :
					// ControlFlowGraph.g:436:7: ^( DOT retReg= expression[regTable, prevBlock] calledId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT70=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1645); 
					DOT70_tree = (CommonTree)adaptor.dupNode(DOT70);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT70_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1649);
					retReg=expression(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					calledId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1654); 
					calledId_tree = (CommonTree)adaptor.dupNode(calledId);


					adaptor.addChild(root_1, calledId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					 
					         prevBlock.instructions.add(new LoadAIInst((retReg!=null?((ControlFlowGraph.expression_return)retReg).regNum:null), (calledId!=null?calledId.getText():null), regCounter));
					         retval.regNum = new Integer(regCounter++);
					      
					}
					break;
				case 16 :
					// ControlFlowGraph.g:441:7: newId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1675); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_0, newId_tree);


					         Integer varReg = regTable.get((newId!=null?newId.getText():null));
					         if (varReg == null) {
					            prevBlock.instructions.add(new ComputeGlobalAddrInst((newId!=null?newId.getText():null), regCounter));
					            retval.regNum = new Integer(regCounter++);
					         } else {
					             prevBlock.instructions.add(new MoveInst(varReg, regCounter));
					             retval.regNum = new Integer(regCounter++);
					         }
					      
					}
					break;
				case 17 :
					// ControlFlowGraph.g:452:7: intVal= INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					intVal=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression1693); 
					intVal_tree = (CommonTree)adaptor.dupNode(intVal);


					adaptor.addChild(root_0, intVal_tree);


					         prevBlock.instructions.add(new ImmInst(Integer.valueOf((intVal!=null?intVal.getText():null)), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 18 :
					// ControlFlowGraph.g:457:7: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE71=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_expression1709); 
					TRUE71_tree = (CommonTree)adaptor.dupNode(TRUE71);


					adaptor.addChild(root_0, TRUE71_tree);


					         prevBlock.instructions.add(new ImmInst(1, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 19 :
					// ControlFlowGraph.g:462:7: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE72=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_expression1726); 
					FALSE72_tree = (CommonTree)adaptor.dupNode(FALSE72);


					adaptor.addChild(root_0, FALSE72_tree);


					         prevBlock.instructions.add(new ImmInst(0, regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 20 :
					// ControlFlowGraph.g:467:7: ^( NEW addrId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEW73=(CommonTree)match(input,NEW,FOLLOW_NEW_in_expression1743); 
					NEW73_tree = (CommonTree)adaptor.dupNode(NEW73);


					root_1 = (CommonTree)adaptor.becomeRoot(NEW73_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					addrId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1747); 
					addrId_tree = (CommonTree)adaptor.dupNode(addrId);


					adaptor.addChild(root_1, addrId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new NewInst((addrId!=null?addrId.getText():null), regCounter));
					         retval.regNum = regCounter++;
					      
					}
					break;
				case 21 :
					// ControlFlowGraph.g:472:7: ^( NEG returnReg= expression[regTable, prevBlock] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEG74=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expression1765); 
					NEG74_tree = (CommonTree)adaptor.dupNode(NEG74);


					root_1 = (CommonTree)adaptor.becomeRoot(NEG74_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1769);
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
					// ControlFlowGraph.g:478:7: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL75=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression1788); 
					NULL75_tree = (CommonTree)adaptor.dupNode(NULL75);


					adaptor.addChild(root_0, NULL75_tree);


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
	// ControlFlowGraph.g:485:1: lvalue[RegisterTable regTable, BasicBlock prevBlock, Integer assReg] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalue_return lvalue(RegisterTable regTable, BasicBlock prevBlock, Integer assReg) throws RecognitionException {
		ControlFlowGraph.lvalue_return retval = new ControlFlowGraph.lvalue_return();
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
			// ControlFlowGraph.g:486:4: (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) )
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
					// ControlFlowGraph.g:486:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1823); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         prevBlock.instructions.add(new MoveInst(assReg, regTable.get((retId!=null?retId.getText():null))));
					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:491:7: ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT76=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalue1840); 
					DOT76_tree = (CommonTree)adaptor.dupNode(DOT76);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT76_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueLoad_in_lvalue1844);
					retReg=lvalueLoad(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1849); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_1, newId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new StoreImmInst(assReg, (retReg!=null?((ControlFlowGraph.lvalueLoad_return)retReg).regNum:null), (newId!=null?newId.getText():null)));
					      
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
	// ControlFlowGraph.g:497:1: lvalueRead[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalueRead_return lvalueRead(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.lvalueRead_return retval = new ControlFlowGraph.lvalueRead_return();
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
			// ControlFlowGraph.g:498:4: (retId= ID | ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID ) )
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
					// ControlFlowGraph.g:498:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueRead1882); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:502:7: ^( DOT retReg= lvalueRead[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT77=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalueRead1899); 
					DOT77_tree = (CommonTree)adaptor.dupNode(DOT77);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT77_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueRead_in_lvalueRead1903);
					retReg=lvalueRead(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueRead1908); 
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
	// ControlFlowGraph.g:509:1: lvalueLoad[RegisterTable regTable, BasicBlock prevBlock] returns [Integer regNum] : (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) );
	public final ControlFlowGraph.lvalueLoad_return lvalueLoad(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.lvalueLoad_return retval = new ControlFlowGraph.lvalueLoad_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree retId=null;
		CommonTree newId=null;
		CommonTree DOT78=null;
		TreeRuleReturnScope retReg =null;

		CommonTree retId_tree=null;
		CommonTree newId_tree=null;
		CommonTree DOT78_tree=null;

		try {
			// ControlFlowGraph.g:510:4: (retId= ID | ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID ) )
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
					// ControlFlowGraph.g:510:7: retId= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					retId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueLoad1941); 
					retId_tree = (CommonTree)adaptor.dupNode(retId);


					adaptor.addChild(root_0, retId_tree);


					         retval.regNum = regTable.get((retId!=null?retId.getText():null));
					         if (retval.regNum == null) {
					            prevBlock.instructions.add(new LoadGlobalInst((retId!=null?retId.getText():null), regCounter));
					            retval.regNum = regCounter++;
					         }
					      
					}
					break;
				case 2 :
					// ControlFlowGraph.g:518:7: ^( DOT retReg= lvalueLoad[regTable, prevBlock] newId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT78=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalueLoad1958); 
					DOT78_tree = (CommonTree)adaptor.dupNode(DOT78);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT78_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalueLoad_in_lvalueLoad1962);
					retReg=lvalueLoad(regTable, prevBlock);
					state._fsp--;

					adaptor.addChild(root_1, retReg.getTree());

					_last = (CommonTree)input.LT(1);
					newId=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalueLoad1967); 
					newId_tree = (CommonTree)adaptor.dupNode(newId);


					adaptor.addChild(root_1, newId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					         prevBlock.instructions.add(new LoadAIInst((retReg!=null?((ControlFlowGraph.lvalueLoad_return)retReg).regNum:null), (newId!=null?newId.getText():null), regCounter));
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
	// ControlFlowGraph.g:525:1: rettype : ( type | VOID );
	public final ControlFlowGraph.rettype_return rettype() throws RecognitionException {
		ControlFlowGraph.rettype_return retval = new ControlFlowGraph.rettype_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree VOID80=null;
		TreeRuleReturnScope type79 =null;

		CommonTree VOID80_tree=null;

		try {
			// ControlFlowGraph.g:526:4: ( type | VOID )
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
					// ControlFlowGraph.g:526:7: type
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_rettype1993);
					type79=type();
					state._fsp--;

					adaptor.addChild(root_0, type79.getTree());

					}
					break;
				case 2 :
					// ControlFlowGraph.g:527:7: VOID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					VOID80=(CommonTree)match(input,VOID,FOLLOW_VOID_in_rettype2001); 
					VOID80_tree = (CommonTree)adaptor.dupNode(VOID80);


					adaptor.addChild(root_0, VOID80_tree);

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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "params"
	// ControlFlowGraph.g:530:1: params[RegisterTable regTable, BasicBlock prevBlock] : ^( PARAMS (declRetID= decl )* ) ;
	public final ControlFlowGraph.params_return params(RegisterTable regTable, BasicBlock prevBlock) throws RecognitionException {
		ControlFlowGraph.params_return retval = new ControlFlowGraph.params_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARAMS81=null;
		TreeRuleReturnScope declRetID =null;

		CommonTree PARAMS81_tree=null;


		      int paramNum = 0;
		   
		try {
			// ControlFlowGraph.g:534:4: ( ^( PARAMS (declRetID= decl )* ) )
			// ControlFlowGraph.g:534:7: ^( PARAMS (declRetID= decl )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARAMS81=(CommonTree)match(input,PARAMS,FOLLOW_PARAMS_in_params2028); 
			PARAMS81_tree = (CommonTree)adaptor.dupNode(PARAMS81);


			root_1 = (CommonTree)adaptor.becomeRoot(PARAMS81_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ControlFlowGraph.g:534:16: (declRetID= decl )*
				loop21:
				while (true) {
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==DECL) ) {
						alt21=1;
					}

					switch (alt21) {
					case 1 :
						// ControlFlowGraph.g:534:17: declRetID= decl
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_params2033);
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
	public static final BitSet FOLLOW_params_in_function486 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RETTYPE_in_function490 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rettype_in_function492 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_declarations_in_function495 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_statement_list_in_function500 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STMTS_in_statement_list533 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_statement_list538 = new BitSet(new long[]{0x04014800240040C8L});
	public static final BitSet FOLLOW_block_in_statement594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_loop_in_statement659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_invocation_in_statement676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_in_statement695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_in_statement714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_statement733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_statement752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read784 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueRead_in_read788 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DELETE_in_delete820 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_delete824 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_print857 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_print861 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_ENDL_in_print864 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret897 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ret903 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_list_in_arguments949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARGS_in_arg_list989 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_arg_list994 = new BitSet(new long[]{0x006005FEB3998018L});
	public static final BitSet FOLLOW_ARGS_in_arg_list1022 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional1055 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_conditional1059 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_conditional1064 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_block_in_conditional1085 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INVOKE_in_invocation1120 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_invocation1124 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_arguments_in_invocation1126 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_loop1164 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_loop1168 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_loop1173 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_loop1178 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block1211 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_list_in_block1215 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment1248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_assignment1252 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_lvalue_in_assignment1255 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_invocation_in_expression1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_expression1307 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1311 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1316 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expression1335 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1339 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1344 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LE_in_expression1363 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1367 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1372 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expression1391 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1395 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1400 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LT_in_expression1419 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1423 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1428 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GT_in_expression1447 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1451 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1456 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NE_in_expression1475 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1477 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1480 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_GE_in_expression1499 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1501 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1504 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PLUS_in_expression1523 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1527 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1532 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MINUS_in_expression1548 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1552 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1557 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TIMES_in_expression1576 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1580 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1585 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DIVIDE_in_expression1604 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1608 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1613 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expression1632 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1634 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_expression1645 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1649 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_expression1654 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expression1675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_expression1693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expression1709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expression1726 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_expression1743 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expression1747 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEG_in_expression1765 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1769 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_expression1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lvalue1823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalue1840 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueLoad_in_lvalue1844 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalue1849 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_lvalueRead1882 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalueRead1899 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueRead_in_lvalueRead1903 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalueRead1908 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_lvalueLoad1941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalueLoad1958 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalueLoad_in_lvalueLoad1962 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalueLoad1967 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_type_in_rettype1993 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_rettype2001 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAMS_in_params2028 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_params2033 = new BitSet(new long[]{0x0000000000000808L});
}
