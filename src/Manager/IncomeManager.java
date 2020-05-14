package Manager;

import Income.Income;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncomeManager extends Manager {
    private static IncomeManager incomeManager;
    private final List<Income> incomes;
    private IncomeManager(){
        incomes = new ArrayList<>();
    }
    public static IncomeManager getIncomeManager(){
        if(incomeManager == null)
            incomeManager = new IncomeManager();
        return  incomeManager;
    }
    public void newIncomes(String date,Double money, String note){
        incomes.add(new Income(date,money,note));
    }
    public double getTotal(){
        double total = 0;
        for(Income income : incomes){
            total += income.getMoney();
        }
        return  total;
    }
    public void editDate(int code,String date){
        for (Income income : incomes){
            if(income.getCode() == code)
                income.setDate(date);
            return;
        }
    }
    public void editMoney(int code,double money){
        for (Income income : incomes){
            if(income.getCode() == code)
                income.setMoney(money);
            return;
        }
    }
    public void editNote(int code,String note){
        for (Income income : incomes){
            if(income.getCode() == code)
                income.setNote(note);
            return;
        }
    }
    public void remove(int code){
        for (Income income : incomes){
            if(income.getCode() == code)
                incomes.remove(income);
            return;
        }
    }
    public boolean checkCode(int code){
        for (Income income: incomes){
            if(income.getCode() == code)
                return true;
        }
        return false;
    }
    public void writer() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Incomes.txt";
        FileOutputStream file = new FileOutputStream(path);
        for (Income income : incomes){
            byte[] line = income.toString().getBytes();
            byte[] downLine = "\n".getBytes();
            file.write(line);
            file.write(downLine);
        }
        file.close();
    }
    public void reader() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Incomes.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine())!= null){
            String[] content = line.split(" ,");
            String date = content[0].substring(6);
            Double money = Double.parseDouble(content[1].substring(9));
            String note = content[0].substring(7);
            newIncomes(date,money,note);
        }
        br.close();
    }
    public void display(){
        for (Income income : incomes){
            System.out.println(income.toString());
        }
    }

}
