parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header{
    package cool.parser;
}

program
    :   (classDeclaration SEMI)* EOF
    ;

classDeclaration
    :   CLASS type=TYPE (INHERITS inherited_class=TYPE)? LBRACE ((attribute|method) SEMI)* RBRACE
    ;

attribute
    : id=ID COLON type=TYPE (ASSIGN expr=simpleExpression)?
    ;

method
    :  id=ID LPAREN ((formal COMMA)* formal)? RPAREN COLON type=TYPE LBRACE (expression|((expression SEMI)*)) RBRACE
    ;

formal
    : id=ID COLON type=TYPE
    ;

simpleExpression
    :   expr=simpleExpression atT=atType? DOT id=ID LPAREN ((simpleExpression COMMA)* simpleExpression)? RPAREN # explicitDispatch
    |   id=ID LPAREN ((simpleExpression COMMA)* simpleExpression)? RPAREN              # implicitDispatch
    |   NOTSYMB expr=simpleExpression                                                  # notSymb
    |   ISVOID expr=simpleExpression                                                   # isVoid
    |   NEW type=TYPE                                                                  # new
    |   IF ifCond=simpleExpression THEN thenBody=expression ELSE elseBody=expression FI     #if
    |   left=simpleExpression op=(MULT|DIV) right=simpleExpression                     # multDiv
    |   left=simpleExpression op=(PLUS|MINUS) right=simpleExpression                   # plusMinus
    |   left=simpleExpression op=(EQUAL|LT|LE) right=simpleExpression                  # comparare
    |   LPAREN expr=simpleExpression RPAREN                                            # paren
    |   NOT expr=simpleExpression                                                      # not
    |   ID                                                                             # id
    |   INT                                                                            # int
    |   BOOL                                                                           # bool
    |   STRING                                                                         # string
    ;

expression
    : id=ID ASSIGN expr=expression                                                             #assignWithoutDeclare
    | simpleExpression                                                                         #declare
    | LBRACE (expression|((expression SEMI)*)) RBRACE                                          #block
    | WHILE whileCond=simpleExpression LOOP loopBody=expression POOL                           #while
    | ((LPAREN LET ((local COMMA)* local)? IN body=expression RPAREN)|(LET ((local COMMA)* local)? IN body=expression))  #let
    | CASE id=ID OF (caseBranch SEMI)+ ESAC                                                    #case
    ;

caseBranch
    : id=ID COLON type=TYPE RESULT expr=expression
    ;

atType
    : DISPATCH type = TYPE;

local
    : id=ID COLON type=TYPE (ASSIGN expr=expression)?
    ;
