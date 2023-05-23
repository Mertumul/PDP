#ifndef PRODUCTION_H
#define PRODUCTION_H


#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "math.h"
#include "string.h"

typedef struct 
{
    char* productionName;
    void (*foodProduct)();

   

}Procuction;

Procuction new_Production();







#endif