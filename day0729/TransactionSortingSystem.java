package day0729;

public class TransactionSortingSystem {
    public static void main(String[] args) {
        Transaction[] transactions = {
            new Transaction("TX101", "ACC-001", 1500.0, 1005),
            new Transaction("TX102", "ACC-002", 3000.0, 1001),
            new Transaction("TX103", "ACC-003", 1500.0, 1002),
            new Transaction("TX104", "ACC-001", 500.0,  1006),
            new Transaction("TX105", "ACC-004", 3000.0, 1000),
            new Transaction("TX106", "ACC-002", 1500.0, 1003)
        };

        System.out.println("=== Before Sorting ===");
        printTransactions(transactions);

        insertionSortTransactions(transactions);

        System.out.println("\n=== After Sorting (Amount Descending, TimeSeq Ascending) ===");
        printTransactions(transactions);
    }

    public static void insertionSortTransactions(Transaction[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Transaction key = arr[i];
            int j = i - 1;

            while (j >= 0 && shouldSwap(arr[j], key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static boolean shouldSwap(Transaction current, Transaction key) {
        if (current.getAmount() < key.getAmount()) {
            return true;
        } else if (current.getAmount() == key.getAmount()) {
            return current.getTimestampSeq() > key.getTimestampSeq();
        }
        return false;
    }

    public static void printTransactions(Transaction[] arr) {
        for (Transaction t : arr) {
            System.out.println(t);
        }
    }
}
