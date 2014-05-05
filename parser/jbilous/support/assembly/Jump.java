package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class Jump extends AssemblyInstruction{
	String label;
	
	public Jump(String label) {
		this.label = label;
	}
	public String toString() {
		return "jmp " + label;
	}
}