package jbilous.support;

import java.lang.String;

public class AddInst extends Instruction{
	Integer source1;
	Integer source2;
	Integer target;

	public AddInst(int source1, int source2, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public String toString() {
		return "add r" + source1 + ", r" +  source2 + ", r" + target;
	}
}