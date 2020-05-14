package Manager;

import Loan.Loan;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private static LoanManager loanManager;
    private final List<Loan> loans;
    private LoanManager(){
        loans = new ArrayList<>();
    }
    public static LoanManager getLoanManager(){
        if(loanManager == null)
            loanManager = new LoanManager();
        return loanManager;
    }
    public void newLoan(String date,String name, Double money, String note){
        loans.add(new Loan(date,name,money,note));
    }
    public double getTotal(){
        double total = 0;
        for(Loan loan : loans){
            total += loan.getMoney();
        }
        return  total;
    }
    public void writerIncomes() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Loan.txt";
        FileOutputStream file = new FileOutputStream(path);
        for (Loan loan : loans){
            byte[] line = loan.toString().getBytes();
            byte[] downLine = "\n".getBytes();
            file.write(line);
            file.write(downLine);
        }
        file.close();
    }
    public void readerIncome() throws IOException {
        String path = "E:\\Codegym\\Module 2\\Week9\\MoneyManager\\Loan.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine())!= null){
            String[] content = line.split(" ,");
            String date = content[0].substring(6);
            String name = content[1].substring(6);
            Double money = Double.parseDouble(content[2].substring(6));
            String note = content[3].substring(6);
            newLoan(date,name,money,note);
        }
        br.close();
    }
}
