package jbilous.support;

import java.lang.String;

public class AddImmInst extends Instruction{
	Integer source1;
	Integer source2;
	Integer target;

	public AddImmInst(int source1, String imm, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public String toString() {
		return "addi rarp, " +  source2 + ", r" + target;
	}
}