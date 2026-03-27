package assignments.pigDiceGame;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class GameController {
    private static final int TARGET_SCORE = 20;
    private static final int DICE_BUST_VALUE = 1;
    
    private final Scanner scanner;
    private final Dice dice;
    private final InputValidator input;
    
    private int totalScore;
    private int turnNumber;

    public GameController() {
        this.scanner = new Scanner(System.in);
        this.totalScore = 0;
        this.turnNumber = 1;
        this.dice = new Dice();
        this.input = new InputValidator(scanner);
    }

    public void startGame() {
        try {
            displayWelcomeAndRules();
            
            while (totalScore < TARGET_SCORE) {
                playTurn();
                turnNumber++;
            }
            
            displayGameEnd();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("Input stream ended unexpectedly. Cannot continue game.", e);
        } catch (IllegalStateException e) {
            throw e;
        } finally {
            closeScanner();
        }
    }

    private void displayWelcomeAndRules() {
        System.out.println("========================================");
        System.out.println("      Welcome to the Pig Dice Game      ");
        System.out.println("========================================\n");
        
        System.out.println("GAME RULES:");
        System.out.println("1. The goal is to reach a total score of " + TARGET_SCORE + " points.");
        System.out.println("2. On each turn, you can ROLL the dice or HOLD your points.");
        System.out.println("3. Roll the dice to add its value to your turn score.");
        System.out.println("4. If you roll a 1, your turn score becomes 0 and your turn ends.");
        System.out.println("5. If you HOLD, your turn score is added to your total score.");
        System.out.println("6. First player to reach " + TARGET_SCORE + " points wins!\n");
        
        System.out.println("========================================\n");
    }

    private void playTurn() {
        int turnScore = 0;
        
        System.out.println("--- TURN " + turnNumber + " ---");
        System.out.println("Current Total Score: " + totalScore + "\n");
        
        boolean turnActive = true;
        
        while (turnActive) {
            try {
                char choice = input.readChoice("Roll or Hold? (r/h): ");
                
                if (choice == 'r') {
                    int dieValue = dice.roll();
                    System.out.println("Die rolled: " + dieValue);
                    
                    if (dieValue == DICE_BUST_VALUE) {
                        turnScore = 0;
                        System.out.println("Oh no! You rolled a 1!");
                        System.out.println("Turn Over. No score.\n");
                        turnActive = false;
                    } else {
                        turnScore += dieValue;
                        System.out.println("Turn score: " + turnScore + "\n");
                    }
                    
                } else if (choice == 'h') {
                    totalScore += turnScore;
                    System.out.println("Score for this turn: " + turnScore);
                    System.out.println("Total score: " + totalScore + "\n");
                    turnActive = false;
                    
                } else {
                    System.out.println("Invalid input. Please try again.\n");
                }
            } catch (NoSuchElementException e) {
                throw new IllegalStateException("Input stream ended unexpectedly during turn " + turnNumber, e);
            }
        }
    }

    private void displayGameEnd() {
        System.out.println("========================================");
        System.out.println("You finished in " + (turnNumber - 1) + " turns!");
        System.out.println("Final Score: " + totalScore);
        System.out.println("========================================");
        System.out.println("Game Over! Thanks for playing!");
    }

    private void closeScanner() {
        if (scanner != null) {
            try {
                scanner.close();
            } catch (Exception e) {
                System.err.println("Warning: Failed to close scanner: " + e.getMessage());
            }
        }
    }
}
