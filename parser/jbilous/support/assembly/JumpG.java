package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpG extends AssemblyInstruction{
	String label;

	public JumpG(String label) {
		this.label = label;
	}
	public String toString() {
		return "jg " + label;
	}
}