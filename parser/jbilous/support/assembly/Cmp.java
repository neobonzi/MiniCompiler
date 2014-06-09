package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class Cmp extends AssemblyInstruction{

	public Cmp(Register source1, Register source2) {
		super(source1, source2, null);
	}

	public String toString() {
		return "cmpq " + source_ass + ", " + source2_ass;
	}
}