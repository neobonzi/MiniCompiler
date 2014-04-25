package jbilous.support;

import java.lang.String;

public class CallInst extends Instruction{
	Integer argCount;
	String label;

	public CallInst(String label, int argCount) {
		this.argCount = new Integer(argCount);
		this.label = label;
	}

	public String toString() {
		return "call " + label + ", " +  argCount;
	}
}