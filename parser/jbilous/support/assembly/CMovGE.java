package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovGE extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovGE(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmovge " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmovge " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmovge " + source + ", " + target;
	}
}