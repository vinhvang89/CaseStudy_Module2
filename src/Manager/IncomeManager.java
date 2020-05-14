package Manager;

import Income.Income;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncomeManager {
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
    public void editName(int code,String name){}
    public void writerIncomes() throws IOException {
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
    public void readerIncome() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Incomes.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine())!= null){
            String[] content = line.split(" ,");
            String date = content[0].substring(6);
            Double money = Double.parseDouble(content[1].substring(9));
            String note = content[0].substring(7);
            int code = Integer.parseInt(content[4].substring(6));
            newIncomes(date,money,note);
        }
        br.close();
    }

}
