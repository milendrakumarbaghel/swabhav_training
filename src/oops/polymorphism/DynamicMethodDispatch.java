package oops.polymorphism;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Meow");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {

        Animal a = new Dog();
        a.sound();

        Animal b = new Cat();
        b.sound();
    }
}
