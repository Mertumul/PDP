#include "BTactic.h"

int getRandomNumber2() {
    int randomNumber = rand() % 1000 + 1; // 1 ila 1000 arasında rastgele bir sayı üretilir
    return randomNumber;
}
int chooseRandom22() {

    int random_number = rand() % 2;  // 0 veya 1 arasında rastgele bir sayı oluştur

    return random_number;
}

BTactic new_BTactic(){
    srand(time(NULL)); // Rastgelelik için zamanı kullanarak tohumlama yapılır
    BTactic *this = (BTactic*)malloc(sizeof(BTactic));
    this->super2 = new_Tactic();
    this->super2.war = &war2;
}

void war2(Colony* colony1, Colony* colony2) {
    int koloniANum = getRandomNumber2();
    int koloniBNum = getRandomNumber2();
    int difference = abs(koloniANum - koloniBNum);
    printf("Difference: %d\n", difference);

    int caseValue = 0;

    if (koloniANum > koloniBNum) {
        caseValue = 1;
    } else if (koloniBNum > koloniANum) {
        caseValue = 2;
    } else {
        caseValue = 3;
    }

    switch (caseValue) {
        case 1: // koloniANum > koloniBNum
            colony2->population -= colony2->population * difference / 1000;
            colony1->foodStock += colony2->foodStock * difference / 1000;
            colony2->foodStock -= colony2->foodStock * difference / 1000;
            break;
        case 2: // koloniBNum > koloniANum
            colony1->population -= colony1->population * difference / 1000;
            colony2->foodStock += colony1->foodStock * difference / 1000;
            colony1->foodStock -= colony1->foodStock * difference / 1000;
            break;
        case 3: // koloniANum = koloniBNum
            if (colony1->population > colony2->population) {
                colony2->population -= colony2->population * difference / 1000;
                colony1->foodStock += colony2->foodStock * difference / 1000;
                colony2->foodStock -= colony2->foodStock * difference / 1000;
            } else if (colony2->population > colony1->population) {
                colony1->population -= colony1->population * difference / 1000;
                colony2->foodStock += colony1->foodStock * difference / 1000;
                colony1->foodStock -= colony1->foodStock * difference / 1000;
            } else {
                int random = chooseRandom22();
                if (random == 0) {
                    colony2->population -= colony2->population * difference / 1000;
                    colony1->foodStock += colony2->foodStock * difference / 1000;
                    colony2->foodStock -= colony2->foodStock * difference / 1000;
                } else if (random == 1) {
                    colony1->population -= colony1->population * difference / 1000;
                    colony2->foodStock += colony1->foodStock * difference / 1000;
                    colony1->foodStock -= colony1->foodStock * difference / 1000;
                } else {
                    printf("Invalid random value.\n");
                }
            }
            break;
        default:
            printf("Invalid case value.\n");
            break;
    }
}
