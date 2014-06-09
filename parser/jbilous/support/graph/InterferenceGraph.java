package jbilous.support.graph;

import jbilous.support.graph.IntGraphNode;
import jbilous.support.Register;
import java.util.ArrayList;
import java.util.Map;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Vector;
import java.util.Iterator;
import java.util.HashMap;

public class InterferenceGraph {

	private HashMap<Integer, IntGraphNode> regNodeMap;
	private HashMap<Integer, IntGraphNode> recMap;

	public InterferenceGraph() {
		regNodeMap = new HashMap<Integer, IntGraphNode>();
		recMap = new HashMap<Integer, IntGraphNode>();
	}

	public int getColor(Integer k) {
		IntGraphNode node = regNodeMap.get(k);
		// System.out.println("Getting color for " + node.getRegister());
		return node.getColor().intValue();
	}

	public void printColors() {
		Iterator it = regNodeMap.entrySet().iterator();
		for (Map.Entry<Integer, IntGraphNode> pairs : regNodeMap.entrySet()) {
		    System.out.println(pairs.getKey() + " : " + pairs.getValue().getColor());
		}
	}

	public void printGraph() {
		Iterator it = regNodeMap.entrySet().iterator();
		for (Map.Entry<Integer, IntGraphNode> pairs : regNodeMap.entrySet()) {
		    System.out.println(pairs.getKey() + " : " + pairs.getValue().toString());
		}
	}

	public IntGraphNode removeNode(IntGraphNode node) {
		BitSet removeBit = new BitSet();
		removeBit.set(node.getRegister());
		for(Integer k : regNodeMap.keySet()) {
			IntGraphNode curNode = regNodeMap.get(k);
			BitSet curEdges = curNode.getEdges();
			curEdges.xor(removeBit);
		}
		recMap.put(node.getRegister(), node);
		return regNodeMap.remove(node.getRegister());
	}

	private HashSet<Integer> initColors() {
		HashSet<Integer> newSet = new HashSet<Integer>();
		
		for(int i = 0; i < 17; i++) {
			if(i != 0 && i != 7 && i != 10 && i != 11 && i != 16 && i != 6) {
				newSet.add(new Integer(i));
			}
		}
		return newSet;
	}

	public void reconstructNode(Integer nodeNum) {
		IntGraphNode node = recMap.get(nodeNum);
		HashSet<Integer> unavailColors = new HashSet<Integer>();
		HashSet<Integer> allColors = initColors();
		
		if(nodeNum < 17) {
			regNodeMap.put(node.getRegister(), node);
			return;
		}

		for(int i = 0; i < node.getEdges().length(); i++) {
			if(recMap.get(i) != null && recMap.get(i).getColor() != null) {
				unavailColors.add(recMap.get(i).getColor());
			}
		}

		if(unavailColors.size() > 12) {
			node.setColor(new Integer(-1));
		} else {
			allColors.removeAll(unavailColors);
			Integer[] colorArray = allColors.toArray(new Integer[0]);
			node.setColor(colorArray[0]);
		}
		regNodeMap.put(node.getRegister(), node);
	}

	public Vector<IntGraphNode> getNodes() {
		// First color all assembly instruction nodes
		for(int regNum = 0; regNum < 17; regNum++) {
			if(regNodeMap.containsKey(new Integer(regNum))) {
				IntGraphNode node = regNodeMap.get(new Integer(regNum));
				node.setColor(new Integer(regNum));
			}
		}

		return new Vector<IntGraphNode>(regNodeMap.values());
	}

	public void addNode(Integer reg)
	{
		if(!regNodeMap.containsKey(reg))
		{
			regNodeMap.put(reg, new IntGraphNode(reg));
		}
	}

	public void addEdge(Integer reg1, Integer reg2) {
		IntGraphNode node1, node2;
		if(!regNodeMap.containsKey(reg1)) {
			node1 = new IntGraphNode(reg1);
			regNodeMap.put(reg1, node1);
		} else {
			node1 = regNodeMap.get(reg1);
		}

		if(!regNodeMap.containsKey(reg2)) {
			node2 = new IntGraphNode(reg2);
			regNodeMap.put(reg2, node2);
		} else {
			node2 = regNodeMap.get(reg2);
		}

		node1.addEdge(reg2);
		node2.addEdge(reg1);
	}
}