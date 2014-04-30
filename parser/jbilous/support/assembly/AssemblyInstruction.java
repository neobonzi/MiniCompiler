package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Instruction;

public class AssemblyInstruction extends Instruction{
	AssemblyRegister source;
	AssemblyRegister target;
	String fakeSource;
	String fakeTarget;

	public AssemblyInstruction(AssemblyRegister source, AssemblyRegister target) {
		this.source = source;
		this.target = target;
	}

	public AssemblyInstruction(String fakeSource, String fakeTarget) {
		this.fakeSource = fakeSource;
		this.fakeTarget = fakeTarget;
	}

	public AssemblyInstruction(AssemblyRegister source) {
		this.source = source;
	}

	public AssemblyInstruction() {
	}
}