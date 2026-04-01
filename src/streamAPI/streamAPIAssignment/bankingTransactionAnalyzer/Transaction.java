package streamAPI.streamAPIAssignment.bankingTransactionAnalyzer;

public class Transaction {
    private int transactionId;
    private String accountHolderName;
    private String type; // DEPOSIT / WITHDRAWAL
    private double amount;
    private String branch;
    private boolean successful;

    public Transaction(int transactionId, String accountHolderName, String type,
                       double amount, String branch, boolean successful) {
        this.transactionId = transactionId;
        this.accountHolderName = accountHolderName;
        this.type = type;
        this.amount = amount;
        this.branch = branch;
        this.successful = successful;
    }

    public int getTransactionId() { return transactionId; }
    public String getAccountHolderName() { return accountHolderName; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getBranch() { return branch; }
    public boolean isSuccessful() { return successful; }

    @Override
    public String toString() {
        return "ID: " + transactionId +
                ", Name: " + accountHolderName +
                ", Type: " + type +
                ", Amount: " + amount +
                ", Branch: " + branch +
                ", Status: " + (successful ? "Success" : "Failed");
    }
}
