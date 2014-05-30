package jbilous.support.lva;

import java.util.BitSet;
import java.util.Vector;
import java.lang.String;
import java.lang.Integer;
import jbilous.support.Register;
import jbilous.support.assembly.AssemblyRegister;
import jbilous.support.assembly.VirtualRegister;

public class LVAIBlock {
	public String label;
	BitSet genSet, killSet, liveOutSet;

	public LVAIBlock(String blockLabel) {
		this.label = blockLabel;
		genSet = new BitSet();
		killSet = new BitSet();
		liveOutSet = new BitSet();
	}

	public void addGen(Integer reg) {
		if(!killSet.get(reg)) {
			genSet.set(reg);
		}
	}

	public void addKill(Integer reg) {
		genSet.clear(reg);
	}

	public BitSet getGenSet() {
		return genSet;
	}

	public BitSet getKillSet() {
		return killSet;
	}

	public Boolean adaptLiveOut(Vector<LVAIBlock> descs) {
		BitSet newLiveOut = new BitSet();
		boolean updated = false;
		for(LVAIBlock desc : descs) {
			System.out.println("working with " + desc.label);
			BitSet descLiveOut = (BitSet)desc.getLiveOut().clone();
			descLiveOut.andNot(desc.getKillSet());
			descLiveOut.or(desc.getGenSet());
			newLiveOut.or(descLiveOut);
		}
		updated = !newLiveOut.equals(liveOutSet);
		if(updated) {
			System.out.println("Changed from " + label + ":" + liveOutSet + " " + newLiveOut);
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