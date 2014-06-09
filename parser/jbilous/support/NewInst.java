package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class NewInst extends Instruction{
	String var;
	public Integer size;
	public Integer assReg;

	public NewInst(String var, int target) {
		this.var = var;
		this.target = target;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new ImmediateRegister(size), new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new Call("_malloc"));
		inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RAX), new VirtualRegister(target)));
		return inst;
	}
	
	public String toString() {
		return "new " + var + ", r" + target;
	}
}