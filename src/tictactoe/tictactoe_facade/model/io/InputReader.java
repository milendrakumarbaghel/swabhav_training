package tictactoe.tictactoe_facade.model.io;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine() {
        return scanner.nextLine();
    }

    public boolean hasInput() {
        return scanner.hasNextLine();
    }

    public void close() {
        scanner.close();
    }
}
