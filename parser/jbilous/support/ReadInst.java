package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class ReadInst extends Instruction{
	Integer target;

	public ReadInst(int target) {
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new ImmediateRegister(".LLC0"), new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new MovQ(new VirtualRegister(target), new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new MovQ(new ImmediateRegister("0"), new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new Call("scanf"));
		return inst;
	}

	public String toString() {
		return "read r" + target;
	}
}