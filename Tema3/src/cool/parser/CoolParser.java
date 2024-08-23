// Generated from D:/Tema3/src/cool/parser/CoolParser.g4 by ANTLR 4.13.1

    package cool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CoolParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_classDeclaration = 1, RULE_attribute = 2, RULE_method = 3, 
		RULE_formal = 4, RULE_simpleExpression = 5, RULE_expression = 6, RULE_caseBranch = 7, 
		RULE_atType = 8, RULE_local = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDeclaration", "attribute", "method", "formal", "simpleExpression", 
			"expression", "caseBranch", "atType", "local"
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

	@Override
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(20);
				classDeclaration();
				setState(21);
				match(SEMI);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public Token type;
		public Token inherited_class;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(CLASS);
			setState(31);
			((ClassDeclarationContext)_localctx).type = match(TYPE);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(32);
				match(INHERITS);
				setState(33);
				((ClassDeclarationContext)_localctx).inherited_class = match(TYPE);
				}
			}

			setState(36);
			match(LBRACE);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(39);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(37);
					attribute();
					}
					break;
				case 2:
					{
					setState(38);
					method();
					}
					break;
				}
				setState(41);
				match(SEMI);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public SimpleExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((AttributeContext)_localctx).id = match(ID);
			setState(51);
			match(COLON);
			setState(52);
			((AttributeContext)_localctx).type = match(TYPE);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(53);
				match(ASSIGN);
				setState(54);
				((AttributeContext)_localctx).expr = simpleExpression(0);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((MethodContext)_localctx).id = match(ID);
			setState(58);
			match(LPAREN);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(59);
						formal();
						setState(60);
						match(COMMA);
						}
						} 
					}
					setState(66);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(67);
				formal();
				}
			}

			setState(70);
			match(RPAREN);
			setState(71);
			match(COLON);
			setState(72);
			((MethodContext)_localctx).type = match(TYPE);
			setState(73);
			match(LBRACE);
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(74);
				expression();
				}
				break;
			case 2:
				{
				{
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2221574529784L) != 0)) {
					{
					{
					setState(75);
					expression();
					setState(76);
					match(SEMI);
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			}
			setState(85);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FormalContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			((FormalContext)_localctx).id = match(ID);
			setState(88);
			match(COLON);
			setState(89);
			((FormalContext)_localctx).type = match(TYPE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleExpressionContext extends ParserRuleContext {
		public SimpleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleExpression; }
	 
		public SimpleExpressionContext() { }
		public void copyFrom(SimpleExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewContext extends SimpleExpressionContext {
		public Token type;
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public NewContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusMinusContext extends SimpleExpressionContext {
		public SimpleExpressionContext left;
		public Token op;
		public SimpleExpressionContext right;
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public PlusMinusContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitPlusMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitPlusMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends SimpleExpressionContext {
		public TerminalNode BOOL() { return getToken(CoolParser.BOOL, 0); }
		public BoolContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends SimpleExpressionContext {
		public TerminalNode STRING() { return getToken(CoolParser.STRING, 0); }
		public StringContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImplicitDispatchContext extends SimpleExpressionContext {
		public Token id;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ImplicitDispatchContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterImplicitDispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitImplicitDispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitImplicitDispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends SimpleExpressionContext {
		public TerminalNode INT() { return getToken(CoolParser.INT, 0); }
		public IntContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotSymbContext extends SimpleExpressionContext {
		public SimpleExpressionContext expr;
		public TerminalNode NOTSYMB() { return getToken(CoolParser.NOTSYMB, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public NotSymbContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNotSymb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNotSymb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNotSymb(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenContext extends SimpleExpressionContext {
		public SimpleExpressionContext expr;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public ParenContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends SimpleExpressionContext {
		public SimpleExpressionContext expr;
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public NotContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsVoidContext extends SimpleExpressionContext {
		public SimpleExpressionContext expr;
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public IsVoidContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIsVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIsVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIsVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultDivContext extends SimpleExpressionContext {
		public SimpleExpressionContext left;
		public Token op;
		public SimpleExpressionContext right;
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(CoolParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(CoolParser.DIV, 0); }
		public MultDivContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitDispatchContext extends SimpleExpressionContext {
		public SimpleExpressionContext expr;
		public AtTypeContext atT;
		public Token id;
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public AtTypeContext atType() {
			return getRuleContext(AtTypeContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ExplicitDispatchContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterExplicitDispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitExplicitDispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExplicitDispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends SimpleExpressionContext {
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public IdContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends SimpleExpressionContext {
		public SimpleExpressionContext ifCond;
		public ExpressionContext thenBody;
		public ExpressionContext elseBody;
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparareContext extends SimpleExpressionContext {
		public SimpleExpressionContext left;
		public Token op;
		public SimpleExpressionContext right;
		public List<SimpleExpressionContext> simpleExpression() {
			return getRuleContexts(SimpleExpressionContext.class);
		}
		public SimpleExpressionContext simpleExpression(int i) {
			return getRuleContext(SimpleExpressionContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CoolParser.EQUAL, 0); }
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public ComparareContext(SimpleExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterComparare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitComparare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitComparare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleExpressionContext simpleExpression() throws RecognitionException {
		return simpleExpression(0);
	}

	private SimpleExpressionContext simpleExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SimpleExpressionContext _localctx = new SimpleExpressionContext(_ctx, _parentState);
		SimpleExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_simpleExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ImplicitDispatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(92);
				((ImplicitDispatchContext)_localctx).id = match(ID);
				setState(93);
				match(LPAREN);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2204394586744L) != 0)) {
					{
					setState(99);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(94);
							simpleExpression(0);
							setState(95);
							match(COMMA);
							}
							} 
						}
						setState(101);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					}
					setState(102);
					simpleExpression(0);
					}
				}

				setState(105);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotSymbContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(NOTSYMB);
				setState(107);
				((NotSymbContext)_localctx).expr = simpleExpression(13);
				}
				break;
			case 3:
				{
				_localctx = new IsVoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(ISVOID);
				setState(109);
				((IsVoidContext)_localctx).expr = simpleExpression(12);
				}
				break;
			case 4:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(NEW);
				setState(111);
				((NewContext)_localctx).type = match(TYPE);
				}
				break;
			case 5:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				match(IF);
				setState(113);
				((IfContext)_localctx).ifCond = simpleExpression(0);
				setState(114);
				match(THEN);
				setState(115);
				((IfContext)_localctx).thenBody = expression();
				setState(116);
				match(ELSE);
				setState(117);
				((IfContext)_localctx).elseBody = expression();
				setState(118);
				match(FI);
				}
				break;
			case 6:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				match(LPAREN);
				setState(121);
				((ParenContext)_localctx).expr = simpleExpression(0);
				setState(122);
				match(RPAREN);
				}
				break;
			case 7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(NOT);
				setState(125);
				((NotContext)_localctx).expr = simpleExpression(5);
				}
				break;
			case 8:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(INT);
				}
				break;
			case 10:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivContext(new SimpleExpressionContext(_parentctx, _parentState));
						((MultDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(132);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(133);
						((MultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
							((MultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(134);
						((MultDivContext)_localctx).right = simpleExpression(10);
						}
						break;
					case 2:
						{
						_localctx = new PlusMinusContext(new SimpleExpressionContext(_parentctx, _parentState));
						((PlusMinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(135);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(136);
						((PlusMinusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((PlusMinusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(137);
						((PlusMinusContext)_localctx).right = simpleExpression(9);
						}
						break;
					case 3:
						{
						_localctx = new ComparareContext(new SimpleExpressionContext(_parentctx, _parentState));
						((ComparareContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(138);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(139);
						((ComparareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
							((ComparareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(140);
						((ComparareContext)_localctx).right = simpleExpression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExplicitDispatchContext(new SimpleExpressionContext(_parentctx, _parentState));
						((ExplicitDispatchContext)_localctx).expr = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_simpleExpression);
						setState(141);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(143);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DISPATCH) {
							{
							setState(142);
							((ExplicitDispatchContext)_localctx).atT = atType();
							}
						}

						setState(145);
						match(DOT);
						setState(146);
						((ExplicitDispatchContext)_localctx).id = match(ID);
						setState(147);
						match(LPAREN);
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2204394586744L) != 0)) {
							{
							setState(153);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(148);
									simpleExpression(0);
									setState(149);
									match(COMMA);
									}
									} 
								}
								setState(155);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
							}
							setState(156);
							simpleExpression(0);
							}
						}

						setState(159);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclareContext extends ExpressionContext {
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public DeclareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignWithoutDeclareContext extends ExpressionContext {
		public Token id;
		public ExpressionContext expr;
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignWithoutDeclareContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAssignWithoutDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAssignWithoutDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAssignWithoutDeclare(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ExpressionContext {
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public BlockContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LetContext extends ExpressionContext {
		public ExpressionContext body;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<LocalContext> local() {
			return getRuleContexts(LocalContext.class);
		}
		public LocalContext local(int i) {
			return getRuleContext(LocalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public LetContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends ExpressionContext {
		public SimpleExpressionContext whileCond;
		public ExpressionContext loopBody;
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public SimpleExpressionContext simpleExpression() {
			return getRuleContext(SimpleExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ExpressionContext {
		public Token id;
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public List<CaseBranchContext> caseBranch() {
			return getRuleContexts(CaseBranchContext.class);
		}
		public CaseBranchContext caseBranch(int i) {
			return getRuleContext(CaseBranchContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public CaseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			int _alt;
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new AssignWithoutDeclareContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				((AssignWithoutDeclareContext)_localctx).id = match(ID);
				setState(166);
				match(ASSIGN);
				setState(167);
				((AssignWithoutDeclareContext)_localctx).expr = expression();
				}
				break;
			case 2:
				_localctx = new DeclareContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				simpleExpression(0);
				}
				break;
			case 3:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(LBRACE);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(170);
					expression();
					}
					break;
				case 2:
					{
					{
					setState(176);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2221574529784L) != 0)) {
						{
						{
						setState(171);
						expression();
						setState(172);
						match(SEMI);
						}
						}
						setState(178);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					break;
				}
				setState(181);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182);
				match(WHILE);
				setState(183);
				((WhileContext)_localctx).whileCond = simpleExpression(0);
				setState(184);
				match(LOOP);
				setState(185);
				((WhileContext)_localctx).loopBody = expression();
				setState(186);
				match(POOL);
				}
				break;
			case 5:
				_localctx = new LetContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LPAREN:
					{
					{
					setState(188);
					match(LPAREN);
					setState(189);
					match(LET);
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(195);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(190);
								local();
								setState(191);
								match(COMMA);
								}
								} 
							}
							setState(197);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						}
						setState(198);
						local();
						}
					}

					setState(201);
					match(IN);
					setState(202);
					((LetContext)_localctx).body = expression();
					setState(203);
					match(RPAREN);
					}
					}
					break;
				case LET:
					{
					{
					setState(205);
					match(LET);
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(211);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(206);
								local();
								setState(207);
								match(COMMA);
								}
								} 
							}
							setState(213);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
						}
						setState(214);
						local();
						}
					}

					setState(217);
					match(IN);
					setState(218);
					((LetContext)_localctx).body = expression();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 6:
				_localctx = new CaseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(221);
				match(CASE);
				setState(222);
				((CaseContext)_localctx).id = match(ID);
				setState(223);
				match(OF);
				setState(227); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(224);
					caseBranch();
					setState(225);
					match(SEMI);
					}
					}
					setState(229); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(231);
				match(ESAC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBranchContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public ExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode RESULT() { return getToken(CoolParser.RESULT, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CaseBranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBranch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCaseBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCaseBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCaseBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseBranchContext caseBranch() throws RecognitionException {
		CaseBranchContext _localctx = new CaseBranchContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_caseBranch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			((CaseBranchContext)_localctx).id = match(ID);
			setState(236);
			match(COLON);
			setState(237);
			((CaseBranchContext)_localctx).type = match(TYPE);
			setState(238);
			match(RESULT);
			setState(239);
			((CaseBranchContext)_localctx).expr = expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtTypeContext extends ParserRuleContext {
		public Token type;
		public TerminalNode DISPATCH() { return getToken(CoolParser.DISPATCH, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public AtTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAtType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAtType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAtType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtTypeContext atType() throws RecognitionException {
		AtTypeContext _localctx = new AtTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(DISPATCH);
			setState(242);
			((AtTypeContext)_localctx).type = match(TYPE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LocalContext extends ParserRuleContext {
		public Token id;
		public Token type;
		public ExpressionContext expr;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLocal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLocal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLocal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalContext local() throws RecognitionException {
		LocalContext _localctx = new LocalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_local);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			((LocalContext)_localctx).id = match(ID);
			setState(245);
			match(COLON);
			setState(246);
			((LocalContext)_localctx).type = match(TYPE);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(247);
				match(ASSIGN);
				setState(248);
				((LocalContext)_localctx).expr = expression();
				}
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return simpleExpression_sempred((SimpleExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean simpleExpression_sempred(SimpleExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u00fc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"\u0018\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001#\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001,\b\u0001\n\u0001\f\u0001/\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00028\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0003\u0003"+
		"\u0003E\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003O\b\u0003\n\u0003"+
		"\f\u0003R\t\u0003\u0003\u0003T\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005b\b\u0005\n\u0005\f\u0005"+
		"e\t\u0005\u0001\u0005\u0003\u0005h\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0083"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0090\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u0098\b\u0005\n\u0005\f\u0005\u009b\t\u0005"+
		"\u0001\u0005\u0003\u0005\u009e\b\u0005\u0001\u0005\u0005\u0005\u00a1\b"+
		"\u0005\n\u0005\f\u0005\u00a4\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u00af\b\u0006\n\u0006\f\u0006\u00b2\t\u0006\u0003\u0006\u00b4"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00c2\b\u0006\n\u0006\f\u0006\u00c5\t\u0006\u0001\u0006"+
		"\u0003\u0006\u00c8\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00d2\b\u0006"+
		"\n\u0006\f\u0006\u00d5\t\u0006\u0001\u0006\u0003\u0006\u00d8\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u00dc\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00e4\b\u0006\u000b"+
		"\u0006\f\u0006\u00e5\u0001\u0006\u0001\u0006\u0003\u0006\u00ea\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00fa\b\t\u0001\t\u0000\u0001\n\n\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0000\u0003\u0001\u0000\u0019\u001a\u0001\u0000\u0017\u0018"+
		"\u0001\u0000\u001b\u001d\u011b\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"\u001e\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u00069\u0001"+
		"\u0000\u0000\u0000\bW\u0001\u0000\u0000\u0000\n\u0082\u0001\u0000\u0000"+
		"\u0000\f\u00e9\u0001\u0000\u0000\u0000\u000e\u00eb\u0001\u0000\u0000\u0000"+
		"\u0010\u00f1\u0001\u0000\u0000\u0000\u0012\u00f4\u0001\u0000\u0000\u0000"+
		"\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005$\u0000\u0000\u0016"+
		"\u0018\u0001\u0000\u0000\u0000\u0017\u0014\u0001\u0000\u0000\u0000\u0018"+
		"\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000\u0000\u0000\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0000\u0000\u0001\u001d"+
		"\u0001\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f"+
		"\"\u0005\u0014\u0000\u0000 !\u0005\u0002\u0000\u0000!#\u0005\u0014\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0001\u0000"+
		"\u0000\u0000$-\u0005\"\u0000\u0000%(\u0003\u0004\u0002\u0000&(\u0003\u0006"+
		"\u0003\u0000\'%\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000\u0000()\u0001"+
		"\u0000\u0000\u0000)*\u0005$\u0000\u0000*,\u0001\u0000\u0000\u0000+\'\u0001"+
		"\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u000001\u0005#\u0000\u00001\u0003\u0001\u0000\u0000\u000023\u0005\u0015"+
		"\u0000\u000034\u0005%\u0000\u000047\u0005\u0014\u0000\u000056\u0005\u0016"+
		"\u0000\u000068\u0003\n\u0005\u000075\u0001\u0000\u0000\u000078\u0001\u0000"+
		"\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0005\u0015\u0000\u0000"+
		":D\u0005 \u0000\u0000;<\u0003\b\u0004\u0000<=\u0005&\u0000\u0000=?\u0001"+
		"\u0000\u0000\u0000>;\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000CE\u0003\b\u0004\u0000D@\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005!\u0000"+
		"\u0000GH\u0005%\u0000\u0000HI\u0005\u0014\u0000\u0000IS\u0005\"\u0000"+
		"\u0000JT\u0003\f\u0006\u0000KL\u0003\f\u0006\u0000LM\u0005$\u0000\u0000"+
		"MO\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QT\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000SJ\u0001\u0000\u0000\u0000SP\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005#\u0000\u0000V\u0007"+
		"\u0001\u0000\u0000\u0000WX\u0005\u0015\u0000\u0000XY\u0005%\u0000\u0000"+
		"YZ\u0005\u0014\u0000\u0000Z\t\u0001\u0000\u0000\u0000[\\\u0006\u0005\uffff"+
		"\uffff\u0000\\]\u0005\u0015\u0000\u0000]g\u0005 \u0000\u0000^_\u0003\n"+
		"\u0005\u0000_`\u0005&\u0000\u0000`b\u0001\u0000\u0000\u0000a^\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fh\u0003\n\u0005\u0000gc\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hi\u0001\u0000\u0000\u0000i\u0083\u0005!\u0000\u0000jk\u0005\u001e\u0000"+
		"\u0000k\u0083\u0003\n\u0005\rlm\u0005\u0005\u0000\u0000m\u0083\u0003\n"+
		"\u0005\fno\u0005\u0006\u0000\u0000o\u0083\u0005\u0014\u0000\u0000pq\u0005"+
		"\t\u0000\u0000qr\u0003\n\u0005\u0000rs\u0005\n\u0000\u0000st\u0003\f\u0006"+
		"\u0000tu\u0005\u000b\u0000\u0000uv\u0003\f\u0006\u0000vw\u0005\f\u0000"+
		"\u0000w\u0083\u0001\u0000\u0000\u0000xy\u0005 \u0000\u0000yz\u0003\n\u0005"+
		"\u0000z{\u0005!\u0000\u0000{\u0083\u0001\u0000\u0000\u0000|}\u0005\u0004"+
		"\u0000\u0000}\u0083\u0003\n\u0005\u0005~\u0083\u0005\u0015\u0000\u0000"+
		"\u007f\u0083\u0005\u0013\u0000\u0000\u0080\u0083\u0005\u0003\u0000\u0000"+
		"\u0081\u0083\u0005)\u0000\u0000\u0082[\u0001\u0000\u0000\u0000\u0082j"+
		"\u0001\u0000\u0000\u0000\u0082l\u0001\u0000\u0000\u0000\u0082n\u0001\u0000"+
		"\u0000\u0000\u0082p\u0001\u0000\u0000\u0000\u0082x\u0001\u0000\u0000\u0000"+
		"\u0082|\u0001\u0000\u0000\u0000\u0082~\u0001\u0000\u0000\u0000\u0082\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u00a2\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\n\t\u0000\u0000\u0085\u0086\u0007\u0000\u0000\u0000\u0086\u00a1\u0003"+
		"\n\u0005\n\u0087\u0088\n\b\u0000\u0000\u0088\u0089\u0007\u0001\u0000\u0000"+
		"\u0089\u00a1\u0003\n\u0005\t\u008a\u008b\n\u0007\u0000\u0000\u008b\u008c"+
		"\u0007\u0002\u0000\u0000\u008c\u00a1\u0003\n\u0005\b\u008d\u008f\n\u000f"+
		"\u0000\u0000\u008e\u0090\u0003\u0010\b\u0000\u008f\u008e\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0005(\u0000\u0000\u0092\u0093\u0005\u0015\u0000\u0000"+
		"\u0093\u009d\u0005 \u0000\u0000\u0094\u0095\u0003\n\u0005\u0000\u0095"+
		"\u0096\u0005&\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0094"+
		"\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009e"+
		"\u0003\n\u0005\u0000\u009d\u0099\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a1\u0005"+
		"!\u0000\u0000\u00a0\u0084\u0001\u0000\u0000\u0000\u00a0\u0087\u0001\u0000"+
		"\u0000\u0000\u00a0\u008a\u0001\u0000\u0000\u0000\u00a0\u008d\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u000b\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u0015"+
		"\u0000\u0000\u00a6\u00a7\u0005\u0016\u0000\u0000\u00a7\u00ea\u0003\f\u0006"+
		"\u0000\u00a8\u00ea\u0003\n\u0005\u0000\u00a9\u00b3\u0005\"\u0000\u0000"+
		"\u00aa\u00b4\u0003\f\u0006\u0000\u00ab\u00ac\u0003\f\u0006\u0000\u00ac"+
		"\u00ad\u0005$\u0000\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ab"+
		"\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00aa"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u00ea\u0005#\u0000\u0000\u00b6\u00b7\u0005"+
		"\r\u0000\u0000\u00b7\u00b8\u0003\n\u0005\u0000\u00b8\u00b9\u0005\u000e"+
		"\u0000\u0000\u00b9\u00ba\u0003\f\u0006\u0000\u00ba\u00bb\u0005\u000f\u0000"+
		"\u0000\u00bb\u00ea\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005 \u0000\u0000"+
		"\u00bd\u00c7\u0005\u0007\u0000\u0000\u00be\u00bf\u0003\u0012\t\u0000\u00bf"+
		"\u00c0\u0005&\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00be"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c6"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c8"+
		"\u0003\u0012\t\u0000\u00c7\u00c3\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005"+
		"\b\u0000\u0000\u00ca\u00cb\u0003\f\u0006\u0000\u00cb\u00cc\u0005!\u0000"+
		"\u0000\u00cc\u00dc\u0001\u0000\u0000\u0000\u00cd\u00d7\u0005\u0007\u0000"+
		"\u0000\u00ce\u00cf\u0003\u0012\t\u0000\u00cf\u00d0\u0005&\u0000\u0000"+
		"\u00d0\u00d2\u0001\u0000\u0000\u0000\u00d1\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d8\u0003\u0012\t\u0000\u00d7"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\b\u0000\u0000\u00da\u00dc"+
		"\u0003\f\u0006\u0000\u00db\u00bc\u0001\u0000\u0000\u0000\u00db\u00cd\u0001"+
		"\u0000\u0000\u0000\u00dc\u00ea\u0001\u0000\u0000\u0000\u00dd\u00de\u0005"+
		"\u0010\u0000\u0000\u00de\u00df\u0005\u0015\u0000\u0000\u00df\u00e3\u0005"+
		"\u0011\u0000\u0000\u00e0\u00e1\u0003\u000e\u0007\u0000\u00e1\u00e2\u0005"+
		"$\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0005\u0012\u0000\u0000\u00e8\u00ea\u0001\u0000"+
		"\u0000\u0000\u00e9\u00a5\u0001\u0000\u0000\u0000\u00e9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00e9\u00a9\u0001\u0000\u0000\u0000\u00e9\u00b6\u0001\u0000"+
		"\u0000\u0000\u00e9\u00db\u0001\u0000\u0000\u0000\u00e9\u00dd\u0001\u0000"+
		"\u0000\u0000\u00ea\r\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0015\u0000"+
		"\u0000\u00ec\u00ed\u0005%\u0000\u0000\u00ed\u00ee\u0005\u0014\u0000\u0000"+
		"\u00ee\u00ef\u0005\u001f\u0000\u0000\u00ef\u00f0\u0003\f\u0006\u0000\u00f0"+
		"\u000f\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\'\u0000\u0000\u00f2\u00f3"+
		"\u0005\u0014\u0000\u0000\u00f3\u0011\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0005\u0015\u0000\u0000\u00f5\u00f6\u0005%\u0000\u0000\u00f6\u00f9\u0005"+
		"\u0014\u0000\u0000\u00f7\u00f8\u0005\u0016\u0000\u0000\u00f8\u00fa\u0003"+
		"\f\u0006\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fa\u0013\u0001\u0000\u0000\u0000\u001b\u0019\"\'-7@DP"+
		"Scg\u0082\u008f\u0099\u009d\u00a0\u00a2\u00b0\u00b3\u00c3\u00c7\u00d3"+
		"\u00d7\u00db\u00e5\u00e9\u00f9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}