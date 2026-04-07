package tictactoe.tictactoe_facade.model.facade;

import tictactoe.tictactoe_facade.model.exception.InvalidInputException;

import java.util.Scanner;

public class TicTacToeMenu {
    private final Scanner scanner;

    public TicTacToeMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readMenuChoice() {
        System.out.println("\nTIC TAC TOE Game");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");

        String input = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid number.");
        }

        if (choice < 1 || choice > 3) {
            throw new InvalidInputException("Menu choice must be 1, 2, or 3.");
        }

        return choice;
    }

    public int readBoardSize() {
        System.out.print("Enter board size (e.g., 3): ");
        String input = scanner.nextLine();

        int size;
        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Board size must be a number.");
        }

        if (size <= 0) {
            throw new InvalidInputException("Board size must be greater than 0.");
        }

        return size;
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showExitMessage() {
        System.out.println("Exiting game");
    }
}

