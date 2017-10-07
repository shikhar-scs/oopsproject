
import java.util.*;
import java.lang.*;

public class index {
    private static Vector<Person> vectorOfPersons=new Vector<>(0);
    private static int idGenerator = 0;

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
            signIn();//re-signin
        }
        System.out.println("Enter password");
        String password = input.nextLine();

        if (vectorOfPersons.elementAt(signInPos).verify(userName, password)) {
            vectorOfPersons.elementAt(signInPos).loggedIn();
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
        System.out.println("Do you want to sign in now");
        String decision=input.nextLine();
        if(decision.equalsIgnoreCase("yes"))
            signIn();
        else
            main(null);//return back to main menu
    }

    public static void main(String[] args) { //my main function where program would be run from
        System.out.println('\n');
        Scanner input = new Scanner(System.in);
        System.out.println("1. Sign in\n2. Sign up");

        int choice = input.nextInt();
        switch (choice) {
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
        }

    }
}