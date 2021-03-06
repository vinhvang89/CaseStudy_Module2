package Loan;

public class Loan {
    private String date;
    private String name;
    private double money;
    private String note;
    private int code = 0;
    public Loan(String date, String name, double money,String note) {
        this.date = date;
        this.name = name;
        this.money = money;
        this.note = note;
        code++;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getCode() {
        return code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString(){
        return "Date: "+date+" ,Name: "+name+" ,Loan: "+money+" ,Note: "+note+" ,Code: "+code;
    }
}
