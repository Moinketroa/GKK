package plic.analyse ;

import java_cup.runtime.*;
import plic.exceptions.*;
import plic.tds.*;
      
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
statut = "publique" | "privee"
type = "entier"


idf = [a-zA-Z][a-zA-Z0-9\_]*

finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]

%state commentaire
commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]


%%

<YYINITIAL> "+"                	{ return symbol(CodesLexicaux.PLUS); }
<YYINITIAL> "-"                	{ return symbol(CodesLexicaux.MOINS); }
<YYINITIAL> "*"                	{ return symbol(CodesLexicaux.MULT); }
<YYINITIAL> "/"                	{ return symbol(CodesLexicaux.DIV); }

<YYINITIAL> "=="                { return symbol(CodesLexicaux.EGALEGAL); }
<YYINITIAL> "!="                { return symbol(CodesLexicaux.DIFF); }
<YYINITIAL> "<"                	{ return symbol(CodesLexicaux.INF); }
<YYINITIAL> ">"                	{ return symbol(CodesLexicaux.SUP); }

<YYINITIAL> "et"               	{ return symbol(CodesLexicaux.ET); }
<YYINITIAL> "ou"               	{ return symbol(CodesLexicaux.OU); }
<YYINITIAL> "non"              	{ return symbol(CodesLexicaux.NON); }

<YYINITIAL> "("                	{ return symbol(CodesLexicaux.PAROUV); }
<YYINITIAL> ")"                	{ return symbol(CodesLexicaux.PARFER); }

<YYINITIAL> "classe" 			{ return symbol(CodesLexicaux.MCCLASSE);}

<YYINITIAL> "fin"				{ return symbol(CodesLexicaux.FIN);}
<YYINITIAL> "="					{ return symbol(CodesLexicaux.EGAL);}
<YYINITIAL> "ecrire"			{ return symbol(CodesLexicaux.MCECRIRE);}
<YYINITIAL> ";"					{ return symbol(CodesLexicaux.POINTVIRGULE);}
<YYINITIAL> ","					{ return symbol(CodesLexicaux.VIRGULE);}
<YYINITIAL> {idf}			    { return symbol(CodesLexicaux.IDF,yytext());}
<YYINITIAL> {csteB}      	    { return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }
<YYINITIAL> {csteC}				{ return symbol(CodesLexicaux.CONSTANTECHAINE, yytext()); }
<YYINITIAL> {csteE}      	    { return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
<YYINITIAL> {type}				{ return symbol(CodesLexicaux.TYPE), yytext());}
<YYINITIAL> {statut}      	    { return symbol(CodesLexicaux.STATUT, yytext()); }



<YYINITIAL> {espace}                { }

<YYINITIAL> {commentaireSlashSlash} {}

<YYINITIAL> {commentaireSlashEtoile}	{ yybegin(commentaire) ; }

<commentaire> {commentaireEtoileSlash} 	{ yybegin(YYINITIAL) ; }


.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }
