package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Instruction;
import jbilous.support.Register;

public class AssemblyInstruction extends Instruction{
	Register source;
	Register target;

	public AssemblyInstruction(Register source, Register target) {
		this.source = source;
		this.target = target;
	}

	public AssemblyInstruction(Register source) {
		this.source = source;
	}

	public AssemblyInstruction() {
	}
}