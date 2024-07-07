package service;
import project.Audit;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        // variabile
        Scanner in = new Scanner(System.in);
        boolean endProgram = false;
        Audit audit = new Audit();

        // afisare comenzi existente in terminal pt user
        System.out.println("\nHello!");
        System.out.println("Available commands:");
        System.out.print("1.Create new client\n2.Create new account\n3.Create new savings account\n4.Create new current account\n5.Card details of a specific client\n6.Cards details associated with a customer's specific account\n7.Account details of a specific client\n8.Update address for a client\n9.Close account\n10.See all accounts\n11.See all savings accounts\n12.See all current accounts\n13.See all clients\n14.Transactionsc between 2 accounts\n15.End queries\n\n");

        //
        List<String> availableCommands = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14");
        List<String> availableCommandsName = Arrays.asList("create_new_client", "create_new_account", "create_new_current_account", "create_new_savings_account", "card_details_of_a_client", "card_details_specific_account", "account_details_of_a_client", "update_address", "close_account", "display_all_accounts", "display_all_savings_accounts", "display_all_curent_accounts", "display_all_clients", "transactions_between2_accounts", "end_queries");
        while( !endProgram ) {
            System.out.print("\n\nInsert command number = ");
            String command = in.nextLine();
            try{
                switch (command) {
                    case "1" ->  BankingApplication.createClient();
                    case "2" ->  BankingApplication.createAccount();
                    case "3" ->  BankingApplication.createSavingsAccount();
                    case "4" ->  BankingApplication.createCurrentAccount();
                    case "5" ->  BankingApplication.cardDetailsAccount();
                    case "6" ->  BankingApplication.cardDetailsSpecificAccount();
                    case "7" ->  BankingApplication.accountDetails();
                    case "8" ->  BankingApplication.updateAddress();
                    case "9" ->  BankingApplication.closeAccount();
                    case "10" -> BankingApplication.displayAllAccounts();
                    case "11" -> BankingApplication.displayAllSavingsAccounts();
                    case "12" -> BankingApplication.displayAllCurrentAccounts();
                    case "13" -> BankingApplication.displayAllClients();
                    case "14" -> BankingApplication.displayTransactions();
                    case "15" -> {System.out.println("\nThank you! Have a nice day!"); endProgram = true;}
                    default -> System.out.println("Wrong command. Try again.");
                }
                if(availableCommands.contains(command)) {
                    audit.stampAction(availableCommandsName.get(Integer.parseInt(command)-1));
                }
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
    }
}
