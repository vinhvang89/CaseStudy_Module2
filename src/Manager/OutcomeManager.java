package Manager;

import Income.Income;
import Outcome.Outcome;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutcomeManager {
    private static OutcomeManager outcomeManager;
    private final List<Outcome> outcomes;
    private OutcomeManager(){
        outcomes = new ArrayList<>();
    }
    public static OutcomeManager getOutcomeManager(){
        if(outcomeManager == null)
            outcomeManager = new OutcomeManager();
        return  outcomeManager;
    }
    public void newOutcomes(String date,Double money, String note){
        outcomes.add(new Outcome(date,money,note));
    }
    public double getTotal(){
        double total = 0;
        for (Outcome outcome : outcomes){
            total +=  outcome.getMoney();
        }
        return  total;
    }
    public void writerOutCome() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Outcomes.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        for (Outcome outcome : outcomes){
            byte[] line = outcome.toString().getBytes();
            byte[] downLine = "\n".getBytes();
            fileOutputStream.write(line);
            fileOutputStream.write(downLine);
        }
        fileOutputStream.close();
    }
    public void readerOutcome() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Outcomes.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine())!= null){
            String[] content = line.split(" ,");
            String date = content[0].substring(6);
            Double money = Double.parseDouble(content[1].substring(10));
            String note = content[0].substring(7);
            newOutcomes(date,money,note);
        }
        br.close();
    }
}
