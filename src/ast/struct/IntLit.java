package ast.struct;

public class IntLit extends Expr {
  public int value;

  public IntLit(int value) {
    this.value = value;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return Integer.toString(this.value);
  }

}
