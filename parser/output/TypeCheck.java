// $ANTLR 3.5 /Users/jbilous/Development/CSC431/parser/TypeCheck.g 2014-04-10 21:35:22

   import java.util.Map;
   import java.util.HashMap;
   import java.util.Vector;
   import java.lang.String;
   import java.util.Iterator;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

@SuppressWarnings("all")
public class TypeCheck extends DebugTreeParser {
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


	public static final String[] ruleNames = new String[] {
		"invalidRule", "type", "types_sub", "print", "verify", "declarations", 
		"statement", "block", "nested_decl", "functions", "type_decl", "invocation", 
		"function", "arguments", "arg_list", "conditional", "id_list", "decl", 
		"expression", "program", "params", "rettype", "lvalue", "assignment", 
		"declaration", "ret", "decllist", "statement_list", "types", "loop"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false, false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public TypeCheck(TreeNodeStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public TypeCheck(TreeNodeStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,input.getTreeAdaptor());
		setDebugListener(proxy);
		setTreeNodeStream(new DebugTreeNodeStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public TypeCheck(TreeNodeStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return TypeCheck.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/jbilous/Development/CSC431/parser/TypeCheck.g"; }


		public void error(int id, String errorText) {
	   	throw new RuntimeException("Error at line " + id + ": " + errorText);
	   }
	   
	   public void error(String errorText) {
	   	throw new RuntimeException(errorText);
	   }
	   
	   public void printEnv(Vector<SymbolTable> env) {
	   	int i = 0;
	   	for(SymbolTable st : env) {
	   		System.out.println("level " + (i++ + 1));
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
	   
		public static enum Types {
	  		INT, BOOL, STRUCT
	  	}
	  
	  	public class Type {
	  		Type() {
	  		};
	  	}
	  
	  	public class StructType extends Type {
	  		public SymbolTable members;
	  		public String typeString = "TYPE";
	  		public String id;
	  		
	  		StructType(String id) {
	  			this.id = id;
	  			members = new SymbolTable();
	  		}

			StructType(String id, SymbolTable members) {
	  			this.id = id;
	  			this.members = members;
	  		}
	  		
	  		public void addMember(String id, Type value) {
	  			members.put(id, value);
	  		}
	  		
	  		public boolean hasMember(String id) {
	  			return members.symbols.containsKey(id);
	  		}
	  		public Type get(String id) {
	  			return members.get(id);
	  		}
	  	}
	  	
	  	public class FunctionType extends Type {
	  		public Type returnType;
	  		public Vector<Type> params;
	  		public String typeString = "FUNCTION";
	  		
	  		FunctionType(Type retType, Vector<Type> parameters) {
	  			returnType = retType;
	  			params = parameters;
	  		}
	  	}
	  	
	  	public class NullType extends Type {
	  		public String typeString = "NULL";
	  		
	  		NullType() {
	  		}
	  	}
	  	
	  	public class VoidType extends Type {
	  		public String typeString = "VOID";
	  		
	  		VoidType() {
	  		}
	  	}
	  
	  	public class BoolType extends Type {
	  		public String typeString = "BOOL";
			BoolType() {
			}
	  	}
	  
	  	public class IntType extends Type {
	  		public String typeString = "INT";
	  		IntType() {
	  		
	  		}
	  	}
	  	
	  	
	  	public class SymbolTable {
	  		public HashMap<String, Type> symbols;
	  		
	  		SymbolTable() {
	  			symbols = new HashMap<String, Type>();
	  		}
	  		
	  		public void put(String id, Type type) {
	  			symbols.put(id, type);
	  		}
	  		
	  		public Type get(String id) {
	  			return symbols.get(id);
	  		}
	  		
	  		public boolean redef(String id) {
	  			return symbols.containsKey(id);
	  		}
	  		
	  	}
	  	
	  	public class StructTypes {
	  		HashMap<String, Type> stypes;
	  		
	  		StructTypes() {
	  			stypes = new HashMap<String, Type>();
	  		}
	  		
	  		public boolean isDefined(String id) {
	  			return stypes.containsKey(id);
	  		}
	  		
	  		public Type get(String id) {
	  			return stypes.get(id);
	  		}
	  		
	  		public StructType put(String id, StructType aStruct) {
	  			return (StructType)stypes.put(id, aStruct);
	  		}
	  	}


	public static class verify_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "verify"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:177:1: verify : ( program EOF |);
	public final TypeCheck.verify_return verify() throws RecognitionException {
		TypeCheck.verify_return retval = new TypeCheck.verify_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree EOF2=null;
		TreeRuleReturnScope program1 =null;

		CommonTree EOF2_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "verify");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(177, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:178:2: ( program EOF |)
			int alt1=2;
			try { dbg.enterDecision(1, decisionCanBacktrack[1]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(1);}

			switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:178:4: program EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(178,4);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_program_in_verify55);
					program1=program();
					state._fsp--;

					adaptor.addChild(root_0, program1.getTree());
					dbg.location(178,12);
					_last = (CommonTree)input.LT(1);
					EOF2=(CommonTree)match(input,EOF,FOLLOW_EOF_in_verify57); 
					EOF2_tree = (CommonTree)adaptor.dupNode(EOF2);


					adaptor.addChild(root_0, EOF2_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:179:6: 
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(179,6);
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
		dbg.location(180, 0);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "verify");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:182:1: program : ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) ;
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


				StructTypes stypes = new StructTypes();
				Vector<SymbolTable> env = new Vector<SymbolTable>();
				env.add(new SymbolTable());
			
		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(182, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:188:4: ( ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:188:6: ^( PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(188,6);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(188,8);
			_last = (CommonTree)input.LT(1);
			PROGRAM3=(CommonTree)match(input,PROGRAM,FOLLOW_PROGRAM_in_program83); 
			PROGRAM3_tree = (CommonTree)adaptor.dupNode(PROGRAM3);


			root_1 = (CommonTree)adaptor.becomeRoot(PROGRAM3_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(188,16);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_types_in_program85);
			types4=types(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, types4.getTree());
			dbg.location(188,35);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_program88);
			declarations5=declarations(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, declarations5.getTree());
			dbg.location(188,61);
			System.out.println("Entering functions");dbg.location(188,105);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_functions_in_program93);
			functions6=functions(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, functions6.getTree());

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
		dbg.location(189, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:191:1: types[StructTypes stypes, Vector<SymbolTable> env] : ( ^( TYPES types_sub[stypes, env] ) | TYPES );
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

		try { dbg.enterRule(getGrammarFileName(), "types");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(191, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:192:4: ( ^( TYPES types_sub[stypes, env] ) | TYPES )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

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
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:192:8: ^( TYPES types_sub[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(192,8);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(192,10);
					_last = (CommonTree)input.LT(1);
					TYPES7=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types115); 
					TYPES7_tree = (CommonTree)adaptor.dupNode(TYPES7);


					root_1 = (CommonTree)adaptor.becomeRoot(TYPES7_tree, root_1);

					if ( input.LA(1)==Token.DOWN ) {
						match(input, Token.DOWN, null); 
						dbg.location(192,16);
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_types_sub_in_types117);
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
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:193:8: TYPES
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(193,8);
					_last = (CommonTree)input.LT(1);
					TYPES9=(CommonTree)match(input,TYPES,FOLLOW_TYPES_in_types128); 
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
		dbg.location(194, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "types");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:196:1: types_sub[StructTypes stypes, Vector<SymbolTable> env] : ( type_decl[stypes] types_sub[stypes, env] |);
	public final TypeCheck.types_sub_return types_sub(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.types_sub_return retval = new TypeCheck.types_sub_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope type_decl10 =null;
		TreeRuleReturnScope types_sub11 =null;


		try { dbg.enterRule(getGrammarFileName(), "types_sub");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(196, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:197:2: ( type_decl[stypes] types_sub[stypes, env] |)
			int alt3=2;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:197:4: type_decl[stypes] types_sub[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(197,4);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_decl_in_types_sub143);
					type_decl10=type_decl(stypes);
					state._fsp--;

					adaptor.addChild(root_0, type_decl10.getTree());
					dbg.location(197,22);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_types_sub_in_types_sub146);
					types_sub11=types_sub(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, types_sub11.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:199:2: 
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
		dbg.location(199, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "types_sub");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:201:1: type_decl[StructTypes stypes] : ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] ) ;
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
			
		try { dbg.enterRule(getGrammarFileName(), "type_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(201, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:205:2: ( ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:205:5: ^( STRUCT ^id= ID nested_decl[stypes, newStruct.members] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(205,5);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(205,13);
			_last = (CommonTree)input.LT(1);
			STRUCT12=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type_decl172); 
			STRUCT12_tree = (CommonTree)adaptor.dupNode(STRUCT12);


			root_1 = (CommonTree)adaptor.becomeRoot(STRUCT12_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(205,17);
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_type_decl177); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);
			dbg.location(206,3);

						newStruct = new StructType((id!=null?id.getText():null));
						stypes.put((id!=null?id.getText():null), newStruct);
					dbg.location(210,3);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_nested_decl_in_type_decl186);
			nested_decl13=nested_decl(stypes, newStruct.members);
			state._fsp--;

			adaptor.addChild(root_1, nested_decl13.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(211,3);

						System.out.println("Filled out struct so heres its shit:");
						StructType myStruct = (StructType)stypes.get((id!=null?id.getText():null));
						printSymbolTable(myStruct.members);
					
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
		dbg.location(216, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type_decl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:218:1: nested_decl[StructTypes stypes, SymbolTable structDecls] : ( decl[stypes, structDecls] )+ ;
	public final TypeCheck.nested_decl_return nested_decl(StructTypes stypes, SymbolTable structDecls) throws RecognitionException {
		TypeCheck.nested_decl_return retval = new TypeCheck.nested_decl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decl14 =null;


		try { dbg.enterRule(getGrammarFileName(), "nested_decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(218, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:219:2: ( ( decl[stypes, structDecls] )+ )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:219:4: ( decl[stypes, structDecls] )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(219,4);
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:219:4: ( decl[stypes, structDecls] )+
			int cnt4=0;
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==DECL) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:219:4: decl[stypes, structDecls]
					{
					dbg.location(219,4);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_decl_in_nested_decl207);
					decl14=decl(stypes, structDecls);
					state._fsp--;

					adaptor.addChild(root_0, decl14.getTree());

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt4++;
			}
			} finally {dbg.exitSubRule(4);}

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
		dbg.location(220, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "nested_decl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:222:1: decl[StructTypes stypes, SymbolTable localEnv] returns [Type newDec] : ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "decl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(222, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:223:4: ( ^( DECL ^( TYPE retType= type[stypes] ) myId= ID ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:223:7: ^( DECL ^( TYPE retType= type[stypes] ) myId= ID )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(223,7);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(223,9);
			_last = (CommonTree)input.LT(1);
			DECL15=(CommonTree)match(input,DECL,FOLLOW_DECL_in_decl231); 
			DECL15_tree = (CommonTree)adaptor.dupNode(DECL15);


			root_1 = (CommonTree)adaptor.becomeRoot(DECL15_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(223,14);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			dbg.location(223,16);
			_last = (CommonTree)input.LT(1);
			TYPE16=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decl234); 
			TYPE16_tree = (CommonTree)adaptor.dupNode(TYPE16);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE16_tree, root_2);

			match(input, Token.DOWN, null); 
			dbg.location(223,28);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decl238);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}

			dbg.location(223,47);
			_last = (CommonTree)input.LT(1);
			myId=(CommonTree)match(input,ID,FOLLOW_ID_in_decl244); 
			myId_tree = (CommonTree)adaptor.dupNode(myId);


			adaptor.addChild(root_1, myId_tree);

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(224,5);

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
		dbg.location(228, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "decl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:230:1: declarations[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLS ( declaration[stypes, env] )* ) ;
	public final TypeCheck.declarations_return declarations(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declarations_return retval = new TypeCheck.declarations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DECLS17=null;
		TreeRuleReturnScope declaration18 =null;

		CommonTree DECLS17_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "declarations");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(230, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:231:4: ( ^( DECLS ( declaration[stypes, env] )* ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:231:7: ^( DECLS ( declaration[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(231,7);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(231,9);
			_last = (CommonTree)input.LT(1);
			DECLS17=(CommonTree)match(input,DECLS,FOLLOW_DECLS_in_declarations273); 
			DECLS17_tree = (CommonTree)adaptor.dupNode(DECLS17);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLS17_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				dbg.location(231,15);
				// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:231:15: ( declaration[stypes, env] )*
				try { dbg.enterSubRule(5);

				loop5:
				while (true) {
					int alt5=2;
					try { dbg.enterDecision(5, decisionCanBacktrack[5]);

					int LA5_0 = input.LA(1);
					if ( (LA5_0==DECLLIST) ) {
						alt5=1;
					}

					} finally {dbg.exitDecision(5);}

					switch (alt5) {
					case 1 :
						dbg.enterAlt(1);

						// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:231:15: declaration[stypes, env]
						{
						dbg.location(231,15);
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_declaration_in_declarations275);
						declaration18=declaration(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, declaration18.getTree());

						}
						break;

					default :
						break loop5;
					}
				}
				} finally {dbg.exitSubRule(5);}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(231,42);
			 System.out.println("Found decls"); 
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
		dbg.location(232, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declarations");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:234:1: declaration[StructTypes stypes, Vector<SymbolTable> env] : decllist[stypes, env] ;
	public final TypeCheck.declaration_return declaration(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.declaration_return retval = new TypeCheck.declaration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope decllist19 =null;


		try { dbg.enterRule(getGrammarFileName(), "declaration");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(234, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:235:2: ( decllist[stypes, env] )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:235:4: decllist[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(235,4);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_decllist_in_declaration295);
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
		dbg.location(236, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "declaration");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:238:1: type[StructTypes stypes] returns [Type t = null] : ( INT | BOOL | ^( STRUCT id= ID ) );
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

		try { dbg.enterRule(getGrammarFileName(), "type");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(238, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:239:2: ( INT | BOOL | ^( STRUCT id= ID ) )
			int alt6=3;
			try { dbg.enterDecision(6, decisionCanBacktrack[6]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(6);}

			switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:239:5: INT
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(239,5);
					_last = (CommonTree)input.LT(1);
					INT20=(CommonTree)match(input,INT,FOLLOW_INT_in_type314); 
					INT20_tree = (CommonTree)adaptor.dupNode(INT20);


					adaptor.addChild(root_0, INT20_tree);
					dbg.location(239,9);
					 retval.t = new IntType(); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:240:5: BOOL
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(240,5);
					_last = (CommonTree)input.LT(1);
					BOOL21=(CommonTree)match(input,BOOL,FOLLOW_BOOL_in_type322); 
					BOOL21_tree = (CommonTree)adaptor.dupNode(BOOL21);


					adaptor.addChild(root_0, BOOL21_tree);
					dbg.location(240,10);
					 retval.t = new BoolType(); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:241:4: ^( STRUCT id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(241,4);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(241,6);
					_last = (CommonTree)input.LT(1);
					STRUCT22=(CommonTree)match(input,STRUCT,FOLLOW_STRUCT_in_type330); 
					STRUCT22_tree = (CommonTree)adaptor.dupNode(STRUCT22);


					root_1 = (CommonTree)adaptor.becomeRoot(STRUCT22_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(241,15);
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_type334); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_1, id_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(242,3);

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
		dbg.location(249, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "type");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:251:1: decllist[StructTypes stypes, Vector<SymbolTable> env] : ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "decllist");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(251, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:252:4: ( ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:252:7: ^( DECLLIST ^( TYPE retType= type[stypes] ) id_list[$retType.t, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(252,7);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(252,9);
			_last = (CommonTree)input.LT(1);
			DECLLIST23=(CommonTree)match(input,DECLLIST,FOLLOW_DECLLIST_in_decllist356); 
			DECLLIST23_tree = (CommonTree)adaptor.dupNode(DECLLIST23);


			root_1 = (CommonTree)adaptor.becomeRoot(DECLLIST23_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(252,18);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			dbg.location(252,20);
			_last = (CommonTree)input.LT(1);
			TYPE24=(CommonTree)match(input,TYPE,FOLLOW_TYPE_in_decllist359); 
			TYPE24_tree = (CommonTree)adaptor.dupNode(TYPE24);


			root_2 = (CommonTree)adaptor.becomeRoot(TYPE24_tree, root_2);

			match(input, Token.DOWN, null); 
			dbg.location(252,32);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_type_in_decllist363);
			retType=type(stypes);
			state._fsp--;

			adaptor.addChild(root_2, retType.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}

			dbg.location(252,47);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_id_list_in_decllist367);
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
		dbg.location(253, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "decllist");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:255:1: id_list[Type t, Vector<SymbolTable> env] : (id= ID )+ ;
	public final TypeCheck.id_list_return id_list(Type t, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.id_list_return retval = new TypeCheck.id_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree id=null;

		CommonTree id_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "id_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(255, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:256:2: ( (id= ID )+ )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:256:4: (id= ID )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(256,4);
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:256:4: (id= ID )+
			int cnt7=0;
			try { dbg.enterSubRule(7);

			loop7:
			while (true) {
				int alt7=2;
				try { dbg.enterDecision(7, decisionCanBacktrack[7]);

				int LA7_0 = input.LA(1);
				if ( (LA7_0==ID) ) {
					alt7=1;
				}

				} finally {dbg.exitDecision(7);}

				switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:257:4: id= ID
					{
					dbg.location(257,6);
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_id_list391); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_0, id_tree);
					dbg.location(258,6);

					   			if(env.get(0).redef((id!=null?id.getText():null))) {
					   				error((id!=null?id.getLine():0), "redefinition of variable '" + id + "'");
					   			}
					   			
									env.get(0).put((id!=null?id.getText():null), t);
					   		
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt7++;
			}
			} finally {dbg.exitSubRule(7);}

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
		dbg.location(266, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "id_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:268:1: functions[StructTypes stypes, Vector<SymbolTable> env] : ^( FUNCS ( function[stypes, env] )* ) ;
	public final TypeCheck.functions_return functions(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.functions_return retval = new TypeCheck.functions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree FUNCS26=null;
		TreeRuleReturnScope function27 =null;

		CommonTree FUNCS26_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "functions");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(268, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:269:4: ( ^( FUNCS ( function[stypes, env] )* ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:269:6: ^( FUNCS ( function[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(269,6);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(269,8);
			_last = (CommonTree)input.LT(1);
			FUNCS26=(CommonTree)match(input,FUNCS,FOLLOW_FUNCS_in_functions425); 
			FUNCS26_tree = (CommonTree)adaptor.dupNode(FUNCS26);


			root_1 = (CommonTree)adaptor.becomeRoot(FUNCS26_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				dbg.location(269,14);
				// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:269:14: ( function[stypes, env] )*
				try { dbg.enterSubRule(8);

				loop8:
				while (true) {
					int alt8=2;
					try { dbg.enterDecision(8, decisionCanBacktrack[8]);

					int LA8_0 = input.LA(1);
					if ( (LA8_0==FUN) ) {
						alt8=1;
					}

					} finally {dbg.exitDecision(8);}

					switch (alt8) {
					case 1 :
						dbg.enterAlt(1);

						// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:269:14: function[stypes, env]
						{
						dbg.location(269,14);
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_function_in_functions427);
						function27=function(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, function27.getTree());

						}
						break;

					default :
						break loop8;
					}
				}
				} finally {dbg.exitSubRule(8);}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(270,5);
			 System.out.println("Found functions"); 
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
		dbg.location(271, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "functions");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:273:1: function[StructTypes stypes, Vector<SymbolTable> env] : ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] statement_list[stypes, localEnv] ) ;
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
		TreeRuleReturnScope declarations30 =null;
		TreeRuleReturnScope statement_list31 =null;

		CommonTree id_tree=null;
		CommonTree FUN28_tree=null;
		CommonTree RETTYPE29_tree=null;


				SymbolTable funcEnv = new SymbolTable();
				Vector<SymbolTable> localEnv = new Vector<SymbolTable>(env);
				localEnv.add(0, funcEnv);
			
		try { dbg.enterRule(getGrammarFileName(), "function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(273, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:279:2: ( ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] statement_list[stypes, localEnv] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:279:4: ^( FUN id= ID retParams= params[stypes, localEnv] ^( RETTYPE rreturn= rettype[stypes] ) declarations[stypes, localEnv] statement_list[stypes, localEnv] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(279,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(279,6);
			_last = (CommonTree)input.LT(1);
			FUN28=(CommonTree)match(input,FUN,FOLLOW_FUN_in_function457); 
			FUN28_tree = (CommonTree)adaptor.dupNode(FUN28);


			root_1 = (CommonTree)adaptor.becomeRoot(FUN28_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(279,12);
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_function461); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);
			dbg.location(279,25);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_params_in_function465);
			retParams=params(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, retParams.getTree());
			dbg.location(279,51);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_2 = _last;
			CommonTree _first_2 = null;
			CommonTree root_2 = (CommonTree)adaptor.nil();
			dbg.location(279,53);
			_last = (CommonTree)input.LT(1);
			RETTYPE29=(CommonTree)match(input,RETTYPE,FOLLOW_RETTYPE_in_function469); 
			RETTYPE29_tree = (CommonTree)adaptor.dupNode(RETTYPE29);


			root_2 = (CommonTree)adaptor.becomeRoot(RETTYPE29_tree, root_2);

			match(input, Token.DOWN, null); 
			dbg.location(279,68);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_rettype_in_function473);
			rreturn=rettype(stypes);
			state._fsp--;

			adaptor.addChild(root_2, rreturn.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_1, root_2);
			_last = _save_last_2;
			}

			dbg.location(279,86);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_declarations_in_function477);
			declarations30=declarations(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, declarations30.getTree());
			dbg.location(280,3);

						FunctionType func = new FunctionType((rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null), (retParams!=null?((TypeCheck.params_return)retParams).retParams:null));
						localEnv.get(1).put((id!=null?id.getText():null), func);
						localEnv.get(0).put("expret", (rreturn!=null?((TypeCheck.rettype_return)rreturn).retType:null));
					dbg.location(285,3);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_function486);
			statement_list31=statement_list(stypes, localEnv);
			state._fsp--;

			adaptor.addChild(root_1, statement_list31.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(286,3);

						
					
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
		dbg.location(290, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "function"


	public static class statement_list_return extends TreeRuleReturnScope {
		public boolean hasRet;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement_list"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:292:1: statement_list[StructTypes stypes, Vector<SymbolTable> env] returns [boolean hasRet] : ^( STMTS (retHasRet= statement[stypes, env] )* ) ;
	public final TypeCheck.statement_list_return statement_list(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_list_return retval = new TypeCheck.statement_list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree STMTS32=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree STMTS32_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "statement_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(292, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:293:2: ( ^( STMTS (retHasRet= statement[stypes, env] )* ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:293:4: ^( STMTS (retHasRet= statement[stypes, env] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(293,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(293,6);
			_last = (CommonTree)input.LT(1);
			STMTS32=(CommonTree)match(input,STMTS,FOLLOW_STMTS_in_statement_list513); 
			STMTS32_tree = (CommonTree)adaptor.dupNode(STMTS32);


			root_1 = (CommonTree)adaptor.becomeRoot(STMTS32_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				dbg.location(293,21);
				// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:293:21: (retHasRet= statement[stypes, env] )*
				try { dbg.enterSubRule(9);

				loop9:
				while (true) {
					int alt9=2;
					try { dbg.enterDecision(9, decisionCanBacktrack[9]);

					int LA9_0 = input.LA(1);
					if ( ((LA9_0 >= ASSIGN && LA9_0 <= BLOCK)||LA9_0==IF||LA9_0==INVOKE||LA9_0==PRINT||LA9_0==RETURN||LA9_0==WHILE) ) {
						alt9=1;
					}

					} finally {dbg.exitDecision(9);}

					switch (alt9) {
					case 1 :
						dbg.enterAlt(1);

						// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:293:21: retHasRet= statement[stypes, env]
						{
						dbg.location(293,21);
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_statement_in_statement_list517);
						retHasRet=statement(stypes, env);
						state._fsp--;

						adaptor.addChild(root_1, retHasRet.getTree());

						}
						break;

					default :
						break loop9;
					}
				}
				} finally {dbg.exitSubRule(9);}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(293,47);
			 retval.hasRet = (retHasRet!=null?((TypeCheck.statement_return)retHasRet).hasRet:false); 
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
		dbg.location(294, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "statement_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "statement_list"


	public static class statement_return extends TreeRuleReturnScope {
		public boolean hasRet = false;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:297:1: statement[StructTypes stypes, Vector<SymbolTable> env] returns [boolean hasRet = false] : ( block[stypes, env] | assignment[stypes, env] | conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | ret[stypes, env] | print[stypes, env] );
	public final TypeCheck.statement_return statement(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.statement_return retval = new TypeCheck.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope block33 =null;
		TreeRuleReturnScope assignment34 =null;
		TreeRuleReturnScope conditional35 =null;
		TreeRuleReturnScope loop36 =null;
		TreeRuleReturnScope invocation37 =null;
		TreeRuleReturnScope ret38 =null;
		TreeRuleReturnScope print39 =null;


		try { dbg.enterRule(getGrammarFileName(), "statement");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(297, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:298:4: ( block[stypes, env] | assignment[stypes, env] | conditional[stypes, env] | loop[stypes, env] | invocation[stypes, env] | ret[stypes, env] | print[stypes, env] )
			int alt10=7;
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

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
			case PRINT:
				{
				alt10=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:298:6: block[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(298,6);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_statement543);
					block33=block(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, block33.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:299:6: assignment[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(299,6);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_assignment_in_statement551);
					assignment34=assignment(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, assignment34.getTree());

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:300:7: conditional[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(300,7);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_conditional_in_statement560);
					conditional35=conditional(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, conditional35.getTree());

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:301:7: loop[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(301,7);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_loop_in_statement569);
					loop36=loop(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, loop36.getTree());

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:302:6: invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(302,6);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_statement577);
					invocation37=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, invocation37.getTree());

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:303:7: ret[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(303,7);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_ret_in_statement586);
					ret38=ret(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, ret38.getTree());
					dbg.location(303,24);
					 retval.hasRet = true; 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:304:7: print[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(304,7);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_print_in_statement597);
					print39=print(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, print39.getTree());

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
		dbg.location(305, 3);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "statement");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "statement"


	public static class print_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "print"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:307:1: print[StructTypes stypes, Vector<SymbolTable> env] : ^( PRINT expression[stypes, env] ( ENDL )? ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "print");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(307, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:308:2: ( ^( PRINT expression[stypes, env] ( ENDL )? ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:308:5: ^( PRINT expression[stypes, env] ( ENDL )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(308,5);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(308,7);
			_last = (CommonTree)input.LT(1);
			PRINT40=(CommonTree)match(input,PRINT,FOLLOW_PRINT_in_print615); 
			PRINT40_tree = (CommonTree)adaptor.dupNode(PRINT40);


			root_1 = (CommonTree)adaptor.becomeRoot(PRINT40_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(308,13);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_print617);
			expression41=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression41.getTree());
			dbg.location(308,37);
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:308:37: ( ENDL )?
			int alt11=2;
			try { dbg.enterSubRule(11);
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			int LA11_0 = input.LA(1);
			if ( (LA11_0==ENDL) ) {
				alt11=1;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:308:37: ENDL
					{
					dbg.location(308,37);
					_last = (CommonTree)input.LT(1);
					ENDL42=(CommonTree)match(input,ENDL,FOLLOW_ENDL_in_print620); 
					ENDL42_tree = (CommonTree)adaptor.dupNode(ENDL42);


					adaptor.addChild(root_1, ENDL42_tree);

					}
					break;

			}
			} finally {dbg.exitSubRule(11);}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(308,44);
			 System.out.println("Found print"); 
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
		dbg.location(309, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "print");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:311:1: ret[StructTypes stypes, Vector<SymbolTable> env] : ( ^( RETURN retExp= expression[stypes, env] ) | RETURN );
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

		try { dbg.enterRule(getGrammarFileName(), "ret");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(311, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:312:2: ( ^( RETURN retExp= expression[stypes, env] ) | RETURN )
			int alt12=2;
			try { dbg.enterDecision(12, decisionCanBacktrack[12]);

			int LA12_0 = input.LA(1);
			if ( (LA12_0==RETURN) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==DOWN) ) {
					alt12=1;
				}
				else if ( (LA12_1==UP||(LA12_1 >= ASSIGN && LA12_1 <= BLOCK)||LA12_1==IF||LA12_1==INVOKE||LA12_1==PRINT||LA12_1==RETURN||LA12_1==WHILE) ) {
					alt12=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(12);}

			switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:312:4: ^( RETURN retExp= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(312,4);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(312,6);
					_last = (CommonTree)input.LT(1);
					RETURN43=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret638); 
					RETURN43_tree = (CommonTree)adaptor.dupNode(RETURN43);


					root_1 = (CommonTree)adaptor.becomeRoot(RETURN43_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(312,19);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_ret642);
					retExp=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retExp.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(313,3);

								Type retType = (retExp!=null?((TypeCheck.expression_return)retExp).t:null);
								Type expType = env.get(0).get("expret");
								if(!retType.getClass().equals(expType.getClass())){
									error(0, "Expected a different return type than what was given");
								}
							
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:320:5: RETURN
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(320,5);
					_last = (CommonTree)input.LT(1);
					RETURN44=(CommonTree)match(input,RETURN,FOLLOW_RETURN_in_ret654); 
					RETURN44_tree = (CommonTree)adaptor.dupNode(RETURN44);


					adaptor.addChild(root_0, RETURN44_tree);
					dbg.location(321,3);

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
		dbg.location(328, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "ret");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:330:1: arguments[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retArgs] :args= arg_list[stypes, env] ;
	public final TypeCheck.arguments_return arguments(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.arguments_return retval = new TypeCheck.arguments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope args =null;


		try { dbg.enterRule(getGrammarFileName(), "arguments");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(330, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:331:2: (args= arg_list[stypes, env] )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:331:4: args= arg_list[stypes, env]
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(331,4);
			System.out.println("arguments");dbg.location(331,43);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arg_list_in_arguments679);
			args=arg_list(stypes, env);
			state._fsp--;

			adaptor.addChild(root_0, args.getTree());
			dbg.location(332,3);

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
		dbg.location(335, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arguments");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:337:1: arg_list[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> argList] : ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS );
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
			
		try { dbg.enterRule(getGrammarFileName(), "arg_list");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(337, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:341:2: ( ^( ARGS (exp= expression[stypes, env] )+ ) | ARGS )
			int alt14=2;
			try { dbg.enterDecision(14, decisionCanBacktrack[14]);

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
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(14);}

			switch (alt14) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:341:4: ^( ARGS (exp= expression[stypes, env] )+ )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(341,4);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(341,6);
					_last = (CommonTree)input.LT(1);
					ARGS45=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list709); 
					ARGS45_tree = (CommonTree)adaptor.dupNode(ARGS45);


					root_1 = (CommonTree)adaptor.becomeRoot(ARGS45_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(341,11);
					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:341:11: (exp= expression[stypes, env] )+
					int cnt13=0;
					try { dbg.enterSubRule(13);

					loop13:
					while (true) {
						int alt13=2;
						try { dbg.enterDecision(13, decisionCanBacktrack[13]);

						int LA13_0 = input.LA(1);
						if ( (LA13_0==AND||(LA13_0 >= DIVIDE && LA13_0 <= DOT)||(LA13_0 >= EQ && LA13_0 <= FALSE)||(LA13_0 >= GE && LA13_0 <= ID)||(LA13_0 >= INTEGER && LA13_0 <= INVOKE)||LA13_0==LE||(LA13_0 >= LT && LA13_0 <= NE)||(LA13_0 >= NEW && LA13_0 <= OR)||LA13_0==PLUS||(LA13_0 >= TIMES && LA13_0 <= TRUE)) ) {
							alt13=1;
						}

						} finally {dbg.exitDecision(13);}

						switch (alt13) {
						case 1 :
							dbg.enterAlt(1);

							// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:341:12: exp= expression[stypes, env]
							{
							dbg.location(341,15);
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_expression_in_arg_list714);
							exp=expression(stypes, env);
							state._fsp--;

							adaptor.addChild(root_1, exp.getTree());
							dbg.location(342,3);

										toReturn.add((exp!=null?((TypeCheck.expression_return)exp).t:null));
										retval.argList = toReturn;
									
							}
							break;

						default :
							if ( cnt13 >= 1 ) break loop13;
							EarlyExitException eee = new EarlyExitException(13, input);
							dbg.recognitionException(eee);

							throw eee;
						}
						cnt13++;
					}
					} finally {dbg.exitSubRule(13);}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:347:4: ARGS
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(347,4);
					_last = (CommonTree)input.LT(1);
					ARGS46=(CommonTree)match(input,ARGS,FOLLOW_ARGS_in_arg_list730); 
					ARGS46_tree = (CommonTree)adaptor.dupNode(ARGS46);


					adaptor.addChild(root_0, ARGS46_tree);
					dbg.location(348,3);

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
		dbg.location(352, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "arg_list");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "arg_list"


	public static class conditional_return extends TreeRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditional"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:354:1: conditional[StructTypes stypes, Vector<SymbolTable> env] : ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "conditional");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(354, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:355:2: ( ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:355:4: ^( IF guard= expression[stypes, env] hasRet1= block[stypes, env] (hasRet2= block[stypes, env] )? )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(355,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(355,6);
			_last = (CommonTree)input.LT(1);
			IF47=(CommonTree)match(input,IF,FOLLOW_IF_in_conditional748); 
			IF47_tree = (CommonTree)adaptor.dupNode(IF47);


			root_1 = (CommonTree)adaptor.becomeRoot(IF47_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(355,14);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_conditional752);
			guard=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, guard.getTree());
			dbg.location(355,46);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_conditional757);
			hasRet1=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, hasRet1.getTree());
			dbg.location(355,73);
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:355:73: (hasRet2= block[stypes, env] )?
			int alt15=2;
			try { dbg.enterSubRule(15);
			try { dbg.enterDecision(15, decisionCanBacktrack[15]);

			int LA15_0 = input.LA(1);
			if ( (LA15_0==BLOCK) ) {
				alt15=1;
			}
			} finally {dbg.exitDecision(15);}

			switch (alt15) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:355:73: hasRet2= block[stypes, env]
					{
					dbg.location(355,73);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_block_in_conditional762);
					hasRet2=block(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, hasRet2.getTree());

					}
					break;

			}
			} finally {dbg.exitSubRule(15);}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(356,3);

						if(!(((hasRet1!=null?((TypeCheck.block_return)hasRet1).hasRet:false) && (hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:false)) || (!(hasRet1!=null?((TypeCheck.block_return)hasRet1).hasRet:false) && !(hasRet2!=null?((TypeCheck.block_return)hasRet2).hasRet:false)))) {
							error("Control flow not complete");
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
		dbg.location(364, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "conditional");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:366:1: invocation[StructTypes stypes, Vector<SymbolTable> env] returns [Type t] : ^( INVOKE id= ID retArgs= arguments[stypes, env] ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "invocation");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(366, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:367:2: ( ^( INVOKE id= ID retArgs= arguments[stypes, env] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:367:4: ^( INVOKE id= ID retArgs= arguments[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(367,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(367,6);
			_last = (CommonTree)input.LT(1);
			INVOKE48=(CommonTree)match(input,INVOKE,FOLLOW_INVOKE_in_invocation787); 
			INVOKE48_tree = (CommonTree)adaptor.dupNode(INVOKE48);


			root_1 = (CommonTree)adaptor.becomeRoot(INVOKE48_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(367,15);
			_last = (CommonTree)input.LT(1);
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_invocation791); 
			id_tree = (CommonTree)adaptor.dupNode(id);


			adaptor.addChild(root_1, id_tree);
			dbg.location(367,19);
			 System.out.println("invokation " + id); dbg.location(367,70);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_arguments_in_invocation797);
			retArgs=arguments(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, retArgs.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(368,2);

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
		dbg.location(393, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "invocation");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:395:1: loop[StructTypes stypes, Vector<SymbolTable> env] : ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "loop");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(395, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:396:2: ( ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:396:4: ^( WHILE expression[stypes, env] block[stypes, env] expression[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(396,4);
			System.out.println("enter while");dbg.location(396,41);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(396,43);
			_last = (CommonTree)input.LT(1);
			WHILE49=(CommonTree)match(input,WHILE,FOLLOW_WHILE_in_loop818); 
			WHILE49_tree = (CommonTree)adaptor.dupNode(WHILE49);


			root_1 = (CommonTree)adaptor.becomeRoot(WHILE49_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(396,49);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop820);
			expression50=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression50.getTree());
			dbg.location(396,73);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_block_in_loop823);
			block51=block(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, block51.getTree());
			dbg.location(396,92);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_loop826);
			expression52=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression52.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(396,116);
			System.out.println("leave while");
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
		dbg.location(397, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "loop");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "loop"


	public static class block_return extends TreeRuleReturnScope {
		public boolean hasRet;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "block"
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:399:1: block[StructTypes stypes, Vector<SymbolTable> env] returns [boolean hasRet] : ^( BLOCK retHasRet= statement_list[stypes, env] ) ;
	public final TypeCheck.block_return block(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.block_return retval = new TypeCheck.block_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree BLOCK53=null;
		TreeRuleReturnScope retHasRet =null;

		CommonTree BLOCK53_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "block");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(399, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:400:2: ( ^( BLOCK retHasRet= statement_list[stypes, env] ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:400:4: ^( BLOCK retHasRet= statement_list[stypes, env] )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(400,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(400,6);
			_last = (CommonTree)input.LT(1);
			BLOCK53=(CommonTree)match(input,BLOCK,FOLLOW_BLOCK_in_block848); 
			BLOCK53_tree = (CommonTree)adaptor.dupNode(BLOCK53);


			root_1 = (CommonTree)adaptor.becomeRoot(BLOCK53_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(400,21);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_statement_list_in_block852);
			retHasRet=statement_list(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, retHasRet.getTree());

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(400,51);
			 retval.hasRet = (retHasRet!=null?((TypeCheck.statement_list_return)retHasRet).hasRet:false); 
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
		dbg.location(401, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "block");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:403:1: assignment[StructTypes stypes, Vector<SymbolTable> env] : ^( ASSIGN expression[stypes, env] lvalue ) ;
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

		try { dbg.enterRule(getGrammarFileName(), "assignment");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(403, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:404:2: ( ^( ASSIGN expression[stypes, env] lvalue ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:404:4: ^( ASSIGN expression[stypes, env] lvalue )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(404,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(404,6);
			_last = (CommonTree)input.LT(1);
			ASSIGN54=(CommonTree)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignment870); 
			ASSIGN54_tree = (CommonTree)adaptor.dupNode(ASSIGN54);


			root_1 = (CommonTree)adaptor.becomeRoot(ASSIGN54_tree, root_1);

			match(input, Token.DOWN, null); 
			dbg.location(404,13);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_expression_in_assignment872);
			expression55=expression(stypes, env);
			state._fsp--;

			adaptor.addChild(root_1, expression55.getTree());
			dbg.location(404,37);
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_lvalue_in_assignment875);
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
		dbg.location(405, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "assignment");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:407:1: expression[StructTypes stypes, Vector<SymbolTable> env] returns [Type t = null] : (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | NULL );
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
		CommonTree NULL68=null;
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
		CommonTree NULL68_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(407, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:408:2: (retVal= invocation[stypes, env] | ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] ) | ^( NOT expression[stypes, env] ) | ^( DOT retType= expression[stypes, env] memberId= ID ) |idCall= ID | INTEGER | TRUE | FALSE | ^( NEW id= ID ) | NULL )
			int alt16=13;
			try { dbg.enterDecision(16, decisionCanBacktrack[16]);

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
			case NULL:
				{
				alt16=13;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(16);}

			switch (alt16) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:408:4: retVal= invocation[stypes, env]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(408,10);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_invocation_in_expression895);
					retVal=invocation(stypes, env);
					state._fsp--;

					adaptor.addChild(root_0, retVal.getTree());
					dbg.location(409,3);

								retval.t = (retVal!=null?((TypeCheck.invocation_return)retVal).t:null);
							
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:412:5: ^( ( AND | OR ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(412,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(412,7);
					set57=(CommonTree)input.LT(1);
					if ( input.LA(1)==AND||input.LA(1)==OR ) {
						input.consume();
						set57_tree = (CommonTree)adaptor.dupNode(set57);


						root_1 = (CommonTree)adaptor.becomeRoot(set57_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					dbg.location(412,22);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression917);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());
					dbg.location(412,51);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression922);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(413,3);

								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(BoolType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(BoolType.class)) {
									error("Operators && and || require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:419:5: ^( ( EQ | LT | GT | NE | LE | GE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(419,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(419,7);
					set58=(CommonTree)input.LT(1);
					if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NE ) {
						input.consume();
						set58_tree = (CommonTree)adaptor.dupNode(set58);


						root_1 = (CommonTree)adaptor.becomeRoot(set58_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					dbg.location(419,41);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression961);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());
					dbg.location(419,70);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression966);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(420,3);

								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators ==, <, >, <=, >= require two integer types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:426:5: ^( ( PLUS | MINUS ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(426,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(426,7);
					set59=(CommonTree)input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						set59_tree = (CommonTree)adaptor.dupNode(set59);


						root_1 = (CommonTree)adaptor.becomeRoot(set59_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					dbg.location(426,26);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression989);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());
					dbg.location(426,55);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression994);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(427,3);

								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators + and - require two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:433:5: ^( ( TIMES | DIVIDE ) ret1= expression[stypes, env] ret2= expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(433,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(433,7);
					set60=(CommonTree)input.LT(1);
					if ( input.LA(1)==DIVIDE||input.LA(1)==TIMES ) {
						input.consume();
						set60_tree = (CommonTree)adaptor.dupNode(set60);


						root_1 = (CommonTree)adaptor.becomeRoot(set60_tree, root_1);

						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}

					match(input, Token.DOWN, null); 
					dbg.location(433,28);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1017);
					ret1=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret1.getTree());
					dbg.location(433,57);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1022);
					ret2=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, ret2.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(434,3);

								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operators * and / requires two integer types");
								}
								retval.t = new IntType();
							
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:440:5: ^( NOT expression[stypes, env] )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(440,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(440,7);
					_last = (CommonTree)input.LT(1);
					NOT61=(CommonTree)match(input,NOT,FOLLOW_NOT_in_expression1035); 
					NOT61_tree = (CommonTree)adaptor.dupNode(NOT61);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT61_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(440,11);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1037);
					expression62=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, expression62.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(441,3);

								if(!(ret1!=null?((TypeCheck.expression_return)ret1).t:null).getClass().equals(IntType.class) || !(ret2!=null?((TypeCheck.expression_return)ret2).t:null).getClass().equals(IntType.class)) {
									error("Operator ! requires two boolean types");
								}
								retval.t = new BoolType();
							
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:447:5: ^( DOT retType= expression[stypes, env] memberId= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(447,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(447,7);
					_last = (CommonTree)input.LT(1);
					DOT63=(CommonTree)match(input,DOT,FOLLOW_DOT_in_expression1050); 
					DOT63_tree = (CommonTree)adaptor.dupNode(DOT63);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT63_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(447,19);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_expression_in_expression1056);
					retType=expression(stypes, env);
					state._fsp--;

					adaptor.addChild(root_1, retType.getTree());
					dbg.location(447,53);
					_last = (CommonTree)input.LT(1);
					memberId=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1061); 
					memberId_tree = (CommonTree)adaptor.dupNode(memberId);


					adaptor.addChild(root_1, memberId_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(447,57);
					 System.out.println("dot finished "); dbg.location(448,3);

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
					dbg.enterAlt(8);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:462:5: idCall= ID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(462,11);
					_last = (CommonTree)input.LT(1);
					idCall=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1075); 
					idCall_tree = (CommonTree)adaptor.dupNode(idCall);


					adaptor.addChild(root_0, idCall_tree);
					dbg.location(463,3);

								Type idType = lookupType((idCall!=null?idCall.getText():null), env);
								
								if(idType == null) {
									error((id!=null?id.getLine():0), "Invokation of type that does not exist: " + (idCall!=null?idCall.getText():null));
								} else {
									retval.t = idType;
								}
							
					}
					break;
				case 9 :
					dbg.enterAlt(9);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:472:4: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(472,4);
					_last = (CommonTree)input.LT(1);
					INTEGER64=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression1084); 
					INTEGER64_tree = (CommonTree)adaptor.dupNode(INTEGER64);


					adaptor.addChild(root_0, INTEGER64_tree);
					dbg.location(472,12);
					 retval.t = new IntType(); 
					}
					break;
				case 10 :
					dbg.enterAlt(10);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:473:4: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(473,4);
					_last = (CommonTree)input.LT(1);
					TRUE65=(CommonTree)match(input,TRUE,FOLLOW_TRUE_in_expression1091); 
					TRUE65_tree = (CommonTree)adaptor.dupNode(TRUE65);


					adaptor.addChild(root_0, TRUE65_tree);
					dbg.location(473,9);
					 retval.t = new BoolType(); 
					}
					break;
				case 11 :
					dbg.enterAlt(11);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:474:5: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(474,5);
					_last = (CommonTree)input.LT(1);
					FALSE66=(CommonTree)match(input,FALSE,FOLLOW_FALSE_in_expression1099); 
					FALSE66_tree = (CommonTree)adaptor.dupNode(FALSE66);


					adaptor.addChild(root_0, FALSE66_tree);
					dbg.location(474,11);
					 retval.t = new BoolType(); 
					}
					break;
				case 12 :
					dbg.enterAlt(12);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:475:5: ^( NEW id= ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(475,5);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(475,7);
					_last = (CommonTree)input.LT(1);
					NEW67=(CommonTree)match(input,NEW,FOLLOW_NEW_in_expression1108); 
					NEW67_tree = (CommonTree)adaptor.dupNode(NEW67);


					root_1 = (CommonTree)adaptor.becomeRoot(NEW67_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(475,13);
					_last = (CommonTree)input.LT(1);
					id=(CommonTree)match(input,ID,FOLLOW_ID_in_expression1112); 
					id_tree = (CommonTree)adaptor.dupNode(id);


					adaptor.addChild(root_1, id_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}

					dbg.location(476,3);
						
								if(!stypes.isDefined((id!=null?id.getText():null))) {
									error((id!=null?id.getLine():0), "Struct with type " + (id!=null?id.getText():null) + " does not exist");
								} else {
									retval.t = stypes.get((id!=null?id.getText():null));
								}
							
					}
					break;
				case 13 :
					dbg.enterAlt(13);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:483:5: NULL
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(483,5);
					_last = (CommonTree)input.LT(1);
					NULL68=(CommonTree)match(input,NULL,FOLLOW_NULL_in_expression1124); 
					NULL68_tree = (CommonTree)adaptor.dupNode(NULL68);


					adaptor.addChild(root_0, NULL68_tree);
					dbg.location(484,3);

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
		dbg.location(487, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:489:1: lvalue : ( ^( DOT lvalue ID ) | ID );
	public final TypeCheck.lvalue_return lvalue() throws RecognitionException {
		TypeCheck.lvalue_return retval = new TypeCheck.lvalue_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree DOT69=null;
		CommonTree ID71=null;
		CommonTree ID72=null;
		TreeRuleReturnScope lvalue70 =null;

		CommonTree DOT69_tree=null;
		CommonTree ID71_tree=null;
		CommonTree ID72_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "lvalue");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(489, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:490:2: ( ^( DOT lvalue ID ) | ID )
			int alt17=2;
			try { dbg.enterDecision(17, decisionCanBacktrack[17]);

			int LA17_0 = input.LA(1);
			if ( (LA17_0==DOT) ) {
				alt17=1;
			}
			else if ( (LA17_0==ID) ) {
				alt17=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(17);}

			switch (alt17) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:490:4: ^( DOT lvalue ID )
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(490,4);
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					dbg.location(490,6);
					_last = (CommonTree)input.LT(1);
					DOT69=(CommonTree)match(input,DOT,FOLLOW_DOT_in_lvalue1141); 
					DOT69_tree = (CommonTree)adaptor.dupNode(DOT69);


					root_1 = (CommonTree)adaptor.becomeRoot(DOT69_tree, root_1);

					match(input, Token.DOWN, null); 
					dbg.location(490,10);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_lvalue_in_lvalue1143);
					lvalue70=lvalue();
					state._fsp--;

					adaptor.addChild(root_1, lvalue70.getTree());
					dbg.location(490,17);
					_last = (CommonTree)input.LT(1);
					ID71=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1145); 
					ID71_tree = (CommonTree)adaptor.dupNode(ID71);


					adaptor.addChild(root_1, ID71_tree);

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:491:5: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(491,5);
					_last = (CommonTree)input.LT(1);
					ID72=(CommonTree)match(input,ID,FOLLOW_ID_in_lvalue1152); 
					ID72_tree = (CommonTree)adaptor.dupNode(ID72);


					adaptor.addChild(root_0, ID72_tree);

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
		dbg.location(492, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lvalue");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:494:1: rettype[StructTypes stypes] returns [Type retType] : (foundType= type[stypes] | VOID );
	public final TypeCheck.rettype_return rettype(StructTypes stypes) throws RecognitionException {
		TypeCheck.rettype_return retval = new TypeCheck.rettype_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree VOID73=null;
		TreeRuleReturnScope foundType =null;

		CommonTree VOID73_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "rettype");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(494, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:495:2: (foundType= type[stypes] | VOID )
			int alt18=2;
			try { dbg.enterDecision(18, decisionCanBacktrack[18]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(18);}

			switch (alt18) {
				case 1 :
					dbg.enterAlt(1);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:495:4: foundType= type[stypes]
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(495,13);
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_type_in_rettype1174);
					foundType=type(stypes);
					state._fsp--;

					adaptor.addChild(root_0, foundType.getTree());
					dbg.location(496,3);

								retval.retType = (foundType!=null?((TypeCheck.type_return)foundType).t:null);
							
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:499:4: VOID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(499,4);
					_last = (CommonTree)input.LT(1);
					VOID73=(CommonTree)match(input,VOID,FOLLOW_VOID_in_rettype1184); 
					VOID73_tree = (CommonTree)adaptor.dupNode(VOID73);


					adaptor.addChild(root_0, VOID73_tree);
					dbg.location(500,3);

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
		dbg.location(503, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "rettype");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:505:1: params[StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retParams] : ^( PARAMS (retVal= decl[stypes, localEnv] )* ) ;
	public final TypeCheck.params_return params(StructTypes stypes, Vector<SymbolTable> env) throws RecognitionException {
		TypeCheck.params_return retval = new TypeCheck.params_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree PARAMS74=null;
		TreeRuleReturnScope retVal =null;

		CommonTree PARAMS74_tree=null;


				SymbolTable localEnv = env.get(0);
				Vector<Type> paramList = new Vector<Type>();
			
		try { dbg.enterRule(getGrammarFileName(), "params");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(505, 0);

		try {
			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:510:2: ( ^( PARAMS (retVal= decl[stypes, localEnv] )* ) )
			dbg.enterAlt(1);

			// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:510:4: ^( PARAMS (retVal= decl[stypes, localEnv] )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(510,4);
			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			dbg.location(510,6);
			_last = (CommonTree)input.LT(1);
			PARAMS74=(CommonTree)match(input,PARAMS,FOLLOW_PARAMS_in_params1213); 
			PARAMS74_tree = (CommonTree)adaptor.dupNode(PARAMS74);


			root_1 = (CommonTree)adaptor.becomeRoot(PARAMS74_tree, root_1);

			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				dbg.location(510,13);
				// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:510:13: (retVal= decl[stypes, localEnv] )*
				try { dbg.enterSubRule(19);

				loop19:
				while (true) {
					int alt19=2;
					try { dbg.enterDecision(19, decisionCanBacktrack[19]);

					int LA19_0 = input.LA(1);
					if ( (LA19_0==DECL) ) {
						alt19=1;
					}

					} finally {dbg.exitDecision(19);}

					switch (alt19) {
					case 1 :
						dbg.enterAlt(1);

						// /Users/jbilous/Development/CSC431/parser/TypeCheck.g:510:14: retVal= decl[stypes, localEnv]
						{
						dbg.location(510,20);
						_last = (CommonTree)input.LT(1);
						pushFollow(FOLLOW_decl_in_params1218);
						retVal=decl(stypes, localEnv);
						state._fsp--;

						adaptor.addChild(root_1, retVal.getTree());
						dbg.location(511,3);

									paramList.add((retVal!=null?((TypeCheck.decl_return)retVal).newDec:null));
								
						}
						break;

					default :
						break loop19;
					}
				}
				} finally {dbg.exitSubRule(19);}

				match(input, Token.UP, null); 
			}
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}

			dbg.location(515,3);

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
		dbg.location(518, 1);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "params");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
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
	public static final BitSet FOLLOW_functions_in_program93 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types115 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_types_sub_in_types117 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TYPES_in_types128 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_decl_in_types_sub143 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_types_sub_in_types_sub146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type_decl172 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type_decl177 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_nested_decl_in_type_decl186 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_decl_in_nested_decl207 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_DECL_in_decl231 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decl234 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decl238 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_decl244 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLS_in_declarations273 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_declaration_in_declarations275 = new BitSet(new long[]{0x0000000000001008L});
	public static final BitSet FOLLOW_decllist_in_declaration295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_type314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_type322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRUCT_in_type330 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_type334 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DECLLIST_in_decllist356 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TYPE_in_decllist359 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_type_in_decllist363 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_id_list_in_decllist367 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_id_list391 = new BitSet(new long[]{0x0000000002000002L});
	public static final BitSet FOLLOW_FUNCS_in_functions425 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_function_in_functions427 = new BitSet(new long[]{0x0000000000200008L});
	public static final BitSet FOLLOW_FUN_in_function457 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_function461 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_params_in_function465 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_RETTYPE_in_function469 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_rettype_in_function473 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_declarations_in_function477 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_statement_list_in_function486 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_STMTS_in_statement_list513 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_in_statement_list517 = new BitSet(new long[]{0x04010800240000C8L});
	public static final BitSet FOLLOW_block_in_statement543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement551 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_in_statement560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_loop_in_statement569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_invocation_in_statement577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ret_in_statement586 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_print_in_statement597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PRINT_in_print615 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_print617 = new BitSet(new long[]{0x0000000000040008L});
	public static final BitSet FOLLOW_ENDL_in_print620 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret638 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_ret642 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RETURN_in_ret654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_arg_list_in_arguments679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARGS_in_arg_list709 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_arg_list714 = new BitSet(new long[]{0x006005EEB3998018L});
	public static final BitSet FOLLOW_ARGS_in_arg_list730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IF_in_conditional748 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_conditional752 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_conditional757 = new BitSet(new long[]{0x0000000000000088L});
	public static final BitSet FOLLOW_block_in_conditional762 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INVOKE_in_invocation787 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_invocation791 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_arguments_in_invocation797 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_WHILE_in_loop818 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_loop820 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_block_in_loop823 = new BitSet(new long[]{0x006005EEB3998010L});
	public static final BitSet FOLLOW_expression_in_loop826 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_BLOCK_in_block848 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_statement_list_in_block852 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ASSIGN_in_assignment870 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_assignment872 = new BitSet(new long[]{0x0000000002010000L});
	public static final BitSet FOLLOW_lvalue_in_assignment875 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_invocation_in_expression895 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_expression907 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression917 = new BitSet(new long[]{0x006005EEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression922 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression935 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression961 = new BitSet(new long[]{0x006005EEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression966 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression979 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression989 = new BitSet(new long[]{0x006005EEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression994 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_in_expression1007 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1017 = new BitSet(new long[]{0x006005EEB3998010L});
	public static final BitSet FOLLOW_expression_in_expression1022 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expression1035 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1037 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DOT_in_expression1050 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expression_in_expression1056 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_expression1061 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expression1075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_expression1084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expression1091 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expression1099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEW_in_expression1108 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_expression1112 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NULL_in_expression1124 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOT_in_lvalue1141 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_lvalue_in_lvalue1143 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_ID_in_lvalue1145 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_lvalue1152 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_in_rettype1174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VOID_in_rettype1184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PARAMS_in_params1213 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_decl_in_params1218 = new BitSet(new long[]{0x0000000000000808L});
}
