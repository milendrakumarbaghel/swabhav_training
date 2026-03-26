package functionalInterface.predicate;

import java.util.Scanner;
import java.util.function.Predicate;

public class OddNumberChecker {
//    static void main() {
//        Scanner scanner = new Scanner(System.in);
//        Predicate<Integer> isOdd = n -> n % 2 != 0;
//
//        while (true) {
//            System.out.println("\n1. Print Odd Numbers");
//            System.out.println("2. Exit");
//            System.out.print("Enter choice: ");
//
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    System.out.print("Enter range (start-end): ");
//                    System.out.println("Enter start - ");
//                    int start = scanner.nextInt();
//                    System.out.println("Enter end - ");
//                    int end = scanner.nextInt();
//
//                    System.out.print("Odd Numbers: ");
//                    for (int i = start; i <= end; i++) {
//                        if (isOdd.test(i)) {
//                            System.out.print(i + " ");
//                        }
//                    }
//                    System.out.println();
//                    break;
//
//                case 2:
//                    System.out.println("Exiting...");
//                    return;
//
//                default:
//                    System.out.println("Invalid choice!");
//            }
//        }
//    }

    public static void main(String[] args) {
        Predicate<Integer> isOdd = n -> n % 2 != 0;

        // Test from 1 to 10
        for (int i = 1; i <= 10; i++) {
            if (isOdd.test(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
