import java.io.Serializable;

public class Owes_To implements Serializable{

    private String bankName;
    private String type;/*whether a person wants to store as a deposit or take loan*/
    private String accountType;//savings or current
    private float rate;
    private float amount;
    private String accountNum;//applicable for deposits only
    private String loanNum;//applicable for loans only

    public String returnBankName() {
        return bankName;
    }

    public String returnType() {
        return type;
    }

    public String returnAccountType() {
        return accountType;
    }

    public float returnRate() {
        return rate;
    }

    public float returnAmount() {
        return amount;
    }

    public String returnAccountNumber() {
        return accountNum;
    }

    public String returnLoanNumber() {
        return loanNum;
    }

    /*Constructor for loan*/
    Owes_To (String type,String bankName,float rate,float amount,String loanNum) {
        this.type=type;
        this.bankName=bankName;
        this.rate=rate;
        this.amount=amount;
        this.loanNum=loanNum;
    }

    /*Constructor for deposits*/
    Owes_To (String type,String bankName,float rate,float amount,String accountNum,String accountType) {
        this.type=type;
        this.bankName=bankName;
        this.rate=rate;
        this.amount=amount;
        this.accountNum=accountNum;
        this.accountType=accountType;
    }
}