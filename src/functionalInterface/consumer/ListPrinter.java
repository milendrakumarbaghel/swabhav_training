package functionalInterface.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ListPrinter {
    static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Mango");

        Consumer<List<String>> printList = l -> {
            for (String item : l) {
                System.out.println(item);
            }
        };

        printList.accept(list);
    }
}
