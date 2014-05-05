package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class PrintInst extends Instruction{
	Integer source;

	public PrintInst(int source) {
		this.source = new Integer(source);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new ImmediateRegister(".LLC0"), new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new MovQ(new ImmediateRegister("0"), new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new Call("printf"));
		return inst;
	}

	public String toString() {
		return "print r" + source;
	}
}