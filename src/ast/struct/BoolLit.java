package ast.struct;

public class BoolLit extends Expr {
  public boolean value;

  public BoolLit(boolean value) {
    this.value = value;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return Boolean.toString(this.value);
  }
}
