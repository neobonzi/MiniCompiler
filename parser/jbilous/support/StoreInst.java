package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class StoreInst extends Instruction{

	public StoreInst(int source, int target) {
		this.source = new Integer(source);	
		this.target = new Integer(target);
	}


	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ storeMove = new MovQ(new VirtualRegister(source), new VirtualRegister(target));
		storeMove.toMem = true;
		storeMove.stackPos = 0;
		inst.add(storeMove);
		return inst;
	}

	public String toString() {
		return "store r" + source + ", r" + target;
	}
}