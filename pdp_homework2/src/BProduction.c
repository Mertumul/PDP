#include "BProduction.h"
int chooseRandom4() {

    int random_number = rand() % 10+1;  // 0 veya 1 arasında rastgele bir sayı oluştur

    return random_number;
}

BProduction new_BProduction(){
    srand(time(NULL)); // Rastgelelik için zamanı kullanarak tohumlama yapılır
    BProduction *this = (BProduction*)malloc(sizeof(BProduction));
    this->super = new_Production();
    this->super.foodProduct = &foodProduct2;

    return *this;
}

void foodProduct2(Colony* colony){


    int num_of_Food = chooseRandom4();
    colony->foodStock +=num_of_Food;





}
