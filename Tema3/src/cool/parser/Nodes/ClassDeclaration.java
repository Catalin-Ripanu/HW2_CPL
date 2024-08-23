package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class ClassDeclaration extends ASTNode {
    Type type;
    Type inheritedClass;

    List<ASTNode> attributesAndFunctions;

    public Type getType(){
        return type;
    }

    public Type getInheritedClass(){
        return inheritedClass;
    }

    public List<ASTNode> getAttributesAndFunctions(){ return attributesAndFunctions; }

    public ClassDeclaration(Type type, Type inheritedClass, List<ASTNode> attributesAndFunctions, Token start, ParserRuleContext ctx) {
        super(start,ctx);
        this.attributesAndFunctions = attributesAndFunctions;
        this.type = type;
        this.inheritedClass = inheritedClass;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}


