package exceptionHandling;

import java.io.IOException;
import java.sql.SQLException;

public class ThrowsKeyword {
    static void test() throws IOException, SQLException {
        throw new IOException("IO Problem");
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (IOException | SQLException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
