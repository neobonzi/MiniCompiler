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
}