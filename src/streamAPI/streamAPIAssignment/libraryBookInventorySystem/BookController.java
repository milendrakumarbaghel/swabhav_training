package streamAPI.streamAPIAssignment.libraryBookInventorySystem;

import java.util.*;
import java.util.stream.Collectors;

public class BookController {
    private List<Book> books = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public void start() {
        books.add(new Book(1, "Java Basics", "James Gosling", "Programming", true, 500));
        books.add(new Book(2, "Spring Boot", "Rod Johnson", "Programming", false, 800));
        books.add(new Book(3, "Harry Potter", "J.K. Rowling", "Fantasy", true, 600));

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Available Books");
            System.out.println("3. Group Books by Genre");
            System.out.println("4. Count Books Genre-wise");
            System.out.println("5. Most Expensive Book");
            System.out.println("6. Sorted Titles by Price");
            System.out.println("7. Check Any Unavailable Book");
            System.out.println("8. Unique Authors");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook();

                case 2 -> showAvailableBooks();

                case 3 -> groupByGenre();

                case 4 -> countByGenre();

                case 5 -> mostExpensiveBook();

                case 6 -> sortedTitles();

                case 7 -> checkUnavailable();

                case 8 -> uniqueAuthors();

                case 0 -> System.out.println("Exiting...");

                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        System.out.print("Is Available (true/false): ");
        boolean available = sc.nextBoolean();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        books.add(new Book(id, title, author, genre, available, price));
        System.out.println("Book added successfully!");
    }

    private void showAvailableBooks() {
        List<Book> result = books.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());

        System.out.println("Available Books: " + result);
    }

    private void groupByGenre() {
        Map<String, List<Book>> result = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));

        System.out.println(result);
    }

    private void countByGenre() {
        Map<String, Long> result = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.counting()
                ));

        System.out.println(result);
    }

    private void mostExpensiveBook() {
        books.stream()
                .max(Comparator.comparing(Book::getPrice))
                .ifPresent(b -> System.out.println("Most Expensive: " + b));
    }

    private void sortedTitles() {
        List<String> result = books.stream()
                .sorted(Comparator.comparing(Book::getPrice))
                .map(Book::getTitle)
                .collect(Collectors.toList());

        System.out.println(result);
    }

    private void checkUnavailable() {
        boolean exists = books.stream()
                .anyMatch(b -> !b.isAvailable());

        System.out.println("Any unavailable book: " + exists);
    }

    private void uniqueAuthors() {
        Set<String> result = books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());

        System.out.println(result);
    }
}
