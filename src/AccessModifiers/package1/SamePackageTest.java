package AccessModifiers.package1;

import AccessModifiers.package1.*;

public class SamePackageTest {
    public static void main(String[] args) {
        Test test = new Test();

        test.publicMethod();
        test.defaultMethod();
        test.protectedMethod();
    }
}
