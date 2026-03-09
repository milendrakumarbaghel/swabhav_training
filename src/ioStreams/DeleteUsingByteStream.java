package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DeleteUsingByteStream {
    static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("src/ioStreams/input.txt");
        FileOutputStream fos = new FileOutputStream("src/ioStreams/delete.txt");

        int data;
        StringBuilder content = new StringBuilder();

        while((data = fis.read()) != -1) {
            content.append((char)data);
        }
        System.out.println("Content before delete");
        System.out.println(content);

        String modified = content.toString().replace("They work with 8-bit bytes.", "");

        fos.write(modified.getBytes());
        System.out.println();
        System.out.println();
        System.out.println("Content deleted successfully");
        System.out.println(modified);

        fis.close();
        fos.close();
    }
}
