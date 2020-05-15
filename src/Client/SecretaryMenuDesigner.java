package Client;

public class SecretaryMenuDesigner {
    private static SecretaryMenuDesigner secretaryMenuDesigner;
    private SecretaryMenuDesigner() {
    }
    public static SecretaryMenuDesigner getSecretaryMenuDesigner(){
        if( secretaryMenuDesigner == null )
            secretaryMenuDesigner = new SecretaryMenuDesigner();
        return secretaryMenuDesigner;
    }
    public void mainMenu(){
        System.out.println("<===== Main menu =====>");
        System.out.println("1. Money Manager");
        System.out.println("0. Exit");
    }
    public void moneyManagerMenu(){
        System.out.println("<+++ Money Manager Menu +++>");
        System.out.println("1. Income");
        System.out.println("2. Outcome");
        System.out.println("3. Get balance");
        System.out.println("4. Loan");
        System.out.println("5. Debt");
        System.out.println("0. Return to main menu");
    }
    public void incomeMenu(){
        System.out.println("<____ Income Menu ____>");
        System.out.println("1. New income");
        System.out.println("2. Edit income");
        System.out.println("3. Remove income");
        System.out.println("4. Display all of incomes");
        System.out.println("5. Get total of incomes");
        System.out.println("0. Return to previous menu");
    }
    public void editIncomeMenu(){
        System.out.println("<....Edit income menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit money");
        System.out.println("3. Edit note");
        System.out.println("4. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    public void outcomeMenu(){
        System.out.println("<____ Outcome Menu ____>");
        System.out.println("1. New outcome");
        System.out.println("2. Edit outcome");
        System.out.println("3. Remove outcome");
        System.out.println("4. Display all of outcomes");
        System.out.println("5. Get total of outcomes");
        System.out.println("0. Return to previous menu");
    }
    public void editOutcomeMenu(){
        System.out.println("<....Edit outcome menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit money");
        System.out.println("3. Edit note");
        System.out.println("4. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    public void loanMenu(){
        System.out.println("<____ Loan menu ____>");
        System.out.println("1. New loan");
        System.out.println("2. Edit loan");
        System.out.println("3. Remove loan");
        System.out.println("4. Receive loan");
        System.out.println("5. Display all of loans");
        System.out.println("6. Get total of loans");
        System.out.println("0. Return to previous menu");
    }
    public void editLoanMenu(){
        System.out.println("<....Edit loan menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit name");
        System.out.println("3. Edit money");
        System.out.println("4. Edit note");
        System.out.println("5. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    public void debtMenu(){
        System.out.println("<____ Debt menu ____>");
        System.out.println("1. New debt");
        System.out.println("2. Edit debt");
        System.out.println("3. Remove debt");
        System.out.println("4. Repay debt");
        System.out.println("5. Display all of debts");
        System.out.println("6. Get total of debts");
        System.out.println("0. Return to previous menu");
    }
    public void editDebtMenu(){
        System.out.println("<....Edit debt menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit name");
        System.out.println("3. Edit money");
        System.out.println("4. Edit note");
        System.out.println("5. Edit all information");
        System.out.println("0. Return to previous menu");
    }
}
