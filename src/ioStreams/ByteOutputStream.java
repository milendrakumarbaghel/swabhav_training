package ioStreams;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputStream {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("src/ioStreams/output.txt");

            String text = "Hello Java Byte Stream!";
            fos.write(text.getBytes());

            fos.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
