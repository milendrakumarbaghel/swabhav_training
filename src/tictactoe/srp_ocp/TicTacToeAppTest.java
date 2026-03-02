package tictactoe.srp_ocp;

import java.util.Scanner;

public class TicTacToeAppTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTIC TAC TOE Game");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = getValidChoice(scanner);

            if (choice == 3) {
                System.out.println("Exiting game");
                break;
            }

            System.out.print("Enter board size (e.g., 3): ");
            int size = isValidNumber(scanner);

            Board board = new Board(size);

            Player p1;
            Player p2;

            switch (choice) {
                case 1:
                    p1 = new HumanPlayer(Mark.X, scanner);
                    p2 = new HumanPlayer(Mark.O, scanner);
                    break;

                case 2:
                    p1 = new HumanPlayer(Mark.O, scanner);
                    p2 = new ComputerPlayer(Mark.X);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    continue;
            }

            Game game = new Game(board, p1, p2);
            game.play();
        }

        scanner.close();
    }

    public static int getValidChoice(Scanner scanner) {
        while(true){
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            int value = scanner.nextInt();

            if (value >= 1 && value <= 3) {
                return value;
            }

            System.out.println("Invalid choice, Enter 1 | 2 | 3");
        }
    }

    public static int isValidNumber(Scanner scanner) {
        while(true){
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter numeric value: ");
                scanner.next();
            }

            int value = scanner.nextInt();

            if (value>0) {
                return value;
            }

            System.out.println("Invalid choice, Enter number greater than zero");
        }
    }
}
