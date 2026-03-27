package assignments.pigDiceGame;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        this.scanner = scanner;
    }

    public char readChoice(String message) {
        while (true) {
            try {
                System.out.print(message);
                
                if (!scanner.hasNext()) {
                    throw new NoSuchElementException("No input available from scanner.");
                }
                
                String input = scanner.next().toLowerCase();
                
                if (input.length() == 1) {
                    char choice = input.charAt(0);
                    
                    if (choice == 'r' || choice == 'h') {
                        return choice;
                    }
                }
                
                System.out.println("Invalid choice. Please enter 'r' (roll) or 'h' (hold).\n");
                
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException("Input stream ended unexpectedly.", e);
            } catch (IllegalStateException e) {
                throw new IllegalStateException("Scanner is closed or unavailable.", e);
            }
        }
    }
}
