package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

csteC = "\".*\""
csteE = [0-9]+
csteB = "vrai" | "faux"


idf = [a-zA-Z][a-zA-Z0-9\_]*

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%%

"+"                	{ return symbol(CodesLexicaux.PLUS); }
"-"                	{ return symbol(CodesLexicaux.MOINS); }
"*"                	{ return symbol(CodesLexicaux.MULT); }
"/"                	{ return symbol(CodesLexicaux.DIV); }

"=="                    { return symbol(CodesLexicaux.EGALEGAL); }
"!="                    { return symbol(CodesLexicaux.DIFF); }
"<"                	{ return symbol(CodesLexicaux.INF); }
">"                	{ return symbol(CodesLexicaux.SUP); }

"et"                	{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"                	{ return symbol(CodesLexicaux.NON); }

"("                	{ return symbol(CodesLexicaux.PAROUV); }
")"                	{ return symbol(CodesLexicaux.PARFER); }

"classe" 			{ return symbol(CodesLexicaux.MCCLASSE);}
"publique"			{ return symbol(CodesLexicaux.PUBLIQUE);}
"privee"			{ return symbol(CodesLexicaux.PRIVEE);}
"entier"			{  return symbol(CodesLexicaux.ENTIER);}
"debut"				{ return symbol(CodesLexicaux.DEBUT);}
"fin"				{  return symbol(CodesLexicaux.FIN);}
"="					{  return symbol(CodesLexicaux.EGAL);}
"ecrire"			{ return symbol(CodesLexicaux.MCECRIRE);}
";"					{ return symbol(CodesLexicaux.POINTVIRGULE);}
","					{ return symbol(CodesLexicaux.VIRGULE);}
{idf}			    { return symbol(CodesLexicaux.IDF,yytext());}
{csteC}				{ return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()); }
{csteE}      	    { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	    { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }

{espace}                { }



.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
