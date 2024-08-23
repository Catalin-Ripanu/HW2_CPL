package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class ImplicitDispatch extends SimpleExpression {
    Id id;
    List<SimpleExpression> arguments;
    String callerType;

    public Id getId() {
        return id;
    }

    public void setCallerType(String callerType) {
        this.callerType = callerType;
    }

    public List<SimpleExpression> getArguments(){
        return arguments;
    }

    public String getCallerType() {
        return callerType;
    }

    public ImplicitDispatch(Id id, List<SimpleExpression> arguments, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.id = id;
        this.arguments = arguments;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
