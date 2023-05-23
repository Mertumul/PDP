#include "ATactic.h"



int getRandomNumber() {
    int randomNumber = rand() % 1000 + 1; // 1 ila 1000 arasında rastgele bir sayı üretilir
    return randomNumber;
}
int chooseRandom() {

    int random_number = rand() % 2;  // 0 veya 1 arasında rastgele bir sayı oluştur

    return random_number;
}

ATactic new_ATactic(){
    srand(time(NULL)); // Rastgelelik için zamanı kullanarak tohumlama yapılır
    ATactic *this = (ATactic*)malloc(sizeof(ATactic));
    this->super = new_Tactic();
    this->super.war = &war;
    this->super.hello = &hello;
    return *this;
}
void hello(){
    printf("Hello World");
}

void war(Colony* colony1,Colony* colony2){

    int koloniANum = getRandomNumber();
    int koloniBNum = getRandomNumber();
    int difference = abs(koloniANum-koloniBNum);
    if(koloniANum > koloniBNum){
        colony2->population -= colony2->population * difference/1000;
        colony1->foodStock +=colony2->foodStock * difference/1000;
        colony2->foodStock -=colony2->foodStock * difference/1000;    
        colony1->wins++;
        colony2->losses++;

        
    }
    else if(koloniBNum > koloniANum){
        colony1->population -= colony1->population * difference/1000;
        colony2->foodStock +=colony1->foodStock * difference/1000;
        colony1->foodStock -=colony1->foodStock * difference/1000;
        colony2->wins++;
        colony1->losses++;
    }
    //Gelen Sayılar eşit
    else
     {
        //Popülasyonu büyük olan kazanır
        if(colony1->population > colony2->population){
            colony2->population -= colony2->population * difference/1000;
            colony1->foodStock +=colony2->foodStock * difference/1000;
            colony2->foodStock -=colony2->foodStock * difference/1000;
            colony1->wins++;
            colony2->losses++;        
            

        }
        else if(colony2->population > colony1->population){

            colony1->population -= colony1->population * difference/1000;
            colony2->foodStock +=colony1->foodStock * difference/1000;
            colony1->foodStock -=colony1->foodStock * difference/1000;
            colony2->wins++;
            colony1->losses++;
        }
        //popülasyon eşit rastgele kazanan seçme
        else{
            int random = chooseRandom();
            //random 0 ise colony1 kazan
            if(random ==0){

            colony2->population -= colony2->population * difference/1000;
            colony1->foodStock +=colony2->foodStock * difference/1000;                
            colony2->foodStock -=colony2->foodStock * difference/1000;
            colony1->wins++;
            colony2->losses++;

            }
            //random 1 ise colony1 kazan

            else{

            colony1->population -= colony1->population * difference/1000;
            colony2->foodStock +=colony1->foodStock * difference/1000;                
            colony1->foodStock -=colony1->foodStock * difference/1000;
            colony2->wins++;
            colony1->losses++;

            }

        }



    }
        

}
