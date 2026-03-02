package tictactoe.srp_ocp;

import java.util.Arrays;

public class Board {
    private final Mark[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.board = new Mark[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (Mark[] row : board) {
            Arrays.fill(row, Mark.EMPTY);
        }
    }

    public boolean placeMark(int row, int col, Mark mark) {
        if (isValidMove(row, col)) {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size &&
                col >= 0 && col < size &&
                board[row][col] == Mark.EMPTY;
    }

    public boolean isBoardFull() {
        for (Mark[] row : board) {
            for (Mark cell : row) {
                if (cell == Mark.EMPTY) return false;
            }
        }
        return true;
    }

    public Mark getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for(int i=0; i<size; i++) {
            System.out.print("|  ");
            for(int j = 0; j<size; j++) {
                if(board[i][j] == Mark.EMPTY) {
                    System.out.print(i + "," + j + "  |  ");
                } else {
                    System.out.print(board[i][j] + "    |  ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
