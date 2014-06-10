package jbilous.support;

import java.lang.String;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.util.Vector;

public class XOrInst extends Instruction{

	public XOrInst(int source1, int source2, int target) {
		this.source = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.R8)));

		inst.add(new MovQ(new VirtualRegister(source2), new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new XOr(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new MovQ(new AssemblyRegister(x86_64Reg.R8), new VirtualRegister(target)));

		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		return inst;
	}

	public String toString() {
		return "xor r" + source + ", r" +  source2 + ", r" + target;
	}
}