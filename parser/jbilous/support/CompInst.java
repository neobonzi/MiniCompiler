package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;
import jbilous.support.assembly.*;
import java.util.Vector;

public class CompInst extends Instruction{

	public CompInst(int source1, int source2) {
		this.source2 = new Integer(source1);
		this.source = new Integer(source2);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Cmp(new VirtualRegister(source), new VirtualRegister(source2)));
		return inst;
	}

	public String toString() {
		return "comp r" + source + ", r" + source2 + ", ccr";
	}
}