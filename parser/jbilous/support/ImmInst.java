package jbilous.support;

import java.lang.String;

public class ImmInst extends Instruction{
	Integer value;
	Integer target;

	public ImmInst(int value, int target) {
		this.value = new Integer(value);
		this.target = new Integer(target);
	}

	public String toString() {
		return "loadi " + value + ", r" + target;
	}
}