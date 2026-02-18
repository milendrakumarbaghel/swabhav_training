package oops.encapsulation.test;

import oops.encapsulation.model.Product;

import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Initial Stock: ");
        int stock = scanner.nextInt();
        Product product = new Product(name, price, stock);
        int choice;

        do {
            System.out.println("1. Update Price");
            System.out.println("2. Increase Stock");
            System.out.println("3. Reduce Stock");
            System.out.println("4. Check Discontinued Status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    product.updatePrice(newPrice);
                    break;

                case 2:
                    System.out.print("Enter quantity to increase: ");
                    int incQty = scanner.nextInt();
                    product.increaseStock(incQty);
                    break;

                case 3:
                    System.out.print("Enter quantity to reduce: ");
                    int redQty = scanner.nextInt();
                    product.reduceStock(redQty);
                    break;

                case 4:
                    System.out.println("Is Discontinued? " + product.isDiscontinued());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        scanner.close();
    }
}
