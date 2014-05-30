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
			return "cmovl " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "cmovl " + source_ass +  ", " + (stackPos * 8) + "(" + target_ass + ")";
		}

		return "cmovl " + source_ass + ", " + target_ass;
	}
}