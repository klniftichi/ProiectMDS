package project;

import java.util.*;
import java.text.SimpleDateFormat;

public class Transaction {

    private String fromIBAN;
    private String toIBAN;
    private double amount;
    private String creationDate;
    private String shortDescription;
    private int accountId;


    public Transaction(String fromIBAN, String toIBAN, double amount, String creationDate, String shortDescription, int accountId) {
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.creationDate = creationDate;
        this.shortDescription = shortDescription;
        this.accountId = accountId;
    }

    public Transaction(String fromIBAN, String toIBAN, double amount, String shortDescription) throws Exception {

        if(amount <= 0)
            throw new Exception("Incorrect amount!");

        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.shortDescription = shortDescription;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.creationDate = formatter.format(date);
    }

    public Transaction(String fromIBAN, String toIBAN, double amount, String creationDate, String shortDescription) {
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.creationDate = creationDate;
        this.shortDescription = shortDescription;
    }

    public String getFromIBAN() {
        return fromIBAN;
    }

    public void setFromIBAN(String fromIBAN) {
        this.fromIBAN = fromIBAN;
    }

    public String getToIBAN() {
        return toIBAN;
    }

    public void setToIBAN(String toIBAN) {
        this.toIBAN = toIBAN;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "\nTransaction{" +
                "fromIBAN='" + fromIBAN + '\'' +
                ", toIBAN='" + toIBAN + '\'' +
                ", amount=" + amount +
                ", creationDate='" + creationDate + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
