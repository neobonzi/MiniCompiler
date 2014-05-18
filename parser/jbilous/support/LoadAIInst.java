package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class LoadAIInst extends Instruction{
	Integer source;
	String sourceString;
	public Integer offset;
	String value;
	Integer target;
	boolean isVar;

	public LoadAIInst(String sourceString, String value, int target) {
		this.isVar = true;
		this.offset = new Integer(0);
		this.sourceString = sourceString;
		this.value = value;
		this.target = target;
	}

	public LoadAIInst(int source, String value, int target) {
		this.isVar = false;
		this.source = new Integer(source);
		this.offset = new Integer(0);
		this.value = value;
		this.target = target;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ globalMove = new MovQ(new VirtualRegister(source), new VirtualRegister(target));
		globalMove.fromMem = true;
		Integer alignedOffset = offset * 8;
		globalMove.varOffset = alignedOffset.toString();
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		if (isVar) {
			return "loadAI r" + sourceString + ", @" + value + ", r" + target;
		} else {
			return "loadAI r" + source + ", @" + value + ", r" + target;
		}
	}
}