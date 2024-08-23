lexer grammar CoolLexer;

@header{
    package cool.lexer;	
}

@members{
    private void raiseError(String msg) {
        setText(msg);
        setType(ERROR);
    }

    // Functie pentru procesarea unui token string
    private void stringProcessing(){

        // Caz in care string-ul e gol
        if(getText().length()==2) {
            setText("");
            return;
        }

        // Stergerea ghilimelelor
        String initialString = getText().substring(1,getText().length()-1);

        // Verificare caracter NULL
        if(initialString.contains("\u0000")){
            raiseError("String contains null character");
            return;
        }

        // Inlocuire \t , \n, \b si \f
        StringBuffer newString = new StringBuffer();
        for(int i = 0; i < initialString.length(); ++i) {
        	if(initialString.charAt(i) == '\\')
        	    {
        	        switch(initialString.charAt(i+1)){
                        case 'n': newString.append('\n');    break;
                        case 't': newString.append('\t');    break;
                        case 'b': newString.append('\b');    break;
                        case 'f': newString.append('\f');    break;
                        default : newString.append(initialString.charAt(i+1));
                        }
                    i++;
                }
        	else
        	    newString.append(initialString.charAt(i));

        if(newString.length() > 1024){
           raiseError("String constant too long");
           return;
        }

        setText(newString.toString());
        }
    }
}

CLASS: 'class';
INHERITS: 'inherits';

BOOL : 'true' | 'false';

// Keywords independente
NOT : 'not';
ISVOID : 'isvoid';
NEW : 'new';

// Keywords let
LET : 'let';
IN: 'in';

// Keywords If
IF: 'if';
THEN: 'then';
ELSE: 'else';
FI: 'fi';

// Keywords While
WHILE: 'while';
LOOP: 'loop';
POOL: 'pool';

// Keywords Case
CASE: 'case';
OF: 'of';
ESAC: 'esac';

// Numere
fragment DIGIT : [0-9];
INT : '0' | ([1-9] DIGIT*);

// Litere, id, type
fragment LETTER: [a-zA-Z];
fragment LETTER_LOWER : [a-z];
fragment LETTER_UPPER : [A-Z];
TYPE: LETTER_UPPER (LETTER| '_' | DIGIT)*;
ID: LETTER_LOWER (LETTER | '_' | DIGIT)*;

// Operatori
ASSIGN : '<-';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
LT : '<';
LE : '<=';
EQUAL: '=';
NOTSYMB: '~';
RESULT: '=>';

// Paranteze si simboluri
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
SEMI: ';';
COLON: ':';
COMMA: ',';
DISPATCH: '@';
DOT: '.';

// Sir de caractere - cu verificari EOF si \n
STRING : '"'  .*?
            ('"'{ stringProcessing();} |
             EOF { raiseError("EOF in string constant");} |
             '\n ' {raiseError("Unterminated string constant");});

// Comentariu block corect de forma (* (* ... *) *) (matching enclosing parantheses)
BLOCK_COMMENT_OK
    : '(*'
      (BLOCK_COMMENT_OK | .)*?
      '*)' ->skip
    ;

// Comentariu block gresit de forma (* (* ... *) (nu avem matching enclosing parantheses)
BLOCK_COMMENT_ERROR
    : '(*'
      (BLOCK_COMMENT_ERROR | .)*?
      ('*)' | EOF { raiseError("EOF in comment"); })
    ;

// Comentariu gresit de forma *) ....
WRONG_COMMENT: '*)' { raiseError("Unmatched *)"); };

// Comentariu pe o linie
LINE_COMMENT: '--' .*?'\n'->skip;

// Spații albe.
WS
    :   [ \n\f\r\t]+ -> skip
    ;

ERROR: . { raiseError("Invalid character: " + getText());};