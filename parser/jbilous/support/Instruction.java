package jbilous.support;

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
}