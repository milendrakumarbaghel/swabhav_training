package ioStreams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteUsingCharacterStream {
    static void main(String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("src/ioStreams/input.txt");
            fw = new FileWriter("src/ioStreams/delete.txt");

            int ch;
            StringBuilder content = new StringBuilder();

            while ((ch = fr.read()) != -1) {
                content.append((char) ch);
            }

            System.out.println("Content before delete");
            System.out.println(content);

            String modified = content.toString().replace("They work with 8-bit bytes.", "");

            fw.write(modified);
            System.out.println();
            System.out.println();
            System.out.println("Content deleted successfully");
            System.out.println(modified);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            fr.close();
            fw.close();
        }


    }
}
