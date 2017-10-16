
grammar PTNET;
/**/
@lexer::header{
	package ptnet.parser;
}

@lexer::members{
@Override
public Token emit() {
    switch (getType()) {
    case UNCLOSE_STRING:
        Token result = super.emit();
        throw new UncloseString(result.getText());

    case ILLEGAL_ESCAPE:
    	result = super.emit();
    	throw new IllegalEscape(result.getText());
    case ERROR_CHAR:
    	result = super.emit();
    	throw new ErrorToken(result.getText());
    default:
        return super.emit();
    }
}
}


@parser::header{
	package ptnet.parser;
}

options{
	language=Java;
} /**/


program: (varDec | constDec)+ funcDec*;

varDec: type ID ASSIGN constant SEMI;

constDec: CONST type ID ASSIGN constant SEMI;

type: INT | BOOLEAN | STRING | FLOAT;

constant: INTLIT | BOOLLIT | STRINGLIT | FLOATLIT;

funcDec: ID block ;

varLocal: type ID ASSIGN expr SEMI;

stmt: block | asnStmt | ifStmt | srcStmt ;
   block: LB varLocal* stmt* RB ;
   asnStmt: ID ASSIGN expr SEMI ;
   ifStmt: IF LP expr RP stmt (ELSE stmt)? ;
   srcStmt: SEARCH expr SEMI;

expr: buf1 (GT | GTE | LT | LTE) buf1 | buf1 ;
   buf1: buf2 (EQ | NE) buf2 | buf2 ;
   buf2: buf2 (AND | OR) buf3 | buf3 ;
   buf3: buf3 (ADD | SUB) buf4 | buf4 ;
   buf4: buf4 (MUL | DIV | MOD) buf5 | buf5 ;
   buf5: buf5 CON buf6 | buf6 ;
   buf6: NOT buf6 | buf7 ;
   buf7: (ADD | SUB) buf7 | buf8 ;
   buf8: LP expr RP | funcCall | ID | INTLIT | STRINGLIT | BOOLLIT | FLOATLIT ;

funcCall: ID LP expr (COMMA expr)* RP ;

	/* 	KEY WORD	*/

CONST: 'const';
ELSE: 'else' ;
IF: 'if' ;
THEN: 'then' ;
BOOLLIT: 'true' | 'false' ;
INT: 'int' ;
BOOLEAN: 'boolean' ;
STRING: 'string' ;
FLOAT: 'float' ;
SEARCH: 'search' ;

	/*	OPERATOR	*/

CON: '^' ;
ADD: '+' ;
SUB: '-' ;
MUL: '*' ;
DIV: '/' ;
MOD: '%' ;
GT: '>' ;
GTE: '>=' ;
LT: '<' ;
LTE : '<=' ;
EQ: '==' ;
NE: '!=' ;
OR: '||' ;
AND: '&&' ;
NOT: '!' ;
DOT: '.' ;
COMMA: ',' ;
LP: '(' ;
RP: ')' ;
LB: '{' ;
RB: '}' ;
LS: '[' ;
RS: ']' ;
COLON: ':' ;
SEMI: ';' ;
EQUAL: '==' ;
ASSIGN: '=' ;

	/*	ID	*/

ID: [A-Za-z_][A-Za-z0-9_]* ;

	/*   LITERAL	*/

INTLIT: [0-9]+ ;
FLOATLIT: [0-9]+('.'[0-9]* | [Ee][+-]?[0-9]+ | '.'[0-9]*[Ee][+-]?[0-9]+) ;
STRINGLIT: '"'('\\'[btnr"\\] | ~[\\\n"])*'"' ;

	/*    ERROR	*/

ILLEGAL_ESCAPE: '"'('\\'[btnr"\\] | ~[\\\n"])*('\\'|'\\'~[btnr"\\]);
UNCLOSE_STRING: '"'('\\'[btnr"\\] | ~[\\\n"])* ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

	/*	COMMENT		*/

LINE_COMMENT: '%%'.*?('\n'|EOF) -> skip ;
COMMENT: '/*'.*?'*/' -> skip ;

ERROR_CHAR: .;
