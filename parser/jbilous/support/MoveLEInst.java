package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveLEInst extends Instruction{

	public MoveLEInst(int source, int target) {
		this.source = new Integer(source);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new CMovLE(new VirtualRegister(source), new VirtualRegister(target)));
		return inst;
	}
	
	public String toString() {
		return "movle r" + source + ", r" + target;
	}
}