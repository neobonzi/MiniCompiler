package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class ReturnInst extends Instruction{
	Integer source;

	public ReturnInst(int source) {
		this.source = new Integer(source);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RAX)));
		return inst;
	}

	public String toString() {
		return "storeret r" + source;
	}
}