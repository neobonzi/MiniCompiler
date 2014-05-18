package jbilous.support;

import jbilous.support.assembly.*;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.VirtualRegister;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;
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

	public void updateLVA(LVABlock lvaBlock) {

	}

	public Vector<AssemblyInstruction> genAssembly() {
		return new Vector<AssemblyInstruction>();
	}

}