package jbilous.support;

import java.lang.String;

public class LoadAIInst extends Instruction{
	Integer source;
	String sourceString;
	String value;
	Integer target;
	boolean isVar;

	public LoadAIInst(String sourceString, String value, int target) {
		this.isVar = true;
		this.sourceString = sourceString;
		this.value = value;
		this.target = target;
	}

	public LoadAIInst(int source, String value, int target) {
		this.isVar = false;
		this.source = new Integer(source);
		this.value = value;
		this.target = target;
	}

	public String toString() {
		if (isVar) {
			return "loadAI r" + sourceString + ", @" + value + ", r" + target;
		} else {
			return "loadAI r" + source + ", @" + value + ", r" + target;
		}
	}
}