package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class CompImmInst extends Instruction{
	Integer source;
	Integer value;

	public CompImmInst(int source, int value) {
		this.source = new Integer(source);
		this.value = new Integer(value);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Cmp(new ImmediateRegister(value), new VirtualRegister(source)));
		return inst;
	}

	public String toString() {
		return "compi r" + source + ", " + value + ", ccr";
	}
}