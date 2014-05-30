package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class BREQInst extends Instruction{
	String label1;
	String label2;

	public BREQInst(String label1, String label2) {
		this.label1 = label1;
		this.label2 = label2;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new JumpE(label1));
		inst.add(new Jump(label2));
		return inst;
	}

	public String toString() {
		return "cbreq cc, " + label1 + ", " + label2;
	}
}