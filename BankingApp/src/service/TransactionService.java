package service;

import project.Account;
import project.Transaction;
import java.util.List;


public class TransactionService {

    public static List<Transaction> getTransactionsBetween2Accounts(String iban1, String iban2){
        List<Transaction> transactions = DatabaseQueryExecutorService.getTransactions(iban1, iban2);
        return transactions;
    }

}
