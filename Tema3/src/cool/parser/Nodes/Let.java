package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Let extends Expression{
    List<Local> localList;
    Expression expression;

    public Expression getExpression() {
        return expression;
    }

    public List<Local> getLocalList() {
        return localList;
    }

    public Let(List<Local> localList, Expression expression, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.expression = expression;
        this.localList = localList;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
