package functionalInterface.consumer;

import java.util.Scanner;
import java.util.function.Consumer;

public class PrintStringInUppercase {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> toUpper = s -> System.out.println(s.toUpperCase());

        System.out.println("Enter string: ");
        String string = scanner.nextLine();

        toUpper.accept(string);
//        toUpper.accept("lambda");
//        toUpper.accept("consumer");
    }
}
