package jbilous.support.assembly;

import java.lang.String;

public class PopQ extends AssemblyInstruction{

	public PopQ(AssemblyRegister source) {
		super(source);
	}
	public String toString() {
		return "popq " + source;
	}
}