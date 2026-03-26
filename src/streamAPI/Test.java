package streamAPI;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    static void main() {
//        List<String> names = List.of("Ram","Shyam","Mohan","Ravi");
//
//        names.stream()
//                .filter(n -> n.startsWith("R"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);

//        List<Integer> list = List.of(1,2,3,4);
//
//        Stream<Integer> s = list.stream();
//        s.forEach(System.out::println);
//        s.forEach(System.out::print);  // streams only consumed once if we are running terminal operation

//        List<String> list = List.of("A","B","C");
//
//        list.stream()
//                .peek(System.out::print)
//                .forEach(s -> System.out.println(s));

//        List<Integer> list = List.of(1,2,3,4);
//
//        list.parallelStream()
//                .forEach(System.out::print);

//        List<List<Integer>> list = List.of(
//                List.of(1,2),
//                List.of(3,4)
//        );
//
//        List<Integer> flat =
//                list.stream()
//                        .flatMap(List::stream)
//                        .toList();
//
//        System.out.println(flat);

//        List<String> list = List.of("A", "B", "C");
//
//        long count = list.stream()
//                .count();
//        System.out.println(count);
//
//        long count2 = list.stream()
//                .count();
//        System.out.println(count2);

//        List<List<Integer>> list = List.of(
//                List.of(1,2),
//                List.of(3,4)
//        );

//        list.stream()
//                .flatMap(x -> x.stream())
//                .forEach(System.out::println);
//        list.stream()
//                .limit(1)
//                .forEach(System.out::println);


//        List<Integer> first3 = IntStream.rangeClosed(1, 10)
//                .boxed()
//                .skip(3)
//                .toList();
//        System.out.println(first3);

//        List<Integer> list = List.of(2,2,3,0,4,5);
//
//        list.stream()
//                .takeWhile(x -> x > 0)
//                .forEach(System.out::println);
//
//        list.stream()
//                .dropWhile(x -> x%2 == 0)
//                .forEach(System.out::println);

//        List<Integer> list = List.of(1,2,3,4);
//
//        Spliterator<Integer> sp = list.stream().spliterator();

//        sp.forEachRemaining(System.out::println);
//        while(sp.tryAdvance(System.out::println));

//        Spliterator<Integer> sp = List.of(1, 2, 3).spliterator();
//
//        sp.tryAdvance(System.out::println);
//        sp.forEachRemaining(System.out::println);
//        Spliterator<Integer> sp1 = List.of(1, 2, 3, 4).spliterator();
//
//        Spliterator<Integer> sp2 = sp1.trySplit();
//
//        sp1.forEachRemaining(System.out::println);
//
//        sp2.forEachRemaining(System.out::println);

        boolean found = IntStream.rangeClosed(1, 100)
                .peek(System.out::println)
                .anyMatch(n -> n == 5);

        System.out.println(found);

    }
}
