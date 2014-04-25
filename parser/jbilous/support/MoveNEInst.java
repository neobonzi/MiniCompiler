package jbilous.support;

import java.lang.String;

public class MoveNEInst extends Instruction{
	Integer value;
	Integer target;

	public MoveNEInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "movne " + value + ", r" + target;
	}
}