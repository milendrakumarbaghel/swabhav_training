package string.test;

import string.main.PasswordValidator;

import java.util.Scanner;

public class PasswordValidatorTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordValidator validator = new PasswordValidator();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        password = validator.removeSpaces(password);

        boolean lengthValid = validator.isLengthValid(password);
        boolean hasUpper = validator.hasUpperCase(password);
        boolean hasLower = validator.hasLowerCase(password);
        boolean hasDigit = validator.hasDigit(password);

        System.out.println("Password: " + password);
        System.out.println("Length valid: " + (lengthValid ? "Yes" : "No"));
        System.out.println("Contains uppercase: " + (hasUpper ? "Yes" : "No"));
        System.out.println("Contains lowercase: " + (hasLower ? "Yes" : "No"));
        System.out.println("Contains digit: " + (hasDigit ? "Yes" : "No"));

        if (validator.isValidPassword(password)) {
            System.out.println("Password is VALID");
        } else {
            System.out.println("Password is INVALID");
        }

        scanner.close();
    }
}
