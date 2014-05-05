package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class AddQ extends AssemblyInstruction{

	public AddQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "addq " + source + ", " + target;
	}
}