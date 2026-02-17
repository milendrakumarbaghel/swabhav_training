package AccessModifiers.package1;

public class Test {
    public void publicMethod() {
        System.out.println("test class public method is executed (public access modifier example)");
    }

    void defaultMethod() {
        System.out.println("test class default method is executed (default access modifier example)");
    }

    protected void protectedMethod() {
        System.out.println("test class protected method is executed (protected access modifier example)");
    }

    private void privateMethod() {
        System.out.println("test class private method is executed (private access modifier example)");
    }
}