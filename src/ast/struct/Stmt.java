package ast.struct;

public class Stmt {
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }
}
