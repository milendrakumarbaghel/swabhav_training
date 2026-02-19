package statickeyword;

class Example {
    int x = 10;
    static int y = 20;

    void instanceMethod() {
        System.out.println(x);
        System.out.println(y);
    }

    static void staticMethod() {
//         System.out.println(x); // can't use instance variable in static methods
        System.out.println(y);
    }
}

public class StaticMethod {
    public static void main(String[] args) {
        Example e1  = new Example();

        e1.instanceMethod();
        Example.staticMethod();
    }
}
