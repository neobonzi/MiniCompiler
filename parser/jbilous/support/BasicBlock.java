package jbilous.support;

import java.util.Vector;

public class BasicBlock {

	public String label;
	public Vector<Instruction> instructions;
	public Vector<BasicBlock> ancestors;
	public Vector<BasicBlock> descendants; 

	public BasicBlock(String label) {
		this.label = label;
		ancestors = new Vector<BasicBlock>();
		descendants = new Vector<BasicBlock>();
		instructions = new Vector<Instruction>();
	}
}
