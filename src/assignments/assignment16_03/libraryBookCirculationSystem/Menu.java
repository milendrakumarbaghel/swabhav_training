package assignments.assignment16_03.libraryBookCirculationSystem;

import java.util.Scanner;

public class Menu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        LibraryManager lib = new LibraryManager();

        while (true) {
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add Academic Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display All Books");
            System.out.println("4. Add Issue Request");
            System.out.println("5. Process Issue Request");
            System.out.println("6. Return Book");
            System.out.println("7. Remove Book");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a number between 1 and 8.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addAcademicBook(scanner, lib);
                    break;

                case 2:
                    addMagazine(scanner, lib);
                    break;

                case 3:
                    System.out.println("\nLIBRARY BOOKS");
                    lib.displayBooks();
                    break;

                case 4:
                    addIssueRequest(scanner, lib);
                    break;

                case 5:
                    lib.processIssueRequest();
                    break;
                    
                case 6:
                    returnBook(scanner, lib);
                    break;

                case 7:
                    removeBook(scanner, lib);
                    break;

                case 8:
                    System.out.println("\nThank you for using Library Management System. Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Error: Invalid choice! Please enter a number between 1 and 8.");
            }
        }
    }

    private void addAcademicBook(Scanner scanner, LibraryManager lib) {
        try {
            System.out.print("Enter Book ID: ");
            int id = scanner.nextInt();
            if (!ValidationUtil.isValidBookId(id)) {
                System.out.println("Error: Book ID must be positive");
                return;
            }

            scanner.nextLine();
            
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            if (!ValidationUtil.isValidTitle(title)) {
                System.out.println("Error: Title must be between 1-100 characters");
                return;
            }

            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            if (!ValidationUtil.isValidAuthor(author)) {
                System.out.println("Error: Author name must be between 1-100 characters");
                return;
            }

            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            if (!ValidationUtil.isValidSubject(subject)) {
                System.out.println("Error: Subject must be between 1-50 characters");
                return;
            }

            System.out.print("Enter Semester (1-8): ");
            int semester = scanner.nextInt();
            if (!ValidationUtil.isValidSemester(semester)) {
                System.out.println("Error: Semester must be between 1 and 8");
                return;
            }
            
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            if (!ValidationUtil.isValidQuantity(quantity)) {
                System.out.println("Error: Quantity must be at least 1");
                return;
            }

            Book ab = new AcademicBook(id, title, author, subject, semester, quantity);
            lib.addBook(ab);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void addMagazine(Scanner scanner, LibraryManager lib) {
        try {
            System.out.print("Enter Book ID: ");
            int id = scanner.nextInt();
            if (!ValidationUtil.isValidBookId(id)) {
                System.out.println("Error: Book ID must be positive");
                return;
            }

            scanner.nextLine();
            
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            if (!ValidationUtil.isValidTitle(title)) {
                System.out.println("Error: Title must be between 1-100 characters");
                return;
            }

            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            if (!ValidationUtil.isValidAuthor(author)) {
                System.out.println("Error: Author name must be between 1-100 characters");
                return;
            }

            System.out.print("Enter Issue Month (e.g., January or 1): ");
            String month = scanner.nextLine();
            if (!ValidationUtil.isValidMonth(month)) {
                System.out.println("Error: Invalid month. Use month name or number (1-12)");
                return;
            }

            System.out.print("Enter Issue Year: ");
            int year = scanner.nextInt();
            if (!ValidationUtil.isValidYear(year)) {
                System.out.println("Error: Year must be between 1900 and current year");
                return;
            }
            
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            if (!ValidationUtil.isValidQuantity(quantity)) {
                System.out.println("Error: Quantity must be at least 1");
                return;
            }

            Book mag = new Magazine(id, title, author, month, year, quantity);
            lib.addBook(mag);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void addIssueRequest(Scanner scanner, LibraryManager lib) {
        try {
            System.out.print("Enter Request ID: ");
            int rid = scanner.nextInt();
            if (!ValidationUtil.isValidRequestId(rid)) {
                System.out.println("Error: Request ID must be positive");
                return;
            }

            System.out.print("Enter Book ID: ");
            int bid = scanner.nextInt();
            if (!ValidationUtil.isValidBookId(bid)) {
                System.out.println("Error: Book ID must be positive");
                return;
            }

            scanner.nextLine();
            System.out.print("Enter Requester Name: ");
            String name = scanner.nextLine();
            if (!ValidationUtil.isValidRequesterName(name)) {
                System.out.println("Error: Name must be between 1-100 characters");
                return;
            }
            
            System.out.print("Enter Quantity Requested: ");
            int quantity = scanner.nextInt();
            if (!ValidationUtil.isValidQuantity(quantity)) {
                System.out.println("Error: Quantity must be at least 1");
                return;
            }

            IssueRequest req = new IssueRequest(rid, bid, name, quantity);
            lib.addIssueRequest(req);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. " + e.getMessage());
            scanner.nextLine();
        }
    }
    
    private void returnBook(Scanner scanner, LibraryManager lib) {
        try {
            System.out.print("Enter Book ID: ");
            int bookId = scanner.nextInt();
            if (!ValidationUtil.isValidBookId(bookId)) {
                System.out.println("Error: Book ID must be positive");
                return;
            }
            
            System.out.print("Enter Quantity to Return: ");
            int quantity = scanner.nextInt();
            if (!ValidationUtil.isValidQuantity(quantity)) {
                System.out.println("Error: Quantity must be at least 1");
                return;
            }
            
            lib.returnBook(bookId, quantity);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. " + e.getMessage());
            scanner.nextLine();
        }
    }

    private void removeBook(Scanner scanner, LibraryManager lib) {
        try {
            System.out.print("Enter Book ID to remove: ");
            int removeId = scanner.nextInt();
            if (!ValidationUtil.isValidBookId(removeId)) {
                System.out.println("Error: Book ID must be positive");
                return;
            }
            lib.removeBook(removeId);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input. " + e.getMessage());
            scanner.nextLine();
        }
    }
}
