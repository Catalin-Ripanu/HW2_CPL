package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class AssignWithoutDeclare extends Expression {
    Id id;
    Expression expression;

    public Id getId() {
        return id;
    }

    public Expression getExpression() {
        return expression;
    }

    public AssignWithoutDeclare(Id id, Expression expression, Token start, ParserRuleContext ctx) {
        super(start, ctx);
        this.id = id;
        this.expression = expression;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
