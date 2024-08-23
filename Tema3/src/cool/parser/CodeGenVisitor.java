package cool.parser;

import cool.compiler.Compiler;
import cool.parser.Nodes.*;
import cool.structures.DefaultScope;
import cool.structures.Scope;
import cool.structures.Symbol;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class CodeGenVisitor implements ASTVisitor<ST> {
    static STGroupFile templates = new STGroupFile("cool/cgen.stg");
    ST stringConstantsSection = templates.getInstanceOf("sequence");
    ST intConstantsSection = templates.getInstanceOf("sequence");
    ST nameTabSeciton = templates.getInstanceOf("sequence");
    ST objTabSection = templates.getInstanceOf("sequence");
    ST protObjSection = templates.getInstanceOf("sequence");
    ST dispTabSection = templates.getInstanceOf("sequence");
    ST initSection = templates.getInstanceOf("sequence");
    ST funcSection = templates.getInstanceOf("sequence");

    HashMap<String, Integer> constantStringMap = new HashMap<>();
    HashMap<Integer, String> constantIntMap = new HashMap<>();
    final List<String> classNames = List.of("Object", "IO", "Int", "String", "Bool");

    // Scope containing all the classes - Used for obtaining the symbols of classes based on names
    DefaultScope defaultScope = null;
    Scope currentScope = null;
    Integer dispatchCnt = 0;

    Integer caseCnt = 0;

    Integer nextIdx = 0;

    @Override
    public ST visit(Prog programS) {

        // Create base classes and initalise Default scope
        List<ClassDeclaration> classDeclarationList = new ArrayList<>();
        for (ClassDeclaration classNode : programS.getClassDeclarationList())
            if (classNode != null && classNode.getType().getScope() != null) {
                defaultScope = ResolutionPassVisitor.getDefaultScope(classNode.getType().getScope());
                classDeclarationList = createbaseClasses();
                break;
            }

        // Add the empty constant string
        add_string_constant("");

        // Add declared classes to list
        for (ClassDeclaration classNode : programS.getClassDeclarationList())
            if (classNode != null)
                classDeclarationList.add(classNode);

        // Visit all clases
        for (ClassDeclaration classDeclaration : classDeclarationList)
            classDeclaration.accept(this);

        // Assemblying it
        var programST = templates.getInstanceOf("program");
        programST.add("constantStrings", stringConstantsSection)
                .add("constantInts", intConstantsSection)
                .add("nameTab", nameTabSeciton)
                .add("objTab", objTabSection)
                .add("protObj", protObjSection)
                .add("dispTab", dispTabSection)
                .add("init", initSection)
                .add("func", funcSection);

        return programST;
    }

    @Override
    public ST visit(ClassDeclaration aClass) {

        currentScope = aClass.getType().getScope();
        String className = aClass.getType().getActualType();
        if (aClass.getType().getToken() != null)
            className = aClass.getType().getToken().getText();

        // Add str_constant for class name
        String strConst = add_string_constant(className);

        // Add class in nameTab
        add_in_nameTab(strConst);

        // Add in objTab
        add_in_objTab(className);

        // Add protObj
        add_in_protObj(className);

        // Add disp tab
        add_in_dispTab(className);

        // Add initMethod
        TypeSymbol classSymbol = (TypeSymbol) defaultScope.lookup(className);
        var st = templates.getInstanceOf("initElem");
        st.add("classname", className);
        if (classSymbol.getParentClass() != null)
            st.add("parentClass", classSymbol.getParentClass());

        // Accept methods and initialised attribtutes
        if (!classNames.contains(className))
            for (ASTNode attributeOrFunction : aClass.getAttributesAndFunctions())
                if (attributeOrFunction != null && attributeOrFunction.getClass().equals(Method.class))
                    attributeOrFunction.accept(this);
                else if (attributeOrFunction != null && attributeOrFunction.getClass().equals(Attribute.class)) {
                    ST currentAttribute = attributeOrFunction.accept(this);
                    if (currentAttribute != null)
                        st.add("initAttributes", currentAttribute);
                }

        initSection.add("e", st);
        return null;
    }

    @Override
    public ST visit(Attribute variableDeclaration) {
        if (variableDeclaration.getExpression() == null)
            return null;
        return templates.getInstanceOf("initializeAttribute")
                .add("offset", variableDeclaration.getId().getSymbol().getOffset())
                .add("expr", variableDeclaration.getExpression().accept(this));
    }

    @Override
    public ST visit(Method method) {
        var scope = method.getId().getScope();
        currentScope = scope;
        var st = templates.getInstanceOf("methodDef");
        int count = 0;
        for (Formal formal : method.getFormalList())
            if (formal != null)
                count++;

        // Add in funcSection
        st.add("methodName", ((TypeSymbol) scope.getParent()).getName() + "." + method.getId().getToken().getText())
                .add("arguments", count * 4);
        for (Expression expr : method.getExpressionList())
            st.add("exprs", expr.accept(this));
        funcSection.add("e", st);
        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public ST visit(AssignWithoutDeclare assignWithoutDeclare) {
        ST value = assignWithoutDeclare.getExpression().accept(this);
        var idSymbol = (IdSymbol) currentScope.lookup(assignWithoutDeclare.getId().getToken().getText());

        // If it's the attribute of a class, store it, else store local/formal/local variable
        if (idSymbol.getAttributeForClass())
            return templates.getInstanceOf("storeAttribute").add("val", value).add("offset", idSymbol.getOffset());
        return templates.getInstanceOf("storeVar").add("val", value).add("offset", idSymbol.getOffset());
    }

    @Override
    public ST visit(Id id) {
        var idName = id.getToken().getText();
        var idSymbol = (IdSymbol) currentScope.lookup(idName);
        if (idName.equals("self"))
            return templates.getInstanceOf("self");

        // Edge case
        if (idSymbol == null)
            return null;

        // If it's the attribute of a class, load it, else load local/formal/local variable
        if (idSymbol.getAttributeForClass())
            return templates.getInstanceOf("loadAttribute").add("offset", idSymbol.getOffset());
        return templates.getInstanceOf("loadVar").add("offset", idSymbol.getOffset());
    }

    @Override
    public ST visit(Bool bool) {
        var st = templates.getInstanceOf("intStringBoolInstruction");
        if (bool.getToken().getText().equals("true"))
            st.add("const", "bool_const1");
        else
            st.add("const", "bool_const0");
        return st;
    }

    @Override
    public ST visit(Int anInt) {
        var st = templates.getInstanceOf("intStringBoolInstruction");
        st.add("const", add_int_constant(Integer.parseInt(anInt.getToken().getText())));
        return st;
    }

    @Override
    public ST visit(Stringg stringg) {
        var st = templates.getInstanceOf("intStringBoolInstruction");
        st.add("const", add_string_constant(stringg.getToken().getText()));
        return st;
    }

    @Override
    public ST visit(Block block) {
        currentScope = block.getScope();
        var st = templates.getInstanceOf("block");
        for (Expression expression : block.getExpressions())
            if (expression != null)
                st.add("exprs", expression.accept(this));
        currentScope = currentScope.getParent();
        return st;
    }

    @Override
    public ST visit(ExplicitDispatch explicitDispatch) {
        var method = explicitDispatch.getId().getToken().getText();
        MethodSymbol methodSymbol = (MethodSymbol) ((TypeSymbol) defaultScope.lookup(explicitDispatch.getCallerType())).lookupMethods(method);

        ST dispatch = templates.getInstanceOf("explicitDispatch")
                .add("method", method)
                .add("idx", dispatchCnt++)
                .add("offset", methodSymbol.getOffset())
                .add("filename", getFileName(explicitDispatch))
                .add("line", explicitDispatch.getId().getLine());

        // Reverse parameters
        List<SimpleExpression> params = explicitDispatch.getArguments();
        Collections.reverse(params);

        // Add the parameters to the template
        for (SimpleExpression param : params)
            dispatch.add("params", templates.getInstanceOf("dispatchParam").add("param", param.accept(this)));

        // Add the type of the element which is called on
        dispatch.add("explicit", explicitDispatch.getExpression().accept(this));

        // Add atType if it exists
        if (explicitDispatch.getAtType() != null)
            dispatch.add("atType", explicitDispatch.getAtType().getType().getToken().getText());

        return dispatch;
    }

    @Override
    public ST visit(ImplicitDispatch implicitDispatch) {
        var method = implicitDispatch.getId().getToken().getText();
        MethodSymbol methodSymbol = (MethodSymbol) ((TypeSymbol) defaultScope.lookup(implicitDispatch.getCallerType())).lookupMethods(method);

        ST dispatch = templates.getInstanceOf("implicitDispatch")
                .add("method", method)
                .add("idx", dispatchCnt++)
                .add("offset", methodSymbol.getOffset())
                .add("filename", getFileName(implicitDispatch))
                .add("line", implicitDispatch.getId().getLine());

        // Reverse parameters
        List<SimpleExpression> params = implicitDispatch.getArguments();
        Collections.reverse(params);

        // Add the parameters to the template
        for (SimpleExpression param : params)
            dispatch.add("params", templates.getInstanceOf("dispatchParam").add("param", param.accept(this)));

        return dispatch;
    }

    @Override
    public ST visit(Local local) {
        currentScope = local.getScope();

        // Initialise with the constant if is the base class
        if (local.getExpression() == null) {
            var st = templates.getInstanceOf("initializeLocal");
            var constT = templates.getInstanceOf("intStringBoolInstruction");
            String type = local.getType().getToken().getText();
            if (type.equals("Int"))
                constT.add("const", "int_const0");
            if (type.equals("String"))
                constT.add("const", "str_const0");
            if (type.equals("Bool"))
                constT.add("const", "bool_const0");
            if (type.equals("SELF_TYPE"))
                constT.add("const", "0");
            if (constT.getAttribute("const") == null)
                return null;
            return st.add("expr", constT).add("offset", local.getSymbol().getOffset());
        } else {
            var st = templates.getInstanceOf("storeVar");
            st.add("offset", local.getSymbol().getOffset());
            st.add("val", local.getExpression().accept(this));
            return st;
        }
    }

    @Override
    public ST visit(Let let) {
        int count = 0;
        var st = templates.getInstanceOf("initLet");

        // Accept locali
        for (Local local : let.getLocalList())
            if (local != null) {
                count++;
                st.add("locals", local.accept(this));
            }

        // Return to the precedent let scope
        for (int i = 0; i < count; i++)
            currentScope = currentScope.getParent();
        st.add("capacity", (count * 4));
        st.add("body", let.getExpression().accept(this));
        return st;
    }

    @Override
    public ST visit(Formal formal) {
        return null;
    }

    @Override
    public ST visit(Type type) {
        return null;
    }

    @Override
    public ST visit(Plus plus) {
        return templates.getInstanceOf("arithmetic").add("expr1", plus.getLeft().accept(this))
                .add("expr2", plus.getRight().accept(this))
                .add("op_arithm", "add");
    }

    @Override
    public ST visit(Minus minus) {
        return templates.getInstanceOf("arithmetic").add("expr1", minus.getLeft().accept(this))
                .add("expr2", minus.getRight().accept(this))
                .add("op_arithm", "sub");
    }

    @Override
    public ST visit(Mult mult) {
        return templates.getInstanceOf("arithmetic").add("expr1", mult.getLeft().accept(this))
                .add("expr2", mult.getRight().accept(this))
                .add("op_arithm", "mul");
    }

    @Override
    public ST visit(Div div) {
        return templates.getInstanceOf("arithmetic").add("expr1", div.getLeft().accept(this))
                .add("expr2", div.getRight().accept(this))
                .add("op_arithm", "div");
    }

    @Override
    public ST visit(NotSymb notSymb) {
        return templates.getInstanceOf("neg").add("expr", notSymb.getExpression().accept(this));
    }

    @Override
    public ST visit(Equal equal) {
        return templates.getInstanceOf("equal").add("expr1", equal.getLeft().accept(this))
                .add("expr2", equal.getRight().accept(this))
                .add("cnt_equal", dispatchCnt++);
    }

    @Override
    public ST visit(LessThan lessThan) {
        return templates.getInstanceOf("comp").add("expr1", lessThan.getLeft().accept(this))
                .add("expr2", lessThan.getRight().accept(this))
                .add("op", "blt")
                .add("cnt_comp", dispatchCnt++);
    }

    @Override
    public ST visit(LessEqual lessEqual) {
        return templates.getInstanceOf("comp").add("expr1", lessEqual.getLeft().accept(this))
                .add("expr2", lessEqual.getRight().accept(this))
                .add("op", "ble")
                .add("cnt_comp", dispatchCnt++);
    }

    @Override
    public ST visit(Not not) {
        return templates.getInstanceOf("not").add("expr", not.getExpression().accept(this))
                .add("cnt_not", dispatchCnt++);
    }

    @Override
    public ST visit(IsVoid isVoid) {
        return templates.getInstanceOf("isvoid").add("expr", isVoid.getExpression().accept(this))
                .add("cnt_isvoid", dispatchCnt++);
    }

    @Override
    public ST visit(New aNew) {
        if (!aNew.getType().getToken().getText().equals("SELF_TYPE"))
            return templates.getInstanceOf("newObj").add("className", aNew.getType().getToken().getText());
        else {
            return templates.getInstanceOf("newSELFTYPE");
        }
    }

    @Override
    public ST visit(If anIf) {
        return templates.getInstanceOf("if").add("cond", anIf.getIfCond().accept(this))
                .add("then_if", anIf.getThenBody().accept(this))
                .add("else_if", anIf.getElseBody().accept(this))
                .add("cnt_if", dispatchCnt++);
    }

    @Override
    public ST visit(While aWhile) {
        return templates.getInstanceOf("while").add("cond_while", aWhile.getWhileCond().accept(this))
                .add("body_while", aWhile.getLoopBody().accept(this))
                .add("cnt_while", dispatchCnt++);
    }

    @Override
    public ST visit(Case aCase) {
        var branches = aCase.getCaseBranchList();
        branches.sort((o1, o2) -> {
            if (o1 != null && o2 != null) {
                if (((TypeSymbol) o1.getSymbol()).getId() > ((TypeSymbol) o2.getSymbol()).getId())
                    return 1;
                else if (((TypeSymbol) o1.getSymbol()).getId() < ((TypeSymbol) o2.getSymbol()).getId())
                    return -1;
            }
            return 0;
        });
        for (var elem : branches) {
            if (elem != null && elem.getSymbol() != null)
                elem.getSymbol().setOffset(-4);
        }
        var bran = branches.stream()
                .filter(Objects::nonNull)
                .map(this::visit)
                .map(ST::render)
                .collect(Collectors.joining("\n"));

        var case_tem = templates.getInstanceOf("case");

        return case_tem.add("expr", aCase.getId().accept(this))
                .add("branches_case", bran)
                .add("cnt_case", caseCnt++)
                .add("filename", getFileName(aCase))
                .add("line", aCase.getId().getLine());
    }

    @Override
    public ST visit(CaseBranch caseBranch) {
        var oldScope = currentScope;
        currentScope = caseBranch.getScope();
        var tag1 = ((TypeSymbol) defaultScope.lookup(caseBranch.getType().getToken().getText())).getId();
        Integer tag2 = tag1;
        for (var elem : defaultScope.getSymbols().keySet()) {
            if (elem.equals(caseBranch.getType().getToken().getText()))
                continue;

            TypeSymbol classSymbol = (TypeSymbol) defaultScope.lookup(elem);
            var copyClass = classSymbol;
            while (true) {
                if (classSymbol.getParentClass() != null && !classSymbol.getParentClass().equals("Object")
                        && !classSymbol.getParentClass().equals("IO"))
                    classSymbol = (TypeSymbol) defaultScope.lookup(classSymbol.getParentClass());
                else
                    break;
            }
            if (classSymbol.getName().equals(caseBranch.getType().getToken().getText())
                    && !copyClass.getName().equals(oldScope.getParent().toString())) {
                if (((TypeSymbol) defaultScope.lookup(copyClass.getName())).getId() > tag2) {

                    tag2 = ((TypeSymbol) defaultScope.lookup(copyClass.getName())).getId();
                }
            }
        }

        var branch = templates.getInstanceOf("case_branch")
                .add("expr", caseBranch.getExpression().accept(this))
                .add("tag1", tag1)
                .add("tag2", tag2)
                .add("cnt_case", caseCnt)
                .add("next_idx_case", nextIdx++);
        currentScope = currentScope.getParent();
        return branch;
    }

    @Override
    public ST visit(AtType atType) {
        return null;
    }

    // Add the Int constant
    private String add_int_constant(int number) {

        // Check if an int with this value already exists
        if (constantIntMap.containsKey(number))
            return constantIntMap.get(number);

        // Add a new int constant
        var st = templates.getInstanceOf("int_constant");
        st.add("index", constantIntMap.size())
                .add("tag", ((TypeSymbol) defaultScope.lookup("Int")).getId())
                .add("value", number);

        // Add it to the int_constants section
        intConstantsSection.add("e", st);

        // Add it to the hashmap
        constantIntMap.put(number, "int_const" + constantIntMap.size());

        // Return the constant
        return constantIntMap.get(number);
    }

    // Add the String constant
    private String add_string_constant(String className) {
        if (constantStringMap.containsKey(className))
            return "str_const" + constantStringMap.get(className);
        var st = templates.getInstanceOf("string_constant");

        // Get the int constant for the length
        String integerConstant = add_int_constant(className.length());

        // Add the string_constant
        st.add("index", constantStringMap.size())
                .add("tag", ((TypeSymbol) defaultScope.lookup("String")).getId())
                .add("int_constant", integerConstant)
                .add("length", (className.length() + 1) / 4 + 5)
                .add("content", className);

        // Add it to the section
        stringConstantsSection.add("e", st);

        // Add it to the hashmap
        constantStringMap.put(className, constantStringMap.size());

        // Return the constant
        return "str_const" + constantStringMap.get(className);
    }

    // Get the filename for the dispatch
    private String getFileName(ASTNode node) {
        var ctx = node.getCtx();
        while (!(ctx.getParent().getClass().equals(CoolParser.ProgramContext.class)))
            ctx = ctx.getParent();
        return add_string_constant(new File(Compiler.fileNames.get(ctx)).getName());
    }

    // Add an element in prototypes section - ProtObj
    private void add_in_protObj(String className) {

        // If it's a base class, ignore it
        if (classNames.contains(className))
            return;
        TypeSymbol classSymbol = (TypeSymbol) defaultScope.lookup(className);
        var st = templates.getInstanceOf("protObjElem");
        st.add("tag", classSymbol.getId());
        st.add("classname", className);

        // Create a full list of the attributes - including the attributes from the parents
        List<String> fullList = new ArrayList<>();

        // Go through the parent classes and current class
        while (classSymbol.getClass().equals(TypeSymbol.class)) {

            // Go through the attributes
            List<String> smallList = new ArrayList<>();
            Map<String, Symbol> attributeSymbols = classSymbol.getSymbols();
            Set<String> attributeNames = classSymbol.getSymbols().keySet();

            for (String attributeName : attributeNames) {
                IdSymbol idSymbol = (IdSymbol) attributeSymbols.get(attributeName);

                // Inializare default daca tipul e clasa de baza sau SELF_TYPE
                if (idSymbol.getType().getToken() != null) {
                    String type = idSymbol.getType().getToken().getText();
                    if (type.equals("Int"))
                        smallList.add("int_const0");
                    if (type.equals("String"))
                        smallList.add("str_const0");
                    if (type.equals("Bool"))
                        smallList.add("bool_const0");
                    if (type.equals("SELF_TYPE"))
                        smallList.add("0");
                }
            }

            Collections.reverse(smallList);
            fullList.addAll(smallList);

            // Get the parent - if there's one
            if (classSymbol.getParentClass() != null)
                classSymbol = (TypeSymbol) defaultScope.lookup(classSymbol.getParentClass());
            else
                break;
        }

        st.add("words", 3 + fullList.size());

        // Get the full list in the correct order (from oldest parent inherited to current class)
        Collections.reverse(fullList);

        // Add the attributes in ProtObj
        for (String attributeType : fullList) {
            var stAux = templates.getInstanceOf("attrributeInProtObj");
            stAux.add("attributeType", attributeType);
            st.add("attributes", stAux);
        }
        protObjSection.add("e", st);
    }

    // Add in dispTab
    private void add_in_dispTab(String className) {

        TypeSymbol classSymbol = (TypeSymbol) defaultScope.lookup(className);
        var st = templates.getInstanceOf("dispTabElem");

        // Create a full list of the methods
        List<String> fullList = new ArrayList<>();

        var currClass = classSymbol;
        var currMethodsSymbols = currClass.getSymbolsMethods();
        var currClassMethods = currClass.getSymbolsMethods().keySet();

        HashMap<String, Bool> hash = new HashMap<>();

        // Go through the parent classes and current class
        while (classSymbol.getClass().equals(TypeSymbol.class)) {
            // Go through the methods
            List<String> smallList = new ArrayList<>();
            Map<String, Symbol> methodSymbols = classSymbol.getSymbolsMethods();
            Set<String> methodNames = classSymbol.getSymbolsMethods().keySet();
            for (String methodName : methodNames) {
                MethodSymbol methodSymbol = (MethodSymbol) methodSymbols.get(methodName);

                smallList.add(classSymbol.getName() + "." + methodSymbol.getName());
            }

            Collections.reverse(smallList);
            fullList.addAll(smallList);

            // Get the parent
            if (classSymbol.getParentClass() != null)
                classSymbol = (TypeSymbol) defaultScope.lookup(classSymbol.getParentClass());
            else
                break;
        }

        Collections.reverse(fullList);
        HashMap<Integer, String> indexes = new HashMap<>();
        boolean signal = false;

        List<String> dupFullList = new ArrayList<>(fullList);
        for (var elem1 : dupFullList)
            for (var elem2 : dupFullList) {
                if (elem1.substring(elem1.indexOf(".")).equals(elem2.substring(elem2.indexOf("."))) &&
                        !(elem1.substring(0, elem1.indexOf(".") + 1).equals(elem2.substring(0, elem2.indexOf(".") + 1)))) {
                    int index1 = fullList.indexOf(elem1);
                    int index2 = fullList.indexOf(elem2);
                    if (index1 < index2)
                        indexes.put(index1, elem1.substring(elem1.indexOf(".") + 1));
                }
            }

        for (var elem : dupFullList)
            for (var key : indexes.keySet()) {
                if (elem.substring(elem.indexOf(".") + 1).equals(indexes.get(key)))
                    if (!currClassMethods.contains(elem.substring(elem.indexOf(".") + 1))) {
                        signal = true;
                        int count = 0;
                        for (var inner : fullList)
                            if (inner.substring(elem.indexOf(".") + 1).equals(indexes.get(key)))
                                count++;
                        if (count > 1)
                            fullList.remove(elem);
                    } else
                        fullList.remove(elem);
            }
        if (!signal) {
            for (var elem : indexes.keySet()) {
                fullList.add(elem, currClass.getName() + "." + indexes.get(elem));
            }
        }


        for (String methodName : fullList) {
            var stAux = templates.getInstanceOf("methodName");
            if (currMethodsSymbols.get(methodName.substring(methodName.indexOf(".") + 1)) != null) {
                ((MethodSymbol) currMethodsSymbols.get(methodName.substring(methodName.indexOf(".") + 1)))
                        .setOffset(fullList.indexOf(methodName) * 4);
            }
            stAux.add("funcName", methodName);
            st.add("methods", stAux);
        }

        st.add("classname", className);
        dispTabSection.add("e", st);
    }

    // Add in nameTab
    private void add_in_nameTab(String strConst) {
        var st = templates.getInstanceOf("nameTabElem");
        st.add("strConst", strConst);
        nameTabSeciton.add("e", st);
    }

    // Add in objTab
    private void add_in_objTab(String className) {
        var st = templates.getInstanceOf("objTabElem");
        st.add("class", className);
        objTabSection.add("e", st);
    }

    // Create objects of type ClassDeclaration for base classes such that the traversal is much more uniform
    private List<ClassDeclaration> createbaseClasses() {

        List<ClassDeclaration> baseClassesList = new ArrayList<>();

        ClassDeclaration objectClass;
        for (String className : classNames) {

            TypeSymbol classInScope = (TypeSymbol) defaultScope.lookup(className);

            // Create methods list
            List<ASTNode> methods = new ArrayList<>();
            Set<String> methodNames = classInScope.getSymbolsMethods().keySet();
            for (String methodName : methodNames) {

                // Create id of method
                Id id = new Id(null, null);
                id.setSymbol(new IdSymbol(methodName));

                MethodSymbol methodSymbol = (MethodSymbol) classInScope.getSymbolsMethods().get(methodName);

                // Get type of method
                Type type = methodSymbol.getType();

                // Get formal list
                List<Formal> formalList = new ArrayList<>();

                // Create formal list
                Set<String> formalNames = methodSymbol.getFormals().keySet();
                for (String formalName : formalNames) {
                    IdSymbol formalSymbol = (IdSymbol) methodSymbol.getFormals().get(formalName);

                    Id idFormal = new Id(null, null);
                    idFormal.setSymbol(new IdSymbol(formalName));

                    Formal formal = new Formal(idFormal, formalSymbol.getType(), null, null);
                    formalList.add(formal);
                }
                Method method = new Method(id, type, formalList, null, null, null);
                methods.add(method);
            }

            // Visit the base class
            if (className.equals("Object")) {
                objectClass = new ClassDeclaration(new Type(className), null, methods, null, null);
                baseClassesList.add(objectClass);
            } else {
                ClassDeclaration classDeclaration = new ClassDeclaration(new Type(className), new Type("Object"), methods, null, null);
                baseClassesList.add(classDeclaration);
            }
        }
        return baseClassesList;
    }

}