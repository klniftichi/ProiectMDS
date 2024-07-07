package project;

import java.util.Scanner;

public class Address {

    private String city;
    private String country;
    private String street;

    public Address() {}

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public void Read(Scanner in) {
        System.out.println("Oras : ");
        this.city = in.nextLine();
        System.out.println("Tara: ");
        this.country = in.nextLine();
        System.out.println("Strada: ");
        this.street = in.nextLine();
    }

    public Address(Scanner in) {
        this.Read(in);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String toCSV() {
        return street +
                "," + city +
                "," + country;
    }

}
