package account;

import customers.Customer;

public class CheckingAccount  extends Account{
    private double overdraftLimit;
    private double monthlyFee;

    // Contructor
    public CheckingAccount(String accountNumber, Customer customer, double balance, String status) {
        super(accountNumber, customer, balance, status);
        this.overdraftLimit = 1000.0;
        this.monthlyFee = 10.0;
    }

    @Override
    public String displayAccountDetails() {
        return "Account Number: " + getAccountNumber() ;
                "\nCustomer Name: " + getCustomer() +
                "\nAccount Type: checking " +
                "\nCBalance: $" + getBalance() +
                "\nOverdraft Limit : $ + overdraftLimit +\n";
    }

    @Override
    public boolean withdraw(double amount) {
        double allowedLimit = -overdraftLimit;  // balance can go down to -1000

        if (getBalance() - amount < allowedLimit) {
            System.out.println(" Withdrawal denied! Exceeds overdraft limit of $" + overdraftLimit);
            return false;
        }

        return super.withdraw(amount); // uses parent logic for updating balance
    }

    @Override
    public String getAccountType() {
        return "Checking";
    }

    public double applyMonthlyFee() {
        System.out.println("monthly fee of $" + monthlyFee);
        setBalance(getBalance() - monthlyFee);
    }
}
