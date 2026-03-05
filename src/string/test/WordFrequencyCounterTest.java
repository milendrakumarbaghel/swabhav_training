package string.test;

import string.main.WordFrequencyCounter;

import java.util.Scanner;

public class WordFrequencyCounterTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        WordFrequencyCounter counter = new WordFrequencyCounter();

        counter.countFrequency(sentence);

        scanner.close();
    }
}
