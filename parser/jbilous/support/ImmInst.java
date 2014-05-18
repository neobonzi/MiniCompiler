package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class ImmInst extends Instruction{
	Integer value;
	Integer target;

	public ImmInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new ImmediateRegister(value), new VirtualRegister(target)));
		return inst;
	}

	public String toString() {
		return "loadi " + value + ", r" + target;
	}
}