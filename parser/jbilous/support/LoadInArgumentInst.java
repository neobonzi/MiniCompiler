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
		VirtualRegister virtualTarget = new VirtualRegister(regNum);
		switch(regNum) {
			case 0: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RDI), virtualTarget));
					break;
			case 1: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RSI), virtualTarget));
					break;
			case 2: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RDX), virtualTarget));
					break;
			case 3: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.RCX), virtualTarget));
					break;
			case 4: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.R8), virtualTarget));
					break;
			case 5: inst.add(new MovQ(new AssemblyRegister(x86_64Reg.R9), virtualTarget));
					break;
			default: MovQ newMove = new MovQ(new AssemblyRegister(x86_64Reg.RBP), virtualTarget);
					newMove.fromMem = true;
					newMove.stackPos = imm + 1;
					inst.add(newMove);

		}
		return inst;
	}

	public String toString() {
		return "loadinargument " + id + ", " +  imm + ", r" + regNum;
	}
}