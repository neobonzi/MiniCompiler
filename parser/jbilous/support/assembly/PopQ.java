package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class PopQ extends AssemblyInstruction{

	public PopQ(Register source) {
		super(source);
	}
	public String toString() {
		return "popq " + source;
	}
}