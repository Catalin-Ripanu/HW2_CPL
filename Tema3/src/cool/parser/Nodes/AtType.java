package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class AtType extends SimpleExpression {
    Type type;

    public Type getType(){
        return type;
    }

    public AtType(Type type, Token op, ParserRuleContext ctx) {
        super(op,ctx);
        this.type = type;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
