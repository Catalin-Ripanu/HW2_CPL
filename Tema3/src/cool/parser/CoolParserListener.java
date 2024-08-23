// Generated from D:/Tema3/src/cool/parser/CoolParser.g4 by ANTLR 4.13.1

    package cool.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoolParser}.
 */
public interface CoolParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CoolParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(CoolParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(CoolParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(CoolParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(CoolParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(CoolParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(CoolParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 */
	void enterFormal(CoolParser.FormalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 */
	void exitFormal(CoolParser.FormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNew(CoolParser.NewContext ctx);
	/**
	 * Exit a parse tree produced by the {@code new}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNew(CoolParser.NewContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinus(CoolParser.PlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinus}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinus(CoolParser.PlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBool(CoolParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBool(CoolParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterString(CoolParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitString(CoolParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implicitDispatch}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterImplicitDispatch(CoolParser.ImplicitDispatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implicitDispatch}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitImplicitDispatch(CoolParser.ImplicitDispatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterInt(CoolParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitInt(CoolParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notSymb}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotSymb(CoolParser.NotSymbContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notSymb}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotSymb(CoolParser.NotSymbContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterParen(CoolParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitParen(CoolParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code not}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNot(CoolParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code not}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNot(CoolParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isVoid}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterIsVoid(CoolParser.IsVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isVoid}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitIsVoid(CoolParser.IsVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultDiv(CoolParser.MultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDiv}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultDiv(CoolParser.MultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code explicitDispatch}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterExplicitDispatch(CoolParser.ExplicitDispatchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code explicitDispatch}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitExplicitDispatch(CoolParser.ExplicitDispatchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterId(CoolParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitId(CoolParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterIf(CoolParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitIf(CoolParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparare}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparare(CoolParser.ComparareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparare}
	 * labeled alternative in {@link CoolParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparare(CoolParser.ComparareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignWithoutDeclare}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignWithoutDeclare(CoolParser.AssignWithoutDeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignWithoutDeclare}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignWithoutDeclare(CoolParser.AssignWithoutDeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declare}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDeclare(CoolParser.DeclareContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declare}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDeclare(CoolParser.DeclareContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CoolParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CoolParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWhile(CoolParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWhile(CoolParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code let}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLet(CoolParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code let}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLet(CoolParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code case}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCase(CoolParser.CaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code case}
	 * labeled alternative in {@link CoolParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCase(CoolParser.CaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#caseBranch}.
	 * @param ctx the parse tree
	 */
	void enterCaseBranch(CoolParser.CaseBranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#caseBranch}.
	 * @param ctx the parse tree
	 */
	void exitCaseBranch(CoolParser.CaseBranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#atType}.
	 * @param ctx the parse tree
	 */
	void enterAtType(CoolParser.AtTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#atType}.
	 * @param ctx the parse tree
	 */
	void exitAtType(CoolParser.AtTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#local}.
	 * @param ctx the parse tree
	 */
	void enterLocal(CoolParser.LocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#local}.
	 * @param ctx the parse tree
	 */
	void exitLocal(CoolParser.LocalContext ctx);
}