package typeCasting;

public class implicitTypeCasting {
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




//        Explicit (Narrowing)
//        Bigger → Smaller type
        double c = 10.5;
//        int d = c;  // Getting Error --> incompatible types: possible lossy conversion from double to int
//        System.out.println(d);
        int d = (int) c;  // manual casting
        System.out.println(c);
        System.out.println(d);

    }
}
