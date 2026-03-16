package evaluationPractice;

interface T1 {
    default void show() {
        System.out.println("A show");
    }
}
class T2 implements T1 {

}

public class Experiment {
     static void main(String[] args) {
        T1 obj = new T2();
        obj.show();
    }
}
