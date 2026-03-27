package assignments.numberGuesserGame;

import java.util.Scanner;

public class GameController {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    private final NumberGenerator generator;
    private final GuessEvaluator evaluator;
    private final InputValidator input;

    public GameController() {
        System.out.println("Number Guesser game started.");
        Scanner scanner = new Scanner(System.in);
        this.input = new InputValidator(scanner);
        this.generator = new NumberGenerator(MIN_NUMBER, MAX_NUMBER);
        this.evaluator = new GuessEvaluator();
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have a maximum of 5 attempts.");
    }

    public void play() {
        String playAgain;

        do {
            int target = generator.generateNumber();
            boolean won = false;

            for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
                int guess = input.readIntegerInRange(
                        "Attempt " + attempt + "/" + MAX_ATTEMPTS + " - Enter your guess (1-100): ",
                        MIN_NUMBER,
                        MAX_NUMBER
                );

                String result = evaluator.evaluate(guess, target);

                if (result.equals(GuessEvaluator.TOO_LOW)) {
                    System.out.println("Sorry, too low");
                } else if (result.equals(GuessEvaluator.TOO_HIGH)) {
                    System.out.println("Sorry, too high");
                } else if (result.equals(GuessEvaluator.CORRECT_GUESS)) {
                    System.out.println("Correct! You guessed the number in attempt " + attempt + ".");
                    won = true;
                } else {
                    throw new IllegalStateException("Unexpected evaluation result: " + result);
                }

                if (won) {
                    break;
                }
            }

            if (!won) {
                System.out.println("Game over! The correct number was " + target + ".");
            }

            playAgain = input.readYesNo("Do you want to play again? (yes/no): ");
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing.");
    }
}
