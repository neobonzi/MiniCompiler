package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveNEInst extends Instruction{

	public MoveNEInst(int source, int target) {
		this.source = new Integer(source);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new CMovNE(new VirtualRegister(source), new VirtualRegister(target)));
		return inst;
	}

	public String toString() {
		return "movne r" + source + ", r" + target;
	}
}