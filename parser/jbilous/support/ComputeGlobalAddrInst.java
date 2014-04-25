package jbilous.support;

import java.lang.String;

public class ComputeGlobalAddrInst extends Instruction{
	String var;
	Integer target;

	public ComputeGlobalAddrInst(String var, int target) {
		this.var = var;
		this.target = target;
	}

	public String toString() {
		return "computeglobaladdress " + var + ", r" + target;
	}
}