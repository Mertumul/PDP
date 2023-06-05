package pdp3;
import java.util.Random;
import java.lang.Math;
public class ATactic extends Tactic {

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(500) + 1;
    }

    private int chooseRandom() {
        Random random = new Random();
        return random.nextInt(2);
    }

    public ATactic(String name) {
        super("ATACTIC");
    }

    @Override
    public void war() {

    }
    @Override
    public void war(Colony colony1, Colony colony2) {
        int colony1Num = getRandomNumber();
        int colony2Num = getRandomNumber();
        int difference = Math.abs(colony1Num-colony2Num);
        if(colony1Num > colony2Num){

            colony2.decreasePopulation(colony2.getPopulation()*difference/1000);
            colony1.increaseFood(colony2.getFoodStock()*difference/1000);
            colony2.decreaseFood(colony2.getFoodStock()*difference/1000);
            colony1.setWins(colony1.getWins()+1);
            colony2.setLosses(colony2.getLosses()+1);
        }
        else if (colony2Num >colony1Num){
            colony1.decreasePopulation(colony1.getPopulation()*difference/1000);
            colony2.increaseFood(colony1.getFoodStock()*difference/1000);
            colony1.decreaseFood(colony1.getFoodStock()*difference/1000);

            colony2.setWins(colony2.getWins()+1);
            colony1.setLosses(colony1.getLosses()+1);
        }
        else{
            if(colony1.getPopulation() > colony2.getPopulation()){
                colony2.decreasePopulation(colony2.getPopulation()*difference/1000);
                colony1.increaseFood(colony2.getFoodStock()*difference/1000);
                colony2.decreaseFood(colony2.getFoodStock()*difference/1000);
                colony1.setWins(colony1.getWins()+1);
                colony2.setLosses(colony2.getLosses()+1);  }
            else if (colony2.getPopulation() > colony1.getPopulation()) {
                colony1.decreasePopulation(colony1.getPopulation()*difference/1000);
                colony2.increaseFood(colony1.getFoodStock()*difference/1000);
                colony1.decreaseFood(colony1.getFoodStock()*difference/1000);
                colony2.setWins(colony2.getWins()+1);
                colony1.setLosses(colony1.getLosses()+1);
            }
            else{
                int random = chooseRandom();
                if(random ==0){
                    colony2.decreasePopulation(colony2.getPopulation()*difference/1000);
                    colony1.increaseFood(colony2.getFoodStock()*difference/1000);
                    colony2.decreaseFood(colony2.getFoodStock()*difference/1000);
                    colony1.setWins(colony1.getWins()+1);
                    colony2.setLosses(colony2.getLosses()+1);
                }
                else{
                    colony1.decreasePopulation(colony1.getPopulation()*difference/1000);
                    colony2.increaseFood(colony1.getFoodStock()*difference/1000);
                    colony1.decreaseFood(colony1.getFoodStock()*difference/1000);
                    colony2.setWins(colony2.getWins()+1);
                    colony1.setLosses(colony1.getLosses()+1);
                }
            }
        }

    }
}