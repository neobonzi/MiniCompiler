package jbilous.support;

import java.util.Vector;
import jbilous.support.assembly.*;
import jbilous.support.copyprop.CPPair;
import java.util.ArrayList;
import jbilous.support.Register;

public class BasicBlock {

	public String label;
	public boolean funEntrance = false;
	public boolean funExit = false;
	public String funLabel = "null";
	public int numParams = 0;
	public Vector<Instruction> instructions;
	public Vector<AssemblyInstruction> assemInstructions;
	public Vector<BasicBlock> ancestors;
	public Vector<BasicBlock> descendants; 
	public ArrayList<CPPair> copyGen;
	public ArrayList<Integer> copyKill;
	public ArrayList<CPPair> copyIn;

	public BasicBlock(String label) {
		this.label = label;
		ancestors = new Vector<BasicBlock>();
		descendants = new Vector<BasicBlock>();
		instructions = new Vector<Instruction>();
		assemInstructions = new Vector<AssemblyInstruction>();
		copyGen = new ArrayList<CPPair>();
		copyKill = new ArrayList<Integer>();
		copyIn = new ArrayList<CPPair>();
	}
}
