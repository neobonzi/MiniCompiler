package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Instruction;
import jbilous.support.Register;
import java.util.BitSet;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.VirtualRegister;
import jbilous.support.graph.InterferenceGraph;

public class AssemblyInstruction extends Instruction{
	Register source;
	Register source2;
	Register target;
	boolean targetSpill;
	boolean sourceSpill;

	public AssemblyInstruction(Register source, Register target) {
		this.source = source;
		this.target = target;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction(Register source1, Register source2, Register target) {
		this.source = source1;
		this.source2 = source2;
		this.target = target;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction(Register source) {
		this.source = source;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction() {
		this.targetSpill = this.sourceSpill = false;
	}

	public Register getSource() {
		return source;
	}

	public void setSource(Register source) {
		this.source = source;
	}

	public void setSource2(Register source) {
		this.source2 = source;
	}

	public void setTarget(Register target) {
		this.target = target;
	}

	public Register getTarget() {
		return target;
	}

	public BitSet updateRegisters(InterferenceGraph intGraph) {
		BitSet result = new BitSet(3);
		if(target != null) {
			if(target instanceof VirtualRegister) {
				VirtualRegister vr = (VirtualRegister)target;
				Integer ordinal = intGraph.getColor(vr.getRegNum());
				if(ordinal < 0) {
					result.set(2);
				} else {
					AssemblyRegister ar = new AssemblyRegister(x86_64Reg.values()[ordinal.intValue()]);
					target = ar;
				}
			}
		}
 
		if(source != null) {
			if(source instanceof VirtualRegister) {
				VirtualRegister vrs = (VirtualRegister)source;
				Integer ordinals = intGraph.getColor(vrs.getRegNum());
				if(ordinals < 0) {
					this.sourceSpill = true;
					result.set(0);
				} else {
					AssemblyRegister ars = new AssemblyRegister(x86_64Reg.values()[ordinals.intValue()]);
					source = ars;
				}
			}
		}

		if(source2 != null) {
			if(source instanceof VirtualRegister) {
				VirtualRegister vrs2 = (VirtualRegister)source;
				Integer ordinals = intGraph.getColor(vrs2.getRegNum());
				if(ordinals < 0) {
					this.sourceSpill = true;
					result.set(1);
				} else {
					AssemblyRegister ars2 = new AssemblyRegister(x86_64Reg.values()[ordinals.intValue()]);
					source2 = ars2;
				}
			}
		}
		return result;
	}

	public void updateGraph(BitSet liveNow, InterferenceGraph intGraph) {
        // Add edge between target and all the registers in liveNow
        if(target != null) {
        	if(target instanceof VirtualRegister) {
	            VirtualRegister vr = (VirtualRegister)target;
	            System.out.println("updating graph to include " + vr.getRegNum());
	            System.out.println(liveNow);
	            for(int nodeNum = 0; nodeNum < liveNow.length(); nodeNum++ ) {
	                if(liveNow.get(nodeNum)) {
	                    intGraph.addEdge(vr.getRegNum(), new Integer(nodeNum));
	                }
	            }
	           
	            //Remove target from liveNow
	            liveNow.clear(vr.getRegNum());
        	} else if (target instanceof AssemblyRegister) {
        		AssemblyRegister ar = (AssemblyRegister)target;

	            for(int nodeNum = 0; nodeNum < liveNow.length(); nodeNum++ ) {
	                if(liveNow.get(nodeNum)) {
	                    intGraph.addEdge(ar.getRegister().ordinal(), new Integer(nodeNum));
	                }
	            }
	            //Remove target from liveNow
	            liveNow.clear(ar.getRegister().ordinal());
        	}
        }

        if(source != null && source instanceof VirtualRegister) {
           // Add sources to liveNow
           VirtualRegister vrSource = (VirtualRegister)source;
           liveNow.set(vrSource.getRegNum());
        }

        if(source2 != null && source2 instanceof VirtualRegister) {
           // Add sources to liveNow
           VirtualRegister vrSource2 = (VirtualRegister)source2;
           liveNow.set(vrSource2.getRegNum());
        }
	}

	public void updateLVA(LVABlock lvaBlock) {
		if(source != null) {
			lvaBlock.addGen(source);
		}

		if(target != null) {
			lvaBlock.addKill(target);
		}
	}
}