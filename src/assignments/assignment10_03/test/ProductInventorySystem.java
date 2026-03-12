package assignments.assignment10_03.test;

import assignments.assignment10_03.main.ProductMenuController;

import java.util.Scanner;

public class ProductInventorySystem {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = readSize(scanner);

        ProductMenuController controller = new ProductMenuController(size);

        controller.startMenu();
    }

    public static int readSize(Scanner scanner) {
        int size;

        while (true) {
            try {
                System.out.print("Enter number of products to store: ");
                size = Integer.parseInt(scanner.nextLine());

                if (size <= 0) throw new IllegalArgumentException("Size must be positive.");

                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid number format.");

            } catch (IllegalArgumentException e) {

                System.out.println(e.getMessage());
            }
        }

        return size;
    }
}
