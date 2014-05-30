package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class LoadInst extends Instruction{
	String sourceString;

	public LoadInst(String sourceString, int target) {
		this.sourceString = source;
		this.target = target;
	}

	public String toString() {
		return "load @r" + sourceString + ", r" + target;
	}
}