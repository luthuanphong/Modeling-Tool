package ast.parser;

public class Undeclared extends RuntimeException {
  public String s;

  public Undeclared(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "Undeclared: " + this.s;
  }
}
