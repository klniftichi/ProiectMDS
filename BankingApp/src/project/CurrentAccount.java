package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CurrentAccount extends Account{

    private int maxAmount;                              // kinf of a limit for transactions

    public CurrentAccount(int accountId, String IBAN, String BIC, double amount, String name, int clientId, int cardId, int maxAmount) {
        super(accountId, IBAN, BIC, amount, name, clientId, cardId);
        this.maxAmount = maxAmount;
    }
    public CurrentAccount(int accountId, String IBAN, String BIC, double amount, String name, int clientId, int maxAmount) {
        super(accountId, IBAN, BIC, amount, name, clientId);
        this.maxAmount = maxAmount;
    }

    public CurrentAccount(String name, int clientId, int uniqueId) {
        super(name, clientId, uniqueId);
        this.maxAmount = 0;
    }

    public CurrentAccount(int accountId, Scanner in) {
        super(accountId, in);
        System.out.println("Maximum limit for transactions: ");
        this.maxAmount = Integer.parseInt(in.nextLine());
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String toString() {
        return "\nCurrentAccount{" +
                "accountId=" + id +
                ", IBAN='" + IBAN + '\'' +
                ", BIC='" + BIC + '\'' +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", clientId=" + clientId +
                ", cardId=" + cardId +
                ", maxAmount=" + maxAmount +
                '}';
    }
}
