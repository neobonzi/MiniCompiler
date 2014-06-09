package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.Register;
import jbilous.support.assembly.*;
import java.util.Vector;
import java.lang.String;

public class DivideInst extends Instruction{
	
	public DivideInst(int source1, int source2, int target) {
		this.source = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PushQ(new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new MovQ(new ImmediateRegister(0), new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new CQTo());
		inst.add(new IDivQ(new VirtualRegister(source2)));
		inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RAX), new VirtualRegister(target)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RAX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDX)));
		return inst;
	}
	
	public String toString() {
		return "div r" + source + ", r" +  source2 + ", r" + target;
	}
}