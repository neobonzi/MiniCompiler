package jbilous.support;

import java.lang.String;

public class StoreImmInst extends Instruction{
	Integer source;
	String target;
	Integer imm;

	public StoreImmInst(int imm, int source, String target) {
		this.imm = new Integer(imm);	
		this.source = new Integer(source);
		this.target = target;
	}

	public String toString() {
		return "storeai r" + imm + ", r" + source + ",  @" + target;
	}
}