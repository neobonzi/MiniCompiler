package jbilous.support;

import java.util.Vector;

public class FunctionType extends Type {
   public Type returnType;
   public Vector<Type> params;
   public String typeString = "FUNCTION";
   
   public FunctionType(Type retType, Vector<Type> parameters) {
      returnType = retType;
      params = parameters;
   }
}