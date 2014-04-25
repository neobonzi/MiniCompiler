package jbilous.support;

import java.lang.String;

public class StoreOutInst extends Instruction{
	Integer source;
	Integer argNum;

	public StoreOutInst(int source, int argNum) {
		this.source = new Integer(source);
		this.argNum = new Integer(argNum);
	}

	public String toString() {
		return "storeoutargument r" + source + ", " + argNum;
	}
}