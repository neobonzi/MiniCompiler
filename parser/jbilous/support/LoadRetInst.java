package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class LoadRetInst extends Instruction{
	Integer source;

	public LoadRetInst(int source) {
		this.source = new Integer(source);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RAX), new VirtualRegister(source)));
		return inst;
	}

	public String toString() {
		return "loadret r" + source;
	}
}