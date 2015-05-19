package modelo;
import java_cup.runtime.*;;
%%

%public
%class Lexico
%unicode
%line
%column
%cup
%cupdebug

/* floating point literals */        
Entero  = {FLit3} {Exponent}? 
Decimal = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [+-]? [0-9]+ \. [0-9]* 
FLit2    = [+-]? \. [0-9]+ 
FLit3    = [+-]? [0-9]+ 
Exponent = [eE] [+-]? [0-9]+


/* identificadores */
Identificador = ({L}|[_$])({L}|{D}|[_$])*

L = [a-zA-Z_]
D = [0-9]


/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"


/* string */
Cadena = \" [^] \"


%%

/* comments */
  {Comment}                      { /* ignore */ }

/* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  "public"                       { lexema = lexema+"PUBLIC \n"; return new Symbol(sym.PUBLIC); }
  "class"                        { lexema = lexema+"CLASS \n"; return new Symbol(sym.CLASS); }
  "static"                       { lexema = lexema+"STATIC \n"; return new Symbol(sym.STATIC); }
  "void"                         { lexema = lexema+"VOID \n"; return new Symbol(sym.VOID); }
  "main"                         { lexema = lexema+"MAIN \n"; return new Symbol(sym.MAIN); }
    
  "int"                          { lexema = lexema+"INT \n"; return new Symbol(sym.INT); }
  "double"                       { lexema = lexema+"DOUBLE \n"; return new Symbol(sym.DOUBLE); }
  "String"                       { lexema = lexema+"STRING \n"; return new Symbol(sym.STRING); }

  "if"                           { lexema = lexema+"IF \n"; return new Symbol(sym.IF); }
  "else"                         { lexema = lexema+"ELSE \n"; return new Symbol(sym.ELSE); }
  "for"                          { lexema = lexema+"FOR \n"; return new Symbol(sym.FOR); }
  "while"                        { lexema = lexema+"WHILE \n"; return new Symbol(sym.WHILE); }

/* separators */
  "("                            { lexema = lexema+"PABIERTO \n"; return new Symbol(sym.PABIERTO); }
  ")"                            { lexema = lexema+"PCERRADO \n"; return new Symbol(sym.PCERRADO); }
  "{"                            { lexema = lexema+"LABIERTA \n"; return new Symbol(sym.LABIERTA); }
  "}"                            { lexema = lexema+"LCERRADA \n"; return new Symbol(sym.LCERRADA); }
  "[]"                           { lexema = lexema+"CORCHETES \n"; return new Symbol(sym.CORCHETES); }
  ";"                            { lexema = lexema+"PUNTOCOMA \n"; return new Symbol(sym.PUNTOCOMA); }
  ","                            { lexema = lexema+"COMA \n"; return new Symbol(sym.COMA); }
  
/* operators */
  "="                            { lexema = lexema+"ASIGNACION \n"; return new Symbol(sym.ASIGNACION); }
  ">"                            { lexema = lexema+"MAYOR \n"; return new Symbol(sym.MAYOR); }
  "<"                            { lexema = lexema+"MENOR \n"; return new Symbol(sym.MENOR); }
  "!"                            { lexema = lexema+"OPUESTO \n"; return new Symbol(sym.OPUESTO); }
  "=="                           { lexema = lexema+"IGUAL \n"; return new Symbol(sym.IGUAL); }
  "<="                           { lexema = lexema+"MENORIGUAL \n"; return new Symbol(sym.MENORIGUAL); }
  ">="                           { lexema = lexema+"MAYORIGUAL \n"; return new Symbol(sym.MAYORIGUAL); }
  "!="                           { lexema = lexema+"DIFERENTE \n"; return new Symbol(sym.DIFERENTE); }
  "&&"                           { lexema = lexema+"Y \n"; return new Symbol(sym.Y); }
  "||"                           { lexema = lexema+"O \n"; return new Symbol(sym.O); }
  "++"                           { lexema = lexema+"INCREMENTO \n"; return new Symbol(sym.INCREMENTO); }
  "--"                           { lexema = lexema+"DISMINUCION \n"; return new Symbol(sym.DISMINUCION); }
  "+"                            { lexema = lexema+"MAS \n"; return new Symbol(sym.MAS); }
  "-"                            { lexema = lexema+"MENOS \n"; return new Symbol(sym.MENOS); }
  "*"                            { lexema = lexema+"MULTIPLICACION \n"; return new Symbol(sym.MULTIPLICACION); }
  "/"                            { lexema = lexema+"DIVISION \n"; return new Symbol(sym.DIVISION); }
  "+="                           { lexema = lexema+"MASIGUAL \n"; return new Symbol(sym.MASIGUAL); }
  "-="                           { lexema = lexema+"MENOSIGUAL \n"; return new Symbol(sym.MENOSIGUAL); }


{Decimal}                        { lexema = lexema+"DECIMAL"+yytext()+"\n"; return new Symbol(sym.DECIMAL, new Double(yytext())); }
{Entero}                         { lexema = lexema+"ENTERO"+yytext()+"\n"; return new Symbol(sym.ENTERO, new Integer(yytext())); }
{Cadena}                         { lexema = lexema+"CADENA"+yytext()+"\n"; return new Symbol(sym.CADENA, new String(yytext())); }
{Identificador}                  { lexema = lexema+"IDENTIFICADOR"+yytext()+"\n"; return new Symbol(sym.IDENTIFICADOR, yytext()); }


. { lexema = lexema+"ERROR LEXICO"+yytext()+"\n"; }


