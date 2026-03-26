package functionalInterface.supplier;

import java.util.function.Supplier;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random();

        for (int i = 0; i < 5; i++) {
            System.out.println(randomSupplier.get());
        }
    }
}
