package assignments.assignment10_03.main;

import java.util.Scanner;

public class ProductMenuController {
    private Product[] products;
    private int count = 0;

    private Scanner scanner = new Scanner(System.in);

    public ProductMenuController(int size) {
        products = new Product[size];
    }

    public void startMenu() {
        while (true) {
            showMenu();
            int choice = readInt();

            switch (choice) {
                case 1:
                    addElectronics();
                    break;

                case 2:
                    addClothing();
                    break;

                case 3:
                    displayProducts();
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

        System.out.println("\nProduct Inventory System");
        System.out.println("1. Add Electronics");
        System.out.println("2. Add Clothing");
        System.out.println("3. Display Products");
        System.out.println("4. Exit");

        System.out.print("Enter choice: ");
    }

    private int readInt() {

        while (true) {

            try {
                return Integer.parseInt(scanner.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid number. Enter again: ");
            }
        }
    }

    private double readDouble() {

        while (true) {

            try {
                return Double.parseDouble(scanner.nextLine());
            }

            catch (NumberFormatException e) {
                System.out.print("Invalid decimal value. Enter again: ");
            }
        }
    }

    private String readString(String message) {

        while (true) {

            System.out.print(message);
            String input = scanner.nextLine();

            if (!input.trim().isEmpty())
                return input;

            System.out.println("Input cannot be empty.");
        }
    }

    private void addElectronics() {

        if (count >= products.length) {
            System.out.println("Inventory full.");
            return;
        }

        try {

            System.out.print("Enter Product ID: ");
            int id = readInt();

            String name = readString("Enter Product Name: ");

            System.out.print("Enter Price: ");
            double price = readDouble();

            System.out.print("Enter Warranty Years: ");
            int warranty = readInt();

            products[count++] =
                    new Electronics(id, name, price, warranty);

            System.out.println("Electronics product added.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void addClothing() {

        if (count >= products.length) {
            System.out.println("Inventory full.");
            return;
        }

        try {

            System.out.print("Enter Product ID: ");
            int id = readInt();

            String name = readString("Enter Product Name: ");

            System.out.print("Enter Price: ");
            double price = readDouble();

            String size = readString("Enter Size: ");
            String fabric = readString("Enter Fabric Type: ");

            products[count++] =
                    new Clothing(id, name, price, size, fabric);

            System.out.println("Clothing product added.");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    private void displayProducts() {

        if (count == 0) {
            System.out.println("Inventory empty.");
            return;
        }

        for (int i = 0; i < count; i++) {
            products[i].displayProduct();
        }
    }
}
