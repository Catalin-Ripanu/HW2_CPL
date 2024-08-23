package cool.parser;

import cool.parser.Nodes.*;
import cool.structures.DefaultScope;
import cool.structures.Scope;
import cool.structures.SymbolTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResolutionPassVisitor implements ASTVisitor<TypeSymbol> {
    List<String> illegalParents = List.of("Int","String","Bool","SELF_TYPE");;
    List<String> baseClasses = List.of("Int","Bool","String","IO");

    @Override
    public TypeSymbol visit(Prog programS) {

        // Parcurgere clase
        for (var stmt: programS.getClassDeclarationList()) {
            if(stmt!=null)
                stmt.accept(this);
        }
        return null;
    }

    @Override
    public TypeSymbol visit(ClassDeclaration aClass) {
        var scope = aClass.getType().getScope();

        // Class <C> has illegal parent <P>
        if(aClass.getInheritedClass().getToken()!=null && illegalParents.contains(aClass.getInheritedClass().getToken().getText()))
        {
            SymbolTable.error(aClass.getCtx(), aClass.getInheritedClass().getToken(),"Class " + aClass.getType().getToken().getText() +" has illegal parent " + aClass.getInheritedClass().getToken().getText());
            return null;
        }

        // Class <C> has undefined parent <P>
        if (aClass.getInheritedClass().getToken()!=null && scope!=null && scope.getParent().lookup(aClass.getInheritedClass().getToken().getText())==null)
            {
                SymbolTable.error(aClass.getCtx(), aClass.getInheritedClass().getToken(),"Class " + aClass.getType().getToken().getText() + " has undefined parent " + aClass.getInheritedClass().getToken().getText());
                return null;
            }

        // Inheritance cycle for class <C>
        if(aClass.getInheritedClass().getToken()!=null && scope!=null) {

            // Salvare clase prin care am trecut
            List<String> passedClasses = new ArrayList<>();
            passedClasses.add(aClass.getType().getToken().getText());

            TypeSymbol currentClass = (TypeSymbol) scope.lookup(aClass.getInheritedClass().getToken().getText());

            // Parcurgere clase mostenite
            while(currentClass!=null){

                // Detectare ciclu
                if(passedClasses.contains(currentClass.getName())){
                    SymbolTable.error(aClass.getCtx(), aClass.getType().getToken(),"Inheritance cycle for class " + aClass.getType().getToken().getText());
                    return null;
                }
                passedClasses.add(currentClass.getName());
                currentClass = (TypeSymbol) scope.lookup(currentClass.getParentClass());
            }
        }

        // Setare scope parinte dupa ce am stabilit ca nu exista cicluri
        if(aClass.getInheritedClass().getToken()!=null && scope!=null) {
            TypeSymbol currentClass = (TypeSymbol) scope.lookup(aClass.getType().getToken().getText());
            TypeSymbol parentClass = (TypeSymbol) scope.lookup(aClass.getInheritedClass().getToken().getText());
            currentClass.setParent(parentClass);
        }

        if(aClass.getInheritedClass().getToken() == null && scope!=null)
        {
            TypeSymbol currentClass = (TypeSymbol) scope.lookup(aClass.getType().getToken().getText());
            TypeSymbol parentClass = (TypeSymbol) scope.lookup("Object");
            currentClass.setParent(parentClass);
        }

        // Parcurgere atribute si metode
        for (var attributeOrMethod: aClass.getAttributesAndFunctions()) {
            if(attributeOrMethod!=null)
                attributeOrMethod.accept(this);
        }

        return null;
    }

    @Override
    public TypeSymbol visit(Attribute variableDeclaration) {
        var scope = variableDeclaration.getId().getScope();

        if (scope == null || variableDeclaration.getType() == null)
            return null;

        DefaultScope defaultScope = getDefaultScope(scope);
        // Setare tip exact
        String currentType = variableDeclaration.getType().getToken().getText();
        if (currentType.equals("SELF_TYPE"))
            currentType = ((TypeSymbol) scope).getName();

        // Class <C> has attribute <a> with undefined type <T>
        TypeSymbol classScope = (TypeSymbol) scope;
        if (scope.getParent().lookup(variableDeclaration.getType().getToken().getText()) == null) {
            SymbolTable.error(variableDeclaration.getCtx(), variableDeclaration.getType().getToken(), "Class " + classScope.getName() + " has attribute " + variableDeclaration.getId().getToken().getText() + " with undefined type " + variableDeclaration.getType().getToken().getText());
            return null;
        }

        // Class <C> redefines inherited attribute <a>
        if (scope.getParent() != null && scope.getParent().lookup(variableDeclaration.getId().getToken().getText()) != null) {
            SymbolTable.error(variableDeclaration.getCtx(), variableDeclaration.getId().getToken(), "Class " + classScope.getName() + " redefines inherited attribute " + variableDeclaration.getId().getToken().getText());
            return null;
        }

        int pos = new ArrayList<>(classScope.getSymbols().keySet()).indexOf(variableDeclaration.getId().getToken().getText());
        if(classScope.getParentClass()!=null)
        {
            TypeSymbol parentClass = (TypeSymbol) defaultScope.lookup(classScope.getParentClass());
            variableDeclaration.getId().getSymbol().setOffset((3 + parentClass.getAllSymbolsSize() + pos) * 4);
        }
        else
            variableDeclaration.getId().getSymbol().setOffset((3 + pos) * 4);
        variableDeclaration.getId().getSymbol().setAttributeForClass(true);
        if (variableDeclaration.getExpression() != null) {
            TypeSymbol expressionType = variableDeclaration.getExpression().accept(this);
            if (expressionType == null)
                return null;

            TypeSymbol finalType = checkIfParent(defaultScope, expressionType, currentType);

            if (finalType == null) {
                //Type <T1> of initialization expression of attribute <a> is incompatible with declared type <T2>
                SymbolTable.error(variableDeclaration.getCtx(), variableDeclaration.getExpression().getToken(), "Type " + expressionType.getName() + " of initialization expression of attribute " + variableDeclaration.getId().getToken().getText() + " is incompatible with declared type " + variableDeclaration.getType().getToken().getText());
                return null;
            }
        }
        return null;
    }

    @Override
    public TypeSymbol visit(Formal formal) {

        var scope = formal.getId().getScope();

        // Method <m> of class <C> has formal parameter <f> with undefined type <T>
        if(scope!=null) {
            TypeSymbol classScope = (TypeSymbol) scope.getParent();
            MethodSymbol methodScope = (MethodSymbol) scope;
            DefaultScope defaultScope = getDefaultScope(scope);

            int pos = new ArrayList<>(methodScope.getFormals().keySet()).indexOf(formal.getId().getToken().getText());
            formal.getId().getSymbol().setOffset((3 + pos) * 4);

            if(defaultScope.lookup(formal.getType().getToken().getText())==null){
                SymbolTable.error(formal.getCtx(), formal.getType().getToken(), "Method " + methodScope.getName() + " of class " + classScope.getName() + " has formal parameter " +  formal.getId().getToken().getText() + " with undefined type " + formal.getType().getToken().getText());
                return null;
            }
        }

        // Class <C> overrides method <m> but changes type of formal parameter <f> from <T1> to <T2>
        if(scope!=null && scope.getParent()!=null && scope.getParent().getParent().getClass().equals(TypeSymbol.class)) {
            TypeSymbol classScope = (TypeSymbol) scope.getParent();
            TypeSymbol parentClassScope = (TypeSymbol) scope.getParent().getParent();
            MethodSymbol methodScope = (MethodSymbol) scope;
            MethodSymbol parentMethod = (MethodSymbol) parentClassScope.lookupMethods(methodScope.getName());

            if(parentMethod!=null) {
                // Determinare pozitie formal in functie si comparare tip
                int pos = new ArrayList<>(methodScope.getFormals().keySet()).indexOf(formal.getId().getToken().getText());
                formal.getId().getSymbol().setOffset((3 + pos) * 4);
                Set<String> keySet = parentMethod.getFormals().keySet();
                List<String> listKeys = new ArrayList<String>(keySet);
                String key = listKeys.get(pos);
                IdSymbol formalSymbol = (IdSymbol) parentMethod.getFormals().get(key);

                String formalType = null;
                if(formalSymbol.getType().getToken()!=null)
                    formalType = formalSymbol.getType().getToken().getText();
                else
                    formalType = formalSymbol.getType().getActualType();

                if (!formalType.equals(formal.getType().getToken().getText()))
                    SymbolTable.error(formal.getCtx(), formal.getType().getToken(), "Class " + classScope.getName() + " overrides method " + methodScope.getName() + " but changes type of formal parameter " + formal.getId().getToken().getText() + " from " + formalType + " to " + formal.getType().getToken().getText());
            }
        }
        return null;
    }

    @Override
    public TypeSymbol visit(Method method) {
        var scope = method.getId().getScope();

        if(scope==null)
            return null;

        // Class <C> has method <m> with undefined return type <T>
        TypeSymbol classScope = (TypeSymbol) scope.getParent();
        if(classScope.getParent().lookup(method.getType().getToken().getText())==null){
            SymbolTable.error(method.getCtx(), method.getType().getToken(), "Class " + classScope.getName() + " has method " + method.getId().getToken().getText() + " with undefined return type " + method.getType().getToken().getText());
            return null;
        }

        // Verificare override gresit
        if(scope.getParent()!=null && scope.getParent().getParent().getClass().equals(TypeSymbol.class)){
            TypeSymbol parentClassScope = (TypeSymbol) scope.getParent().getParent();
            MethodSymbol parentMethod = (MethodSymbol) parentClassScope.lookupMethods(method.getId().getToken().getText());

            // Class <C> overrides method <m> with different number of formal parameters
            if(parentMethod!=null && parentMethod.getFormals().size()!=method.getFormalList().size()){
                    SymbolTable.error(method.getCtx(), method.getId().getToken(), "Class " + classScope.getName() + " overrides method " + method.getId().getToken().getText() + " with different number of formal parameters");
                    return null;
            }

            String parentMethodType = null;

            if(parentMethod!=null) {
                if(parentMethod.getType().getToken()!=null)
                    parentMethodType = parentMethod.getType().getToken().getText();
                else
                    parentMethodType = parentMethod.getType().getActualType();
            }

            String methodType = method.getType().getToken().getText();
            if(methodType.equals("SELF_TYPE") && parentMethodType!=null)
                methodType = getCommonParent(new TypeSymbol(null,parentMethodType),classScope, getDefaultScope(scope)).getName();

            // Class <C> overrides method <m> but changes return type from <T1> to <T2>
            if(parentMethod!=null && !parentMethodType.equals(methodType)){
                SymbolTable.error(method.getCtx(), method.getType().getToken(), "Class " + classScope.getName() + " overrides method " + method.getId().getToken().getText() + " but changes return type from " + parentMethodType + " to " + methodType);
                return null;
            }
        }

        int pos = new ArrayList<>(classScope.getSymbolsMethods().keySet()).indexOf(method.getId().getToken().getText());
        if(classScope.getParentClass()!=null)
        {
            DefaultScope defaultScope = getDefaultScope(scope);
            TypeSymbol parentClass = (TypeSymbol) defaultScope.lookup(classScope.getParentClass());
            Set<String> keySet =  classScope.getSymbolsMethods().keySet();
            HashSet<String> parentMethods = parentClass.getAllMethodsSymbolsSize();
            for (String methodName : keySet)
            {
                if(pos==0)
                    break;
                parentMethods.add(methodName);
                pos--;
            }
            method.getId().getSymbol().setOffset(parentMethods.size() * 4);
        }
        else
            method.getId().getSymbol().setOffset(pos * 4);
        // Parcurgere lista formali
        for (var formal: method.getFormalList())
            if(formal!=null)
                formal.accept(this);

        // Determinare tip corp functie si tip declarat functie
        TypeSymbol returnBodyType = null;
        Type returnType = method.getType();
        // Parcurgere corp functie
        for (var bodyExpr : method.getExpressionList())
            if(bodyExpr!=null)
                returnBodyType = bodyExpr.accept(this);

        if(returnType==null || returnBodyType == null)
            return null;

        DefaultScope defaultScope = getDefaultScope(scope);

        if(checkIfParent(defaultScope,returnBodyType,returnType.getToken().getText())!=null)
            return null;

        // Verificare exacta pentru cazuri la limita cu SELF_TYPE
        Expression lastExpression = null;
        for (var expr : method.getExpressionList())
        {
            if(expr.getToken()!=null)
                lastExpression = expr;
        }

        // Type <T1> of the body of method <m> is incompatible with declared return type <T2>
        if(method.getType().getToken().getText().equals("SELF_TYPE"))
        {
            TypeSymbol parentClassScope = (TypeSymbol) scope.getParent().getParent();
            MethodSymbol parentMethod = (MethodSymbol) parentClassScope.lookupMethods(method.getId().getToken().getText());

            String parentMethodType = null;

            if(parentMethod!=null) {
                if(parentMethod.getType().getToken()!=null)
                    parentMethodType = parentMethod.getType().getToken().getText();
                else
                    parentMethodType = parentMethod.getType().getActualType();
            }

            TypeSymbol classType = (TypeSymbol) scope.getParent();
            String methodType = method.getType().getToken().getText();
            if(methodType.equals("SELF_TYPE") && parentMethodType!=null)
                methodType = getCommonParent(new TypeSymbol(null,parentMethodType),classScope, getDefaultScope(scope)).getName();

            if(methodType.equals(returnBodyType.getName()) && lastExpression.getToken().getText().equals("self"))
                return null;
        }
        SymbolTable.error(method.getCtx(), method.getExpressionList().get(0).getToken(), "Type " + returnBodyType.getName() + " of the body of method " + method.getId().getToken().getText() + " is incompatible with declared return type " + method.getType().getToken().getText());
        return null;
    }

    @Override
    public TypeSymbol visit(AssignWithoutDeclare assignWithoutDeclare) {

        var scope = assignWithoutDeclare.getId().getScope();

        if(scope==null)
            return null;

        // Cannot assign to self
        if(assignWithoutDeclare.getId().getToken().getText().equals("self")){
            SymbolTable.error(assignWithoutDeclare.getCtx(), assignWithoutDeclare.getId().getToken(), "Cannot assign to self");
            return null;
        }

        TypeSymbol idType = assignWithoutDeclare.getId().accept(this);
        TypeSymbol assignType = assignWithoutDeclare.getExpression().accept(this);

        if(idType==null || assignType == null)
            return null;

        if(scope!=null)
        {
            DefaultScope defaultScope = getDefaultScope(scope);

            if(assignType.getName().equals(idType.getName()))
                return assignType;

            String actualIdType = (idType.getActualType() != null) ? idType.getActualType() : idType.getName();

            //Type <T1> of assigned expression is incompatible with declared type <T2> of identifier <i>
            if(idType.getName().equals("SELF_TYPE") && assignType.getFixedType()) {
                SymbolTable.error(assignWithoutDeclare.getCtx(), assignWithoutDeclare.getExpression().getToken(), "Type " + assignType.getName() + " of assigned expression is incompatible with declared type " + idType.getName() + " of identifier " + assignWithoutDeclare.getId().getToken().getText());
                return null;
            }

            //Type <T1> of assigned expression is incompatible with declared type <T2> of identifier <i>
            if(checkIfParent(defaultScope, assignType, actualIdType)==null)
                SymbolTable.error(assignWithoutDeclare.getCtx(), assignWithoutDeclare.getExpression().getToken(), "Type " + assignType.getName() + " of assigned expression is incompatible with declared type " + idType.getName() + " of identifier " + assignWithoutDeclare.getId().getToken().getText());
        }
        return null;
    }

    // Explicit Dispatch
    @Override
    public TypeSymbol visit(ExplicitDispatch explicitDispatch) {

        TypeSymbol atTypeSymbol = null;
        TypeSymbol expressionTypeSymbol = null;
        TypeSymbol typeToReturn;
        MethodSymbol methodSymbol;

        if(explicitDispatch.getExpression()!=null)
            expressionTypeSymbol = explicitDispatch.getExpression().accept(this);

        if(expressionTypeSymbol.getName().equals("SELF_TYPE"))
            expressionTypeSymbol =  new TypeSymbol(null, expressionTypeSymbol.getActualType());

        if(expressionTypeSymbol==null)
            return null;

        expressionTypeSymbol = (TypeSymbol) getDefaultScope(explicitDispatch.getId().getScope()).lookup(expressionTypeSymbol.getName());

        if(explicitDispatch.getAtType()!=null)
            atTypeSymbol = explicitDispatch.getAtType().accept(this);

        var scope = explicitDispatch.getId().getScope();
        DefaultScope defaultScope = getDefaultScope(scope);

        // Dyanmic dispatch
        if(atTypeSymbol ==null)
        {
            methodSymbol = (MethodSymbol) expressionTypeSymbol.lookupMethods(explicitDispatch.getId().getToken().getText());

            // Verificare metoda
            if(!checkMethod(explicitDispatch.getCtx(),explicitDispatch.getId().getToken(),methodSymbol,expressionTypeSymbol,defaultScope,explicitDispatch.getArguments()))
                return null;

            // Verificare return type metoda
            if(methodSymbol.getType().getToken()==null)
                typeToReturn = (TypeSymbol) defaultScope.lookup(methodSymbol.getType().getActualType());
            else typeToReturn= (TypeSymbol) defaultScope.lookup(methodSymbol.getType().getToken().getText());

            // Setare caller type
            explicitDispatch.setCallerType(expressionTypeSymbol.getName());

            // Return explicit in cazul lui SELF_TYPE
            if(typeToReturn.getName().equals("SELF_TYPE"))
                return expressionTypeSymbol;

            return typeToReturn;
        }
        else {
            // Verificare daca dispatch-ul este corect - A mosteneste pe B in a@B
            if (!getCommonParent(atTypeSymbol, expressionTypeSymbol, scope).getName().equals(atTypeSymbol.getName())) {
                SymbolTable.error(explicitDispatch.getCtx(), explicitDispatch.getAtType().getType().getToken(), "Type " + atTypeSymbol.getName() + " of static dispatch is not a superclass of type " + expressionTypeSymbol.getName());
                return null;
            }

            // Preluare tip atTypeSymbol
            TypeSymbol explicitClassSymbol = (TypeSymbol) defaultScope.lookup(atTypeSymbol.getName());
            methodSymbol = (MethodSymbol) explicitClassSymbol.lookupMethods(explicitDispatch.getId().getToken().getText());

            // Verificare metoda
            if(!checkMethod(explicitDispatch.getCtx(),explicitDispatch.getId().getToken(),methodSymbol,atTypeSymbol,defaultScope,explicitDispatch.getArguments()))
                return null;

            if(methodSymbol.getType().getToken()!=null)
                typeToReturn = (TypeSymbol) scope.lookup(methodSymbol.getType().getToken().getText());
            else
                typeToReturn = (TypeSymbol) scope.lookup(methodSymbol.getType().getActualType());
        }

        // Setare caller type
        explicitDispatch.setCallerType(atTypeSymbol.getName());

        if(typeToReturn.getName().equals("SELF_TYPE"))
            return expressionTypeSymbol;
        else
            return typeToReturn;
    }

    // Implicit Dispatch
    @Override
    public TypeSymbol visit(ImplicitDispatch implicitDispatch) {
        var scope = implicitDispatch.getId().getScope();

        // Extragere clasa in care se afla metoda
        while(!scope.getClass().equals(TypeSymbol.class))
            scope = scope.getParent();

        TypeSymbol currentType = (TypeSymbol) scope;
        DefaultScope defaultScope = getDefaultScope (scope);

        // Verificare warning-uri metoda
        MethodSymbol methodSymbol = (MethodSymbol) currentType.lookupMethods(implicitDispatch.getId().getToken().getText());
        if(!checkMethod(implicitDispatch.getCtx(),implicitDispatch.getId().getToken(),methodSymbol,currentType,defaultScope,implicitDispatch.getArguments()))
            return null;

        implicitDispatch.setCallerType(((TypeSymbol)scope).getName());

        // Return tip
        if(methodSymbol.getType().getToken()==null)
            return (TypeSymbol) defaultScope.lookup(methodSymbol.getType().getActualType());
        return (TypeSymbol) defaultScope.lookup(methodSymbol.getType().getToken().getText());
    }

    // Id
    @Override
    public TypeSymbol visit(Id id) {

        var scope = id.getScope();
        var copyScope = scope;

        // Return tipul lui self
        if(id.getToken().getText().equals("self"))
        {
            if(scope!=null)
                while (!scope.getClass().equals(TypeSymbol.class))
                    scope = scope.getParent();
            else
                return null;
            return new TypeSymbol((TypeSymbol) scope,null,false);
        }

        // Undefined identifier <i>
        if(scope == null)
        {
            SymbolTable.error(id.getCtx(), id.getToken(), "Undefined identifier " + id.getToken().getText());
            return null;
        }

        IdSymbol idSymbol = (IdSymbol) scope.lookup(id.getToken().getText());
        if(idSymbol == null)
        {
            SymbolTable.error(id.getCtx(), id.getToken(), "Undefined identifier " + id.getToken().getText());
            return null;
        }

        // Return tipul exact
        while(!copyScope.getClass().equals(TypeSymbol.class))
            copyScope = copyScope.getParent();
        if(idSymbol.getType().getToken().getText().equals("SELF_TYPE"))
            return new TypeSymbol((TypeSymbol) scope.lookup(idSymbol.getType().getToken().getText()),((TypeSymbol)copyScope).getName(),true);
        else
            return (TypeSymbol) scope.lookup(idSymbol.getType().getToken().getText());
    }

    // Let si Locali
    @Override
    public TypeSymbol visit(Let let) {
        for(var local : let.getLocalList())
            if(local!=null)
                local.accept(this);
        return let.getExpression().accept(this);
    }

    @Override
    public TypeSymbol visit(Local local) {
        var scope = local.getScope();

        if(scope == null)
            return null;

        // Let variable <l> has undefined type <T>
        DefaultScope defaultScope = getDefaultScope(scope);
        if(defaultScope.lookup(local.getType().getToken().getText())==null){
            SymbolTable.error(local.getCtx(), local.getType().getToken(), "Let variable " + local.getId().getToken().getText() + " has undefined type " +  local.getType().getToken().getText());
            return null;
        }

        if(local.getExpression()==null)
            return null;

        TypeSymbol expressionType = local.getExpression().accept(this);

        if(expressionType==null)
            return null;

        // Verificare tip assign cu tip declarat
        TypeSymbol currentType = (TypeSymbol) defaultScope.lookup(expressionType.getName());
        TypeSymbol finalType = checkIfParent(defaultScope,currentType,local.getType().getToken().getText());

        if(finalType!=null)
            return finalType;

        //Type <T1> of initialization expression of identifier <i> is incompatible with declared type <T2>
        SymbolTable.error(local.getCtx(), local.getExpression().getToken(), "Type " + expressionType.getName() + " of initialization expression of identifier " + local.getId().getToken().getText() + " is incompatible with declared type " + local.getType().getToken().getText());
        return null;
    }

    // Block
    @Override
    public TypeSymbol visit(Block block) {

        TypeSymbol returnBodyType = new TypeSymbol(null, "Object");

        // Parcurgere corp functie si determinare tip
        for (var bodyExpr : block.getExpressions())
            if(bodyExpr!=null)
                returnBodyType = bodyExpr.accept(this);

        return returnBodyType;
    }

    // If si while
    @Override
    public TypeSymbol visit(If anIf) {

        TypeSymbol conditionType = anIf.getIfCond().accept(this);
        var scope = anIf.getScope();

        if(scope==null)
            return null;

        // If condition has type <T> instead of Bool
        if(!conditionType.getName().equals("Bool"))
        {
            SymbolTable.error(anIf.getCtx(), anIf.getIfCond().getToken(), "If condition has type " + conditionType.getName() + " instead of Bool");
            return new TypeSymbol(null, "Object");
        }

        TypeSymbol thenType = anIf.getThenBody().accept(this);
        TypeSymbol elseType = anIf.getElseBody().accept(this);

        // Return tip comun celor 2 branch-uri
        return getCommonParent(thenType,elseType,getDefaultScope(scope));
    }

    @Override
    public TypeSymbol visit(While aWhile) {

        TypeSymbol conditionType = aWhile.getWhileCond().accept(this);

        // While condition has type <T> instead of Bool
        if(!conditionType.getName().equals("Bool"))
        {
            SymbolTable.error(aWhile.getCtx(), aWhile.getWhileCond().getToken(), "While condition has type " + conditionType.getName() + " instead of Bool");
            return new TypeSymbol(null, "Object");
        }

        aWhile.getLoopBody().accept(this);
        return new TypeSymbol(null, "Object");
    }

    // Case si CaseBranch
    @Override
    public TypeSymbol visit(Case aCase) {

        // Preluare scope
        var scope = aCase.getId().getScope();
        DefaultScope defaultScope = null;
        if(scope!=null)
            defaultScope = getDefaultScope(scope);
        else
            return new TypeSymbol(null, "Object");

        TypeSymbol bestClass = null;
        for(var branch : aCase.getCaseBranchList())
            if(branch!=null)
            {
                TypeSymbol branchType = branch.accept(this);
                if(branchType == null)
                    return null;
                if(bestClass==null)
                    bestClass = branchType;
                else
                    bestClass = getCommonParent(bestClass,branchType,defaultScope);
            }

        return bestClass;
    }

    @Override
    public TypeSymbol visit(CaseBranch caseBranch) {
        var scope = caseBranch.getScope();

        // Case variable <c> has undefined type <T>
        if(scope!=null) {
            DefaultScope defaultScope = getDefaultScope(scope);
            if(defaultScope.lookup(caseBranch.getType().getToken().getText())==null){
                SymbolTable.error(caseBranch.getCtx(), caseBranch.getType().getToken(), "Case variable " + caseBranch.getId().getToken().getText() + " has undefined type " +  caseBranch.getType().getToken().getText());
                return null;
            }
        }

        return caseBranch.getExpression().accept(this);
    }

    // Tipuri de baza
    @Override
    public TypeSymbol visit(Type type) {
        return null;
    }

    @Override
    public TypeSymbol visit(Bool bool) {
        return new TypeSymbol(null, "Bool");
    }

    @Override
    public TypeSymbol visit(Int anInt) {
        return new TypeSymbol(null,"Int");
    }

    @Override
    public TypeSymbol visit(Stringg stringg) {
        return new TypeSymbol(null, "String");
    }

    // IsVoid New si AtType
    @Override
    public TypeSymbol visit(IsVoid isVoid) {
        return new TypeSymbol(null, "Bool");
    }

    @Override
    public TypeSymbol visit(New aNew) {
        var scope = aNew.getType().getScope();
        if(scope == null)
            return null;

        // new is used with undefined type <T>
        DefaultScope defaultScope = getDefaultScope(scope);
        TypeSymbol typeSymbol = (TypeSymbol) defaultScope.lookup(aNew.getType().getToken().getText());
        if(typeSymbol==null) {
            SymbolTable.error(aNew.getCtx(), aNew.getType().getToken(), "new is used with undefined type " + aNew.getType().getToken().getText());
            return null;
        }

        // Returneaza tipul clasei
        while(!scope.getClass().equals(TypeSymbol.class))
            scope = scope.getParent();
        if(aNew.getType().getToken().getText().equals("SELF_TYPE"))
            return new TypeSymbol((TypeSymbol) scope.lookup(aNew.getType().getToken().getText()),((TypeSymbol)scope).getName(),true);
        return typeSymbol;
    }


    @Override
    public TypeSymbol visit(AtType atType) {

        var scope = atType.getType().getScope();

        if(atType.getType().getToken().getText().equals("SELF_TYPE"))
        {
            SymbolTable.error(atType.getCtx(),atType.getType().getToken(),"Type of static dispatch cannot be SELF_TYPE");
            return null;
        }

        if(scope == null)
            return null;

        // Case variable <c> has undefined type <T>
        DefaultScope defaultScope = getDefaultScope(scope);
        if(defaultScope.lookup(atType.getType().getToken().getText())==null){
            SymbolTable.error(atType.getCtx(), atType.getType().getToken(), "Type " + atType.getType().getToken().getText() + " of static dispatch is undefined");
            return null;
        }

        return new TypeSymbol(null, atType.getType().getToken().getText());
    }

    // Not (ambele)
    @Override
    public TypeSymbol visit(NotSymb notSymb) {
        TypeSymbol expr = notSymb.getExpression().accept(this);
        if(expr == null)
            return null;

        // Operand of ~ has type <T> instead of Int
        if(!expr.getName().equals("Int"))
        {
            SymbolTable.error(notSymb.getCtx(), notSymb.getExpression().getToken(), "Operand of ~ has type " + expr.getName() + " instead of Int");
            return null;
        }
        return expr;
    }

    @Override
    public TypeSymbol visit(Not not) {

        TypeSymbol expr = not.getExpression().accept(this);

        if(expr == null)
            return null;

        // Operand of not has type <T> instead of Bool
        if(!expr.getName().equals("Bool"))
        {
            SymbolTable.error(not.getCtx(), not.getExpression().getToken(), "Operand of not has type " + expr.getName() + " instead of Bool");
            return null;
        }
        return expr;
    }

    // Egal
    @Override
    public TypeSymbol visit(Equal equal) {
        TypeSymbol left = equal.getLeft().accept(this);
        TypeSymbol right = equal.getRight().accept(this);

        var scope = equal.getScope();

        if(left==null || right==null)
            return null;

        String leftType = left.getName();
        String actualFirstLeft = left.getName();
        if(actualFirstLeft == "SELF_TYPE")
            actualFirstLeft = left.getActualType();

        for (String baseClass : baseClasses)
            {
                String currentType = getCommonParent(new TypeSymbol(null,actualFirstLeft), new TypeSymbol(null, baseClass), getDefaultScope(scope)).getName();
                if(currentType.equals(baseClass))
                {
                    leftType = currentType;
                    break;
                }
            }

        String rightType = right.getName();
        String actualFirstRight = left.getName();
        if(actualFirstRight == "SELF_TYPE")
            actualFirstRight = left.getActualType();
        for (String baseClass : baseClasses)
            {
                String currentType = getCommonParent(new TypeSymbol(null,actualFirstRight), new TypeSymbol(null, baseClass), getDefaultScope(scope)).getName();
                if(currentType.equals(baseClass))
                {
                    rightType = currentType;
                    break;
                }
            }

        // Return null daca niciunul dintre tipuri nu este din cele de baza
        if(!baseClasses.contains(leftType) || !baseClasses.contains(rightType))
            return null;

        // Tipurile corespund
        if(leftType.equals(rightType))
            return new TypeSymbol(null,"Bool");

        // Cannot compare <T1> with <T2>
        SymbolTable.error(equal.getCtx(), equal.getOperation(), "Cannot compare " + leftType + " with " + rightType);
        return null;
    }

    // Operatii aritmetice si relationale
    @Override
    public TypeSymbol visit(Plus plus) {
        return visitRelationalOrArithmetic(plus,"+");
    }

    @Override
    public TypeSymbol visit(Minus minus) {
        return visitRelationalOrArithmetic(minus,"-");
    }

    @Override
    public TypeSymbol visit(Mult mult) {
        return visitRelationalOrArithmetic(mult,"*");
    }

    @Override
    public TypeSymbol visit(Div div) {
        return visitRelationalOrArithmetic(div,"/");
    }

    @Override
    public TypeSymbol visit(LessThan lessThan) {
        return visitRelationalOrArithmetic(lessThan, "<");
    }

    @Override
    public TypeSymbol visit(LessEqual lessEqual) {
        return visitRelationalOrArithmetic(lessEqual, "<=");
    }

    public TypeSymbol visitRelationalOrArithmetic(BinaryOperation operation, String op) {
        TypeSymbol left = operation.getLeft().accept(this);
        TypeSymbol right = operation.getRight().accept(this);

        // Operand of <op> has type <T> instead of Int
        if (left != null && !left.getName().equals("Int"))
            SymbolTable.error(operation.getCtx(), operation.getLeft().getToken(), "Operand of " + op + " has type " + left.getName() + " instead of Int");

        // Operand of <op> has type <T> instead of Int
        if (right != null && !right.getName().equals("Int"))
            SymbolTable.error(operation.getCtx(), operation.getRight().getToken(), "Operand of " + op + " has type " + right.getName() + " instead of Int");

        if (left != null && right != null && left.getName().equals("Int") && right.getName().equals("Int")) {
            if (operation instanceof Relational)
                return new TypeSymbol(null, "Bool");
            else
                return left;
        }
        return null;
    }

    // UTILE

    public static DefaultScope getDefaultScope(Scope scope) {
        while(!scope.getClass().equals(DefaultScope.class))
            scope = scope.getParent();
        return (DefaultScope) scope;
    }

    private TypeSymbol checkIfParent(Scope defaultScope, TypeSymbol currentType, String parent) {

        // Obtinere simbol clasa curenta
        TypeSymbol typeSymbol = (TypeSymbol) defaultScope.lookup(currentType.getName());

        // Traversare clase mostenite
        while(typeSymbol!=null){
            // Clasa curenta o mosteneste pe cea parinte
            if(typeSymbol.getName().equals(parent))
                return (TypeSymbol) defaultScope.lookup(parent);
            if(typeSymbol.getParentClass() == null)
                return null;
            typeSymbol = (TypeSymbol) defaultScope.lookup(typeSymbol.getParentClass());
        }
        return null;
    }

    public TypeSymbol getCommonParent(TypeSymbol a, TypeSymbol b, Scope defaultScope) {
        if (a.getName().equals(b.getName())) return a;

        // Obtinere ierarhii de clase
        List<String> classesA = getClassHierarchy(a, defaultScope);
        List<String> classesB = getClassHierarchy(b, defaultScope);


        for (String className : classesA)
            if (classesB.contains(className)) {
                if (!a.getFixedType() || !b.getFixedType())
                    return new TypeSymbol((TypeSymbol) defaultScope.lookup(className), null, false);
                return (TypeSymbol) defaultScope.lookup(className);
            }

        return (TypeSymbol) defaultScope.lookup("Object");
    }

    // Obtinere lista cu ierearhia de clase a unei clase
    private List<String> getClassHierarchy(TypeSymbol type, Scope defaultScope) {
        List<String> classes = new ArrayList<>();
        type = (TypeSymbol) defaultScope.lookup(type.getName());
        classes.add(type.getName());
        classes.add(type.getActualType() != null ? type.getActualType() : type.getName());

        while (type != null) {
            classes.add(type.getName());
            if (type.getParentClass() == null)
                break;
            type = (TypeSymbol) defaultScope.lookup(type.getParentClass());
        }
        return classes;
    }

    private boolean checkFormalParameters(ParserRuleContext ctx, MethodSymbol methodSymbol, List<SimpleExpression> arguments, DefaultScope defaultScope, TypeSymbol classType) {
        int pos = 0;
        // Parcurgere parametrii
        for( var arg : arguments)
            if(arg!=null)
            {
                TypeSymbol parameterType = null;
                parameterType = arg.accept(this);
                if(parameterType == null)
                    return false;

                // Extragere idSymbol pentru a afla tipul parametrilor
                Set<String> keySet = methodSymbol.getFormals().keySet();
                List<String> listKeys = new ArrayList<>(keySet);
                String key = listKeys.get(pos);
                IdSymbol formalSymbol = (IdSymbol) methodSymbol.getFormals().get(key);

                // Setare tip
                String formalClassName;
                if(formalSymbol.getType().getToken()==null)
                    formalClassName = formalSymbol.getType().getActualType();
                else
                    formalClassName = formalSymbol.getType().getToken().getText();

                TypeSymbol formalClass = (TypeSymbol) defaultScope.lookup(formalClassName);

                // In call to method <m> of class <C>, actual type <T1> of formal parameter <f> is incompatible with declared type <T2>
                if (!getCommonParent(formalClass,parameterType,defaultScope).getName().equals(formalClass.getName()))
                    SymbolTable.error(ctx, arg.getToken(), "In call to method " + methodSymbol.getName() + " of class " + classType.getName() + ", actual type " + parameterType.getName() + " of formal parameter " + formalSymbol.getName() +" is incompatible with declared type " + formalClassName);
                pos++;
            }
        return true;
    }

    private boolean checkMethod(ParserRuleContext ctx, Token idToken, MethodSymbol methodSymbol, TypeSymbol currentClass, DefaultScope defaultScope, List<SimpleExpression> arguments) {
        // Undefined method <m> in class <C>
        if(methodSymbol==null){
            SymbolTable.error(ctx, idToken, "Undefined method " + idToken.getText() + " in class " + currentClass.getName());
            return false;
        }

        // Method <m> of class <C> is applied to wrong number of arguments
        if(methodSymbol.getFormals().size()!=arguments.size())
        {
            SymbolTable.error(ctx, idToken, "Method " + idToken.getText() + " of class " + currentClass.getName() +" is applied to wrong number of arguments");
            return false;
        }

        return checkFormalParameters(ctx,methodSymbol,arguments,defaultScope,currentClass);
    }

};