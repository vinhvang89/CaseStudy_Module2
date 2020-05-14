package Manager;

import Outcome.Outcome;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutcomeManager extends Manager {
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
    public void editDate(int code,String date){
        for (Outcome outcome: outcomes){
            if(outcome.getCode() == code)
                outcome.setDate(date);
            return;
        }
    }
    public void editMoney(int code,double money){
        for (Outcome outcome : outcomes){
            if(outcome.getCode() == code)
                outcome.setMoney(money);
            return;
        }
    }
    public void editNote(int code,String note){
        for (Outcome outcome : outcomes){
            if(outcome.getCode() == code)
                outcome.setNote(note);
            return;
        }
    }
    public void remove(int code){
        for (Outcome outcome : outcomes){
            if(outcome.getCode() == code)
                outcomes.remove(outcome);
            return;
        }
    }
    public void writer() throws IOException {
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
    public void reader() throws IOException {
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
    public void display(){
        for (Outcome outcome : outcomes){
            System.out.println(outcome.toString());
        }
    }
}
