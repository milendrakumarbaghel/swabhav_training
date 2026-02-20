package oops.inheritance.test;

import oops.inheritance.model.CurrentAccount;
import oops.inheritance.model.SavingsAccount;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Select Account Type: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Account Holder's Name: ");
        String holderName = scanner.nextLine();

        while (holderName.isBlank()) {
            System.out.print("Holder name cannot be blank. Enter again: ");
            holderName = scanner.nextLine();
        }

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        while (balance < 0) {
            System.out.print("Balance cannot be negative. Enter again: ");
            balance = scanner.nextDouble();
        }

        SavingsAccount savings = null;
        CurrentAccount current = null;

        if (type == 1) {
            System.out.println("Enter minimum balance: ");
            double minimumBalance = scanner.nextDouble();

            while(minimumBalance<=0) {
                System.out.println("Minimum balance should be greater than zero, Please reenter valid minimum balance: ");
                minimumBalance = scanner.nextDouble();
            }

            savings = new SavingsAccount(holderName, balance, minimumBalance);
            System.out.println("Savings Account Created Successfully!");
        } else if (type == 2) {
            System.out.println("Enter overdraft limit: ");
            double overDraftLimit = scanner.nextDouble();

            while(overDraftLimit<=0) {
                System.out.println("Minimum balance should be greater than zero, Please reenter valid minimum balance: ");
                overDraftLimit = scanner.nextDouble();
            }

            current = new CurrentAccount(holderName, balance, overDraftLimit);
            System.out.println("Current Account Created Successfully!");
        } else {
            System.out.println("Invalid account type selected.");
            return;
        }

        int choice;

        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Details");
            System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();

                    while (depositAmount <= 0) {
                        System.out.print("Invalid amount. Enter again: ");
                        depositAmount = scanner.nextDouble();
                    }

                    if (type == 1) {
                        savings.deposit(depositAmount);
                    } else {
                        current.deposit(depositAmount);
                    }
                    break;

                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();

                    while (withdrawAmount <= 0) {
                        System.out.print("Invalid amount. Enter again: ");
                        withdrawAmount = scanner.nextDouble();
                    }

                    if (type == 1) {
                        savings.withdraw(withdrawAmount);
                    } else {
                        current.withdraw(withdrawAmount);
                    }
                    break;

                case 3:
                    if (type == 1) {
                        savings.displayDetails();
                    } else {
                        current.displayDetails();
                    }
                    break;

                case 4:
                    System.out.println("Exiting Banking System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        scanner.close();
    }
}
