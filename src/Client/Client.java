package Client;

import Manager.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private final MoneyManager moneyManager;
    private final IncomeManager incomeManager;
    private final OutcomeManager outcomeManager;
    private final LoanManager loanManager;
    private final DebtManager debtManager;
    private final SecretaryMenuDesigner secretaryMenuDesigner;

    public Client() throws IOException {
        moneyManager = MoneyManager.getMoneyManager();
        incomeManager = moneyManager.getIncomeManager();
        outcomeManager = moneyManager.getOutcomeManager();
        debtManager = moneyManager.getDebtManager();
        loanManager = moneyManager.getLoanManager();
        secretaryMenuDesigner = SecretaryMenuDesigner.getSecretaryMenuDesigner();
    }
    protected void moneyManagerMenuRun() throws IOException {
        secretaryMenuDesigner.moneyManagerMenu();
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
    protected void incomeMenuRun() throws IOException {
        secretaryMenuDesigner.incomeMenu();
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
                incomeManager.newIncomes(date,money,note);
                incomeMenuRun();
                break;
            case 2:
                System.out.println("Enter code");
                int code = scanner.nextInt();
                if( incomeManager.checkCode(code))
                    editIncomeMenuRun(code);
                else
                    System.out.println("This code is wrong");
                incomeMenuRun();
                break;
            case 3:
                System.out.println("Enter code");
                int code1 = scanner.nextInt();
                if(incomeManager.checkCode(code1))
                    moneyManager.remove(incomeManager,code1);
                else
                    System.out.println("This code is wrong");
                incomeMenuRun();
                break;
            case 4:
                incomeManager.display();
                incomeMenuRun();
                break;
            case 5:
                moneyManager.getTotal(incomeManager);
                incomeMenuRun();
                break;
            case 0:
                moneyManagerMenuRun();
                moneyManager.writerData(incomeManager);
                break;
            default:
                System.out.println("please choose from 0 to 5");
                incomeMenuRun();

        }
    }
    protected void editIncomeMenuRun(int code) throws IOException {
        secretaryMenuDesigner.editIncomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                incomeManager.editDate(code,date);
                editIncomeMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                incomeManager.editMoney(code,money);
                editIncomeMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                incomeManager.editNote(code,note);
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
                incomeManager.editDate(code,date1);
                incomeManager.editMoney(code,money1);
                incomeManager.editNote(code,note1);
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
    private void outcomeMenuRun() throws IOException {
        secretaryMenuDesigner.outcomeMenu();
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
                outcomeManager.newOutcomes(date,money,note);
                outcomeMenuRun();
                break;
            case 2:
                System.out.println("Enter code");
                int code = scanner.nextInt();
                if( outcomeManager.checkCode(code))
                    editOutcomeMenuRun(code);
                else
                    System.out.println("This code is wrong");
                outcomeMenuRun();
                break;
            case 3:
                System.out.println("Enter code");
                int code1 = scanner.nextInt();
                if( outcomeManager.checkCode(code1))
                    moneyManager.remove(outcomeManager,code1);
                else
                    System.out.println("This code is wrong");
                outcomeMenuRun();
                break;
            case 4:
                outcomeManager.display();
                outcomeMenuRun();
                break;
            case 5:
                moneyManager.getTotal(outcomeManager);
                outcomeMenuRun();
                break;
            case 0:
                moneyManager.writerData(outcomeManager);
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("please choose from 0 to 5 ");
                outcomeMenuRun();

        }
    }
    public void editOutcomeMenuRun(int code) throws IOException {
        secretaryMenuDesigner.editOutcomeMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date");
                String date = scanner.nextLine();
                moneyManager.editDate(outcomeManager,code,date);
                editOutcomeMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.editMoney(outcomeManager,code,money);
                editOutcomeMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.editNote(outcomeManager,code,note);
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
                moneyManager.editDate(outcomeManager,code,date1);
                moneyManager.editMoney(outcomeManager,code,money1);
                moneyManager.editNote(outcomeManager,code,note1);
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
    private void debtMenuRun() throws IOException {
        secretaryMenuDesigner.debtMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose: ");
        int choose = scanner.nextInt();
        scanner.nextLine();
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
                debtManager.newDebt(date,name,money,note);
                debtMenuRun();
                break;
            case 2:
                System.out.println("Enter code ");
                int code = scanner.nextInt();
                scanner.nextLine();
                if (debtManager.checkCode(code))
                    editDebtMenuRun(code);
                else
                    System.out.println("This code is wrong");
                debtMenuRun();
                break;
            case 3:
                System.out.println("Enter code ");
                int code1 = scanner.nextInt();
                scanner.nextLine();
                if (debtManager.checkCode(code1))
                    moneyManager.remove(debtManager,code1);
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
                debtManager.display();
                debtMenuRun();
                break;
            case 6:
                moneyManager.getTotal(debtManager);
                debtMenuRun();
                break;
            case 0:
                moneyManager.writerData(debtManager);
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 6");
                debtMenuRun();
        }
    }
    private void editDebtMenuRun(int code) throws IOException {
        secretaryMenuDesigner.editDebtMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date ");
                String date = scanner.nextLine();
                moneyManager.editDate(debtManager,code,date);
                editDebtMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                moneyManager.editName(debtManager,code,name);
                editDebtMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.editMoney(debtManager,code,money);
                editDebtMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.editNote(debtManager,code,note);
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
                moneyManager.editDate(debtManager,code,date1);
                moneyManager.editName(debtManager,code,name1);
                moneyManager.editMoney(debtManager,code,money1);
                moneyManager.editNote(debtManager,code,note1);
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

    private void loanMenuRun() throws IOException {
        secretaryMenuDesigner.loanMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose: ");
        int choose = scanner.nextInt();
        scanner.nextLine();
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
                loanManager.newLoan(date,name,money,note);
                loanMenuRun();
                break;
            case 2:
                System.out.println("Enter code ");
                int code = scanner.nextInt();
                scanner.nextLine();
                if (loanManager.checkCode(code))
                    editLoanMenuRun(code);
                else
                    System.out.println("This code is wrong");
                loanMenuRun();
                break;
            case 3:
                System.out.println("Enter code ");
                int code1 = scanner.nextInt();
                scanner.nextLine();
                if (loanManager.checkCode(code1))
                    moneyManager.remove(loanManager,code1);
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
                loanManager.display();
                loanMenuRun();
                break;
            case 6:
                moneyManager.getTotal(loanManager);
                loanMenuRun();
                break;
            case 0:
                moneyManager.writerData(loanManager);
                moneyManagerMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 6");
                loanMenuRun();
        }
    }
    private void editLoanMenuRun(int code) throws IOException {
        secretaryMenuDesigner.editLoanMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose :");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter new date ");
                String date = scanner.nextLine();
                moneyManager.editDate(loanManager,code,date);
                editLoanMenuRun(code);
                break;
            case 2:
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                moneyManager.editName(loanManager,code,name);
                editLoanMenuRun(code);
                break;
            case 3:
                System.out.println("Enter new money");
                double money = scanner.nextDouble();
                scanner.nextLine();
                moneyManager.editMoney(loanManager,code,money);
                editLoanMenuRun(code);
                break;
            case 4:
                System.out.println("Enter new note");
                String note = scanner.nextLine();
                moneyManager.editNote(loanManager,code,note);
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
                moneyManager.editDate(loanManager,code,date1);
                moneyManager.editName(loanManager,code,name1);
                moneyManager.editMoney(loanManager,code,money1);
                moneyManager.editNote(loanManager,code,note1);
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
    public void lottoMenuRun() throws IOException {
        secretaryMenuDesigner.lottoMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                String link = "https://xoso.com.vn/xo-so-mien-bac/xsmb-p1.html";
                URL url = new URL(link);
                Scanner scanner1 = new Scanner(new InputStreamReader(url.openStream()));
                scanner1.useDelimiter("\\Z");
                String content = scanner1.next();
                Pattern pattern = Pattern.compile("<span class=\"item col1 colorred xshover\">(.*?)</span>");
                Matcher matcher = pattern.matcher(content);
                System.out.println("Result of premium in 7 days ");
                while (matcher.find()){
                    System.out.println(matcher.group(1));
                }
                lottoMenuRun();
                break;
            case 2:
                int num1 = (int) (Math.random()*100);
                int num2 = (int) (Math.random()*10);
                System.out.println("The lucky number of today is : "+(num1+num2));
            case 0:
                mainMenuRun();
                break;
            default:
                System.out.println("Please choose from 0 to 2");
                lottoMenuRun();
        }
    }
    public void mainMenuRun() throws IOException {
        secretaryMenuDesigner.mainMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                moneyManagerMenuRun();
                break;
            case 2:
                lottoMenuRun();
                break;
            case 0:
                System.out.println("Goodbye ^_^");
            default:
                System.out.println("Please choose from 0 to 2");
                mainMenuRun();
        }
    }
    public void start() throws IOException {
        mainMenuRun();
    }
}
