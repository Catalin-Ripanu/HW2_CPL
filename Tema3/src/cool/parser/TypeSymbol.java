package cool.parser;

import cool.structures.Scope;
import cool.structures.Symbol;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TypeSymbol extends IdSymbol implements Scope {

    protected Map<String, Symbol> symbols = new LinkedHashMap<>();
    protected Map<String, Symbol> symbolsMethods = new LinkedHashMap<>();
    private Scope parent;
    private String parentClass;
    private String actualType;
    private Boolean fixedType;

    private Integer id;

    private Integer index;

    public TypeSymbol(Scope parent, String name) {
        super(name);
        this.parent = parent;
        this.fixedType = true;
    }

    public TypeSymbol(TypeSymbol copy, String actualType, Boolean fixedType) {
        super(copy.name);
        this.parent = copy.parent;
        this.symbols = copy.symbols;
        this.symbolsMethods = copy.symbolsMethods;
        this.parentClass = copy.parentClass;
        this.actualType = (actualType != null) ? actualType : copy.actualType;
        this.fixedType = fixedType;
    }

    @Override
    public boolean add(Symbol sym) {
        // Ne asigurăm că simbolul nu există deja în domeniul de vizibilitate curent.
        if (symbols.containsKey(sym.getName()))
            return false;

        symbols.put(sym.getName(), sym);

        return true;
    }

    public boolean addMethod(Symbol sym) {
        // Ne asigurăm că simbolul nu există deja în domeniul de vizibilitate curent.
        if (symbolsMethods.containsKey(sym.getName()))
            return false;

        symbolsMethods.put(sym.getName(), sym);

        return true;
    }

    @Override
    public Symbol lookup(String s) {
        var sym = symbols.get(s);

        if (sym != null)
            return sym;

        // Dacă nu găsim simbolul în domeniul de vizibilitate curent, îl căutăm
        // în domeniul de deasupra.
        if (parent != null)
            return parent.lookup(s);

        return null;
    }

    public Symbol lookupMethods(String s) {
        var sym = symbolsMethods.get(s);

        if (sym != null)
            return sym;

        // Dacă nu găsim simbolul în domeniul de vizibilitate curent, îl căutăm
        // în domeniul de deasupra. (daca e tot clasa)
        if (parent != null && parent.getClass().equals(TypeSymbol.class))
            return ((TypeSymbol)parent).lookupMethods(s);

        return null;
    }

    @Override
    public Scope getParent() {
        return parent;
    }

    public void setParent(Scope parent){
        this.parent = parent;
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getParentClass() {
        return parentClass;
    }

    public String getActualType() {
        return actualType;
    }

    public Boolean getFixedType() {
        return fixedType;
    }

    public Map<String, Symbol> getSymbolsMethods() {
        return symbolsMethods;
    }

    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

    public int getAllSymbolsSize() {
        // Dacă nu găsim simbolul în domeniul de vizibilitate curent, îl căutăm
        // în domeniul de deasupra. (daca e tot clasa)
        if (parent != null && parent.getClass().equals(TypeSymbol.class))
            return ((TypeSymbol)parent).getAllSymbolsSize()+getSymbols().size();
        return getSymbols().size();
    }

    public HashSet<String> getAllMethodsSymbolsSize() {
        Set<String> currentMethods = getSymbolsMethods().keySet();
        HashSet<String> hashSet = new HashSet<>(currentMethods);
        if (parent != null && parent.getClass().equals(TypeSymbol.class))
            hashSet.addAll(((TypeSymbol)parent).getAllMethodsSymbolsSize());
        return hashSet;
    }
}
