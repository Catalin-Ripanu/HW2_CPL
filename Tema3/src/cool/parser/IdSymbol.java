package cool.parser;

import cool.parser.Nodes.Type;
import cool.structures.Symbol;

public class IdSymbol extends Symbol {
    // Fiecare identificator posedă un tip.
    protected Type type;

    protected Integer offset = 0;

    protected Boolean attributeForClass = false;

    public IdSymbol(String name) {
        super(name);
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public Type getType() {
        return type;
    }


    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setAttributeForClass(Boolean attributeForClass) {
        this.attributeForClass = attributeForClass;
    }

    public Boolean getAttributeForClass() {
        return this.attributeForClass;
    }
}