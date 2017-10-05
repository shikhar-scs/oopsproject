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


// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
// CALL ME WHEN THERE IS MORE WORK TO DO
public class Person {

    public Scanner input  = new Scanner(System.in);
    private int personId;
    private String personName;
    private String userName;
    private String password;
    private static Vector<Expense> VectorOfExpenses=new Vector<>(0);
    private static Vector<Owes_To_Or_From> VectorOfOwes_To=new Vector<>(0);

    public Person(String personName,String userName,String password,int personId) {
        this.personName=personName;
        this.userName=userName;
        this.password=password;
        this.personId=personId;
    }

    public void loggedIn () {
        System.out.println("Successfully logged in as "+personName);
        System.out.println("User Id : "+personId);
        //insert 3 or 4 sec time delay then clear sc and display the followin->

        System.out.println("1. Add New Expense");
        System.out.println("2. Delete Existing Expense");
        System.out.println("3. Money given on/taken as loan ");
        System.out.println("4. View Total Expenses");
        System.out.println("5. Avg Expense per day");

        int expensechoice = input.nextInt();

        switch (expensechoice)
        {
            case 1 :
                addExpense();
                //input all the expense details
                // push it to the array of expenses in the same way you pushed a person
                // send all relevant details);
                break;

            case 2: //delete on basis of date or tag and amount

            case 3: //call a display function from owes to and display.... total expense incudes this too

            case 4 :int t=TotalDisplay();//can be implemented here only by iterating through amount and display total);
                    // break not included on purpose as TOtal days is anyways required for both
            case 5 : int d=TotalDays();
                       object.tot_avg=t/d;_
                System.out.println(t/d);;
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
