package comparableComparator.main;

import java.util.Comparator;

public class TransactionComparator implements Comparator<Transaction> {
    public int compare(Transaction t1, Transaction t2) {
        int amount = Double.compare(t2.amount, t1.amount);

        if(amount != 0) {
            return amount;
        }

        return t1.id - t2.id;
    }
}
