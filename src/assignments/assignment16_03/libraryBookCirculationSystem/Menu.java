package assignments.assignment16_03.libraryBookCirculationSystem;

import java.util.Scanner;

public class Menu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\nLIBRARY MENU");
            System.out.println("1. Add Academic Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Display Books");
            System.out.println("4. Add Issue Request");
            System.out.println("5. Process Issue Request");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id1 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title1 = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author1 = scanner.nextLine();

                    System.out.print("Enter Subject: ");
                    String subject = scanner.nextLine();

                    System.out.print("Enter Semester: ");
                    int sem = scanner.nextInt();

                    Book ab = new AcademicBook(id1, title1, author1, subject, sem);
                    lib.addBook(ab);
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int id2 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Title: ");
                    String title2 = scanner.nextLine();

                    System.out.print("Enter Author: ");
                    String author2 = scanner.nextLine();

                    System.out.print("Enter Issue Month: ");
                    String month = scanner.nextLine();

                    System.out.print("Enter Issue Year: ");
                    int year = scanner.nextInt();

                    Book mag = new Magazine(id2, title2, author2, month, year);
                    lib.addBook(mag);
                    break;

                case 3:
                    System.out.println("\nLibrary Books");
                    lib.displayBooks();
                    break;

                case 4:
                    System.out.print("Enter Request ID: ");
                    int rid = scanner.nextInt();

                    System.out.print("Enter Book ID: ");
                    int bid = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Requester Name: ");
                    String name = scanner.nextLine();

                    IssueRequest req = new IssueRequest(rid, bid, name);
                    lib.addIssueRequest(req);
                    break;

                case 5:
                    lib.processIssueRequest();
                    break;

                case 6:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    lib.removeBook(removeId);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
