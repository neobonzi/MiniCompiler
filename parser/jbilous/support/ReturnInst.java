package jbilous.support;

import java.lang.String;

public class ReturnInst extends Instruction{
	Integer source;

	public ReturnInst(int source) {
		this.source = new Integer(source);
	}

	public String toString() {
		return "storeret r" + source;
	}
}