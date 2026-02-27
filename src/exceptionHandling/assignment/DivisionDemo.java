package exceptionHandling.assignment;

import java.util.Scanner;

public class DivisionDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter x: ");
            int x = scanner.nextInt();

            System.out.println("Enter y: ");
            int y = scanner.nextInt();

            int out = x/y;
            System.out.println("Division result: " + out);

        } catch (ArithmeticException e) {
            System.out.println("Can't divide by zero");
            e.getMessage();
        } catch (Exception e) {
            System.out.println("Invalid input");
        } finally {
            scanner.close();
        }
    }
}
