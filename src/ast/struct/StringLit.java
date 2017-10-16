package ast.struct;

public class StringLit extends Expr {
  public String value;

  public StringLit(String value) {
    this.value = value;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.value;
  }
}
