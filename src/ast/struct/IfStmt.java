package ast.struct;

public class IfStmt extends Stmt {
  public Expr condition;
  public Stmt thenStmt;
  public Stmt elseStmt;

  public IfStmt(Expr condition, Stmt thenStmt, Stmt elseStmt) {
    this.condition = condition;
    this.thenStmt = thenStmt;
    this.elseStmt = elseStmt;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return "if " + this.condition.toString() + "...";
  }
}
