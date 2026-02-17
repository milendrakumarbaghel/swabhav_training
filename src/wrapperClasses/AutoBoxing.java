package wrapperClasses;

public class AutoBoxing {
    public static void main(String[] args) {
        int a = 10;
        Integer obj = a;  // Autoboxing (automatically convert primitive variable into wrapper object)

        // Internally java run valueOf() method --> Integer obj = Integer.valueOf(a)

        System.out.println("Value of a (int): " + a);
        System.out.println("Value of obj (Integer): " + obj);
    }
}
