package oops.constructor;

import java.io.NotActiveException;

class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
//        super();
//        this();
        this("Ram");
    }

//    this() && super()  --> Not Allowed
//    this.variable && super.variable --> Allowed
//    this.method() && super.method() --> Allowed

    Child(String str) {
//        super();
        System.out.println(str);
    }
}

class Main {
    public static void main(String[] args) {
        Child child = new Child();
    }
}