package pdp3;
import java.lang.String;

public class Game {

     int ColonyStatusCollector(Colony[] colonies) {
        int total = 0;
        for (Colony colony : colonies) {
            total += colony.getStatus();
        }
        return total;
    }

     void Warround(Colony[] colonies, int numofColony) {
        for (Colony colony : colonies) {
            colony.increasePopulation(colony.getPopulation()*2/10);
            colony.decreaseFood(colony.getPopulation()*2);
            colony.production.foodProduct(colony);

        }
    }

    void setScreen(Colony colonies4[], int koloniSayisi, int Tur) {
        System.out.println("Round: " + Tur);
        System.out.printf("%-7s %-14s %-14s %-9s %s\n", "Koloni", "Populasyon", "Yemek Stogu", "Kazanma", "Kaybetme");

        for (int z = 0; z < koloniSayisi; z++) {
            String population = colonies4[z].getPopulation() == 0 ? "--" : String.valueOf(colonies4[z].getPopulation());
            String foodStock = colonies4[z].getFoodStock() == 0 ? "--" : String.valueOf(colonies4[z].getFoodStock());
            String wins = colonies4[z].getWins() == 0 ? "--" : String.valueOf(colonies4[z].getWins());
            String losses = colonies4[z].getLosses() == 0 ? "--" : String.valueOf(colonies4[z].getLosses());

            String formattedLine = String.format("%-7c %-14s %-14s %-9s %s\n", colonies4[z].getSymbol(), population, foodStock, wins, losses);
            System.out.print(formattedLine);
        }

        System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------\n");
    }



    void ColonyChecker(Colony colony) {
        if (colony.getFoodStock() < 4 || colony.getPopulation() < 3) {
            colony.setStatus(0);
            colony.setPopulation(0);
            colony.setLosses(0);
            colony.setWins(0);
            colony.setFoodStock(0);
        }
    }

    public  void simulateWar(Colony[] colonies, int numColonies) {
        int Tur = 0;

        while (true) {
            int total = 0;
            Tur++;

            for (int i = 0; i < numColonies; i++) {
                for (int j = i + 1; j < numColonies; j++) {
                    ColonyChecker(colonies[i]);
                    ColonyChecker(colonies[j]);
                    if (colonies[i].getStatus() == 1 && colonies[j].getStatus() == 1) {
                        //rastgele taktik ile savaşma
                        colonies[i].tactic.war(colonies[i],colonies[j]);
                        ColonyChecker(colonies[i]);
                        ColonyChecker(colonies[j]);
                    } else {
                        ColonyChecker(colonies[i]);
                        ColonyChecker(colonies[j]);
                        continue;
                    }
                }
            }

            Warround(colonies, numColonies);
            setScreen(colonies, numColonies, Tur);

            total = ColonyStatusCollector(colonies);
            if (total == 1 || total ==0) {
                break;
            }
        }
    }

}
