package jbilous.support;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.lang.String;
import java.util.Iterator;

public class SymbolTable {
   public HashMap<String, Type> symbols;
   
   public SymbolTable() {
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