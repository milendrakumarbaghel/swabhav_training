package oops.interfaceDemo.ecommerceDomain;

import java.util.Scanner;

public class ECommerceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of transactions: ");
        int total = readPositiveInt(scanner);

        for (int i = 0; i < total; i++) {
            System.out.println("\nTransaction No " + (i + 1));
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Net Banking");
            System.out.print("Choose payment method: ");

            int type = readValidType(scanner);
            scanner.nextLine();

            PaymentGateway gateway = null;

            switch (type) {
                case 1:
                    System.out.print("Enter 5 digit Card Number: ");
                    String card = readValidCard(scanner);
                    gateway = new CreditCard(card);
                    break;

                case 2:
                    System.out.print("Enter UPI ID (example: name@bank): ");
                    String upi = readValidUpi(scanner);
                    gateway = new UPI(upi);
                    break;

                case 3:
                    System.out.print("Enter Bank Name: ");
                    String bank = readValidBankName(scanner);
                    gateway = new NetBanking(bank);
                    break;
            }

            Checkout checkout = new Checkout(gateway);

            System.out.println("1. Pay");
            System.out.println("2. Refund");
            System.out.print("Choose operation: ");

            int operation = readValidOperation(scanner);

            System.out.print("Enter amount: ");
            double amount = readPositiveDouble(scanner);

            if (operation == 1)
                checkout.makePayment(amount);
            else
                checkout.processRefund(amount);

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
            System.out.print("Value must be > 0. Enter again: ");
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
            System.out.print("Amount must be > 0. Enter again: ");
            value = readPositiveDouble(scanner);
        }
        return value;
    }

    public static int readValidType(Scanner scanner) {
        int type = readPositiveInt(scanner);
        while (type != 1 && type != 2 && type != 3) {
            System.out.print("Invalid choice (1-3). Enter again: ");
            type = readPositiveInt(scanner);
        }
        return type;
    }

    public static int readValidOperation(Scanner scanner) {
        int op = readPositiveInt(scanner);
        while (op != 1 && op != 2) {
            System.out.print("Invalid choice (1-2). Enter again: ");
            op = readPositiveInt(scanner);
        }
        return op;
    }

    public static String readValidCard(Scanner scanner) {
        String card = scanner.nextLine().trim();
        while (!card.matches("\\d{5}")) {
            System.out.print("Invalid card number. Enter 5 digits: ");
            card = scanner.nextLine().trim();
        }
        return card;
    }

    public static String readValidUpi(Scanner scanner) {
        String upi = scanner.nextLine().trim();
        while (!upi.matches("^[a-zA-Z0-9._-]+@[a-zA-Z]+$")) {
            System.out.print("Invalid UPI ID. Enter again: ");
            upi = scanner.nextLine().trim();
        }
        return upi;
    }

    public static String readValidBankName(Scanner scanner) {
        String bank = scanner.nextLine().trim();
        while (!bank.matches("[a-zA-Z ]+")) {
            System.out.print("Invalid bank name. Enter alphabetic name: ");
            bank = scanner.nextLine().trim();
        }
        return bank;
    }
}
