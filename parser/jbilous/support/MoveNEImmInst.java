package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveNEImmInst extends Instruction{

	public MoveNEImmInst(int source, int target) {
		this.source = new Integer(source);
		this.source2 = new Integer(target);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new MovQ(new ImmediateRegister(source), new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new CMovNE(new AssemblyRegister(x86_64Reg.R8), new VirtualRegister(target)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		return inst;
	}

	public String toString() {
		return "movne " + source + ", r" + target;
	}
}