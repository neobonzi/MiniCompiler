package jbilous.support;

import jbilous.support.assembly.*;
import jbilous.support.lva.LVABlock;
import java.lang.String;
import java.util.Vector;

public class RetInst extends Instruction{

	public RetInst() {
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		inst.add(new Ret());
		return inst;
	}

	public String toString() {
		return "ret true";
	}
}