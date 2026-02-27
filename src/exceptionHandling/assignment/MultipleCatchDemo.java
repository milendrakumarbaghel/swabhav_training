package exceptionHandling.assignment;

import java.util.Scanner;

public class MultipleCatchDemo {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            stringInitializer(scanner);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Accessing invalid index" + e.getMessage());

        } catch (NullPointerException e) {
            System.out.println("null values does not have length" + e.getMessage());

        } finally {
            scanner.close();
        }
    }

    public static void stringInitializer(Scanner scanner) {
        System.out.println("Enter size of array between (0-9): ");
        int size = scanner.nextInt();
        String[] strings = new String[size];

        System.out.println("Assigning string value {hello} at index 10: ");
        strings[0] = "hello";
        System.out.println(strings[0]);

        System.out.println("Accessing length of string at 1st position");
        int length = strings[1].length();
        System.out.println("Length of string at 1st position is: " + length);
    }
}
