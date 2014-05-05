package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class JumpL extends AssemblyInstruction{
	String label;

	public JumpL(String label) {
		this.label = label;
	}
	public String toString() {
		return "jl " + label;
	}
}