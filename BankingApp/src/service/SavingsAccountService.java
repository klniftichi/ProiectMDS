package service;

import project.Account;
import project.SavingsAccount;
import java.util.List;


public class SavingsAccountService {

    public static List<SavingsAccount> getAllSavingsAccounts(){
        List<Object> savingsAccounts = DatabaseQueryExecutorService.executeReadQuery("savingsaccount");
        return (List<SavingsAccount>) (Object) savingsAccounts;
    }

    public static List<SavingsAccount> addSavingsAccount(String name) {
        List<SavingsAccount> savingsAccounts = DatabaseQueryExecutorService.addSavingsAccountQuery(name);
        return savingsAccounts;
    }


}
