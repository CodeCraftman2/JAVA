import java.util.Scanner;

public class bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.displayMenu();
    }
}

class BankAccount {

    private double balance;
    private double selection = 0;
    private Scanner select = new Scanner(System.in);

    void displayMenu() {
        while (selection != 6) {
            for (int i = 0; i < 81; i++)
                System.out.print("=");
            System.out.println("\n  Welcome to JAI RAM Bank");
            for (int i = 0; i < 81; i++)
                System.out.print("=");
            System.out.println("\n Branch Name   |   IFSC       |   Address");
            for (int i = 0; i < 81; i++)
                System.out.print("-");
            System.out.println("\n AGARPADA      |   SBIN0013585|   AT BY PO AGARPADA, ISTT.BHADRAK, ODISHA 756115");
            for (int i = 0; i < 81; i++)
                System.out.print("=");
            System.out.println("\nWhat would you like to do? \nSelect an option:");
            System.out.println("\n1) Open an account");
            System.out.println("2) Close an account");
            System.out.println("3) Deposit");
            System.out.println("4) Withdraw");
            System.out.println("5) Login as Administrator");
            System.out.println("6) Exit");

            selection = select.nextDouble();

            switch ((int)selection) {
                case 1:
                    createAcc();
                    break;
                case 2:
                    closeAcc();
                    break;
                case 3:
                    System.out.println("Make a deposit.\n---------------\nEnter the amount you'd like to deposit");
                    double depAmount = select.nextDouble();
                    deposit(depAmount);
                    break;
                case 4:
                    System.out.println("Make a withdrawal.\n---------------\nEnter the amount you'd like to withdraw");
                    double withdrawAmount = select.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 5:
                    AdministrativeServices.displayAccountDetails(balance);
                    break;
                case 6:
                    System.out.print("Thank you for using our services.\n---------------\nJai Shree Ram !\n---------------\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid selection.");
                    break;
            }
        }
    }

    int generateAccountNumber() {
        // Generate a random integer between 1000 and 9999
        return (int) (Math.random() * (99999 - 10000 + 1) + 10000);
    }

    void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
        else
            System.out.println("Please enter a valid amount to deposit:");
    }

    void withdraw(double amount) {
        if (amount > 0) {
            if (amount > balance) {
                System.out.println("Insufficient balance.");
            } else
                balance -= amount;
        } else
            System.out.println("Please enter a valid withdrawal amount:");
    }

    void closeAcc() {
    }

    void createAcc() {
        System.out.println("How many accounts would you like to open?");
        int numAccounts = (int)select.nextDouble();

        for (int i = 0; i < numAccounts; i++) {
            System.out.println("Enter name for account " + (i + 1) + ": ");

            select.nextLine();
            String accountHolderName = select.nextLine(); // Read the name of the account holder

            int accountNumber = (int)generateAccountNumber(); // Generate account number

            System.out.println("Enter initial deposit amount for account " + (i + 1) + " (compulsory): ");
            double initialDeposit = select.nextDouble();
            while (initialDeposit <= 2000) { // Ensure initial deposit is positive
                System.out.println("Initial deposit must be greater than 2000. Please enter again: ");//Warning for initial deposit
                initialDeposit = select.nextDouble();
            }

            System.out.println("Account " + (i + 1) + " has been created successfully for " + accountHolderName + ".");
            System.out.println("Welcome, " + accountHolderName + "!");
            System.out.println("Account Number: " + accountNumber);
            deposit(initialDeposit); // Deposit the initial amount into the account
        }
    }
}

