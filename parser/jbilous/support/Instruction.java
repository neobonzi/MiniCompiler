package jbilous.support;

import jbilous.support.assembly.*;
import java.util.Vector;

public class Instruction {
	
	Vector<Integer> registers;

	public Instruction() {
		registers = new Vector<Integer>();
	}

	public String toString() {
		String regs = new String();
		for (Integer regNum : registers) {
			regs += " " + regNum;
		}
		return regs;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		return new Vector<AssemblyInstruction>();
	}

}