package pdp3;
import java.util.Random;

public class AProduction extends Production {

    private int chooseRandom3() {
        Random random = new Random();
        int random_number = random.nextInt(5) + 1;
        return random_number;
    }

    public AProduction(String name){
        super("AProduction");
    }

    @Override
    public void foodProduct() {
    }

    @Override
    public void foodProduct(Colony colony){

        int num_of_Food =chooseRandom3();

        if(colony.getFoodStock() !=0)
            colony.increaseFood(num_of_Food);

    }


}
