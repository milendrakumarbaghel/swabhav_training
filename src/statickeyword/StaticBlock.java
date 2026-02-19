package statickeyword;

class StaticBlockEx {
    static {
        System.out.println("static block called");
    }

    StaticBlockEx() {
        System.out.println("constructor called");
    }
}

public class StaticBlock {
    public static void main(String[] args) {
        StaticBlockEx staticBlockEx = new StaticBlockEx();

        System.out.println("main method called");
    }
}
