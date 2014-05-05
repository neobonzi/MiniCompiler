package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovLT extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovLT(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmovlt " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmovlt " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmovlt " + source + ", " + target;
	}
}