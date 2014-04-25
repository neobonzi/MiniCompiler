package jbilous.support;

import java.lang.String;

public class LoadInArgumentInst extends Instruction{
	String id;
	Integer imm;
	Integer regNum;

	public LoadInArgumentInst(String id, int imm, int regNum) {
		this.id = id;
		this.imm = new Integer(imm);
		this.regNum = new Integer(regNum);
	}

	public String toString() {
		return "loadinargument " + id + ", " +  imm + ", r" + regNum;
	}
}