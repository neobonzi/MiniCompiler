package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveNEInst extends Instruction{
	Integer value;
	Integer target;

	public MoveNEInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new CMovNE(new ImmediateRegister(value), new VirtualRegister(target)));
		return inst;
	}

	public String toString() {
		return "movne " + value + ", r" + target;
	}
}