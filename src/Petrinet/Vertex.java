package Petrinet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import ast.struct.Var;

public class Vertex {

  private ArrayList<Place> marking;
  private HashMap<String, Var> varList;
  private ArrayList<Edge> children = new ArrayList<Edge>();
  private ArrayList<Edge> parents = new ArrayList<Edge>();

  public Vertex(ArrayList<Place> marking, HashMap<String, Var> varList) {
    this.marking = marking;
    this.varList = varList;
  }

  public void addChild(Edge e) {
    this.children.add(e);
  }

  public void addParent(Edge e) {
    this.parents.add(e);
  }

  public ArrayList<Edge> getChildren() {
    return this.children;
  }

  public ArrayList<Edge> getParents() {
    return this.parents;
  }

  public ArrayList<Place> getMarking() {
    return this.marking;
  }

  public HashMap<String, Var> getVarList() {
    return this.varList;
  }

  @Override
  public String toString() {
    ArrayList<String> al = new ArrayList<>();
    for (Var v: varList.values()) {
      al.add(v.toString());
    }
    Collections.sort(al);
		return marking.toString()+" "+al.toString();
  }

}
