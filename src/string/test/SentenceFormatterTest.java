package string.test;

import jdk.jshell.spi.ExecutionControl;
import string.main.SentenceFormatter;

import java.util.Scanner;

public class SentenceFormatterTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SentenceFormatter formatter = new SentenceFormatter();

        System.out.print("Enter sentence: ");
        String sentence = scanner.nextLine();

        sentence = formatter.trimSentence(sentence);
        sentence = formatter.toLowerCase(sentence);

        System.out.println("Enter target String to be replaced from sentence: ");
        String target = scanner.nextLine();

        System.out.println("Enter replacement String which replace target in sentence: ");
        String replacement = scanner.nextLine();

        sentence = formatter.customeReplace(sentence, target, replacement);
        System.out.println("Sentence after replacement: " + sentence);
        sentence = formatter.capitalizeFirstLetter(sentence);

        int totalWords = formatter.countWords(sentence);
        String firstWord = formatter.getFirstWord(sentence);
        String lastWord = formatter.getLastWord(sentence);

        System.out.println("Formatted Sentence: " + sentence);
        System.out.println("Total words: " + totalWords);
        System.out.println("First word: " + firstWord);
        System.out.println("Last word: " + lastWord);

        scanner.close();
    }
}
