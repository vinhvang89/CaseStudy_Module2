package Manager;

import Income.Income;
import Loan.Loan;
import Method.*;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoanManager implements GetTotal,ReaderData,WriterData, EditName, EditDate,EditNote,EditMoney,Remove {
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
    public void editDate(int code,String date){
        for (Loan loan : loans){
            if(loan.getCode() == code)
                loan.setDate(date);
            return;
        }
    }
    public void editMoney(int code,double money){
        for (Loan loan : loans){
            if(loan.getCode() == code)
                loan.setMoney(money);
            return;
        }
    }
    public void editNote(int code,String note){
        for (Loan loan : loans){
            if(loan.getCode() == code)
                loan.setNote(note);
            return;
        }
    }
    public void editName(int code,String name){
        for (Loan loan : loans){
            if(loan.getCode() == code)
                loan.setName(name);
            return;
        }
    }
    public void remove(int code){
        for (Loan loan : loans){
            if(loan.getCode() == code)
                loans.remove(loan);
            return;
        }
    }
    public void writer() throws IOException {
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
    public void reader() throws IOException {
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
