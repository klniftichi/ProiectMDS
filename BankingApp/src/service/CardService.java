package service;

import project.Account;
import project.Card;
import java.util.List;
import java.util.Set;

public class CardService {

    public static Set<Card> getCardDetailsByClientId(int id){
        Set<Card> cards = DatabaseQueryExecutorService.cardDetailsQuery(id);
        return cards;
    }

    public static List<Card> getCardDetailsByClientId2(String table, int id){
        List<Object> cards = DatabaseQueryExecutorService.cardDetailsQuery2(table, id);
        return (List<Card>) (Object) cards;

    }
}
