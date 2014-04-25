package jbilous.support;

import java.lang.String;

public class MoveInst extends Instruction{
	String id;
	Integer source;
	Integer target;

	public MoveInst(int source, int target) {
		this.source = new Integer(source);
		this.target = new Integer(target);
	}

	public String toString() {
		return "mov r" + source + ", r" + target;
	}
}