package sudokuValidatorSystem.model;

import java.util.Scanner;

public class SudokuValidatorMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        while (true) {
            System.out.println("\nSUDOKU VALIDATOR");
            System.out.println("1. Enter in Blank Sudoku Board");
            System.out.println("2. Play Sudoku Puzzle");
            System.out.println("3. Exit");

            int choice = readInteger("Choose option: ");

            switch (choice) {
                case 1:
                    try {
                        int[][] grid = readBoard();
                        SudokuBoard board = new SudokuBoard(grid);
                        validateSudoku(board);
                    } catch (InvalidSudokuException e) {
                        System.out.println("Current board state is INVALID.");
                        System.out.println("Reason: " + e.getMessage());
                        System.out.println("Returning to main menu...");
                    }
                    break;

                case 2:
                    playGeneratedPuzzle();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void playGeneratedPuzzle() {
        while (true) {
            System.out.println("\nSELECT DIFFICULTY");
            System.out.println("1. Easy (25 empty cells)");
            System.out.println("2. Medium (40 empty cells)");
            System.out.println("3. Hard (55 empty cells)");
            System.out.println("4. Back to Main Menu");

            int levelChoice = readInteger("Choose difficulty: ");
            DifficultyLevel level;

            switch (levelChoice) {
                case 1:
                    level = DifficultyLevel.EASY;
                    break;
                case 2:
                    level = DifficultyLevel.MEDIUM;
                    break;
                case 3:
                    level = DifficultyLevel.HARD;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid difficulty choice!");
                    continue;
            }

            int[][] puzzle = SudokuPuzzleGenerator.generatePuzzle(level);
            System.out.println("\nGenerated " + level.getDisplayName() + " puzzle:");
            playPuzzleGame(puzzle);
        }
    }

    private static void playPuzzleGame(int[][] puzzle) {
        boolean[][] fixedCells = getFixedCells(puzzle);

        while (true) {
            Utility.printBoard(puzzle);

            if (isCompletedBoard(puzzle)) {
                System.out.println("Congratulations! You solved the puzzle.");
                return;
            }

            System.out.println("Enter -1 as row to stop this puzzle.");
            int row = readInteger("Enter row (0-8): ");

            if (row == -1) {
                System.out.println("Returning to difficulty menu...");
                return;
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

            if (fixedCells[row][col]) {
                System.out.println("This cell is fixed and cannot be changed.");
                continue;
            }

            int value = readInteger("Enter value (1-9, or 0 to clear): ");
            if (value < 0 || value > 9) {
                System.out.println("Value must be between 0 and 9.");
                continue;
            }

            int previousValue = puzzle[row][col];
            puzzle[row][col] = value;

            try {
                validateSudokuRules(new SudokuBoard(puzzle));
                System.out.println("Move accepted.");
            } catch (InvalidSudokuException e) {
                puzzle[row][col] = previousValue;
                System.out.println("Invalid move: " + e.getMessage());
            }
        }
    }

    private static boolean[][] getFixedCells(int[][] puzzle) {
        boolean[][] fixedCells = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                fixedCells[row][col] = puzzle[row][col] != 0;
            }
        }

        return fixedCells;
    }

    private static boolean isCompletedBoard(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) {
                    return false;
                }
            }
        }

        try {
            validateSudokuRules(new SudokuBoard(grid));
            return true;
        } catch (InvalidSudokuException e) {
            return false;
        }
    }

    private static void validateSudoku(SudokuBoard board) {
        validateSudokuRules(board);
        System.out.println("Current board state is VALID.");
    }

    private static void validateSudokuRules(SudokuBoard board) {
        new RowValidator(board).validate();
        new ColumnValidator(board).validate();
        new BoxValidator(board).validate();
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

            validateSudoku(tempBoard);
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
