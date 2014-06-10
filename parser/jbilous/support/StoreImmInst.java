package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class StoreImmInst extends Instruction{
	public Integer offset;
	String stringTarget;
	Integer imm;

	public StoreImmInst(int imm, int source, String stringTarget) {
		this.imm = new Integer(imm);	
		this.offset = new Integer(0);
		this.source = new Integer(source);
		this.stringTarget = stringTarget;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ globalMove = new MovQ(new VirtualRegister(imm), new VirtualRegister(source));
		globalMove.toMem = true;
		System.out.println("store for " + stringTarget);
		globalMove.stackPos = (offset - 1) * 8;
		globalMove.setTargetAsSource();
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		return "storeai r" + imm + ", r" + source + ",  @" + stringTarget;
	}
}