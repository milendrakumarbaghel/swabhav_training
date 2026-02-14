package strings;

import java.util.Scanner;

public class ShiftCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = scanner.nextLine();

        while (str.isEmpty()) {
            System.out.print("Please enter non-empty string: ");
            str = scanner.nextLine();
        }

        System.out.print("Enter shift value (Integer): ");
        int shift = scanner.nextInt();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ch = (char) (ch + shift);
            result += ch;
        }

        System.out.println("Shifted string: " + result);
    }
}