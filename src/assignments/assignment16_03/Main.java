package assignments.assignment16_03;

@FunctionalInterface
interface Greetings {
    public void sayHello(String str);
//    int add(int num1, int num2);

    String toString();
}

public class Main {
    static void main() {
//        Greetings greetings = (num1, num2) -> num1+num2;

//        System.out.println(greetings.add(5, 6));

        Greetings greetings = (str) -> System.out.println(str);
//        Greetings greetings = System.out::println;
    }
}
