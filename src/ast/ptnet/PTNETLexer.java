// Generated from PTNET.g4 by ANTLR 4.5.3

	package ast.ptnet;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

import ast.parser.ErrorToken;
import ast.parser.IllegalEscape;
import ast.parser.UncloseString;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PTNETLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CONST", "ELSE", "IF", "THEN", "BOOLLIT", "INT", "BOOLEAN", "STRING", 
		"FLOAT", "SEARCH", "CON", "ADD", "SUB", "MUL", "DIV", "MOD", "GT", "GTE", 
		"LT", "LTE", "EQ", "NE", "OR", "AND", "NOT", "DOT", "COMMA", "LP", "RP", 
		"LB", "RB", "LS", "RS", "COLON", "SEMI", "EQUAL", "ASSIGN", "ID", "INTLIT", 
		"FLOATLIT", "STRINGLIT", "ILLEGAL_ESCAPE", "UNCLOSE_STRING", "WS", "LINE_COMMENT", 
		"COMMENT", "ERROR_CHAR"
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
	public Token emit() {
	    switch (getType()) {
	    case UNCLOSE_STRING:
	        Token result = super.emit();
	        throw new UncloseString(result.getText());

	    case ILLEGAL_ESCAPE:
	    	result = super.emit();
	    	throw new IllegalEscape(result.getText());
	    case ERROR_CHAR:
	    	result = super.emit();
	    	throw new ErrorToken(result.getText());
	    default:
	        return super.emit();
	    }
	}


	public PTNETLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PTNET.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\61\u0156\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6~\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"%\3&\3&\3\'\3\'\7\'\u00df\n\'\f\'\16\'\u00e2\13\'\3(\6(\u00e5\n(\r(\16"+
		"(\u00e6\3)\6)\u00ea\n)\r)\16)\u00eb\3)\3)\7)\u00f0\n)\f)\16)\u00f3\13"+
		")\3)\3)\5)\u00f7\n)\3)\6)\u00fa\n)\r)\16)\u00fb\3)\3)\7)\u0100\n)\f)\16"+
		")\u0103\13)\3)\3)\5)\u0107\n)\3)\6)\u010a\n)\r)\16)\u010b\5)\u010e\n)"+
		"\3*\3*\3*\3*\7*\u0114\n*\f*\16*\u0117\13*\3*\3*\3+\3+\3+\3+\7+\u011f\n"+
		"+\f+\16+\u0122\13+\3+\3+\3+\5+\u0127\n+\3,\3,\3,\3,\7,\u012d\n,\f,\16"+
		",\u0130\13,\3-\6-\u0133\n-\r-\16-\u0134\3-\3-\3.\3.\3.\3.\7.\u013d\n."+
		"\f.\16.\u0140\13.\3.\5.\u0143\n.\3.\3.\3/\3/\3/\3/\7/\u014b\n/\f/\16/"+
		"\u014e\13/\3/\3/\3/\3/\3/\3\60\3\60\4\u013e\u014c\2\61\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\13\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4"+
		"\2GGgg\4\2--//\b\2$$^^ddppttvv\5\2\f\f$$^^\5\2\13\f\17\17\"\"\3\3\f\f"+
		"\u016b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\3a\3\2\2\2\5g\3\2\2\2\7l\3\2\2\2\to\3\2\2\2\13}\3\2\2\2\r\177\3\2\2"+
		"\2\17\u0083\3\2\2\2\21\u008b\3\2\2\2\23\u0092\3\2\2\2\25\u0098\3\2\2\2"+
		"\27\u009f\3\2\2\2\31\u00a1\3\2\2\2\33\u00a3\3\2\2\2\35\u00a5\3\2\2\2\37"+
		"\u00a7\3\2\2\2!\u00a9\3\2\2\2#\u00ab\3\2\2\2%\u00ad\3\2\2\2\'\u00b0\3"+
		"\2\2\2)\u00b2\3\2\2\2+\u00b5\3\2\2\2-\u00b8\3\2\2\2/\u00bb\3\2\2\2\61"+
		"\u00be\3\2\2\2\63\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c5\3\2\2\29\u00c7"+
		"\3\2\2\2;\u00c9\3\2\2\2=\u00cb\3\2\2\2?\u00cd\3\2\2\2A\u00cf\3\2\2\2C"+
		"\u00d1\3\2\2\2E\u00d3\3\2\2\2G\u00d5\3\2\2\2I\u00d7\3\2\2\2K\u00da\3\2"+
		"\2\2M\u00dc\3\2\2\2O\u00e4\3\2\2\2Q\u00e9\3\2\2\2S\u010f\3\2\2\2U\u011a"+
		"\3\2\2\2W\u0128\3\2\2\2Y\u0132\3\2\2\2[\u0138\3\2\2\2]\u0146\3\2\2\2_"+
		"\u0154\3\2\2\2ab\7e\2\2bc\7q\2\2cd\7p\2\2de\7u\2\2ef\7v\2\2f\4\3\2\2\2"+
		"gh\7g\2\2hi\7n\2\2ij\7u\2\2jk\7g\2\2k\6\3\2\2\2lm\7k\2\2mn\7h\2\2n\b\3"+
		"\2\2\2op\7v\2\2pq\7j\2\2qr\7g\2\2rs\7p\2\2s\n\3\2\2\2tu\7v\2\2uv\7t\2"+
		"\2vw\7w\2\2w~\7g\2\2xy\7h\2\2yz\7c\2\2z{\7n\2\2{|\7u\2\2|~\7g\2\2}t\3"+
		"\2\2\2}x\3\2\2\2~\f\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081"+
		"\u0082\7v\2\2\u0082\16\3\2\2\2\u0083\u0084\7d\2\2\u0084\u0085\7q\2\2\u0085"+
		"\u0086\7q\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\u0089\7c\2\2"+
		"\u0089\u008a\7p\2\2\u008a\20\3\2\2\2\u008b\u008c\7u\2\2\u008c\u008d\7"+
		"v\2\2\u008d\u008e\7t\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090\u0091"+
		"\7i\2\2\u0091\22\3\2\2\2\u0092\u0093\7h\2\2\u0093\u0094\7n\2\2\u0094\u0095"+
		"\7q\2\2\u0095\u0096\7c\2\2\u0096\u0097\7v\2\2\u0097\24\3\2\2\2\u0098\u0099"+
		"\7u\2\2\u0099\u009a\7g\2\2\u009a\u009b\7c\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7e\2\2\u009d\u009e\7j\2\2\u009e\26\3\2\2\2\u009f\u00a0\7`\2\2\u00a0"+
		"\30\3\2\2\2\u00a1\u00a2\7-\2\2\u00a2\32\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4"+
		"\34\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\36\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8"+
		" \3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\"\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac"+
		"$\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\7?\2\2\u00af&\3\2\2\2\u00b0\u00b1"+
		"\7>\2\2\u00b1(\3\2\2\2\u00b2\u00b3\7>\2\2\u00b3\u00b4\7?\2\2\u00b4*\3"+
		"\2\2\2\u00b5\u00b6\7?\2\2\u00b6\u00b7\7?\2\2\u00b7,\3\2\2\2\u00b8\u00b9"+
		"\7#\2\2\u00b9\u00ba\7?\2\2\u00ba.\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc\u00bd"+
		"\7~\2\2\u00bd\60\3\2\2\2\u00be\u00bf\7(\2\2\u00bf\u00c0\7(\2\2\u00c0\62"+
		"\3\2\2\2\u00c1\u00c2\7#\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7\60\2\2\u00c4"+
		"\66\3\2\2\2\u00c5\u00c6\7.\2\2\u00c68\3\2\2\2\u00c7\u00c8\7*\2\2\u00c8"+
		":\3\2\2\2\u00c9\u00ca\7+\2\2\u00ca<\3\2\2\2\u00cb\u00cc\7}\2\2\u00cc>"+
		"\3\2\2\2\u00cd\u00ce\7\177\2\2\u00ce@\3\2\2\2\u00cf\u00d0\7]\2\2\u00d0"+
		"B\3\2\2\2\u00d1\u00d2\7_\2\2\u00d2D\3\2\2\2\u00d3\u00d4\7<\2\2\u00d4F"+
		"\3\2\2\2\u00d5\u00d6\7=\2\2\u00d6H\3\2\2\2\u00d7\u00d8\7?\2\2\u00d8\u00d9"+
		"\7?\2\2\u00d9J\3\2\2\2\u00da\u00db\7?\2\2\u00dbL\3\2\2\2\u00dc\u00e0\t"+
		"\2\2\2\u00dd\u00df\t\3\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1N\3\2\2\2\u00e2\u00e0\3\2\2\2"+
		"\u00e3\u00e5\t\4\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7P\3\2\2\2\u00e8\u00ea\t\4\2\2\u00e9"+
		"\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2"+
		"\2\2\u00ec\u010d\3\2\2\2\u00ed\u00f1\7\60\2\2\u00ee\u00f0\t\4\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u010e\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f6\t\5\2\2\u00f5"+
		"\u00f7\t\6\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2"+
		"\2\2\u00f8\u00fa\t\4\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u010e\3\2\2\2\u00fd\u0101\7\60"+
		"\2\2\u00fe\u0100\t\4\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u0106\t\5\2\2\u0105\u0107\t\6\2\2\u0106\u0105\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0109\3\2\2\2\u0108\u010a\t\4\2\2\u0109\u0108\3\2"+
		"\2\2\u010a\u010b\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c"+
		"\u010e\3\2\2\2\u010d\u00ed\3\2\2\2\u010d\u00f4\3\2\2\2\u010d\u00fd\3\2"+
		"\2\2\u010eR\3\2\2\2\u010f\u0115\7$\2\2\u0110\u0111\7^\2\2\u0111\u0114"+
		"\t\7\2\2\u0112\u0114\n\b\2\2\u0113\u0110\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2"+
		"\2\2\u0117\u0115\3\2\2\2\u0118\u0119\7$\2\2\u0119T\3\2\2\2\u011a\u0120"+
		"\7$\2\2\u011b\u011c\7^\2\2\u011c\u011f\t\7\2\2\u011d\u011f\n\b\2\2\u011e"+
		"\u011b\3\2\2\2\u011e\u011d\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2"+
		"\2\2\u0120\u0121\3\2\2\2\u0121\u0126\3\2\2\2\u0122\u0120\3\2\2\2\u0123"+
		"\u0127\7^\2\2\u0124\u0125\7^\2\2\u0125\u0127\n\7\2\2\u0126\u0123\3\2\2"+
		"\2\u0126\u0124\3\2\2\2\u0127V\3\2\2\2\u0128\u012e\7$\2\2\u0129\u012a\7"+
		"^\2\2\u012a\u012d\t\7\2\2\u012b\u012d\n\b\2\2\u012c\u0129\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012fX\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0133\t\t\2\2\u0132\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\b-\2\2\u0137Z\3\2\2\2\u0138\u0139\7\'\2\2\u0139"+
		"\u013a\7\'\2\2\u013a\u013e\3\2\2\2\u013b\u013d\13\2\2\2\u013c\u013b\3"+
		"\2\2\2\u013d\u0140\3\2\2\2\u013e\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0142\3\2\2\2\u0140\u013e\3\2\2\2\u0141\u0143\t\n\2\2\u0142\u0141\3\2"+
		"\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b.\2\2\u0145\\\3\2\2\2\u0146\u0147"+
		"\7\61\2\2\u0147\u0148\7,\2\2\u0148\u014c\3\2\2\2\u0149\u014b\13\2\2\2"+
		"\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014d\3\2\2\2\u014c\u014a"+
		"\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7,\2\2\u0150"+
		"\u0151\7\61\2\2\u0151\u0152\3\2\2\2\u0152\u0153\b/\2\2\u0153^\3\2\2\2"+
		"\u0154\u0155\13\2\2\2\u0155`\3\2\2\2\31\2}\u00e0\u00e6\u00eb\u00f1\u00f6"+
		"\u00fb\u0101\u0106\u010b\u010d\u0113\u0115\u011e\u0120\u0126\u012c\u012e"+
		"\u0134\u013e\u0142\u014c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}