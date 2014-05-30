package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class AddQ extends AssemblyInstruction{

	public AddQ(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "addq " + source_ass + ", " + target_ass;
	}
}