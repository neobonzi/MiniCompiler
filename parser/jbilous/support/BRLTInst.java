package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class BRLTInst extends Instruction{
	String label1;
	String label2;

	public BRLTInst(String label1, String label2) {
		this.label1 = label1;
		this.label2 = label2;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new JumpL(label1));
		inst.add(new Jump(label2));
		return inst;
	}

	public String toString() {
		return "cbrlt cc, " + label1 + ", " + label2;
	}
}