package assignments.pigDiceGame;

import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public char readChoice(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.next().toLowerCase();

            if (input.length() == 1) {
                char choice = input.charAt(0);

                if (choice == 'r' || choice == 'h') {
                    return choice;
                }
            }

            System.out.println("Invalid choice. Enter r (roll) or h (hold).");
        }
    }
}
