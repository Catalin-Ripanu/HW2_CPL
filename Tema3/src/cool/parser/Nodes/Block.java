package cool.parser.Nodes;

import cool.parser.IdSymbol;
import cool.structures.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Block extends Expression{
    List<Expression> expressions;

    // A block of expressions has its own scope.
    private IdSymbol symbol;
    private Scope scope;

    public List<Expression> getExpressions(){
        return expressions;
    }

    public Block(List<Expression> expressions, Token start, ParserRuleContext ctx) {
        super(start,ctx);
        this.expressions = expressions;
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
