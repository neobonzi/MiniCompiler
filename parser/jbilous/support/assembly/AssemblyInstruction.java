package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Instruction;
import jbilous.support.Register;
import java.util.BitSet;
import jbilous.support.lva.LVABlock;
import jbilous.support.assembly.VirtualRegister;
import jbilous.support.graph.InterferenceGraph;

public class AssemblyInstruction extends Instruction{
	Register source_ass;
	Register source2_ass;
	Register target_ass;
	boolean targetSpill;
	boolean sourceSpill;

	public AssemblyInstruction(Register source, Register target) {
		super();
		this.source_ass = source;
		this.target_ass = target;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction(Register source1, Register source2, Register target) {
		super();
		this.source_ass = source1;
		this.source2_ass = source2;
		this.target_ass = target;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction(Register source) {
		super();
		this.source_ass = source;
		this.targetSpill = this.sourceSpill = false;
	}

	public AssemblyInstruction() {
		super();
		this.targetSpill = this.sourceSpill = false;
	}

	public Register getSourceReg() {
		return source_ass;
	}

	public Register getSource() {
		return source_ass;
	}

	public Register getSource2()
	{
		return source2_ass;
	}

	public void setSource(Register source) {
		this.source_ass = source;
	}

	public void setSource2(Register source) {
		this.source2_ass = source;
	}

	public void setTarget(Register target) {
		this.target_ass = target;
	}

	public Register getTarget() {
		return target_ass;
	}

	public BitSet updateRegisters(InterferenceGraph intGraph) {
		BitSet result = new BitSet(3);

		if(target_ass != null) {
			if(target_ass instanceof VirtualRegister) {
				VirtualRegister vr = (VirtualRegister)target_ass;
				System.out.println("get color for " + vr.getRegNum());
				Integer ordinal = intGraph.getColor(vr.getRegNum());
				if(ordinal < 0) {
					result.set(2);
				} else {
					AssemblyRegister ar = new AssemblyRegister(x86_64Reg.values()[ordinal.intValue()]);
					target_ass = ar;
				}
			}
		}
 
		if(source_ass != null) {
			if(source_ass instanceof VirtualRegister) {
				VirtualRegister vrs = (VirtualRegister)source_ass;
				System.out.println("get color for " + vrs.getRegNum());
				Integer ordinals = intGraph.getColor(vrs.getRegNum());
				if(ordinals < 0) {
					this.sourceSpill = true;
					result.set(0);
				} else {
					AssemblyRegister ars = new AssemblyRegister(x86_64Reg.values()[ordinals.intValue()]);
					source_ass = ars;
				}
			}
		}

		if(source2_ass != null) {
			if(source2_ass instanceof VirtualRegister) {
				VirtualRegister vrs2 = (VirtualRegister)source2_ass;
				System.out.println("get color for " + vrs2.getRegNum());
				Integer ordinals = intGraph.getColor(vrs2.getRegNum());
				if(ordinals < 0) {
					this.sourceSpill = true;
					result.set(1);
				} else {
					AssemblyRegister ars2 = new AssemblyRegister(x86_64Reg.values()[ordinals.intValue()]);
					source2_ass = ars2;
				}
			}
		}
		return result;
	}

	public void updateGraph(BitSet liveNow, InterferenceGraph intGraph) {
        // Add edge between target and all the registers in liveNow
        if(target_ass != null) {
        	if(target_ass instanceof VirtualRegister) {
	            VirtualRegister vr = (VirtualRegister)target_ass;
	            boolean nodeAdded = false;
	            for(int nodeNum = 0; nodeNum < liveNow.length(); nodeNum++ ) {
	                if(liveNow.get(nodeNum)) {
	                    intGraph.addEdge(vr.getRegNum(), new Integer(nodeNum));
	                    nodeAdded = true;
	                }
	            }
	            if(!nodeAdded)
	            {
	            	System.out.println("adding node " + vr.getRegNum() + " cuz nothing in live out");
	            	intGraph.addNode(vr.getRegNum());
	            }
	            //Remove target from liveNow
	            liveNow.clear(vr.getRegNum());
        	} else if (target_ass instanceof AssemblyRegister) {
        		AssemblyRegister ar = (AssemblyRegister)target_ass;

	            for(int nodeNum = 0; nodeNum < liveNow.length(); nodeNum++ ) {
	                if(liveNow.get(nodeNum)) {
	                    intGraph.addEdge(ar.getRegister().ordinal(), new Integer(nodeNum));
	                }
	            }
	            //Remove target from liveNow
	            liveNow.clear(ar.getRegister().ordinal());
        	}
        }

        if(source_ass != null && source_ass instanceof VirtualRegister) {
           // Add sources to liveNow
           VirtualRegister vrSource = (VirtualRegister)source_ass;
           liveNow.set(vrSource.getRegNum());
        }

        if(source2_ass != null && source2_ass instanceof VirtualRegister) {
           // Add sources to liveNow
           VirtualRegister vrSource2 = (VirtualRegister)source2_ass;
           liveNow.set(vrSource2.getRegNum());
        }
	}

	public void updateLVA(LVABlock lvaBlock) {
		if(source_ass != null) {
			lvaBlock.addGen(source_ass);
		}

		if(target_ass != null) {
			lvaBlock.addKill(target_ass);
		}
	}
}