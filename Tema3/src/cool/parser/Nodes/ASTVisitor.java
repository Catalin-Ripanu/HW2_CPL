package cool.parser.Nodes;

import org.antlr.v4.runtime.Token;

public interface ASTVisitor<T> {
    T visit(ClassDeclaration aClass);
    T visit(Prog programS);
    T visit(Attribute variableDeclaration);
    T visit(Formal formal);
    T visit(Method method);
    T visit(AssignWithoutDeclare assignWithoutDeclare);
    T visit(Type type);
    T visit(Id id);
    T visit(Bool bool);
    T visit(Int anInt);
    T visit(Stringg stringg);
    T visit(Plus plus);
    T visit(Minus minus);
    T visit(Mult mult);
    T visit(Div div);
    T visit(NotSymb notSymb);
    T visit(Equal equal);
    T visit(LessThan lessThan);
    T visit(LessEqual lessEqual);
    T visit(Not not);
    T visit(IsVoid isVoid);
    T visit(New aNew);
    T visit(Block block);
    T visit(If anIf);
    T visit(While aWhile);
    T visit(Case aCase);
    T visit(CaseBranch caseBranch);
    T visit(AtType atType);
    T visit(ExplicitDispatch explicitDispatch);
    T visit(ImplicitDispatch implicitDispatch);
    T visit(Local local);
    T visit(Let let);

    public static void error(Token token, String message) {
        System.err.println("line " + token.getLine()
                + ":" + (token.getCharPositionInLine() + 1)
                + ", " + message);
    }
}
