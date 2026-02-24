package oops.interfaceDemo;

interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }

    public void stop()  {
        System.out.println("car stopped by car class");
    }
}

public class defaultMethods {
    static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}
