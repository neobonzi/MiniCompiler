package jbilous.support.assembly;
import jbilous.support.Register;

public class VirtualRegister implements Register {
	Integer regNum;

	public VirtualRegister(Integer regNum) {
		this.regNum = regNum;
	}
	public String toString() {
		return "r" + regNum;
	}
	public Integer getRegNum() {
		return regNum;
	}

	public int hashCode() {
		return regNum;
	}

	public boolean equals(Object object) {
		if(object instanceof VirtualRegister) {
			VirtualRegister virtualReg = (VirtualRegister)object;
			return virtualReg.getRegNum().equals(regNum);
		} 
		return false;
	}

	public Integer getValueNum() {
		return regNum;
	}
}