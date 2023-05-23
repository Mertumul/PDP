#ifndef BTAKTIC_H
#define BTAKTIC_H
#include "Colony.h"
#include "Tactic.h"



typedef struct 
{
    Tactic super2;

}BTactic;

BTactic new_BTactic();
void war2(Colony*,Colony*);

#endif