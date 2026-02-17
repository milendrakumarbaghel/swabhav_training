package ioStreams;

import java.io.*;

public class BufferedWriterExample {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/ioStreams/output.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hello Buffered Writer");
        bw.newLine();
        bw.write("Second line");
        System.out.println("Write through buffered writer completed");

        bw.close();
    }
}
