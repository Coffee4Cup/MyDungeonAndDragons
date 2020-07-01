package D_D;

import D_D.MoveGenerator.ActionReader;
import D_D.MoveGenerator.TrueAction;
import D_D.RandomGenerator.RandomGenerator;
import D_D.RandomGenerator.TrueRandom;

public class Game {
    private RandomGenerator  random = new TrueRandom();//@TODO add the deterministic way
    private ActionReader actionReader = new TrueAction();//@TODO add the deterministic way

    public RandomGenerator getRandom() {
        return random;
    }

    public void setRandom(RandomGenerator random) {
        this.random = random;
    }
}
