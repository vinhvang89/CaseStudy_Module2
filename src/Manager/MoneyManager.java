package Manager;


import Income.Income;

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
    public double getBalance(){
        return  incomeManager.getTotal() - outcomeManager.getTotal();
    }


}
