package accessModifiers.package2;

import accessModifiers.package1.*;

public class CrossPackageTest extends Test {
    public static void main(String[] args) {
        CrossPackageTest crossPackageTest = new CrossPackageTest();

        crossPackageTest.publicMethod();
        crossPackageTest.protectedMethod();
    }
}
