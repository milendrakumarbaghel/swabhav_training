package exceptionHandling;

import java.util.Scanner;

public class ExceptionHandlingDemo {
    static void main(String[] args) {
//        int a = 10/0;
//        System.out.println("exception not caught or handled");


//        try {
//            int a = 10 / 0;
//        } catch (ArithmeticException e) {
//            System.out.println("Cannot divide by zero");
//        }
//        System.out.println("continued after exception caught");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = scanner.nextInt();
        System.out.println("Enter y: ");
        int y = scanner.nextInt();

        try {
            int a = x/y;
//            System.exit(0);
            return;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("finally block");
            scanner.close();
        }

    }
}
