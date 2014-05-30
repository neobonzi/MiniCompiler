package jbilous.support;

import java.lang.String;
import jbilous.support.lva.LVABlock;

public class AndInst extends Instruction{

	public AndInst(int source1, int source2, int target) {

		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}

	public String toString() {
		return "and r" + source1 + ", r" +  source2 + ", r" + target;
	}
}