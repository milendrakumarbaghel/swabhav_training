package assignments.assignment16_03.libraryBookCirculationSystem;

public class IssueRequest {
    private int requestId;
    private int bookId;
    private String requesterName;

    public IssueRequest(int requestId, int bookId, String requesterName) {
        this.requestId = requestId;
        this.bookId = bookId;
        this.requesterName = requesterName;
    }

    @Override
    public String toString() {
        return requestId + " -> BookId: " + bookId + " Requested By: " + requesterName;
    }
}
