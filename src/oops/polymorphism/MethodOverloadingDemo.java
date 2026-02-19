package oops.polymorphism;

// static binding
// compile time polymorphism
class Demo {
    void show(int x) {
        System.out.println("int version: " + x);
    }

    void show(double x) {
        System.out.println("double version: " + x);
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.show(10);       // exact match with int → calls int version
        d.show(10.5);     // exact match with double → calls double version
        d.show('A');      // 'A' is char, promoted to int → calls int version
        d.show(10L);      // long → promoted to double → calls double version
    }
}
