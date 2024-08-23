package cool.parser.Nodes;

import cool.parser.IdSymbol;
import cool.structures.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Local extends ASTNode {
    Id id;
    Type type;
    Expression expression;
    private IdSymbol symbol;
    private Scope scope;

    public Id getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Expression getExpression(){
        return expression;
    }
    public Local(Id id, Type type, Expression expression, Token start, ParserRuleContext ctx) {
        super(start, ctx);
        this.id = id;
        this.type = type;
        this.expression = expression;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Scope getScope() {
        return scope;
    }

    public void setSymbol(IdSymbol symbol) {
        this.symbol = symbol;
    }

    public IdSymbol getSymbol() {
        return symbol;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

