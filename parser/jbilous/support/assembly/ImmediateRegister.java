package jbilous.support.assembly;
import jbilous.support.Register;

public class ImmediateRegister implements Register {
	Integer value;

	public ImmediateRegister(Integer value) {
		this.value = value;
	}
	public String toString() {
		return "$" + value;
	}
}