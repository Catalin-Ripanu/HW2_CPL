package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

// The root of classes hierarchy representing the nodes of Abstract Syntax Tree (AST).
// The single method accepts one visitor.

public abstract class ASTNode {
    // Store a descriptive token in order to be able to show information later
    // regarding the line and the column of the occurred semantic errors.

    Token token;
    ParserRuleContext ctx;

    public Token getToken() {return token;}
    public ParserRuleContext getCtx() {return ctx;}
    ASTNode(Token token, ParserRuleContext ctx) {
        this.token = token;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}


