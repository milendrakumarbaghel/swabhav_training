package conditionalStatements;

import java.util.Scanner;

class BankAccountEx {
    private double balance;
    private boolean isActive;

    BankAccountEx(double balance, boolean isActive) {
        this.balance = balance;
        this.isActive = isActive;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if(!isActive) {
            System.out.println("Account is not active");
            return;
        }

        if(amount < 0) {
            System.out.println("Amount should be greater than zero");
            return;
        }

        if(balance<amount) {
            System.out.println("Insufficient balance in account");
            return;
        }

        balance -= amount;
    }
}

public class ifStatementWithoutElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        while (balance<0) {
            System.out.print("please provide valid balance amount: ");
            balance = scanner.nextDouble();
        }

        System.out.print("Enter Account active status (true/false): ");

        while (!scanner.hasNextBoolean()) {
            System.out.print("Please enter valid Account active status (true/false): ");
            scanner.next();
        }

        boolean isActive = scanner.nextBoolean();

        System.out.println("Account Active Status: " + isActive);

        BankAccountEx account = new BankAccountEx(balance, isActive);

        int choice;

        do {
            System.out.println("\n1. Withdraw");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        scanner.close();
    }
}
