package model;

import java.util.Date;

public class Transaction {
    private double amount;
    private Account account;
    Date transactionDate;

    private String category;

    private String note;

    private String transactionType;

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", account=" + account +
                ", transactionDate=" + transactionDate +
                ", category='" + category + '\'' +
                ", note='" + note + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }

    public Transaction(double amount, Account account, Date transactionDate, String category, String note, String transactionType) {
        this.amount = amount;
        this.account = account;
        this.transactionDate = transactionDate;
        this.category = category;
        this.note = note;
        this.transactionType = transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    public Transaction() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
