package project;

import java.nio.charset.StandardCharsets;
import java.util.*;


public class Card {

    private int cardId;
    private String number;
    private String name;
    private int CVV;
    private String IBAN;
    private Date expirationDate;

    public Card(){}

    public Card(int cardId, String number, String name, int CVV, String IBAN, Date expirationDate) {
        this.cardId = cardId;
        this.number = number;
        this.name = name;
        this.CVV = CVV;
        this.IBAN = IBAN;
        this.expirationDate = expirationDate;
    }

    public Card(int cardId, String name, String IBAN) {
        this.cardId = cardId;
        this.name = name;
        this.IBAN = IBAN;
        this.number = generateCardNumber();
        this.CVV = generateCVV();
        this.expirationDate = generateExpirationDate();
    }

    private String generateCardNumber() {
        byte[] vec = new byte[16];
        Random r = new Random();
        r.nextBytes(vec);
        return new String(vec, StandardCharsets.UTF_8);
    }

    private int generateCVV() {
        var random = new Random();
        return 100 + random.nextInt(899);
    }

    private Date generateExpirationDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 4);
        return calendar.getTime();
    }

    public Card(int cardId, Scanner in) {
        this.cardId = cardId;
        this.Read(in);
        this.number = generateCardNumber();
        this.CVV = generateCVV();
        this.expirationDate = generateExpirationDate();
    }

    public void Read(Scanner in){
        System.out.println("IBAN: ");
        this.IBAN = in.nextLine();
        System.out.println("Card holder: ");
        this.name = in.nextLine();
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "\nCard{" +
                "cardId=" + cardId +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", CVV=" + CVV +
                ", IBAN='" + IBAN + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }

    public String toCSV() {
        return cardId +
                "," + number +
                "," + name +
                "," + CVV +
                "," + IBAN +
                "," + expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardId == card.cardId && CVV == card.CVV && Objects.equals(number, card.number) && Objects.equals(name, card.name) && Objects.equals(IBAN, card.IBAN) && Objects.equals(expirationDate, card.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, number, name, CVV, IBAN, expirationDate);
    }
}
