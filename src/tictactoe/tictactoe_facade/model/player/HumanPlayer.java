package tictactoe.tictactoe_facade.model.player;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.Mark;
import tictactoe.tictactoe_facade.model.exception.InvalidInputException;
import tictactoe.tictactoe_facade.model.exception.InvalidMoveException;
import tictactoe.tictactoe_facade.model.io.InputReader;
import tictactoe.tictactoe_facade.model.validation.CellCoordinateMapper;
import tictactoe.tictactoe_facade.model.validation.GameValidator;
import tictactoe.tictactoe_facade.model.validation.InputValidator;

public class HumanPlayer implements Player {
    private final Mark mark;
    private final InputReader inputReader;

    public HumanPlayer(Mark mark, InputReader inputReader) {
        this.mark = mark;
        this.inputReader = inputReader;
    }

    @Override
    public void makeMove(Board board) {
        while (true) {
            try {
                int size = board.getSize();
                System.out.println("Enter cell: ");
                String input = inputReader.readLine();
                int cell = InputValidator.validateInteger(input, "Cell");
                GameValidator.validateCellRange(cell, size);

                int[] position = CellCoordinateMapper.cellToCoordinates(cell, size);
                board.placeMark(position[0], position[1], mark);
                break;
            } catch (InvalidMoveException | InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public String getDisplayName() {
        return "Human";
    }
}

