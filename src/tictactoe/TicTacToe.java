package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private Scanner scanner;
    private Random random;

    public TicTacToe(Scanner scanner) {
        this.board = new char[3][3];
        this.currentPlayer = 'X';
        this.scanner = scanner;
        this.random = new Random();
        initializeBoard();
    }

    private void initializeBoard() {
//        for(int i=0; i<3; i++) {
//            for(int j=0; j<3; j++) {
//                board[i][j] = ' ';
//            }
//        }

        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    private void printBoard() {
        for(int i=0; i<3; i++) {
            System.out.print("| ");
            for(int j=0; j<3; j++) {

                if(board[i][j] == ' ') {
                    System.out.print(i + "," + j + " | ");
                } else {
                    System.out.print(board[i][j] + "   | ");
                }
//                System.out.print(board[i][j] + " | ");

            }
            System.out.println();
        }
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer=='X' ? 'O' : 'X';
    }

    private boolean checkWinner() {
        for(int i=0; i<3; i++) {
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer) {
                return true;
            }

            if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer) {
                return true;
            }
        }

        if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer) {
            return true;
        }

        if(board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        int count = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i][j] != ' ') {
                    count++;
                }
            }
        }

        return count == 9 ? true : false;
    }

    private boolean isValidMove(int row, int  col) {
        if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' ') return true;

        return false;
    }

    public void playHumanVsHuman() {
        boolean isGameEnded = false;

        while (!isGameEnded) {
            printBoard();

            System.out.println("\nPlayer " + currentPlayer + " turn");
            humanMove();

            if(checkWinner()) {
                printBoard();
                System.out.println("\nPlayer " + currentPlayer + " won the game");
                isGameEnded = true;
            } else if(isBoardFull()) {
                printBoard();
                System.out.println("Game draw");
                isGameEnded = true;
            } else {
                switchPlayer();
            }
        }
    }

    public void playHumanVsComputer() {
        boolean isGameEnded = false;

        while(!isGameEnded) {
            printBoard();

            if(currentPlayer=='X') {
                System.out.println("\nYour turn (X)");
                humanMove();
            } else {
                System.out.println("\nComputer's turn (O)");
                computerMove();
            }

            if(checkWinner()) {
                printBoard();

                if(currentPlayer=='X') {
                    System.out.println("You win");
                } else {
                    System.out.println("Computer Win");
                }

                isGameEnded = true;
            } else if(isBoardFull()) {
                printBoard();
                System.out.println("Match draw");
                isGameEnded = true;
            } else {
                switchPlayer();
            }
        }
    }

    public void humanMove() {
        int row;
        int col;

        while(true) {
            System.out.println("Enter row (0-2): ");
            row = isValidNumericInput();

            System.out.println("Enter column (0-2): ");
            col = isValidNumericInput();

            if(isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                break;
            }

            System.out.println("Invalid move, please try again");
        }
    }

    public void computerMove() {
        int row;
        int col;

        while(true) {
            row = random.nextInt(3);
            col = random.nextInt(3);

            if(isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                break;
            }
        }
    }

    public int isValidNumericInput() {
        while (true){
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            int value = scanner.nextInt();

            if (value >= 0 && value <= 3) {
                return value;
            }

            System.out.println("Invalid input, Enter correct index (0 | 1 | 2): ");
        }

    }
}
