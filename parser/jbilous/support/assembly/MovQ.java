package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class MovQ extends AssemblyInstruction{

	public int stackPos;
	public boolean fromMem = false;
	public boolean toMem = false;
	public String varOffset = null;
	public LeaQ relatedLoad = null;

	public MovQ(Register source, Register target) {
		super(source, target);
	}

	public void setTargetAsSource()
	{
		this.source2_ass = target_ass;
	}

	public String toString() {
		if (fromMem) {
			if (varOffset != null) {
				return "movq " + varOffset + "(" + source_ass + "), " + target_ass;
			}
			return "movq " + (stackPos * 8) + "(" + source_ass + "), " + target_ass;
		}

		if (toMem) {
			return "movq " + source_ass +  ", " + stackPos + "(" + target_ass + ")";
		}

		return "movq " + source_ass + ", " + target_ass;
	}
}