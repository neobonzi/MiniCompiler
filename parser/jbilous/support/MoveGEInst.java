package jbilous.support;

import java.lang.String;

public class MoveGEInst extends Instruction{
	Integer value;
	Integer target;

	public MoveGEInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "movge " + value + ", r" + target;
	}
}