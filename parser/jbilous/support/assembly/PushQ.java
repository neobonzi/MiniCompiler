package jbilous.support.assembly;

import java.lang.String;
import jbilous.support.Register;

public class PushQ extends AssemblyInstruction{

	public PushQ(Register source) {
		super(source, null);
	}
	public String toString() {
		return "pushq " + source;
	}
}