#include "Tactic.h"

Tactic new_Tactic(){

Tactic* this;
this = (Tactic*)malloc(sizeof(Tactic));
return *this;
}