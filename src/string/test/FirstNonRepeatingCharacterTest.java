package string.test;

import string.main.FirstNonRepeatingCharacter;

import java.util.Scanner;

public class FirstNonRepeatingCharacterTest {
    static void main(String[] args) {
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter word for finding first non repeating character: ");
        String input = scanner.nextLine();

        char result = obj.findFirstNonRepeating(input);

        if(result != ' ') System.out.println("First Non-Repeating Character: " + result);
        else System.out.println("No Non-Repeating Character Found");

        scanner.close();
    }
}
