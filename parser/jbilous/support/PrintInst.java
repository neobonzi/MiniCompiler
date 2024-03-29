package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class PrintInst extends Instruction{

	public PrintInst(int source) {
		super();
		this.source = new Integer(source);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RCX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R9)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R10)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R11)));
		LeaQ formatLoad = new LeaQ(new AssemblyRegister(x86_64Reg.RIP), new AssemblyRegister(x86_64Reg.RDI));
		formatLoad.fromMem = true;
		formatLoad.varOffset = "L_.str";
		inst.add(formatLoad);
		inst.add(new MovQ(new ImmediateRegister("0"), new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new Call("_printf"));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R11)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R10)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R9)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RCX)));
		return inst;
	}

	public String toString() {
		return "print r" + source;
	}
}