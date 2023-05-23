#include "AProduction.h"
int chooseRandom3() {

    int random_number = rand() % 10+1;  // 0 veya 1 arasında rastgele bir sayı oluştur

    return random_number;
}

AProduction new_AProduction(){
    srand(time(NULL)); // Rastgelelik için zamanı kullanarak tohumlama yapılır
    AProduction *this = (AProduction*)malloc(sizeof(AProduction));
    this->super = new_Production();
    this->super.foodProduct = &foodProduct;

    return *this;
}

void foodProduct(Colony* colony){


    int num_of_Food = chooseRandom3();

    if(colony->foodStock !=0)
        colony->foodStock +=num_of_Food;





}
