package pdp3;
import java.util.Random;
import java.util.Scanner;


public class Program {
    private static final int MAX_SIZE = 100;

   private static char generateRandomSymbol(char[] symbols, int size) {
        char symbol;
        int isDuplicate;

        do {
            char[] specialCharacters = "!\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~©¢£¤¥§®«¬¶¿×±".toCharArray(); // Özel karakterlerin bulunduğu diziyi karakter dizisine dönüştürür
            int numSpecialCharacters = specialCharacters.length; // Özel karakterlerin sayısı
            int randomIndex = new Random().nextInt(numSpecialCharacters);
            symbol = specialCharacters[randomIndex];

            isDuplicate = 0;

            // Oluşturulan sembolün dizideki sembollerle eşleşip eşleşmediği kontrol edilir
            for (int i = 0; i < size; i++) {
                if (symbols[i] == symbol) {
                    isDuplicate = 1;
                    break;
                }
            }
        } while (isDuplicate == 1); // Eğer sembol bir başka sembole eşitse tekrar sembol üretilir

        return symbol;
    }
    public static void main(String[] args){
        int[] arr = new int[MAX_SIZE]; // Kullanıcının girdiği kodları saklayan dizi
        char[] symbols = new char[MAX_SIZE]; // Rastgele üretilen sembolleri saklayan dizi
        int size = 0;
        String input;
        int number_of_Colonies = 0;
        System.out.println("Lutfen bosluklarla ayrilmis sayilari giriniz (Sayi girmeyi bitirmek icin q'ya basiniz):");
        System.out.println("Ornek kullanim < 12 54 65 45 78 q>");


        try (Scanner scanner = new Scanner(System.in)) {
            while (size < MAX_SIZE) {
                input = scanner.next();
                if (input.equals("q") || input.equals("Q")) {
                    break; // Kullanıcı q harfine bastı
                }
                try {
                    arr[size] = Integer.parseInt(input);
                    symbols[size] = generateRandomSymbol(symbols, size);
                    size++; // Sayı başarıyla okundu
                    number_of_Colonies++;
                } catch (NumberFormatException e) {
                    // Geçersiz giriş1
                    System.out.println("Hatalı giriş. Lütfen sayı veya 'q' girin.");
                }
            }
        }
        System.out.println("\n\nKoloni Sayisi: " + number_of_Colonies);

        Colony[] colonies = new Colony[number_of_Colonies];

        for(int i = 0; i<number_of_Colonies; i++){
            colonies[i] = new Colony();
            colonies[i].setSymbol(symbols[i]);
            colonies[i].setPopulation(arr[i]);
            colonies[i].setFoodStock(arr[i]*arr[i]);
        }

        Game game = new Game();
        game.simulateWar(colonies,number_of_Colonies);





    }

}
