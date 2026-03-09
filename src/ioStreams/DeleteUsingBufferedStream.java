package ioStreams;

import java.io.*;
import java.util.Objects;

public class DeleteUsingBufferedStream {
    static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/ioStreams/input.txt"));
            bw = new BufferedWriter(new FileWriter("src/ioStreams/delete.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String modified = line.replace("They work with 8-bit bytes.", "");

                bw.write(modified);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Objects.requireNonNull(br).close();
            if (bw != null) {
                bw.close();
            }
        }
    }
}
