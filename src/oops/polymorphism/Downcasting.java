package oops.polymorphism;

class Parent2 {
    void show() {
        System.out.println("Parent method");
    }
}

class Child2 extends Parent2 {
    void display() {
        System.out.println("Child method");
    }
}

public class Downcasting {
    public static void main(String[] args) {
        Parent2 p = new Child2();   // Upcasting

        Child2 c = (Child2) p;      // Downcasting

        c.display();
        c.show();
    }
}
