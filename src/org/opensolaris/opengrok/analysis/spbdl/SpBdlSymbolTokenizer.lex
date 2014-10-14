
package org.opensolaris.opengrok.analysis.spbdl;
import org.opensolaris.opengrok.analysis.JFlexTokenizer;

%%
%public
%class SpBdlSymbolTokenizer
%extends JFlexTokenizer
%init{
super(in);
%init}
%unicode
%type boolean
%eofval{
this.finalOffset =  zzEndRead;
return false;
%eofval}
%char

Identifier = [a-zA-Z_] [a-zA-Z0-9_]*

%state STRING COMMENT SCOMMENT QSTRING

%%

<YYINITIAL> {
{Identifier} {String id = yytext();
                if(!Consts.kwd.contains(id)){
                        setAttribs(id, yychar, yychar + yylength());
                        return true; }
              }
 \"     { yybegin(STRING); }
 \'     { yybegin(QSTRING); }
 "/*"   { yybegin(COMMENT); }
 "//"   { yybegin(SCOMMENT); }
}

<STRING> {
 \"     { yybegin(YYINITIAL); }
\\\\ | \\\"     {}
}

<QSTRING> {
 \'     { yybegin(YYINITIAL); }
}

<COMMENT> {
"*/"    { yybegin(YYINITIAL);}
}

<SCOMMENT> {
\n      { yybegin(YYINITIAL);}
}

<YYINITIAL, STRING, COMMENT, SCOMMENT, QSTRING> {
<<EOF>>   { this.finalOffset =  zzEndRead; return false;}
[^]    {}
}
