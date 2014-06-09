package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveGEInst extends Instruction{

	public MoveGEInst(int source, int target) {
		this.source = new Integer(source);
		this.source2 = new Integer(target);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new CMovGE(new VirtualRegister(source), new VirtualRegister(target)));
		return inst;
	}

	public String toString() {
		return "movge r" + source + ", r" + target;
	}
}