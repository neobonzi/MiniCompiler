package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class LoadGlobalInst extends Instruction{
	String sourceString;
	
	public LoadGlobalInst(String sourceString, int target) {
		this.sourceString = sourceString;
		this.target = target;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ globalMove = new MovQ(new AssemblyRegister(x86_64Reg.RIP), new VirtualRegister(target));
		globalMove.fromMem = true;
		globalMove.varOffset = sourceString;
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		return "loadglobal @" + sourceString + ", r" + target;
	}
}