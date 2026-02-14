package loops;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesserGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String playAgain;

        do {
            int randomNumber = rand.nextInt(100) + 1;
            int guess;
            int maxAttempts = 5;
            boolean won = false;

            System.out.println("\nMaximum possible attempts:  " + maxAttempts);

            for (int i = 1; i <= maxAttempts; i++) {

                System.out.print("Guess a number: ");
                guess = scanner.nextInt();

                if (guess < randomNumber) {
                    System.out.println("Sorry, Too Low");
                } else if (guess > randomNumber) {
                    System.out.println("Sorry, Too High");
                } else {
                    System.out.println("You won in attempt: " + i);
                    won = true;
                    break;
                }

                if (i == maxAttempts) {
                    System.out.println("Game Over! The number was: " + randomNumber);
                }
            }

            System.out.print("Do you want to play the game again (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}