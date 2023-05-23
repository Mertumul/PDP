#ifndef TAKTIC_H
#define TAKTIC_H

#include "stdio.h"
#include "stdlib.h"
#include "time.h"
#include "math.h"
#include "string.h"

typedef struct 
{
    char* tacticName;
    void (*war)();
    void (*hello)();

}Tactic;

Tactic new_Tactic();

#endif