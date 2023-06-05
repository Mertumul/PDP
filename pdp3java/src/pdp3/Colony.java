package pdp3;
import java.util.Random;

public class Colony {

    private char symbol;
    private int population;
    private int foodStock;
    private int wins;
    private int status;
    private int losses;

    public Tactic tactic;

    public  Production production;

    public Colony(){
        this.foodStock = 0;
        this.wins = 0;
        this.losses = 0;
        this.status = 1;
        this.population =0;
        this.symbol = ' ';
        this.tactic = getRandomTaktik();
        this.production = getRandomProduction();
    }

    public int getFoodStock(){return foodStock;}
    public void setFoodStock(int foodStock1){this.foodStock =foodStock1;}

    public void increaseFood(int foodStock){this.foodStock += foodStock;}
    public void decreaseFood(int foodStock){this.foodStock -=foodStock;}

//Burada kazanmlar icin get() ve  set() methodu yazdım.
    public int getWins(){return wins;};
    public void setWins(int wins1){this.wins = wins1;}
//Burada kaybetmeler icin get() ve  set() methodu yazdım.
    public int getLosses(){return losses;};
    public void setLosses(int losses1){this.losses =losses1;}
//   Burada status icin get() ve  set() methodu yazdım.(status koloninin ölü olup olmadığına bakıyor)
    public  int getStatus(){return status;}
    public void setStatus(int status1){this.status = status1;}

//   Burada popülasyon için set() get() methodu yazdım;
    public  int getPopulation(){return  population;}
    public  void setPopulation(int population1){this.population  = population1;}

    public void increasePopulation(int population){this.population += population;}
    public void decreasePopulation(int population){this.population -=population;}

//   Burada sembol için set() get() methodları yazdım;

    public  char getSymbol(){return symbol;}
    public void setSymbol(char symbol1){this.symbol = symbol1;
    }
//Rastgele taktik secme
private static Tactic getRandomTaktik() {
    Random random = new Random();
    int randomTaktik = random.nextInt(2);

    switch (randomTaktik) {
        case 0:
            return new ATactic("ATactic");
        case 1:
            return new BTactic("Btactic");

        default:
            return null;
    }
}

private  static  Production getRandomProduction(){
    Random random = new Random();
    int randomProction = random.nextInt(2);
    switch (randomProction){
        case 0:
            return new AProduction("AProduction");
        case 1:
            return new BProduction("BProduction");

        default:
            return null;
    }



}

}




