package ast.parser;

public class Redeclared extends RuntimeException {
  public String s;

  public Redeclared(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "Redeclared: " + this.s;
  }
}
