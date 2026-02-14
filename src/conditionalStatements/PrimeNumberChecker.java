package conditionalStatements;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for checking Prime Number: ");
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i*i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");

        scanner.close();
    }
}