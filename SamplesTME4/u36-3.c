#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object print;
ILP_Object x;

/* Global prototypes */ 

/* Global functions */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp1; 
{ 
  ILP_Object ilptmp2; 
ilptmp2 = ILP_Integer2ILP(10); 
ilptmp1 = (x = ilptmp2); 
} 
{ 
  ILP_Object ilptmp3; 
{ 
  ILP_Object ilptmp4; 
  ILP_Object ilptmp5; 
ilptmp4 = x; 
ilptmp5 = ILP_Integer2ILP(0); 
ilptmp3 = ILP_LessThan(ilptmp4, ilptmp5);
} 
  if (! ILP_isEquivalentToTrue(ilptmp3 ) ) {
{ 
  ILP_Object ilptmp6; 
ilptmp6 =  ILP_String2ILP("a is bigger than 0"); 
ilptmp1 = ILP_print(ilptmp6);
}

  }
}
return ilptmp1; 
} 

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
