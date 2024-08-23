package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class While extends Expression{

    SimpleExpression whileCond;
    Expression loopBody;

    public SimpleExpression getWhileCond(){
        return whileCond;
    }

    public Expression getLoopBody(){
        return loopBody;
    }

    public While(SimpleExpression whileCond, Expression loopBody, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.whileCond = whileCond;
        this.loopBody = loopBody;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
