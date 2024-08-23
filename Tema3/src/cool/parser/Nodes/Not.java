package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Not extends SimpleExpression {
    SimpleExpression expression;

    public SimpleExpression getExpression(){
        return expression;
    }

    public Not(SimpleExpression expression, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.expression = expression;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
