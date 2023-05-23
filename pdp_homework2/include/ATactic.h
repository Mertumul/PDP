#ifndef ATAKTIC_H
#define ATAKTIC_H
#include "Colony.h"
#include "Tactic.h"



typedef struct 
{
    Tactic super;

}ATactic;

ATactic new_ATactic();
void war(Colony*,Colony*);
void hello();


#endif