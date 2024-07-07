package service;

import project.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

//    public static List<Account> getAllAccounts(){
//        List<Account> allAccounts = DatabaseQueryExecutorService.executeReadQueryAccounts();
//        return allAccounts;
//    }

    public static List<Account> getAllAccounts(){
        List<Object> accounts = DatabaseQueryExecutorService.executeReadQuery("account");
        return (List<Account>) (Object) accounts;
    }

    public static List<Account> getAllAccountsByClientId(int clientId){
        List<Account> accounts = DatabaseQueryExecutorService.accountDetailsQuery(clientId);
        return accounts;
    }

    public static List<Account> deleteAccount(String iban){
        List<Account> accounts = DatabaseQueryExecutorService.deleteAccountQuery(iban);
        return accounts;
    }

    public static List<Account> addAccount(String name) {
        List<Account> accounts = DatabaseQueryExecutorService.addAccountQuery(name);
        return accounts;
    }

}
