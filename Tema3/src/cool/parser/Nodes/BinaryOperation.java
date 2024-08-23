package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public abstract class BinaryOperation extends SimpleExpression{
    SimpleExpression left;
    SimpleExpression right;

    public SimpleExpression getLeft(){
        return left;
    }

    public SimpleExpression getRight(){
        return right;
    }

    public BinaryOperation(Token token, ParserRuleContext ctx) {
        super(token, ctx);
    }
}
