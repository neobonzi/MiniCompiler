package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class SubtractInst extends Instruction{

	public SubtractInst(int source1, int source2, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new VirtualRegister(source1), new VirtualRegister(target)));
		inst.add(new SubQ(new VirtualRegister(source2), new VirtualRegister(target)));
		return inst;
	}
	
	public String toString() {
		return "sub r" + source1 + ", r" +  source2 + ", r" + target;
	}
}