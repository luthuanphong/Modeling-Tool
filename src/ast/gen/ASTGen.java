package ast.gen;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.tree.*;
import ast.parser.*;
import ast.ptnet.PTNETBaseVisitor;
import ast.ptnet.PTNETParser;

import java.util.*;
import ast.struct.*;


public class ASTGen extends PTNETBaseVisitor<Object> {
  @Override public Object visitProgram(PTNETParser.ProgramContext ctx) {
    HashMap<String, Var> varList = new HashMap<String, Var>();
    HashMap<String, Const> constList = new HashMap<String, Const>();
    HashMap<String, Func> funcList = new HashMap<String, Func>();
    for (PTNETParser.VarDecContext i: ctx.varDec()) {
      Var ivar = (Var)i.accept(this);
      if (varList.containsKey(ivar.id)) {
        throw new Redeclared(ivar.toString());
      }
      varList.put(ivar.id, ivar);
    }
    for (PTNETParser.ConstDecContext i: ctx.constDec()) {
      Const iconst = (Const)i.accept(this);
      if (constList.containsKey(iconst.id)) {
        throw new Redeclared(iconst.toString());
      }
      constList.put(iconst.id, iconst);
    }
    for (PTNETParser.FuncDecContext i: ctx.funcDec()) {
      Func ifunc = (Func)i.accept(this);
      funcList.put(ifunc.id, ifunc);
    }
    return new Program(varList, constList, funcList);
  }

  @Override public Object visitVarDec(PTNETParser.VarDecContext ctx) {
    String id = ctx.ID().getText();
    String type = (String)ctx.type().accept(this);
    Object value = ctx.constant().accept(this);
    String v = "";
    if (value instanceof IntLit) {
      v = Integer.toString(((IntLit)value).value);
      if (!type.equals("int")) throw new TypeMismatchInDeclare(id, type, v);
    } else if (value instanceof BoolLit) {
      v = Boolean.toString(((BoolLit)value).value);
      if (!type.equals("boolean")) throw new TypeMismatchInDeclare(id, type, v);
    } else if (value instanceof FloatLit) {
      v = Float.toString(((FloatLit)value).value);
      if (!type.equals("float")) throw new TypeMismatchInDeclare(id, type, v);
    }
    else {
      v = ((StringLit)value).value;
      if (!type.equals("string")) throw new TypeMismatchInDeclare(id, type, v);
    }
    return new Var(id, type, v);
  }

  @Override public Object visitConstDec(PTNETParser.ConstDecContext ctx) {
    String id = ctx.ID().getText();
    String type = (String)ctx.type().accept(this);
    Object value = ctx.constant().accept(this);
    String v = "";
    if (value instanceof IntLit) {
      v = Integer.toString(((IntLit)value).value);
      if (!type.equals("int")) throw new TypeMismatchInDeclare(id, type, v);
    } else if (value instanceof BoolLit) {
      v = Boolean.toString(((BoolLit)value).value);
      if (!type.equals("boolean")) throw new TypeMismatchInDeclare(id, type, v);
    } else if (value instanceof FloatLit) {
      v = Float.toString(((FloatLit)value).value);
      if (!type.equals("float")) throw new TypeMismatchInDeclare(id, type, v);
    } else {
      v = ((StringLit)value).value;
      if (!type.equals("string")) throw new TypeMismatchInDeclare(id, type, v);
    }
    return new Const(id, type, v);
  }



  @Override public Object visitType(PTNETParser.TypeContext ctx) {
    if (ctx.INT() != null) return ctx.INT().getText();
    else if (ctx.BOOLEAN() != null) return ctx.BOOLEAN().getText();
    else if (ctx.FLOAT() != null) return ctx.FLOAT().getText();
    return ctx.STRING().getText();
  }

  @Override public Object visitConstant(PTNETParser.ConstantContext ctx) {
    if (ctx.INTLIT() != null) {
      return new IntLit(Integer.parseInt(ctx.INTLIT().getText()));
    }
    else if (ctx.BOOLLIT() != null) {
      return new BoolLit(Boolean.parseBoolean(ctx.BOOLLIT().getText()));
    }
    else if (ctx.FLOATLIT() != null) {
      return new FloatLit(Float.parseFloat(ctx.FLOATLIT().getText()));
    }
    return new StringLit(ctx.STRINGLIT().getText());
  }

  @Override public Object visitFuncDec(PTNETParser.FuncDecContext ctx) {
    String id = ctx.ID().getText();
    Block block = (Block)ctx.block().accept(this);
    return new Func(id, block);
  }

  @Override public Object visitVarLocal(PTNETParser.VarLocalContext ctx) {
    String id = ctx.ID().getText();
    String type = (String)ctx.type().accept(this);
    Expr value = (Expr)ctx.expr().accept(this);
    return new VarLocal(id, type, value);
  }

  @Override public Object visitStmt(PTNETParser.StmtContext ctx) {
    return visitChildren(ctx);
  }

  @Override public Object visitBlock(PTNETParser.BlockContext ctx) {
    List<VarLocal> locals = new LinkedList<VarLocal>();
    for (PTNETParser.VarLocalContext i: ctx.varLocal()) {
      locals.add((VarLocal)i.accept(this));
    }
    List<Stmt> stmts = new LinkedList<Stmt>();
    for (PTNETParser.StmtContext i: ctx.stmt()) {
      stmts.add((Stmt)i.accept(this));
    }
    return new Block(locals, stmts);
  }

  @Override public Object visitAsnStmt(PTNETParser.AsnStmtContext ctx) {
    String id = ctx.ID().getText();
    Expr expr = (Expr)ctx.expr().accept(this);
    return new AssignStmt(id, expr);
  }

  @Override public Object visitIfStmt(PTNETParser.IfStmtContext ctx) {
    Expr condition = (Expr)ctx.expr().accept(this);
    Stmt thenStmt = (Stmt)ctx.stmt(0).accept(this);
    Stmt elseStmt = null;
    if (ctx.stmt().size() == 2) elseStmt = (Stmt)ctx.stmt(1).accept(this);
    return new IfStmt(condition, thenStmt, elseStmt);
  }

  @Override public Object visitSrcStmt(PTNETParser.SrcStmtContext ctx) {
    Expr condition = (Expr)ctx.expr().accept(this);
    return new SearchStmt(condition);
  }

  @Override public Object visitExpr(PTNETParser.ExprContext ctx) {
    return (Expr)exprVisitBin(ctx);
  }

  @Override public Object visitBuf1(PTNETParser.Buf1Context ctx) {
    return exprVisitBin(ctx);
  }

  @Override public Object visitBuf2(PTNETParser.Buf2Context ctx) {
    return exprVisitBin(ctx);
  }

  @Override public Object visitBuf3(PTNETParser.Buf3Context ctx) {
    return exprVisitBin(ctx);
  }

  @Override public Object visitBuf4(PTNETParser.Buf4Context ctx) {
    return exprVisitBin(ctx);
  }

  @Override public Object visitBuf5(PTNETParser.Buf5Context ctx) {
    return exprVisitBin(ctx);
  }

  @Override public Object visitBuf6(PTNETParser.Buf6Context ctx) {
    return exprVisitUn(ctx);
  }

  @Override public Object visitBuf7(PTNETParser.Buf7Context ctx) {
    return exprVisitUn(ctx);
  }

  @Override public Object visitBuf8(PTNETParser.Buf8Context ctx) {
    if (ctx.getChildCount() == 3) {
      return ctx.getChild(1).accept(this);
    }
    else if (ctx.ID() != null) {
      return new Id(ctx.ID().getText());
    }
    else if (ctx.INTLIT() != null) {
      return new IntLit(Integer.parseInt(ctx.INTLIT().getText()));
    }
    else if (ctx.BOOLLIT() != null) {
      return new BoolLit(Boolean.parseBoolean(ctx.BOOLLIT().getText()));
    }
    else if (ctx.FLOATLIT() != null) {
      return new FloatLit(Float.parseFloat(ctx.FLOATLIT().getText()));
    }
    else if (ctx.STRINGLIT() != null) {
      return new StringLit(ctx.STRINGLIT().getText());
    }
    else {
      return ctx.funcCall().accept(this);
    }
  }

  @Override public Object visitFuncCall(PTNETParser.FuncCallContext ctx) {
    String id = ctx.ID().getText();
    List<Expr> param = new LinkedList<Expr>();
    for (PTNETParser.ExprContext i: ctx.expr()) {
      param.add((Expr)i.accept(this));
    }
    return new FuncCall(id, param);
  }

  @Override public String visitTerminal(TerminalNode node) {
    return node.getText();
  }

  public Object exprVisitBin(ParserRuleContext ctx) {
    if (ctx.getChildCount() == 1) {
      return ctx.getChild(0).accept(this);
    }
    else {
      return new BinOp(ctx.getChild(1).getText(), (Expr)ctx.getChild(0).accept(this), (Expr)ctx.getChild(2).accept(this));
    }
  }

  public Object exprVisitUn(ParserRuleContext ctx) {
    if (ctx.getChildCount() == 1) {
      return ctx.getChild(0).accept(this);
    }
    else {
      return new UnOp(ctx.getChild(0).getText(), (Expr)ctx.getChild(1).accept(this));
    }
  }

}
