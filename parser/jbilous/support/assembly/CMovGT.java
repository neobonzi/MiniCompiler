package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovGT extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovGT(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmovg " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmovg " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmovg " + source + ", " + target;
	}
}