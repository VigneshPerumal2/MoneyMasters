package model;

public class Account {
    private String accountName;
    private String accountType;
    private double amount;
    private String note;

    public Account(String accountName, String accountType, double amount, String note) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.amount = amount;
        this.note = note;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", amount=" + amount +
                ", note='" + note + '\'' +
                '}';
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
