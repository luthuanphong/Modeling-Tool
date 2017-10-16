package ast.struct;

public class VarLocal {
  public String id;
  public String type;
  public Expr value;

  public VarLocal(String id, String type, Expr value) {
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
