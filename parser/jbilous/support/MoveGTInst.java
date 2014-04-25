package jbilous.support;

import java.lang.String;

public class MoveGTInst extends Instruction{
	Integer value;
	Integer target;

	public MoveGTInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "movgt " + value + ", r" + target;
	}
}