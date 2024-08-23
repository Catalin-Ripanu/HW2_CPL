// Generated from D:/Tema3/src/cool/lexer/CoolLexer.g4 by ANTLR 4.13.1

    package cool.lexer;	

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, INHERITS=2, BOOL=3, NOT=4, ISVOID=5, NEW=6, LET=7, IN=8, IF=9, 
		THEN=10, ELSE=11, FI=12, WHILE=13, LOOP=14, POOL=15, CASE=16, OF=17, ESAC=18, 
		INT=19, TYPE=20, ID=21, ASSIGN=22, PLUS=23, MINUS=24, MULT=25, DIV=26, 
		LT=27, LE=28, EQUAL=29, NOTSYMB=30, RESULT=31, LPAREN=32, RPAREN=33, LBRACE=34, 
		RBRACE=35, SEMI=36, COLON=37, COMMA=38, DISPATCH=39, DOT=40, STRING=41, 
		BLOCK_COMMENT_OK=42, BLOCK_COMMENT_ERROR=43, WRONG_COMMENT=44, LINE_COMMENT=45, 
		WS=46, ERROR=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"CLASS", "INHERITS", "BOOL", "NOT", "ISVOID", "NEW", "LET", "IN", "IF", 
			"THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", "OF", "ESAC", 
			"DIGIT", "INT", "LETTER", "LETTER_LOWER", "LETTER_UPPER", "TYPE", "ID", 
			"ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "LT", "LE", "EQUAL", "NOTSYMB", 
			"RESULT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "SEMI", "COLON", "COMMA", 
			"DISPATCH", "DOT", "STRING", "BLOCK_COMMENT_OK", "BLOCK_COMMENT_ERROR", 
			"WRONG_COMMENT", "LINE_COMMENT", "WS", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'inherits'", null, "'not'", "'isvoid'", "'new'", "'let'", 
			"'in'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'loop'", "'pool'", 
			"'case'", "'of'", "'esac'", null, null, null, "'<-'", "'+'", "'-'", "'*'", 
			"'/'", "'<'", "'<='", "'='", "'~'", "'=>'", "'('", "')'", "'{'", "'}'", 
			"';'", "':'", "','", "'@'", "'.'", null, null, null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CLASS", "INHERITS", "BOOL", "NOT", "ISVOID", "NEW", "LET", "IN", 
			"IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "CASE", "OF", "ESAC", 
			"INT", "TYPE", "ID", "ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "LT", 
			"LE", "EQUAL", "NOTSYMB", "RESULT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"SEMI", "COLON", "COMMA", "DISPATCH", "DOT", "STRING", "BLOCK_COMMENT_OK", 
			"BLOCK_COMMENT_ERROR", "WRONG_COMMENT", "LINE_COMMENT", "WS", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	    private void raiseError(String msg) {
	        setText(msg);
	        setType(ERROR);
	    }

	    // Functie pentru procesarea unui token string
	    private void stringProcessing(){

	        // Caz in care string-ul e gol
	        if(getText().length()==2) {
	            setText("");
	            return;
	        }

	        // Stergerea ghilimelelor
	        String initialString = getText().substring(1,getText().length()-1);

	        // Verificare caracter NULL
	        if(initialString.contains("\u0000")){
	            raiseError("String contains null character");
	            return;
	        }

	        // Inlocuire \t , \n, \b si \f
	        StringBuffer newString = new StringBuffer();
	        for(int i = 0; i < initialString.length(); ++i) {
	        	if(initialString.charAt(i) == '\\')
	        	    {
	        	        switch(initialString.charAt(i+1)){
	                        case 'n': newString.append('\n');    break;
	                        case 't': newString.append('\t');    break;
	                        case 'b': newString.append('\b');    break;
	                        case 'f': newString.append('\f');    break;
	                        default : newString.append(initialString.charAt(i+1));
	                        }
	                    i++;
	                }
	        	else
	        	    newString.append(initialString.charAt(i));

	        if(newString.length() > 1024){
	           raiseError("String constant too long");
	           return;
	        }

	        setText(newString.toString());
	        }
	    }


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			BLOCK_COMMENT_ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		case 47:
			WRONG_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			ERROR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 stringProcessing();
			break;
		case 1:
			 raiseError("EOF in string constant");
			break;
		case 2:
			raiseError("Unterminated string constant");
			break;
		}
	}
	private void BLOCK_COMMENT_ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 raiseError("EOF in comment"); 
			break;
		}
	}
	private void WRONG_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 raiseError("Unmatched *)"); 
			break;
		}
	}
	private void ERROR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 raiseError("Invalid character: " + getText());
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000/\u015d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0080\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00ca\b\u0013\n\u0013"+
		"\f\u0013\u00cd\t\u0013\u0003\u0013\u00cf\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u00db\b\u0017\n\u0017\f\u0017\u00de"+
		"\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u00e4"+
		"\b\u0018\n\u0018\f\u0018\u00e7\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0005"+
		",\u0114\b,\n,\f,\u0117\t,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0003,\u0121\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0005-\u0128"+
		"\b-\n-\f-\u012b\t-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0005.\u0137\b.\n.\f.\u013a\t.\u0001.\u0001.\u0001.\u0001"+
		".\u0003.\u0140\b.\u0001/\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u0001"+
		"0\u00010\u00050\u014b\b0\n0\f0\u014e\t0\u00010\u00010\u00010\u00010\u0001"+
		"1\u00041\u0155\b1\u000b1\f1\u0156\u00011\u00011\u00012\u00012\u00012\u0004"+
		"\u0115\u0129\u0138\u014c\u00003\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0000"+
		"\'\u0013)\u0000+\u0000-\u0000/\u00141\u00153\u00165\u00177\u00189\u0019"+
		";\u001a=\u001b?\u001cA\u001dC\u001eE\u001fG I!K\"M#O$Q%S&U\'W(Y)[*]+_"+
		",a-c.e/\u0001\u0000\u0006\u0001\u000009\u0001\u000019\u0002\u0000AZaz"+
		"\u0001\u0000az\u0001\u0000AZ\u0003\u0000\t\n\f\r  \u016b\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		"/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001"+
		"\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000"+
		"\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000"+
		"=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001"+
		"\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000"+
		"\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000"+
		"K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001"+
		"\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000"+
		"\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000"+
		"Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001"+
		"\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000"+
		"\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0001"+
		"g\u0001\u0000\u0000\u0000\u0003m\u0001\u0000\u0000\u0000\u0005\u007f\u0001"+
		"\u0000\u0000\u0000\u0007\u0081\u0001\u0000\u0000\u0000\t\u0085\u0001\u0000"+
		"\u0000\u0000\u000b\u008c\u0001\u0000\u0000\u0000\r\u0090\u0001\u0000\u0000"+
		"\u0000\u000f\u0094\u0001\u0000\u0000\u0000\u0011\u0097\u0001\u0000\u0000"+
		"\u0000\u0013\u009a\u0001\u0000\u0000\u0000\u0015\u009f\u0001\u0000\u0000"+
		"\u0000\u0017\u00a4\u0001\u0000\u0000\u0000\u0019\u00a7\u0001\u0000\u0000"+
		"\u0000\u001b\u00ad\u0001\u0000\u0000\u0000\u001d\u00b2\u0001\u0000\u0000"+
		"\u0000\u001f\u00b7\u0001\u0000\u0000\u0000!\u00bc\u0001\u0000\u0000\u0000"+
		"#\u00bf\u0001\u0000\u0000\u0000%\u00c4\u0001\u0000\u0000\u0000\'\u00ce"+
		"\u0001\u0000\u0000\u0000)\u00d0\u0001\u0000\u0000\u0000+\u00d2\u0001\u0000"+
		"\u0000\u0000-\u00d4\u0001\u0000\u0000\u0000/\u00d6\u0001\u0000\u0000\u0000"+
		"1\u00df\u0001\u0000\u0000\u00003\u00e8\u0001\u0000\u0000\u00005\u00eb"+
		"\u0001\u0000\u0000\u00007\u00ed\u0001\u0000\u0000\u00009\u00ef\u0001\u0000"+
		"\u0000\u0000;\u00f1\u0001\u0000\u0000\u0000=\u00f3\u0001\u0000\u0000\u0000"+
		"?\u00f5\u0001\u0000\u0000\u0000A\u00f8\u0001\u0000\u0000\u0000C\u00fa"+
		"\u0001\u0000\u0000\u0000E\u00fc\u0001\u0000\u0000\u0000G\u00ff\u0001\u0000"+
		"\u0000\u0000I\u0101\u0001\u0000\u0000\u0000K\u0103\u0001\u0000\u0000\u0000"+
		"M\u0105\u0001\u0000\u0000\u0000O\u0107\u0001\u0000\u0000\u0000Q\u0109"+
		"\u0001\u0000\u0000\u0000S\u010b\u0001\u0000\u0000\u0000U\u010d\u0001\u0000"+
		"\u0000\u0000W\u010f\u0001\u0000\u0000\u0000Y\u0111\u0001\u0000\u0000\u0000"+
		"[\u0122\u0001\u0000\u0000\u0000]\u0131\u0001\u0000\u0000\u0000_\u0141"+
		"\u0001\u0000\u0000\u0000a\u0146\u0001\u0000\u0000\u0000c\u0154\u0001\u0000"+
		"\u0000\u0000e\u015a\u0001\u0000\u0000\u0000gh\u0005c\u0000\u0000hi\u0005"+
		"l\u0000\u0000ij\u0005a\u0000\u0000jk\u0005s\u0000\u0000kl\u0005s\u0000"+
		"\u0000l\u0002\u0001\u0000\u0000\u0000mn\u0005i\u0000\u0000no\u0005n\u0000"+
		"\u0000op\u0005h\u0000\u0000pq\u0005e\u0000\u0000qr\u0005r\u0000\u0000"+
		"rs\u0005i\u0000\u0000st\u0005t\u0000\u0000tu\u0005s\u0000\u0000u\u0004"+
		"\u0001\u0000\u0000\u0000vw\u0005t\u0000\u0000wx\u0005r\u0000\u0000xy\u0005"+
		"u\u0000\u0000y\u0080\u0005e\u0000\u0000z{\u0005f\u0000\u0000{|\u0005a"+
		"\u0000\u0000|}\u0005l\u0000\u0000}~\u0005s\u0000\u0000~\u0080\u0005e\u0000"+
		"\u0000\u007fv\u0001\u0000\u0000\u0000\u007fz\u0001\u0000\u0000\u0000\u0080"+
		"\u0006\u0001\u0000\u0000\u0000\u0081\u0082\u0005n\u0000\u0000\u0082\u0083"+
		"\u0005o\u0000\u0000\u0083\u0084\u0005t\u0000\u0000\u0084\b\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005i\u0000\u0000\u0086\u0087\u0005s\u0000\u0000"+
		"\u0087\u0088\u0005v\u0000\u0000\u0088\u0089\u0005o\u0000\u0000\u0089\u008a"+
		"\u0005i\u0000\u0000\u008a\u008b\u0005d\u0000\u0000\u008b\n\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005n\u0000\u0000\u008d\u008e\u0005e\u0000\u0000"+
		"\u008e\u008f\u0005w\u0000\u0000\u008f\f\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0005l\u0000\u0000\u0091\u0092\u0005e\u0000\u0000\u0092\u0093\u0005"+
		"t\u0000\u0000\u0093\u000e\u0001\u0000\u0000\u0000\u0094\u0095\u0005i\u0000"+
		"\u0000\u0095\u0096\u0005n\u0000\u0000\u0096\u0010\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0005i\u0000\u0000\u0098\u0099\u0005f\u0000\u0000\u0099\u0012"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005t\u0000\u0000\u009b\u009c\u0005"+
		"h\u0000\u0000\u009c\u009d\u0005e\u0000\u0000\u009d\u009e\u0005n\u0000"+
		"\u0000\u009e\u0014\u0001\u0000\u0000\u0000\u009f\u00a0\u0005e\u0000\u0000"+
		"\u00a0\u00a1\u0005l\u0000\u0000\u00a1\u00a2\u0005s\u0000\u0000\u00a2\u00a3"+
		"\u0005e\u0000\u0000\u00a3\u0016\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005"+
		"f\u0000\u0000\u00a5\u00a6\u0005i\u0000\u0000\u00a6\u0018\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0005w\u0000\u0000\u00a8\u00a9\u0005h\u0000\u0000\u00a9"+
		"\u00aa\u0005i\u0000\u0000\u00aa\u00ab\u0005l\u0000\u0000\u00ab\u00ac\u0005"+
		"e\u0000\u0000\u00ac\u001a\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005l\u0000"+
		"\u0000\u00ae\u00af\u0005o\u0000\u0000\u00af\u00b0\u0005o\u0000\u0000\u00b0"+
		"\u00b1\u0005p\u0000\u0000\u00b1\u001c\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0005p\u0000\u0000\u00b3\u00b4\u0005o\u0000\u0000\u00b4\u00b5\u0005o"+
		"\u0000\u0000\u00b5\u00b6\u0005l\u0000\u0000\u00b6\u001e\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0005c\u0000\u0000\u00b8\u00b9\u0005a\u0000\u0000\u00b9"+
		"\u00ba\u0005s\u0000\u0000\u00ba\u00bb\u0005e\u0000\u0000\u00bb \u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005o\u0000\u0000\u00bd\u00be\u0005f\u0000"+
		"\u0000\u00be\"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005e\u0000\u0000"+
		"\u00c0\u00c1\u0005s\u0000\u0000\u00c1\u00c2\u0005a\u0000\u0000\u00c2\u00c3"+
		"\u0005c\u0000\u0000\u00c3$\u0001\u0000\u0000\u0000\u00c4\u00c5\u0007\u0000"+
		"\u0000\u0000\u00c5&\u0001\u0000\u0000\u0000\u00c6\u00cf\u00050\u0000\u0000"+
		"\u00c7\u00cb\u0007\u0001\u0000\u0000\u00c8\u00ca\u0003%\u0012\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce"+
		"\u00c6\u0001\u0000\u0000\u0000\u00ce\u00c7\u0001\u0000\u0000\u0000\u00cf"+
		"(\u0001\u0000\u0000\u0000\u00d0\u00d1\u0007\u0002\u0000\u0000\u00d1*\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0007\u0003\u0000\u0000\u00d3,\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0007\u0004\u0000\u0000\u00d5.\u0001\u0000\u0000"+
		"\u0000\u00d6\u00dc\u0003-\u0016\u0000\u00d7\u00db\u0003)\u0014\u0000\u00d8"+
		"\u00db\u0005_\u0000\u0000\u00d9\u00db\u0003%\u0012\u0000\u00da\u00d7\u0001"+
		"\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00d9\u0001"+
		"\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000\u0000\u00dc\u00da\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd0\u0001\u0000"+
		"\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00df\u00e5\u0003+\u0015"+
		"\u0000\u00e0\u00e4\u0003)\u0014\u0000\u00e1\u00e4\u0005_\u0000\u0000\u00e2"+
		"\u00e4\u0003%\u0012\u0000\u00e3\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e62\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005<\u0000\u0000\u00e9\u00ea\u0005-\u0000"+
		"\u0000\u00ea4\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005+\u0000\u0000\u00ec"+
		"6\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005-\u0000\u0000\u00ee8\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0005*\u0000\u0000\u00f0:\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0005/\u0000\u0000\u00f2<\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f4\u0005<\u0000\u0000\u00f4>\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005"+
		"<\u0000\u0000\u00f6\u00f7\u0005=\u0000\u0000\u00f7@\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0005=\u0000\u0000\u00f9B\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0005~\u0000\u0000\u00fbD\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005"+
		"=\u0000\u0000\u00fd\u00fe\u0005>\u0000\u0000\u00feF\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0005(\u0000\u0000\u0100H\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0005)\u0000\u0000\u0102J\u0001\u0000\u0000\u0000\u0103\u0104\u0005"+
		"{\u0000\u0000\u0104L\u0001\u0000\u0000\u0000\u0105\u0106\u0005}\u0000"+
		"\u0000\u0106N\u0001\u0000\u0000\u0000\u0107\u0108\u0005;\u0000\u0000\u0108"+
		"P\u0001\u0000\u0000\u0000\u0109\u010a\u0005:\u0000\u0000\u010aR\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0005,\u0000\u0000\u010cT\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0005@\u0000\u0000\u010eV\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0005.\u0000\u0000\u0110X\u0001\u0000\u0000\u0000\u0111\u0115\u0005"+
		"\"\u0000\u0000\u0112\u0114\t\u0000\u0000\u0000\u0113\u0112\u0001\u0000"+
		"\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000"+
		"\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0116\u0120\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u0119\u0005\"\u0000"+
		"\u0000\u0119\u0121\u0006,\u0000\u0000\u011a\u011b\u0005\u0000\u0000\u0001"+
		"\u011b\u0121\u0006,\u0001\u0000\u011c\u011d\u0005\n\u0000\u0000\u011d"+
		"\u011e\u0005 \u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121"+
		"\u0006,\u0002\u0000\u0120\u0118\u0001\u0000\u0000\u0000\u0120\u011a\u0001"+
		"\u0000\u0000\u0000\u0120\u011c\u0001\u0000\u0000\u0000\u0121Z\u0001\u0000"+
		"\u0000\u0000\u0122\u0123\u0005(\u0000\u0000\u0123\u0124\u0005*\u0000\u0000"+
		"\u0124\u0129\u0001\u0000\u0000\u0000\u0125\u0128\u0003[-\u0000\u0126\u0128"+
		"\t\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0126\u0001"+
		"\u0000\u0000\u0000\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u012a\u0001"+
		"\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012c\u0001"+
		"\u0000\u0000\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u012d\u0005"+
		"*\u0000\u0000\u012d\u012e\u0005)\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0006-\u0003\u0000\u0130\\\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0005(\u0000\u0000\u0132\u0133\u0005*\u0000\u0000\u0133\u0138"+
		"\u0001\u0000\u0000\u0000\u0134\u0137\u0003].\u0000\u0135\u0137\t\u0000"+
		"\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0135\u0001\u0000"+
		"\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139\u013f\u0001\u0000"+
		"\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u013c\u0005*\u0000"+
		"\u0000\u013c\u0140\u0005)\u0000\u0000\u013d\u013e\u0005\u0000\u0000\u0001"+
		"\u013e\u0140\u0006.\u0004\u0000\u013f\u013b\u0001\u0000\u0000\u0000\u013f"+
		"\u013d\u0001\u0000\u0000\u0000\u0140^\u0001\u0000\u0000\u0000\u0141\u0142"+
		"\u0005*\u0000\u0000\u0142\u0143\u0005)\u0000\u0000\u0143\u0144\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0006/\u0005\u0000\u0145`\u0001\u0000\u0000\u0000"+
		"\u0146\u0147\u0005-\u0000\u0000\u0147\u0148\u0005-\u0000\u0000\u0148\u014c"+
		"\u0001\u0000\u0000\u0000\u0149\u014b\t\u0000\u0000\u0000\u014a\u0149\u0001"+
		"\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000\u014c\u014d\u0001"+
		"\u0000\u0000\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u014f\u0001"+
		"\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014f\u0150\u0005"+
		"\n\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u00060"+
		"\u0003\u0000\u0152b\u0001\u0000\u0000\u0000\u0153\u0155\u0007\u0005\u0000"+
		"\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000"+
		"\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u0159\u00061\u0003\u0000"+
		"\u0159d\u0001\u0000\u0000\u0000\u015a\u015b\t\u0000\u0000\u0000\u015b"+
		"\u015c\u00062\u0006\u0000\u015cf\u0001\u0000\u0000\u0000\u0011\u0000\u007f"+
		"\u00cb\u00ce\u00da\u00dc\u00e3\u00e5\u0115\u0120\u0127\u0129\u0136\u0138"+
		"\u013f\u014c\u0156\u0007\u0001,\u0000\u0001,\u0001\u0001,\u0002\u0006"+
		"\u0000\u0000\u0001.\u0003\u0001/\u0004\u00012\u0005";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}