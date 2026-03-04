package tictactoe.srp_ocp;

import exceptionHandling.assignment.InvalidMarksException;

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
                System.out.print("Enter row: ");
//                int row = isValidRowCol(size);
                int row = readInt();
                System.out.print("Enter col: ");
//                int col = isValidRowCol(size);
                int col = readInt();


                board.placeMark(row, col, mark);
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
            throw new InvalidInputException("Please enter a valid number.");
        }
    }
}
