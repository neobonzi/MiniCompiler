package jbilous.support;

import java.lang.String;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.VirtualRegister;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;

public class AddImmInst extends Instruction{
	String sourceString;
	String imm;

	public AddImmInst(int source, String imm, int target) {
		this.source = new Integer(source);
		this.imm = imm;
		this.target = new Integer(target);
	}

	public AddImmInst(String source, String imm, int target) {
		this.sourceString = source;
		this.imm = imm;
		this.target = new Integer(target);
	}
	public String toString() {
		if (sourceString != null) {
			return "addi r" + sourceString + ",  " +  imm + ", r" + target;
		} else {
			return "addi r" + source + ", " + imm + ", r" + target;
		}
	}
}