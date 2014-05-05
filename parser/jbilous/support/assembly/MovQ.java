package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class MovQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;
	public String varOffset = null;

	public MovQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			if (varOffset != null) {
				return "movq " + varOffset + "(" + source + "), " + target;
			}
			return "movq " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "movq " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "movq " + source + ", " + target;
	}
}