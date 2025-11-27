package account;

import customers.Customer;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private double balance;
    private String status;

    private static int accountCounter= 0;

    // Contructor
    public Account(String accountNumber, Customer customer, double balance, String status) {
        this.accountNumber = generate() ;
        this.customer = customer;
        this.balance = balance;
        this.status = status;
        //this.accountNumber= accountCounter;
    }

    static String generate() {
        return  String.format("ACC%03d", ++accountCounter);
    }

    // Getters for account number
    public String getAccountNumber(String accountNumber) {
        return accountNumber;
    }
    public String getCustomer(String customer) {
        return customer;
    }
    public double getBalance(double balance) {
        return balance;
    }
    public String getStatus() {
        return status;
    }

    // setter for customer
    public void setStatus(String status) {
        this.status = status;
    }

    // Setters for balance
    public String setBalance(String balance) {
        return balance;
    }
    // get accounts.Account method & Display Account method
    public abstract String displayAccountDetails();
    public abstract String getAccountType();

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    // Withdraw Money
    public  void withdraw(double amount){
        if (amount > balance){
            System.out.println("Insufficient funds withdrawer can not be made");
        }else {
            balance-=amount;
            System.out.println("Withdrawal made successfully");
        }
    }
}
