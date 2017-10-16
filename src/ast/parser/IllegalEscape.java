package ast.parser;

public class IllegalEscape extends RuntimeException {
  public String s;

  public IllegalEscape(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "Illegal escape: " + this.s;
  }
}
