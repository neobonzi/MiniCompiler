package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import jbilous.support.assembly.x86_64Reg;
import java.lang.String;
import java.util.Vector;

public class CallInst extends Instruction{
	Integer argCount;
	String label;

	public CallInst(String label, int argCount) {
		this.argCount = new Integer(argCount);
		this.label = label;
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
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R11)));
		inst.add(new Call(label));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R11)));
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
		return "call " + label + ", " +  argCount;
	}
}