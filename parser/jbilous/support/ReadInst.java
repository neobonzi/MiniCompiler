package jbilous.support;

import java.lang.String;

public class ReadInst extends Instruction{
	Integer target;

	public ReadInst(int target) {
		this.target = new Integer(target);
	}

	public String toString() {
		return "read r" + target;
	}
}