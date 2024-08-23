package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Formal extends ASTNode{
    Id id;
    Type type;

    public Id getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Formal(Id id, Type type, Token start, ParserRuleContext ctx) {
        super(start, ctx);
        this.id = id;
        this.type = type;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
