package wrapperClasses;

public class UnBoxing {
    public static void main(String[] args) {
        Integer obj = 20;
        int b = obj;   // Unboxing (also automatically convert wrapper object into primitive variable)

        // Internally java run intValue() method --> int b = obj.intValue();

        System.out.println("Value of obj (Integer): " + obj);
        System.out.println("Value of a (int): " + b);
    }
}
