package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class DeleteInst extends Instruction{
	Integer source;

	public DeleteInst(int source) {
		this.source = new Integer(source);
	}

	public String toString() {
		return "del r" + source;
	}
}