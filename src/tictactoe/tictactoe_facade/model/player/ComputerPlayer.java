package tictactoe.tictactoe_facade.model.player;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.exception.InvalidInputException;
import tictactoe.tictactoe_facade.model.exception.InvalidMoveException;
import tictactoe.tictactoe_facade.model.Mark;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final Mark mark;
    private final Random random = new Random();

    public ComputerPlayer(Mark mark) {
        this.mark = mark;
    }

    @Override
    public void makeMove(Board board) {
        int size = board.getSize();

        while (true) {
            try {
                int row = random.nextInt(size);
                int col = random.nextInt(size);

                board.placeMark(row, col, mark);
                break;
            } catch (InvalidMoveException | InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public String getDisplayName() {
        return "Computer";
    }


}
