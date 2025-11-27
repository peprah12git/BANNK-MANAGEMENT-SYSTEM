package account;

import customers.Customer;

public class SavingsAccount extends Account{

    // private fields
    private double interestRate;
    private double minimumBalance;

    // Setting constructor
    public SavingsAccount(String accountNumber, Customer customer, double balance, String status) {
        super(accountNumber, customer, balance, status);
        this.interestRate = 3.5;
        this.minimumBalance = 500;
    }

    @Override
    public String displayAccountDetails() {
        String baseDetails;
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: $" + minimumBalance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < minimumBalance) {
            System.out.println(" Withdrawal denied! Balance cannot go below minimum: $" + minimumBalance);
            return false;
        }
        return super.withdraw(amount);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }

    // Calculating interest method
    public double calculateInterest() {
        return (getBalance() + interestRate) / 100;
    }

}
