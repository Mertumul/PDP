#ifndef BPRODUCTION_H
#define BPRODUCTION_H
#include "Colony.h"
#include "Production.h"



typedef struct 
{
    Procuction super;

}BProduction;

BProduction new_BProduction();
void foodProduct2(Colony*);

#endif