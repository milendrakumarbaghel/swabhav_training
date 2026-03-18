package assignments.assignment16_03.libraryBookCirculationSystem;

public class Magazine extends Book{
    private String issueMonth;
    private int issueYear;

    public Magazine(int bookId, String title, String author,
                    String issueMonth, int issueYear) {

        super(bookId, title, author);
        this.issueMonth = issueMonth;
        this.issueYear = issueYear;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Issue:" + issueMonth +
                " " + issueYear;
    }
}
