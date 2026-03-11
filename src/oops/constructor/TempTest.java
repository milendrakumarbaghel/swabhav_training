package oops.constructor;

public class TempTest {
    static void main(String[] args) {
        Temp[] temps = new  Temp[5];

        System.out.println(Temp.count);

        for(int i = 0; i < 5; i++) {
            temps[i] = new Temp(); // Constructor called here!
        }

        System.out.println(Temp.count);
    }
}
