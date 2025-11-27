package processTransaction;

public class Transaction {
    static int  transactionCounter;
    private  String transactionId;
    private  String accountNumber;
   private String type;
    private double amount;
    private  double balanceAfter;
    private String StringTimestamp;

    Transaction( String accountNumber, String type, double amount, double balanceAfter){
        this.accountNumber= accountNumber;
        this.type= type;
        this.amount = amount;
        this.balanceAfter= balanceAfter;
    }
    static String generate() {
        return  String.format("TXN%03d", ++transactionCounter);
    }

    public static int getTransactionCounter() {
        return transactionCounter;
    }

    public static void setTransactionCounter(int transactionCounter) {
        Transaction.transactionCounter = transactionCounter;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public String getStringTimestamp() {
        return StringTimestamp;
    }

    public void setStringTimestamp(String stringTimestamp) {
        StringTimestamp = stringTimestamp;
    }
    public  void  displayTransactionDetails(){
        return;
    }
}
