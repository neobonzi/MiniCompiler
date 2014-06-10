package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class StoreGlobalInst extends Instruction{
	String targetString;
	
	public StoreGlobalInst(int source, String targetString) {
		this.targetString = targetString;
		this.source = source;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ globalMove = new MovQ(new VirtualRegister(source), new AssemblyRegister(x86_64Reg.RIP));
		globalMove.toMem = true;
		globalMove.globalStackOffset = targetString;
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		return "storeglobal r" + source + ", @" + targetString;
	}
}