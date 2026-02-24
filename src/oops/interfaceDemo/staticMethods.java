package oops.interfaceDemo;

interface MathUtil {
    void show();

    static int add(int a, int b) {
        return a + b;
    }
}

class Test implements MathUtil {
    public void show() {
        System.out.println("show method");
    }
}

public class staticMethods {
    static void main(String[] args) {

        Test test = new Test();
        test.show();
//        test.add(25, 26);

        System.out.println(MathUtil.add(25, 26));
    }
}
