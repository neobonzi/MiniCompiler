package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class SubQ extends AssemblyInstruction{

	public SubQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "subq " + source + ", " + target;
	}
}