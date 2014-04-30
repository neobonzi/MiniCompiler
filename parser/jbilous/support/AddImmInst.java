package jbilous.support;

import java.lang.String;

public class AddImmInst extends Instruction{
	Integer source;
	String sourceString;
	String imm;
	Integer target;

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