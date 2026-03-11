package oops.polymorphism;

class Parent1 {
    void show() {
        System.out.println("Parent method");
    }
}

class Child1 extends Parent1 {
    void display() {
        System.out.println("Child method");
    }
}

public class Upcasting {
    public static void main(String[] args) {

        Parent1 p = new Child1();   // Upcasting

        p.show(); // allowed
        // p.display(); // not allowed
    }
}
