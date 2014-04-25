package jbilous.support;

import java.lang.String;

public class CompInst extends Instruction{
	Integer source1;
	Integer source2;

	public CompInst(int source1, int source2) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
	}

	public String toString() {
		return "comp r" + source1 + ", r" + source2 + ", ccr";
	}
}