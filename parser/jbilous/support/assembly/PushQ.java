package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class PushQ extends AssemblyInstruction{
	Register pushReg;

	public PushQ(Register source) {
		super(source);
	}
	public String toString() {
		return "pushq " + source_ass;
	}
}