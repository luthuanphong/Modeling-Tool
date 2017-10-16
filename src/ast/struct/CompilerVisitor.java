package ast.struct;

import java.util.Enumeration;
import java.util.HashMap;
import ast.parser.*;
import java.util.Random;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.util.List;
import java.util.LinkedList;

public class CompilerVisitor extends BaseVisitor {

  private HashMap<String, Const> constList;

  public CompilerVisitor(HashMap<String, Const> constList) {
    this.constList = constList;
  }

  @Override
  public Object visit(Func ast, Object o) {
    ast.block.accept(this, o);
    return null;
  }

  @Override
  public Object visit(Block ast, Object o) {
    List<String> locals = new LinkedList<String>();
    for (VarLocal vl: ast.locals) {
      locals.add(vl.id);
      vl.accept(this, o);
    }
    for (Stmt s: ast.stmts) {
      s.accept(this, o);
    }
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    for (String s: locals) {
      varList.remove(s);
    }
    return null;
  }

  @Override
  public Object visit(VarLocal ast, Object o) {
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    Object expr = ast.value.accept(this, o);
    String e = null;
    Var v = new Var(ast.id, ast.type, e);
    if (ast.type.equals("int")) {
      e = Integer.toString(((IntLit)expr).value);
    } else if (ast.type.equals("boolean")) {
      e = Boolean.toString(((BoolLit)expr).value);
    } else if (ast.type.equals("float")) {
      e = Float.toString(((FloatLit)expr).value);
    } else {
      e = (String)expr;
    }
    v.value = e;
    varList.put(v.id, v);
    return null;
  }

  @Override
  public Object visit(AssignStmt ast, Object o) {
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    //if (!varList.containsKey(ast.lhs)) throw new Undeclared(ast.lhs);
    //String lhs = varList.get(ast.lhs).id;
    Object expr = ast.expr.accept(this, o);
    String e;
    if (expr instanceof IntLit) {
      e = Integer.toString(((IntLit)expr).value);
    } else if (expr instanceof BoolLit) {
      e = Boolean.toString(((BoolLit)expr).value);
    } else if (expr instanceof FloatLit) {
      e = Float.toString(((FloatLit)expr).value);
    } else {
      e = (String)expr;
    }
    //if (!lhs.equals(expr)) throw new TypeMismatchInStatement(ast.toString());
    varList.get(ast.lhs).value = e;
    return null;
  }

  @Override
  public Object visit(IfStmt ast, Object o) {
    boolean condition = ((BoolLit)ast.condition.accept(this, o)).value;
    //if (!condition.equals("boolean")) throw new TypeMismatchInStatement(ast.toString());
    if (condition) {
        ast.thenStmt.accept(this, o);
    } else {
        if (ast.elseStmt != null) ast.elseStmt.accept(this, o);
    }
    return null;
  }

  @Override
  public Object visit(SearchStmt ast, Object o) {
    boolean condition = ((BoolLit)ast.condition.accept(this, o)).value;
    //if (!condition.equals("boolean")) throw new TypeMismatchInStatement(ast.toString());
    return new Boolean(condition);
  }

  @Override
  public Object visit(Id ast, Object o) {
    HashMap<String, Var> varList = (HashMap<String, Var>)o;
    String type = "";
    String value = "";
    if (!varList.containsKey(ast.id)) {
      if (!constList.containsKey(ast.id)) {
        throw new Undeclared(ast.id);
      } else {
        Const c = constList.get(ast.id);
        type = c.type;
        value = c.value;
      }
    } else {
      Var v = varList.get(ast.id);
      type = v.type;
      value = v.value;
    }
    if (type.equals("int")) {
      return new IntLit(Integer.parseInt(value));
    } else if (type.equals("boolean")) {
      return new BoolLit(Boolean.parseBoolean(value));
    } else if (type.equals("float")) {
      return new FloatLit(Float.parseFloat(value));
    } else {
      return value;
    }
  }

  @Override
  public Object visit(IntLit ast, Object o) {
    return ast;
  }

  @Override
  public Object visit(BoolLit ast, Object o) {
    return ast;
  }

  @Override
  public Object visit(StringLit ast, Object o) {
    return ast.value;
  }

  @Override
  public Object visit(FloatLit ast, Object o) {
    return ast;
  }

  @Override
  public Object visit(FuncCall ast, Object o) {
    switch (ast.id) {
      case "randomInt":
        int minI = ((IntLit)ast.param.get(0).accept(this, o)).value;
        int maxI = ((IntLit)ast.param.get(1).accept(this, o)).value;
        return new IntLit(new Random().nextInt((maxI-minI)+1)+minI);
      case "randomFloat":
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        float minF = ((FloatLit)ast.param.get(0).accept(this, o)).value;
        float maxF = ((FloatLit)ast.param.get(1).accept(this, o)).value;
        return new FloatLit(Float.parseFloat(df.format(new Random().nextFloat()*(maxF-minF)+minF)));
    }
    return null;
  }

  @Override
  public Object visit(UnOp ast, Object o) {
    Object expr = ast.expr.accept(this, o);
    switch (ast.op) {
      case "!":
        //if (!expr.equals("boolean")) throw new TypeMismatchInExpression(ast.toString());
        return new BoolLit(!((BoolLit)expr).value);
      case "+":
        return expr;
      default:
        //if (!expr.equals("int")) throw new TypeMismatchInExpression(ast.toString());
        if (expr instanceof IntLit) {
          return new IntLit(-((IntLit)expr).value);
        }
        return new FloatLit(-((FloatLit)expr).value);
    }
  }

  @Override
  public Object visit(BinOp ast, Object o) {
    Object left = ast.left.accept(this, o);
    Object right = ast.right.accept(this, o);
    if (left instanceof IntLit) {
      if (right instanceof IntLit) {
        switch (ast.op) {
          case "+":
            return new IntLit(((IntLit)left).value + ((IntLit)right).value);
          case "-":
            return new IntLit(((IntLit)left).value - ((IntLit)right).value);
          case "*":
            return new IntLit(((IntLit)left).value * ((IntLit)right).value);
          case "/":
            return new FloatLit((float)((IntLit)left).value / ((IntLit)right).value);
          case "%":
            return new IntLit(((IntLit)left).value % ((IntLit)right).value);
          case ">":
            return new BoolLit(((IntLit)left).value > ((IntLit)right).value);
          case ">=":
            return new BoolLit(((IntLit)left).value >= ((IntLit)right).value);
          case "<":
            return new BoolLit(((IntLit)left).value < ((IntLit)right).value);
          case "<=":
            return new BoolLit(((IntLit)left).value <= ((IntLit)right).value);
          case "==":
            return new BoolLit(((IntLit)left).value == ((IntLit)right).value);
          case "!=":
            return new BoolLit(((IntLit)left).value != ((IntLit)right).value);
        }
      } else {
        switch (ast.op) {
          case "+":
            return new FloatLit(((IntLit)left).value + ((FloatLit)right).value);
          case "-":
            return new FloatLit(((IntLit)left).value - ((FloatLit)right).value);
          case "*":
            return new FloatLit(((IntLit)left).value * ((FloatLit)right).value);
          case "/":
            return new FloatLit(((IntLit)left).value / ((FloatLit)right).value);
          case ">":
            return new BoolLit(((IntLit)left).value > ((FloatLit)right).value);
          case ">=":
            return new BoolLit(((IntLit)left).value >= ((FloatLit)right).value);
          case "<":
            return new BoolLit(((IntLit)left).value < ((FloatLit)right).value);
          case "<=":
            return new BoolLit(((IntLit)left).value <= ((FloatLit)right).value);
          case "==":
            return new BoolLit(((IntLit)left).value == ((FloatLit)right).value);
          case "!=":
            return new BoolLit(((IntLit)left).value != ((FloatLit)right).value);
        }
      }
    } else if (left instanceof FloatLit) {
      if (right instanceof IntLit) {
        switch (ast.op) {
          case "+":
            return new FloatLit(((FloatLit)left).value + ((IntLit)right).value);
          case "-":
            return new FloatLit(((FloatLit)left).value - ((IntLit)right).value);
          case "*":
            return new FloatLit(((FloatLit)left).value * ((IntLit)right).value);
          case "/":
            return new FloatLit(((FloatLit)left).value / ((IntLit)right).value);
          case ">":
            return new BoolLit(((FloatLit)left).value > ((IntLit)right).value);
          case ">=":
            return new BoolLit(((FloatLit)left).value >= ((IntLit)right).value);
          case "<":
            return new BoolLit(((FloatLit)left).value < ((IntLit)right).value);
          case "<=":
            return new BoolLit(((FloatLit)left).value <= ((IntLit)right).value);
          case "==":
            return new BoolLit(((FloatLit)left).value == ((IntLit)right).value);
          case "!=":
            return new BoolLit(((FloatLit)left).value != ((IntLit)right).value);
        }
      } else {
        switch (ast.op) {
          case "+":
            return new FloatLit(((FloatLit)left).value + ((FloatLit)right).value);
          case "-":
            return new FloatLit(((FloatLit)left).value - ((FloatLit)right).value);
          case "*":
            return new FloatLit(((FloatLit)left).value * ((FloatLit)right).value);
          case "/":
            return new FloatLit(((FloatLit)left).value / ((FloatLit)right).value);
          case ">":
            return new BoolLit(((FloatLit)left).value > ((FloatLit)right).value);
          case ">=":
            return new BoolLit(((FloatLit)left).value >= ((FloatLit)right).value);
          case "<":
            return new BoolLit(((FloatLit)left).value < ((FloatLit)right).value);
          case "<=":
            return new BoolLit(((FloatLit)left).value <= ((FloatLit)right).value);
          case "==":
            return new BoolLit(((FloatLit)left).value == ((FloatLit)right).value);
          case "!=":
            return new BoolLit(((FloatLit)left).value != ((FloatLit)right).value);
        }
      }
    }
    //if (!left.equals(right)) throw new TypeMismatchInExpression(ast.toString());
    switch (ast.op) {
      case "^":
        //if (!left.equals("string")) throw new TypeMismatchInExpression(ast.toString());
        return (String)left + (String)right;
      case "&&":
        return new BoolLit(((BoolLit)left).value && ((BoolLit)right).value);
      case "||":
        return new BoolLit(((BoolLit)left).value || ((BoolLit)right).value);
      case "==":
        if (left instanceof BoolLit) {
          return new BoolLit(((BoolLit)left).value == ((BoolLit)right).value);
        } else {
          return new BoolLit(((String)left).equals((String)right));
        }
      default:
        if (left instanceof BoolLit) {
          return new BoolLit(((BoolLit)left).value != ((BoolLit)right).value);
        } else {
          return new BoolLit(!((String)left).equals((String)right));
        }
    }
  }

}
