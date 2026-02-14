package conditionalStatements;

import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for checking Even or Odd: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        scanner.close();
    }
}