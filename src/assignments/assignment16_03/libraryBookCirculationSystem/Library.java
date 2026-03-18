package assignments.assignment16_03.libraryBookCirculationSystem;

import java.util.*;

public class Library {
    private Set<Book> books = new HashSet<>();
    private TreeSet<Book> sortedBooks = new TreeSet<>();
    private Queue<IssueRequest> issueQueue = new LinkedList<>();

    public void addBook(Book b) {
        if(books.add(b)) {
            sortedBooks.add(b);
            System.out.println("Book Added");
        } else
            System.out.println("Duplicate Book Not Allowed");
    }

    public void displayBooks() {
        for(Book b : sortedBooks)
            System.out.println(b);
    }

    public void addIssueRequest(IssueRequest r) {
        issueQueue.add(r);
    }

    public void processIssueRequest() {
        IssueRequest r = issueQueue.poll();

        if(r == null) {
            System.out.println("No requests pending");
            return;
        }

        System.out.println("Processing Request: " + r);
    }

    public void removeBook(int id) {
        Iterator<Book> itr = books.iterator();

        while(itr.hasNext()) {
            Book b = itr.next();

            if(b.getBookId() == id) {
                itr.remove();
                sortedBooks.remove(b);
                System.out.println("Book Removed");
            }
        }
    }
}
