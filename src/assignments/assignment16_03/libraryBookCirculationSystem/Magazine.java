package assignments.assignment16_03.libraryBookCirculationSystem;

public class Magazine extends Book{
    private String issueMonth;
    private int issueYear;

    public Magazine(int bookId, String title, String author, 
                    String issueMonth, int issueYear, int quantity) {
        super(bookId, title, author, quantity);
        
        if (!ValidationUtil.isValidMonth(issueMonth)) {
            throw new IllegalArgumentException("Invalid month");
        }
        if (!ValidationUtil.isValidYear(issueYear)) {
            throw new IllegalArgumentException("Invalid year");
        }
        
        this.issueMonth = issueMonth;
        this.issueYear = issueYear;
    }

    public String getIssueMonth() {
        return issueMonth;
    }
    
    public int getIssueYear() {
        return issueYear;
    }

    @Override
    public String displayBook() {
        return super.displayBook() + " Issue: " + issueMonth + " " + issueYear;
    }
}
