package jbilous.support;

import java.lang.String;

public class LoadInst extends Instruction{
	String source;
	Integer target;

	public LoadInst(String source, int target) {
		this.source = source;
		this.target = target;
	}

	public String toString() {
		return "load @r" + source + ", r" + target;
	}
}