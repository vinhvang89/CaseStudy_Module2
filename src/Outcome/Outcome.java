package Outcome;


public class Outcome {
    private double money;
    private String note;
    private String date;
    private int code = 0;
    public Outcome(String date,double money, String note) {
        this.money = money;
        this.note = note;
        this.date = date;
        this.code++;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public int getCode() {
        return code;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String toString(){
        return "Date: "+date+" , "+",Outcome : "+money+" ,Note : "+note+" ,Code: "+code;
    }
}
