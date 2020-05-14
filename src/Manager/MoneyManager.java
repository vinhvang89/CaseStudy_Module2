package Manager;


import Method.*;

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

    public IncomeManager getIncomeManager() {
        return incomeManager;
    }

    public OutcomeManager getOutcomeManager() {
        return outcomeManager;
    }

    public LoanManager getLoanManager() {
        return loanManager;
    }

    public DebtManager getDebtManager() {
        return debtManager;
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
