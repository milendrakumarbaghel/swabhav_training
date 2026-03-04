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

//            int choice = getValidChoice(scanner);
            int choice;
            try {
                choice = readMenuChoice(scanner);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (choice == 3) {
                System.out.println("Exiting game");
                break;
            }

            System.out.print("Enter board size (e.g., 3): ");
//            int size = isValidNumber(scanner);
            int size;

            while (true) {
                try {
                    size = readBoardSize(scanner);
                    break;
                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }

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

    private static int readMenuChoice(Scanner scanner) {
        String input = scanner.nextLine();

        int choice;

        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Please enter a valid number.");
        }

        if (choice < 1 || choice > 3) {
            throw new InvalidInputException("Menu choice must be 1, 2, or 3.");
        }

        return choice;
    }

    private static int readBoardSize(Scanner scanner) {
        String input = scanner.nextLine();

        int size;

        try {
            size = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Board size must be a number.");
        }

        if (size <= 0) {
            throw new InvalidInputException("Board size must be greater than 0.");
        }

        return size;
    }
}
