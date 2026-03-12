package assignments.assignment11_03.digitalLoanProcessingSystem;

import java.util.Scanner;

public class DigitalLoanProcessingApp {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size= readInt(scanner);

        LoanMenuController controller = new LoanMenuController(size);

        controller.startMenu();
    }

    public static int readInt(Scanner scanner) {
        int size;
        while (true) {
            try {
                System.out.print("Enter number of loans: ");
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
