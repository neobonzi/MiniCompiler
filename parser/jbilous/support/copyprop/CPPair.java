package jbilous.support.copyprop;

import java.util.Vector;
import jbilous.support.Register;
import jbilous.support.assembly.*;

public class CPPair {
	Integer source;
	Integer target;

	public CPPair(Integer source, Integer target) {
		this.source = source;
		this.target = target;
	}

	public Integer getSource() {
		return this.source;
	}

	public Integer getTarget() {
		return this.target;
	}

	public String toString() {
		return "{" + source.toString() + ", " + target.toString() + "}";
	}

	public boolean equals(Object o) {
		if(o instanceof CPPair) {
			CPPair oPair = (CPPair)o;
			return oPair.getSource().equals(this.source) && oPair.getTarget().equals(this.target);
		}
		return false;
	}
}