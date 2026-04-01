package solidPrinciple.inventoryManagementSystem.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Please enter a value between " + min + " and " + max + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value <= 0) {
                System.out.println("Value must be greater than 0.");
                continue;
            }
            return value;
        }
    }

    public int readNonNegativeInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value < 0) {
                System.out.println("Value cannot be negative.");
                continue;
            }
            return value;
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Value must be greater than 0.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    public String readYesNo(String prompt) {
        while (true) {
            String input = readNonEmptyString(prompt).toLowerCase(Locale.ROOT);
            if ("yes".equals(input) || "no".equals(input)) {
                return input;
            }
            System.out.println("Please enter only 'yes' or 'no'.");
        }
    }

    public LocalDate readFutureDate(String prompt) {
        while (true) {
            String input = readNonEmptyString(prompt);
            try {
                LocalDate date = LocalDate.parse(input);
                if (!date.isAfter(LocalDate.now())) {
                    System.out.println("Expiry date must be in the future.");
                    continue;
                }
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use yyyy-mm-dd.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
