package string.test;

import string.main.DuplicateWordRemover;

import java.util.Scanner;

public class DuplicateWordRemoverTest {
    static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            DuplicateWordRemover obj = new DuplicateWordRemover();
            System.out.println("Enter sentence for removing duplicate: ");
            String input = scanner.nextLine();

            String output = obj.removeDuplicates(input);

            System.out.println(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
