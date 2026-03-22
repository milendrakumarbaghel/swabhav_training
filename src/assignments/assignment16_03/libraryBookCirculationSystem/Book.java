package assignments.assignment16_03.libraryBookCirculationSystem;

public abstract class Book {
    protected int bookId;
    protected String title;
    protected String author;
    protected int quantity;

    public Book(int bookId, String title, String author, int quantity) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        if (ValidationUtil.isValidQuantity(quantity)) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
    }
    
    public void decreaseQuantity(int count) {
        if (count > 0 && count <= quantity) {
            this.quantity -= count;
        } else {
            throw new IllegalArgumentException("Invalid quantity to decrease");
        }
    }
    
    public void increaseQuantity(int count) {
        if (count > 0) {
            this.quantity += count;
        } else {
            throw new IllegalArgumentException("Quantity to increase must be positive");
        }
    }

    public String displayBook() {
        return "Book Id: " + bookId + ", Title: " + title + ", Author: " + author + ", Quantity: " + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return this.bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(bookId);
    }
}