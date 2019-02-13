%{
#include<stdio.h>
#include"y.tab.h"
%}

%token DTYPE ID SEMI COMMA 
%%

Decl:DTYPE IDlist SEMI		{printf("VALID\n");}
IDlist:ID COMMA IDlist | ID	{printf("INTERMEDIATE\n");}
%%

void main(){
	
	extern FILE *yyin;
	yyin=fopen("Input.txt","r");
	yyparse();
}

int yyerror(char *s){
printf("ERROR=%s\n",s);
return 1;
}
