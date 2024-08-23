package cool.parser;

import cool.parser.Nodes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ASTConstructionVisitor extends CoolParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(CoolParser.ProgramContext ctx) {

        // The list of class declarations
        List<ClassDeclaration> classDeclarationList = ctx.children.stream()
                .map(c -> (ClassDeclaration) visit(c))
                .collect(Collectors.toList());

        return new Prog(classDeclarationList, ctx.start, ctx);
    }

    @Override
    public ASTNode visitClassDeclaration(CoolParser.ClassDeclarationContext ctx) {

        // The list of attributes and functions
        List<ASTNode> attributesAndFunctions = ctx.children.stream()
                .map(af -> visit(af))
                .collect(Collectors.toList());
        return new ClassDeclaration(new Type(ctx.type, ctx), new Type(ctx.inherited_class, ctx), attributesAndFunctions, ctx.start, ctx);
    }

    @Override
    public ASTNode visitAttribute(CoolParser.AttributeContext ctx) {
        SimpleExpression simpleExpression = null;
        if (ctx.expr != null)
            simpleExpression = (SimpleExpression) ctx.expr.accept(this);
        return new Attribute(new Id(ctx.id, ctx), new Type(ctx.type, ctx), simpleExpression, ctx.start, ctx);
    }

    @Override
    public ASTNode visitMethod(CoolParser.MethodContext ctx) {

        // Create the list of formal parameters
        List<Formal> formalList = ctx.formal() != null ?
                ctx.formal().stream()
                        .map(f -> (Formal) visit(f))
                        .collect(Collectors.toList()) :
                new ArrayList<>();

        // Create the list of expressions of function body
        List<Expression> expressionList = ctx.expression() != null ?
                ctx.expression().stream()
                        .map(e -> (Expression) visit(e))
                        .collect(Collectors.toList()) :
                new ArrayList<>();

        return new Method(new Id(ctx.id, ctx), new Type(ctx.type, ctx), formalList, expressionList, ctx.start, ctx);
    }

    @Override
    public ASTNode visitFormal(CoolParser.FormalContext ctx) {
        return new Formal(new Id(ctx.id, ctx), new Type(ctx.type, ctx), ctx.start, ctx);
    }

    @Override
    public ASTNode visitAssignWithoutDeclare(CoolParser.AssignWithoutDeclareContext ctx) {
        return new AssignWithoutDeclare(new Id(ctx.id, ctx), (Expression) visit(ctx.expr), ctx.start, ctx);
    }

    @Override
    public ASTNode visitInt(CoolParser.IntContext ctx) {
        return new Int(ctx.start, ctx);
    }

    @Override
    public ASTNode visitString(CoolParser.StringContext ctx) {
        return new Stringg(ctx.start, ctx);
    }

    @Override
    public ASTNode visitBool(CoolParser.BoolContext ctx) {
        return new Bool(ctx.start, ctx);
    }

    @Override
    public ASTNode visitId(CoolParser.IdContext ctx) {
        return new Id(ctx.start, ctx);
    }

    @Override
    public ASTNode visitPlusMinus(CoolParser.PlusMinusContext ctx) {
        if (ctx.op.getText().equals("+"))
            return new Plus((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
        return new Minus((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitMultDiv(CoolParser.MultDivContext ctx) {
        if (ctx.op.getText().equals("*"))
            return new Mult((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
        return new Div((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitParen(CoolParser.ParenContext ctx) {
        return ctx.expr.accept(this);
    }

    @Override
    public ASTNode visitNotSymb(CoolParser.NotSymbContext ctx) {
        return new NotSymb((SimpleExpression) ctx.expr.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitComparare(CoolParser.ComparareContext ctx) {
        switch (ctx.op.getText()) {
            case "<":
                return new LessThan((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
            case "<=":
                return new LessEqual((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.start, ctx);
            default:
                return new Equal((SimpleExpression) ctx.left.accept(this), (SimpleExpression) ctx.right.accept(this), ctx.op , ctx.start, ctx);
        }
    }

    @Override
    public ASTNode visitNot(CoolParser.NotContext ctx) {
        return new Not((SimpleExpression) ctx.expr.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitIsVoid(CoolParser.IsVoidContext ctx) {
        return new IsVoid((SimpleExpression) ctx.expr.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitNew(CoolParser.NewContext ctx) {
        return new New(new Type(ctx.type, ctx), ctx.start, ctx);
    }

    @Override
    public ASTNode visitBlock(CoolParser.BlockContext ctx) {

        // Create list of expressions of a block
        List<Expression> expressionList = ctx.children.stream()
                .map(expr -> (Expression) visit(expr))
                .collect(Collectors.toList());

        return new Block(expressionList, ctx.start, ctx);
    }

    @Override
    public ASTNode visitIf(CoolParser.IfContext ctx) {
        return new If((SimpleExpression) ctx.ifCond.accept(this), (Expression) ctx.thenBody.accept(this), (Expression) ctx.elseBody.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitWhile(CoolParser.WhileContext ctx) {
        return new While((SimpleExpression) ctx.whileCond.accept(this), (Expression) ctx.loopBody.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitCase(CoolParser.CaseContext ctx) {

        // Create list of case branches
        List<CaseBranch> caseBranches = ctx.children.stream()
                .map(caseBranch -> (CaseBranch) visit(caseBranch))
                .collect(Collectors.toList());

        return new Case(new Id(ctx.id, ctx), caseBranches, ctx.start, ctx);
    }

    @Override
    public ASTNode visitCaseBranch(CoolParser.CaseBranchContext ctx) {
        return new CaseBranch(new Id(ctx.id, ctx), new Type(ctx.type, ctx), (Expression) ctx.expr.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitAtType(CoolParser.AtTypeContext ctx) {
        return new AtType(new Type(ctx.type, ctx), ctx.start, ctx);
    }

    @Override
    public ASTNode visitImplicitDispatch(CoolParser.ImplicitDispatchContext ctx) {

        // Create list of function arguments expressions
        List<SimpleExpression> expressionList = ctx.simpleExpression().stream()
                .map(se -> (SimpleExpression) visit(se))
                .collect(Collectors.toList());
        return new ImplicitDispatch(new Id(ctx.id, ctx), expressionList, ctx.start, ctx);
    }

    @Override
    public ASTNode visitExplicitDispatch(CoolParser.ExplicitDispatchContext ctx) {

        AtType atType = null;
        if (ctx.atT != null)
            atType = (AtType) ctx.atT.accept(this);

        // Create list of function arguments expressions
        List<SimpleExpression> expressionList = ctx.simpleExpression().stream().skip(1)
                .map(se -> (SimpleExpression) visit(se))
                .collect(Collectors.toList());

        return new ExplicitDispatch((SimpleExpression) ctx.expr.accept(this), new Id(ctx.id, ctx), atType, expressionList, ctx.start, ctx);
    }

    @Override
    public ASTNode visitLet(CoolParser.LetContext ctx) {

        // Create list of let locals
        List<Local> localList = ctx.local().stream()
                .map(local -> (Local) visit(local))
                .collect(Collectors.toList());

        return new Let(localList, (Expression) ctx.body.accept(this), ctx.start, ctx);
    }

    @Override
    public ASTNode visitLocal(CoolParser.LocalContext ctx) {

        Expression expression = null;

        if (ctx.expr != null)
            expression = (Expression) ctx.expr.accept(this);

        return new Local(new Id(ctx.id, ctx), new Type(ctx.type, ctx), expression, ctx.start, ctx);
    }
}
