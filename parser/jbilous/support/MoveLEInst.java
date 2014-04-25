package jbilous.support;

import java.lang.String;

public class MoveLEInst extends Instruction{
	Integer value;
	Integer target;

	public MoveLEInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "movle " + value + ", r" + target;
	}
}