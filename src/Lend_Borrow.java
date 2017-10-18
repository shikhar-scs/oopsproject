import java.io.Serializable;
import java.util.*;

public class Lend_Borrow implements Serializable{

    private String personName;
    private String type;/*whether a person has borrowed or lent money*/
    private float amount;
    private String tag;//applicable for loans only
    private Date date = new Date();
    private String ModeOfPayment;

    public String returnpersonName() {
        return personName;
    }
    public String returnType() {
        return type;
    }
    public float returnAmount() {
        return amount;
    }
    public String returntag() {
        return tag;
    }
    public String returnModeOfPayment() {return ModeOfPayment;}
    public Date returnDate() {return date;}
    /*Constructor for loan*/
    Lend_Borrow (String type,String personName,float amount,String tag,String ModeOfPayment,Date date) {
        this.type=type;
        this.personName=personName;
        this.amount=amount;
        this.tag=tag;
        this.ModeOfPayment=ModeOfPayment;
        this.date=date;
    }
}