import account.Account;
import account.AccountManager;
import account.CheckingAccount;
import account.SavingsAccount;
import customers.Customer;
import customers.PremiumCustomer;
import customers.RegularCustomer;
import processTransaction.TransactionManager;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AccountManager manager = new AccountManager();
        TransactionManager transactionManager = new TransactionManager();
        int choice;

        do {
            // Display Menu
            System.out.println("____________________________________________________________");
            System.out.println();
            System.out.println("  ┌───────────────────────────────────────────────┐");
            System.out.println("  │      BANK ACCOUNT MANAGEMENT - MAIN MENU     │");
            System.out.println("  └───────────────────────────────────────────────┘");
            System.out.println();
            System.out.println("  1. Create Account");
            System.out.println("  2. View Accounts");
            System.out.println("  3. Process Transaction");
            System.out.println("  4. View Transaction History");
            System.out.println("  5. Exit");
            System.out.println();
            System.out.print("  Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    createAccount(scanner , manager);
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    processTransaction();
                    break;

                case 4:
                    viewTransactionHistory();
                    break;

                case 5:
                    System.out.println("Exiting system... Thank you for using Bank Account Management.");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 5.");
            }

        } while (choice != 5);

        scanner.close();
    }

    // ===== Menu Functions =====

    public static void createAccount(Scanner scanner,AccountManager accountManager) {
        // User Details
        System.out.println("[Enter your details]");
        System.out.println(" Enter Customer name: ");
        String customerName = scanner.nextLine();
        System.out.println(" Enter Customer age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        //
        System.out.println(" Enter Customer contact: ");
        String contact = scanner.nextLine();

        //
        System.out.println(" Enter Customer address: ");
        String address = scanner.nextLine();
        //

        System.out.println("--------------");

        System.out.println("Choose customer type: 1. Regular / 2.Premium");
        int customerType = scanner.nextInt();
        System.out.println(" Choose account type : 1. Savings Account. 2. Checking Account");
        int accountType = scanner.nextInt();

        System.out.println("Enter initial deposit amount: $2500");
        double deposit = scanner.nextDouble();
        // print account created succesfully

        Customer customer;
        if (customerType ==1){
            customer = new RegularCustomer(customerName, age,contact,address);
        } else {
            customer = new PremiumCustomer(customerName, age,contact,address);
        }
        // account object
        Account account;
        if (accountType == 1){
            account = new SavingsAccount(customer, deposit);
        }else {
            account = new CheckingAccount(customer, deposit);
        }
        accountManager.addAccount(account);

        System.out.print("Account created successfully!!");

        account.displayAccountDetails();

        System.out.println("Press enter to continue...");
        scanner.nextLine();



    }

    public static void viewAccounts() {
        System.out.println("[View Accounts]");
        System.out.println("No accounts available to display.");
        System.out.println();
    }

    public static void processTransaction() {
        System.out.println("[Process Transaction]");
        System.out.println("Transaction processing feature coming soon...");
        System.out.println();
    }

    public static void viewTransactionHistory() {
        System.out.println("[View Transaction History]");
        System.out.println("No transaction history found.");
        System.out.println();
    }
}
