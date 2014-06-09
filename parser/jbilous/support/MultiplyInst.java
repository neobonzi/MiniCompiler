package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MultiplyInst extends Instruction{

	public MultiplyInst(int source1, int source2, int target) {
		this.source = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R8)));

		inst.add(new MovQ(new VirtualRegister(source2), new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new IMulQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new MovQ(new AssemblyRegister(x86_64Reg.R8), new VirtualRegister(target)));

		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		return inst;
	}
	
	public String toString() {
		return "mult r" + source + ", r" +  source2 + ", r" + target;
	}
}