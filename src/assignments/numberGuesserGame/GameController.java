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
        this.scanner=new Scanner(System.in);
        this.input = new InputValidator(scanner);
        this.generator = new NumberGenerator(input.readInteger("Enter minimum range of number:"),
                input.readInteger("Enter maximum range of number"));
        this.evaluator = new GuessEvaluator();
        this.maxAttempts = input.readInteger("Enter no of maximum attempts: ");
    }

    public void play() {
        String playAgain;

        do {
            int target = generator.generateNumber();
            boolean won = false;
            System.out.println("\nMaximum possible attempts: " + maxAttempts);

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                int guess = input.readInteger("Enter your guess (range->[" + generator.getMin() + "-" + generator.getMax()+"]): ");
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
    }
}
