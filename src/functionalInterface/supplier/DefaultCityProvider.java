package functionalInterface.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Supplier<String> defaultCity = () -> "Pune";

        System.out.print("Enter city (press Enter to skip): ");
        String input = sc.nextLine();

        String city = (input == null || input.trim().isEmpty())
                ? defaultCity.get()
                : input;

        System.out.println("City: " + city);
    }
}
