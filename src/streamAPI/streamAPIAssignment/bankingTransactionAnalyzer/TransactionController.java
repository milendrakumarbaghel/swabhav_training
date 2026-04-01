package streamAPI.streamAPIAssignment.bankingTransactionAnalyzer;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionController {
    private List<Transaction> transactions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nBanking Transaction Analyzer");
            System.out.println("1. Add Transaction");
            System.out.println("2. Show Successful Transactions");
            System.out.println("3. Total Deposit Amount");
            System.out.println("4. Total Withdrawal Amount");
            System.out.println("5. Group by Branch");
            System.out.println("6. Count Failed Transactions");
            System.out.println("7. Branch -> Total Successful Amount");
            System.out.println("8. Largest Transaction");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addTransaction();
                case 2 -> showSuccessful();
                case 3 -> totalDeposit();
                case 4 -> totalWithdrawal();
                case 5 -> groupByBranch();
                case 6 -> countFailed();
                case 7 -> branchWiseTotal();
                case 8 -> largestTransaction();
                case 9 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addTransaction() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Type (DEPOSIT/WITHDRAWAL): ");
        String type = sc.next();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Branch: ");
        String branch = sc.next();

        System.out.print("Is Successful (true/false): ");
        boolean success = sc.nextBoolean();

        transactions.add(new Transaction(id, name, type, amount, branch, success));
    }

    private void showSuccessful() {
        transactions.stream()
                .filter(Transaction::isSuccessful)
                .forEach(System.out::println);
    }

    private void totalDeposit() {
        double total = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("DEPOSIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total Deposit: " + total);
    }

    private void totalWithdrawal() {
        double total = transactions.stream()
                .filter(t -> t.getType().equalsIgnoreCase("WITHDRAWAL"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total Withdrawal: " + total);
    }

    private void groupByBranch() {
        Map<String, List<Transaction>> map = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getBranch));

        map.forEach((branch, list) -> {
            System.out.println("Branch: " + branch);
            list.forEach(System.out::println);
        });
    }

    private void countFailed() {
        long count = transactions.stream()
                .filter(t -> !t.isSuccessful())
                .count();

        System.out.println("Failed Transactions: " + count);
    }

    private void branchWiseTotal() {
        Map<String, Double> map = transactions.stream()
                .filter(Transaction::isSuccessful)
                .collect(Collectors.groupingBy(
                        Transaction::getBranch,
                        Collectors.summingDouble(Transaction::getAmount)
                ));

        map.forEach((branch, total) ->
                System.out.println(branch + " -> " + total));
    }

    private void largestTransaction() {
        transactions.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount))
                .ifPresent(System.out::println);
    }
}
