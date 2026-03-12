package assignments.numberGuesserGame;

import java.lang.classfile.attribute.LineNumberTableAttribute;
import java.util.Random;

public class NumberGenerator {
    private int min;
    private int  max;
    private Random random;
    public NumberGenerator(int min, int max) {
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
