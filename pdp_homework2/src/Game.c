#include "Game.h"


Game new_Game(){
    Game* this;
    this = (Game*)malloc(sizeof(Game));

}

int ColonyStatusCollector(Colony colonies2[],int size){

    int total=0;

    for(int i=0;i<size;i++){

        total += colonies2[i].status;


    }
    return total;


}
void Warround(Colony colonies3[],int numofColony){

    for(int i=0;i<numofColony;i++){

         //Her turun sonunda popülasyon %20 artar
         colonies3[i].population +=(colonies3[i].population*2)/10;
        //her turun sonunda e Yemek stoğu (GüncelPopülasyon x 2) oranında azalır;
        if(colonies3[i].foodStock !=0)
            colonies3[i].foodStock -=colonies3[i].population*2;

        //Uretim yapısının Uret fonksiyonunu çağırarak döndürdükleri 1-10 arası tam sayı değerini yemek stoğuna eklerler
         foodProduct(&colonies3[i]);

        
    }

}

void setScreen(Colony colonies4[],int  koloniSayisi,int Tur){

    printf("Round: %d\n",Tur);
    printf("%-7s %-14s %-14s %-9s %s\n", "Koloni", "Populasyon", "Yemek Stogu", "Kazanma", "Kaybetme");

    for(int z=0;z<koloniSayisi;z++){
        
            
        

            printf("%-7c %-14d %-14d %-9d %d\n", colonies4[z].symbol, colonies4[z].population, colonies4[z].foodStock, colonies4[z].wins, colonies4[z].losses);

                }
    printf("\n---------------------------------------------------------------------------------------------------------------------------------------------------------\n");




}

void ColonyChecker(Colony* colony){

    if((colony->foodStock<=1)||(colony->population<=1)){

        colony->status =0;//Koloni öldü
        //deüerleri sıfırla
        colony->population = 0;
        colony->losses =0;
        colony->wins =0;
        colony->foodStock = 0;
    }
}



void simulateWar(Colony colonies[], int numColonies) {
    int Tur=0;

    while(1){
        int total =0;
        Tur++;


    for (int i = 0; i < numColonies; i++) {
        for (int j = i+1; j < numColonies; j++) {
            if (colonies[i].status == 1 && colonies[j].status == 1) {

                war(&colonies[i],&colonies[j]);
              
                ColonyChecker(&colonies[i]);
                ColonyChecker(&colonies[j]);

            }
            else 
                continue;
        }
    }
    Warround(colonies,numColonies);//her roundda gerekli ekleme işlemleri
    setScreen(colonies,numColonies,Tur);


    total = ColonyStatusCollector(colonies,numColonies);
    if(total ==1)
        break;
    }

}
