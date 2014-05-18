package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;
import jbilous.support.assembly.*;
import java.util.Vector;

public class CompInst extends Instruction{
	Integer source1;
	Integer source2;

	public CompInst(int source1, int source2) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Cmp(new VirtualRegister(source1), new VirtualRegister(source2)));
		return inst;
	}

	public String toString() {
		return "comp r" + source1 + ", r" + source2 + ", ccr";
	}
}