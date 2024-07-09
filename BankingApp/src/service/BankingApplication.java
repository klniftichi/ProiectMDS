package service;

import project.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BankingApplication {


    public static void createClient() {                 // creare client nou cu date introduse de la tastatura
        Scanner in = new Scanner(System.in);
        Client c = new Client();
        c.Read(in);
        String name = c.getName();
        String cnp = c.getCNP();
        String phone = c.getPhone();
        String email = c.getEmail();
        int addressid = c.getAddress();
        List<Client> newClients = ClientService.addClient(name, cnp, phone, email, addressid);
    }

    public static void createAccount() {               // creare cont nou
        // pt a crea un cont avem nevoie intai sa cream un client nou
        Scanner in = new Scanner(System.in);
        Client c = new Client();
        c.Read(in);
        // introducem clientul in baza de date
        String name = c.getName();
        String cnp = c.getCNP();
        String phone = c.getPhone();
        String email = c.getEmail();
        int addressid = c.getAddress();
        List<Client> newClients = ClientService.addClient(name, cnp, phone, email, addressid);
        // apelam metoda de creare a unui cont
        List<Account> newAccounts = AccountService.addAccount(name);
        System.out.println(newAccounts.get(newAccounts.size()-1));
    }

    public static void createSavingsAccount() {        // creare cont economii nou
        // pt a crea un savings cont avem nevoie intai sa cream un client nou
        Scanner in = new Scanner(System.in);
        Client c = new Client();
        c.Read(in);
        // introducem clientul in baza de date
        String name = c.getName();
        String cnp = c.getCNP();
        String phone = c.getPhone();
        String email = c.getEmail();
        int addressid = c.getAddress();
        List<Client> newClients = ClientService.addClient(name, cnp, phone, email, addressid);
        // apelam metoda de creare a unui cont
        List<SavingsAccount> newSavingsAccounts = SavingsAccountService.addSavingsAccount(name);
        System.out.println(newSavingsAccounts.get(newSavingsAccounts.size()-1));
    }

    public static void createCurrentAccount() {        // creare cont curent nou
        // pt a crea un savings cont avem nevoie intai sa cream un client nou
        Scanner in = new Scanner(System.in);
        Client c = new Client();
        c.Read(in);
        // introducem clientul in baza de date
        String name = c.getName();
        String cnp = c.getCNP();
        String phone = c.getPhone();
        String email = c.getEmail();
        int addressid = c.getAddress();
        List<Client> newClients = ClientService.addClient(name, cnp, phone, email, addressid);
        // apelam metoda de creare a unui cont
        List<CurrentAccount> newCurrentAccounts = CurrentAccountService.addCurrentAccount(name);
        System.out.println(newCurrentAccounts.get(newCurrentAccounts.size()-1));
    }

    public static void cardDetailsAccount() {             // afiseaza detaliile cardurilor asociate contului unui client

        Scanner in = new Scanner(System.in);
        System.out.print("Client ID =  ");
        int clientId = Integer.parseInt(in.nextLine());

        Set<Card> cards = CardService.getCardDetailsByClientId(clientId);
        System.out.print("\nCards details:");
        for(Card c : cards)
            System.out.print(c);
    }

    public static void cardDetailsSpecificAccount() {      // afiseaza detaliile cardurilor asociate contului pe care il dam noi unui client

        Scanner in = new Scanner(System.in);
        System.out.print("Client ID =  ");
        int clientId = Integer.parseInt(in.nextLine());
        System.out.print("Account type (account / currentacount / savingsaccount) =  ");
        String accountType = in.nextLine();

        List<Card> cards = CardService.getCardDetailsByClientId2(accountType, clientId);
        System.out.print("\nCards details:");
        for(int i = 0; i < cards.size(); i++)
             System.out.print(cards.get(i));
    }

    public static void accountDetails() {                  // afiseaza detaliile conturilor unui client

        Scanner in = new Scanner(System.in);
        System.out.print("Client ID =  ");
        int clientId = Integer.parseInt(in.nextLine());

        List<Account> clientAccounts = AccountService.getAllAccountsByClientId(clientId);
        System.out.print("\nAccount details:");
        for(int i = 0; i < clientAccounts.size(); i++)
            System.out.print(clientAccounts.get(i));
    }

    public static void updateAddress() {                  // update la adresa unui client - facem sa returneze adresa modificata

        Scanner in = new Scanner(System.in);
        System.out.print("Client ID =  ");
        int clientId = Integer.parseInt(in.nextLine());
        System.out.print("New city =  ");
        String newCity = in.nextLine();
        System.out.print("New street = ");
        String newStreet = in.nextLine();

        Address address = AddressService.updateAddres(clientId, newCity, newStreet);
    }

    public static void seeAddress() {

        Scanner in = new Scanner(System.in);
        System.out.print("Client ID =  ");
        int clientId = Integer.parseInt(in.nextLine());
        Address address = AddressService.getAddress(clientId);
    }
    public static void closeAccount() {                  // dezactivare cont dupa iban - iban ul este unic pt orice cont- putem afisa conturile pt verificare

        Scanner in = new Scanner(System.in);
        System.out.print("IBAN =  ");
        String iban = in.nextLine();

        List<Account> allAccountsAfterDelete = AccountService.deleteAccount(iban);
//        System.out.println(allAccountsAfterDelete);
    }

    public static void displayAllAccounts() {             // afiseaza toate conturile bancare din bd

        List<Account> allAccounts = AccountService.getAllAccounts();
        System.out.print("\nAll accounts:");
        for(int i = 0; i < allAccounts.size(); i++)
            System.out.print(allAccounts.get(i));
    }

    public static void displayAllSavingsAccounts() {      // afiseaza toate conturile bancare de economii

        List<SavingsAccount> savingsAccounts = SavingsAccountService.getAllSavingsAccounts();
        System.out.print("\nAll savings accounts:");
        for(int i = 0; i < savingsAccounts.size(); i++)
            System.out.print(savingsAccounts.get(i));
    }

    public static void displayAllCurrentAccounts() {      // afiseaza toate conturile bancare curente - de uz zilnic

        List<CurrentAccount> currentAccounts = CurrentAccountService.getAllCurrentAccounts();
        System.out.print("\nAll current accounts:");
        for(int i = 0; i < currentAccounts.size(); i++)
            System.out.print(currentAccounts.get(i));
    }

    public static void displayAllClients() {           // afiseaza toti clientii bancii din bd

        List<Client> allClients = ClientService.getAllClients();
        System.out.print("\nAll clients:");
        for(int i = 0; i < allClients.size(); i++)
            System.out.print(allClients.get(i));
    }

    public static void displayTransactions() {         // afiseaza tranzactiile efectuate intre doua conturi pe baza iban-urilor celor de conturi
        Scanner in = new Scanner(System.in);
        System.out.print("IBAN1 =  ");
        String iban1 = in.nextLine();
        System.out.print("IBAN2 =  ");
        String iban2 = in.nextLine();

        List<Transaction> transactions = TransactionService.getTransactionsBetween2Accounts(iban1, iban2);
        System.out.print("\nTransactions: ");
        for(int i = 0; i < transactions.size(); i++)
            System.out.print(transactions.get(i));
    }
}