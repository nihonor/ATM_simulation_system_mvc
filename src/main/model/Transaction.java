package main.model;

public class Transaction {
    private String type; // "Deposit" or "Withdrawal"
    private double amount;
    private String timestamp;

    public Transaction(String type, double amount, String timestamp) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return type + ": " + amount + " on " + timestamp;
    }
}