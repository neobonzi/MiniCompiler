package jbilous.support;

import java.lang.String;

public class LoadRetInst extends Instruction{
	Integer source;

	public LoadRetInst(int source) {
		this.source = new Integer(source);
	}

	public String toString() {
		return "loadret r" + source;
	}
}