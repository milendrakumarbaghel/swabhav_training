package tictactoe.srp_ocp;

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
            int size = board.getSize();
            System.out.print("Enter row: ");
            int row = isValidRowCol(scanner, size);
            System.out.print("Enter col: ");
            int col = isValidRowCol(scanner, size);

            if (board.placeMark(row, col, mark)) break;

            System.out.println("Invalid move, try again.");
        }
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    public static int isValidRowCol(Scanner scanner, int size) {
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
}
