package wrapperClasses;

public class IntegerWrapperDemo {
    public static void main(String[] args) {
        String str1 = "123";
        int num1 = Integer.parseInt(str1);   // returns primitive int
        System.out.println("Using parseInt(): " + num1);

        String str2 = "469";
        Integer num2 = Integer.valueOf(str2);  // returns Integer object
        System.out.println("Using valueOf(): " + num2);

        System.out.println("Maximum Integer Value: " + Integer.MAX_VALUE);

        System.out.println("Minimum Integer Value: " + Integer.MIN_VALUE);

        // Difference between parseInt and valueOf
        System.out.println("Type of num1 (parseInt) is primitive int");
        System.out.println("Type of num2 (valueOf) is Integer object");

        Integer a = 100;
        Integer b = 100;

        System.out.println(a == b);  // true (Note: Java caches Integer objects between: -128 to 127)
//        Because: Both refer to same cached object

        Integer c = 200;
        Integer d = 200;

        System.out.println(c == d);  // false (Note: Outside cache range & Two different objects created)

        //Memory Behaviour

        int x = 10;
        // Stored directly in stack

        Integer y = 10;
        // Reference in stack
        // Object in heap
    }
}
