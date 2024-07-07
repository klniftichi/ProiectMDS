package project;

import java.util.Scanner;

public class Account {
    protected int id;
    protected String IBAN;
    protected String BIC;
    protected double amount;
    protected String name;
    protected int clientId;
    protected int cardId;

    public Account() {}

    public Account(int id, String IBAN, String BIC, double amount, String name, int clientId, int cardId) {
        this.id = id;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.amount = amount;
        this.name = name;
        this.clientId = clientId;
        this.cardId = cardId;
    }

    public Account(int accountId, String IBAN, String BIC, double amount, String name, int clientId) {
        this.id = accountId;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.amount = amount;
        this.name = name;
        this.clientId = clientId;
    }



    public Account(String name, int clientId, int uniqueId) {
        this.id = uniqueId;
        this.IBAN = this.generateIBAN(uniqueId);
        this.BIC = this.generateBIC(uniqueId);
        this.amount = 0;
        this.name = name;
        this.clientId = clientId;
    }

    public Account(int accountId, Scanner in){
        this.id = accountId;
        this.Read(in);
        this.IBAN = this.generateIBAN(accountId);
        this.BIC = this.generateBIC(accountId);
        this.amount = 0;
    }

    public void Read(Scanner in){
        System.out.println("Titular card: ");
        this.name = in.nextLine();
        System.out.println("ID Client: ");
        this.clientId = Integer.parseInt(in.nextLine());
    }

    protected String generateBIC(int clientId)
    {
        return "BIC" + "GAA" + clientId*2;
    }

    protected String generateIBAN(int clientId)
    {
        return "RO04GAAA" + clientId*2;
    }

    public int getAccountId() {
        return id;
    }

    public void setAccountId(int id) {
        this.id = id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCardId() {
        return cardId;
    }


    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "\nAccount {" +
                "accountId=" + id +
                ", IBAN='" + IBAN + '\'' +
                ", BIC='" + BIC + '\'' +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                ", clientId=" + clientId +
                ", cardId=" + cardId +
                "}";
    }

    public String toCSV() {
        return id +
                "," + IBAN +
                "," + BIC +
                "," + amount +
                "," + name +
                "," + clientId +
                ", " + cardId;
    }

}


