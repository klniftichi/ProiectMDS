package service;

import project.Address;
import project.Card;
import java.util.List;

public class AddressService {

    public static Address updateAddres(int id, String newCity, String newStreet){
        Address address = DatabaseQueryExecutorService.updateAddressQuery(id, newCity, newStreet);
        return address;
    }
    public static Address getAddress(int id) {
        Address address = DatabaseQueryExecutorService.getAddressQuery(id);
        return address;
    }
}
