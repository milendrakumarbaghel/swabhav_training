package assignment10_03_26.test;

import assignment10_03_26.main.StaffMenuController;

import java.util.Scanner;

public class HospitalStaffSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = readInt(scanner);

        StaffMenuController controller = new StaffMenuController(size);

        controller.startMenu();
    }

    public static int readInt(Scanner scanner) {
        int size;

        while (true) {

            try {

                System.out.print("Enter number of staff records to store: ");
                size = Integer.parseInt(scanner.nextLine());

                if (size <= 0)
                    throw new IllegalArgumentException("Size must be positive.");

                break;
            }

            catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }

            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return size;
    }
}
