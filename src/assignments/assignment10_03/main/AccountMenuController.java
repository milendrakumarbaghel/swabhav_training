package assignments.assignment10_03.main;

import java.util.Scanner;

public class AccountMenuController {
    private Account[] accounts;
    private int count = 0;
    private Scanner sc = new Scanner(System.in);

    public AccountMenuController(int size) {
        accounts = new Account[size];
    }

    public void startMenu() {
        while (true) {
            showMenu();

            int choice = readInt();

            switch (choice) {
                case 1:
                    addSavingsAccount();
                    break;

                case 2:
                    addCurrentAccount();
                    break;

                case 3:
                    displayAccounts();
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nBank Account System");
        System.out.println("1. Add Savings Account");
        System.out.println("2. Add Current Account");
        System.out.println("3. Display Accounts");
        System.out.println("4. Exit");

        System.out.print("Enter choice: ");
    }

    private int readInt() {
        while (true) {

            try {
                return Integer.parseInt(sc.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid decimal value. Enter again: ");
            }
        }
    }

    private String readString(String message) {
        while (true) {

            System.out.print(message);
            String input = sc.nextLine();

            if (!input.trim().isEmpty())
                return input;

            System.out.println("Input cannot be empty.");
        }
    }

    private void addSavingsAccount() {
        if (count >= accounts.length) {
            System.out.println("Account storage full.");
            return;
        }

        try {

            System.out.print("Enter Account Number: ");
            int accNo = readInt();

            String name = readString("Enter Holder Name: ");

            System.out.print("Enter Balance: ");
            double balance = readDouble();

            System.out.print("Enter Interest Rate: ");
            double rate = readDouble();

            accounts[count++] =
                    new SavingsAccount(accNo, name, balance, rate);

            System.out.println("Savings account created successfully.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addCurrentAccount() {
        if (count >= accounts.length) {
            System.out.println("Account storage full.");
            return;
        }

        try {

            System.out.print("Enter Account Number: ");
            int accNo = readInt();

            String name = readString("Enter Holder Name: ");

            System.out.print("Enter Balance: ");
            double balance = readDouble();

            System.out.print("Enter Overdraft Limit: ");
            double limit = readDouble();

            accounts[count++] =
                    new CurrentAccount(accNo, name, balance, limit);

            System.out.println("Current account created successfully.");
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayAccounts() {
        if (count == 0) {
            System.out.println("No accounts available.");
            return;
        }

        for (int i = 0; i < count; i++) {

            accounts[i].displayDetails();
        }
    }
}
