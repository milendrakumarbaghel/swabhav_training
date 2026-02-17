package ioStreams;

import java.io.FileWriter;
import java.io.IOException;

public class CharacterOutputStream {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("src/ioStreams/output.txt");

            fw.write("Hello Java Character Stream!");
            fw.close();

            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
