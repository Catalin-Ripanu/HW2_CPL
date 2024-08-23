package cool.parser.Nodes;

import cool.parser.IdSymbol;
import cool.structures.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Id extends SimpleExpression {
    private IdSymbol symbol;
    private Scope scope;

    public Id(Token token, ParserRuleContext ctx) {
        super(token, ctx);
    }
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }


    public void setSymbol(IdSymbol symbol) {
        this.symbol = symbol;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public IdSymbol getSymbol() {
        return symbol;
    }

    public Scope getScope() {
        return scope;
    }

    public Integer getLine() {
        return token.getLine();
    }
}