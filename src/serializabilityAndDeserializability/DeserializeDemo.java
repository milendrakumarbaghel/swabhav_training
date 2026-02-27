package serializabilityAndDeserializability;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"));

            Student s = (Student) ois.readObject();  // Deserializing

            ois.close();

            System.out.println(s.id + " " + s.name);
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}
