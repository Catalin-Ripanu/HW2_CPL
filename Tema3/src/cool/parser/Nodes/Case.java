package cool.parser.Nodes;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class Case extends Expression{
    Id id;
    List<CaseBranch> caseBranchList;

    public Id getId() {
        return id;
    }

    public List<CaseBranch> getCaseBranchList() {
        return caseBranchList;
    }

    public Case(Id id, List<CaseBranch> caseBranchList, Token start, ParserRuleContext ctx){
        super(start, ctx);
        this.id = id;
        this.caseBranchList = caseBranchList;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
