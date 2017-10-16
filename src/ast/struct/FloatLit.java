package ast.struct;

public class FloatLit extends Expr {
  public float value;

  public FloatLit(float value) {
    this.value = value;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return Float.toString(this.value);
  }
}
