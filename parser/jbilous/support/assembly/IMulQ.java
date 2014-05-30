package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class IMulQ extends AssemblyInstruction{

	public IMulQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "imulq " + source_ass + ", " + target_ass;
	}
}