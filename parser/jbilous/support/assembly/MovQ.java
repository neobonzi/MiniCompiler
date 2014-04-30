package jbilous.support.assembly;

import java.lang.String;

public class MovQ extends AssemblyInstruction{

	public int stackPos;
	boolean fromMem = false;
	boolean toMem = false;

	public MovQ(AssemblyRegister source, AssemblyRegister target) {
		super(source, target);
	}

	public MovQ(String source, String target) {
		super(source, target);
	}

	public String toString() {
		if (fromMem) {
			return "movq " + (stackPos * 8) + "(" + source + "), " + target;
		}

		if (toMem) {
			return "movq " + source +  ", " + (stackPos * 8) + "(" + target + ")";
		}
		if (source == null && target != null) {
			return "movq " + fakeSource + ", " + target;
		} 

		if (source != null && target == null){
			return "movq " + source + ", " + fakeTarget;
		}

		return "movq " + fakeSource + ", " + fakeTarget;
	}
}