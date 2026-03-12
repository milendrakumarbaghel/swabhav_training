package assignments.assignment11_03.onlineOrderFulfillmentSystem;

import java.util.Scanner;

public class OnlineOrderApp {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = readInt(scanner);
        OrderMenuController controller = new OrderMenuController(size);

        controller.startMenu();
    }

    public static int readInt(Scanner scanner) {
        int size;
        while (true) {
            try {
                System.out.print("Enter number of orders: ");
                size = Integer.parseInt(scanner.nextLine());

                if (size <= 0) throw new IllegalArgumentException("Size must be positive");

                break;

            } catch (Exception e) {

                System.out.println("Invalid input");
            }
        }

        return size;
    }
}
