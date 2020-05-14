package Client;

import Manager.MoneyManager;

import java.util.Scanner;

public class Client {
    private final MoneyManager moneyManager;

    public Client() {
        moneyManager = MoneyManager.getMoneyManager();
    }
    private void mainMenu(){
        System.out.println("<===== Main menu =====>");
        System.out.println("1. Money Manager");
        System.out.println("0. Exit");
    }
    private void moneyManagerMenu(){
        System.out.println("<+++ Money Manager Menu +++>");
        System.out.println("1. Income");
        System.out.println("2. Outcome");
        System.out.println("3. Get balance");
        System.out.println("4. Loan");
        System.out.println("5. Debt");
        System.out.println("0. Return to main menu");
    }
    private void incomeMenu(){
        System.out.println("<____ Income Menu ____>");
        System.out.println("1. New income");
        System.out.println("2. Edit income");
        System.out.println("3. Remove income");
        System.out.println("4. Display all of incomes");
        System.out.println("5. Get total of incomes");
        System.out.println("0. Return to previous menu");
    }
    private void editIncomeMenu(){
        System.out.println("<....Edit income menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit money");
        System.out.println("3. Edit note");
        System.out.println("4. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    private void outcomeMenu(){
        System.out.println("<____ Outcome Menu ____>");
        System.out.println("1. New outcome");
        System.out.println("2. Edit outcome");
        System.out.println("3. Remove outcome");
        System.out.println("4. Display all of outcomes");
        System.out.println("5. Get total of outcomes");
        System.out.println("0. Return to previous menu");
    }
    private void editOutcomeMenu(){
        System.out.println("<....Edit outcome menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit money");
        System.out.println("3. Edit note");
        System.out.println("4. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    private void loanMenu(){
        System.out.println("<____ Loan menu ____>");
        System.out.println("1. New loan");
        System.out.println("2. Edit loan");
        System.out.println("3. Remove loan");
        System.out.println("4. Receive loan");
        System.out.println("5. Display all of loans");
        System.out.println("6. Get total of loans");
        System.out.println("0. Return to previous menu");
    }
    private void editLoanMenu(){
        System.out.println("<....Edit loan menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit name");
        System.out.println("3. Edit money");
        System.out.println("4. Edit note");
        System.out.println("5. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    private void debtMenu(){
        System.out.println("<____ Debt menu ____>");
        System.out.println("1. New debt");
        System.out.println("2. Edit debt");
        System.out.println("3. Remove debt");
        System.out.println("4. Repay debt");
        System.out.println("5. Display all of debts");
        System.out.println("6. Get total of debts");
        System.out.println("0. Return to previous menu");
    }
    private void editDebtMenu(){
        System.out.println("<....Edit debt menu....>");
        System.out.println("1. Edit date");
        System.out.println("2. Edit name");
        System.out.println("3. Edit money");
        System.out.println("4. Edit note");
        System.out.println("5. Edit all information");
        System.out.println("0. Return to previous menu");
    }
    private void moneyManagerMenuRun(){
        moneyManagerMenu();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                incomeMenuRun();
                break;
            case 2:
                outcomeMenuRun();
                break;
            case 3:
                System.out.println(moneyManager.getBalance());
                moneyManagerMenuRun();
                break;
            case 4:
                loanMenuRun();
                break;
            case 5:
                debtMenuRun();
                break;
            case 0:
                mainMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 5");
                moneyManagerMenuRun();
        }
    }
    private void incomeMenuRun(){
        incomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new Note");
                String note = scanner.nextLine();
                moneyManager.getIncomeManager().newIncomes(date,money,note);
                incomeMenuRun();
                break;
            case 2:
                System.out.println("Enter code");
                int code = scanner.nextInt();
                if( moneyManager.getIncomeManager().checkCode(code))
                    editIncomeMenuRun(code);
                else
                    System.out.println("This code is wrong");
                incomeMenuRun();
                break;
            case 3:
                System.out.println("Enter code");
                int code1 = scanner.nextInt();
                if(moneyManager.getIncomeManager().checkCode(code1))
                    moneyManager.remove(moneyManager.getIncomeManager(),code1);
                else
                    System.out.println("This code is wrong");
                incomeMenuRun();
                break;
            case 4:
                moneyManager.getIncomeManager().display();
                incomeMenuRun();
                break;
            case 5:
                moneyManager.getTotal(moneyManager.getIncomeManager());
                incomeMenuRun();
                break;
            case 0:
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("please choose from 0 to 5");
                incomeMenuRun();

        }
    }
    public void editIncomeMenuRun(int code){
        editIncomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                moneyManager.getIncomeManager().editDate(code,date);
                editIncomeMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.getIncomeManager().editMoney(code,money);
                editIncomeMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.getIncomeManager().editNote(code,note);
                editIncomeMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new date");
                String date1 = scanner.nextLine();
                System.out.println("Enter new money");
                double money1 = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new note");
                String note1 = scanner.nextLine();
                moneyManager.getIncomeManager().editDate(code,date1);
                moneyManager.getIncomeManager().editMoney(code,money1);
                moneyManager.getIncomeManager().editNote(code,note1);
                editIncomeMenuRun(code);
                break;
            case 0:
                incomeMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 4 ");
                editIncomeMenuRun(code);
        }
    }
    private void outcomeMenuRun(){
        outcomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new Note");
                String note = scanner.nextLine();
                moneyManager.getOutcomeManager().newOutcomes(date,money,note);
                outcomeMenuRun();
                break;
            case 2:
                System.out.println("Enter code");
                int code = scanner.nextInt();
                if( moneyManager.getOutcomeManager().checkCode(code))
                    editOutcomeMenuRun(code);
                else
                    System.out.println("This code is wrong");
                outcomeMenuRun();
                break;
            case 3:
                System.out.println("Enter code");
                int code1 = scanner.nextInt();
                if( moneyManager.getOutcomeManager().checkCode(code1))
                    moneyManager.remove(moneyManager.getOutcomeManager(),code1);
                else
                    System.out.println("This code is wrong");
                outcomeMenuRun();
                break;
            case 4:
                moneyManager.getOutcomeManager().display();
                outcomeMenuRun();
                break;
            case 5:
                moneyManager.getOutcomeManager().getTotal();
                outcomeMenuRun();
                break;
            case 0:
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("please choose from 0 to 5 ");
                outcomeMenuRun();

        }
    }
    public void editOutcomeMenuRun(int code){
        editOutcomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                moneyManager.getOutcomeManager().editDate(code,date);
                editOutcomeMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.getOutcomeManager().editMoney(code,money);
                editOutcomeMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.getOutcomeManager().editNote(code,note);
                editOutcomeMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new date");
                String date1 = scanner.nextLine();
                System.out.println("Enter new money");
                double money1 = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new note");
                String note1 = scanner.nextLine();
                moneyManager.getOutcomeManager().editDate(code,date1);
                moneyManager.getOutcomeManager().editMoney(code,money1);
                moneyManager.getOutcomeManager().editNote(code,note1);
                editOutcomeMenuRun(code);
                break;
            case 0:
                outcomeMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 4 ");
                editOutcomeMenuRun(code);
        }
    }
    private void debtMenuRun(){
        debtMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose: ");
        int choose = scanner.nextInt();
        scanner.next();
        switch (choose){
            case 1:
                System.out.println("Enter new date :");
                String date = scanner.nextLine();
                System.out.println("Enter new name :");
                String name = scanner.nextLine();
                System.out.println("Enter money :");
                double money = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new note :");
                String note = scanner.nextLine();
                moneyManager.getDebtManager().newDebt(date,name,money,note);
                debtMenuRun();
                break;
            case 2:
                System.out.println("Enter code ");
                int code = scanner.nextInt();
                scanner.nextLine();
                if (moneyManager.getDebtManager().checkCode(code))
                    editDebtMenuRun(code);
                else
                    System.out.println("This code is wrong");
                debtMenuRun();
                break;
            case 3:
                System.out.println("Enter code ");
                int code1 = scanner.nextInt();
                scanner.nextLine();
                if (moneyManager.getDebtManager().checkCode(code1))
                    moneyManager.remove(moneyManager.getDebtManager(),code1);
                else
                    System.out.println("This code is wrong");
                debtMenuRun();
                break;
            case 4:
                System.out.println("Enter date");
                String date3 = scanner.nextLine();
                System.out.println("Enter name");
                String name3 = scanner.nextLine();
                System.out.println("Enter money");
                double money3 = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.repayDebt(date3,name3,money3);
                debtMenuRun();
                break;
            case 5:
                moneyManager.getDebtManager().display();
                debtMenuRun();
                break;
            case 6:
                moneyManager.getDebtManager().getTotal();
                debtMenuRun();
                break;
            case 0:
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 6");
                debtMenuRun();
        }
    }
    private void editDebtMenuRun(int code){
        editDebtMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date ");
                String date = scanner.nextLine();
                moneyManager.getDebtManager().editDate(code,date);
                editDebtMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                moneyManager.getDebtManager().editName(code,name);
                editDebtMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.getDebtManager().editMoney(code,money);
                editDebtMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.getDebtManager().editNote(code,note);
                editDebtMenuRun(code);
                break;
            case 5:
                System.out.println("Enter new date");
                String date1 = scanner.nextLine();
                System.out.println("Enter new name");
                String name1 = scanner.nextLine();
                System.out.println("Enter new money");
                double money1 = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new note");
                String note1 = scanner.nextLine();
                moneyManager.getDebtManager().editDate(code,date1);
                moneyManager.getDebtManager().editName(code,name1);
                moneyManager.getDebtManager().editMoney(code,money1);
                moneyManager.getDebtManager().editNote(code,note1);
                editDebtMenuRun(code);
                break;
            case 0:
                debtMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 5");
                editDebtMenuRun(code);
        }
    }

    private void loanMenuRun(){
        loanMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose: ");
        int choose = scanner.nextInt();
        scanner.next();
        switch (choose){
            case 1:
                System.out.println("Enter new date :");
                String date = scanner.nextLine();
                System.out.println("Enter new name :");
                String name = scanner.nextLine();
                System.out.println("Enter money :");
                double money = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter note :");
                String note = scanner.nextLine();
                moneyManager.getLoanManager().newLoan(date,name,money,note);
                loanMenuRun();
                break;
            case 2:
                System.out.println("Enter code ");
                int code = scanner.nextInt();
                scanner.nextLine();
                if (moneyManager.getLoanManager().checkCode(code))
                    editLoanMenuRun(code);
                else
                    System.out.println("This code is wrong");
                loanMenuRun();
                break;
            case 3:
                System.out.println("Enter code ");
                int code1 = scanner.nextInt();
                scanner.nextLine();
                if (moneyManager.getLoanManager().checkCode(code1))
                    moneyManager.remove(moneyManager.getLoanManager(),code1);
                else
                    System.out.println("This code is wrong");
                loanMenuRun();
                break;
            case 4:
                System.out.println("Enter date");
                String date3 = scanner.nextLine();
                System.out.println("Enter name");
                String name3 = scanner.nextLine();
                System.out.println("Enter money");
                double money3 = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.receiveLoan(date3,name3,money3);
                loanMenuRun();
                break;
            case 5:
                moneyManager.getLoanManager().display();
                loanMenuRun();
                break;
            case 6:
                moneyManager.getLoanManager().getTotal();
                loanMenuRun();
                break;
            case 0:
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 6");
                loanMenuRun();
        }
    }
    private void editLoanMenuRun(int code){
        editLoanMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date ");
                String date = scanner.nextLine();
                moneyManager.getLoanManager().editDate(code,date);
                editLoanMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                moneyManager.getLoanManager().editName(code,name);
                editLoanMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.getLoanManager().editMoney(code,money);
                editLoanMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.getLoanManager().editNote(code,note);
                editLoanMenuRun(code);
                break;
            case 5:
                System.out.println("Enter new date");
                String date1 = scanner.nextLine();
                System.out.println("Enter new name");
                String name1 = scanner.nextLine();
                System.out.println("Enter new money");
                double money1 = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter new note");
                String note1 = scanner.nextLine();
                moneyManager.getLoanManager().editDate(code,date1);
                moneyManager.getLoanManager().editName(code,name1);
                moneyManager.getLoanManager().editMoney(code,money1);
                moneyManager.getLoanManager().editNote(code,note1);
                editLoanMenuRun(code);
                break;
            case 0:
                loanMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 5");
                editLoanMenuRun(code);
        }
    }
    public void mainMenuRun(){
        mainMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                moneyManagerMenuRun();
                break;
            case 0:
                System.out.println("Goodbye ^_^");
        }
    }
    public void start(){
        mainMenuRun();
    }
}
