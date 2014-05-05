package jbilous.support.assembly;
import jbilous.support.Register;

public class ImmediateRegister implements Register {
	Integer value;
	String stringVal;

	public ImmediateRegister(Integer value) {
		this.value = value;
	}

	public ImmediateRegister(String value) {
		this.stringVal = value;
	}
	public String toString() {
		if(value == null) {
			return "$" + stringVal;
		}
		return "$" + value;
	}
}