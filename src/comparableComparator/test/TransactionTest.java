package comparableComparator.test;

import comparableComparator.main.Transaction;
import comparableComparator.main.TransactionComparator;

import java.util.*;

public class TransactionTest {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of transactions: ");
        int n = scanner.nextInt();

        List<Transaction> transactions = new ArrayList<>();
//        transactions.add(new Transaction(1, 100));
//        transactions.add(new Transaction(2, 100.0));
//        transactions.add(new Transaction(33, 200.1));
//        transactions.add(new Transaction(96, 200.1));

        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter Transaction " + (i+1));

            System.out.print("ID: ");
            int id = scanner.nextInt();

            System.out.print("Amount: ");
            double amount = scanner.nextDouble();

            transactions.add(new Transaction(id, amount));
        }

//        Collections.sort(transactions, new TransactionComparator());

//        transactions.sort((t1, t2) -> {
//            int amountCompare = Double.compare(t2.amount, t1.amount);
//            if(amountCompare != 0) return amountCompare;
//            return Integer.compare(t1.id, t2.id);
//        });

        transactions.sort(
                Comparator.comparingDouble((Transaction t) -> t.amount)
                        .reversed()
                        .thenComparingInt(t -> t.id)
        );

        System.out.println("\nSorted Transactions:");

        for(Transaction t : transactions) {
            System.out.println("ID: " + t.id + "  Amount: " + t.amount);
        }

        scanner.close();
    }
}
