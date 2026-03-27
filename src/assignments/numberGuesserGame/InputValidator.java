package assignments.numberGuesserGame;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInteger(String message) {
        while (true) {
            try {
                System.out.print(message);

                if (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    if (value > 0) {
                        return value;
                    }

                    System.out.println("Number must be positive.");
                } else {
                    System.out.println("Invalid input. Enter a number.");
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid number format. Please enter digits only.");
                scanner.next();
            } catch (NoSuchElementException e) {
                throw new IllegalStateException("Input stream ended unexpectedly.", e);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Input scanner is closed.", e);
            }
        }
    }

    public int readIntegerInRange(String message, int min, int max) {
        while (true) {
            int value = readInteger(message);
            if (value < min || value > max) {
                System.out.println("Enter a value between " + min + " and " + max + ".");
                continue;
            }
            return value;
        }
    }

    public String readYesNo(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();

                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                    return input;
                }

                System.out.println("Please type yes or no.");
            } catch (NoSuchElementException e) {
                throw new IllegalStateException("Input stream ended unexpectedly.", e);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Input scanner is closed.", e);
            }
        }
    }
}
