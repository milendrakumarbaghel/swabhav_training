package tictactoe.tictactoe_facade.model.facade;

import tictactoe.tictactoe_facade.model.io.InputReader;
import tictactoe.tictactoe_facade.model.validation.InputValidator;
import tictactoe.tictactoe_facade.model.validation.GameValidator;

public class TicTacToeMenu {
    private final InputReader inputReader;

    public TicTacToeMenu(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int readMenuChoice() {
        System.out.println("\nTIC TAC TOE Game");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");

        String input = inputReader.readLine();
        int choice = InputValidator.validateInteger(input, "Choice");
        InputValidator.validateMenuChoice(choice, 1, 3);

        return choice;
    }

    public int readBoardSize() {
        System.out.print("Enter board size (e.g., 3): ");
        String input = inputReader.readLine();

        int size = InputValidator.validateInteger(input, "Board size");
        GameValidator.validateBoardSize(size);

        return size;
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showExitMessage() {
        System.out.println("Exiting game");
    }
}
