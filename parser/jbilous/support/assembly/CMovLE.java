package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovLE extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovLE(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmovle " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmovle " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmovle " + source + ", " + target;
	}
}