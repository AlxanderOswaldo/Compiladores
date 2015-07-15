package modello;
import java_cup.runtime.Symbol;

/*
Directivas:
public: clase publica
cup: compatibilidad con cup
full: extender el alfabeto con todos los valores de 8 bits
line: agrega la variable int yyline, para indicar la fila del lexema
char: agrega la variable int yychar, indica el indice del primer caracter del lexema
ignorecase: validar, indistitntamente si la letra es mayuscula o minuscula
eofval: especifica un valor de retorno al final del archivo
*/

%%


%cup
%full
%line
%column
%char
%public 
%eofval{
 fin=true;
return new Symbol(sym.EOF,new String("Fin del archivo"));
%eofval}
%{
public boolean fin=false;
public String lexema="";
public int linea;
public int columna;

public void imprime(){
    System.out.println(lexema);
}
%}
D = [0-9]
letra = [a-zA-Z]
id = {letra}({letra}|{D}|"_")*
espacio = \t|\f|" "|\r|\n
ENTERO = [+-]?{D}+
DECIMAL = [+-]?{D}+"."{D}*
CADENA = [a-zA-Z0-9_]*


%%
{espacio}	{}
"Programa"		{ lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.PROGRAMA,new token(yytext(),yyline,yycolumn));}
"Declaraciones"		{ lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DECLARACIONES, new token(yytext(),yyline,yycolumn));}
"Estructura"		{ lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.ESTRUCTURA, new token(yytext(),yyline,yycolumn));}
"Fin"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.FIN, new token(yytext(),yyline,yycolumn));}
"Imprimir"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.IMPRIMIR, new token(yytext(),yyline,yycolumn));}
"booleano"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.BOOLEANO, new token(yytext(),yyline,yycolumn));}
"vector"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.VECTOR, new token(yytext(),yyline,yycolumn));}
"si"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.SI, new token(yytext(),yyline,yycolumn));}
"mientras"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MIENTRAS, new token(yytext(),yyline,yycolumn));}
"desde"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DESDE, new token(yytext(),yyline,yycolumn));}
"parar"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.PARAR, new token(yytext(),yyline,yycolumn));}
"+"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MAS, new token(yytext(),yyline,yycolumn));}
"-"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MENOS, new token(yytext(),yyline,yycolumn));}
"*"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.POR, new token(yytext(),yyline,yycolumn));}
"/"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DIVIDENDO, new token(yytext(),yyline,yycolumn));}
"<"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MENOR, new token(yytext(),yyline,yycolumn));}
">"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MAYOR, new token(yytext(),yyline,yycolumn));}
"="                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.IGUAL, new token(yytext(),yyline,yycolumn));}
"<="                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MENORIG, new token(yytext(),yyline,yycolumn));}
">="                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.MAYORIG, new token(yytext(),yyline,yycolumn));}
"<>"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DISTINTO, new token(yytext(),yyline,yycolumn));}
"!"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.NO, new token(yytext(),yyline,yycolumn));}
"&"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.Y, new token(yytext(),yyline,yycolumn));}
"|"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.O, new token(yytext(),yyline,yycolumn));}
";"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.PCOMA, new token(yytext(),yyline,yycolumn));}
"entero"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.ENTERO, new token(yytext(),yyline,yycolumn));}
"decimal"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DECIMAL, new token(yytext(),yyline,yycolumn));}
"cadena"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.CADENA, new token(yytext(),yyline,yycolumn));}
"verdadero"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.VERDADERO, new token(yytext(),yyline,yycolumn));}
"falso"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.FALSO, new token(yytext(),yyline,yycolumn));}
","                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.COMA, new token(yytext(),yyline,yycolumn));}
"("                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.PARENA, new token(yytext(),yyline,yycolumn));}
")"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.PARENC, new token(yytext(),yyline,yycolumn));}
"Inicio"                   { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.INICIO, new token(yytext(),yyline,yycolumn));}
"Ciclo"         { lexema+="Token: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.CICLO, new token(yytext(),yyline,yycolumn));}


"'(CADENA)'"                   { lexema+="Cadena: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.DCADENA, new token(yytext(),yyline,yycolumn));}
{ENTERO}	{ lexema+="Entero: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.NENTERO, new token(yytext(),yyline,yycolumn));}
{DECIMAL}	{ lexema+="Decimal: "+(yytext()).toUpperCase()+"\n";  return new Symbol(sym.NDECIMAL, new token(yytext(),yyline,yycolumn));}
{id}		{ lexema+="ID: "+(yytext())+"\n";  return new Symbol(sym.ID, new token(yytext(),yyline,yycolumn));}


.			{ lexema+="Error Léxico : "+yytext()+ " en la linea "+(yyline+1)+" columna "+yycolumn+"\n";   return new Symbol(sym.error,new token(yytext(),yyline,yycolumn)); } 