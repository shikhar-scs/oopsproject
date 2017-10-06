import java.util.Date;
import java.util.*;


public class Expense {

    private String tag;
    private String modeOfPayment;
    private Float amount;
    Date date = new Date();

    Expense(String tag,String modeOfPayment,Float amount,Date date) {
        this.tag=tag;
        this.amount=amount;
        this.date= (returnDate());
        this.modeOfPayment=modeOfPayment;
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

/*Previous tasks have been implemented #SHM
 *
 *
 * calculation of average expense still remains */