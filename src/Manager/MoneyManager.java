package Manager;


import Debt.Debt;
import Loan.Loan;
import Method.*;
import Outcome.Outcome;

import java.io.IOException;

public class MoneyManager {
    private static MoneyManager moneyManager;
    private final IncomeManager incomeManager;
    private final OutcomeManager outcomeManager;
    private final LoanManager loanManager;
    private final DebtManager debtManager;
    private MoneyManager(){
        outcomeManager = OutcomeManager.getOutcomeManager();
        incomeManager = IncomeManager.getIncomeManager();
        loanManager = LoanManager.getLoanManager();
        debtManager = DebtManager.getDebtManager();
    }
    public static MoneyManager getMoneyManager(){
        if (moneyManager == null)
            moneyManager = new MoneyManager();
        return moneyManager;
    }
    public IncomeManager getIncomeManager() {
        return incomeManager;
    }

    public OutcomeManager getOutcomeManager() {
        return outcomeManager;
    }
    public double getBalance(){
        return getIncomeManager().getTotal() - getOutcomeManager().getTotal();
    }
    public LoanManager getLoanManager() {
        return loanManager;
    }

    public DebtManager getDebtManager() {
        return debtManager;
    }
    public void repayDebt(String date,String name,double money){
        String note = "Repay to "+name;
        outcomeManager.newOutcomes(date,money,note);
        for ( Debt debt : debtManager.getDebts()){
            if(debt.getName().equals(name))
                if(debt.getMoney() > money) {
                    debt.setMoney(debt.getMoney() - money);
                    debt.setNote("Repay to "+name+" : "+money );
                } else if ( debt.getMoney() < money){
                    debtManager.remove(debt.getCode());
                    outcomeManager.newOutcomes(date,money-debt.getMoney(),"Ngu vkl");
                } else
                    debtManager.remove(debt.getCode());
        }
    }
    public void receiveLoan(String date,String name,double money){
        String note = "Received loan from "+name;
        incomeManager.newIncomes(date,money,note);
        for ( Loan loan : loanManager.getLoans()){
            if(loan.getName().equals(name))
                if(loan.getMoney() > money) {
                    loan.setMoney(loan.getMoney() - money);
                    loan.setNote("Received from "+name+" : "+money );
                } else if ( loan.getMoney() < money){
                    loanManager.remove(loan.getCode());
                    incomeManager.newIncomes(date,money-loan.getMoney(),"Ngon vkl");
                } else
                    loanManager.remove(loan.getCode());
        }
    }
    public double getTotal(GetTotal getTotal){
        return getTotal.getTotal();
    }
    public void editName(EditName editName,int code,String name){
        editName.editName(code,name);
    }
    public void editDate(EditDate editDate,int code,String date){
        editDate.editDate(code,date);
    }
    public void editNote(EditNote editNote,int code,String note){
        editNote.editNote(code,note);
    }
    public void editMoney(EditMoney editMoney,int code,double money){
        editMoney.editMoney(code,money);
    }
    public void remove(Remove remove,int code){
        remove.remove(code);
    }
    public void readerData(ReaderData readerData) throws IOException {
        readerData.reader();
    }
    public void writerData(WriterData writerData) throws IOException {
        writerData.writer();
    }

}
