package cool.parser;

import cool.parser.Nodes.*;
import cool.structures.DefaultScope;
import cool.structures.Scope;
import cool.structures.SymbolTable;

import java.util.List;

public class DefinitionPassVisitor implements ASTVisitor<Void> {
    private Scope currentScope = null;
    private Boolean foundMain = false;
    private Integer currentLocals = 0;
    private Integer classIndex = 0;

    @Override
    public Void visit(Prog programS) {
        currentScope = new DefaultScope(null);

        // Adaugare clasa Object
        TypeSymbol objectTypeSymbol = new TypeSymbol(currentScope,"Object");
        objectTypeSymbol.setId(classIndex++);
        addObjectMethods(objectTypeSymbol);
        currentScope.add(objectTypeSymbol);

        // Adaugarea restului de clase de baza si a metodelor
        List<String> baseClasses = List.of("IO","Int","String","Bool","SELF_TYPE");
        for (String className : baseClasses)
        {
            TypeSymbol typeSymbol = new TypeSymbol(currentScope,className);
            typeSymbol.setParent(objectTypeSymbol);
            typeSymbol.setParentClass("Object");
            if(!className.equals("SELF_TYPE"))
                typeSymbol.setId(classIndex++);
            switch(className) {
                case "String":
                    addStringMethods(typeSymbol);
                    break;
                case "IO":
                    addIOMethods(typeSymbol);
                    break;
            }
            currentScope.add(typeSymbol);
        }

        // Parcurgere lista de clase
        for (var classDeclaration: programS.getClassDeclarationList())
            if(classDeclaration!=null)
                classDeclaration.accept(this);
        return null;
    }


    @Override
    public Void visit(ClassDeclaration aClass) {

        Boolean inMain = false;

        if(aClass.getType().getToken().getText().equals("Main"))
            inMain = true;

        // Creare symbol si scope nou al clasei
        var type = aClass.getType();
        var symbol = new TypeSymbol(currentScope,type.getToken().getText());
        var defaultScope = currentScope;

        // Class has illegal name SELF_TYPE
        if(aClass.getType().getToken().getText().equals("SELF_TYPE")){
            SymbolTable.error(aClass.getCtx(), aClass.getType().getToken(),"Class has illegal name " + aClass.getType().getToken().getText());
            return null;
        }

        // Class <C> is redefined
        if(!currentScope.add(symbol)) {
            SymbolTable.error(aClass.getCtx(), aClass.getType().getToken(), "Class " + aClass.getType().getToken().getText() + " is redefined");
            return null;
        }

        // Setare simbol parinte (daca a fost gasit pana acum)
        if(aClass.getInheritedClass().getToken()!=null)
        {
            TypeSymbol inheritedClass = (TypeSymbol) currentScope.lookup(aClass.getInheritedClass().getToken().getText());
            if(inheritedClass!=null)
                symbol.setParent(inheritedClass);
        }

        // Setare nume clasa parinte - daca nu are parinte, atunci Object va fi parintele
        if(aClass.getInheritedClass().getToken()!=null)
            symbol.setParentClass(aClass.getInheritedClass().getToken().getText());
        else
            symbol.setParentClass("Object");
        symbol.setId(classIndex++);

        // Setare scope nou si symbol
        currentScope = symbol;
        type.setSymbol(symbol);
        type.setScope(currentScope);

        // Parcurgere atribute si metode
        for (var attributeOrMethod : aClass.getAttributesAndFunctions())
            if(attributeOrMethod!=null)
                attributeOrMethod.accept(this);

        // Verificare existenta main in main
        if(inMain && !foundMain)
        {
            SymbolTable.error(aClass.getCtx(), aClass.getToken(), "No method main in class Main");
            return null;
        }

        // Revenire la scope-ul default
        currentScope = defaultScope;
        return null;
    }

    @Override
    public Void visit(Attribute variableDeclaration) {

        // Creare symbol al variabilei
        var id = variableDeclaration.getId();
        var symbol = new IdSymbol(variableDeclaration.getId().getToken().getText());

        // Obtinere simbol al clasei curente
        TypeSymbol currentClass = (TypeSymbol) currentScope;

        // Class <C> has attribute with illegal name self
        if(variableDeclaration.getId().getToken().getText().equals("self")){
            SymbolTable.error(variableDeclaration.getCtx(), variableDeclaration.getId().getToken(),"Class " + currentClass.getName() + " has attribute with illegal name self");
            return null;
        }

        // Class <C> redefines attribute <a>
        if(!currentScope.add(symbol)) {
            SymbolTable.error(variableDeclaration.getCtx(), variableDeclaration.getId().getToken(), "Class " + currentClass.getName() + " redefines attribute " +  variableDeclaration.getId().getToken().getText());
            return null;
        }

        // Setare tip al simbolului si setare symbol/scope
        symbol.setType(variableDeclaration.getType());
        id.setSymbol(symbol);
        id.setScope(currentScope);

        if(variableDeclaration.getExpression()!=null)
            variableDeclaration.getExpression().accept(this);

        return null;
    }

    @Override
    public Void visit(Method method) {

        // Creare symbol al noului scope
        var id = method.getId();
        var symbol = new MethodSymbol(currentScope,id.getToken().getText());
        symbol.setType(method.getType());

        // Verificare existenta main in Main
        if(((TypeSymbol)currentScope).getName().equals("Main") && method.getId().getToken().getText().equals("main"))
            foundMain = true;

        // Obtinere simbol al clasei curente
        TypeSymbol currentClass = (TypeSymbol) currentScope;

        // Class <C> redefines method <m>
        if(!currentClass.addMethod(symbol)) {
            SymbolTable.error(method.getCtx(), method.getId().getToken(), "Class " + currentClass.getName() + " redefines method " + method.getId().getToken().getText());
            return null;
        }

        // Setare scope si symbol
        id.setSymbol(symbol);
        currentScope = symbol;
        id.setScope(currentScope);

        // Parcurgere parametrii formali
        for (var formal : method.getFormalList())
            if(formal!=null)
                formal.accept(this);

        // Parcurgere corp functie
        for (var bodyExpr : method.getExpressionList())
            if(bodyExpr!=null)
                bodyExpr.accept(this);

        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public Void visit(Formal formal) {

        // Creare symbol
        var id = formal.getId();
        var symbol = new IdSymbol(formal.getId().getToken().getText());

        TypeSymbol currentClass = (TypeSymbol) currentScope.getParent();
        MethodSymbol currentMethod = (MethodSymbol) currentScope;

        // Method <m> of class <C> has formal parameter with illegal name self
        if(formal.getId().getToken().getText().equals("self")){
            SymbolTable.error(formal.getCtx(), formal.getId().getToken(),"Method " + currentMethod.getName() + " of class " + currentClass.getName() + " has formal parameter with illegal name self");
            return null;
        }

        // Method <m> of class <C> has formal parameter <f> with illegal type SELF_TYPE
        if(formal.getType().getToken().getText().equals("SELF_TYPE")){
            SymbolTable.error(formal.getCtx(), formal.getType().getToken(), "Method " + currentMethod.getName() + " of class " + currentClass.getName() + " has formal parameter " + formal.getId().getToken().getText() + " with illegal type SELF_TYPE");
        }

        // Method <m> of class <C> redefines formal parameter <f>
        if(!currentScope.add(symbol)) {
            SymbolTable.error(formal.getCtx(), formal.getId().getToken(), "Method " + currentMethod.getName() + " of class " + currentClass.getName() + " redefines formal parameter " +  formal.getId().getToken().getText());
            return null;
        }

        // Setare tip al parametrului formal
        symbol.setType(formal.getType());

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);
        return null;

    }

    @Override
    public Void visit(AssignWithoutDeclare assignWithoutDeclare) {

        // Creare symbol
        var id = assignWithoutDeclare.getId();
        var symbol = new IdSymbol(id.getToken().getText());

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);

        // Accept id si expresie initializare
        assignWithoutDeclare.getId().accept(this);
        assignWithoutDeclare.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(Id id) {
        var symbol = new IdSymbol(id.getToken().getText());

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);
        return null;
    }

    @Override
    public Void visit(Block block) {
        // Creare symbol al noului scope
        var symbol = new LocalSymbol(currentScope, "block");

        // Setare scope nou si symbol
        currentScope = symbol;
        block.setSymbol(symbol);
        block.setScope(currentScope);

        for (var expression : block.getExpressions())
            if(expression!=null)
                expression.accept(this);

        currentScope = currentScope.getParent();
        return null;
    }

    // AtType si New
    @Override
    public Void visit(AtType atType) {

        // Creare symbol al scope-ului
        var type = atType.getType();
        var symbol = new TypeSymbol(currentScope, atType.getType().getToken().getText());

        // Setare scope si symbol
        type.setSymbol(symbol);
        type.setScope(currentScope);
        return null;
    }

    @Override
    public Void visit(New aNew) {

        // Creare symbol al scope-ului
        var type = aNew.getType();
        var symbol = new TypeSymbol(currentScope, aNew.getType().getToken().getText());

        // Setare scope si symbol
        type.setSymbol(symbol);
        type.setScope(currentScope);
        return null;
    }

    // Explicit si Implicit Dispatch
    @Override
    public Void visit(ExplicitDispatch explicitDispatch) {

        // Creare symbol al scope-ului
        var id = explicitDispatch.getId();
        var symbol = new IdSymbol(id.getToken().getText());

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);

        // Accept AtType si expresia apelanta
        if(explicitDispatch.getAtType()!=null)
            explicitDispatch.getAtType().accept(this);

        explicitDispatch.getExpression().accept(this);

        // Parcurgere parametrii formali
        for (var argument : explicitDispatch.getArguments())
            argument.accept(this);

        return null;
    }

    @Override
    public Void visit(ImplicitDispatch implicitDispatch) {

        // Creare symbol al scope-ului
        var id = implicitDispatch.getId();
        var symbol = new IdSymbol(id.getToken().getText());

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);

        // Parcurgere parametrii formali
        for (var argument : implicitDispatch.getArguments())
            argument.accept(this);

        return null;
    }

    // Case si branch-urile
    @Override
    public Void visit(Case aCase) {

        // Creare symbol al scope-ului
        var id = aCase.getId();
        var symbol = new IdSymbol("case");

        // Setare scope si symbol
        id.setSymbol(symbol);
        id.setScope(currentScope);

        // Parcurgere branch-uri case
        for (var branch : aCase.getCaseBranchList())
            if(branch!=null)
                branch.accept(this);
        return null;
    }

    @Override
    public Void visit(CaseBranch caseBranch) {

        // Creare symbol al noului scope
        var symbol = new LocalSymbol(currentScope, caseBranch.getId().getToken().getText());

        // Case variable has illegal name self
        if(caseBranch.getId().getToken().getText().equals("self"))
        {
            SymbolTable.error(caseBranch.getCtx(), caseBranch.getId().getToken(), "Case variable has illegal name self");
            return null;
        }

        // Case variable <c> has illegal type SELF_TYPE
        if(caseBranch.getType().getToken().getText().equals("SELF_TYPE"))
        {
            SymbolTable.error(caseBranch.getCtx(), caseBranch.getType().getToken(), "Case variable " +caseBranch.getId().getToken().getText() + " has illegal type SELF_TYPE");
            return null;
        }

        // Setare tip al branch-ului + set scope/symbol
        symbol.setType(caseBranch.getType());
        currentScope = symbol;
        caseBranch.setSymbol(symbol);
        caseBranch.setScope(currentScope);

        // Adaugare avariabila in scope
        currentScope.add(symbol);

        // Parcurgere expresie corepunzatoare branch-ului
        caseBranch.getExpression().accept(this);

        currentScope = currentScope.getParent();
        return null;
    }

    // Let si definitiile sale
    @Override
    public Void visit(Let let) {

        // Parcurgere parametrii locali
        for (var local : let.getLocalList())
            if(local!=null)
                local.accept(this);

        // Accept block expresie
        let.getExpression().accept(this);

        // Revenire in scope-ul precedent let-ului
        while (currentLocals > 0) {
            currentScope = currentScope.getParent();
            currentLocals--;
        }

        return null;
    }

    @Override
    public Void visit(Local local) {

        // Creare symbol al noului scope
        var symbol = new LocalSymbol(currentScope, local.getId().getToken().getText());
        symbol.setType(local.getType());

        // Let variable has illegal name self
        if(local.getId().getToken().getText().equals("self"))
        {
            SymbolTable.error(local.getCtx(), local.getId().getToken(), "Let variable has illegal name self");
            return null;
        }

        // Accept expresia de initializare inainte de setarea scope-ului nou
        // Pentru a putea semnala eroare la u <- u + x de exemplu
        if(local.getExpression()!=null)
            local.getExpression().accept(this);

        // Setare scope nou si symbol - si offset local
        currentScope = symbol;
        symbol.setOffset((-4)*(currentLocals+1));
        local.setSymbol(symbol);
        local.setScope(currentScope);

        // Incrementare adancime scope-uri in let + adaugarea variabilei in let
        currentLocals++;
        currentScope.add(symbol);
        return null;
    }

    // While si if
    @Override
    public Void visit(If anIf) {
        anIf.setScope(currentScope);
        anIf.getIfCond().accept(this);
        anIf.getThenBody().accept(this);
        anIf.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(While aWhile) {
        aWhile.getWhileCond().accept(this);
        aWhile.getLoopBody().accept(this);
        return null;
    }

    // Operatii artimetice + new / not / isVoid
    @Override
    public Void visit(Plus plus) {
        plus.getLeft().accept(this);
        plus.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(Minus minus) {
        minus.getLeft().accept(this);
        minus.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(Mult mult) {
        mult.getLeft().accept(this);
        mult.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(Div div) {
        div.getLeft().accept(this);
        div.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(Equal equal) {
        equal.setScope(currentScope);
        equal.getLeft().accept(this);
        equal.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(LessThan lessThan) {
        lessThan.getLeft().accept(this);
        lessThan.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(LessEqual lessEqual) {
        lessEqual.getLeft().accept(this);
        lessEqual.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(Not not) {
        not.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(NotSymb notSymb) {
        notSymb.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(IsVoid isVoid) {
        isVoid.getExpression().accept(this);
        return null;
    }

    // Tipurile de baza
    @Override
    public Void visit(Type type) {
        return null;
    }

    @Override
    public Void visit(Bool bool) {
        return null;
    }

    @Override
    public Void visit(Int anInt) {
        return null;
    }

    @Override
    public Void visit(Stringg stringg) {
        return null;
    }

    // UTILE - Adaugare metode predefinite IO,String,Object
    /*  in object
        abort() - returneaza object
        type_name() - returneaza string
        copy() - returneaza SELF_TYPE

        in io
        out_string("abc") -returenaza io
        out_int(3) - returneaza io
        in_string() - returneaza string
        in_int() - returenaza int

        in string
        length() - returneaza int
        concat("abc") - returneaza string
        substr(4,7) - returneaza string
    */

    // Adaugare metode Object
    private void addObjectMethods(TypeSymbol object) {
        String[] methodNames = {"abort", "type_name", "copy"};
        String[] methodReturnTypes = {"Object", "String", "SELF_TYPE"};

        for (int i = 0; i < methodNames.length; i++) {
            MethodSymbol symbol = new MethodSymbol(currentScope, methodNames[i]);
            symbol.setOffset(i*4);
            symbol.setType(new Type(methodReturnTypes[i]));
            object.addMethod(symbol);
        }
    }

    // Adaugare metode IO
    private void addIOMethods(TypeSymbol typeSymbol) {
        String[] methodNames = {"out_string", "out_int", "in_string", "in_int"};
        String[] methodParamTypes = {"String", "Int"};

        for (int i = 0; i < methodNames.length; i++) {
            MethodSymbol symbol = new MethodSymbol(currentScope, methodNames[i]);
            Type methodType = i < 2 ? new Type("IO") : new Type(methodParamTypes[i-2]);
            symbol.setOffset((3+i)*4);
            symbol.setType(methodType);
            typeSymbol.addMethod(symbol);

            if (i < 2) {
                IdSymbol formalsymbol = new IdSymbol(i == 0 ? "str" : "num");
                formalsymbol.setType(new Type(methodParamTypes[i]));
                symbol.add(formalsymbol);
            }
        }
    }

    // Adaugare metode String
    private void addStringMethods(TypeSymbol typeSymbol) {
        String[] methodNames = {"length", "concat", "substr"};
        String[] methodReturnTypes = {"Int", "String", "String"};
        String[][] formalNames = {{}, {"str"}, {"f", "l"}};
        String[] formalTypes = {"String", "Int", "Int"};

        int index = 0;
        for (int i = 0; i < methodNames.length; i++) {
            String methodName = methodNames[i];
            String returnType = methodReturnTypes[i];

            MethodSymbol symbol = new MethodSymbol(currentScope, methodName);
            symbol.setOffset((3+i)*4);
            symbol.setType(new Type(returnType));
            typeSymbol.addMethod(symbol);

            for (String formalName : formalNames[i]) {
                IdSymbol formalsymbol = new IdSymbol(formalName);
                formalsymbol.setType(new Type(formalTypes[index]));
                symbol.add(formalsymbol);
                index++;
            }
        }
    }
}