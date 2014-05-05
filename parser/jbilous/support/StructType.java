package jbilous.support;

import java.lang.String;
import java.util.HashMap;

public class StructType extends Type {
   public SymbolTable members;
   public int memberCount;
   public HashMap<String, Integer> memberCounts;
   public String typeString = "TYPE";
   public String id;
   
   public StructType(String id) {
      this.id = id;
      memberCount = 0;
      members = new SymbolTable();
      memberCounts = new HashMap<String, Integer>();
   }

   public StructType(String id, SymbolTable members) {
      this.id = id;
      memberCount = 0;
      this.members = members;
      memberCounts = new HashMap<String, Integer>();
   }
   
   public void addMember(String id, Type value) {
      memberCount++;
      members.put(id, value);
      memberCounts.put(id, new Integer(memberCount));
   }
   
   public boolean hasMember(String id) {
      return members.symbols.containsKey(id);
   }
   public Type get(String id) {
      return members.get(id);
   }
}