package assignments.assignment16_03.libraryBookCirculationSystem;

import java.util.*;

public class LibraryManager {
    private final Set<Book> books = new HashSet<>();
    private final Queue<IssueRequest> issueQueue = new LinkedList<>();

    public void addBook(Book b) {
        if (b == null) {
            System.out.println("Error: Book cannot be null");
            return;
        }
        
        // Check if book with same ID already exists
        for (Book book : books) {
            if (book.getBookId() == b.getBookId()) {
                System.out.println("Error: Duplicate Book ID. Book already exists!");
                return;
            }
        }
        
        if (books.add(b)) {
            System.out.println("✓ Book Added Successfully!");
        } else {
            System.out.println("Error: Failed to add book");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library");
            return;
        }
        for (Book b : books) {
            System.out.println(b.displayBook());
        }
    }

    public void addIssueRequest(IssueRequest r) {
        if (r == null) {
            System.out.println("Error: Invalid request");
            return;
        }
        
        // Check if book exists and has sufficient quantity
        Book foundBook = findBookById(r.getBookId());
        if (foundBook == null) {
            System.out.println("Error: Book not found");
            return;
        }
        
        if (foundBook.getQuantity() < r.getQuantityRequested()) {
            System.out.println("Error: Insufficient quantity. Available: " + foundBook.getQuantity());
            return;
        }
        
        issueQueue.add(r);
        System.out.println("✓ Request added to queue");
    }

    public void processIssueRequest() {
        IssueRequest r = issueQueue.poll();

        if (r == null) {
            System.out.println("No requests pending");
            return;
        }

        Book foundBook = findBookById(r.getBookId());
        if (foundBook != null) {
            foundBook.decreaseQuantity(r.getQuantityRequested());
            System.out.println("✓ Request Processed: " + r);
            System.out.println("Remaining quantity: " + foundBook.getQuantity());
        }
    }

    public void removeBook(int id) {
        if (id <= 0) {
            System.out.println("Error: Invalid Book ID");
            return;
        }
        
        Iterator<Book> itr = books.iterator();

        while (itr.hasNext()) {
            Book b = itr.next();

            if (b.getBookId() == id) {
                itr.remove();
                System.out.println("✓ Book Removed Successfully!");
                return;
            }
        }
        System.out.println("Error: Book not found");
    }
    
    private Book findBookById(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        return null;
    }
    
    public void returnBook(int bookId, int quantityReturned) {
        if (!ValidationUtil.isValidBookId(bookId)) {
            System.out.println("Error: Invalid Book ID");
            return;
        }
        if (!ValidationUtil.isValidQuantity(quantityReturned)) {
            System.out.println("Error: Quantity must be at least 1");
            return;
        }
        
        Book foundBook = findBookById(bookId);
        if (foundBook != null) {
            foundBook.increaseQuantity(quantityReturned);
            System.out.println("✓ Book returned successfully. New quantity: " + foundBook.getQuantity());
        } else {
            System.out.println("Error: Book not found");
        }
    }
}
