package cool.parser.Nodes;

import cool.structures.Scope;
import cool.parser.TypeSymbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Type extends SimpleExpression{
    private TypeSymbol symbol;
    private Scope scope;
    private String actualType;

    public Type(Token token, ParserRuleContext ctx) {
        super(token, ctx);
    }

    public Type(String actualType) {
        super(null,null);
        this.actualType = actualType;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public void setSymbol(TypeSymbol symbol) {
        this.symbol = symbol;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public TypeSymbol getSymbol() {
        return symbol;
    }

    public Scope getScope() {
        return scope;
    }

    public String getActualType() {
        return actualType;
    }
}