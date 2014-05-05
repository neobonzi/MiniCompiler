package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovNE extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovNE(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmovne " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmovne " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmovne " + source + ", " + target;
	}
}