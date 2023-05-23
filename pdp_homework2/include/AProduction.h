#ifndef APRODUCTION_H
#define APRODUCTION_H
#include "Colony.h"
#include "Production.h"



typedef struct 
{
    Procuction super;

}AProduction;

AProduction new_AProduction();
void foodProduct(Colony*);

#endif