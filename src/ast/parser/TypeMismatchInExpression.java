package ast.parser;

public class TypeMismatchInExpression extends RuntimeException {
  public String s;

  public TypeMismatchInExpression(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "Type mismatch in expression: " + this.s;
  }
}
