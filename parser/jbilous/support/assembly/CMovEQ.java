package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class CMovEQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public CMovEQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "cmoveq " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "cmoveq " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "cmoveq " + source + ", " + target;
	}
}