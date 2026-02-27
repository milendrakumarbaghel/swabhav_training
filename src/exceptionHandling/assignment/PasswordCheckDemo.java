package exceptionHandling.assignment;

import java.util.Scanner;

public class PasswordCheckDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            checkPassword(password);

        } catch (InvalidPassswordException e) {
            System.out.println(e.getMessage());
        }
    }

    static void checkPassword(String password) throws InvalidPassswordException {
        if(password.length()<8 || !isContainsDigit(password)) {
            throw new InvalidPassswordException("Password is invalid, should contain 8 characters and contains 1 digit in it.");
        }

        System.out.println("Password is valid");
    }

    static boolean isContainsDigit(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }

        return false;
    }
}
