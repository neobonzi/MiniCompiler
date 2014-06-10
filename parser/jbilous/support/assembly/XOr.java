package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class XOr extends AssemblyInstruction{

	public XOr(Register source, Register target) {
		super(source, target);
	}

	public String toString() {
		return "xor " + source_ass + ", " + target_ass;
	}
}