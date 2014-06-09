package jbilous.support;

import java.lang.String;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.util.Vector;

public class AndInst extends Instruction{

	public AndInst(int source1, int source2, int target) {

		this.source = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new AndQ(new VirtualRegister(source), new VirtualRegister(source2)));
		inst.add(new MovQ(new VirtualRegister(source2), new VirtualRegister(target)));
		return inst;
	}

	public String toString() {
		return "and r" + source + ", r" +  source2 + ", r" + target;
	}
}