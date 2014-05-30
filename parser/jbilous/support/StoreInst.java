package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class StoreInst extends Instruction{

	public StoreInst(int source, int target) {
		this.source = new Integer(source);	
		this.target = new Integer(target);
	}

	public String toString() {
		return "store r" + source + ", r" + target;
	}
}