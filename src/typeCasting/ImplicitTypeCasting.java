package typeCasting;

public class ImplicitTypeCasting {
    public static void main(String[] args) {
//        Implicit (Widening)
//        Smaller → Bigger type
        int a = 10;
        double b = a;  // automatic (type promotion/implicit type casting)
        System.out.println(a);
        System.out.println(b);

//        byte → short → int → long → float → double
//                        ^
//                        |
//               char ----
    }
}
