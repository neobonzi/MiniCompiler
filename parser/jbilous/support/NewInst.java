package jbilous.support;

import java.lang.String;

public class NewInst extends Instruction{
	String var;
	Integer target;

	public NewInst(String var, int target) {
		this.var = var;
		this.target = target;
	}

	public String toString() {
		return "new " + var + ", r" + target;
	}
}