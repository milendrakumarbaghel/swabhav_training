package assignments.assignment11_03.onlineOrderFulfillmentSystem;

import java.util.Scanner;

public class OrderMenuController {
    private Order[] orders;
    private int count = 0;
    private Scanner scanner = new Scanner(System.in);

    public OrderMenuController(int size) {
        orders = new Order[size];
    }

    public void startMenu() {
        while (true) {
            System.out.println("\nOnline Order System");
            System.out.println("1 Add Standard Order");
            System.out.println("2 Add Express Order");
            System.out.println("3 Add International Order");
            System.out.println("4 Display Orders");
            System.out.println("5 Exit");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addStandardOrder();
                    break;

                case 2:
                    addExpressOrder();
                    break;

                case 3:
                    addInternationalOrder();
                    break;

                case 4:
                    displayOrders();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            }
        }
    }

    private double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal");
            }
        }
    }

    private void addStandardOrder() {
        try {
            System.out.print("Order ID: ");
            int id = readInt();

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Order Amount: ");
            double amount = readDouble();

            System.out.print("Delivery Days: ");
            int days = readInt();

            orders[count++] =
                    new StandardOrder(id, name, amount, days);

        } catch (InvalidOrderException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addExpressOrder() {
        try {
            System.out.print("Order ID: ");
            int id = readInt();

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Order Amount: ");
            double amount = readDouble();

            System.out.print("Priority Level: ");
            String priority = scanner.nextLine();

            orders[count++] =
                    new ExpressOrder(id, name, amount, priority);

        } catch (InvalidOrderException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addInternationalOrder() {
        try {
            System.out.print("Order ID: ");
            int id = readInt();

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Order Amount: ");
            double amount = readDouble();

            System.out.print("Destination Country: ");
            String country = scanner.nextLine();

            orders[count++] = new InternationalOrder(id, name, amount, country);

        } catch (InvalidOrderException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayOrders() {

        for (int i = 0; i < count; i++) {
            orders[i].displayOrder();
        }
    }
}
