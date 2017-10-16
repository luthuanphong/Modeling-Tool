package ast.parser;

public class UncloseString extends RuntimeException {
  public String s;

  public UncloseString(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "UncloseString: " + this.s;
  }
}
