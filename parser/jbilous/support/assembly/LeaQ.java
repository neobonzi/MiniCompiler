package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class LeaQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;
	public boolean setMe = false;
	public String varOffset = null;

	public LeaQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			if (varOffset != null) {
				return "leaq " + varOffset + "(" + source_ass + "), " + target_ass;
			}
			return "leaq " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "leaq " + source_ass +  ", " + (stackPos * 8) + "(" + target_ass + ")";
		}

		return "leaq " + source_ass + ", " + target_ass;
	}
}