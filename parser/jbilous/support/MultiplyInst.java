package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MultiplyInst extends Instruction{
	Integer source1;
	Integer source2;
	Integer target;

	public MultiplyInst(int source1, int source2, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new VirtualRegister(source1), new VirtualRegister(target)));
		inst.add(new IMulQ(new VirtualRegister(source2), new VirtualRegister(target)));
		return inst;
	}
	
	public String toString() {
		return "mult r" + source1 + ", r" +  source2 + ", r" + target;
	}
}