package ast.struct;

public class SearchStmt extends Stmt {
  public Expr condition;

  public SearchStmt(Expr condition) {
    this.condition = condition;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return "search " + this.condition.toString();
  }
}
