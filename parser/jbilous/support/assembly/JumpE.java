package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpE extends AssemblyInstruction{
	String label;
	
	public JumpE(String label) {
		this.label = label;
	}
	public String toString() {
		return "je " + label;
	}
}