package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Attribute extends ASTNode {
    Id id;
    Type type;
    SimpleExpression simpleExpression;

    public void setType(Type type) { this.type = type;}

    public Id getId() {
        return id;
    }

    public Type getType() { return type; }

    public SimpleExpression getExpression(){ return simpleExpression; }

    public Attribute(Id id, Type type, SimpleExpression simpleExpression, Token start, ParserRuleContext ctx) {
        super(start, ctx);
        this.id = id;
        this.type = type;
        this.simpleExpression = simpleExpression;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
