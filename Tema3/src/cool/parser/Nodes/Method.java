package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Method extends ASTNode {
    Id id;
    Type type;
    List<Formal> formalList;
    List<Expression> expressionList;

    public Id getId(){
        return id;
    }

    public Type getType() {
        return type;
    }

    public List<Formal> getFormalList() {
        return formalList;
    }

    public List<Expression> getExpressionList() {
        return expressionList;
    }

    public Method(Id id, Type type, List<Formal> formalList, List<Expression> expressionList, Token token, ParserRuleContext ctx) {
        super(token, ctx);
        this.id = id;
        this.type = type;
        this.formalList = formalList;
        this.expressionList = expressionList;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
