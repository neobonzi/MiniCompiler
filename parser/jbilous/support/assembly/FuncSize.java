package jbilous.support.assembly;

import java.util.Vector;

public class FuncSize extends AssemblyInstruction {
	String label;

   public FuncSize(String label) {
      this.label = label;
   }

   public String toString() {
   		return ".size   " + label + ", .-" + label;
   }
}