package D_D.RandomGenerator;

import java.util.Random;

public class TrueRandom implements RandomGenerator {

    Random random;

    public TrueRandom() {
        random = new Random();
    }

    @Override
    public int nextInt(int n) {
        return random.nextInt(n);
    }
}
