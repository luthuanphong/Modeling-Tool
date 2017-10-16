// Generated from PTNET.g4 by ANTLR 4.5.3

	package ast.ptnet;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PTNETParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PTNETVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PTNETParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PTNETParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#varDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDec(PTNETParser.VarDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#constDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDec(PTNETParser.ConstDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PTNETParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PTNETParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#funcDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDec(PTNETParser.FuncDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#varLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarLocal(PTNETParser.VarLocalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(PTNETParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PTNETParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#asnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsnStmt(PTNETParser.AsnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(PTNETParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#srcStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSrcStmt(PTNETParser.SrcStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PTNETParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf1(PTNETParser.Buf1Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf2(PTNETParser.Buf2Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf3(PTNETParser.Buf3Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf4}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf4(PTNETParser.Buf4Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf5}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf5(PTNETParser.Buf5Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf6}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf6(PTNETParser.Buf6Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf7}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf7(PTNETParser.Buf7Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#buf8}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuf8(PTNETParser.Buf8Context ctx);
	/**
	 * Visit a parse tree produced by {@link PTNETParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(PTNETParser.FuncCallContext ctx);
}