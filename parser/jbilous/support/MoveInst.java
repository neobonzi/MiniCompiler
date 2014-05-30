package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class MoveInst extends Instruction{
	String id;

	public MoveInst(int source, int target) {
		this.source = new Integer(source);
		this.target = new Integer(target);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new MovQ(new VirtualRegister(source), new VirtualRegister(target)));
		return inst;
	}

	public Integer getSource() {
		return source;
	}

	public Integer getTarget() {
		return target;
	}

	public String toString() {
		return "mov r" + source + ", r" + target;
	}
}