package functionalInterface.function;

import java.util.function.Function;

public class StringLengthCalculator {
    static void main(String[] args) {
        Function<String, Integer> getLength = s -> s.length();

        String[] names = {"Ram", "Shyam", "Mohan"};

        for (String name : names) {
            System.out.println(name + " : " + getLength.apply(name));
        }
    }
}
