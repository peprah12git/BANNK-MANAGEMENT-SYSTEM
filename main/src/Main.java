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
            System.out.println("________________________________________");
            System.out.println("BANK ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("1. Create Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Process Transaction");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    createAccount(scanner, manager);
                    break;

                case 2:
                    viewAccounts(scanner, manager);
                    break;

                case 3:
                    processTransaction(scanner, manager, transactionManager);
                    break;

                case 4:
                    viewTransactionHistory(scanner, manager);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }

    // CREATE ACCOUNT
    public static void createAccount(Scanner scanner, AccountManager accountManager) {

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Customer type (1-Regular, 2-Premium): ");
        int customerType = scanner.nextInt();

        System.out.print("Account type (1-Savings, 2-Checking): ");
        int accountType = scanner.nextInt();

        System.out.print("Initial deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        Customer customer =
                (customerType == 1)
                        ? new RegularCustomer(name, age, contact, address)
                        : new PremiumCustomer(name, age, contact, address);

        Account account =
                (accountType == 1)
                        ? new SavingsAccount(customer, deposit)
                        : new CheckingAccount(customer, deposit);

        accountManager.addAccount(account);
        account.displayAccountDetails();
        System.out.println("Account created successfully!");
    }

    // VIEW ACCOUNTS
    public static void viewAccounts(Scanner scanner, AccountManager accountManager) {
        accountManager.viewAllAccounts();
        System.out.println("Press Enter...");
        scanner.nextLine();
    }

    // PROCESS TRANSACTION
    public static void processTransaction(Scanner scanner, AccountManager accountManager, TransactionManager transactionManager) {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        Account account = accountManager.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("1. Deposit  2. Withdraw");
        int choice = scanner.nextInt();

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        if (choice == 1) {
            account.deposit(amount);
            transactionManager.calculateTotalDeposits(accountNumber);
        } else {
            account.withdraw(amount);
            transactionManager.calculateTotalDeposits(accountNumber);
        }

        System.out.println("Transaction Successful!");
    }

    // VIEW TRANSACTION HISTORY
    public static void viewTransactionHistory(Scanner scanner, AccountManager accountManager) {

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        accountManager.findAccount(accountNumber);
        System.out.println("Transaction Records:");
    }
}
