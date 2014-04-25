package jbilous.support;

import java.lang.String;

public class CBRNEInst extends Instruction{
	String label1;
	String label2;

	public CBRNEInst(String label1, String label2) {
		this.label1 = label1;
		this.label2 = label2;
	}

	public String toString() {
		return "cbrne cc, " + label1 + ", " + label2;
	}
}