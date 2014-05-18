package jbilous.support;

import jbilous.support.lva.LVABlock;
import java.lang.String;

public class DivideInst extends Instruction{
	Integer source1;
	Integer source2;
	Integer target;

	public DivideInst(int source1, int source2, int target) {
		this.source1 = new Integer(source1);
		this.source2 = new Integer(source2);
		this.target = new Integer(target);
	}
	
	public String toString() {
		return "div r" + source1 + ", r" +  source2 + ", r" + target;
	}
}