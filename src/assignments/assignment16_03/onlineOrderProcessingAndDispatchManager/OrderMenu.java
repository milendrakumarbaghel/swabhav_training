package assignments.assignment16_03.onlineOrderProcessingAndDispatchManager;

import java.util.Scanner;

public class OrderMenu {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        ManageOrder manager = new ManageOrder();

        while(true) {
            System.out.println("Order Menu:");
            System.out.println("1. Add Regular Order");
            System.out.println("2. Add Priority Order");
            System.out.println("1. Display Order");
            System.out.println("4. Process Order");
            System.out.println("5. Remove Order");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            int id;
            String name;
            double amount;
            int days;

            switch (choice) {
                case 1:
                    System.out.println("Enter Order Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Customer Name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter amount: ");
                    amount = scanner.nextDouble();
                    days = 10;

                    manager.addOrder(new RegularOrder(id, name, amount, days));
                    break;

                case 2:
                    System.out.println("Enter Order Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Customer Name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter amount: ");
                    amount = scanner.nextDouble();
                    days = 5;
                    double deliveryCharge = 100;

                    manager.addOrder(new PriorityOrder(id, name, amount, days, deliveryCharge));
                    break;

                case 3:
                    manager.displayOrders();
                    break;

                case 4:
                    manager.processOrders();
                    break;

                case 5:
                    System.out.println("Enter minimum amount");
                    double minAmount = scanner.nextDouble();
                    manager.removeCancelledOrders(minAmount);
                    break;

                case 6:
                    scanner.close();
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
