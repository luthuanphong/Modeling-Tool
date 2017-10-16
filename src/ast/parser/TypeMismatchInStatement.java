package ast.parser;

public class TypeMismatchInStatement extends RuntimeException {
  public String s;

  public TypeMismatchInStatement(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return "Type mismatch in statement: " + this.s;
  }
}
