package string.test;

import string.main.EmailAnalyzer;

import java.util.Scanner;

public class EmailAnalyzerTest {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmailAnalyzer analyzer = new EmailAnalyzer();

        System.out.print("Enter email (eg. john.doe@gmail.com): ");
        String email = sc.nextLine();

        email = analyzer.trimEmail(email);

        if (!analyzer.containsAtSymbol(email)) {
            System.out.println("Invalid Email. '@' symbol missing.");
            return;
        }

        email = analyzer.convertToLowerCase(email);

        String username = analyzer.getUsername(email);
        String domain = analyzer.getDomain(email);

        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);

        int length = analyzer.usernameLength(username);
        System.out.println("Total characters in username: " + length);

        boolean hasDigits = analyzer.containsDigit(username);
        System.out.println("Contains digits: " + (hasDigits ? "Yes" : "No"));

        String modifiedUsername = analyzer.replaceDots(username);
        System.out.println("Modified username: " + modifiedUsername);

        if (analyzer.isGmail(domain)) {
            System.out.println("Email belongs to Gmail.");
        } else {
            System.out.println("Email does not belong to Gmail.");
        }

        sc.close();
    }
}
