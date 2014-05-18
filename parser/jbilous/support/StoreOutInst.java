package jbilous.support;

import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.*;
import java.lang.String;
import java.util.Vector;


public class StoreOutInst extends Instruction{
	Integer source;
	Integer argNum;

	public StoreOutInst(int source, int argNum) {
		this.source = new Integer(source);
		this.argNum = new Integer(argNum);
	}

	public Vector<AssemblyInstruction> genAssembly() {
		Vector<AssemblyInstruction> inst = new Vector<AssemblyInstruction>();
		VirtualRegister virtualSource = new VirtualRegister(source);
		switch(argNum) {
			case 0: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.RDI)));
					break;
			case 1: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.RSI)));
					break;
			case 2: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.RDX)));
					break;
			case 3: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.RCX)));
					break;
			case 4: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.R8)));
					break;
			case 5: inst.add(new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.R9)));
					break;
			default: MovQ newMove = new MovQ(virtualSource, new AssemblyRegister(x86_64Reg.RBP));
					newMove.toMem = true;
					newMove.stackPos = argNum + 1;
					inst.add(newMove);
		}
		return inst;
	}

	public String toString() {
		return "storeoutargument r" + source + ", " + argNum;
	}
}