%{

%}

%%
#.*>  		{printf("%s: Header File \n",yytext);}
float|int 	{printf("%s: Data Type \n",yytext);}
[A-Za-z]+.*\)   {printf("%s: Function \n",yytext);}
[A-Za-z]	{printf("%s: Variable \n",yytext);}	
[0-9]+		{printf("%s: Value \n",yytext);}
=		{printf("%s: Assignment \n",yytext);}
;|\{|\}		{}
%%
/**/
void main()
{
	yyin=fopen("input.c","r");
	yylex();
	
	
	
}

int yywrap()
{
	return 1;
}
