package project;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class SavingsAccount extends Account {

    private String startDate;

    public SavingsAccount(int accountId, String IBAN, String BIC, double amount, String name, int clientId, int cardId, String startDate) {
        super(accountId, IBAN, BIC, amount, name, clientId, cardId);
        this.startDate = startDate;
    }

    public SavingsAccount(int accountId, String IBAN, String BIC, double amount, String name, int clientId, String startDate) {
        super(accountId, IBAN, BIC, amount, name, clientId);
        this.startDate = startDate;
    }

    public SavingsAccount(String name, int clientId, int uniqueId) {
        super(name, clientId, uniqueId);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.startDate = formatter.format(date);
    }

    public SavingsAccount(int accountId, Scanner in) {
        super(accountId, in);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.startDate = formatter.format(date);
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "\nSavingsAccount {" +
                "accountId=" + id +
                ", IBAN='" + IBAN + '\'' +
                ", BIC='" + BIC + '\'' +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", clientId=" + clientId +
                ", startDate='" + startDate + '\'' +
                '}';
    }

    public String toCSV() {
        return id +
                "," + IBAN +
                "," + BIC +
                "," + amount +
                "," + name +
                "," + clientId +
                "," + startDate;
    }
}
