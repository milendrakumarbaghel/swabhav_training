package tictactoe.tictactoe_facade.model.facade;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.Game;
import tictactoe.tictactoe_facade.model.Mark;
import tictactoe.tictactoe_facade.model.io.InputReader;
import tictactoe.tictactoe_facade.model.player.ComputerPlayer;
import tictactoe.tictactoe_facade.model.player.HumanPlayer;
import tictactoe.tictactoe_facade.model.player.Player;
import tictactoe.tictactoe_facade.model.validation.GameValidator;

public class TicTacToeFacade {
    private final InputReader inputReader;

    public TicTacToeFacade(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void startHumanVsHuman(int size) {
        GameValidator.validateBoardSize(size);

        Board board = new Board(size);
        Player player1 = new HumanPlayer(Mark.X, inputReader);
        Player player2 = new HumanPlayer(Mark.O, inputReader);
        new Game(board, player1, player2).play();
    }

    public void startHumanVsComputer(int size) {
        GameValidator.validateBoardSize(size);

        Board board = new Board(size);
        Player player1 = new HumanPlayer(Mark.O, inputReader);
        Player player2 = new ComputerPlayer(Mark.X);
        new Game(board, player1, player2).play();
    }
}
