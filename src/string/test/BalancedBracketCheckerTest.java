package string.test;

import string.main.BalancedBracketChecker;

import java.util.Scanner;

public class BalancedBracketCheckerTest {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BalancedBracketChecker obj = new BalancedBracketChecker();

        System.out.println("Give input with brackets (eg. (a+b) * [c-d]):");
        String input = scanner.nextLine();

        if (obj.isBalanced(input)) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }
}
