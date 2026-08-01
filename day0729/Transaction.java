package day0729;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private long timestampSeq;

    public Transaction(String id, String accountNumber, double amount, long timestampSeq) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.timestampSeq = timestampSeq;
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestampSeq() {
        return timestampSeq;
    }

    @Override
    public String toString() {
        return String.format("TxID: %-6s | Acc: %-10s | Amount: %-10.2f | Seq: %-5d", id, accountNumber, amount, timestampSeq);
    }
}
