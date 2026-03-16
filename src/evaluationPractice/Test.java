package evaluationPractice;

abstract class A{
    public void print() {
        System.out.println("hello");
    }

    public void subject(){
        System.out.println("science");
    }

    public abstract int add(int a, int b);
}

class B extends A{
    public int add(int a, int b) {
        return a+b;
    }

    public void subject(){
        super.subject();
        System.out.println("math");
    }
}

public class Test {
    static void main() {
//        long l = 99999999999999999l;
//        int i = (int) l;
//        System.out.println(i);

        A a = new B();

        System.out.println(a.add(3, 4));
//        a.print();
        a.subject();
    }
}
