import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Person {

    private int personId;
    private String personName;
    private String userName;
    private String password;
    private Vector<Expense> vectorOfExpenses=new Vector<>(0);
    private Vector<Owes_To> vectorOfOwes_To=new Vector<>(0);
    private Vector<Lend_Borrow> vectorOfLend_borrow=new Vector<>(0);

    public Scanner input  = new Scanner(System.in);

    public Person(String personName,String userName,String password,int personId) {
        this.personName=personName;
        this.userName=userName;
        this.password=password;
        this.personId=personId;
    }

    private void viewExpenses(){
        System.out.println('\n');
        System.out.println("Expenses Details");
        System.out.println("--Sr.-- "+" --Tag--" +" --Date-- "+" --Mode Of Payment-- "+" --Amount-- ");
        for(int i=0;i<vectorOfExpenses.size();i++) {
            System.out.println((i+1)+"   "+vectorOfExpenses.elementAt(i).returnTag()+"   "+vectorOfExpenses.elementAt(i).returnDate()+"   "+vectorOfExpenses.elementAt(i).returnModeOfPayment()+"   "+vectorOfExpenses.elementAt(i).returnAmount());
        }

        System.out.println('\n');
        System.out.println("Money Lent/Borrowed from friends");

        System.out.println("--Sr.-- "+" --Category-- "+"--Tag--"+"--Name of Friend " +" --Date-- "+" --Mode Of Payment-- "+" --Amount-- ");
        for(int i=0;i<vectorOfLend_borrow.size();i++) {
            System.out.println((i+1)+"   "+vectorOfLend_borrow.elementAt(i).returnType()+"   "+ vectorOfLend_borrow.elementAt(i).returntag()+"   "+vectorOfLend_borrow.elementAt(i).returnpersonName()+"  "+vectorOfLend_borrow.elementAt(i).returnDate()+"   "+vectorOfLend_borrow.elementAt(i).returnModeOfPayment()+"   "+vectorOfLend_borrow.elementAt(i).returnAmount());
        }

        System.out.println('\n');

        System.out.println("Loan Details");
        System.out.println("--Bank-- "+" --Amount-- "+" --Rate-- "+" --Loan No.-- ");
        for(int i=0;i<vectorOfOwes_To.size();i++) {
            if(vectorOfOwes_To.elementAt(i).returnType().equals("Deposit"))
                continue;
            System.out.println(vectorOfOwes_To.elementAt(i).returnBankName()+"   "+vectorOfOwes_To.elementAt(i).returnAmount()+"   "+vectorOfOwes_To.elementAt(i).returnRate()+"   "+vectorOfOwes_To.elementAt(i).returnLoanNumber());
        }

        System.out.println('\n');
        System.out.println('\n');
        System.out.println("Deposit Details");
        System.out.println("--Bank-- "+" --Amount-- "+" --Rate-- "+" --Account No.-- "+" --Account Type-- ");
        for(int i=0;i<vectorOfOwes_To.size();i++) {
            if(vectorOfOwes_To.elementAt(i).returnType().equals("Loan"))
                continue;
            System.out.println(vectorOfOwes_To.elementAt(i).returnBankName()+"   "+vectorOfOwes_To.elementAt(i).returnAmount()+"   "+vectorOfOwes_To.elementAt(i).returnRate()+"   "+vectorOfOwes_To.elementAt(i).returnAccountNumber()+"   "+vectorOfOwes_To.elementAt(i).returnAccountType());
        }
    }

    private void addLoan() {
        System.out.println('\n');
        Owes_To tempLoan=null;

        System.out.println("Please Enter The Name Of The Bank");
        String bankName=input.nextLine();

        System.out.println("1. Add a new loan");
        System.out.println("2. Add a new account");
        int choice=input.nextInt();
        input.nextLine();

        if(choice==1){
            System.out.println("Please Enter The Amount");
            float amount=input.nextFloat();
            input.nextLine();

            System.out.println("Please Enter The Rate Of Interest");
            float rate=input.nextFloat();
            input.nextLine();

            System.out.println("Please Enter The Loan Number/Id");
            String loanNum=input.nextLine();

            tempLoan=new Owes_To("Loan",bankName,rate,amount,loanNum);
        }

        else if(choice==2){
            System.out.println("Please Enter The Amount");
            float amount=input.nextFloat();
            input.nextLine();

            System.out.println("Please Enter The Type Of Account");
            String accountType=input.nextLine();

            System.out.println("Please Enter The Account Number");
            String accountNum=input.nextLine();

            System.out.println("Please Enter The Rate Of Interest");
            float rate=input.nextFloat();
            input.nextLine();

            tempLoan=new Owes_To("Deposit",bankName,rate,amount,accountNum,accountType);

        }
        vectorOfOwes_To.add(tempLoan);
    }

    private void addExpense() {
        System.out.println('\n');
        Expense tempExpense;

        System.out.println("Please enter the category/tag of expenditure");
        String tag=input.nextLine();


        System.out.println("Please enter the amount of expenditure");
        float amount=input.nextFloat();
        input.nextLine();

        System.out.println("Please enter the mode of payment of the expenditure");
        String modeOfPayment=input.nextLine();


        Date date=new Date();
        tempExpense=new Expense(tag,modeOfPayment,amount,date);

        vectorOfExpenses.add(tempExpense);
    }

    private void deleteLoan() {
        System.out.println('\n');

        System.out.println("Please enter the loan number of the loan you want to delete");
        String delId = input.nextLine();

        int p = 1;
        Vector<Owes_To> tempVector=new Vector<>(0);
        for (int i = 0; i < vectorOfOwes_To.size(); i++) {
            if (vectorOfOwes_To.elementAt(i).returnType().equals("Loan")) {
                if (vectorOfOwes_To.elementAt(i).returnLoanNumber().equals(delId)) {
                    p = -1;
                    continue;
                }
            }
            tempVector.add(vectorOfOwes_To.elementAt(i));
        }
        vectorOfOwes_To=tempVector;
        if (p == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired loan record has been deleted");
        }
    }
    private void deleteAccount() {
        System.out.println('\n');

        System.out.println("Please enter the account number of the deposit you want to delete");
        String delId = input.nextLine();

        int p = 1;
        Vector<Owes_To> tempVector=new Vector<>(0);
        for (int i = 0; i < vectorOfOwes_To.size(); i++) {
            if(vectorOfOwes_To.elementAt(i).returnType().equals("Deposit")) {
                if (vectorOfOwes_To.elementAt(i).returnAccountNumber().equals(delId)) {
                    p = -1;
                    continue;
                }
            }
            tempVector.add(vectorOfOwes_To.elementAt(i));
        }
        vectorOfOwes_To=tempVector;
        if (p == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired account record has been deleted");
        }
    }

    private void deleteExpense() {

        System.out.println('\n');

        System.out.println("Please enter serial no. of the Expense you want to delete");
        int delId = input.nextInt();
        input.nextLine();

        int p = 1;
        Vector<Expense> tempVector=new Vector<>(0);
        for (int i = 0; i < vectorOfExpenses.size(); i++) {
            if ((i+1)==delId) {
                p = -1;
                continue;
            }
            tempVector.add(vectorOfExpenses.elementAt(i));
        }
        vectorOfExpenses=tempVector;
        if (p == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired serial number of expense has been deleted");
        }
    }

    private void averageExpense(){

        float total=0;

        for(int i=0;i<vectorOfExpenses.size();i++)
            total+=vectorOfExpenses.elementAt(i).returnAmount();
        for(int i=0;i<vectorOfLend_borrow.size();i++) {
            total+=vectorOfLend_borrow.elementAt(i).returnAmount();
        }
        Date maxDate,minDate;
        Date tempDate = new Date();

        maxDate = minDate = vectorOfExpenses.elementAt(0).returnDate();

        for(int i=0; i<vectorOfExpenses.size();i++)
        {
            if(tempDate.before(minDate))
                maxDate=tempDate;
            else if ( tempDate.after(maxDate))
                minDate=tempDate;
        }

        long diffInMillies = maxDate.getTime() - minDate.getTime();

        diffInMillies = ((((diffInMillies /1000)/60)/60)/24);
            if(diffInMillies==0)
                ++diffInMillies;
        System.out.println("The Avg Expense Per Day is  "+ total/diffInMillies + "\n");

    }

    private void addtransactionFriend() {
        System.out.println('\n');
        Lend_Borrow tempFriend;

        System.out.println("Please Enter The Name Of The Friend");
        String PersonName=input.nextLine();

        System.out.println("Please Enter The Amount");
        float amount=input.nextFloat();
        input.nextLine();

        System.out.println("Please Enter the Type Borrow/Lend");
        String type=input.nextLine();


        System.out.println("Please Enter The Tag");
        String tag=input.nextLine();

        System.out.println("Please Enter The Mode Of Payment");
        String ModeOfPayment=input.nextLine();

        Date date=new Date();



        tempFriend = new Lend_Borrow(type,PersonName,amount,tag,ModeOfPayment,date);
        vectorOfLend_borrow.add(tempFriend);
    }


    private void deletetransactionFriend() {

        System.out.println('\n');

        System.out.println("Please enter the serial number of the transaction");
        int delId = input.nextInt();

        int p = 1;
        Vector<Lend_Borrow> tempVector=new Vector<>(0);
        for (int i = 0; i < vectorOfLend_borrow.size(); i++) {
            if ((i+1)==delId) {
                p = -1;
                continue;
            }
            tempVector.add(vectorOfLend_borrow.elementAt(i));
        }
        vectorOfLend_borrow=tempVector;
        if (p == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired transaction number has been deleted");
        }
    }

    public void loggedIn () {

        System.out.println('\n');
        System.out.println("Successfully logged in as "+personName);
        System.out.println("User Id : "+personId);
        //displaying menu after getting logged in
        do {
            System.out.println('\n');
            System.out.println("--ADD ZONE--\n");
            System.out.println("1. Add New Expense Details");
            System.out.println("2. Add details of transactions among friends ");
            System.out.println("3. Add Details Of A New Loan Or A New Account");
            System.out.println("\n--DELETE ZONE--\n");
            System.out.println("4. Delete Existing Expense Details");
            System.out.println("5. Delete details of transactions among friends ");
            System.out.println("6. Delete loan record");
            System.out.println("7. Delete account record");
            System.out.println("\n--VIEW ZONE--\n");
            System.out.println("8. View Total Expenses, Deposits And Loans as well as transactions among friends");
            System.out.println("9. Avg Expense per day");
            System.out.println("\n--EXIT ZONE--\n");
            System.out.println("10. Log Out");
            int expenseChoice = input.nextInt();
            input.nextLine();

            System.out.println('\n');

            switch (expenseChoice) {
                case 1:
                    addExpense();
                    break;
                case 4:
                    deleteExpense();
                    break;
                case 3:
                    addLoan();
                    break;
                case 2:
                    addtransactionFriend();
                    break;
                case 5:
                    deletetransactionFriend();
                    break;
                case 6:
                    deleteLoan();
                    break;
                case 7:
                    deleteAccount();
                    break;
                case 8:
                    viewExpenses();
                    break;
                case 9:
                    averageExpense();
                    break;
                case 10:
                    return;
            }
        }while(true);
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