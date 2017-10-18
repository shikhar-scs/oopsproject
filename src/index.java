import java.io.*;
import java.util.*;
import java.lang.*;

public class index {

    static boolean bool=true;
    private static Vector<Person> vectorOfPersons=new Vector<>(0);
    static Scanner input=new Scanner(System.in);
    private static int idGenerator = 0;
    private static void averageExpense(Person p){

        float total=0;
        Vector<Expense> vectorOfExpenses=p.returnVectorOfExpenses();
        Vector<Lend_Borrow> vectorOfLend_borrow=p.returnVectorOfLend_Borrow();
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
    private static void viewExpenses(Person p){
        System.out.println('\n');
        Vector<Expense> vectorOfExpenses=p.returnVectorOfExpenses();
        System.out.println("Expenses Details");
        System.out.println("--Sr.-- "+" --Tag--" +" --Date-- "+" --Mode Of Payment-- "+" --Amount-- ");
        for(int i=0;i<vectorOfExpenses.size();i++) {
            System.out.println((i+1)+"   "+vectorOfExpenses.elementAt(i).returnTag()+"   "+vectorOfExpenses.elementAt(i).returnDate()+"   "+vectorOfExpenses.elementAt(i).returnModeOfPayment()+"   "+vectorOfExpenses.elementAt(i).returnAmount());
        }

        System.out.println('\n');
        System.out.println("Money Lent/Borrowed from friends");
        Vector<Lend_Borrow> vectorOfLend_borrow=p.returnVectorOfLend_Borrow();
        System.out.println("--Sr.-- "+" --Category-- "+"--Tag--"+"--Name of Friend " +" --Date-- "+" --Mode Of Payment-- "+" --Amount-- ");
        for(int i=0;i<vectorOfLend_borrow.size();i++) {
            System.out.println((i+1)+"   "+vectorOfLend_borrow.elementAt(i).returnType()+"   "+ vectorOfLend_borrow.elementAt(i).returntag()+"   "+vectorOfLend_borrow.elementAt(i).returnpersonName()+"  "+vectorOfLend_borrow.elementAt(i).returnDate()+"   "+vectorOfLend_borrow.elementAt(i).returnModeOfPayment()+"   "+vectorOfLend_borrow.elementAt(i).returnAmount());
        }

        System.out.println('\n');

        System.out.println("Loan Details");
        Vector<Owes_To> vectorOfOwes_To=p.returnVectorOfOwes_to();
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
    private static void deletetransactionFriend(Person p) {

        System.out.println('\n');

        System.out.println("Please enter the serial number of the transaction");
        int delId = input.nextInt();

        int p1 = 1;
        Vector<Lend_Borrow> tempVector=new Vector<>(0);
        Vector<Lend_Borrow> vectorOfLend_borrow=p.returnVectorOfLend_Borrow();
        for (int i = 0; i < vectorOfLend_borrow.size(); i++) {
            if ((i+1)==delId) {
                p1 = -1;
                continue;
            }
            tempVector.add(vectorOfLend_borrow.elementAt(i));
        }
        vectorOfLend_borrow=tempVector;
        p.addLend_Borrow(vectorOfLend_borrow);
        if (p1 == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired transaction number has been deleted");
        }
    }
    private static void deleteAccount(Person p) {
        System.out.println('\n');

        System.out.println("Please enter the account number of the deposit you want to delete");
        String delId = input.nextLine();

        int p1 = 1;
        Vector<Owes_To> tempVector=new Vector<>(0);
        Vector<Owes_To> vectorOfOwes_To=p.returnVectorOfOwes_to();
        for (int i = 0; i < vectorOfOwes_To.size(); i++) {
            if(vectorOfOwes_To.elementAt(i).returnType().equals("Deposit")) {
                if (vectorOfOwes_To.elementAt(i).returnAccountNumber().equals(delId)) {
                    p1 = -1;
                    continue;
                }
            }
            tempVector.add(vectorOfOwes_To.elementAt(i));
        }
        vectorOfOwes_To=tempVector;
        p.addOwes_To(vectorOfOwes_To);
        if (p1 == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired account record has been deleted");
        }
    }
    private static void addtransactionFriend(Person p) {
        System.out.println('\n');
        Lend_Borrow tempFriend;
        Vector<Lend_Borrow> vectorOfLend_borrow=new Vector<>(0);
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
        p.addLend_Borrow(vectorOfLend_borrow);
    }
    private static void deleteLoan(Person p) {
        System.out.println('\n');

        System.out.println("Please enter the loan number of the loan you want to delete");
        String delId = input.nextLine();

        int p1 = 1;
        Vector<Owes_To> tempVector=new Vector<>(0);
        Vector<Owes_To> vectorOfOwes_To=p.returnVectorOfOwes_to();
        for (int i = 0; i < vectorOfOwes_To.size(); i++) {
            if (vectorOfOwes_To.elementAt(i).returnType().equals("Loan")) {
                if (vectorOfOwes_To.elementAt(i).returnLoanNumber().equals(delId)) {
                    p1 = -1;
                    continue;
                }
            }
            tempVector.add(vectorOfOwes_To.elementAt(i));
        }
        vectorOfOwes_To=tempVector;
        p.addOwes_To(vectorOfOwes_To);
        if (p1 == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired loan record has been deleted");
        }
    }
    private static void addLoan(Person p) {
        System.out.println('\n');
        Owes_To tempLoan=null;
        Vector<Owes_To> vectorOfOwes_To=new Vector<>(0);
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
        p.addOwes_To(vectorOfOwes_To);
    }
    private static void addExpense(Person p) {
        System.out.println('\n');
        Expense tempExpense;
        Vector<Expense> vectorOfExpenses=new Vector<>(0);
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
        p.addExpenses(vectorOfExpenses);
    }
    private static void deleteExpense(Person p) {

        System.out.println('\n');

        System.out.println("Please enter serial no. of the Expense you want to delete");
        int delId = input.nextInt();
        input.nextLine();
        Vector<Expense> vectorOfExpenses=p.returnVectorOfExpenses();
        int p1 = 1;
        Vector<Expense> tempVector=new Vector<>(0);
        for (int i = 0; i < vectorOfExpenses.size(); i++) {
            if ((i+1)==delId) {
                p1 = -1;
                continue;
            }
            tempVector.add(vectorOfExpenses.elementAt(i));
        }
        vectorOfExpenses=tempVector;
        p.addExpenses(vectorOfExpenses);
        if (p1 == 1) {
            System.out.println("Not Found");
        }
        else {
            System.out.println("The desired serial number of expense has been deleted");
        }
    }
    public static void loggedIn (Person p) {

        System.out.println('\n');
        System.out.println("Successfully logged in as "+p.returnPersonName());
        System.out.println("User Id : "+p.returnPersonId());
        //displaying menu after getting logged in
        do {
            System.out.println("\n--ADD ZONE--\n");
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
                    addExpense(p);
                    break;
                case 4:
                    deleteExpense(p);
                    break;
                case 3:
                    addLoan(p);
                    break;
                case 2:
                    addtransactionFriend(p);
                    break;
                case 5:
                    deletetransactionFriend(p);
                    break;
                case 6:
                    deleteLoan(p);
                    break;
                case 7:
                    deleteAccount(p);
                    break;
                case 8:
                    viewExpenses(p);
                    break;
                case 9:
                    averageExpense(p);
                    break;
                case 10:
                    return;
            }
        }while(true);
    }
    private static void signIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter UserName");
        String userName = input.nextLine();
        int signInPos=-1;//nothing located yet
        for(int i=0;i<vectorOfPersons.size();i++) {
            if(((vectorOfPersons.elementAt(i)).returnUserName()).equals(userName)) {
                signInPos=i;
            }
        }
        if(signInPos==-1) {
            System.out.println("No such username exists\nsign in again");
            signIn();//re-signIn
        }
        System.out.println("Enter password");
        String password = input.nextLine();

        if (vectorOfPersons.elementAt(signInPos).verify(userName, password)) {
            loggedIn(vectorOfPersons.elementAt(signInPos));
            main(null);//for now every time logged in is called it will call main()
            //later we can set up a user determined log out which will only be logged out
            //when user wants to
            //by using thread Handling
        }

        else {
            System.out.println("Invalid login credentials");
            main(null);
        }
    }
    private static void signUp() {

        System.out.println('\n');
        Person tempPerson;/* Details of newly signed up person
         later this will be pushed into the master object vector array*/

        Scanner input = new Scanner(System.in);//for input
        System.out.println("Enter Your Name");
        String name = input.nextLine();

        System.out.println("Enter UserName");
        String userName = input.nextLine();

        //performing username validation
        while (true) {
            boolean uniqueUserName=true;//tests if unique userName
            for (int i = 0; i < vectorOfPersons.size(); i++) {
                if (userName.equals(vectorOfPersons.elementAt(i).returnUserName())) {
                    System.out.println("This UserName already exists please enter again");
                    System.out.println("Enter UserName");
                    userName = input.nextLine();
                    uniqueUserName=false;//if not unique
                    break;
                }
            }
            if(uniqueUserName) {
                break;
            }
        }

        System.out.println("Enter Password");
        String password = input.nextLine();

        System.out.println("Confirm Password");
        String re_password = input.nextLine();

        if(re_password.equals(password)) { //checking password verification

            tempPerson = new Person(name, userName, password, ++idGenerator);//tempPerson takes new credentials
            vectorOfPersons.add(tempPerson);//pushing into master vector array
        }
        else {
            System.out.println("Password error");
            main(null);//again shows up the main menu
        }
        //if password cross-verification true then....
        System.out.println('\n');
        System.out.println("Do you want to sign in now? (yes/no)");
        String decision=input.nextLine();
        if(decision.equalsIgnoreCase("yes"))
            signIn();
        else
            main(null);//return back to main menu
    }
    public static void leave(){
        try {
            FileOutputStream file = new FileOutputStream(new File("data.txt"));
            PrintWriter pw=new PrintWriter(file);
            pw.write("");
            ObjectOutputStream o = new ObjectOutputStream(file);
            for(Object p:vectorOfPersons){
                o.writeObject(p);
            }
            o.close();
            file.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void enter(){
        try{
            int line=0;
            FileInputStream file = new FileInputStream(new File("data.txt"));
            ObjectInputStream i=new ObjectInputStream(file);
            if(file.available()==0){
                return;
            }
            System.out.println("Existing users");
            while (file.available()>0){
                Person p;
                p=(Person) i.readObject();
                if(p==null){
                    break;
                }
                System.out.println(p.returnPersonId()+" "+p.returnPersonName());
                vectorOfPersons.add(p);
                line++;
            }
            i.close();
            file.close();
            idGenerator+=line;
        }
        catch (FileNotFoundException fe){
            fe.printStackTrace();
        }
        catch (ClassNotFoundException ce){
            ce.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args) { //my main function where program would be run from
        System.out.println('\n');
        Scanner input = new Scanner(System.in);
        if(bool){
            enter();
            bool=false;
        }
        System.out.println("1. Sign in\n2. Sign up\n3. Exit");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            case 3:
                leave();
                break;

        }
    }
}