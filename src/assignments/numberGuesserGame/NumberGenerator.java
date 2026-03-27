package assignments.numberGuesserGame;

import java.util.Random;

public class NumberGenerator {
    private int min;
    private int  max;
    private Random random;

    public NumberGenerator(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Minimum range must be less than maximum range.");
        }
        this.min=min;
        this.max=max;
        this.random= new Random();
    }

    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }

    public int generateNumber() {
        return random.nextInt(max-min+1)+min;
    }
}
