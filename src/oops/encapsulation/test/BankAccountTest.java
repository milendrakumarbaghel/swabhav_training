package oops.encapsulation.test;

import oops.encapsulation.model.BankAccount;
import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        while(name.isBlank()) {
            System.out.println("Name can't be null, please enter valid name: ");
            name = scanner.nextLine();
        }

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        while(initialBalance < 0) {
            System.out.println("Initial balance can't be zero, please enter valid initial balance: ");
            initialBalance = scanner.nextInt();
        }

        BankAccount account = new BankAccount(name, initialBalance);

        int choice;

        do {
            System.out.println("Press: ,");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the bank system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
