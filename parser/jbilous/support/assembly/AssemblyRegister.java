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

	public x86_64Reg getRegister() {
		return register;
	}

	public boolean equals(Object object) {
		if(object instanceof AssemblyRegister) {
			AssemblyRegister assReg = (AssemblyRegister)object;
			return assReg.getRegister() == this.register;
		}
		return false;
	}
}