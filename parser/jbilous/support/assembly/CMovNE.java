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
			return "cmovne " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "cmovne " + source_ass +  ", " + (stackPos * 8) + "(" + target_ass + ")";
		}

		return "cmovne " + source_ass + ", " + target_ass;
	}
}