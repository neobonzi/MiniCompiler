package jbilous.support.assembly;

import java.lang.String;

public class PushQ extends AssemblyInstruction{

	public PushQ(AssemblyRegister source) {
		super(source);
	}
	public String toString() {
		return "pushq " + source;
	}
}