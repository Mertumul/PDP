#ifndef GAME_H
#define GAME_H
#include "Colony.h"
#include "ATactic.h"
#include "AProduction.h"



typedef struct 
{
    Procuction super;

}Game;

Game new_Game();
void ColonyChecker(Colony*);
int ColonyStatusCollector(Colony colonies2[],int);
void simulateWar(Colony colonies[], int);
void Warround(Colony colonies3[],int);
void setScreen(Colony colonies4[],int,int);

#endif