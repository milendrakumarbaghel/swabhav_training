package oops.constructor.test;

import oops.constructor.model.PremiumAccount;
import oops.constructor.model.BankAccount;

import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Type (1-Regular, 2-Premium): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();

        while (accNo.isBlank()) {
            System.out.print("Account number cannot be empty. Enter again: ");
            accNo = scanner.nextLine();
        }

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        while (balance < 0) {
            System.out.print("Balance cannot be negative. Enter again: ");
            balance = scanner.nextDouble();
        }

        BankAccount account;

        if (type == 2) {
            account = new PremiumAccount(accNo, name, balance);
        } else {
            account = new BankAccount(accNo, name, balance);
        }

        int choice;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = scanner.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        scanner.close();
    }
}
