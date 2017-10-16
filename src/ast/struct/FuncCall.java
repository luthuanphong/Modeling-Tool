package ast.struct;

import java.util.List;

public class FuncCall extends Expr {
  public String id;
  public List<Expr> param;

  public FuncCall(String id, List<Expr> param) {
    this.id = id;
    this.param = param;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  @Override
  public String toString() {
    return id + param.toString();
  }

}
