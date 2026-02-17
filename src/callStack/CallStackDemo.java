package callStack;

public class CallStackDemo {
    public static void main(String[] args) {
        System.out.println("Main started");
        methodA();
        System.out.println("Main ended");
    }

    public static void methodA() {
        System.out.println("Method A started");
        methodB();
        System.out.println("Method A ended");
    }

    public static void methodB() {
        System.out.println("Method B executed");
    }
}
