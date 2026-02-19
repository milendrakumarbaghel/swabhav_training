package statickeyword;

class Student {
    static String schoolName = "Raju ka school";

    public void display() {
        System.out.println("School name is: " + schoolName);
    }
}

public class StaticVariable {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        student1.display();
        student2.display();
    }
}
