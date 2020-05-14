package Manager;


import Method.GetTotal;
import Method.ReaderData;
import Method.WriterData;

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
    public double getTotal(GetTotal getTotal){
        return getTotal.getTotal();
    }
    public void readerData(ReaderData readerData) throws IOException {
        readerData.reader();
    }
    public void writerData(WriterData writerData) throws IOException {
        writerData.writer();
    }

}
