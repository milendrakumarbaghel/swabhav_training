package exceptionHandling;

import java.io.IOException;

public class ExceptionPropagation {
    static void method3() throws IOException {
        throw new IOException("Error in method3");
    }

    static void method2() throws IOException {
        method3();
    }

    static void method1() {
        try {
            method2();
        } catch (IOException e) {
            System.out.println("Handled in method1");
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
