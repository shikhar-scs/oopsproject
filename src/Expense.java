import java.util.*;

public class Expense {

    private String tag;
    private String modeOfPayment;
    private float amount;
    private String date;

    Expense(String tag,String modeOfPayment,float amount,Date date) {
        this.tag=tag;
        this.amount=amount;
        this.date= date.getDate()+"/"+date.getMonth()+"/"+date.getYear();/**These functions may appear to be struck off
         as they are "DEPRECATED METHODS"*/
        this.modeOfPayment=modeOfPayment;
    }
    public String returnTag() {
        return tag;
    }
    public float returnAmount() {
        return amount;
    }
    public String returnDate() {
        return date;
    }
    public String returnModeOfPayment() {
        return modeOfPayment;
    }


}

/**Previous tasks have been implemented #SHM
 *
 *
 * calculation of average expense still remains */