package assignments.assignment16_03.libraryBookCirculationSystem;

public abstract class Book implements Comparable<Book> {
    protected int bookId;
    protected String title;
    protected String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Book b) {
        return this.title.compareToIgnoreCase(b.title);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(!(obj instanceof Book))
            return false;

        Book b = (Book) obj;
        return this.bookId == b.bookId;
    }

    @Override
    public int hashCode() {
        return bookId;
    }

    @Override
    public String toString() {
        return bookId + " " + title + " " + author;
    }
}