package assignments.numberGuesserGame;

import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInteger(String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value > 0) {
                    return value;
                }

                System.out.println("Number must be positive.");
            } else{
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
    }

    public String readYesNo(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.next();

            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")){
                return input;
            }

            System.out.println("Please type yes or no.");
        }
    }
}
