import java.util.*;

public class AdministrativeServices {
    private static Map<Integer, List<String>> transactionHistoryMap = new HashMap<>();
    private static Map<Integer, String> accountHolderMap = new HashMap<>();
    private static Map<Integer, Double> accountBalanceMap = new HashMap<>();
    private static int numAccounts = 0;

    public static int createAcc(String accountHolderName, double initialDeposit) {
        int accountNumber = ++numAccounts;
        // Initialize transaction history for the new account
        transactionHistoryMap.put(accountNumber, new ArrayList<>());
        // Store account holder name, account number, and initial deposit
        accountHolderMap.put(accountNumber, accountHolderName);
        accountBalanceMap.put(accountNumber, initialDeposit);
        System.out.println("Account created successfully!");
        return accountNumber;
    }

    public static void closeAcc(int accountNumber) {
        // Remove account details and transaction history
        transactionHistoryMap.remove(accountNumber);
        accountHolderMap.remove(accountNumber);
        accountBalanceMap.remove(accountNumber);
        numAccounts--;
        System.out.println("Account closed successfully!");
    }

    public static void deposit(int accountNumber, double depositAmount) {
        // Update account balance and record transaction
        double currentBalance = accountBalanceMap.getOrDefault(accountNumber, 0.0);
        currentBalance += depositAmount;
        accountBalanceMap.put(accountNumber, currentBalance);
        recordTransaction(accountNumber, "Deposit: $" + depositAmount);
        System.out.println("Deposit successful. New balance: $" + currentBalance);
    }

    public static void withdraw(int accountNumber, double withdrawAmount) {
        // Check if sufficient balance and update account balance
        double currentBalance = accountBalanceMap.getOrDefault(accountNumber, 0.0);
        if (currentBalance >= withdrawAmount) {
            currentBalance -= withdrawAmount;
            accountBalanceMap.put(accountNumber, currentBalance);
            recordTransaction(accountNumber, "Withdrawal: $" + withdrawAmount);
            System.out.println("Withdrawal successful. New balance: $" + currentBalance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    private static void recordTransaction(int accountNumber, String transaction) {
        // Add the transaction to the transaction history of the specified account
        List<String> transactionHistory = transactionHistoryMap.getOrDefault(accountNumber, new ArrayList<>());
        transactionHistory.add(transaction);
        transactionHistoryMap.put(accountNumber, transactionHistory);
    }

    public static void displayTransactionHistory() {
        System.out.println("Transaction History for All Opened Accounts:");
        for (Map.Entry<Integer, List<String>> entry : transactionHistoryMap.entrySet()) {
            int accountNumber = entry.getKey();
            String accountHolderName = accountHolderMap.get(accountNumber);
            double accountBalance = accountBalanceMap.get(accountNumber);
            List<String> transactionHistory = entry.getValue();

            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Balance: $" + accountBalance);
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println("- " + transaction);
            }
            System.out.println();
        }
    }

    public static void displayAccountDetails(double balance) {
        System.out.println("Enter account number to display details: ");
        // Adjusted method to accept no arguments
        int accountNumber = new Scanner(System.in).nextInt();
        String accountHolderName = accountHolderMap.getOrDefault(accountNumber, "Account not found");
        double accountBalance = accountBalanceMap.getOrDefault(accountNumber, 0.0);

        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: $" + accountBalance);
    }
}
