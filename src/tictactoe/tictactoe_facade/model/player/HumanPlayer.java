package tictactoe.tictactoe_facade.model.player;

import tictactoe.tictactoe_facade.model.Board;
import tictactoe.tictactoe_facade.model.exception.InvalidInputException;
import tictactoe.tictactoe_facade.model.exception.InvalidMoveException;
import tictactoe.tictactoe_facade.model.Mark;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Mark mark;
    private final Scanner scanner;

    public HumanPlayer(Mark mark, Scanner scanner) {
        this.mark = mark;
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Board board) {
        while (true) {
            try {
                int size = board.getSize();
//                System.out.print("Enter row: ");
//                int row = isValidRowCol(size);
//                int row = readInt();
//                System.out.print("Enter col: ");
//                int col = isValidRowCol(size);
//                int col = readInt();

                System.out.println("Enter cell: ");
                int cell= readInt();

                int[] position = getPosition(cell, size);

                board.placeMark(position[0], position[1], mark);
                break;
            } catch (InvalidMoveException | InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

//            System.out.println("Invalid move, try again.");

        }
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    public int isValidRowCol(int size) {
        while(true){
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            int value = scanner.nextInt();

            if (value >= 1 && value < size) {
                return value;
            }

            System.out.println("Invalid choice, Enter valid row/col number (0-"+size+")");
        }
    }

    private int readInt() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid Cell.");
        }
    }

    public int[] getPosition(int cell, int size) {
        int row = (cell - 1) / size;
        int col = (cell - 1) % size;

        return new int[]{row, col};
    }
}
