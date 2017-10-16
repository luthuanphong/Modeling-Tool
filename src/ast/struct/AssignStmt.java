package ast.struct;

public class AssignStmt extends Stmt {
  public String lhs;
  public Expr expr;

  public AssignStmt(String lhs, Expr expr) {
    this.lhs = lhs;
    this.expr = expr;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return this.lhs + " = " + this.expr.toString();
  }
}
