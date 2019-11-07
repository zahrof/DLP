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
  ILP_Object ilptmp7; 
{ 
  ILP_Object ilptmp8; 
ilptmp8 = ILP_Integer2ILP(15); 
ilptmp7 = (x = ilptmp8); 
} 
while ( 1 ) { 
  ILP_Object ilptmp9; 
{ 
  ILP_Object ilptmp10; 
  ILP_Object ilptmp11; 
ilptmp10 = x; 
ilptmp11 = ILP_Integer2ILP(0); 
ilptmp9 = ILP_GreaterThan(ilptmp10, ilptmp11);
} 
  if ( ILP_isEquivalentToTrue(ilptmp9) ) {
{ 
  ILP_Object ilptmp12; 
{ 
  ILP_Object ilptmp13; 
{ 
  ILP_Object ilptmp14; 
  ILP_Object ilptmp15; 
ilptmp14 = ILP_Integer2ILP(3); 
ilptmp15 = ILP_Integer2ILP(2); 
ilptmp13 = ILP_GreaterThan(ilptmp14, ilptmp15);
} 
  if ( ILP_isEquivalentToTrue(ilptmp13 ) ) {
{ 
  ILP_Object ilptmp16; 
{ 
  ILP_Object ilptmp17; 
  ILP_Object ilptmp18; 
ilptmp17 = ILP_Integer2ILP(4); 
ilptmp18 = ILP_Integer2ILP(5); 
ilptmp16 = ILP_GreaterThan(ilptmp17, ilptmp18);
} 
  if (! ILP_isEquivalentToTrue(ilptmp16 ) ) {
{ 
  ILP_Object ilptmp19; 
{ 
  ILP_Object ilptmp20; 
  ILP_Object ilptmp21; 
ilptmp20 = ILP_Integer2ILP(3); 
ilptmp21 = ILP_Integer2ILP(4); 
ilptmp19 = ILP_Plus(ilptmp20, ilptmp21);
} 
ilptmp12 = ILP_print(ilptmp19);
}

  }
}

  } else {
ilptmp12 = ILP_FALSE; 

  }
}
{ 
  ILP_Object ilptmp22; 
{ 
  ILP_Object ilptmp23; 
{ 
  ILP_Object ilptmp24; 
  ILP_Object ilptmp25; 
ilptmp24 = ILP_Integer2ILP(3); 
ilptmp25 = ILP_Integer2ILP(2); 
ilptmp23 = ILP_LessThan(ilptmp24, ilptmp25);
} 
  if (! ILP_isEquivalentToTrue(ilptmp23 ) ) {
{ 
  ILP_Object ilptmp26; 
  ILP_Object ilptmp27; 
ilptmp26 = x; 
ilptmp27 = ILP_Integer2ILP(1); 
ilptmp22 = ILP_Minus(ilptmp26, ilptmp27);
} 

  }
}
ilptmp12 = (x = ilptmp22); 
} 
(void)ilptmp12; 
} 

} else { 
    break; 

}
}
ilptmp7 = ILP_FALSE; 
return ilptmp7; 
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
