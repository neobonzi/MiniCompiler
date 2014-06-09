package jbilous.support;

import jbilous.support.assembly.*;
import jbilous.support.lva.LVAIBlock;
import jbilous.support.assembly.VirtualRegister;
import jbilous.support.graph.InterferenceGraph;
import java.util.BitSet;
import java.util.Vector;

public class Instruction {

	Integer source;
	Integer target;
	Integer source2;
	public boolean isCritical;

	public Instruction() {
		isCritical = false;
	}

	public Integer getILSource() {
		return source;
	}

	public Integer getILTarget() {
		return target;
	}


	public Integer getILSource2() {
		return source2;
	}

	public void setILSource(Integer source) {
		this.source = source;
	}

	public void setILSource2(Integer source2) {
		this.source2 = source2;
	}

	public void updateILLVA(LVAIBlock lvaiBlock) {
		BitSet killSet = lvaiBlock.getKillSet();
		if(source != null && !killSet.get(source)) {
			lvaiBlock.addGen(source);
		}

		if(source2 != null && !killSet.get(source2)) {
			lvaiBlock.addGen(source2);
		}

		if(target != null) {
			lvaiBlock.addKill(target);
		}
	}

	public Vector<AssemblyInstruction> genAssembly() {
		return new Vector<AssemblyInstruction>();
	}

}