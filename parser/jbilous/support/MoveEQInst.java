package jbilous.support;

import java.lang.String;

public class MoveEQInst extends Instruction{
	Integer value;
	Integer target;

	public MoveEQInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "moveq " + value + ", r" + target;
	}
}