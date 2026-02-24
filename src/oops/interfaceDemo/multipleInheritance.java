package oops.interfaceDemo;

interface Father {
    void height();
}

interface Mother {
    void intelligence();
}

class Child implements Father, Mother {

    public void height() {
        System.out.println("Height from Father");
    }

    public void intelligence() {
        System.out.println("Intelligence from Mother");
    }
}


public class multipleInheritance {
    static void main(String[] args) {

        Child c = new Child();

        c.height();
        c.intelligence();
    }
}
