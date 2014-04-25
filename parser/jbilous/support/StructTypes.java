package jbilous.support;

import java.util.HashMap;
import java.lang.String;

public class StructTypes {
   HashMap<String, Type> stypes;
   
   public StructTypes() {
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