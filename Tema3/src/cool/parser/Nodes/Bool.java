package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Bool extends SimpleExpression {
    public Bool(Token token, ParserRuleContext ctx) {
        super(token, ctx);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
