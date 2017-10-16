package ast.parser;

public class TypeMismatchInDeclare extends RuntimeException {
  public String id;
  public String type;
  public String value;

  public TypeMismatchInDeclare(String id, String type, String value) {
    this.id = id;
    this.type = type;
    this.value = value;
  }

  @Override
  public String toString() {
    return "Type mismatch in declare: " + this.type + " " + this.id + " = " + this.value;
  }
}
