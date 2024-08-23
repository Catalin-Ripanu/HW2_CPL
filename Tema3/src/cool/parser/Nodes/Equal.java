package cool.parser.Nodes;

import cool.structures.Scope;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class Equal extends SimpleExpression {
    SimpleExpression left;
    SimpleExpression right;
    Token operation;
    Scope scope;

    public SimpleExpression getLeft(){
        return left;
    }

    public SimpleExpression getRight(){
        return right;
    }

    public Token getOperation() {
        return operation;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public Equal(SimpleExpression left, SimpleExpression right, Token operation, Token op, ParserRuleContext ctx) {
        super(op, ctx);
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
