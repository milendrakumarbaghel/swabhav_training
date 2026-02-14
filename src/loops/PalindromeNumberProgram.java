package loops;

import java.util.Scanner;

public class PalindromeNumberProgram {
    public static boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        if (num < 0)
            return false;

        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }

        return original == reverse;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (isPalindrome(num))
            System.out.println(num + " is a Palindrome number.");
        else
            System.out.println(num + " is NOT a Palindrome number.");

        scanner.close();
    }
}