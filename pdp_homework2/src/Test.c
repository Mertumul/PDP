#include "Colony.h"
#include "Tactic.h"
#include "ATactic.h"
#include "BTactic.h"
#include "Production.h"
#include "AProduction.h"
#include "BProduction.h"
#include "Game.h"
#define MAX_SIZE 100
//rastgele sembol üretme
char generateRandomSymbol(char *symbols, int size) {
    char symbol;
    int isDuplicate;
    
    do {
        char specialCharacters[] = "!\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~©¢£¤¥§®«¬¶¿×±"; // Özel karakterlerin bulunduğu dizi
        int numSpecialCharacters = sizeof(specialCharacters) - 1; // Özel karakterlerin sayısı
        int randomIndex = rand() % numSpecialCharacters;
        symbol = specialCharacters[randomIndex];

        isDuplicate = 0;
        
        // Oluşturulan sembolün dizideki sembollerle eşleşip eşleşmediği kontrol edilir
        for (int i = 0; i < size; i++) {
            if (symbols[i] == symbol) {
                isDuplicate = 1;
                break;
            }
        }
    } while (isDuplicate); // Eğer sembol bir başka sembole eşitse tekrar sembol üretilir
    
    return symbol;
}

int main() {
  
    //Kullanıcının girdiği kodları saklayan dizi
    int arr[MAX_SIZE];
    //Rastgele üretilen sembolleri saklayan dizi
    char symbols[MAX_SIZE];

    int size = 0;
    char input[10];
    int number_of_Colonies = 0;

    srand(time(NULL));

    printf("Lutfen bosluklarla ayrilmis sayilari giriniz (Sayi girmeyi bitirmek icin q'ya basiniz):\n");
    
    // Kullanıcının girdiği kod  okunur ve diziye aktarılır
    while (size < MAX_SIZE) {
        if (scanf("%s", input) != 1) {
            break; // scanf hatası
        }
        if (strcmp(input, "q") == 0 || strcmp(input, "Q") == 0) {
            break; // Kullanıcı q harfine bastı
        }
        if (sscanf(input, "%d", &arr[size]) == 1) {
            //Aynı zamanda semboller dizisine de veri girdisi yapılır
            symbols[size]= generateRandomSymbol(symbols,size);
            size++; // Sayı başarıyla okundu
            number_of_Colonies++;
        }
    }
    printf("\n\nKoloni Sayisi: %d",number_of_Colonies);

    printf("\n\n");

    //Koloni için yer ayırır
    Colony* popArray = malloc(number_of_Colonies * sizeof(Colony));

     // Koloni değerlerini  atama
    for(int i = 0;i<number_of_Colonies;i++)
    {

        
        popArray[i].symbol = symbols[i];
        popArray[i].population = arr[i];
        popArray[i].foodStock = arr[i]*arr[i];
        popArray[i].status = 1 ;//Foksiyon Yaşıyor
        popArray[i].wins = 0 ;//Foksiyon Yaşıyor
        popArray[i].losses = 0 ;//Foksiyon Yaşıyor

        
    }
    simulateWar(popArray,size);

    return 0;
}
