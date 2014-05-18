package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class PopQ extends AssemblyInstruction{

	public PopQ(Register target) {
		super(null, target);
	}
	public String toString() {
		return "popq " + target;
	}
}