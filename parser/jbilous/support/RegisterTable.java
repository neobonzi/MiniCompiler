package jbilous.support;

import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.lang.String;
import java.util.Iterator;

public class RegisterTable {
   public HashMap<String, Integer> registers;
   
   public RegisterTable() {
      registers = new HashMap<String, Integer>();
   }

   public void put(String k, Integer v) {
      registers.put(k, v);
   }

   public Integer get(String k) {
      return registers.get(k);
   }
}