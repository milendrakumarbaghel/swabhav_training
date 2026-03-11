package oops.polymorphism;


class Parent {
    public static void methodOne() {
        System.out.println("Parent method");
    }
}
class Child extends Parent {
    public static void methodOne() {
        System.out.println("Child method");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
//        Parent p = new Child();
//        p.methodOne(); // Output: Parent method (based on reference type, not object)

//        Child child = new Child();
//        child.methodOne();

//        Child child = new Parent(); //not allowed because parent doesn't contain child property
    }


}
