tree grammar TypeCheck;

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
   import jbilous.parser.support;
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
}

verify 
	:	program EOF
   |	{ error(0, "EOF Not Found!"); }
;

program 
	@init{
		StructTypes stypes = new StructTypes();
		Vector<SymbolTable> env = new Vector<SymbolTable>();
		env.add(new SymbolTable());
	}
   :	^(PROGRAM types[stypes, env] declarations[stypes, env] functions[stypes, env])
   	{
   		if(lookupType("main", env) == null) {
   			error("Main method required");
   		}
   		
   		System.out.println("---------Successfully Passed Type Checking!---------");
   	}
   ;

types [StructTypes stypes, Vector<SymbolTable> env]
   :   ^(TYPES types_sub[stypes, env])
   |   TYPES
   ;

types_sub [StructTypes stypes, Vector<SymbolTable> env]
	:	type_decl[stypes] types_sub[stypes, env]
	|	
	;

type_decl [StructTypes stypes]
	@init {
		StructType newStruct;
	}
	:  ^(STRUCT^ id=ID
		{
			newStruct = new StructType($id.text);
			stypes.put($id.text, newStruct);
		} 
		nested_decl[stypes, newStruct.members])
		{
			StructType myStruct = (StructType)stypes.get($id.text);
		}
	;
	 
nested_decl [StructTypes stypes, SymbolTable structDecls]
	:	decl[stypes, structDecls]+
	;
	
decl [StructTypes stypes, SymbolTable localEnv] returns [Type newDec]
   :  ^(DECL ^(TYPE retType=type[stypes]) myId=ID) 
   	{
   		localEnv.put($myId.text, $retType.t);
   		$newDec = $retType.t;
   	}
   ;
   
declarations[StructTypes stypes, Vector<SymbolTable> env]
   :  ^(DECLS declaration[stypes, env]*) 
   ;

declaration[StructTypes stypes, Vector<SymbolTable> env]
	:	decllist[stypes, env]
	;

type [StructTypes stypes] returns [Type t = null]
	:  INT	{ $t = new IntType(); }
	|  BOOL	{ $t = new BoolType(); }
	|	^(STRUCT id=ID)
		{
			if(!$stypes.isDefined($id.text))
			{
				error($id.line, "undefined struct type '" + $id + "'");
			}
			$t = $stypes.get($id.text);
		}
	;

decllist [StructTypes stypes, Vector<SymbolTable> env]
   :  ^(DECLLIST ^(TYPE retType=type[stypes]) id_list[$retType.t, env])
   ;

id_list [Type t, Vector<SymbolTable> env]
	:	(
			id=ID
   		{
   			if($env.get(0).redef($id.text)) {
   				error($id.line, "redefinition of variable '" + $id + "'");
   			}
   			
				$env.get(0).put($id.text, $t);
   		}
		)+   
	;
   
functions [StructTypes stypes, Vector<SymbolTable> env]
   :	^(FUNCS function[stypes, env]*)
   ;

function[StructTypes stypes, Vector<SymbolTable> env]
	@init {
		SymbolTable funcEnv = new SymbolTable();
		Vector<SymbolTable> localEnv = new Vector<SymbolTable>(env);
		localEnv.add(0, funcEnv);
	}
	:	^(FUN id=ID retParams=params[stypes, localEnv] ^(RETTYPE rreturn=rettype[stypes]) declarations[stypes, localEnv]
		{
			FunctionType func = new FunctionType($rreturn.retType, $retParams.retParams);
			localEnv.get(1).put($id.text, func);
			localEnv.get(0).put("expret", $rreturn.retType);
		}
		sl=statement_list[stypes, localEnv])
		{
			if(!$rreturn.retType.getClass().equals(VoidType.class) && !$sl.hasRet) {
				error("Function requires a return value");
			}
		}
		
	;

statement_list [StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false]
	:	^(STMTS retHasRet=statement[stypes, env]*) 
		{ 
			if($retHasRet.hasRet != null) {
				$hasRet = $retHasRet.hasRet; 
			}
		}
	;
	

statement [StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false]
   :	blockRet=block[stypes, env] { $hasRet = $blockRet.hasRet;}
   |	assignment[stypes, env]
   | 	condRet=conditional[stypes, env] { $hasRet = $condRet.hasRet;} 
   |  loop[stypes, env] 
   |	invocation[stypes, env]
   |  ret[stypes, env] { $hasRet = true; }
   |  print[stypes, env] 
   ;

print [StructTypes stypes, Vector<SymbolTable> env]
	:  ^(PRINT expression[stypes, env] ENDL?)
	;

ret [StructTypes stypes, Vector<SymbolTable> env]
	:	^(RETURN retExp=expression[stypes, env])
		{
			Type retType = $retExp.t;
			Type expType = env.get(0).get("expret");
			if(!retType.getClass().equals(expType.getClass())){
				error(0, "Expected a different return type than what was given");
			}
		}
	|  RETURN
		{
			Type retType = new VoidType();
			Type expType = env.get(0).get("expret");
			if(!retType.getClass().equals(expType.getClass())){
				error(0, "Expected a different return type than what was given");
			}
		}
	;

arguments [StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retArgs]
	:	args=arg_list[stypes, env] 
		{
			$retArgs = $args.argList;
		}
	;

arg_list [StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> argList]
	@init {
		Vector<Type> toReturn = new Vector<Type>();
	}
	:	^(ARGS (exp=expression[stypes, env]
		{
			toReturn.add($exp.t);
			$argList = toReturn;
		}
		)+)
	|	ARGS
		{
			toReturn.add(new VoidType());
			$argList = toReturn;
		}
	;

conditional [StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false]
	:	^(IF guard=expression[stypes, env] hasRet1=block[stypes, env] hasRet2=block[stypes, env]?)
		{
			Boolean first = $hasRet1.hasRet;
			Boolean second;
			if($hasRet2.hasRet == null) {
				second = false;
			} else {
				second = $hasRet2.hasRet;
			}
			
			if((!first && second)
				||	(first && !second)){
				error("Control flow not complete");
			} else {
				$hasRet = true;
			}
			if(!$guard.t.getClass().equals(BoolType.class)) {
				error("Conditional requires a boolean guard");
			}
		}
	;

invocation [StructTypes stypes, Vector<SymbolTable> env] returns [Type t]
	:	^(INVOKE id=ID retArgs=arguments[stypes, env])
	{
		Type calledVar = lookupType($id.text, env);
		if(calledVar == null || !(calledVar instanceof FunctionType)) {
			error(0, "Can't find function with id " + $id.text); 
		}
		FunctionType calledFunc = (FunctionType)calledVar;
		
		Vector<Type> provParams = $retArgs.retArgs;
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
		
		$t = calledFunc.returnType;
	}
	;

loop [StructTypes stypes, Vector<SymbolTable> env]
	:	^(WHILE expression[stypes, env] block[stypes, env] expression[stypes, env]) 
	;

block [StructTypes stypes, Vector<SymbolTable> env] returns [Boolean hasRet = false]
	:	^(BLOCK retHasRet=statement_list[stypes, env])
		{
			$hasRet = $retHasRet.hasRet; 
		}
	;

assignment [StructTypes stypes, Vector<SymbolTable> env]
	:	^(ASSIGN expression[stypes, env] lvalue)
	;

expression [StructTypes stypes, Vector<SymbolTable> env] returns [Type t = null]
	:	retVal=invocation[stypes, env]
		{
			$t = $retVal.t;
		}
	|  ^((AND | OR) ret1=expression[stypes, env] ret2=expression[stypes, env])
		{
			if(!$ret1.t.getClass().equals(BoolType.class) || !$ret2.t.getClass().equals(BoolType.class)) {
				error("Operators && and || require two integer types");
			}
			$t = new BoolType();
		}
	|  ^((EQ | LT | GT | NE | LE | GE) ret1=expression[stypes, env] ret2=expression[stypes, env])
		{
			if(!$ret1.t.getClass().equals(IntType.class) || !$ret2.t.getClass().equals(IntType.class)) {
				error("Operators ==, <, >, <=, >= require two integer types");
			}
			$t = new BoolType();
		}
	|  ^((PLUS | MINUS) ret1=expression[stypes, env] ret2=expression[stypes, env])
		{
			if(!$ret1.t.getClass().equals(IntType.class) || !$ret2.t.getClass().equals(IntType.class)) {
				error("Operators + and - require two integer types");
			}
			$t = new IntType();
		}
	|  ^((TIMES | DIVIDE) ret1=expression[stypes, env] ret2=expression[stypes, env])
		{
			if(!$ret1.t.getClass().equals(IntType.class) || !$ret2.t.getClass().equals(IntType.class)) {
				error("Operators * and / requires two integer types");
			}
			$t = new IntType();
		}
	|  ^(NOT expression[stypes, env])
		{
			if(!$ret1.t.getClass().equals(IntType.class) || !$ret2.t.getClass().equals(IntType.class)) {
				error("Operator ! requires two boolean types");
			}
			$t = new BoolType();
		}
	|  ^(DOT retType = expression[stypes, env] memberId=ID)
		{
			if(!($retType.t instanceof StructType)) {
				error($memberId.line, "Called dot on non struct");
			}
			
			StructType structType = (StructType)$retType.t;
			if(!structType.hasMember($memberId.text)) {
				System.out.println("-----");
				printSymbolTable(structType.members);
				error($memberId.line, "Struct does not have member with id " + $memberId.text);
			} else {
				$t = structType.members.get($memberId.text);
			}
		}
	|  idCall=ID
		{
			Type idType = lookupType($idCall.text, env);
			
			if(idType == null) {
				error($id.line, "Invokation of type that does not exist: " + $idCall.text);
			} else {
				$t = idType;
			}
		}
	|	INTEGER { $t = new IntType(); }
	|	TRUE	{ $t = new BoolType(); }
	| 	FALSE	{ $t = new BoolType(); }
	|  ^(NEW id=ID) 
		{	
			if(!stypes.isDefined($id.text)) {
				error($id.line, "Struct with type " + $id.text + " does not exist");
			} else {
				$t = stypes.get($id.text);
			}
		}
	|  ^(NEG retType = expression[stypes,env]) 
		{ $t = $retType.t; }
	|  NULL
		{
			$t = new NullType();
		}
	;
	
lvalue
	:	^(DOT lvalue ID)
	| 	ID
	;
   
rettype [StructTypes stypes] returns [Type retType]
	:	foundType=type[stypes]
		{
			$retType = $foundType.t;
		}
	|	VOID	
		{
			$retType = new VoidType();
		}
	;

params [StructTypes stypes, Vector<SymbolTable> env] returns [Vector<Type> retParams]
	@init {
		SymbolTable localEnv = env.get(0);
		Vector<Type> paramList = new Vector<Type>();
	}
	:	^(PARAMS (retVal=decl[stypes, localEnv]
		{
			paramList.add($retVal.newDec);
		}
		)*)
		{
			$retParams = paramList;
		}
	;