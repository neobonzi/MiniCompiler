// $ANTLR 3.5.2 TypeCheck.g 2014-06-09 16:56:26

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
	    HashMap<String, SymbolTable> envMap;
	  	SymbolTable globals;

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

	   public HashMap<String, SymbolTable> getEnvMap() {
	   		return envMap;
	   }


	public static class verify_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "verify"
	// TypeCheck.g:81:1: verify : ( program EOF |);
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
			// TypeCheck.g:82:2: ( program EOF |)
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
					// TypeCheck.g:82:4: program EOF
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
					// TypeCheck.g:83:6: 
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
	// TypeCheck.g:86:1: program : ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) ;
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
				envMap = new HashMap<String, SymbolTable>();
				globals = new SymbolTable();
				env.add(globals);
			
		try {
			// TypeCheck.g:94:4: ( ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) )
			// TypeCheck.g:94:6: ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] )
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



			   		envMap.put("globals", globals);
			   		if(lookupType("main", env) == null) {
			   			error("Main method required");
			   		}
			   		
			   		System.out.println("~~~~~~CONGRATZ U HAZ TYPE CHECKED!~~~~~~");
			   	
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
	// TypeCheck.g:105:1: types[StructTypes stypes, Vector<SymbolTable> env] : ( ^( TYPES types_sub[stypes, env] ) | TYPES );
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
			// TypeCheck.g:106:4: ( ^( TYPES types_sub[stypes, env] ) | TYPES )
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
					// TypeCheck.g:106:8: ^( TYPES types_sub[stypes, env] )
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
					// TypeCheck.g:107:8: TYPES
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
	// TypeCheck.g:110:1: types_sub[StructTypes stypes, Vector<SymbolTable> env] : ( type_decl[stypes] types_sub[stypes, env] |);
	public final TypeCheck.types_sub_return types_sub(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.types_sub_return retval = new TypeCheck.types_sub_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope type_decl10 =null;
		TreeRuleReturnScope types_sub11 =null;


		try {
			// TypeCheck.g:111:2: ( type_decl[stypes] types_sub[stypes, env] |)
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
					// TypeCheck.g:111:4: type_decl[stypes] types_sub[stypes, env]
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
					// TypeCheck.g:113:2: 
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
	// TypeCheck.g:115:1: type_decl[StructTypes stypes] : ^( STRUCT ^id= ID nested_struct_decl[stypes, newStruct] ) ;
	public final TypeCheck.type_decl_return type_decl(StructTypes stypes) throws RecognitionException {
		TypeCheck.type_decl_return retval = new TypeCheck.type_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree STRUCT12=null;
		TreeRuleReturnScope nested_struct_decl13 =null;

		CommonTree id_tree=null;
		CommonTree STRUCT12_tree=null;


				StructType newStruct;
			
		try {
			// TypeCheck.g:119:2: ( ^( STRUCT ^id= ID nested_struct_decl[stypes, newStruct] ) )
			// TypeCheck.g:119:5: ^( STRUCT ^id= ID nested_struct_decl[stypes, newStruct] )
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
			pushFollow(FOLLOW_nested_struct_decl_in_type_decl190);
			nested_struct_decl13=nested_struct_decl(stypes, newStruct);
			state._fsp--;

			adaptor.addChild(root_1, nested_struct_decl13.getTree());

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


	public static class nested_struct_decl_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_struct_decl"
	// TypeCheck.g:130:1: nested_struct_decl[StructTypes stypes, StructType newStruct] : ( struct_decl[stypes, newStruct] )+ ;
	public final TypeCheck.nested_struct_decl_return nested_struct_decl(StructTypes stypes, StructType newStruct) throws RecognitionException {
		TypeCheck.nested_struct_decl_return retval = new TypeCheck.nested_struct_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope struct_decl14 =null;


		try {
			// TypeCheck.g:131:2: ( ( struct_decl[stypes, newStruct] )+ )
			// TypeCheck.g:131:4: ( struct_decl[stypes, newStruct] )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// TypeCheck.g:131:4: ( struct_decl[stypes, newStruct] )+
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
					// TypeCheck.g:131:5: struct_decl[stypes, newStruct]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_struct_decl_in_nested_struct_decl210);
					struct_decl14=struct_decl(stypes, newStruct);
					state._fsp--;

					adaptor.addChild(root_0, struct_decl14.getTree());

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
	// $ANTLR end "nested_struct_decl"


	public static class struct_decl_return extends TreeRuleReturnScope {
		public Type newDec;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "struct_decl"
	// TypeCheck.g:134:1: struct_decl[StructTypes stypes, StructType newStruct] returns [Type newDec] : ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) ;
	public final TypeCheck.struct_decl_return struct_decl(StructTypes stypes, StructType newStruct) throws RecognitionException {
		TypeCheck.struct_decl_return retval = new TypeCheck.struct_decl_return();
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
			// TypeCheck.g:135:4: ( ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) )
			// TypeCheck.g:135:7: ^( DECL ^( TYPE retType= type[stypes] ) myId= ID )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECL15=(CommonTree)match(input,DECL,FOLLOW_DECL_in_struct_decl235); 
			DECL15_tree = (CommonTree)adaptor.dupNode(DECL15);


			root_1 = (CommonTree)adaptor.becomeRoot(DECL15_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE16=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_struct_decl238); 
			TYPE16_tree = (CommonTree)adaptor.dupNode(TYPE16);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE16_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_struct_decl242);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			myId=(CommonTree)match(input,ID,FOLLOW_ID_in_struct_decl248); 
			myId_tree = (CommonTree)adaptor.dupNode(myId);


			adaptor.addChild(root_1, myId_tree);

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



			   		newStruct.addMember((myId!=null?myId.getText():null), (retType!=null?((TypeCheck.type_return)retType).t:null));
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
	// $ANTLR end "struct_decl"


	public static class nested_decl_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "nested_decl"
	// TypeCheck.g:142:1: nested_decl[StructTypes stypes, SymbolTable structDecls] : ( decl[stypes, structDecls] )+ ;
	public final TypeCheck.nested_decl_return nested_decl(StructTypes stypes, SymbolTable structDecls) throws RecognitionException {
		TypeCheck.nested_decl_return retval = new TypeCheck.nested_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decl17 =null;


		try {
			// TypeCheck.g:143:2: ( ( decl[stypes, structDecls] )+ )
			// TypeCheck.g:143:4: ( decl[stypes, structDecls] )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// TypeCheck.g:143:4: ( decl[stypes, structDecls] )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==DECL) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// TypeCheck.g:143:4: decl[stypes, structDecls]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_decl_in_nested_decl271);
					decl17=decl(stypes, structDecls);
					state._fsp--;

					adaptor.addChild(root_0, decl17.getTree());

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
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
	// TypeCheck.g:146:1: decl[StructTypes stypes, SymbolTable localEnv] returns [Type newDec] : ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) ;
	public final TypeCheck.decl_return decl(StructTypes stypes, SymbolTable localEnv) throws RecognitionException {
		TypeCheck.decl_return retval = new TypeCheck.decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree myId=null;
		CommonTree DECL18=null;
		CommonTree TYPE19=null;
		TreeRuleReturnScope retType =null;

		CommonTree myId_tree=null;
		CommonTree DECL18_tree=null;
		CommonTree TYPE19_tree=null;

		try {
			// TypeCheck.g:147:4: ( ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) )
			// TypeCheck.g:147:7: ^( DECL ^( TYPE retType= type[stypes] ) myId= ID )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECL18=(CommonTree)match(input,DECL,FOLLOW_DECL_in_decl295); 
			DECL18_tree = (CommonTree)adaptor.dupNode(DECL18);


			root_1 = (CommonTree)adaptor.becomeRoot(DECL18_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE19=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decl298); 
			TYPE19_tree = (CommonTree)adaptor.dupNode(TYPE19);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE19_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decl302);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			myId=(CommonTree)match(input,ID,FOLLOW_ID_in_decl308); 
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
	// TypeCheck.g:154:1: declarations[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLS ( declaration[stypes, env] )* ) ;
	public final TypeCheck.declarations_return declarations(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declarations_return retval = new TypeCheck.declarations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLS20=null;
		TreeRuleReturnScope declaration21 =null;

		CommonTree DECLS20_tree=null;

		try {
			// TypeCheck.g:155:4: ( ^( DECLS ( declaration[stypes, env] )* ) )
			// TypeCheck.g:155:7: ^( DECLS ( declaration[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLS20=(CommonTree)match(input,DECLS,FOLLOW_DECLS_in_declarations337); 
			DECLS20_tree = (CommonTree)adaptor.dupNode(DECLS20);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLS20_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:155:15: ( declaration[stypes, env] )*
				loop6:
				while (true) {
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==DECLLIST) ) {
						alt6=1;
					}

					switch (alt6) {
					case 1 :
						// TypeCheck.g:155:15: declaration[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_declaration_in_declarations339);
						declaration21=declaration(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, declaration21.getTree());

						}
						break;

					default :
						break loop6;
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
	// TypeCheck.g:158:1: declaration[StructTypes stypes, Vector<SymbolTable> env] : decllist[stypes, env] ;
	public final TypeCheck.declaration_return declaration(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declaration_return retval = new TypeCheck.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decllist22 =null;


		try {
			// TypeCheck.g:159:2: ( decllist[stypes, env] )
			// TypeCheck.g:159:4: decllist[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_decllist_in_declaration357);
			decllist22=decllist(stypes, env);
			state._fsp--;

			adaptor.addChild(root_0, decllist22.getTree());

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
	// TypeCheck.g:162:1: type[StructTypes stypes] returns [Type t = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
	public final TypeCheck.type_return type(StructTypes stypes) throws RecognitionException {
		TypeCheck.type_return retval = new TypeCheck.type_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree INT23=null;
		CommonTree BOOL24=null;
		CommonTree STRUCT25=null;

		CommonTree id_tree=null;
		CommonTree INT23_tree=null;
		CommonTree BOOL24_tree=null;
		CommonTree STRUCT25_tree=null;

		try {
			// TypeCheck.g:163:2: ( INT | BOOL | ^( STRUCT id= ID ) )
			int alt7=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt7=1;
				}
				break;
			case BOOL:
				{
				alt7=2;
				}
				break;
			case STRUCT:
				{
				alt7=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// TypeCheck.g:163:5: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INT23=(CommonTree)match(input,INT,FOLLOW_INT_in_type376); 
					INT23_tree = (CommonTree)adaptor.dupNode(INT23);


					adaptor.addChild(root_0, INT23_tree);

					 retval.t = new IntType(); 
					}
					break;
				case 2 :
					// TypeCheck.g:164:5: BOOL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					BOOL24=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_type384); 
					BOOL24_tree = (CommonTree)adaptor.dupNode(BOOL24);


					adaptor.addChild(root_0, BOOL24_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 3 :
					// TypeCheck.g:165:4: ^( STRUCT id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					STRUCT25=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type392); 
					STRUCT25_tree = (CommonTree)adaptor.dupNode(STRUCT25);


					root_1 = (CommonTree)adaptor.becomeRoot(STRUCT25_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_type396); 
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
	// TypeCheck.g:175:1: decllist[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) ;
	public final TypeCheck.decllist_return decllist(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.decllist_return retval = new TypeCheck.decllist_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLLIST26=null;
		CommonTree TYPE27=null;
		TreeRuleReturnScope retType =null;
		TreeRuleReturnScope id_list28 =null;

		CommonTree DECLLIST26_tree=null;
		CommonTree TYPE27_tree=null;

		try {
			// TypeCheck.g:176:4: ( ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) )
			// TypeCheck.g:176:7: ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DECLLIST26=(CommonTree)match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist418); 
			DECLLIST26_tree = (CommonTree)adaptor.dupNode(DECLLIST26);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLLIST26_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			TYPE27=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decllist421); 
			TYPE27_tree = (CommonTree)adaptor.dupNode(TYPE27);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE27_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decllist425);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_id_list_in_decllist429);
			id_list28=id_list((retType!=null?((TypeCheck.type_return)retType).t:null), env);
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
	// TypeCheck.g:179:1: id_list[Type t, Vector<SymbolTable> env] : (id= ID )+ ;
	public final TypeCheck.id_list_return id_list(Type t, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.id_list_return retval = new TypeCheck.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;

		CommonTree id_tree=null;

		try {
			// TypeCheck.g:180:2: ( (id= ID )+ )
			// TypeCheck.g:180:4: (id= ID )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// TypeCheck.g:180:4: (id= ID )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==ID) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// TypeCheck.g:181:4: id= ID
					{
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list453); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_0, id_tree);


					   			if(env.get(0).redef((id!=null?id.getText():null))) {
					   				error((id!=null?id.getLine():0), "redefinition of variable '" + id + "'");
					   			}
					   			
									env.get(0).put((id!=null?id.getText():null), t);
					   		
					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
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
	// TypeCheck.g:192:1: functions[StructTypes stypes, Vector<SymbolTable> env] : ^( FUNCS ( function[stypes, env] )* ) ;
	public final TypeCheck.functions_return functions(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.functions_return retval = new TypeCheck.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FUNCS29=null;
		TreeRuleReturnScope function30 =null;

		CommonTree FUNCS29_tree=null;

		try {
			// TypeCheck.g:193:4: ( ^( FUNCS ( function[stypes, env] )* ) )
			// TypeCheck.g:193:6: ^( FUNCS ( function[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUNCS29=(CommonTree)match(input,FUNCS,FOLLOW_FUNCS_in_functions487); 
			FUNCS29_tree = (CommonTree)adaptor.dupNode(FUNCS29);


			root_1 = (CommonTree)adaptor.becomeRoot(FUNCS29_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:193:14: ( function[stypes, env] )*
				loop9:
				while (true) {
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==FUN) ) {
						alt9=1;
					}

					switch (alt9) {
					case 1 :
						// TypeCheck.g:193:14: function[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_function_in_functions489);
						function30=function(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, function30.getTree());

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
	// TypeCheck.g:196:1: function[StructTypes stypes, Vector<SymbolTable> env] : ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] ) ;
	public final TypeCheck.function_return function(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.function_return retval = new TypeCheck.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree FUN31=null;
		CommonTree RETTYPE32=null;
		TreeRuleReturnScope retParams =null;
		TreeRuleReturnScope rreturn =null;
		TreeRuleReturnScope sl =null;
		TreeRuleReturnScope declarations33 =null;

		CommonTree id_tree=null;
		CommonTree FUN31_tree=null;
		CommonTree RETTYPE32_tree=null;


				SymbolTable funcEnv = new SymbolTable();
				Vector<SymbolTable> localEnv = new Vector<SymbolTable>(env);
				localEnv.add(0, funcEnv);
			
		try {
			// TypeCheck.g:202:2: ( ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] ) )
			// TypeCheck.g:202:4: ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] sl= statement_list[stypes, localEnv] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			FUN31=(CommonTree)match(input,FUN,FOLLOW_FUN_in_function513); 
			FUN31_tree = (CommonTree)adaptor.dupNode(FUN31);


			root_1 = (CommonTree)adaptor.becomeRoot(FUN31_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_function517); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_params_in_function521);
			retParams=params(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, retParams.getTree());

			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			RETTYPE32=(CommonTree)match(input,RETTYPE,FOLLOW_RETTYPE_in_function525); 
			RETTYPE32_tree = (CommonTree)adaptor.dupNode(RETTYPE32);


			root_2 = (CommonTree)adaptor.becomeRoot(RETTYPE32_tree, root_2);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rettype_in_function529);
			rreturn=rettype(stypes);
			state._fsp--;

			adaptor.addChild(root_2, rreturn.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_function533);
			declarations33=declarations(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, declarations33.getTree());


						envMap.put((id!=null?id.getText():null), funcEnv);
						FunctionType func = new FunctionType((rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null), (retParams!=null?((TypeCheck.params_return)retParams).retParams:null));
						localEnv.get(1).put((id!=null?id.getText():null), func);
						localEnv.get(0).put("expret", (rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null));
					
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_function544);
			sl=statement_list(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, sl.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}



						if(!(rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null).getClass().equals(VoidType.class) && !(sl!=null?((TypeCheck.statement_list_return)sl).hasRet:null)) {
							//error("Function requires a return value");
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
	// TypeCheck.g:218:1: statement_list[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( STMTS (retHasRet= statement[stypes, env] )* ) ;
	public final TypeCheck.statement_list_return statement_list(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_list_return retval = new TypeCheck.statement_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STMTS34=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree STMTS34_tree=null;

		try {
			// TypeCheck.g:219:2: ( ^( STMTS (retHasRet= statement[stypes, env] )* ) )
			// TypeCheck.g:219:4: ^( STMTS (retHasRet= statement[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			STMTS34=(CommonTree)match(input,STMTS,FOLLOW_STMTS_in_statement_list571); 
			STMTS34_tree = (CommonTree)adaptor.dupNode(STMTS34);


			root_1 = (CommonTree)adaptor.becomeRoot(STMTS34_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:219:21: (retHasRet= statement[stypes, env] )*
				loop10:
				while (true) {
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( ((LA10_0 >= ASSIGN && LA10_0 <= BLOCK)||LA10_0==DELETE||LA10_0==IF||LA10_0==INVOKE||LA10_0==PRINT||LA10_0==READ||LA10_0==RETURN||LA10_0==WHILE) ) {
						alt10=1;
					}

					switch (alt10) {
					case 1 :
						// TypeCheck.g:219:21: retHasRet= statement[stypes, env]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_statement_list575);
						retHasRet=statement(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, retHasRet.getTree());

						}
						break;

					default :
						break loop10;
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
	// TypeCheck.g:228:1: statement[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : (blockRet= block[stypes, env] | assignment[stypes, env] |condRet= conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | read[stypes, env] | ret[stypes, env] | print[stypes, env] | delete[stypes, env] );
	public final TypeCheck.statement_return statement(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_return retval = new TypeCheck.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope blockRet =null;
		TreeRuleReturnScope condRet =null;
		TreeRuleReturnScope assignment35 =null;
		TreeRuleReturnScope loop36 =null;
		TreeRuleReturnScope invocation37 =null;
		TreeRuleReturnScope read38 =null;
		TreeRuleReturnScope ret39 =null;
		TreeRuleReturnScope print40 =null;
		TreeRuleReturnScope delete41 =null;


		try {
			// TypeCheck.g:229:4: (blockRet= block[stypes, env] | assignment[stypes, env] |condRet= conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | read[stypes, env] | ret[stypes, env] | print[stypes, env] | delete[stypes, env] )
			int alt11=9;
			switch ( input.LA(1) ) {
			case BLOCK:
				{
				alt11=1;
				}
				break;
			case ASSIGN:
				{
				alt11=2;
				}
				break;
			case IF:
				{
				alt11=3;
				}
				break;
			case WHILE:
				{
				alt11=4;
				}
				break;
			case INVOKE:
				{
				alt11=5;
				}
				break;
			case READ:
				{
				alt11=6;
				}
				break;
			case RETURN:
				{
				alt11=7;
				}
				break;
			case PRINT:
				{
				alt11=8;
				}
				break;
			case DELETE:
				{
				alt11=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// TypeCheck.g:229:6: blockRet= block[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_statement606);
					blockRet=block(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, blockRet.getTree());

					 retval.hasRet = (blockRet!=null?((TypeCheck.block_return)blockRet).hasRet:null);
					}
					break;
				case 2 :
					// TypeCheck.g:230:6: assignment[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assignment_in_statement616);
					assignment35=assignment(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, assignment35.getTree());

					}
					break;
				case 3 :
					// TypeCheck.g:231:7: condRet= conditional[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_conditional_in_statement627);
					condRet=conditional(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, condRet.getTree());

					 retval.hasRet = (condRet!=null?((TypeCheck.conditional_return)condRet).hasRet:null);
					}
					break;
				case 4 :
					// TypeCheck.g:232:7: loop[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_loop_in_statement639);
					loop36=loop(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, loop36.getTree());

					}
					break;
				case 5 :
					// TypeCheck.g:233:7: invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_statement649);
					invocation37=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, invocation37.getTree());

					}
					break;
				case 6 :
					// TypeCheck.g:234:7: read[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_read_in_statement658);
					read38=read(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, read38.getTree());

					}
					break;
				case 7 :
					// TypeCheck.g:235:7: ret[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_ret_in_statement667);
					ret39=ret(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, ret39.getTree());

					 retval.hasRet = true; 
					}
					break;
				case 8 :
					// TypeCheck.g:236:7: print[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_print_in_statement678);
					print40=print(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, print40.getTree());

					}
					break;
				case 9 :
					// TypeCheck.g:237:7: delete[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_delete_in_statement687);
					delete41=delete(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, delete41.getTree());

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
	// TypeCheck.g:240:1: read[StructTypes stypes, Vector<SymbolTable> env] : ^( READ lvalue ) ;
	public final TypeCheck.read_return read(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.read_return retval = new TypeCheck.read_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree READ42=null;
		TreeRuleReturnScope lvalue43 =null;

		CommonTree READ42_tree=null;

		try {
			// TypeCheck.g:241:2: ( ^( READ lvalue ) )
			// TypeCheck.g:241:5: ^( READ lvalue )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			READ42=(CommonTree)match(input,READ,FOLLOW_READ_in_read705); 
			READ42_tree = (CommonTree)adaptor.dupNode(READ42);


			root_1 = (CommonTree)adaptor.becomeRoot(READ42_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_read707);
			lvalue43=lvalue();
			state._fsp--;

			adaptor.addChild(root_1, lvalue43.getTree());

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
	// TypeCheck.g:244:1: print[StructTypes stypes, Vector<SymbolTable> env] : ^( PRINT expression[stypes, env] ( ENDL )? ) ;
	public final TypeCheck.print_return print(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.print_return retval = new TypeCheck.print_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PRINT44=null;
		CommonTree ENDL46=null;
		TreeRuleReturnScope expression45 =null;

		CommonTree PRINT44_tree=null;
		CommonTree ENDL46_tree=null;

		try {
			// TypeCheck.g:245:2: ( ^( PRINT expression[stypes, env] ( ENDL )? ) )
			// TypeCheck.g:245:5: ^( PRINT expression[stypes, env] ( ENDL )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PRINT44=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print723); 
			PRINT44_tree = (CommonTree)adaptor.dupNode(PRINT44);


			root_1 = (CommonTree)adaptor.becomeRoot(PRINT44_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_print725);
			expression45=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression45.getTree());

			// TypeCheck.g:245:37: ( ENDL )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==ENDL) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// TypeCheck.g:245:37: ENDL
					{
					_last = (CommonTree)input.LT(1);
					ENDL46=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print728); 
					ENDL46_tree = (CommonTree)adaptor.dupNode(ENDL46);


					adaptor.addChild(root_1, ENDL46_tree);

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


	public static class delete_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "delete"
	// TypeCheck.g:248:1: delete[StructTypes stypes, Vector<SymbolTable> env] : ^( DELETE expression[stypes, env] ) ;
	public final TypeCheck.delete_return delete(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.delete_return retval = new TypeCheck.delete_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DELETE47=null;
		TreeRuleReturnScope expression48 =null;

		CommonTree DELETE47_tree=null;

		try {
			// TypeCheck.g:249:2: ( ^( DELETE expression[stypes, env] ) )
			// TypeCheck.g:249:5: ^( DELETE expression[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			DELETE47=(CommonTree)match(input,DELETE,FOLLOW_DELETE_in_delete745); 
			DELETE47_tree = (CommonTree)adaptor.dupNode(DELETE47);


			root_1 = (CommonTree)adaptor.becomeRoot(DELETE47_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_delete747);
			expression48=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression48.getTree());

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
	// $ANTLR end "delete"


	public static class ret_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ret"
	// TypeCheck.g:252:1: ret[StructTypes stypes, Vector<SymbolTable> env] : ( ^( RETURN retExp= expression[stypes, env] ) | RETURN );
	public final TypeCheck.ret_return ret(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.ret_return retval = new TypeCheck.ret_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree RETURN49=null;
		CommonTree RETURN50=null;
		TreeRuleReturnScope retExp =null;

		CommonTree RETURN49_tree=null;
		CommonTree RETURN50_tree=null;

		try {
			// TypeCheck.g:253:2: ( ^( RETURN retExp= expression[stypes, env] ) | RETURN )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==RETURN) ) {
				int LA13_1 = input.LA(2);
				if ( (LA13_1==DOWN) ) {
					alt13=1;
				}
				else if ( (LA13_1==UP||(LA13_1 >= ASSIGN && LA13_1 <= BLOCK)||LA13_1==DELETE||LA13_1==IF||LA13_1==INVOKE||LA13_1==PRINT||LA13_1==READ||LA13_1==RETURN||LA13_1==WHILE) ) {
					alt13=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// TypeCheck.g:253:4: ^( RETURN retExp= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					RETURN49=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret763); 
					RETURN49_tree = (CommonTree)adaptor.dupNode(RETURN49);


					root_1 = (CommonTree)adaptor.becomeRoot(RETURN49_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_ret767);
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
									//error(0, "Expected a different return type than what was given");
								}
							
					}
					break;
				case 2 :
					// TypeCheck.g:261:5: RETURN
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					RETURN50=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret779); 
					RETURN50_tree = (CommonTree)adaptor.dupNode(RETURN50);


					adaptor.addChild(root_0, RETURN50_tree);


								Type retType = new VoidType();
								Type expType = env.get(0).get("expret");
								if(!retType.getClass().equals(expType.getClass())){
									//error(0, "Expected a different return type than what was given");
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
	// TypeCheck.g:271:1: arguments[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retArgs] : args= arg_list[stypes, env] ;
	public final TypeCheck.arguments_return arguments(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.arguments_return retval = new TypeCheck.arguments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope args =null;


		try {
			// TypeCheck.g:272:2: (args= arg_list[stypes, env] )
			// TypeCheck.g:272:4: args= arg_list[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arg_list_in_arguments802);
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
	// TypeCheck.g:278:1: arg_list[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> argList] : ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS );
	public final TypeCheck.arg_list_return arg_list(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.arg_list_return retval = new TypeCheck.arg_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ARGS51=null;
		CommonTree ARGS52=null;
		TreeRuleReturnScope exp =null;

		CommonTree ARGS51_tree=null;
		CommonTree ARGS52_tree=null;


				Vector<Type> toReturn = new Vector<Type>();
			
		try {
			// TypeCheck.g:282:2: ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==ARGS) ) {
				int LA15_1 = input.LA(2);
				if ( (LA15_1==DOWN) ) {
					alt15=1;
				}
				else if ( (LA15_1==UP) ) {
					alt15=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// TypeCheck.g:282:4: ^( ARGS (exp= expression[stypes, env] )+ )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					ARGS51=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list832); 
					ARGS51_tree = (CommonTree)adaptor.dupNode(ARGS51);


					root_1 = (CommonTree)adaptor.becomeRoot(ARGS51_tree, root_1);

					match(input, Token.DOWN, null); 
					// TypeCheck.g:282:11: (exp= expression[stypes, env] )+
					int cnt14=0;
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==AND||(LA14_0 >= DIVIDE && LA14_0 <= DOT)||(LA14_0 >= EQ && LA14_0 <= FALSE)||(LA14_0 >= GE && LA14_0 <= ID)||(LA14_0 >= INTEGER && LA14_0 <= INVOKE)||LA14_0==LE||(LA14_0 >= LT && LA14_0 <= OR)||LA14_0==PLUS||(LA14_0 >= TIMES && LA14_0 <= TRUE)) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// TypeCheck.g:282:12: exp= expression[stypes, env]
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expression_in_arg_list837);
							exp=expression(stypes, env);
							state._fsp--;

							adaptor.addChild(root_1, exp.getTree());


										toReturn.add((exp!=null?((TypeCheck.expression_return)exp).t:null));
										retval.argList = toReturn;
									
							}
							break;

						default :
							if ( cnt14 >= 1 ) break loop14;
							EarlyExitException eee = new EarlyExitException(14, input);
							throw eee;
						}
						cnt14++;
					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 2 :
					// TypeCheck.g:288:4: ARGS
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ARGS52=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list853); 
					ARGS52_tree = (CommonTree)adaptor.dupNode(ARGS52);


					adaptor.addChild(root_0, ARGS52_tree);


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
	// TypeCheck.g:295:1: conditional[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) ;
	public final TypeCheck.conditional_return conditional(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.conditional_return retval = new TypeCheck.conditional_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree IF53=null;
		TreeRuleReturnScope guard =null;
		TreeRuleReturnScope hasRet1 =null;
		TreeRuleReturnScope hasRet2 =null;

		CommonTree IF53_tree=null;

		try {
			// TypeCheck.g:296:2: ( ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) )
			// TypeCheck.g:296:4: ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			IF53=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional875); 
			IF53_tree = (CommonTree)adaptor.dupNode(IF53);


			root_1 = (CommonTree)adaptor.becomeRoot(IF53_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_conditional879);
			guard=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, guard.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_conditional884);
			hasRet1=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, hasRet1.getTree());

			// TypeCheck.g:296:73: (hasRet2= block[stypes, env] )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==BLOCK) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// TypeCheck.g:296:73: hasRet2= block[stypes, env]
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_conditional889);
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



			//			Boolean first = (hasRet1!=null?((TypeCheck.block_return)hasRet1).hasRet:null);
			//			Boolean second;
			//			if((hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:null) == null) {
			//				second = false;
			//			} else {
			//				second = (hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:null);
			//			}
			//			
			//			if(!env.get(0).get("expret").getClass().equals(VoidType.class) && ((!first && second)
			//				||	(first && !second))){
			//				error("Control flow not complete");
			//			} else {
			//				retval.hasRet = true;
			//			}
			//			if(!(guard!=null?((TypeCheck.expression_return)guard).t:null).getClass().equals(BoolType.class)) {
			//				error("Conditional requires a boolean guard");
			//			}
					
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
	// TypeCheck.g:318:1: invocation[StructTypes stypes, Vector<SymbolTable> env] returns [Type t] : ^( INVOKE id= ID retArgs= arguments[stypes, env] ) ;
	public final TypeCheck.invocation_return invocation(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.invocation_return retval = new TypeCheck.invocation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;
		CommonTree INVOKE54=null;
		TreeRuleReturnScope retArgs =null;

		CommonTree id_tree=null;
		CommonTree INVOKE54_tree=null;

		try {
			// TypeCheck.g:319:2: ( ^( INVOKE id= ID retArgs= arguments[stypes, env] ) )
			// TypeCheck.g:319:4: ^( INVOKE id= ID retArgs= arguments[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			INVOKE54=(CommonTree)match(input,INVOKE,FOLLOW_INVOKE_in_invocation914); 
			INVOKE54_tree = (CommonTree)adaptor.dupNode(INVOKE54);


			root_1 = (CommonTree)adaptor.becomeRoot(INVOKE54_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation918); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arguments_in_invocation922);
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
						//if(!provParams.get(0).getClass().equals(VoidType.class) || provParams.size() > 1) {
						//	error("The provided parameters do not match those required");
						//}
					} else {
						System.out.println("params not empty for " + (id!=null?id.getText():null) + " " + provParams.get(0));
						for(int i = 0; i < provParams.size(); i++) {
							//if(!provParams.get(i).getClass().equals(reqParams.get(i).getClass()) 
							//	&& !provParams.get(i).getClass().equals(NullType.class)) {
							//	error("The provided parameters do not match those required");
							//}
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
	// TypeCheck.g:347:1: loop[StructTypes stypes, Vector<SymbolTable> env] : ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) ;
	public final TypeCheck.loop_return loop(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.loop_return retval = new TypeCheck.loop_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree WHILE55=null;
		TreeRuleReturnScope expression56 =null;
		TreeRuleReturnScope block57 =null;
		TreeRuleReturnScope expression58 =null;

		CommonTree WHILE55_tree=null;

		try {
			// TypeCheck.g:348:2: ( ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) )
			// TypeCheck.g:348:4: ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			WHILE55=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop941); 
			WHILE55_tree = (CommonTree)adaptor.dupNode(WHILE55);


			root_1 = (CommonTree)adaptor.becomeRoot(WHILE55_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop943);
			expression56=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression56.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_loop946);
			block57=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, block57.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop949);
			expression58=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression58.getTree());

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
	// TypeCheck.g:351:1: block[StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false] : ^( BLOCK retHasRet= statement_list[stypes, env] ) ;
	public final TypeCheck.block_return block(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.block_return retval = new TypeCheck.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BLOCK59=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree BLOCK59_tree=null;

		try {
			// TypeCheck.g:352:2: ( ^( BLOCK retHasRet= statement_list[stypes, env] ) )
			// TypeCheck.g:352:4: ^( BLOCK retHasRet= statement_list[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			BLOCK59=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block970); 
			BLOCK59_tree = (CommonTree)adaptor.dupNode(BLOCK59);


			root_1 = (CommonTree)adaptor.becomeRoot(BLOCK59_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_block974);
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
	// TypeCheck.g:358:1: assignment[StructTypes stypes, Vector<SymbolTable> env] : ^( ASSIGN expression[stypes, env] lvalue ) ;
	public final TypeCheck.assignment_return assignment(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.assignment_return retval = new TypeCheck.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ASSIGN60=null;
		TreeRuleReturnScope expression61 =null;
		TreeRuleReturnScope lvalue62 =null;

		CommonTree ASSIGN60_tree=null;

		try {
			// TypeCheck.g:359:2: ( ^( ASSIGN expression[stypes, env] lvalue ) )
			// TypeCheck.g:359:4: ^( ASSIGN expression[stypes, env] lvalue )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			ASSIGN60=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment994); 
			ASSIGN60_tree = (CommonTree)adaptor.dupNode(ASSIGN60);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSIGN60_tree, root_1);

			match(input, Token.DOWN, null); 
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_assignment996);
			expression61=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression61.getTree());

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_assignment999);
			lvalue62=lvalue();
			state._fsp--;

			adaptor.addChild(root_1, lvalue62.getTree());

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
	// TypeCheck.g:362:1: expression[StructTypes stypes, Vector<SymbolTable> env] returns [Type t = null] : (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | ^( NEG retType= expression[stypes,env] ) | NULL );
	public final TypeCheck.expression_return expression(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.expression_return retval = new TypeCheck.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree memberId=null;
		CommonTree idCall=null;
		CommonTree id=null;
		CommonTree set63=null;
		CommonTree set64=null;
		CommonTree set65=null;
		CommonTree set66=null;
		CommonTree NOT67=null;
		CommonTree DOT69=null;
		CommonTree INTEGER70=null;
		CommonTree TRUE71=null;
		CommonTree FALSE72=null;
		CommonTree NEW73=null;
		CommonTree NEG74=null;
		CommonTree NULL75=null;
		TreeRuleReturnScope retVal =null;
		TreeRuleReturnScope ret1 =null;
		TreeRuleReturnScope ret2 =null;
		TreeRuleReturnScope retType =null;
		TreeRuleReturnScope expression68 =null;

		CommonTree memberId_tree=null;
		CommonTree idCall_tree=null;
		CommonTree id_tree=null;
		CommonTree set63_tree=null;
		CommonTree set64_tree=null;
		CommonTree set65_tree=null;
		CommonTree set66_tree=null;
		CommonTree NOT67_tree=null;
		CommonTree DOT69_tree=null;
		CommonTree INTEGER70_tree=null;
		CommonTree TRUE71_tree=null;
		CommonTree FALSE72_tree=null;
		CommonTree NEW73_tree=null;
		CommonTree NEG74_tree=null;
		CommonTree NULL75_tree=null;

		try {
			// TypeCheck.g:363:2: (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | ^( NEG retType= expression[stypes,env] ) | NULL )
			int alt17=14;
			switch ( input.LA(1) ) {
			case INVOKE:
				{
				alt17=1;
				}
				break;
			case AND:
			case OR:
				{
				alt17=2;
				}
				break;
			case EQ:
			case GE:
			case GT:
			case LE:
			case LT:
			case NE:
				{
				alt17=3;
				}
				break;
			case MINUS:
			case PLUS:
				{
				alt17=4;
				}
				break;
			case DIVIDE:
			case TIMES:
				{
				alt17=5;
				}
				break;
			case NOT:
				{
				alt17=6;
				}
				break;
			case DOT:
				{
				alt17=7;
				}
				break;
			case ID:
				{
				alt17=8;
				}
				break;
			case INTEGER:
				{
				alt17=9;
				}
				break;
			case TRUE:
				{
				alt17=10;
				}
				break;
			case FALSE:
				{
				alt17=11;
				}
				break;
			case NEW:
				{
				alt17=12;
				}
				break;
			case NEG:
				{
				alt17=13;
				}
				break;
			case NULL:
				{
				alt17=14;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// TypeCheck.g:363:4: retVal= invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_expression1019);
					retVal=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, retVal.getTree());


								retval.t = (retVal!=null?((TypeCheck.invocation_return)retVal).t:null);
							
					}
					break;
				case 2 :
					// TypeCheck.g:367:5: ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set63=(CommonTree)input.LT(1);
					if ( input.LA(1)==AND||input.LA(1)==OR ) {
						input.consume();
						set63_tree = (CommonTree)adaptor.dupNode(set63);


						root_1 = (CommonTree)adaptor.becomeRoot(set63_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1041);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1046);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(BoolType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(BoolType.class)) {
									//error("Operators && and || require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 3 :
					// TypeCheck.g:374:5: ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set64=(CommonTree)input.LT(1);
					if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NE ) {
						input.consume();
						set64_tree = (CommonTree)adaptor.dupNode(set64);


						root_1 = (CommonTree)adaptor.becomeRoot(set64_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1085);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1090);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									//error("Operators ==, <, >, <=, >= require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 4 :
					// TypeCheck.g:381:5: ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set65=(CommonTree)input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						set65_tree = (CommonTree)adaptor.dupNode(set65);


						root_1 = (CommonTree)adaptor.becomeRoot(set65_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1113);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1118);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									//error("Operators + and - require two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 5 :
					// TypeCheck.g:388:5: ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					set66=(CommonTree)input.LT(1);
					if ( input.LA(1)==DIVIDE||input.LA(1)==TIMES ) {
						input.consume();
						set66_tree = (CommonTree)adaptor.dupNode(set66);


						root_1 = (CommonTree)adaptor.becomeRoot(set66_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1141);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1146);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									//error("Operators * and / requires two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 6 :
					// TypeCheck.g:395:5: ^( NOT expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT67=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1159); 
					NOT67_tree = (CommonTree)adaptor.dupNode(NOT67);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT67_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1161);
					expression68=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, expression68.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									//error("Operator ! requires two boolean types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 7 :
					// TypeCheck.g:402:5: ^( DOT retType= expression[stypes, env] memberId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT69=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1174); 
					DOT69_tree = (CommonTree)adaptor.dupNode(DOT69);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT69_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1180);
					retType=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retType.getTree());

					_last = (CommonTree)input.LT(1);
					memberId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1185); 
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
					// TypeCheck.g:417:5: idCall= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					idCall=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1198); 
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
					// TypeCheck.g:427:4: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					INTEGER70=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression1207); 
					INTEGER70_tree = (CommonTree)adaptor.dupNode(INTEGER70);


					adaptor.addChild(root_0, INTEGER70_tree);

					 retval.t = new IntType(); 
					}
					break;
				case 10 :
					// TypeCheck.g:428:4: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					TRUE71=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_expression1214); 
					TRUE71_tree = (CommonTree)adaptor.dupNode(TRUE71);


					adaptor.addChild(root_0, TRUE71_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 11 :
					// TypeCheck.g:429:5: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					FALSE72=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_expression1222); 
					FALSE72_tree = (CommonTree)adaptor.dupNode(FALSE72);


					adaptor.addChild(root_0, FALSE72_tree);

					 retval.t = new BoolType(); 
					}
					break;
				case 12 :
					// TypeCheck.g:430:5: ^( NEW id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEW73=(CommonTree)match(input,NEW,FOLLOW_NEW_in_expression1231); 
					NEW73_tree = (CommonTree)adaptor.dupNode(NEW73);


					root_1 = (CommonTree)adaptor.becomeRoot(NEW73_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1235); 
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
					// TypeCheck.g:438:5: ^( NEG retType= expression[stypes,env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NEG74=(CommonTree)match(input,NEG,FOLLOW_NEG_in_expression1248); 
					NEG74_tree = (CommonTree)adaptor.dupNode(NEG74);


					root_1 = (CommonTree)adaptor.becomeRoot(NEG74_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1254);
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
					// TypeCheck.g:440:5: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					NULL75=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression1267); 
					NULL75_tree = (CommonTree)adaptor.dupNode(NULL75);


					adaptor.addChild(root_0, NULL75_tree);


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
	// TypeCheck.g:446:1: lvalue : ( ID | ^( DOT lvalue ID ) );
	public final TypeCheck.lvalue_return lvalue() throws RecognitionException {
		TypeCheck.lvalue_return retval = new TypeCheck.lvalue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ID76=null;
		CommonTree DOT77=null;
		CommonTree ID79=null;
		TreeRuleReturnScope lvalue78 =null;

		CommonTree ID76_tree=null;
		CommonTree DOT77_tree=null;
		CommonTree ID79_tree=null;

		try {
			// TypeCheck.g:447:2: ( ID | ^( DOT lvalue ID ) )
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
					// TypeCheck.g:447:5: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ID76=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1284); 
					ID76_tree = (CommonTree)adaptor.dupNode(ID76);


					adaptor.addChild(root_0, ID76_tree);

					}
					break;
				case 2 :
					// TypeCheck.g:448:4: ^( DOT lvalue ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					DOT77=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalue1290); 
					DOT77_tree = (CommonTree)adaptor.dupNode(DOT77);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT77_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalue_in_lvalue1292);
					lvalue78=lvalue();
					state._fsp--;

					adaptor.addChild(root_1, lvalue78.getTree());

					_last = (CommonTree)input.LT(1);
					ID79=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1294); 
					ID79_tree = (CommonTree)adaptor.dupNode(ID79);


					adaptor.addChild(root_1, ID79_tree);

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
	// TypeCheck.g:451:1: rettype[StructTypes stypes] returns [Type retType] : (foundType= type[stypes] | VOID );
	public final TypeCheck.rettype_return rettype(StructTypes stypes) throws RecognitionException {
		TypeCheck.rettype_return retval = new TypeCheck.rettype_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree VOID80=null;
		TreeRuleReturnScope foundType =null;

		CommonTree VOID80_tree=null;

		try {
			// TypeCheck.g:452:2: (foundType= type[stypes] | VOID )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==BOOL||LA19_0==INT||LA19_0==STRUCT) ) {
				alt19=1;
			}
			else if ( (LA19_0==VOID) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// TypeCheck.g:452:4: foundType= type[stypes]
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_rettype1317);
					foundType=type(stypes);
					state._fsp--;

					adaptor.addChild(root_0, foundType.getTree());


								retval.retType = (foundType!=null?((TypeCheck.type_return)foundType).t:null);
							
					}
					break;
				case 2 :
					// TypeCheck.g:456:4: VOID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					VOID80=(CommonTree)match(input,VOID,FOLLOW_VOID_in_rettype1327); 
					VOID80_tree = (CommonTree)adaptor.dupNode(VOID80);


					adaptor.addChild(root_0, VOID80_tree);


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
	// TypeCheck.g:462:1: params[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retParams] : ^( PARAMS (retVal= decl[stypes, localEnv] )* ) ;
	public final TypeCheck.params_return params(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.params_return retval = new TypeCheck.params_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARAMS81=null;
		TreeRuleReturnScope retVal =null;

		CommonTree PARAMS81_tree=null;


				SymbolTable localEnv = env.get(0);
				Vector<Type> paramList = new Vector<Type>();
			
		try {
			// TypeCheck.g:467:2: ( ^( PARAMS (retVal= decl[stypes, localEnv] )* ) )
			// TypeCheck.g:467:4: ^( PARAMS (retVal= decl[stypes, localEnv] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			PARAMS81=(CommonTree)match(input,PARAMS,FOLLOW_PARAMS_in_params1356); 
			PARAMS81_tree = (CommonTree)adaptor.dupNode(PARAMS81);


			root_1 = (CommonTree)adaptor.becomeRoot(PARAMS81_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// TypeCheck.g:467:13: (retVal= decl[stypes, localEnv] )*
				loop20:
				while (true) {
					int alt20=2;
					int LA20_0 = input.LA(1);
					if ( (LA20_0==DECL) ) {
						alt20=1;
					}

					switch (alt20) {
					case 1 :
						// TypeCheck.g:467:14: retVal= decl[stypes, localEnv]
						{
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_params1361);
						retVal=decl(stypes, localEnv);
						state._fsp--;

						adaptor.addChild(root_1, retVal.getTree());


									paramList.add((retVal!=null?((TypeCheck.decl_return)retVal).newDec:null));
								
						}
						break;

					default :
						break loop20;
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
	public static final BitSet FOLLOW_nested_struct_decl_in_type_decl190 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_struct_decl_in_nested_struct_decl210 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_DECL_in_struct_decl235 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_struct_decl238 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_struct_decl242 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_struct_decl248 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_in_nested_decl271 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_DECL_in_decl295 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decl298 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decl302 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_decl308 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLS_in_declarations337 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_declarations339 = new BitSet(new long[]{0x0000000000001008L});
	public static final BitSet FOLLOW_decllist_in_declaration357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type384 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type392 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type396 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decllist421 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decllist425 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_id_list_in_decllist429 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_id_list453 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_FUNCS_in_functions487 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_function_in_functions489 = new BitSet(new long[]{0x0000000000200008L});
	public static final BitSet FOLLOW_FUN_in_function513 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function517 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_params_in_function521 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RETTYPE_in_function525 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rettype_in_function529 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_declarations_in_function533 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_statement_list_in_function544 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STMTS_in_statement_list571 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_statement_list575 = new BitSet(new long[]{0x04014800240040C8L});
	public static final BitSet FOLLOW_block_in_statement606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_loop_in_statement639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_invocation_in_statement649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_read_in_statement658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_in_statement667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_statement678 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_in_statement687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_READ_in_read705 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalue_in_read707 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_PRINT_in_print723 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_print725 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_ENDL_in_print728 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DELETE_in_delete745 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_delete747 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret763 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ret767 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret779 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_list_in_arguments802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARGS_in_arg_list832 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_arg_list837 = new BitSet(new long[]{0x006005FEB3998018L});
	public static final BitSet FOLLOW_ARGS_in_arg_list853 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional875 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_conditional879 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_conditional884 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_block_in_conditional889 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INVOKE_in_invocation914 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_invocation918 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_arguments_in_invocation922 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_loop941 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_loop943 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_loop946 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_loop949 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block970 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_list_in_block974 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment994 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_assignment996 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_lvalue_in_assignment999 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_invocation_in_expression1019 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_expression1031 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1041 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1046 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1059 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1085 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1090 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1103 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1113 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1118 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1131 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1141 = new BitSet(new long[]{0x006005FEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1146 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expression1159 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1161 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_expression1174 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1180 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_expression1185 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expression1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_expression1207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expression1214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expression1222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_expression1231 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expression1235 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEG_in_expression1248 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1254 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_expression1267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_lvalue1284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalue1290 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalue_in_lvalue1292 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalue1294 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_type_in_rettype1317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_rettype1327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAMS_in_params1356 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_params1361 = new BitSet(new long[]{0x0000000000000808L});
}
