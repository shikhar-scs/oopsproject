import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable{

    private String tag;
    private String modeOfPayment;
    private Float amount;
    Date date = new Date();

    Expense(String tag,String modeOfPayment,Float amount,Date date) {
        this.tag=tag;
        this.amount=amount;
        this.date= (returnDate());
        this.modeOfPayment=modeOfPayment;
        this.date=date;

    }

    public String returnTag() {
        return tag;
    }

    public float returnAmount() {
        return amount;
    }

    public Date returnDate() {
        return date;
    }

    public String returnModeOfPayment() {
        return modeOfPayment;
    }
}