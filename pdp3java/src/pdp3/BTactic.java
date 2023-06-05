package pdp3;

import java.util.Random;

public class BTactic extends  Tactic {

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(500) + 500;
    }

    private int chooseRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public BTactic(String name) {
        super("BTACTIC");
    }

    @Override
    public void war() {

    }
    @Override
    public void war(Colony colony1, Colony colony2) {
        int colony1Num = getRandomNumber();
        int colony2Num = getRandomNumber();
        int difference = Math.abs(colony1Num-colony2Num);


        int caseValue = 0;
        if (colony1Num > colony2Num) {
            caseValue = 1;
        } else if (colony2Num > colony1Num) {
            caseValue = 2;
        } else {
            if (colony1.getPopulation() > colony2.getPopulation()) {
                caseValue = 3;
            } else if (colony2.getPopulation() > colony1.getPopulation()) {
                caseValue = 4;
            } else {
                caseValue = 5;
            }
        }

        // Durum değerine göre işlemleri gerçekleştirme
        switch (caseValue) {
            case 1:
                colony2.decreasePopulation(colony2.getPopulation() * difference / 1000);
                colony1.increaseFood(colony2.getFoodStock() * difference / 1000);
                colony2.decreaseFood(colony2.getFoodStock() * difference / 1000);
                colony1.setWins(colony1.getWins() + 1);
                colony2.setLosses(colony2.getLosses() + 1);
                break;
            case 2:
                colony1.decreasePopulation(colony1.getPopulation() * difference / 1000);
                colony2.increaseFood(colony1.getFoodStock() * difference / 1000);
                colony1.decreaseFood(colony1.getFoodStock() * difference / 1000);
                colony2.setWins(colony2.getWins() + 1);
                colony1.setLosses(colony1.getLosses() + 1);
                break;
            case 3:
                colony2.decreasePopulation(colony2.getPopulation() * difference / 1000);
                colony1.increaseFood(colony2.getFoodStock() * difference / 1000);
                colony2.decreaseFood(colony2.getFoodStock() * difference / 1000);
                colony1.setWins(colony1.getWins() + 1);
                colony2.setLosses(colony2.getLosses() +1);
                break;
            case 4:
                colony1.decreasePopulation(colony1.getPopulation() * difference / 1000);
                colony2.increaseFood(colony1.getFoodStock() * difference / 1000);
                colony1.decreaseFood(colony1.getFoodStock() * difference / 1000);
                colony2.setWins(colony2.getWins() + 1);
                colony1.setLosses(colony1.getLosses() + 1);
                break;
            case 5:
                int random = chooseRandom();
                if (random == 0) {
                    colony2.decreasePopulation(colony2.getPopulation() * difference / 1000);
                    colony1.increaseFood(colony2.getFoodStock() * difference / 1000);
                    colony2.decreaseFood(colony2.getFoodStock() * difference / 1000);
                    colony1.setWins(colony1.getWins() + 1);
                    colony2.setLosses(colony2.getLosses() + 1);
                } else {
                    colony1.decreasePopulation(colony1.getPopulation() * difference / 1000);
                    colony2.increaseFood(colony1.getFoodStock() * difference / 1000);
                    colony1.decreaseFood(colony1.getFoodStock() * difference / 1000);
                    colony2.setWins(colony2.getWins() + 1);
                    colony1.setLosses(colony1.getLosses() + 1);
                }
                break;
            default:
                break;
        }
    }
}
