#ifndef COLONY_H
#define COLONY_H

#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "math.h"
#include "string.h"
#include "Tactic.h"
#include "Production.h"


typedef struct 
{
    char symbol;
    int population;
    int foodStock;
    int wins;
    int status;
    int losses;
    Tactic* tactic;
    Procuction* production;
    
    

}Colony;



Colony new_Koloni();


#endif