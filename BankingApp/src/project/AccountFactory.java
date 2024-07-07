package project;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountFactory {

    private static int uniqueId = 0;

    public AccountFactory() throws SQLException {
    }

    public static void incrementUniqueId(int inc) {
        AccountFactory.uniqueId += inc;
    }

    public Account createAccount(String name, int clientId){
        return new Account(name, clientId, uniqueId++);
    }

    public static Account createAccount(Scanner in) {
        return new Account(uniqueId++, in);
    }
}
