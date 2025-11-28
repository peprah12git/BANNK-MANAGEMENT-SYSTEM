package account;

import customers.Customer;

public class CheckingAccount extends Account {

    private double overdraftLimit;
    private double monthlyFee;

    // Constructor
    public CheckingAccount(String accountNumber, Customer customer, double balance, String status) {
        super(accountNumber, customer, balance, status);
        this.overdraftLimit = 1000.0;
        this.monthlyFee = 10.0;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println( "Account Number: " + getAccountNumber() +
                "\nCustomer Name: " + getCustomer() +
                "\nAccount Type: Checking" +
                "\nBalance: $" + getBalance() +
                "\nOverdraft Limit: $" + overdraftLimit
        );
    }

    @Override
    public boolean withdraw(double amount) {
        double allowedLimit = -overdraftLimit; // balance can go down to -1000

        if (getBalance() - amount < allowedLimit) {
            System.out.println("Withdrawal denied! Exceeds overdraft limit of $" + overdraftLimit);
            return false;
        }

        return super.withdraw(amount); // uses parent logic for updating balance
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }

    public void applyMonthlyFee() {
        System.out.println("Monthly fee of $" + monthlyFee + " applied.");
        setBalance(getBalance() - monthlyFee);
    }
}
