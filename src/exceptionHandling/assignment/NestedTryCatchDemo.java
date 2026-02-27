package exceptionHandling.assignment;

import java.util.Scanner;

public class NestedTryCatchDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Enter x: ");
            int x = scanner.nextInt();

            System.out.println("Enter y: ");
            int y = scanner.nextInt();

            int out = x / y;
            System.out.println("Division result: " + out);

            try {
                System.out.println("Enter size of array between (0-9): ");
                int size = scanner.nextInt();
                int[] arr = new int[size];

                System.out.println("Enter index you want to insert element: ");
                int index = scanner.nextInt();
                arr[index] = 10;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner: Array index error");
            }

        } catch (ArithmeticException e) {
            System.out.println("Outer: Arithmetic error");
        } finally {
            scanner.close();
        }
    }
}
