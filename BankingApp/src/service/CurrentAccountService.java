package service;

import project.CurrentAccount;
import project.SavingsAccount;
import java.util.List;

public class CurrentAccountService {

    public static List<CurrentAccount> getAllCurrentAccounts(){
        List<Object> currentAccounts = DatabaseQueryExecutorService.executeReadQuery("currentaccount");
        return (List<CurrentAccount>) (Object) currentAccounts;
    }

    public static List<CurrentAccount> addCurrentAccount(String name) {
        List<CurrentAccount> currentAccounts = DatabaseQueryExecutorService.addCurrentAccountQuery(name);
        return currentAccounts;
    }
}
