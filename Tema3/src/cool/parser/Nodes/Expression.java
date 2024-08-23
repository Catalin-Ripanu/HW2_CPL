package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public abstract class Expression extends ASTNode {
    Expression(Token start, ParserRuleContext ctx) {
        super(start, ctx);
    }
}
