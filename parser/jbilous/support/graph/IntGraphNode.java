package jbilous.support.graph;

import jbilous.support.Register;
import java.util.BitSet;
import java.lang.Comparable;
import java.util.ArrayList;

public class IntGraphNode implements Comparable{
	private Integer register;
	private Integer color;
	private BitSet edges; 

	public IntGraphNode(Integer register) {
		this.register = register;
		edges = new BitSet();
	}

	public BitSet getEdges() {
		return edges;
	}

	public Integer getRegister() {
		return register;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getColor() {
		return color;
	}

	public void addEdge(Integer newEdge) {
		edges.set(newEdge);
	}

	public int compareTo(Object obj) {
		int returnVal = 0;
		if(obj instanceof IntGraphNode) {
			IntGraphNode other = (IntGraphNode)obj;
			Integer thisCard = new Integer(edges.cardinality());
			Integer otherCard = new Integer(other.getEdges().cardinality());
			returnVal = otherCard.compareTo(thisCard);
		}
		return returnVal;
	}

	public String toString() {
		return register + " : " + edges.toString();
	}
}