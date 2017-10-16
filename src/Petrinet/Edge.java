package Petrinet;

public class Edge {

  public String id;
  public Vertex end;

  public Edge(String id, Vertex end) {
    this.id = id;
    this.end = end;
  }

  @Override
  public String toString() {
    return this.id + ":" + this.end.toString();
  }

}
