package conditionalStatements;

import java.util.Scanner;

public class NumberSignChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for checking Positive/Negative/Zero: ");
        int number = scanner.nextInt();

        String signType;
        if (number > 0) {
            signType = "Positive";
        } else if (number < 0) {
            signType = "Negative";
        } else {
            signType = "Zero";
        }

        System.out.println("Sign of Integer is: " + signType);
        scanner.close();

    }
}