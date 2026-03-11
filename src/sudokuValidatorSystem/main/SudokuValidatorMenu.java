package sudokuValidatorSystem.main;

import java.util.Scanner;

public class SudokuValidatorMenu {
    private static Scanner scanner = new Scanner(System.in);

    public static void start() {
        while(true) {
            System.out.println("\nSUDOKU VALIDATOR");
            System.out.println("1. Enter Sudoku Grid");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    validateSudoku();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void validateSudoku() {
        try {
            int[][] sudokuBoard = readBoard();
            SudokuBoard board = new SudokuBoard(sudokuBoard);

            new RowValidator(board).validate();
            new ColumnValidator(board).validate();
            new BoxValidator(board).validate();

            System.out.println("\nSudoku is VALID");

        } catch (InvalidSudokuException e) {

            System.out.println("\nSudoku is INVALID");
            System.out.println("Reason: " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid input. Please enter numbers only.");
        }
    }

    private static int[][] readBoard() {
        int[][] board = new int[9][9];
        System.out.println("\nEnter Sudoku Board (values 1 - 9)");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int value;

                while (true) {
                    value = readInteger("Enter value for [" + i + "][" + j + "]: ");

                    if (value >= 1 && value <= 9)
                        break;

                    System.out.println("Number must be between 1 and 9.");
                }

                board[i][j] = value;
            }
        }

        return board;
    }

    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            else {

                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }
}
