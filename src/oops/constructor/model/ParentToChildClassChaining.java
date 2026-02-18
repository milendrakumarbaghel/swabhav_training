package oops.constructor.model;

public class ParentToChildClassChaining {
    public static void main(String[] args) {
        Child child = new Child();
    }
}

class Parent {
    Parent() {
        System.out.println("Parent Class Constructor");
    }
}

class Child extends Parent {
    Child() {
        super();
        System.out.println("Child Class Constructor");
    }
}
