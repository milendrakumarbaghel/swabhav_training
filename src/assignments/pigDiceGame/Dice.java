package assignments.pigDiceGame;

import java.util.Random;

public class Dice {
    private static final int SIDES_ON_DIE = 6;
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(SIDES_ON_DIE) + 1;
    }
}
