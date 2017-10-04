//public class Person {
//    Expense [] e; //convert it to a vector
//    Owes_To [] o; //convert to a vector
//    int current_balance;
//    boolean debt;
//    float avg;
//}
//the above mentioned tasks are yet to be implemented

import java.util.*;
import java.lang.*;
import java.util.Vector;


public class Person {

    public Scanner input  = new Scanner(System.in);
    private int personId;
    private String personName;
    private String userName;
    private String password;
    private static Vector<Expense> VectorOfExpenses=new Vector<>(0);
    private static Vector<Owes_To> VectorOfOwes_To=new Vector<>(0);

    public Person(String personName,String userName,String password,int personId) {
        this.personName=personName;
        this.userName=userName;
        this.password=password;
        this.personId=personId;
    }

    public void loggedIn () {
        System.out.println("Successfully logged in as "+personName);
        System.out.println("User Id : "+personId);
        //insert 3 or 4 sec time delay
        System.out.println("1. Add New Expense");
        System.out.println("2. Delete Existing Expense");
        System.out.println("3. Money on/as loan ");
        System.out.println("4. View Total Expenses");
        System.out.println("5. Avg Expense per day");

        int expensechoice = input.nextInt();

        switch (expensechoice)
        {
            case 1 : //input all the expense details
                // push it to the array of expenses in the same way you push a person
                //addition has been done
                addExpense();// send all relevant details);
                break;

            case 2: //delete on basis of date or tag and amount

            case 3: //call a display function from owes to and display.... total expense incudes this too

            case 4 :
                t=TotalDisplay();//can be implemented here only by iterating through amount and display total);

            case 5 : d=TotalDays();
                cout<<t/d;
                break;
        }

    }

    public boolean verify(String userName,String password){
        if(this.userName.equals(userName) && this.password.equals(password))
            return true;
        else
            return false;
    }

    public String returnUserName() {
        return userName;
    }
}
