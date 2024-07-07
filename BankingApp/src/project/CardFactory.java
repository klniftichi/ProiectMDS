package project;

import java.sql.SQLException;
import java.util.Scanner;

public class CardFactory {

    private static int uniqueId = 0;

    public CardFactory() throws SQLException {
    }

    public Card createCard(String IBAN, String name) {

        return new Card(uniqueId++, IBAN, name);
    }

    public static Card createCard(Scanner in) {
        return new Card(uniqueId++, in);
    }

}