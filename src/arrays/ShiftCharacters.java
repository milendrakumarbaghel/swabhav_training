package arrays;

import java.util.Scanner;

public class ShiftCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String str = sc.nextLine();

        while (str.isEmpty()) {
            System.out.print("Please enter non-empty string: ");
            str = sc.nextLine();
        }

        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ch = (char) (ch + shift);
            result += ch;
        }

        System.out.println("Shifted string: " + result);
    }
}