package ast.struct;

public class Id extends Expr {
  public String id;

  public Id(String id) {
    this.id = id;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.id;
  }
}
