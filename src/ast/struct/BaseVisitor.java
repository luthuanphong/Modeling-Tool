package ast.struct;

public class BaseVisitor {

  public Object visit(Program ast, Object o) {
		return null;
	}

  public Object visit(Func ast, Object o) {
		return null;
	}

  public Object visit(Block ast, Object o) {
		return null;
	}

  public Object visit(AssignStmt ast, Object o) {
		return null;
	}

  public Object visit(IfStmt ast, Object o) {
		return null;
	}

  public Object visit(SearchStmt ast, Object o) {
		return null;
	}

  public Object visit(Id ast, Object o) {
		return null;
	}

  public Object visit(IntLit ast, Object o) {
		return null;
	}

  public Object visit(BoolLit ast, Object o) {
		return null;
	}

  public Object visit(VarLocal ast, Object o) {
    return null;
  }

  public Object visit(StringLit ast, Object o) {
		return null;
	}

  public Object visit(FloatLit ast, Object o) {
    return null;
  }

  public Object visit(UnOp ast, Object o) {
		return null;
	}

  public Object visit(BinOp ast, Object o) {
		return null;
	}

  public Object visit(FuncCall ast, Object o) {
    return null;
  }

  public Object visit(Object ast, Object o) {
    return null;
  }


}
