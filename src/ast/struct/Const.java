package ast.struct;

public class Const {
  public String id;
  public String type;
  public String value;

  public Const(String id, String type, String value) {
    this.id = id;
    this.type = type;
    this.value = value;
  }

  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.id + "=" + this.value;
  }
}
