package oops.interfaceDemo.bankingDomain;

import java.util.Scanner;

public class BankingTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of accounts: ");
        int total = readPositiveInt(scanner);

        AccountOperations[] accounts = new AccountOperations[total];

        for (int i = 0; i < total; i++) {
            System.out.println("\nAccount No " + (i + 1));
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Loan Account");
            System.out.print("Choose account type: ");

            int type = readValidAccountType(scanner);

            System.out.print("Enter Initial Amount: ");
            double amount = readPositiveDouble(scanner);

            switch (type) {
                case 1:
                    accounts[i] = new SavingsAccount(amount);
                    break;

                case 2:
                    accounts[i] = new CurrentAccount(amount);
                    break;

                case 3:
                    accounts[i] = new LoanAccount(amount);
                    break;
            }
        }

        System.out.println("\nPERFORMING OPERATIONS\n");

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("\nOperations for Account " + (i + 1));
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.print("Choose operation: ");

            int operation = readValidOperation(scanner);

            switch (operation) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    accounts[i].deposit(readPositiveDouble(scanner));
                    break;

                case 2:
                    System.out.print("Enter Withdraw Amount: ");
                    accounts[i].withdraw(readPositiveDouble(scanner));
                    break;

                case 3:
                    accounts[i].checkBalance();
                    break;
            }
        }

        scanner.close();
    }

    public static int readPositiveInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        int value = scanner.nextInt();

        while (value <= 0) {
            System.out.print("Value must be greater than 0. Enter again: ");
            value = readPositiveInt(scanner);
        }

        return value;
    }

    public static double readPositiveDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter numeric value: ");
            scanner.next();
        }

        double value = scanner.nextDouble();

        while (value <= 0) {
            System.out.print("Amount must be greater than 0. Enter again: ");
            value = readPositiveDouble(scanner);
        }

        return value;
    }

    public static int readValidAccountType(Scanner scanner) {
        int type = readPositiveInt(scanner);

        while (type != 1 && type != 2 && type != 3) {
            System.out.print("Invalid choice. Enter again (1-3): ");
            type = readPositiveInt(scanner);
        }

        return type;
    }

    public static int readValidOperation(Scanner scanner) {
        int op = readPositiveInt(scanner);

        while (op != 1 && op != 2 && op != 3) {
            System.out.print("Invalid operation. Enter again (1-3): ");
            op = readPositiveInt(scanner);
        }

        return op;
    }
}
