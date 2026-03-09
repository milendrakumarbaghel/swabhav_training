package string.test;

import string.main.IPv4Validator;

import java.util.Scanner;

public class IPv4ValidatorTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPv4Validator obj = new IPv4Validator();

        System.out.println("Enter IPv4 address for validation (eg. 192.168.1.1): ");
        String ip = scanner.nextLine();

        if (obj.isValidIP(ip))
            System.out.println("Valid IPv4 Address");
        else
            System.out.println("Invalid IPv4 Address");
    }
}
