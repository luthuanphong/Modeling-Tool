package ast.struct;

public class Func {
  public String id;
  public Block block;

  public Func(String id, Block block) {
    this.id = id;
    this.block = block;
  }

  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

}
