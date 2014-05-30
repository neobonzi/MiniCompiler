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
			return "cmovge " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "cmovge " + source_ass +  ", " + (stackPos * 8) + "(" + target_ass + ")";
		}

		return "cmovge " + source_ass + ", " + target_ass;
	}
}