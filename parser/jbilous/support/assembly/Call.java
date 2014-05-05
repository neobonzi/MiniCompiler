package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class Call extends AssemblyInstruction{
	String label;
	
	public Call(String label) {
		this.label = label;
	}
	public String toString() {
		return "call " + label;
	}
}