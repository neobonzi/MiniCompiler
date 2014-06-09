package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class IDivQ extends AssemblyInstruction{

	public IDivQ(Register source) {
		super(source);
	}

	public String toString() {
		return "idivq " + source_ass;
	}
}