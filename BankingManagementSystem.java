// Importing Scanner class for taking user input from the console
import java.util.Scanner;

// This class represents a bank account with basic functionalities
class BankAccount {
    // Final variables: cannot be changed after they are assigned in the constructor
    final String accountHolder;     // Name of the account holder
    final String accountNumber;     // Unique account number

    // Private variable: only accessible within this class
    private double balance;         // Stores the current balance of the account

    // Constructor to initialize account details when creating an object
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;     // Set account holder name
        this.accountNumber = accountNumber;     // Set account number
        this.balance = initialBalance;          // Set initial balance
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount; // Increase balance by deposit amount
        // Show confirmation
        System.out.println("Deposited ₹" + amount + ". New balance: ₹" + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > balance) {
            // If withdrawal amount is greater than available balance
            System.out.println("Insufficient balance!");
        } else {
            // Deduct the amount and show updated balance
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + ". Remaining balance: ₹" + balance);
        }
    }

    // Method to display account details and current balance
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);         // Display name
        System.out.println("Account Number: " + accountNumber);         // Display account number
        System.out.println("Current Balance: ₹" + balance);             // Display balance
    }
}

// This is the main class that controls the Banking Management System
public class BankingManagementSystem {
    // Entry point of the program
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);

        // Create a new bank account with initial details
        BankAccount account = new BankAccount("Ayush Kumar Jha", "GU1420159", 5000.00);

        // Start an infinite loop to keep showing the menu until the user exits
        while (true) {
            // Display main menu
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            // Read the user's menu choice
            int choice = scanner.nextInt();

            // Handle different choices using switch-case
            switch (choice) {
                case 1:
                    // Deposit option
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();  // Read deposit amount
                    account.deposit(depositAmount);               // Call deposit method
                    break;

                case 2:
                    // Withdraw option
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble(); // Read withdrawal amount
                    account.withdraw(withdrawAmount);             // Call withdraw method
                    break;

                case 3:
                    // Check balance option
                    account.checkBalance();                       // Call checkBalance method
                    break;

                case 4:
                    // Exit option
                    System.out.println("Thank you for using our banking system!");
                    scanner.close();                              // Close the scanner to prevent memory leak
                    return;                                       // Exit the program

                default:
                    // If user enters an invalid option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


