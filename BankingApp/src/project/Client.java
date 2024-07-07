package project;

import java.text.ParseException;
import java.util.*;


public class Client {

    private int id;
    private String name;
    private String CNP;
    private String phone;
    private String email;
    private int addressId;

    private List<Account> accounts = new ArrayList<>();

    public Client(){}

    public Client(int clientId, String name, String CNP, String phone, String email, int addressId) {
        this.id = clientId;
        this.name = name;
        this.CNP = CNP;
        this.phone = phone;
        this.email = email;
        this.addressId = addressId;
    }

    public Client(int clientId, Scanner in) {
        this.id = clientId;
        this.Read(in);
    }

    public void Read(Scanner in){
        System.out.println("Name: ");
        this.name = in.nextLine();
        System.out.println("CNP: ");
        this.CNP = in.nextLine();
        System.out.println("Phone: ");
        this.phone = in.nextLine();
        System.out.println("Email: ");
        this.email = in.nextLine();
        System.out.println("Address ID: ");
        this.addressId = Integer.parseInt(in.nextLine());
    }

    public int getClientId() {
        return id;
    }

    public void setClientId(int clientId) {
        this.id = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddress() {
        return addressId;
    }

    public void setAddress(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "\nClient{" +
                "clientId=" + id +
                ", name='" + name + '\'' +
                ", CNP='" + CNP + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", addressId='" + addressId +
                '}';
    }

    public String toCSV(){
        return id +
                "," + name +
                "," + CNP +
                "," + phone +
                "," + email +
                "," + addressId;
    }
}
