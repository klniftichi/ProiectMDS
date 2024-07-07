package service;

import project.Account;
import project.Client;

import java.util.List;

public class ClientService {

    public static List<Client> getAllClients(){
        List<Object> clients = DatabaseQueryExecutorService.executeReadQuery("client");
        return (List<Client>) (Object) clients;
    }

    public static List<Client> addClient(String name, String cnp, String phone, String email, int addressId){
        List<Client> clients = DatabaseQueryExecutorService.addClientQuery(name, cnp, phone, email, addressId);
        return clients;
    }
}
