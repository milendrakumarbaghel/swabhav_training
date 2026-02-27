package miniProjectTicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    static char[][] board = new char[3][3];
    static char currentPlayer = 'X';
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initializeBoard();

        System.out.println("\nTIC TAC TOE\n");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.print("Choose mode: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> playHumanVsHuman();
            case 2 -> playHumanVsComputer();
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void playHumanVsHuman() {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + " turn.");
            makeHumanMove();

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " Wins!");
                gameEnded = true;
            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a Draw!");
                gameEnded = true;
            } else {
                switchPlayer();
            }
        }
    }

    public static void playHumanVsComputer() {
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();

            if (currentPlayer == 'X') {
                System.out.println("Your turn (X)");
                makeHumanMove();
            } else {
                System.out.println("Computer turn (O)");
                makeComputerMove();
            }

            if (checkWinner()) {
                printBoard();
                if (currentPlayer == 'X') System.out.println("You Win!");
                else System.out.println("Computer Wins!");
                gameEnded = true;

            } else if (isBoardFull()) {
                printBoard();
                System.out.println("It's a Draw!");
                gameEnded = true;

            } else {
                switchPlayer();
            }
        }
    }

    public static void makeHumanMove() {
        int row, col;

        while (true) {
            System.out.print("Enter row (0-2): ");
            row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    public static void makeComputerMove() {
        int row, col;

        while (true) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                break;
            }
        }
    }

    public static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;

            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }

        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer)
            return true;

        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
