package project;

import java.sql.SQLException;
import java.util.Scanner;

public class CurrentAccountFactory {

    private static int uniqueId = 0;

    public CurrentAccountFactory() throws SQLException {
    }

    public static void incrementUniqueId(int inc) {
        CurrentAccountFactory.uniqueId += inc;
    }

    public CurrentAccount createCurentAccount(String name, int clientId){
        return new CurrentAccount(name, clientId, uniqueId++);
    }

    public static CurrentAccount createAccount(Scanner in) {
        return new CurrentAccount(uniqueId++, in);
    }
}
