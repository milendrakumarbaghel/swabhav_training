package typeCasting;

public class ExplicitTypeCasting {
    public static void main(String[] args) {
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
