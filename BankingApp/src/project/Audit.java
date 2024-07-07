package project;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {

    FileWriter writer;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Audit() {
        try{
            this.writer = new FileWriter("data/audit.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public void stampAction(String action)
    {
        try {
            logAction(action);
        }
        catch (IOException e) {
            System.out.println("Caught exception from audit.");
        }
    }
    public void logAction(String action) throws IOException {

        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }


}