package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class AndQ extends AssemblyInstruction{

	public AndQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "andq " + source_ass + ", " + target_ass;
	}
}