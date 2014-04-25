package jbilous.support;

import java.lang.String;

public class CompImmInst extends Instruction{
	Integer source;
	Integer value;

	public CompImmInst(int source, int value) {
		this.source = new Integer(source);
		this.value = new Integer(value);
	}

	public String toString() {
		return "compi r" + source + ", " + value + ", ccr";
	}
}