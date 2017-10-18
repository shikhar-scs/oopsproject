import java.util.*;
import java.lang.*;
import java.io.*;

public class Person implements Serializable{

    private int personId;
    private String personName;
    private String userName;
    private String password;

    private Vector<Expense> vectorOfExpenses=new Vector<>(0);
    private Vector<Owes_To> vectorOfOwes_To=new Vector<>(0);
    private Vector<Lend_Borrow> vectorOfLend_borrow=new Vector<>(0);

    public Person(String personName,String userName,String password,int personId) {
        this.personName=personName;
        this.userName=userName;
        this.password=password;
        this.personId=personId;
    }

    public boolean verify(String userName,String password){
        if(this.userName.equals(userName) && this.password.equals(password))
            return true;
        else
            return false;
    }

    public void addExpenses(Vector<Expense> vectorOfExpenses){
        this.vectorOfExpenses=vectorOfExpenses;
    }

    public String returnUserName() {
        return userName;
    }
    public String returnPersonName() {
        return personName;
    }
    public int returnPersonId(){
        return personId;
    }
    public Vector<Expense> returnVectorOfExpenses(){
        return vectorOfExpenses;
    }
    public void addOwes_To(Vector<Owes_To> vectorOfOwes_To){
        this.vectorOfOwes_To=vectorOfOwes_To;
    }
    public Vector<Owes_To> returnVectorOfOwes_to(){
        return vectorOfOwes_To;
    }
    public void addLend_Borrow(Vector<Lend_Borrow> vectorOfLend_borrow){
        this.vectorOfLend_borrow=vectorOfLend_borrow;
    }
    public Vector<Lend_Borrow> returnVectorOfLend_Borrow(){
        return vectorOfLend_borrow;
    }

}
