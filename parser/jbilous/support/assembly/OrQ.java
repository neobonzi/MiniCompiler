package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class OrQ extends AssemblyInstruction{

	public OrQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "orq " + source_ass + ", " + target_ass;
	}
}