import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String CustomerID;

    //constructing my class
    public Account(String cname, String cid) {
        customerName = cname;
        CustomerID = cid;
    }

    //deposit money
    public void deposit(int amount) {
        if (amount != 0) {
            balance = (balance + amount);
            previousTransaction = amount;
        }
    }

    //withdraw function
    public void withdraw(int amount) {
        if (amount != 0) {
            balance = (balance - amount);
            previousTransaction = -amount;
        }
    }

    //show previous transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }


    //calculate interest based on years
    public void calculateInterest(int years) {
        double interestRate = .0140;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("the current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }

    //mainmenu
    public void MainMenu() {
        char option = '\0';
        Scanner userInput = new Scanner(System.in);
        System.out.println("welcome " + customerName + "!");
        System.out.println("Your ID is " + CustomerID);
        System.out.println();
        System.out.println("what would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. view previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. exit");

        do {
            System.out.println();
            System.out.println("enter an option: ");
            char option1 = userInput.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("===========================");
                    System.out.println("balance = $" + balance);
                    System.out.println("============================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("enter an amount to deposit: ");
                    int amount = userInput.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = userInput.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("==============================");
                    getPreviousTransaction();
                    System.out.println("===============================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = userInput.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("Error: invalid option. Enter A, B, C, D , E, F");
                    break;
            }
        } while (option != 'F');
        System.out.println("thank you for banking with us");
    }

}