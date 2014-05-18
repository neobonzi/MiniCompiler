package jbilous.support;

import jbilous.support.lva.LVABlock;
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
		LeaQ formatLoad = new LeaQ(new AssemblyRegister(x86_64Reg.RIP), new AssemblyRegister(x86_64Reg.RDI));
		formatLoad.fromMem = true;
		formatLoad.varOffset = "L_.str";
		inst.add(formatLoad);
		inst.add(new MovQ(new ImmediateRegister("0"), new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new Call("_printf"));
		return inst;
	}

	public String toString() {
		return "print r" + source;
	}
}