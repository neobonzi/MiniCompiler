package jbilous.support.assembly;
import jbilous.support.Register;
import jbilous.support.assembly.x86_64Reg;

public class AssemblyRegister implements Register {
	x86_64Reg register;

	public AssemblyRegister(x86_64Reg register) {
		this.register = register;
	}
	public String toString() {
		return register.toString();
	}
}