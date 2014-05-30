package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class PopQ extends AssemblyInstruction{
	Register popReg;

	public PopQ(Register target) {
		this.popReg = target;
		// super(null, target);
	}
	public String toString() {
		return "popq " + popReg;
		//return "popq " + target_ass;
	}
}