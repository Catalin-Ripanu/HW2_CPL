package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public abstract class Arithmetic extends BinaryOperation {
    public Arithmetic(Token token, ParserRuleContext ctx) {
        super(token, ctx);
    }
}
