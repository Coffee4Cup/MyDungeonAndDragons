package D_D;

import D_D.MoveGenerator.MoveGenerator;
import D_D.MoveGenerator.TrueMove;
import D_D.RandomGenerator.RandomGenerator;
import D_D.RandomGenerator.TrueRandom;

public class Game {
    private RandomGenerator  random = new TrueRandom();//@TODO add the deterministic way
    private MoveGenerator moveGenerator = new TrueMove();//@TODO add the deterministic way

    public RandomGenerator getRandom() {
        return random;
    }

    public void setRandom(RandomGenerator random) {
        this.random = random;
    }
}
