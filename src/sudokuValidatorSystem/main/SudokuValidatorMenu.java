package sudokuValidatorSystem.main;

import java.util.Scanner;

public class SudokuValidatorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            System.out.println("\nSUDOKU VALIDATOR");
            System.out.println("1. Enter Sudoku Grid");
            System.out.println("2. Exit");

            int choice = readInteger("Choose option: ");

            switch (choice) {
                case 1:
                    int[][] grid = readBoard();
                    SudokuBoard board = new SudokuBoard(grid);
                    validateSudoku(board);
                    break;

                case 2:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void validateSudoku(SudokuBoard board) {
        try {
            new RowValidator(board).validate();
            new ColumnValidator(board).validate();
            new BoxValidator(board).validate();

            System.out.println("Current board state is VALID.");

        } catch (InvalidSudokuException e) {
            System.out.println("Current board state is INVALID.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    private static int[][] readBoard() {
        int[][] grid = new int[9][9];

        System.out.println("\nEnter Sudoku Board (values 1 - 9)");
        System.out.println("Enter -1 as row to stop input.\n");

        while (true) {
            Utility.printBoard(grid);
            int row = readInteger("Enter row (0-8) or -1 to finish: ");

            if (row == -1) {
                break;
            }

            if (row < 0 || row > 8) {
                System.out.println("Row must be between 0 and 8.");
                continue;
            }

            int col = readInteger("Enter column (0-8): ");

            if (col < 0 || col > 8) {
                System.out.println("Column must be between 0 and 8.");
                continue;
            }

            if (grid[row][col] != 0) {
                System.out.println("Cell already filled.");
                continue;
            }

            int value;

            while (true) {
                value = readInteger("Enter value (1-9): ");
                if (value >= 1 && value <= 9) {
                    break;
                }

                System.out.println("Number must be between 1 and 9.");
            }

            grid[row][col] = value;
            SudokuBoard tempBoard = new SudokuBoard(grid);

            try {
                validateSudoku(tempBoard);
            } catch (Exception e) {
                System.out.println("Move invalid: " + e.getMessage());
                grid[row][col] = 0;
                System.out.println("Move reverted.");
            }
        }

        System.out.println("\nFinal Board:");
        Utility.printBoard(grid);

        return grid;
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
