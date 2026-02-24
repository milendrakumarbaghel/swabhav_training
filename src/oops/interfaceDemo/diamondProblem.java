package oops.interfaceDemo;

interface A {
    default void show() {
        System.out.println("A");
    }

    void display();
}

interface B {
    default void show() {
        System.out.println("B");
    }

    void display();
}

class C implements A, B {

    public void display() {
        System.out.println("display method called");
    }

    public void show() {
        A.super.show();  // resolving conflict (Multiple Interface Conflict)
    }
}

public class diamondProblem {
    public static void main(String[] args) {
        C c = new C();
        c.show();
        c.display();
    }
}