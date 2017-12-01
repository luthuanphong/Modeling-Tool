package Petrinet;

import java.util.ArrayList;
import java.util.HashMap;
import ast.struct.*;

public class Petrinet {

	private String name;
	private ArrayList<Place> places = new ArrayList<Place>();
	private ArrayList<Transition> transitions = new ArrayList<Transition>();
	private ArrayList<Arc> arcs = new ArrayList<Arc>();
	private final int MAX_SIZE = 300000;
	private final String CONGESTION = "CONGESTION";
	private final String TRUE = "true";

	public Petrinet(String name) {
		this.name = name;
	}

	public void add(Place p) {
		this.places.add(p);
	}

	public void add(Transition t) {
		this.transitions.add(t);
	}

	public void add(Arc a) {
		this.arcs.add(a);
	}

  private ArrayList<Transition> getEnabledTransitons() {
		ArrayList<Transition> result = new ArrayList<Transition>();
		for (Transition t: this.transitions) {
			if (t.isEnabled()) {
				result.add(t);
			}
		}
		return result;
	}

	private ArrayList<Place> getCurrentMarking() {
		ArrayList<Place> result = new ArrayList<Place>();
		for (Place p: this.places) {
			result.add(new Place(p.getId(), p.getLabel(), p.getToken()));
		}
		return result;
	}

	/**
	 * This method apply a marking to the petrinet
	 * Return true if success, otherwise return false
	 */
	private boolean applyMarking(ArrayList<Place> marking) {
		for (int i = 0; i < marking.size(); i++) {
			if (marking.get(i).getId() != this.places.get(i).getId()) {
				return false;
			}
			this.places.get(i).setToken(marking.get(i).getToken());
		}
		return true;
	}

	private ArrayList<Place> getNextState(Transition t) {
		// Only call this method when transition t is surely enabled
		t.fire();
		ArrayList<Place> result = this.getCurrentMarking();
		return result;
	}

	private ArrayList<Place> WSNGetNextState(Transition t, HashMap<String, Var> varList) {
		// Only call this method when transition t is surely enabled
		t.fire();
		WSNAdjust(t, varList);
		ArrayList<Place> result = this.getCurrentMarking();
		return result;
	}

	private void WSNAdjust(Transition t, HashMap<String, Var> varList) {
		for (Arc a: t.getOutgoing()) {
			a.getPlace().setToken(1);
		}
		for (Arc a: t.getIncoming()) {
			Place p = a.getPlace();
			String varName = getBindingVar(p.getId());
			if (!varList.get(varName).value.equals("0")) {
				//System.out.println(varName + "   " + varList.get(varName).value);
				p.setToken(1);
			}
		}
	}

	private String getBindingVar(String id) {
		String[] array = id.split("_");
		String type = array[0];
		String sub = array[1];
		String num = array[2];
		switch (type) {
			case "src":
				if (sub.equals("in")) {
					return "NUMBER_OF_PACKAGE";
				} else if (sub.equals("int")) {
					return "Buffer_"+num;
				} else {
					return "Queue_"+num;
				}
			case "int": case "sink":
				if (sub.equals("in")) {
					return "Buffer_"+num;
				} else {
					return "Queue_"+num;
				}
			default:
				return "Channel_Buffer_"+num+"_"+array[3];
		}
	}

	/**
	 * A recursive method which helps generate the reachability graph
	 */
	private void recursiveGen(Vertex start, Graph graph, HashMap<String, Func> funcList, CompilerVisitor cv) {
		if (graph.getSize() > MAX_SIZE) return;
		this.applyMarking(start.getMarking());
		ArrayList<Transition> enabledTransitions = this.getEnabledTransitons();
		for (Transition t: enabledTransitions) {
			this.applyMarking(start.getMarking());
			ArrayList<Place> newMarking = this.getNextState(t);
			HashMap<String, Var> newVarList = getClone(start.getVarList());
			funcList.get(t.getId()).accept(cv, newVarList);
			Vertex temp = new Vertex(newMarking, newVarList);
			Vertex v = graph.find(temp.toString()); // Check if the marking and varList are already in the graph
			if (v == null) {
				v = temp;
				graph.add(v);
				Edge e = new Edge(t.getId(), v);
				start.addChild(e);
				v.addParent(new Edge(t.getId(), start));
				recursiveGen(v, graph, funcList, cv);
			}
			else {
				Edge e = new Edge(t.getId(), v);
				start.addChild(e);
				v.addParent(new Edge(t.getId(), start));
			}
		}
	}

	public Graph generate(Program prog) {
		Graph graph = new Graph();
		ArrayList<Place> currentMarking = this.getCurrentMarking();
		HashMap<String, Var> currentVarList = prog.cloneVarList();
		Vertex start = new Vertex(currentMarking, currentVarList);
		graph.add(start);
		graph.setInit(start);
		recursiveGen(start, graph, prog.funcList, new CompilerVisitor(prog.constList));
		this.applyMarking(currentMarking); // return the petrinet to its current state
		return graph;
	}

	private void WSNRecursiveGen(Vertex start, Graph graph, HashMap<String, Func> funcList, CompilerVisitor cv) {
		if (graph.getSize() > MAX_SIZE) return;
		if (isCongest(start)) return;
		this.applyMarking(start.getMarking());
		ArrayList<Transition> enabledTransitions = this.getEnabledTransitons();
		for (Transition t: enabledTransitions) {
			this.applyMarking(start.getMarking());
			HashMap<String, Var> newVarList = getClone(start.getVarList());
			funcList.get(t.getId()).accept(cv, newVarList);
			ArrayList<Place> newMarking = this.WSNGetNextState(t, newVarList);
			Vertex temp = new Vertex(newMarking, newVarList);
			Vertex v = graph.find(temp.toString()); // Check if the marking and varList are already in the graph
			if (v == null) {
				v = temp;
				graph.add(v);
				Edge e = new Edge(t.getId(), v);
				start.addChild(e);
				v.addParent(new Edge(t.getId(), start));
				WSNRecursiveGen(v, graph, funcList, cv);
			}
			else {
				Edge e = new Edge(t.getId(), v);
				start.addChild(e);
				v.addParent(new Edge(t.getId(), start));
			}
		}
	}

	public Graph WSNGenerate(Program prog) {
		Graph graph = new Graph();
		ArrayList<Place> currentMarking = this.getCurrentMarking();
		HashMap<String, Var> currentVarList = prog.cloneVarList();
		Vertex start = new Vertex(currentMarking, currentVarList);
		graph.add(start);
		graph.setInit(start);
		WSNRecursiveGen(start, graph, prog.funcList, new CompilerVisitor(prog.constList));
		this.applyMarking(currentMarking); // return the petrinet to its current state
		return graph;
	}

	private HashMap<String, Var> getClone(HashMap<String, Var> varList) {
		HashMap<String, Var> h = new HashMap<>();
		for (Var v: varList.values()) {
			h.put(v.id, new Var(v.id, v.type, v.value));
		}
		return h;
	}

	private boolean isCongest(Vertex v) {
		return v.getVarList().get(CONGESTION).value == TRUE;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Petrinet ");
		sb.append(name).append("\n");
		sb.append("---Places---").append("\n");
		for (Place p : places) {
			sb.append(p).append("\n");
		}
		sb.append("\n---Transitions---").append("\n");
		for (Transition t : transitions) {
			sb.append(t).append("\n");
		}
		return sb.toString();
	}
}
