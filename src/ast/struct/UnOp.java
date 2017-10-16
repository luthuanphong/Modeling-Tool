package ast.struct;

public class UnOp extends Expr {
  public String op;
  public Expr expr;

  public UnOp(String op, Expr expr) {
    this.op = op;
    this.expr = expr;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.op + this.expr.toString();
  }

}
