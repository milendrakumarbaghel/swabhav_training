package tictactoe.tictactoe_facade.model.facade;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.Game;
import tictactoe.tictactoe_facade.model.Mark;
import tictactoe.tictactoe_facade.model.exception.InvalidInputException;
import tictactoe.tictactoe_facade.model.player.ComputerPlayer;
import tictactoe.tictactoe_facade.model.player.HumanPlayer;
import tictactoe.tictactoe_facade.model.player.Player;

import java.util.Scanner;

public class TicTacToeFacade {
    private final Scanner scanner;

    public TicTacToeFacade(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startHumanVsHuman(int size) {
        validateBoardSize(size);

        Board board = new Board(size);
        Player player1 = new HumanPlayer(Mark.X, scanner);
        Player player2 = new HumanPlayer(Mark.O, scanner);
        new Game(board, player1, player2).play();
    }

    public void startHumanVsComputer(int size) {
        validateBoardSize(size);

        Board board = new Board(size);
        Player player1 = new HumanPlayer(Mark.O, scanner);
        Player player2 = new ComputerPlayer(Mark.X);
        new Game(board, player1, player2).play();
    }

    private void validateBoardSize(int size) {
        if (size <= 0) {
            throw new InvalidInputException("Board size must be greater than 0.");
        }
    }
}


