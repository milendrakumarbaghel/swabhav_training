package assignments.assignment16_03.libraryBookCirculationSystem;

public class IssueRequest {
    private int requestId;
    private int bookId;
    private String requesterName;
    private int quantityRequested;

    public IssueRequest(int requestId, int bookId, String requesterName, int quantityRequested) {
        if (!ValidationUtil.isValidRequestId(requestId)) {
            throw new IllegalArgumentException("Invalid request ID");
        }
        if (!ValidationUtil.isValidBookId(bookId)) {
            throw new IllegalArgumentException("Invalid book ID");
        }
        if (!ValidationUtil.isValidRequesterName(requesterName)) {
            throw new IllegalArgumentException("Invalid requester name");
        }
        if (!ValidationUtil.isValidQuantity(quantityRequested)) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        
        this.requestId = requestId;
        this.bookId = bookId;
        this.requesterName = requesterName;
        this.quantityRequested = quantityRequested;
    }

    public int getRequestId() {
        return requestId;
    }
    
    public int getBookId() {
        return bookId;
    }
    
    public String getRequesterName() {
        return requesterName;
    }
    
    public int getQuantityRequested() {
        return quantityRequested;
    }

    @Override
    public String toString() {
        return "RequestId: " + requestId + " -> BookId: " + bookId + 
               " Requested By: " + requesterName + " Quantity: " + quantityRequested;
    }
}
