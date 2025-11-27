import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
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
            System.out.println();

            switch (choice) {
                case 1:
                    createAccount();
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

    public static void createAccount() {
        System.out.println("[Create Account]");
        System.out.println("Account creation feature coming soon...");
        System.out.println();
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
