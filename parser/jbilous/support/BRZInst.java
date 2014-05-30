package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class BRZInst extends Instruction{
	String label1;
	String label2;

	public BRZInst(int source, String label1, String label2) {
		this.source = new Integer(source);
		this.label1 = label1;
		this.label2 = label2;
	}

	public String toString() {
		return "brz r" + source + ", " +  label1 + ", " + label2;
	}
}