package Manager;

import Debt.Debt;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DebtManager {
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
    public void writerIncomes() throws IOException {
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
    public void readerIncome() throws IOException {
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
