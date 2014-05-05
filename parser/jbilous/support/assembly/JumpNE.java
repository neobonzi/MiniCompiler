package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpNE extends AssemblyInstruction{
	String label;
	public JumpNE(String label) {
		this.label = label;
	}
	public String toString() {
		return "jne " + label;
	}
}