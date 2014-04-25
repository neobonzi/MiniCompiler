package jbilous.support;

import java.lang.String;

public class PrintInst extends Instruction{
	Integer source;

	public PrintInst(int source) {
		this.source = new Integer(source);
	}

	public String toString() {
		return "print r" + source;
	}
}