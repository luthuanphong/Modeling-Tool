package ast.struct;

import java.util.*;

public class Block extends Stmt {
  public List<VarLocal> locals;
  public List<Stmt> stmts;

  public Block(List<VarLocal> locals, List<Stmt> stmts) {
    this.locals = locals;
    this.stmts = stmts;
  }

  @Override
  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }
}
