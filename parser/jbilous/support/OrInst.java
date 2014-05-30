package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class OrInst extends Instruction{

	public OrInst(int source1, int source2, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public String toString() {
		return "or r" + source1 + ", r" +  source2 + ", r" + target;
	}
}