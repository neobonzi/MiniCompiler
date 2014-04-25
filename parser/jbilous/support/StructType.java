package jbilous.support;

import java.lang.String;

public class StructType extends Type {
   public SymbolTable members;
   public String typeString = "TYPE";
   public String id;
   
   public StructType(String id) {
      this.id = id;
      members = new SymbolTable();
   }

   public StructType(String id, SymbolTable members) {
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