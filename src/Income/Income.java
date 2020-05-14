package Income;


public class Income {
    private Double money;
    private String note ;
    private String date;
    private int code = 0;
    public Income(String date,Double money, String note) {
        this.money = money;
        this.note = note;
        this.date = date;
        this.code++;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public int getCode() {
        return code;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String toString(){
        return "Date: "+date+" ,Income : "+money+" ,Note : "+note+" ,Code :"+code;
    }
}
