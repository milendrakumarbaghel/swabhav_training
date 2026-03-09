package string.test;

import string.main.WordReverser;

import java.util.Scanner;

public class WordReverserTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordReverser obj = new WordReverser();

        System.out.println("Enter sentence for reversing");
        String input = scanner.nextLine();

        String result = obj.reverseWords(input);
        System.out.println(result);

        scanner.close();
    }
}
