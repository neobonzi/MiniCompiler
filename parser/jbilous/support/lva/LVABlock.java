package jbilous.support.lva;

import java.util.BitSet;
import java.util.Vector;
import java.lang.String;
import java.lang.Integer;
import jbilous.support.Register;
import jbilous.support.assembly.AssemblyRegister;
import jbilous.support.assembly.VirtualRegister;

public class LVABlock {
	String label;
	BitSet genSet, killSet, liveOutSet;

	public LVABlock(String blockLabel) {
		this.label = blockLabel;
		genSet = new BitSet();
		killSet = new BitSet();
		liveOutSet = new BitSet();
	}

	public void addGen(Register reg) {
		if(reg instanceof VirtualRegister) {
			VirtualRegister vr = (VirtualRegister)reg;
			if(!killSet.get(vr.getRegNum())) {
				genSet.set(vr.getRegNum());
			}
		} else if (reg instanceof AssemblyRegister) {
			AssemblyRegister ar = (AssemblyRegister)reg;
			if(!killSet.get(ar.getRegister().ordinal())) {
				genSet.set(ar.getRegister().ordinal());
			}
		}
	}

	public void addKill(Register reg) {
		if(reg instanceof VirtualRegister) {
			VirtualRegister vr = (VirtualRegister)reg;
			genSet.clear(vr.getRegNum());
		} else if (reg instanceof AssemblyRegister) {
			AssemblyRegister ar = (AssemblyRegister)reg;
			genSet.clear(ar.getRegister().ordinal());
		}
	}

	public BitSet getGenSet() {
		return genSet;
	}

	public BitSet getKillSet() {
		return killSet;
	}

	public Boolean adaptLiveOut(Vector<LVABlock> descs) {
		BitSet newLiveOut = new BitSet();
		boolean updated = false;
		for(LVABlock desc : descs) {
			BitSet descLiveOut = (BitSet)desc.getLiveOut().clone();
			descLiveOut.andNot(desc.getKillSet());
			descLiveOut.or(desc.getGenSet());
			newLiveOut.or(descLiveOut);
		}
		updated = !newLiveOut.equals(liveOutSet);
		if(updated) {
			liveOutSet = newLiveOut;
		}
		return updated;
	}

	public BitSet getLiveOut() {
		return this.liveOutSet;
	}

	public String toString() {
		return label + " Gen: " + genSet.toString() + ", Kill: " + killSet.toString() + ", LO: " + liveOutSet.toString();
	}
}