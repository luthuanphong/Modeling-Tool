package ast.struct;

public class BinOp extends Expr {
  public String op;
  public Expr left;
  public Expr right;

  public BinOp(String op, Expr left, Expr right) {
    this.op = op;
    this.left = left;
    this.right = right;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.left.toString() + this.op + this.right.toString();
  }
}
