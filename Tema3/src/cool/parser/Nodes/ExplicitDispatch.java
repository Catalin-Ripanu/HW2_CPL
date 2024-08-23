package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class ExplicitDispatch extends SimpleExpression {
    SimpleExpression expression;
    AtType atType;
    Id id;
    List<SimpleExpression> arguments;
    String callerType;

    public SimpleExpression getExpression() { return expression; }

    public Id getId() { return id; }

    public AtType getAtType() {
        return atType;
    }

    public List<SimpleExpression> getArguments(){
        return arguments;
    }

    public ExplicitDispatch(SimpleExpression expression, Id id, AtType atType, List<SimpleExpression> arguments, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.expression = expression;
        this.id = id;
        this.atType = atType;
        this.arguments = arguments;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void setCallerType(String callerType) {
        this.callerType = callerType;
    }

    public String getCallerType() {
        return callerType;
    }
}
