package project;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.ParseException;

public class ClientFactory {

    private static int uniqueId = 0;

    public ClientFactory() throws SQLException {
    }

    public static void incrementUniqueId(int inc) {
        ClientFactory.uniqueId += inc;
    }

    public static Client createClient(String name, String CNP, String phone, String email, int addressId){
        return new Client(uniqueId++ , name, CNP, phone, email, addressId);
    }

    public static Client createClient(Scanner in) {
        return new Client(uniqueId++, in);
    }
}
