package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Div extends Arithmetic {

    public Div(SimpleExpression left, SimpleExpression right, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.left = left;
        this.right = right;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}