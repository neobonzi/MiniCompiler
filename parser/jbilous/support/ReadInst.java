package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class ReadInst extends Instruction{

	public ReadInst(int target) {
		super();
		this.target = new Integer(target);
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
		LeaQ formatLoad = new LeaQ(new AssemblyRegister(x86_64Reg.RIP), new AssemblyRegister(x86_64Reg.RDI));
		formatLoad.fromMem = true;
		formatLoad.varOffset = "L2_.str";
		inst.add(formatLoad);

		LeaQ addressLoad = new LeaQ(new AssemblyRegister(x86_64Reg.RBP), new AssemblyRegister(x86_64Reg.RSI));
		addressLoad.fromMem = true;
		addressLoad.setMe = true;
		inst.add(addressLoad);

		inst.add(new MovQ(new ImmediateRegister(0), new AssemblyRegister(x86_64Reg.RAX)));

		inst.add(new Call("_scanf"));
		
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R10)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R9)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.R8)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RSI)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RDX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RCX)));
		inst.add(new PopQ(new AssemblyRegister(x86_64Reg.RAX)));

		MovQ readMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), new VirtualRegister(target));
		readMove.fromMem = true;
		addressLoad.fromMem = true;
		readMove.relatedLoad = addressLoad;
		inst.add(readMove);

		return inst;
	}

	public String toString() {
		return "read r" + target;
	}
}