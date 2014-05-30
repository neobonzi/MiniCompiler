package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpLE extends AssemblyInstruction{
	String label;

	public JumpLE(String label) {
		this.label = label;
	}
	public String toString() {
		return "jle " + label;
	}
}