// Generated from PTNET.g4 by ANTLR 4.5.3

	package ast.ptnet;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PTNETParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CONST=1, ELSE=2, IF=3, THEN=4, BOOLLIT=5, INT=6, BOOLEAN=7, STRING=8, 
		FLOAT=9, SEARCH=10, CON=11, ADD=12, SUB=13, MUL=14, DIV=15, MOD=16, GT=17, 
		GTE=18, LT=19, LTE=20, EQ=21, NE=22, OR=23, AND=24, NOT=25, DOT=26, COMMA=27, 
		LP=28, RP=29, LB=30, RB=31, LS=32, RS=33, COLON=34, SEMI=35, EQUAL=36, 
		ASSIGN=37, ID=38, INTLIT=39, FLOATLIT=40, STRINGLIT=41, ILLEGAL_ESCAPE=42, 
		UNCLOSE_STRING=43, WS=44, LINE_COMMENT=45, COMMENT=46, ERROR_CHAR=47;
	public static final int
		RULE_program = 0, RULE_varDec = 1, RULE_constDec = 2, RULE_type = 3, RULE_constant = 4, 
		RULE_funcDec = 5, RULE_varLocal = 6, RULE_stmt = 7, RULE_block = 8, RULE_asnStmt = 9, 
		RULE_ifStmt = 10, RULE_srcStmt = 11, RULE_expr = 12, RULE_buf1 = 13, RULE_buf2 = 14, 
		RULE_buf3 = 15, RULE_buf4 = 16, RULE_buf5 = 17, RULE_buf6 = 18, RULE_buf7 = 19, 
		RULE_buf8 = 20, RULE_funcCall = 21;
	public static final String[] ruleNames = {
		"program", "varDec", "constDec", "type", "constant", "funcDec", "varLocal", 
		"stmt", "block", "asnStmt", "ifStmt", "srcStmt", "expr", "buf1", "buf2", 
		"buf3", "buf4", "buf5", "buf6", "buf7", "buf8", "funcCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'const'", "'else'", "'if'", "'then'", null, "'int'", "'boolean'", 
		"'string'", "'float'", "'search'", "'^'", "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'>'", "'>='", "'<'", "'<='", null, "'!='", "'||'", "'&&'", "'!'", 
		"'.'", "','", "'('", "')'", "'{'", "'}'", "'['", "']'", "':'", "';'", 
		null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CONST", "ELSE", "IF", "THEN", "BOOLLIT", "INT", "BOOLEAN", "STRING", 
		"FLOAT", "SEARCH", "CON", "ADD", "SUB", "MUL", "DIV", "MOD", "GT", "GTE", 
		"LT", "LTE", "EQ", "NE", "OR", "AND", "NOT", "DOT", "COMMA", "LP", "RP", 
		"LB", "RB", "LS", "RS", "COLON", "SEMI", "EQUAL", "ASSIGN", "ID", "INTLIT", 
		"FLOATLIT", "STRINGLIT", "ILLEGAL_ESCAPE", "UNCLOSE_STRING", "WS", "LINE_COMMENT", 
		"COMMENT", "ERROR_CHAR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PTNET.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PTNETParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<VarDecContext> varDec() {
			return getRuleContexts(VarDecContext.class);
		}
		public VarDecContext varDec(int i) {
			return getRuleContext(VarDecContext.class,i);
		}
		public List<ConstDecContext> constDec() {
			return getRuleContexts(ConstDecContext.class);
		}
		public ConstDecContext constDec(int i) {
			return getRuleContext(ConstDecContext.class,i);
		}
		public List<FuncDecContext> funcDec() {
			return getRuleContexts(FuncDecContext.class);
		}
		public FuncDecContext funcDec(int i) {
			return getRuleContext(FuncDecContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(46);
				switch (_input.LA(1)) {
				case INT:
				case BOOLEAN:
				case STRING:
				case FLOAT:
					{
					setState(44);
					varDec();
					}
					break;
				case CONST:
					{
					setState(45);
					constDec();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CONST) | (1L << INT) | (1L << BOOLEAN) | (1L << STRING) | (1L << FLOAT))) != 0) );
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(50);
				funcDec();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDecContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PTNETParser.ASSIGN, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PTNETParser.SEMI, 0); }
		public VarDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitVarDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDecContext varDec() throws RecognitionException {
		VarDecContext _localctx = new VarDecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_varDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			type();
			setState(57);
			match(ID);
			setState(58);
			match(ASSIGN);
			setState(59);
			constant();
			setState(60);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDecContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(PTNETParser.CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PTNETParser.ASSIGN, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PTNETParser.SEMI, 0); }
		public ConstDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitConstDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDecContext constDec() throws RecognitionException {
		ConstDecContext _localctx = new ConstDecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CONST);
			setState(63);
			type();
			setState(64);
			match(ID);
			setState(65);
			match(ASSIGN);
			setState(66);
			constant();
			setState(67);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(PTNETParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(PTNETParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(PTNETParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(PTNETParser.FLOAT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << STRING) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTLIT() { return getToken(PTNETParser.INTLIT, 0); }
		public TerminalNode BOOLLIT() { return getToken(PTNETParser.BOOLLIT, 0); }
		public TerminalNode STRINGLIT() { return getToken(PTNETParser.STRINGLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(PTNETParser.FLOATLIT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLLIT) | (1L << INTLIT) | (1L << FLOATLIT) | (1L << STRINGLIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDecContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitFuncDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDecContext funcDec() throws RecognitionException {
		FuncDecContext _localctx = new FuncDecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(ID);
			setState(74);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarLocalContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PTNETParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PTNETParser.SEMI, 0); }
		public VarLocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varLocal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitVarLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarLocalContext varLocal() throws RecognitionException {
		VarLocalContext _localctx = new VarLocalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varLocal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			type();
			setState(77);
			match(ID);
			setState(78);
			match(ASSIGN);
			setState(79);
			expr();
			setState(80);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AsnStmtContext asnStmt() {
			return getRuleContext(AsnStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public SrcStmtContext srcStmt() {
			return getRuleContext(SrcStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(86);
			switch (_input.LA(1)) {
			case LB:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				block();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				asnStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				ifStmt();
				}
				break;
			case SEARCH:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				srcStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(PTNETParser.LB, 0); }
		public TerminalNode RB() { return getToken(PTNETParser.RB, 0); }
		public List<VarLocalContext> varLocal() {
			return getRuleContexts(VarLocalContext.class);
		}
		public VarLocalContext varLocal(int i) {
			return getRuleContext(VarLocalContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(LB);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOLEAN) | (1L << STRING) | (1L << FLOAT))) != 0)) {
				{
				{
				setState(89);
				varLocal();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << SEARCH) | (1L << LB) | (1L << ID))) != 0)) {
				{
				{
				setState(95);
				stmt();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsnStmtContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PTNETParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PTNETParser.SEMI, 0); }
		public AsnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asnStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitAsnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AsnStmtContext asnStmt() throws RecognitionException {
		AsnStmtContext _localctx = new AsnStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			setState(104);
			match(ASSIGN);
			setState(105);
			expr();
			setState(106);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PTNETParser.IF, 0); }
		public TerminalNode LP() { return getToken(PTNETParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(PTNETParser.RP, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PTNETParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(IF);
			setState(109);
			match(LP);
			setState(110);
			expr();
			setState(111);
			match(RP);
			setState(112);
			stmt();
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(113);
				match(ELSE);
				setState(114);
				stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SrcStmtContext extends ParserRuleContext {
		public TerminalNode SEARCH() { return getToken(PTNETParser.SEARCH, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(PTNETParser.SEMI, 0); }
		public SrcStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_srcStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitSrcStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SrcStmtContext srcStmt() throws RecognitionException {
		SrcStmtContext _localctx = new SrcStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_srcStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(SEARCH);
			setState(118);
			expr();
			setState(119);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<Buf1Context> buf1() {
			return getRuleContexts(Buf1Context.class);
		}
		public Buf1Context buf1(int i) {
			return getRuleContext(Buf1Context.class,i);
		}
		public TerminalNode GT() { return getToken(PTNETParser.GT, 0); }
		public TerminalNode GTE() { return getToken(PTNETParser.GTE, 0); }
		public TerminalNode LT() { return getToken(PTNETParser.LT, 0); }
		public TerminalNode LTE() { return getToken(PTNETParser.LTE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				buf1();
				setState(122);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GTE) | (1L << LT) | (1L << LTE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(123);
				buf1();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				buf1();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Buf1Context extends ParserRuleContext {
		public List<Buf2Context> buf2() {
			return getRuleContexts(Buf2Context.class);
		}
		public Buf2Context buf2(int i) {
			return getRuleContext(Buf2Context.class,i);
		}
		public TerminalNode EQ() { return getToken(PTNETParser.EQ, 0); }
		public TerminalNode NE() { return getToken(PTNETParser.NE, 0); }
		public Buf1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf1Context buf1() throws RecognitionException {
		Buf1Context _localctx = new Buf1Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_buf1);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				buf2(0);
				setState(129);
				_la = _input.LA(1);
				if ( !(_la==EQ || _la==NE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(130);
				buf2(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				buf2(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Buf2Context extends ParserRuleContext {
		public Buf3Context buf3() {
			return getRuleContext(Buf3Context.class,0);
		}
		public Buf2Context buf2() {
			return getRuleContext(Buf2Context.class,0);
		}
		public TerminalNode AND() { return getToken(PTNETParser.AND, 0); }
		public TerminalNode OR() { return getToken(PTNETParser.OR, 0); }
		public Buf2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf2Context buf2() throws RecognitionException {
		return buf2(0);
	}

	private Buf2Context buf2(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Buf2Context _localctx = new Buf2Context(_ctx, _parentState);
		Buf2Context _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_buf2, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(136);
			buf3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(143);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Buf2Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_buf2);
					setState(138);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(139);
					_la = _input.LA(1);
					if ( !(_la==OR || _la==AND) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(140);
					buf3(0);
					}
					} 
				}
				setState(145);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Buf3Context extends ParserRuleContext {
		public Buf4Context buf4() {
			return getRuleContext(Buf4Context.class,0);
		}
		public Buf3Context buf3() {
			return getRuleContext(Buf3Context.class,0);
		}
		public TerminalNode ADD() { return getToken(PTNETParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PTNETParser.SUB, 0); }
		public Buf3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf3; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf3Context buf3() throws RecognitionException {
		return buf3(0);
	}

	private Buf3Context buf3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Buf3Context _localctx = new Buf3Context(_ctx, _parentState);
		Buf3Context _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_buf3, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(147);
			buf4(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Buf3Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_buf3);
					setState(149);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(150);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(151);
					buf4(0);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Buf4Context extends ParserRuleContext {
		public Buf5Context buf5() {
			return getRuleContext(Buf5Context.class,0);
		}
		public Buf4Context buf4() {
			return getRuleContext(Buf4Context.class,0);
		}
		public TerminalNode MUL() { return getToken(PTNETParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PTNETParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PTNETParser.MOD, 0); }
		public Buf4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf4; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf4(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf4Context buf4() throws RecognitionException {
		return buf4(0);
	}

	private Buf4Context buf4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Buf4Context _localctx = new Buf4Context(_ctx, _parentState);
		Buf4Context _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_buf4, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(158);
			buf5(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Buf4Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_buf4);
					setState(160);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(161);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(162);
					buf5(0);
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Buf5Context extends ParserRuleContext {
		public Buf6Context buf6() {
			return getRuleContext(Buf6Context.class,0);
		}
		public Buf5Context buf5() {
			return getRuleContext(Buf5Context.class,0);
		}
		public TerminalNode CON() { return getToken(PTNETParser.CON, 0); }
		public Buf5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf5; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf5(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf5Context buf5() throws RecognitionException {
		return buf5(0);
	}

	private Buf5Context buf5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Buf5Context _localctx = new Buf5Context(_ctx, _parentState);
		Buf5Context _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_buf5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(169);
			buf6();
			}
			_ctx.stop = _input.LT(-1);
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Buf5Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_buf5);
					setState(171);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(172);
					match(CON);
					setState(173);
					buf6();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Buf6Context extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PTNETParser.NOT, 0); }
		public Buf6Context buf6() {
			return getRuleContext(Buf6Context.class,0);
		}
		public Buf7Context buf7() {
			return getRuleContext(Buf7Context.class,0);
		}
		public Buf6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf6; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf6(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf6Context buf6() throws RecognitionException {
		Buf6Context _localctx = new Buf6Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_buf6);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(NOT);
				setState(180);
				buf6();
				}
				break;
			case BOOLLIT:
			case ADD:
			case SUB:
			case LP:
			case ID:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				buf7();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Buf7Context extends ParserRuleContext {
		public Buf7Context buf7() {
			return getRuleContext(Buf7Context.class,0);
		}
		public TerminalNode ADD() { return getToken(PTNETParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PTNETParser.SUB, 0); }
		public Buf8Context buf8() {
			return getRuleContext(Buf8Context.class,0);
		}
		public Buf7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf7; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf7(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf7Context buf7() throws RecognitionException {
		Buf7Context _localctx = new Buf7Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_buf7);
		int _la;
		try {
			setState(187);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(185);
				buf7();
				}
				break;
			case BOOLLIT:
			case LP:
			case ID:
			case INTLIT:
			case FLOATLIT:
			case STRINGLIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				buf8();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Buf8Context extends ParserRuleContext {
		public TerminalNode LP() { return getToken(PTNETParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(PTNETParser.RP, 0); }
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode INTLIT() { return getToken(PTNETParser.INTLIT, 0); }
		public TerminalNode STRINGLIT() { return getToken(PTNETParser.STRINGLIT, 0); }
		public TerminalNode BOOLLIT() { return getToken(PTNETParser.BOOLLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(PTNETParser.FLOATLIT, 0); }
		public Buf8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buf8; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitBuf8(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Buf8Context buf8() throws RecognitionException {
		Buf8Context _localctx = new Buf8Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_buf8);
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(LP);
				setState(190);
				expr();
				setState(191);
				match(RP);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				funcCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(INTLIT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				match(STRINGLIT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(197);
				match(BOOLLIT);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(198);
				match(FLOATLIT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PTNETParser.ID, 0); }
		public TerminalNode LP() { return getToken(PTNETParser.LP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RP() { return getToken(PTNETParser.RP, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PTNETParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PTNETParser.COMMA, i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PTNETVisitor ) return ((PTNETVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ID);
			setState(202);
			match(LP);
			setState(203);
			expr();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(204);
				match(COMMA);
				setState(205);
				expr();
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return buf2_sempred((Buf2Context)_localctx, predIndex);
		case 15:
			return buf3_sempred((Buf3Context)_localctx, predIndex);
		case 16:
			return buf4_sempred((Buf4Context)_localctx, predIndex);
		case 17:
			return buf5_sempred((Buf5Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean buf2_sempred(Buf2Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean buf3_sempred(Buf3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean buf4_sempred(Buf4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean buf5_sempred(Buf5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u00d8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\6\2\61\n\2"+
		"\r\2\16\2\62\3\2\7\2\66\n\2\f\2\16\29\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\5\tY\n\t\3\n\3\n\7\n]\n\n\f\n\16\n`\13\n\3\n\7"+
		"\nc\n\n\f\n\16\nf\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\5\fv\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u0081\n\16\3\17\3\17\3\17\3\17\3\17\5\17\u0088\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\7\21\u009b\n\21\f\21\16\21\u009e\13\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\7\22\u00a6\n\22\f\22\16\22\u00a9\13\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\7\23\u00b1\n\23\f\23\16\23\u00b4\13\23\3\24\3\24\3\24\5"+
		"\24\u00b9\n\24\3\25\3\25\3\25\5\25\u00be\n\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00ca\n\26\3\27\3\27\3\27\3\27\3\27\7\27"+
		"\u00d1\n\27\f\27\16\27\u00d4\13\27\3\27\3\27\3\27\2\6\36 \"$\30\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\t\3\2\b\13\4\2\7\7)+\3\2\23"+
		"\26\3\2\27\30\3\2\31\32\3\2\16\17\3\2\20\22\u00d9\2\60\3\2\2\2\4:\3\2"+
		"\2\2\6@\3\2\2\2\bG\3\2\2\2\nI\3\2\2\2\fK\3\2\2\2\16N\3\2\2\2\20X\3\2\2"+
		"\2\22Z\3\2\2\2\24i\3\2\2\2\26n\3\2\2\2\30w\3\2\2\2\32\u0080\3\2\2\2\34"+
		"\u0087\3\2\2\2\36\u0089\3\2\2\2 \u0094\3\2\2\2\"\u009f\3\2\2\2$\u00aa"+
		"\3\2\2\2&\u00b8\3\2\2\2(\u00bd\3\2\2\2*\u00c9\3\2\2\2,\u00cb\3\2\2\2."+
		"\61\5\4\3\2/\61\5\6\4\2\60.\3\2\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3"+
		"\2\2\2\62\63\3\2\2\2\63\67\3\2\2\2\64\66\5\f\7\2\65\64\3\2\2\2\669\3\2"+
		"\2\2\67\65\3\2\2\2\678\3\2\2\28\3\3\2\2\29\67\3\2\2\2:;\5\b\5\2;<\7(\2"+
		"\2<=\7\'\2\2=>\5\n\6\2>?\7%\2\2?\5\3\2\2\2@A\7\3\2\2AB\5\b\5\2BC\7(\2"+
		"\2CD\7\'\2\2DE\5\n\6\2EF\7%\2\2F\7\3\2\2\2GH\t\2\2\2H\t\3\2\2\2IJ\t\3"+
		"\2\2J\13\3\2\2\2KL\7(\2\2LM\5\22\n\2M\r\3\2\2\2NO\5\b\5\2OP\7(\2\2PQ\7"+
		"\'\2\2QR\5\32\16\2RS\7%\2\2S\17\3\2\2\2TY\5\22\n\2UY\5\24\13\2VY\5\26"+
		"\f\2WY\5\30\r\2XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2XW\3\2\2\2Y\21\3\2\2\2Z^"+
		"\7 \2\2[]\5\16\b\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_d\3\2\2\2"+
		"`^\3\2\2\2ac\5\20\t\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2"+
		"\2fd\3\2\2\2gh\7!\2\2h\23\3\2\2\2ij\7(\2\2jk\7\'\2\2kl\5\32\16\2lm\7%"+
		"\2\2m\25\3\2\2\2no\7\5\2\2op\7\36\2\2pq\5\32\16\2qr\7\37\2\2ru\5\20\t"+
		"\2st\7\4\2\2tv\5\20\t\2us\3\2\2\2uv\3\2\2\2v\27\3\2\2\2wx\7\f\2\2xy\5"+
		"\32\16\2yz\7%\2\2z\31\3\2\2\2{|\5\34\17\2|}\t\4\2\2}~\5\34\17\2~\u0081"+
		"\3\2\2\2\177\u0081\5\34\17\2\u0080{\3\2\2\2\u0080\177\3\2\2\2\u0081\33"+
		"\3\2\2\2\u0082\u0083\5\36\20\2\u0083\u0084\t\5\2\2\u0084\u0085\5\36\20"+
		"\2\u0085\u0088\3\2\2\2\u0086\u0088\5\36\20\2\u0087\u0082\3\2\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\35\3\2\2\2\u0089\u008a\b\20\1\2\u008a\u008b\5 \21"+
		"\2\u008b\u0091\3\2\2\2\u008c\u008d\f\4\2\2\u008d\u008e\t\6\2\2\u008e\u0090"+
		"\5 \21\2\u008f\u008c\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\37\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\b\21\1"+
		"\2\u0095\u0096\5\"\22\2\u0096\u009c\3\2\2\2\u0097\u0098\f\4\2\2\u0098"+
		"\u0099\t\7\2\2\u0099\u009b\5\"\22\2\u009a\u0097\3\2\2\2\u009b\u009e\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d!\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a0\b\22\1\2\u00a0\u00a1\5$\23\2\u00a1\u00a7\3\2\2\2"+
		"\u00a2\u00a3\f\4\2\2\u00a3\u00a4\t\b\2\2\u00a4\u00a6\5$\23\2\u00a5\u00a2"+
		"\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"#\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\b\23\1\2\u00ab\u00ac\5&\24\2"+
		"\u00ac\u00b2\3\2\2\2\u00ad\u00ae\f\4\2\2\u00ae\u00af\7\r\2\2\u00af\u00b1"+
		"\5&\24\2\u00b0\u00ad\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3%\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\33\2\2"+
		"\u00b6\u00b9\5&\24\2\u00b7\u00b9\5(\25\2\u00b8\u00b5\3\2\2\2\u00b8\u00b7"+
		"\3\2\2\2\u00b9\'\3\2\2\2\u00ba\u00bb\t\7\2\2\u00bb\u00be\5(\25\2\u00bc"+
		"\u00be\5*\26\2\u00bd\u00ba\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be)\3\2\2\2"+
		"\u00bf\u00c0\7\36\2\2\u00c0\u00c1\5\32\16\2\u00c1\u00c2\7\37\2\2\u00c2"+
		"\u00ca\3\2\2\2\u00c3\u00ca\5,\27\2\u00c4\u00ca\7(\2\2\u00c5\u00ca\7)\2"+
		"\2\u00c6\u00ca\7+\2\2\u00c7\u00ca\7\7\2\2\u00c8\u00ca\7*\2\2\u00c9\u00bf"+
		"\3\2\2\2\u00c9\u00c3\3\2\2\2\u00c9\u00c4\3\2\2\2\u00c9\u00c5\3\2\2\2\u00c9"+
		"\u00c6\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca+\3\2\2\2"+
		"\u00cb\u00cc\7(\2\2\u00cc\u00cd\7\36\2\2\u00cd\u00d2\5\32\16\2\u00ce\u00cf"+
		"\7\35\2\2\u00cf\u00d1\5\32\16\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2"+
		"\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d5\u00d6\7\37\2\2\u00d6-\3\2\2\2\23\60\62\67X^du\u0080\u0087"+
		"\u0091\u009c\u00a7\u00b2\u00b8\u00bd\u00c9\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}