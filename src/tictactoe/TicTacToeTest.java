package tictactoe;

import java.util.Scanner;

public class TicTacToeTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLet's play TicTacToe Game");
            System.out.println("1. Human vs Human");
            System.out.println("2. Human vs Computer");
            System.out.println("3. Exit");
            System.out.println("Enter your choice (1 or 2): ");
            choice = getValidChoice(scanner);

            TicTacToe ticTacToe;
            switch(choice) {
                case 1:
                    ticTacToe = new TicTacToe(scanner);
                    ticTacToe.playHumanVsHuman();
                    break;

                case 2:
                    ticTacToe = new TicTacToe(scanner);
                    ticTacToe.playHumanVsComputer();
                    break;

                case 3:
                    System.out.println("Thank you for playing");
            }

        } while (choice != 3);

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
}
