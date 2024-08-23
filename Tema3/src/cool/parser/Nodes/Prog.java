package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Prog extends ASTNode {
    List<ClassDeclaration> classDeclarationList;

    public List<ClassDeclaration> getClassDeclarationList(){
        return classDeclarationList;
    }

    public Prog(List<ClassDeclaration> classDeclarationList, Token start, ParserRuleContext ctx) {
        super(start, ctx);
        this.classDeclarationList = classDeclarationList;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
