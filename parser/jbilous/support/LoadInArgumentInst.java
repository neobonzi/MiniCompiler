package jbilous.support;

import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;

public class LoadInArgumentInst extends Instruction{
	String id;
	Integer imm;
	Integer regNum;

	public LoadInArgumentInst(String id, int imm, int regNum) {
		this.id = id;
		this.imm = new Integer(imm);
		this.regNum = new Integer(regNum);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		switch(regNum) {
			case 0: inst.add(new MovQ(AssemblyRegister.RDI, regNum));
					break;
			case 1: inst.add(new MovQ(AssemblyRegister.RSI, regNum));
					break;
			case 2: inst.add(new MovQ(AssemblyRegister.RDX, regNum));
					break;
			case 3: inst.add(new MovQ(AssemblyRegister.RCX, regNum));
					break;
			case 4: inst.add(new MovQ(AssemblyRegister.R8, regNum));
					break;
			case 5: inst.add(new MovQ(AssemblyRegister.R9, regNum));
					break;
			default: MovQ newMove = new MovQ("", regNum));
					newMove.fromMem = true;
					newMove.stackPos = imm + 1;

		}
		return new Vector<AssemblyInstruction>();
	}

	public String toString() {
		return "loadinargument " + id + ", " +  imm + ", r" + regNum;
	}
}