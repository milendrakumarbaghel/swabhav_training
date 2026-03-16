package evaluationPractice;

abstract class A{
    public void print() {
        System.out.println("hello");
    }

    public void subject(){
        System.out.println("science");
    }

    public abstract int add(int a, int b);
}

class B extends A{
    public int add(int a, int b) { //private -> default -> protected -> public
        return a+b;
    }

//    public void subject(){
//        super.subject();
//        System.out.println("math");
//    }
}

class Singleton{
    private static Singleton instance;

    private Singleton() {
        System.out.println("singleton class created");
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance =  new Singleton(); // lazy initialization
        }

        return instance;
    }
}


class Animal{
    String eye;
    String nose;

    void move() {
        System.out.println("Animals can move");
    }

    void eat() {
        System.out.println("Animals can eat");
    }

}

class Dog extends Animal {
    int legs;

    void move() {
        System.out.println("Dog move with 4 legs");
    }

    void listen() {
        System.out.println("Dogs can listen");
    }
}


public class Test {
    static void main() {
//        long l = 99999999999999999l;
//        int i = (int) l;
//        System.out.println(i);

//        A a = new B();
//
//        System.out.println(a.add(3, 4));
//        a.print();
//        a.subject();

//        Singleton singleton1 = Singleton.getInstance();
//        Singleton singleton2 = Singleton.getInstance();
//
//        System.out.println(singleton1.hashCode());
//        System.out.println(singleton2.hashCode());

//        Animal animal = new Dog();
//        animal.listen();

        CopyConst copyConst = new CopyConst(1);
        CopyConst copyConst1 = new CopyConst(copyConst);
        //full copy
        System.out.println(copyConst1.x);
    }


}
