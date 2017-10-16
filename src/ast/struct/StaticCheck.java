package ast.struct;

import java.util.Iterator;

import ast.parser.TypeMismatchInExpression;
import ast.parser.TypeMismatchInStatement;
import ast.parser.Undeclared;

import java.util.HashMap;
import ast.parser.*;

public class StaticCheck extends BaseVisitor {
  @Override
  public Object visit(Program ast, Object o) {
    Iterator<String> funcId = ast.funcList.keySet().iterator();
    while (funcId.hasNext()) {
      String id = funcId.next();
      ast.funcList.get(id).accept(this, o);
    }
    return null;
  }

  @Override
  public Object visit(Func ast, Object o) {
    ast.block.accept(this, o);
    return null;
  }

  @Override
  public Object visit(Block ast, Object o) {
    for (Stmt s: ast.stmts) {
      s.accept(this, o);
    }
    return null;
  }

  @Override
  public Object visit(AssignStmt ast, Object o) {
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    if (!varList.containsKey(ast.lhs)) throw new Undeclared(ast.lhs);
    String lhs = varList.get(ast.lhs).type;
    String expr = (String)ast.expr.accept(this, o);
    if (lhs.equals("float") && expr.equals("int")) {
    } else if (!lhs.equals(expr)) throw new TypeMismatchInStatement(ast.toString());
    return null;
  }

  @Override
  public Object visit(IfStmt ast, Object o) {
    String condition = (String)ast.condition.accept(this, o);
    if (!condition.equals("boolean")) throw new TypeMismatchInStatement(ast.toString());
    ast.thenStmt.accept(this, o);
    if (ast.elseStmt != null) ast.thenStmt.accept(this, o);
    return null;
  }

  @Override
  public Object visit(SearchStmt ast, Object o) {
    String condition = (String)ast.condition.accept(this, o);
    if (!condition.equals("boolean")) throw new TypeMismatchInStatement(ast.toString());
    return null;
  }

  @Override
  public Object visit(Id ast, Object o) {
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    if (!varList.containsKey(ast.id)) throw new Undeclared(ast.id);
    return varList.get(ast.id).type;
  }

  @Override
  public Object visit(IntLit ast, Object o) {
    return "int";
  }

  @Override
  public Object visit(BoolLit ast, Object o) {
    return "boolean";
  }

  @Override
  public Object visit(StringLit ast, Object o) {
    return "string";
  }

  @Override
  public Object visit(FloatLit ast, Object o) {
    return "float";
  }

  @Override
  public Object visit(UnOp ast, Object o) {
    String expr = (String)ast.expr.accept(this, o);
    switch (ast.op) {
      case "!":
        if (!expr.equals("boolean")) throw new TypeMismatchInExpression(ast.toString());
        break;
      case "+": case "-":
        if (!expr.equals("int") || !expr.equals("float")) throw new TypeMismatchInExpression(ast.toString());
    }
    return expr;
  }

  @Override
  public Object visit(BinOp ast, Object o) {
    String left = (String)ast.left.accept(this, o);
    String right = (String)ast.right.accept(this, o);
    if (!canPair(left, right)) throw new TypeMismatchInExpression(ast.toString());
    switch (ast.op) {
      case "^":
        if (!left.equals("string")) throw new TypeMismatchInExpression(ast.toString());
        return "string";
      case "%":
        if (!left.equals("int") || !right.equals("int")) throw new TypeMismatchInExpression(ast.toString());
        return "int";
      case "+": case "-": case "*": case "/":
        if (!left.equals("int") && !left.equals("float")) throw new TypeMismatchInExpression(ast.toString());
        if (left.equals("float") || right.equals("float"))
          return "float";
        return "int";
      case "&&": case "||":
        if (!left.equals("boolean")) throw new TypeMismatchInExpression(ast.toString());
        return "boolean";
      case ">": case ">=": case "<": case "<=":
        if (!left.equals("int") && !left.equals("float")) throw new TypeMismatchInExpression(ast.toString());
        return "boolean";
      default:
        return "boolean";
    }
  }

  private boolean canPair(String left, String right) {
    if (left.equals("int") || left.equals("float")) {
      if (right.equals("int") || right.equals("float")) {
        return true;
      }
    }
    if (left.equals(right)) {
      return true;
    }
    return false;
  }

}
