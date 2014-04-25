package jbilous.support;

import java.lang.String;

public class MoveLTInst extends Instruction{
	Integer value;
	Integer target;

	public MoveLTInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "movlt " + value + ", r" + target;
	}
}