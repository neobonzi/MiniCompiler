// $ANTLR 3.5.2 TypeCheck.g 2014-04-22 16:03:25

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
public class TypeCheck extends TreeParser {
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


	public TypeCheck(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public TypeCheck(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return TypeCheck.tokenNames; }
	@Override public String getGrammarFileName() { return "TypeCheck.g"; }


		
	    StructTypes stypes;
	    Vector<SymbolTable> env;

	    public Vector<SymbolTable> getGlobalSymbolTable() {
	        return env; 
	    }

	    public StructTypes getStructTypes() {
	        return stypes;
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

		public Vector<SymbolTable> getSymTable() {
	      return env;
	   }


	public static class verify_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "verify"
	// TypeCheck.g:75:1: verify : ( program EOF |);
	public final TypeCheck.verify_return verify() throws RecognitionException {
		TypeCheck.verify_return retval = new TypeCheck.verify_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree EOF2=null;
		TreeRuleReturnScope program1 =null;

		CommonTree EOF2_tree=null;

		try {
			// TypeCheck.g:76:2: ( program EOF |)
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
					// TypeCheck.g:76:4: program EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_program_in_verify55);
					program1=program();
					state._fsp--;

					adaptor.addChild(root_0, program1.getTree());

					_last = (CommonTree)input.LT(1);
					EOF2=(CommonTree)match(input,EOF,FOLLOW_EOF_in_verify57); 
					EOF2_tree = (CommonTree)adaptor.dupNode(EOF2);


					adaptor.addChild(root_0, EOF2_tree);

					}
					break;
				case 2 :
					// TypeCheck.g:77:6: 
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
	// $ANTLR end "verify"


	public static class program_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "program"
	// TypeCheck.g:80:1: program : ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) ;
	public final TypeCheck.program_return program() throws RecognitionException {
		TypeCheck.program_return retval = new TypeCheck.program_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PROGRAM3=null;
		TreeRuleReturnScope types4 =null;
		TreeRuleReturnScope declarations5 =null;
		TreeRuleReturnScope functions6 =null;

		CommonTree PROGRAM3_tree=null;


				stypes = new StructTypes();
				env = new Vector<SymbolTable>();
				env.add(new SymbolTable());
			
		try {
			// TypeCheck.g:86:4: ( ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) )
			// TypeCheck.g:86:6: ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PROGRAM3=(CommonTree)match(input,PROGRAM,FOLLOW_PROGRAM_in_program83); 
			PROGRAM3_tree = (CommonTree)adaptor.dupNode(PROGRAM3);


			root_1 = (CommonTree)adaptor.becomeRoot(PROGRAM3_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_types_in_program85);
			types4=types(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, types4.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_program88);
			declarations5=declarations(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, declarations5.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_functions_in_program91);
			functions6=functions(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, functions6.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			   		if(lookupType("main", env) == null) {
			   			error("Main method required");
			   		}
			   		
			   		System.out.println("---------Successfully Passed Type Checking!---------");
			   	
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
	// TypeCheck.g:96:1: types[StructTypes stypes, Vector<SymbolTable> env] : ( ^( TYPES types_sub[stypes, env] ) | TYPES );
	public final TypeCheck.types_return types(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.types_return retval = new TypeCheck.types_return();
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
			// TypeCheck.g:97:4: ( ^( TYPES types_sub[stypes, env] ) | TYPES )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==TYPES) ) {
				int LA2_1 = input.LA(2);
				if ( (LA2_1==DOWN) ) {
					alt2=1;
				}
				else if ( (LA2_1==DECLS) ) {
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
					// TypeCheck.g:97:8: ^( TYPES types_sub[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					TYPES7=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types119); 
					TYPES7_tree = (CommonTree)adaptor.dupNode(TYPES7);


					root_1 = (CommonTree)adaptor.becomeRoot(TYPES7_tree, root_1);

					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_types_sub_in_types121);
						types_sub8=types_sub(stypes, env);
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
					// TypeCheck.g:98:8: TYPES
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TYPES9=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types132); 
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
	// TypeCheck.g:101:1: types_sub[StructTypes stypes, Vector<SymbolTable> env] : ( type_decl[stypes] types_sub[stypes, env] |);
	public final TypeCheck.types_sub_return types_sub(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.types_sub_return retval = new TypeCheck.types_sub_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope type_decl10 =null;
		TreeRuleReturnScope types_sub11 =null;


		try {
			// TypeCheck.g:102:2: ( type_decl[stypes] types_sub[stypes, env] |)
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
					// TypeCheck.g:102:4: type_decl[stypes] types_sub[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_decl_in_types_sub147);
					type_decl10=type_decl(stypes);
					state._fsp--;

					adaptor.addChild(root_0, type_decl10.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_types_sub_in_types_sub150);
					types_sub11=types_sub(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, types_sub11.getTree());

					}
					break;
				case 2 :
					// TypeCheck.g:104:2: 
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
	// TypeCheck.g:106:1: type_decl[StructTypes stypes] : ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] ) ;
	public final TypeCheck.type_decl_return type_decl(StructTypes stypes) throws RecognitionException {
		TypeCheck.type_decl_return retval = new TypeCheck.type_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree STRUCT12=null;
		TreeRuleReturnScope nested_decl13 =null;

		CommonTree id_tree=null;
		CommonTree STRUCT12_tree=null;


				StructType newStruct;
			
		try {
			// TypeCheck.g:110:2: ( ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] ) )
			// TypeCheck.g:110:5: ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STRUCT12=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type_decl176); 
			STRUCT12_tree = (CommonTree)adaptor.dupNode(STRUCT12);


			root_1 = (CommonTree)adaptor.becomeRoot(STRUCT12_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_decl181); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);


						newStruct = new StructType((id!=null?id.getText():null));
						stypes.put((id!=null?id.getText():null), newStruct);
					
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_decl_in_type_decl190);
			nested_decl13=nested_decl(stypes, newStruct.members);
			state._fsp--;

			adaptor.addChild(root_1, nested_decl13.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						StructType myStruct = (StructType)stypes.get((id!=null?id.getText():null));
					
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
	// TypeCheck.g:121:1: nested_decl[StructTypes stypes, SymbolTable structDecls] : ( decl[stypes, structDecls] )+ ;
	public final TypeCheck.nested_decl_return nested_decl(StructTypes stypes, SymbolTable structDecls) throws RecognitionException {
		TypeCheck.nested_decl_return retval = new TypeCheck.nested_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decl14 =null;


		try {
			// TypeCheck.g:122:2: ( ( decl[stypes, structDecls] )+ )
			// TypeCheck.g:122:4: ( decl[stypes, structDecls] )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// TypeCheck.g:122:4: ( decl[stypes, structDecls] )+
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
					// TypeCheck.g:122:4: decl[stypes, structDecls]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_decl_in_nested_decl211);
					decl14=decl(stypes, structDecls);
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
		public Type newDec;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "decl"
	// TypeCheck.g:125:1: decl[StructTypes stypes, SymbolTable localEnv] returns [Type newDec] : ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) ;
	public final TypeCheck.decl_return decl(StructTypes stypes, SymbolTable localEnv) throws RecognitionException {
		TypeCheck.decl_return retval = new TypeCheck.decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree myId=null;
		CommonTree DECL15=null;
		CommonTree TYPE16=null;
		TreeRuleReturnScope retType =null;

		CommonTree myId_tree=null;
		CommonTree DECL15_tree=null;
		CommonTree TYPE16_tree=null;

		try {
			// TypeCheck.g:126:4: ( ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) )
			// TypeCheck.g:126:7: ^( DECL ^( TYPE retType= type[stypes] ) myId= ID )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECL15=(CommonTree)match(input,DECL,FOLLOW_DECL_in_decl235); 
			DECL15_tree = (CommonTree)adaptor.dupNode(DECL15);


			root_1 = (CommonTree)adaptor.becomeRoot(DECL15_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE16=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decl238); 
			TYPE16_tree = (CommonTree)adaptor.dupNode(TYPE16);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE16_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decl242);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			myId=(CommonTree)match(input,ID,FOLLOW_ID_in_decl248); 
			myId_tree = (CommonTree)adaptor.dupNode(myId);


			adaptor.addChild(root_1, myId_tree);

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			   		localEnv.put((myId!=null?myId.getText():null), (retType!=null?((TypeCheck.type_return)retType).t:null));
			   		retval.newDec = (retType!=null?((TypeCheck.type_return)retType).t:null);
			   	
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
	// TypeCheck.g:133:1: declarations[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLS ( declaration[stypes, env] )* ) ;
	public final TypeCheck.declarations_return declarations(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declarations_return retval = new TypeCheck.declarations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLS17=null;
		TreeRuleReturnScope declaration18 =null;

		CommonTree DECLS17_tree=null;

		try {
			// TypeCheck.g:134:4: ( ^( DECLS ( declaration[stypes, env] )* ) )
			// TypeCheck.g:134:7: ^( DECLS ( declaration[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLS17=(CommonTree)match(input,DECLS,FOLLOW_DECLS_in_declarations277); 
			DECLS17_tree = (CommonTree)adaptor.dupNode(DECLS17);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLS17_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:134:15: ( declaration[stypes, env] )*
				loop5:
				while (true) {
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==DECLLIST) ) {
						alt5=1;
					}

					switch (alt5) {
					case 1 :
						// TypeCheck.g:134:15: declaration[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_declaration_in_declarations279);
						declaration18=declaration(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, declaration18.getTree());

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
	// TypeCheck.g:137:1: declaration[StructTypes stypes, Vector<SymbolTable> env] : decllist[stypes, env] ;
	public final TypeCheck.declaration_return declaration(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declaration_return retval = new TypeCheck.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decllist19 =null;


		try {
			// TypeCheck.g:138:2: ( decllist[stypes, env] )
			// TypeCheck.g:138:4: decllist[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_decllist_in_declaration297);
			decllist19=decllist(stypes, env);
			state._fsp--;

			adaptor.addChild(root_0, decllist19.getTree());

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
		public Type t = null;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "type"
	// TypeCheck.g:141:1: type[StructTypes stypes] returns [Type t = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
	public final TypeCheck.type_return type(StructTypes stypes) throws RecognitionException {
		TypeCheck.type_return retval = new TypeCheck.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree INT20=null;
		CommonTree BOOL21=null;
		CommonTree STRUCT22=null;

		CommonTree id_tree=null;
		CommonTree INT20_tree=null;
		CommonTree BOOL21_tree=null;
		CommonTree STRUCT22_tree=null;

		try {
			// TypeCheck.g:142:2: ( INT | BOOL | ^( STRUCT id= ID ) )
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
					// TypeCheck.g:142:5: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT20=(CommonTree)match(input,INT,FOLLOW_INT_in_type316); 
					INT20_tree = (CommonTree)adaptor.dupNode(INT20);


					adaptor.addChild(root_0, INT20_tree);

					 retval.t = new IntType(); 
					}
					break;
				case 2 :
					// TypeCheck.g:143:5: BOOL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOL21=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_type324); 
					BOOL21_tree = (CommonTree)adaptor.dupNode(BOOL21);


					adaptor.addChild(root_0, BOOL21_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 3 :
					// TypeCheck.g:144:4: ^( STRUCT id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					STRUCT22=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type332); 
					STRUCT22_tree = (CommonTree)adaptor.dupNode(STRUCT22);


					root_1 = (CommonTree)adaptor.becomeRoot(STRUCT22_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_type336); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_1, id_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!stypes.isDefined((id!=null?id.getText():null)))
								{
									error((id!=null?id.getLine():0), "undefined struct type '" + id + "'");
								}
								retval.t = stypes.get((id!=null?id.getText():null));
							
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
	// TypeCheck.g:154:1: decllist[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) ;
	public final TypeCheck.decllist_return decllist(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.decllist_return retval = new TypeCheck.decllist_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLLIST23=null;
		CommonTree TYPE24=null;
		TreeRuleReturnScope retType =null;
		TreeRuleReturnScope id_list25 =null;

		CommonTree DECLLIST23_tree=null;
		CommonTree TYPE24_tree=null;

		try {
			// TypeCheck.g:155:4: ( ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) )
			// TypeCheck.g:155:7: ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLLIST23=(CommonTree)match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist358); 
			DECLLIST23_tree = (CommonTree)adaptor.dupNode(DECLLIST23);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLLIST23_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE24=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decllist361); 
			TYPE24_tree = (CommonTree)adaptor.dupNode(TYPE24);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE24_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decllist365);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_id_list_in_decllist369);
			id_list25=id_list((retType!=null?((TypeCheck.type_return)retType).t:null), env);
			state._fsp--;

			adaptor.addChild(root_1, id_list25.getTree());

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
	// TypeCheck.g:158:1: id_list[Type t, Vector<SymbolTable> env] : (id= ID )+ ;
	public final TypeCheck.id_list_return id_list(Type t, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.id_list_return retval = new TypeCheck.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;

		CommonTree id_tree=null;

		try {
			// TypeCheck.g:159:2: ( (id= ID )+ )
			// TypeCheck.g:159:4: (id= ID )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// TypeCheck.g:159:4: (id= ID )+
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
					// TypeCheck.g:160:4: id= ID
					{
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list393); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_0, id_tree);


					   			if(env.get(0).redef((id!=null?id.getText():null))) {
					   				error((id!=null?id.getLine():0), "redefinition of variable '" + id + "'");
					   			}
					   			
									env.get(0).put((id!=null?id.getText():null), t);
					   		
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
	// TypeCheck.g:171:1: functions[StructTypes stypes, Vector<SymbolTable> env] : ^( FUNCS ( function[stypes, env] )* ) ;
	public final TypeCheck.functions_return functions(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.functions_return retval = new TypeCheck.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FUNCS26=null;
		TreeRuleReturnScope function27 =null;

		CommonTree FUNCS26_tree=null;

		try {
			// TypeCheck.g:172:4: ( ^( FUNCS ( function[stypes, env] )* ) )
			// TypeCheck.g:172:6: ^( FUNCS ( function[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUNCS26=(CommonTree)match(input,FUNCS,FOLLOW_FUNCS_in_functions427); 
			FUNCS26_tree = (CommonTree)adaptor.dupNode(FUNCS26);


			root_1 = (CommonTree)adaptor.becomeRoot(FUNCS26_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:172:14: ( function[stypes, env] )*
				loop8:
				while (true) {
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==FUN) ) {
						alt8=1;
					}

					switch (alt8) {
					case 1 :
						// TypeCheck.g:172:14: function[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_function_in_functions429);
						function27=function(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, function27.getTree());

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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function"
	// TypeCheck.g:175:1: function[StructTypes stypes, Vector<SymbolTable> env] : ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] ) ;
	public final TypeCheck.function_return function(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.function_return retval = new TypeCheck.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree FUN28=null;
		CommonTree RETTYPE29=null;
		TreeRuleReturnScope retParams =null;
		TreeRuleReturnScope rreturn =null;
		TreeRuleReturnScope sl =null;
		TreeRuleReturnScope declarations30 =null;

		CommonTree id_tree=null;
		CommonTree FUN28_tree=null;
		CommonTree RETTYPE29_tree=null;


				SymbolTable funcEnv = new SymbolTable();
				Vector<SymbolTable> localEnv = new Vector<SymbolTable>(env);
				localEnv.add(0, funcEnv);
			
		try {
			// TypeCheck.g:181:2: ( ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] ) )
			// TypeCheck.g:181:4: ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUN28=(CommonTree)match(input,FUN,FOLLOW_FUN_in_function453); 
			FUN28_tree = (CommonTree)adaptor.dupNode(FUN28);


			root_1 = (CommonTree)adaptor.becomeRoot(FUN28_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_function457); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_params_in_function461);
			retParams=params(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, retParams.getTree());

			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			RETTYPE29=(CommonTree)match(input,RETTYPE,FOLLOW_RETTYPE_in_function465); 
			RETTYPE29_tree = (CommonTree)adaptor.dupNode(RETTYPE29);


			root_2 = (CommonTree)adaptor.becomeRoot(RETTYPE29_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rettype_in_function469);
			rreturn=rettype(stypes);
			state._fsp--;

			adaptor.addChild(root_2, rreturn.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_function473);
			declarations30=declarations(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, declarations30.getTree());


						FunctionType func = new FunctionType((rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null), (retParams!=null?((TypeCheck.params_return)retParams).retParams:null));
						localEnv.get(1).put((id!=null?id.getText():null), func);
						localEnv.get(0).put("expret", (rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null));
					
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_function484);
			sl=statement_list(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, sl.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						if(!(rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null).getClass().equals(VoidType.class) && !(sl!=null?((TypeCheck.statement_list_return)sl).hasRet:null)) {
							error("Function requires a return value");
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
	// $ANTLR end "function"


	public static class statement_list_return extends TreeRuleReturnScope {
		public Boolean hasRet = false;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement_list"
	// TypeCheck.g:196:1: statement_list[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( STMTS (retHasRet= statement[stypes, env] )* ) ;
	public final TypeCheck.statement_list_return statement_list(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_list_return retval = new TypeCheck.statement_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STMTS31=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree STMTS31_tree=null;

		try {
			// TypeCheck.g:197:2: ( ^( STMTS (retHasRet= statement[stypes, env] )* ) )
			// TypeCheck.g:197:4: ^( STMTS (retHasRet= statement[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STMTS31=(CommonTree)match(input,STMTS,FOLLOW_STMTS_in_statement_list511); 
			STMTS31_tree = (CommonTree)adaptor.dupNode(STMTS31);


			root_1 = (CommonTree)adaptor.becomeRoot(STMTS31_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:197:21: (retHasRet= statement[stypes, env] )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= ASSIGN && LA9_0 <= BLOCK)||LA9_0==IF||LA9_0==INVOKE||LA9_0==PRINT||LA9_0==READ||LA9_0==RETURN||LA9_0==WHILE) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// TypeCheck.g:197:21: retHasRet= statement[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_statement_list515);
						retHasRet=statement(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, retHasRet.getTree());

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


			 
						if((retHasRet!=null?((TypeCheck.statement_return)retHasRet).hasRet:null) != null) {
							retval.hasRet = (retHasRet!=null?((TypeCheck.statement_return)retHasRet).hasRet:null); 
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
		public Boolean hasRet = false;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// TypeCheck.g:206:1: statement[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : (blockRet= block[stypes, env] | assignment[stypes, env] |condRet= conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | read[stypes, env] | ret[stypes, env] | print[stypes, env] );
	public final TypeCheck.statement_return statement(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_return retval = new TypeCheck.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope blockRet =null;
		TreeRuleReturnScope condRet =null;
		TreeRuleReturnScope assignment32 =null;
		TreeRuleReturnScope loop33 =null;
		TreeRuleReturnScope invocation34 =null;
		TreeRuleReturnScope read35 =null;
		TreeRuleReturnScope ret36 =null;
		TreeRuleReturnScope print37 =null;


		try {
			// TypeCheck.g:207:4: (blockRet= block[stypes, env] | assignment[stypes, env] |condRet= conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | read[stypes, env] | ret[stypes, env] | print[stypes, env] )
			int alt10=8;
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
			case READ:
				{
				alt10=6;
				}
				break;
			case RETURN:
				{
				alt10=7;
				}
				break;
			case PRINT:
				{
				alt10=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// TypeCheck.g:207:6: blockRet= block[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_statement546);
					blockRet=block(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, blockRet.getTree());

					 retval.hasRet = (blockRet!=null?((TypeCheck.block_return)blockRet).hasRet:null);
					}
					break;
				case 2 :
					// TypeCheck.g:208:6: assignment[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assignment_in_statement556);
					assignment32=assignment(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, assignment32.getTree());

					}
					break;
				case 3 :
					// TypeCheck.g:209:7: condRet= conditional[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_conditional_in_statement567);
					condRet=conditional(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, condRet.getTree());

					 retval.hasRet = (condRet!=null?((TypeCheck.conditional_return)condRet).hasRet:null);
					}
					break;
				case 4 :
					// TypeCheck.g:210:7: loop[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_loop_in_statement579);
					loop33=loop(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, loop33.getTree());

					}
					break;
				case 5 :
					// TypeCheck.g:211:7: invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_statement589);
					invocation34=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, invocation34.getTree());

					}
					break;
				case 6 :
					// TypeCheck.g:212:7: read[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_read_in_statement598);
					read35=read(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, read35.getTree());

					}
					break;
				case 7 :
					// TypeCheck.g:213:7: ret[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_ret_in_statement607);
					ret36=ret(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, ret36.getTree());

					 retval.hasRet = true; 
					}
					break;
				case 8 :
					// TypeCheck.g:214:7: print[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_print_in_statement618);
					print37=print(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, print37.getTree());

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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "read"
	// TypeCheck.g:217:1: read[StructTypes stypes, Vector<SymbolTable> env] : ^( READ lvalue ) ;
	public final TypeCheck.read_return read(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.read_return retval = new TypeCheck.read_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree READ38=null;
		TreeRuleReturnScope lvalue39 =null;

		CommonTree READ38_tree=null;

		try {
			// TypeCheck.g:218:2: ( ^( READ lvalue ) )
			// TypeCheck.g:218:5: ^( READ lvalue )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			READ38=(CommonTree)match(input,READ,FOLLOW_READ_in_read636); 
			READ38_tree = (CommonTree)adaptor.dupNode(READ38);


			root_1 = (CommonTree)adaptor.becomeRoot(READ38_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_read638);
			lvalue39=lvalue();
			state._fsp--;

			adaptor.addChild(root_1, lvalue39.getTree());

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
	// $ANTLR end "read"


	public static class print_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "print"
	// TypeCheck.g:221:1: print[StructTypes stypes, Vector<SymbolTable> env] : ^( PRINT expression[stypes, env] ( ENDL )? ) ;
	public final TypeCheck.print_return print(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.print_return retval = new TypeCheck.print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PRINT40=null;
		CommonTree ENDL42=null;
		TreeRuleReturnScope expression41 =null;

		CommonTree PRINT40_tree=null;
		CommonTree ENDL42_tree=null;

		try {
			// TypeCheck.g:222:2: ( ^( PRINT expression[stypes, env] ( ENDL )? ) )
			// TypeCheck.g:222:5: ^( PRINT expression[stypes, env] ( ENDL )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PRINT40=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print654); 
			PRINT40_tree = (CommonTree)adaptor.dupNode(PRINT40);


			root_1 = (CommonTree)adaptor.becomeRoot(PRINT40_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_print656);
			expression41=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression41.getTree());

			// TypeCheck.g:222:37: ( ENDL )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ENDL) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// TypeCheck.g:222:37: ENDL
					{
					_last = (CommonTree)input.LT(1);
					ENDL42=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print659); 
					ENDL42_tree = (CommonTree)adaptor.dupNode(ENDL42);


					adaptor.addChild(root_1, ENDL42_tree);

					}
					break;

			}

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
	// $ANTLR end "print"


	public static class ret_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret"
	// TypeCheck.g:225:1: ret[StructTypes stypes, Vector<SymbolTable> env] : ( ^( RETURN retExp= expression[stypes, env] ) | RETURN );
	public final TypeCheck.ret_return ret(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.ret_return retval = new TypeCheck.ret_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree RETURN43=null;
		CommonTree RETURN44=null;
		TreeRuleReturnScope retExp =null;

		CommonTree RETURN43_tree=null;
		CommonTree RETURN44_tree=null;

		try {
			// TypeCheck.g:226:2: ( ^( RETURN retExp= expression[stypes, env] ) | RETURN )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==RETURN) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==DOWN) ) {
					alt12=1;
				}
				else if ( (LA12_1==UP||(LA12_1 >= ASSIGN && LA12_1 <= BLOCK)||LA12_1==IF||LA12_1==INVOKE||LA12_1==PRINT||LA12_1==READ||LA12_1==RETURN||LA12_1==WHILE) ) {
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
					// TypeCheck.g:226:4: ^( RETURN retExp= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					RETURN43=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret675); 
					RETURN43_tree = (CommonTree)adaptor.dupNode(RETURN43);


					root_1 = (CommonTree)adaptor.becomeRoot(RETURN43_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_ret679);
					retExp=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retExp.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								Type retType = (retExp!=null?((TypeCheck.expression_return)retExp).t:null);
								Type expType = env.get(0).get("expret");
								if(!retType.getClass().equals(expType.getClass())){
									error(0, "Expected a different return type than what was given");
								}
							
					}
					break;
				case 2 :
					// TypeCheck.g:234:5: RETURN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RETURN44=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret691); 
					RETURN44_tree = (CommonTree)adaptor.dupNode(RETURN44);


					adaptor.addChild(root_0, RETURN44_tree);


								Type retType = new VoidType();
								Type expType = env.get(0).get("expret");
								if(!retType.getClass().equals(expType.getClass())){
									error(0, "Expected a different return type than what was given");
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
	// $ANTLR end "ret"


	public static class arguments_return extends TreeRuleReturnScope {
		public Vector<Type> retArgs;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "arguments"
	// TypeCheck.g:244:1: arguments[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retArgs] : args= arg_list[stypes, env] ;
	public final TypeCheck.arguments_return arguments(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.arguments_return retval = new TypeCheck.arguments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope args =null;


		try {
			// TypeCheck.g:245:2: (args= arg_list[stypes, env] )
			// TypeCheck.g:245:4: args= arg_list[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arg_list_in_arguments714);
			args=arg_list(stypes, env);
			state._fsp--;

			adaptor.addChild(root_0, args.getTree());


						retval.retArgs = (args!=null?((TypeCheck.arg_list_return)args).argList:null);
					
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
		public Vector<Type> argList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "arg_list"
	// TypeCheck.g:251:1: arg_list[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> argList] : ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS );
	public final TypeCheck.arg_list_return arg_list(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.arg_list_return retval = new TypeCheck.arg_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ARGS45=null;
		CommonTree ARGS46=null;
		TreeRuleReturnScope exp =null;

		CommonTree ARGS45_tree=null;
		CommonTree ARGS46_tree=null;


				Vector<Type> toReturn = new Vector<Type>();
			
		try {
			// TypeCheck.g:255:2: ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS )
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
					// TypeCheck.g:255:4: ^( ARGS (exp= expression[stypes, env] )+ )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					ARGS45=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list744); 
					ARGS45_tree = (CommonTree)adaptor.dupNode(ARGS45);


					root_1 = (CommonTree)adaptor.becomeRoot(ARGS45_tree, root_1);

					match(input, Token.DOWN, null); 
					// TypeCheck.g:255:11: (exp= expression[stypes, env] )+
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
							// TypeCheck.g:255:12: exp= expression[stypes, env]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expression_in_arg_list749);
							exp=expression(stypes, env);
							state._fsp--;

							adaptor.addChild(root_1, exp.getTree());


										toReturn.add((exp!=null?((TypeCheck.expression_return)exp).t:null));
										retval.argList = toReturn;
									
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


					}
					break;
				case 2 :
					// TypeCheck.g:261:4: ARGS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ARGS46=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list765); 
					ARGS46_tree = (CommonTree)adaptor.dupNode(ARGS46);


					adaptor.addChild(root_0, ARGS46_tree);


								toReturn.add(new VoidType());
								retval.argList = toReturn;
							
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
		public Boolean hasRet = false;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditional"
	// TypeCheck.g:268:1: conditional[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) ;
	public final TypeCheck.conditional_return conditional(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.conditional_return retval = new TypeCheck.conditional_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IF47=null;
		TreeRuleReturnScope guard =null;
		TreeRuleReturnScope hasRet1 =null;
		TreeRuleReturnScope hasRet2 =null;

		CommonTree IF47_tree=null;

		try {
			// TypeCheck.g:269:2: ( ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) )
			// TypeCheck.g:269:4: ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			IF47=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional787); 
			IF47_tree = (CommonTree)adaptor.dupNode(IF47);


			root_1 = (CommonTree)adaptor.becomeRoot(IF47_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_conditional791);
			guard=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, guard.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_conditional796);
			hasRet1=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, hasRet1.getTree());

			// TypeCheck.g:269:73: (hasRet2= block[stypes, env] )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==BLOCK) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// TypeCheck.g:269:73: hasRet2= block[stypes, env]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_conditional801);
					hasRet2=block(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, hasRet2.getTree());

					}
					break;

			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						Boolean first = (hasRet1!=null?((TypeCheck.block_return)hasRet1).hasRet:null);
						Boolean second;
						if((hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:null) == null) {
							second = false;
						} else {
							second = (hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:null);
						}
						
						if(!env.get(0).get("expret").getClass().equals(VoidType.class) && ((!first && second)
							||	(first && !second))){
							error("Control flow not complete");
						} else {
							retval.hasRet = true;
						}
						if(!(guard!=null?((TypeCheck.expression_return)guard).t:null).getClass().equals(BoolType.class)) {
							error("Conditional requires a boolean guard");
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
	// $ANTLR end "conditional"


	public static class invocation_return extends TreeRuleReturnScope {
		public Type t;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "invocation"
	// TypeCheck.g:291:1: invocation[StructTypes stypes, Vector<SymbolTable> env] returns [Type t] : ^( INVOKE id= ID retArgs= arguments[stypes, env] ) ;
	public final TypeCheck.invocation_return invocation(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.invocation_return retval = new TypeCheck.invocation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree INVOKE48=null;
		TreeRuleReturnScope retArgs =null;

		CommonTree id_tree=null;
		CommonTree INVOKE48_tree=null;

		try {
			// TypeCheck.g:292:2: ( ^( INVOKE id= ID retArgs= arguments[stypes, env] ) )
			// TypeCheck.g:292:4: ^( INVOKE id= ID retArgs= arguments[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			INVOKE48=(CommonTree)match(input,INVOKE,FOLLOW_INVOKE_in_invocation826); 
			INVOKE48_tree = (CommonTree)adaptor.dupNode(INVOKE48);


			root_1 = (CommonTree)adaptor.becomeRoot(INVOKE48_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation830); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arguments_in_invocation834);
			retArgs=arguments(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, retArgs.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



					Type calledVar = lookupType((id!=null?id.getText():null), env);
					if(calledVar == null || !(calledVar instanceof FunctionType)) {
						error(0, "Can't find function with id " + (id!=null?id.getText():null)); 
					}
					FunctionType calledFunc = (FunctionType)calledVar;
					
					Vector<Type> provParams = (retArgs!=null?((TypeCheck.arguments_return)retArgs).retArgs:null);
					Vector<Type> reqParams = calledFunc.params;
					
					if(provParams.isEmpty()){
						if(!provParams.get(0).getClass().equals(VoidType.class) || provParams.size() > 1) {
							error("The provided parameters do not match those required");
						}
					} else {
						for(int i = 0; i < provParams.size(); i++) {
							if(!provParams.get(i).getClass().equals(reqParams.get(i).getClass()) 
								&& !provParams.get(i).getClass().equals(NullType.class)) {
								error("The provided parameters do not match those required");
							}
						}
					}
					
					retval.t = calledFunc.returnType;
				
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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "loop"
	// TypeCheck.g:320:1: loop[StructTypes stypes, Vector<SymbolTable> env] : ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) ;
	public final TypeCheck.loop_return loop(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.loop_return retval = new TypeCheck.loop_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree WHILE49=null;
		TreeRuleReturnScope expression50 =null;
		TreeRuleReturnScope block51 =null;
		TreeRuleReturnScope expression52 =null;

		CommonTree WHILE49_tree=null;

		try {
			// TypeCheck.g:321:2: ( ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) )
			// TypeCheck.g:321:4: ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			WHILE49=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop853); 
			WHILE49_tree = (CommonTree)adaptor.dupNode(WHILE49);


			root_1 = (CommonTree)adaptor.becomeRoot(WHILE49_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop855);
			expression50=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression50.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_loop858);
			block51=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, block51.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop861);
			expression52=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression52.getTree());

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
	// $ANTLR end "loop"


	public static class block_return extends TreeRuleReturnScope {
		public Boolean hasRet = false;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// TypeCheck.g:324:1: block[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( BLOCK retHasRet= statement_list[stypes, env] ) ;
	public final TypeCheck.block_return block(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.block_return retval = new TypeCheck.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BLOCK53=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree BLOCK53_tree=null;

		try {
			// TypeCheck.g:325:2: ( ^( BLOCK retHasRet= statement_list[stypes, env] ) )
			// TypeCheck.g:325:4: ^( BLOCK retHasRet= statement_list[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BLOCK53=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block882); 
			BLOCK53_tree = (CommonTree)adaptor.dupNode(BLOCK53);


			root_1 = (CommonTree)adaptor.becomeRoot(BLOCK53_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_block886);
			retHasRet=statement_list(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, retHasRet.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						retval.hasRet = (retHasRet!=null?((TypeCheck.statement_list_return)retHasRet).hasRet:null); 
					
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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// TypeCheck.g:331:1: assignment[StructTypes stypes, Vector<SymbolTable> env] : ^( ASSIGN expression[stypes, env] lvalue ) ;
	public final TypeCheck.assignment_return assignment(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.assignment_return retval = new TypeCheck.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASSIGN54=null;
		TreeRuleReturnScope expression55 =null;
		TreeRuleReturnScope lvalue56 =null;

		CommonTree ASSIGN54_tree=null;

		try {
			// TypeCheck.g:332:2: ( ^( ASSIGN expression[stypes, env] lvalue ) )
			// TypeCheck.g:332:4: ^( ASSIGN expression[stypes, env] lvalue )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ASSIGN54=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment906); 
			ASSIGN54_tree = (CommonTree)adaptor.dupNode(ASSIGN54);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSIGN54_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_assignment908);
			expression55=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression55.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_assignment911);
			lvalue56=lvalue();
			state._fsp--;

			adaptor.addChild(root_1, lvalue56.getTree());

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
	// $ANTLR end "assignment"


	public static class expression_return extends TreeRuleReturnScope {
		public Type t = null;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// TypeCheck.g:335:1: expression[StructTypes stypes, Vector<SymbolTable> env] returns [Type t = null] : (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | ^( NEG retType= expression[stypes,env] ) | NULL );
	public final TypeCheck.expression_return expression(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.expression_return retval = new TypeCheck.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree memberId=null;
		CommonTree idCall=null;
		CommonTree id=null;
		CommonTree set57=null;
		CommonTree set58=null;
		CommonTree set59=null;
		CommonTree set60=null;
		CommonTree NOT61=null;
		CommonTree DOT63=null;
		CommonTree INTEGER64=null;
		CommonTree TRUE65=null;
		CommonTree FALSE66=null;
		CommonTree NEW67=null;
		CommonTree NEG68=null;
		CommonTree NULL69=null;
		TreeRuleReturnScope retVal =null;
		TreeRuleReturnScope ret1 =null;
		TreeRuleReturnScope ret2 =null;
		TreeRuleReturnScope retType =null;
		TreeRuleReturnScope expression62 =null;

		CommonTree memberId_tree=null;
		CommonTree idCall_tree=null;
		CommonTree id_tree=null;
		CommonTree set57_tree=null;
		CommonTree set58_tree=null;
		CommonTree set59_tree=null;
		CommonTree set60_tree=null;
		CommonTree NOT61_tree=null;
		CommonTree DOT63_tree=null;
		CommonTree INTEGER64_tree=null;
		CommonTree TRUE65_tree=null;
		CommonTree FALSE66_tree=null;
		CommonTree NEW67_tree=null;
		CommonTree NEG68_tree=null;
		CommonTree NULL69_tree=null;

		try {
			// TypeCheck.g:336:2: (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | ^( NEG retType= expression[stypes,env] ) | NULL )
			int alt16=14;
			switch ( input.LA(1) ) {
			case INVOKE:
				{
				alt16=1;
				}
				break;
			case AND:
			case OR:
				{
				alt16=2;
				}
				break;
			case EQ:
			case GE:
			case GT:
			case LE:
			case LT:
			case NE:
				{
				alt16=3;
				}
				break;
			case MINUS:
			case PLUS:
				{
				alt16=4;
				}
				break;
			case DIVIDE:
			case TIMES:
				{
				alt16=5;
				}
				break;
			case NOT:
				{
				alt16=6;
				}
				break;
			case DOT:
				{
				alt16=7;
				}
				break;
			case ID:
				{
				alt16=8;
				}
				break;
			case INTEGER:
				{
				alt16=9;
				}
				break;
			case TRUE:
				{
				alt16=10;
				}
				break;
			case FALSE:
				{
				alt16=11;
				}
				break;
			case NEW:
				{
				alt16=12;
				}
				break;
			case NEG:
				{
				alt16=13;
				}
				break;
			case NULL:
				{
				alt16=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// TypeCheck.g:336:4: retVal= invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_expression931);
					retVal=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, retVal.getTree());


								retval.t = (retVal!=null?((TypeCheck.invocation_return)retVal).t:null);
							
					}
					break;
				case 2 :
					// TypeCheck.g:340:5: ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set57=(CommonTree)input.LT(1);
					if ( input.LA(1)==AND||input.LA(1)==OR ) {
						input.consume();
						set57_tree = (CommonTree)adaptor.dupNode(set57);


						root_1 = (CommonTree)adaptor.becomeRoot(set57_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression953);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression958);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(BoolType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(BoolType.class)) {
									error("Operators && and || require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 3 :
					// TypeCheck.g:347:5: ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set58=(CommonTree)input.LT(1);
					if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NE ) {
						input.consume();
						set58_tree = (CommonTree)adaptor.dupNode(set58);


						root_1 = (CommonTree)adaptor.becomeRoot(set58_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression997);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1002);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators ==, <, >, <=, >= require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 4 :
					// TypeCheck.g:354:5: ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set59=(CommonTree)input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						set59_tree = (CommonTree)adaptor.dupNode(set59);


						root_1 = (CommonTree)adaptor.becomeRoot(set59_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1025);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1030);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators + and - require two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 5 :
					// TypeCheck.g:361:5: ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set60=(CommonTree)input.LT(1);
					if ( input.LA(1)==DIVIDE||input.LA(1)==TIMES ) {
						input.consume();
						set60_tree = (CommonTree)adaptor.dupNode(set60);


						root_1 = (CommonTree)adaptor.becomeRoot(set60_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1053);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1058);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators * and / requires two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 6 :
					// TypeCheck.g:368:5: ^( NOT expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT61=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1071); 
					NOT61_tree = (CommonTree)adaptor.dupNode(NOT61);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT61_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1073);
					expression62=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, expression62.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operator ! requires two boolean types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 7 :
					// TypeCheck.g:375:5: ^( DOT retType= expression[stypes, env] memberId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT63=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1086); 
					DOT63_tree = (CommonTree)adaptor.dupNode(DOT63);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT63_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1092);
					retType=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retType.getTree());

					_last = (CommonTree)input.LT(1);
					memberId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1097); 
					memberId_tree = (CommonTree)adaptor.dupNode(memberId);


					adaptor.addChild(root_1, memberId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!((retType!=null?((TypeCheck.expression_return)retType).t:null) instanceof StructType)) {
									error((memberId!=null?memberId.getLine():0), "Called dot on non struct");
								}
								
								StructType structType = (StructType)(retType!=null?((TypeCheck.expression_return)retType).t:null);
								if(!structType.hasMember((memberId!=null?memberId.getText():null))) {
									System.out.println("-----");
									printSymbolTable(structType.members);
									error((memberId!=null?memberId.getLine():0), "Struct does not have member with id " + (memberId!=null?memberId.getText():null));
								} else {
									retval.t = structType.members.get((memberId!=null?memberId.getText():null));
								}
							
					}
					break;
				case 8 :
					// TypeCheck.g:390:5: idCall= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					idCall=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1110); 
					idCall_tree = (CommonTree)adaptor.dupNode(idCall);


					adaptor.addChild(root_0, idCall_tree);


								Type idType = lookupType((idCall!=null?idCall.getText():null), env);
								
								if(idType == null) {
									error((id!=null?id.getLine():0), "Invokation of type that does not exist: " + (idCall!=null?idCall.getText():null));
								} else {
									retval.t = idType;
								}
							
					}
					break;
				case 9 :
					// TypeCheck.g:400:4: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INTEGER64=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression1119); 
					INTEGER64_tree = (CommonTree)adaptor.dupNode(INTEGER64);


					adaptor.addChild(root_0, INTEGER64_tree);

					 retval.t = new IntType(); 
					}
					break;
				case 10 :
					// TypeCheck.g:401:4: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE65=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_expression1126); 
					TRUE65_tree = (CommonTree)adaptor.dupNode(TRUE65);


					adaptor.addChild(root_0, TRUE65_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 11 :
					// TypeCheck.g:402:5: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE66=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_expression1134); 
					FALSE66_tree = (CommonTree)adaptor.dupNode(FALSE66);


					adaptor.addChild(root_0, FALSE66_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 12 :
					// TypeCheck.g:403:5: ^( NEW id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEW67=(CommonTree)match(input,NEW,FOLLOW_NEW_in_expression1143); 
					NEW67_tree = (CommonTree)adaptor.dupNode(NEW67);


					root_1 = (CommonTree)adaptor.becomeRoot(NEW67_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1147); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_1, id_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


						
								if(!stypes.isDefined((id!=null?id.getText():null))) {
									error((id!=null?id.getLine():0), "Struct with type " + (id!=null?id.getText():null) + " does not exist");
								} else {
									retval.t = stypes.get((id!=null?id.getText():null));
								}
							
					}
					break;
				case 13 :
					// TypeCheck.g:411:5: ^( NEG retType= expression[stypes,env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEG68=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expression1160); 
					NEG68_tree = (CommonTree)adaptor.dupNode(NEG68);


					root_1 = (CommonTree)adaptor.becomeRoot(NEG68_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1166);
					retType=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retType.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					 retval.t = (retType!=null?((TypeCheck.expression_return)retType).t:null); 
					}
					break;
				case 14 :
					// TypeCheck.g:413:5: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL69=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression1179); 
					NULL69_tree = (CommonTree)adaptor.dupNode(NULL69);


					adaptor.addChild(root_0, NULL69_tree);


								retval.t = new NullType();
							
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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// TypeCheck.g:419:1: lvalue : ( ID | ^( DOT lvalue ID ) );
	public final TypeCheck.lvalue_return lvalue() throws RecognitionException {
		TypeCheck.lvalue_return retval = new TypeCheck.lvalue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ID70=null;
		CommonTree DOT71=null;
		CommonTree ID73=null;
		TreeRuleReturnScope lvalue72 =null;

		CommonTree ID70_tree=null;
		CommonTree DOT71_tree=null;
		CommonTree ID73_tree=null;

		try {
			// TypeCheck.g:420:2: ( ID | ^( DOT lvalue ID ) )
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
					// TypeCheck.g:420:5: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ID70=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1196); 
					ID70_tree = (CommonTree)adaptor.dupNode(ID70);


					adaptor.addChild(root_0, ID70_tree);

					}
					break;
				case 2 :
					// TypeCheck.g:421:4: ^( DOT lvalue ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT71=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalue1202); 
					DOT71_tree = (CommonTree)adaptor.dupNode(DOT71);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT71_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalue_in_lvalue1204);
					lvalue72=lvalue();
					state._fsp--;

					adaptor.addChild(root_1, lvalue72.getTree());

					_last = (CommonTree)input.LT(1);
					ID73=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1206); 
					ID73_tree = (CommonTree)adaptor.dupNode(ID73);


					adaptor.addChild(root_1, ID73_tree);

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
	// $ANTLR end "lvalue"


	public static class rettype_return extends TreeRuleReturnScope {
		public Type retType;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rettype"
	// TypeCheck.g:424:1: rettype[StructTypes stypes] returns [Type retType] : (foundType= type[stypes] | VOID );
	public final TypeCheck.rettype_return rettype(StructTypes stypes) throws RecognitionException {
		TypeCheck.rettype_return retval = new TypeCheck.rettype_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree VOID74=null;
		TreeRuleReturnScope foundType =null;

		CommonTree VOID74_tree=null;

		try {
			// TypeCheck.g:425:2: (foundType= type[stypes] | VOID )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==BOOL||LA18_0==INT||LA18_0==STRUCT) ) {
				alt18=1;
			}
			else if ( (LA18_0==VOID) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// TypeCheck.g:425:4: foundType= type[stypes]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_rettype1229);
					foundType=type(stypes);
					state._fsp--;

					adaptor.addChild(root_0, foundType.getTree());


								retval.retType = (foundType!=null?((TypeCheck.type_return)foundType).t:null);
							
					}
					break;
				case 2 :
					// TypeCheck.g:429:4: VOID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					VOID74=(CommonTree)match(input,VOID,FOLLOW_VOID_in_rettype1239); 
					VOID74_tree = (CommonTree)adaptor.dupNode(VOID74);


					adaptor.addChild(root_0, VOID74_tree);


								retval.retType = new VoidType();
							
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
		public Vector<Type> retParams;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "params"
	// TypeCheck.g:435:1: params[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retParams] : ^( PARAMS (retVal= decl[stypes, localEnv] )* ) ;
	public final TypeCheck.params_return params(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.params_return retval = new TypeCheck.params_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARAMS75=null;
		TreeRuleReturnScope retVal =null;

		CommonTree PARAMS75_tree=null;


				SymbolTable localEnv = env.get(0);
				Vector<Type> paramList = new Vector<Type>();
			
		try {
			// TypeCheck.g:440:2: ( ^( PARAMS (retVal= decl[stypes, localEnv] )* ) )
			// TypeCheck.g:440:4: ^( PARAMS (retVal= decl[stypes, localEnv] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARAMS75=(CommonTree)match(input,PARAMS,FOLLOW_PARAMS_in_params1268); 
			PARAMS75_tree = (CommonTree)adaptor.dupNode(PARAMS75);


			root_1 = (CommonTree)adaptor.becomeRoot(PARAMS75_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:440:13: (retVal= decl[stypes, localEnv] )*
				loop19:
				while (true) {
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==DECL) ) {
						alt19=1;
					}

					switch (alt19) {
					case 1 :
						// TypeCheck.g:440:14: retVal= decl[stypes, localEnv]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_params1273);
						retVal=decl(stypes, localEnv);
						state._fsp--;

						adaptor.addChild(root_1, retVal.getTree());


									paramList.add((retVal!=null?((TypeCheck.decl_return)retVal).newDec:null));
								
						}
						break;

					default :
						break loop19;
					}
				}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						retval.retParams = paramList;
					
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



	public static final BitSet FOLLOW_program_in_verify55 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_verify57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PROGRAM_in_program83 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_types_in_program85 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_declarations_in_program88 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_functions_in_program91 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types119 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_types_sub_in_types121 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_decl_in_types_sub147 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_types_sub_in_types_sub150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type_decl176 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type_decl181 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_nested_decl_in_type_decl190 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_in_nested_decl211 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_DECL_in_decl235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decl238 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decl242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_decl248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLS_in_declarations277 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_declarations279 = new BitSet(new long[]{0x0000000000001008L});
	public static final BitSet FOLLOW_decllist_in_declaration297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type324 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type332 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type336 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist358 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decllist361 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decllist365 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_id_list_in_decllist369 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_id_list393 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_FUNCS_in_functions427 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_function_in_functions429 = new BitSet(new long[]{0x0000000000200008L});
	public static final BitSet FOLLOW_FUN_in_function453 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function457 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_params_in_function461 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RETTYPE_in_function465 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rettype_in_function469 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_declarations_in_function473 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_statement_list_in_function484 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STMTS_in_statement_list511 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_statement_list515 = new BitSet(new long[]{0x04014800240000C8L});
	public static final BitSet FOLLOW_block_in_statement546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_loop_in_statement579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_invocation_in_statement589 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_in_statement598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_in_statement607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_statement618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read636 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalue_in_read638 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_print654 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_print656 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_ENDL_in_print659 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret675 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ret679 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_list_in_arguments714 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARGS_in_arg_list744 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_arg_list749 = new BitSet(new long[]{0x006005FEB3998018L});
	public static final BitSet FOLLOW_ARGS_in_arg_list765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional787 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_conditional791 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_conditional796 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_block_in_conditional801 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INVOKE_in_invocation826 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_invocation830 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_arguments_in_invocation834 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_loop853 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_loop855 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_loop858 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_loop861 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block882 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_list_in_block886 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment906 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_assignment908 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_lvalue_in_assignment911 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_invocation_in_expression931 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_expression943 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression953 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression958 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression971 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression997 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1002 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1015 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1025 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1030 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1043 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1053 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1058 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expression1071 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1073 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_expression1086 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1092 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_expression1097 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expression1110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_expression1119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expression1126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expression1134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_expression1143 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expression1147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEG_in_expression1160 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1166 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_expression1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lvalue1196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalue1202 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalue_in_lvalue1204 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalue1206 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_type_in_rettype1229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_rettype1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAMS_in_params1268 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_params1273 = new BitSet(new long[]{0x0000000000000808L});
}
