package conditionalStatements;

import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for checking Armstrong Number: ");
        int number = scanner.nextInt();

        if (number >= 100 && number <= 999) {
            int original = number;
            int sum = 0;

            while (number != 0) {
                int digit = number % 10;
                sum += (digit * digit * digit);
                number /= 10;
            }

            if (sum == original) {
                System.out.println("Armstrong");
            } else {
                System.out.println("Not Armstrong");
            }
        } else {
            System.out.println("Not a 3-digit number");
        }

        scanner.close();
    }
}