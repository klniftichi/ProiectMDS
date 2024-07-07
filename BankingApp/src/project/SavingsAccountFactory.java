package project;

import java.sql.SQLException;
import java.util.Scanner;

public class SavingsAccountFactory {

    private static int uniqueId = 0;

    public SavingsAccountFactory() throws SQLException {
    }

    public static void incrementUniqueId(int inc) {
        SavingsAccountFactory.uniqueId += inc;
    }

    public SavingsAccount createSavingsAccount(String name, int clientId){
        return new SavingsAccount(name, clientId, uniqueId++);
    }

    public static SavingsAccount createAccount(Scanner in) {
        return new SavingsAccount(uniqueId++, in);
    }
}
