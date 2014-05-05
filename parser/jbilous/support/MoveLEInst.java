package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveLEInst extends Instruction{
	Integer value;
	Integer target;

	public MoveLEInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new CMovLE(new ImmediateRegister(value), new VirtualRegister(target)));
		return inst;
	}


	public String toString() {
		return "movle " + value + ", r" + target;
	}
}