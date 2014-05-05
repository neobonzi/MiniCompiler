package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpGE extends AssemblyInstruction{
	String label;

	public JumpGE(String label) {
		this.label = label;
	}
	public String toString() {
		return "jge " + label;
	}
}