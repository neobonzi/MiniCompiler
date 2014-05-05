package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class BranchInst extends Instruction{
	String label;

	public BranchInst(String label) {
		this.label = label;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Jump(label));
		return inst;
	}

	public String toString() {
		return "br "+ label;
	}
}