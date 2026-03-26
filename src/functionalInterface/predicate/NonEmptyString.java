package functionalInterface.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class NonEmptyString {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String name = scanner.nextLine();

        Predicate<String> isEmpty = str -> str.length() > 0;

        if (isEmpty.test(name)) {
            System.out.println("Non-Empty");
        } else {
            System.out.println("Empty");
        }
    }

//    public static void main(String[] args) {
//
//        List<String> list = Arrays.asList("", "Java", null, " ");
//
//        Predicate<String> isValid =
//                s -> s != null && !s.trim().isEmpty();
//
//        for(String s :list){
//            if (isValid.test(s)) {
//                System.out.println(s);
//            }
//        }
//    }
}
