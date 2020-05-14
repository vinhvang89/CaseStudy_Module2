package Manager;

import Debt.Debt;
import Method.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DebtManager implements GetTotal, ReaderData, WriterData, EditNote, EditMoney,EditName,EditDate,Remove {
    private static DebtManager debtManager;
    private final List<Debt> debts;
    private DebtManager(){
        debts = new ArrayList<>();
    }
    public static DebtManager  getDebtManager(){
        if(debtManager == null)
            debtManager = new DebtManager();
        return debtManager;
    }
    public void newDebt(String date,String name, Double money, String note){
        debts.add(new Debt(date,name,money,note));
    }
    public double getTotal(){
        double total = 0;
        for(Debt debt : debts){
            total += debt.getMoney();
        }
        return  total;
    }
    public void editDate(int code,String date){
        for (Debt debt : debts){
            if(debt.getCode() == code)
                debt.setDate(date);
            return;
        }
    }
    public void editMoney(int code,double money){
        for (Debt debt : debts){
            if(debt.getCode() == code)
                debt.setMoney(money);
            return;
        }
    }
    public void editNote(int code,String note){
        for (Debt debt : debts){
            if(debt.getCode() == code)
                debt.setNote(note);
            return;
        }
    }
    public void editName(int code,String name){
        for (Debt debt : debts){
            if(debt.getCode() == code)
                debt.setName(name);
            return;
        }
    }
    public void remove(int code){
        for (Debt debt : debts){
            if(debt.getCode() == code)
                debts.remove(debt);
            return;
        }
    }
    public void writer() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Debt.txt";
        FileOutputStream file = new FileOutputStream(path);
        for (Debt debt : debts){
            byte[] line = debt.toString().getBytes();
            byte[] downLine = "\n".getBytes();
            file.write(line);
            file.write(downLine);
        }
        file.close();
    }
    public void reader() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Debt.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine())!= null){
            String[] content = line.split(" ,");
            String date = content[0].substring(6);
            String name = content[1].substring(6);
            Double money = Double.parseDouble(content[2].substring(6));
            String note = content[3].substring(6);
            newDebt(date,name,money,note);
        }
        br.close();
    }
}
