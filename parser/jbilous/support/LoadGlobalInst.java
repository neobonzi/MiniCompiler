package jbilous.support;

import java.lang.String;

public class LoadGlobalInst extends Instruction{
	String sourceString;
	Integer target;

	public LoadGlobalInst(String sourceString, int target) {
		this.sourceString = sourceString;
		this.target = target;
	}

	public String toString() {
		return "loadglobal @" + sourceString + ", r" + target;
	}
}