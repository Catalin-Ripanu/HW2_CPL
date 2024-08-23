package cool.parser.Nodes;

import cool.structures.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class If extends SimpleExpression{
    SimpleExpression ifCond;
    Expression thenBody;
    Expression elseBody;

    // Este necesar sa cunoastem scope-ul in care se afla if

    // Is it necessary to gain knowledge about the scope the 'if' instruction is in.

    private Scope scope;

    public SimpleExpression getIfCond(){
        return ifCond;
    }

    public Expression getThenBody(){
        return thenBody;
    }

    public Expression getElseBody(){
        return elseBody;
    }

    public Scope getScope() { return scope; }

    public void setScope(Scope scope) { this.scope = scope; }

    public If(SimpleExpression ifCond, Expression thenBody, Expression elseBody, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.ifCond = ifCond;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
