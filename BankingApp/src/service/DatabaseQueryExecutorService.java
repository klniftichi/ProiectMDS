package service;

import project.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DatabaseQueryExecutorService {

    private static DatabaseQueryExecutorService instance = null;
    static Connection conn;
    static Statement stmt;
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/project";
    //  Database credentials
    static final String USER = "ga";
    static final String PASS = "ga";

    private static void createConnection () throws SQLException {
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
    }

    public DatabaseQueryExecutorService getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseQueryExecutorService();
        }
        return instance;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void executeUpdate(String query) throws SQLException {
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    public static List<Account> executeReadQueryAccounts() {
        List<Account> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "SELECT * from account";
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String iban = rs.getString("iban");
                String bic = rs.getString("bic");
                double amount = rs.getDouble("amount");
                int clientId = rs.getInt("clientId");

                Account account = new Account(id, iban, bic, amount, name, clientId);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<Object> executeReadQuery(String table) {
        List<Object> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "SELECT * from " + table;
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            if(table.equals("account"))
                while(rs.next()) {
                    // Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String iban = rs.getString("iban");
                    String bic = rs.getString("bic");
                    double amount = rs.getDouble("amount");
                    int clientId = rs.getInt("clientId");
                    int cardId = rs.getInt("cardId");

                    Account account = new Account(id, iban, bic, amount, name, clientId, cardId);
                    result.add(account);
                }
            else if(table.equals("savingsaccount"))
                while(rs.next()) {
                    // Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String iban = rs.getString("iban");
                    String bic = rs.getString("bic");
                    double amount = rs.getDouble("amount");
                    int clientId = rs.getInt("clientId");
                    int cardId = rs.getInt("cardId");
                    String startDate = rs.getString("startDate");

                    SavingsAccount account = new SavingsAccount(id, iban, bic, amount, name, clientId, cardId, startDate);
                    result.add(account);
                }
            else if(table.equals("currentaccount"))
                while(rs.next()) {
                    // Retrieve by column name
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String iban = rs.getString("iban");
                    String bic = rs.getString("bic");
                    double amount = rs.getDouble("amount");
                    int clientId = rs.getInt("clientId");
                    int cardId = rs.getInt("cardId");
                    int maxAmount = rs.getInt("maxAmount");

                    CurrentAccount account = new CurrentAccount(id, iban, bic, amount, name, clientId, cardId, maxAmount);
                    result.add(account);
                }
            else if(table.equals("client"))
                    while(rs.next()) {
                        // Retrieve by column name
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String cnp = rs.getString("cnp");
                        String phone = rs.getString("phone");
                        String email = rs.getString("email");
                        int addressid = rs.getInt("addressid");

                        Client client= new Client(id, name, cnp, phone, email, addressid);
                        result.add(client);
                    }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static Set<Card> cardDetailsQuery(int clientid) {
        Set<Card> result = new HashSet<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "select card.id, card.number, card.name, card.cvv, card.iban, card.expirationdate from card, account, client where card.id = account.cardid and account.clientid = " + clientid;
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");
                int cvv = rs.getInt("cvv");
                String iban = rs.getString("iban");
                Date expirationdate = rs.getDate("expirationdate");

                Card card = new Card(id, number, name, cvv, iban, expirationdate);
                result.add(card);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }


    public static List<Object> cardDetailsQuery2(String table, int clientid) {
        List<Object> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "select distinct card.id, card.number, card.name, card.cvv, card.iban, card.expirationdate from card, " + table + ", client where card.id = " + table + ".cardid and " + table + ".clientid = " + clientid;
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String number = rs.getString("number");
                String name = rs.getString("name");
                int cvv = rs.getInt("cvv");
                String iban = rs.getString("iban");
                Date expirationdate = rs.getDate("expirationdate");

                Card card = new Card(id, number, name, cvv, iban, expirationdate);
                result.add(card);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<Account> accountDetailsQuery(int clientid) {
        List<Account> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "select distinct account.id, account.name, account.iban, account.bic, account.amount, account.cardid from account where account.clientid = " + clientid;
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String iban = rs.getString("iban");
                String bic = rs.getString("bic");
                double amount = rs.getDouble("amount");
                int cardId = rs.getInt("cardid");
                Account account = new Account(id, iban, bic, amount,  name, cardId);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static Address updateAddressQuery(int clientid, String newCity, String newStreet) {
        Address result = new Address();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "UPDATE address SET city = '" + newCity + "', street='" + newStreet + "' WHERE id = "  + clientid;
            stmt.executeUpdate(sql);
            String sql2 = "select * from address where address.id = 1";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String street = rs.getString("street");

                Address address = new Address(city, country, street);
                result = address;
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static Address getAddressQuery(int clientid) {
        Address result = new Address();
        String sql = "select addressid from client where id = " + clientid;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs1 = stmt.executeQuery(sql)) {
            if (rs1.next()) {
                int addressid = rs1.getInt("addressid");
                String sql2 = "select * from address where id = " + addressid;
                try (ResultSet rs2 = stmt.executeQuery(sql2)) {
                    while (rs2.next()) {
                        int id = rs2.getInt("id");
                        String city = rs2.getString("city");
                        String country = rs2.getString("country");
                        String street = rs2.getString("street");

                        result = new Address(city, country, street);
                        System.out.println(result);
                    }
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    public static List<Client> addClientQuery(String name, String cnp, String phone, String email, int addressId) {
        List<Client> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "insert into client(name, cnp, phone, email, addressid) values ('" + name + "', '" + cnp + "', '" + phone +  "', '" + email + "', " + addressId + ")";
            stmt.executeUpdate(sql);
            String sql2 = "select * from client";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String cnp1 = rs.getString("cnp");
                String phone1 = rs.getString("phone");
                String email1 = rs.getString("email");
                int addressid1 = rs.getInt("addressid");

                Client client= new Client(id, name1, cnp1, phone1, email1, addressid1);
                result.add(client);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<Account> deleteAccountQuery(String iban) {
        List<Account> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "delete from account where account.iban = '" + iban +"'";
            stmt.executeUpdate(sql);
            String sql2 = "select * from account";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String iban2 = rs.getString("iban");
                String bic = rs.getString("bic");
                double amount = rs.getDouble("amount");
                int clientId = rs.getInt("clientId");
                int cardId = rs.getInt("cardId");

                Account account = new Account(id, iban2, bic, amount, name, clientId, cardId);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }


    public static List<Account> addAccountQuery(String name) {
        List<Account> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            // aflam id-ul ulimului client adaugat
            String sql3 = "SELECT * FROM client WHERE id =(SELECT max(id) FROM client)";
            ResultSet rs3 = stmt.executeQuery(sql3);
            int clientid = 0;
            while(rs3.next())
                clientid = rs3.getInt("id");
            // inseram date in tabela pt contul nou
            String iban = "BIC" + "GAA" + clientid*2;;
            String bic = "RO04GAAA" + clientid*2;
            double amount = 0;
            String sql = "insert into account(name, iban, bic, amount, clientid) values ('" + name + "', '" + iban + "', '" + bic +  "', " + amount + ", " + clientid + ")";
            stmt.executeUpdate(sql);
            String sql2 = "select * from account";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                String iban1 = rs.getString("iban");
                String bic1 = rs.getString("bic");
                double amount1 = rs.getDouble("amount");
                int clientid1 = rs.getInt("clientid");

                Account account= new Account(id, iban1, bic1, amount1, name, clientid);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<SavingsAccount> addSavingsAccountQuery(String name) {
        List<SavingsAccount> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            // aflam id-ul ulimului client adaugat
            String sql3 = "SELECT * FROM client WHERE id =(SELECT max(id) FROM client)";
            ResultSet rs3 = stmt.executeQuery(sql3);
            int clientid = 0;
            while(rs3.next())
                clientid = rs3.getInt("id");
            // inseram date in tabela pt contul nou
            String iban = "BIC" + "GAA" + clientid*2;;
            String bic = "RO04GAAA" + clientid*2;
            double amount = 0;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            String startdate = dtf.format(now);
            String sql = "insert into savingsaccount(name, iban, bic, amount, clientid, startdate) values ('" + name + "', '" + iban + "', '" + bic +  "', " + amount + ", " + clientid + ",' " + startdate  + "')";
            stmt.executeUpdate(sql);
            String sql2 = "select * from savingsaccount";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id1 = rs.getInt("id");
                String name1 = rs.getString("name");
                String iban1 = rs.getString("iban");
                String bic1 = rs.getString("bic");
                double amount1 = rs.getDouble("amount");
                int clientId1 = rs.getInt("clientId");
                int cardId1 = rs.getInt("cardId");
                String startDate1 = rs.getString("startDate");

                SavingsAccount account = new SavingsAccount(id1, iban1, bic1, amount1, name1, clientId1, cardId1, startDate1);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<CurrentAccount> addCurrentAccountQuery(String name) {
        List<CurrentAccount> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            // aflam id-ul ulimului client adaugat
            String sql3 = "SELECT * FROM client WHERE id =(SELECT max(id) FROM client)";
            ResultSet rs3 = stmt.executeQuery(sql3);
            int clientid = 0;
            while(rs3.next())
                clientid = rs3.getInt("id");
            // inseram date in tabela pt contul nou
            String iban = "BIC" + "GAA" + clientid*2;;
            String bic = "RO04GAAA" + clientid*2;
            double amount = 0;
            int maxamount = 9000;
            String sql = "insert into currentaccount(name, iban, bic, amount, clientid, maxamount) values ('" + name + "', '" + iban + "', '" + bic +  "', " + amount + ", " + clientid + ", " + maxamount  + ")";
            stmt.executeUpdate(sql);
            String sql2 = "select * from currentaccount";
            ResultSet rs = stmt.executeQuery(sql2);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id1 = rs.getInt("id");
                String name1 = rs.getString("name");
                String iban1 = rs.getString("iban");
                String bic1 = rs.getString("bic");
                double amount1 = rs.getDouble("amount");
                int clientId1 = rs.getInt("clientId");
                int cardId1 = rs.getInt("cardId");
                int maxamount1 = rs.getInt("maxAmount");

                CurrentAccount account = new CurrentAccount(id1, iban1, bic1, amount1, name1, clientId1, cardId1, maxamount1);
                result.add(account);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }

    public static List<Transaction> getTransactions(String iban1, String iban2) {
        List<Transaction> result = new ArrayList<>();
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // STEP 2: Open a connection
            DatabaseQueryExecutorService.createConnection();
            // STEP 3: Execute a query
            String sql = "select * from transactions where fromiban = " + iban1 + " and toiban = " + iban2 + " or fromiban = " + iban2 + " and toiban = " + iban1 ;
            ResultSet rs = stmt.executeQuery(sql);
            // STEP 4: Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                String fromIban = rs.getString("fromiban");
                String toIban = rs.getString("toiban");
                double amount = rs.getDouble("amount");
                String creationDate = rs.getString("creationdate");
                String shortDescription = rs.getString("shortdescription");

                Transaction transaction = new Transaction(fromIban, toIban, amount, creationDate, shortDescription);
                result.add(transaction);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
        return result;
    }
}