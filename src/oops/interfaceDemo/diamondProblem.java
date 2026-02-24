package oops.interfaceDemo;

interface A {
    default void show() {
        System.out.println("A");
    }

//    void display();
}

interface B {
    default void show() {
        System.out.println("B");
    }

//    void display();
}

class C implements A, B {
//    void display() {
//        System.out.println("display method called");
//    }

    public void show() {
        A.super.show();  // Must resolve conflict
    }
}

public class diamondProblem {
    static void main(String[] args) {
        C c = new C();
        c.show();

//        c.display();
    }
}

