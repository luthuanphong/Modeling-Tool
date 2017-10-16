package ast.struct;

import java.util.*;

public class Program {
  public HashMap<String, Var> varList;
  public HashMap<String, Const> constList;
  public HashMap<String, Func> funcList;

  public Program(HashMap<String, Var> varList, HashMap<String, Const> constList, HashMap<String, Func> funcList) {
    this.varList = varList;
    this.constList = constList;
    this.funcList = funcList;
  }

  public Object accept(BaseVisitor v, Object o) {
    return v.visit(this, o);
  }

  public HashMap<String, Var> cloneVarList() {
    HashMap<String, Var> h = new HashMap<>();
    for (Var v: varList.values()) {
      h.put(v.id, new Var(v.id, v.type, v.value));
    }
    return h;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Iterator<String> varId = this.varList.keySet().iterator();
    while (varId.hasNext()) {
      sb.append(this.varList.get(varId.next()).toString() + "\n");
    }
    return sb.toString();
  }

}
