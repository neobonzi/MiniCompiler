package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class CallInst extends Instruction{
	Integer argCount;
	String label;

	public CallInst(String label, int argCount) {
		this.argCount = new Integer(argCount);
		this.label = label;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Call(label));
		return inst;
	}

	public String toString() {
		return "call " + label + ", " +  argCount;
	}
}