package strings;

import java.util.Scanner;

public class FindSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String mainStr = scanner.nextLine();

        System.out.print("Enter substring: ");
        String subStr = scanner.nextLine();

        if (mainStr.contains(subStr)) {
            int index = mainStr.indexOf(subStr);
            System.out.println("Substring found at index: " + index);
        } else {
            System.out.println("Substring not found.");
        }
    }
}