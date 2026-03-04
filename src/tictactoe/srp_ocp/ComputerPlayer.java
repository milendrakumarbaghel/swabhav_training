package tictactoe.srp_ocp;

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


}
