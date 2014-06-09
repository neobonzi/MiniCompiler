package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class CompImmInst extends Instruction{
	Integer value;

	public CompImmInst(int imm, int regNum) {
		this.value = new Integer(imm);
		this.source = new Integer(regNum);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Cmp(new ImmediateRegister(value), new VirtualRegister(source)));
		return inst;
	}

	public String toString() {
		return "compi " + value + ", r" + source + ", ccr";
	}
}