package assignments.pigDiceGame;

import java.util.Scanner;

public class GameController {
    private static final int TARGET_SCORE = 20;
    private Scanner scanner = new Scanner(System.in);
    private int totalScore;
    private int turnNumber;

    private Dice dice;
    private InputValidator input;

    public GameController() {
        this.totalScore = 0;
        this.turnNumber = 1;

        this.dice = new Dice();
        this.input = new InputValidator(scanner);
    }

    public void startGame() {
        while (totalScore < TARGET_SCORE) {
            int turnScore = 0;
            System.out.println("TURN " + turnNumber);

            while (true) {
                char choice = input.readChoice("Roll or Hold? (r/h): ");

                if (choice == 'r') {
                    int die = dice.roll();
                    System.out.println("Die: " + die);

                    if (die == 1) {
                        turnScore = 0;
                        System.out.println("Turn Over. No score.\n");

                        break;
                    }

                    turnScore += die;
                    System.out.println("Turn score: " + turnScore);

                } else {

                    totalScore += turnScore;
                    System.out.println("Score for turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");

                    break;
                }
            }

            turnNumber++;
        }

        System.out.println("You finished in " + (turnNumber - 1) + " turns!");
        System.out.println("Game Over!");
    }
}
