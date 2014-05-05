package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class LeaQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;
	public String varOffset = null;

	public LeaQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			if (varOffset != null) {
				return "leaq " + varOffset + "(" + source + "), " + target;
			}
			return "leaq " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "leaq " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}

		return "leaq " + source + ", " + target;
	}
}