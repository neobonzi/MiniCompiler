package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class MovQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;

	public MovQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "movq " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "movq " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "movq " + source + ", " + target;
	}
}