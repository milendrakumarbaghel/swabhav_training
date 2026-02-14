package loops;

import java.util.Scanner;

public class PrimeNumberProgram {
    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        int i = 2;

        while (i <= Math.sqrt(num)) {
            if (num % i == 0)
                return false;
            i++;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isPrime(num)) {
            System.out.println(num + " is a Prime number.");
        } else {
            System.out.println(num + " is NOT a Prime number.");
        }

        scanner.close();
    }
}