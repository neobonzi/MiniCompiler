package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class ComputeGlobalAddrInst extends Instruction{
	String var;
	Integer target;
	public Type type;

	public ComputeGlobalAddrInst(String var, int target) {
		this.var = var;
		this.target = target;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		LeaQ globalMove = new LeaQ(new AssemblyRegister(x86_64Reg.RIP), new VirtualRegister(target));
		globalMove.fromMem = true;
		globalMove.varOffset = var;
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		return "computeglobaladdress " + var + ", r" + target;
	}
}