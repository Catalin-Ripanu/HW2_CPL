package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public abstract class SimpleExpression extends Expression {
    public SimpleExpression(Token token, ParserRuleContext ctx) {
        super(token,ctx);
    }
}
