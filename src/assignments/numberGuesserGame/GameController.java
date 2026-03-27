package assignments.numberGuesserGame;

import java.util.Scanner;

public class GameController {
    private NumberGenerator generator;
    private GuessEvaluator evaluator;
    private InputValidator input;
    private Scanner scanner;
    private int maxAttempts;

    public GameController() {
        System.out.println("Number Guesser game started");
        this.scanner = new Scanner(System.in);
        this.input = new InputValidator(scanner);
        this.generator = createNumberGenerator();
        this.evaluator = new GuessEvaluator();
        this.maxAttempts = input.readInteger("Enter no of maximum attempts: ");
    }

    private NumberGenerator createNumberGenerator() {
        while (true) {
            int min = input.readInteger("Enter minimum range of number: ");
            int max = input.readInteger("Enter maximum range of number: ");

            try {
                return new NumberGenerator(min, max);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid range: " + e.getMessage());
            }
        }
    }

    public void play() {
        String playAgain;

        try {
            do {
                int target = generator.generateNumber();
                boolean won = false;
                System.out.println("\nMaximum possible attempts: " + maxAttempts);

                for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                    int guess = input.readIntegerInRange(
                            "Enter your guess (range->[" + generator.getMin() + "-" + generator.getMax() + "]): ",
                            generator.getMin(),
                            generator.getMax());
                    String result = evaluator.evaluate(guess, target);

                    switch (result) {
                        case "Too Low":
                            System.out.println("Too Low");
                            break;

                        case "Too High":
                            System.out.println("Too High");
                            break;

                        case "Correct Number Guessed":
                            System.out.println("You won in attempt: " + attempt);
                            won = true;
                            break;
                    }

                    if (won) {
                        break;
                    }

                    if (attempt == maxAttempts) {
                        System.out.println("Game Over! Number was: " + target);
                    }
                }

                playAgain = input.readYesNo("Play again (yes/no): ");

            } while (playAgain.equalsIgnoreCase("yes"));

            System.out.println("Thanks for playing");
        } catch (IllegalStateException e) {
            System.out.println("Game stopped due to input error: " + e.getMessage());
        }
    }
}
