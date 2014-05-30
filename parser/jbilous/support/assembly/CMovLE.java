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
			return "cmovle " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "cmovle " + source_ass +  ", " + (stackPos * 8) + "(" + target_ass + ")";
		}

		return "cmovle " + source_ass + ", " + target_ass;
	}
}