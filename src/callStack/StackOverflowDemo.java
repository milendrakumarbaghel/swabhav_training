package callStack;

public class StackOverflowDemo {
    public static void test() {
        test();   // infinite recursion
    }

    public static void main(String[] args) {
        test();
    }
}
