package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class DeleteInst extends Instruction{

	public DeleteInst(int source) {
		this.source = new Integer(source);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RCX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R9)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R10)));
		MovQ freeMove = new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RDI));
		inst.add(new Call("_free"));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R10)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R9)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RCX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RAX)));
		return inst;
	}

	public String toString() {
		return "del r" + source;
	}
}