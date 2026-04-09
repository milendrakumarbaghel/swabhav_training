package tictactoe.tictactoe_facade.model;

import tictactoe.tictactoe_facade.model.player.Player;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(Board board, Player p1, Player p2) {
        this.board = board;
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = p1;
    }

    public void play() {
        while (true) {
            board.printBoard();
            System.out.println("\n" + currentPlayer.getDisplayName() + " Player " + currentPlayer.getMark() + "'s turn->");

            currentPlayer.makeMove(board);

            if (checkWinner()) {
                board.printBoard();
                System.out.println("\n" + currentPlayer.getDisplayName() + " Player " + currentPlayer.getMark() + " won the game");
                break;
            }

            if (board.isBoardFull()) {
                board.printBoard();
                System.out.println("Game draw");
                break;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean checkWinner() {
        int size = board.getSize();
        Mark mark = currentPlayer.getMark();

        for (int i = 0; i < size; i++) {
            if (rowWin(i, mark) || colWin(i, mark)) return true;
        }

        return diagWin(mark);
    }

    private boolean rowWin(int row, Mark mark) {
        for (int col = 0; col < board.getSize(); col++)
            if (board.getCell(row, col) != mark) return false;
        return true;
    }

    private boolean colWin(int col, Mark mark) {
        for (int row = 0; row < board.getSize(); row++)
            if (board.getCell(row, col) != mark) return false;
        return true;
    }

    private boolean diagWin(Mark mark) {
        int size = board.getSize();

        boolean diagonal = true;
        boolean antiDiagonal = true;

        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != mark) diagonal = false;
            if (board.getCell(i, size - i - 1) != mark) antiDiagonal = false;
        }

        return diagonal || antiDiagonal;
    }
}
