package project;

public class Loan {
    private int id;
    private int amount;
    private String startDate;
    private String finalDate;
    int clientId;

    public Loan(int id, int amount, String startDate, String finalDate, int clientId) {
        this.id = id;
        this.amount = amount;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.clientId = clientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "\nLoan{" +
                "id=" + id +
                ", amount=" + amount +
                ", startDate='" + startDate + '\'' +
                ", finalDate='" + finalDate + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
