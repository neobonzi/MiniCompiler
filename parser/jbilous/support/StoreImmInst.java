package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class StoreImmInst extends Instruction{
	Integer source;
	public Integer offset;
	String target;
	Integer imm;

	public StoreImmInst(int imm, int source, String target) {
		this.imm = new Integer(imm);	
		this.offset = new Integer(0);
		this.source = new Integer(source);
		this.target = target;
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		MovQ globalMove = new MovQ(new VirtualRegister(imm), new VirtualRegister(source));
		globalMove.toMem = true;
		globalMove.varOffset = offset.toString();
		inst.add(globalMove);
		return inst;
	}

	public String toString() {
		return "storeai r" + imm + ", r" + source + ",  @" + target;
	}
}