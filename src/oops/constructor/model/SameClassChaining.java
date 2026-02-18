package oops.constructor.model;

// In same class constructor chaining is done using this keyword
public class SameClassChaining {
    String name;
    int age;

    public SameClassChaining() {
        this("Milendra", 24);
        System.out.println("Default Constructor");
    }

    public SameClassChaining(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Name is updated to: " + name);
        System.out.println("Age is updated to: " + age);
    }
}
