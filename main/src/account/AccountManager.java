package account;

public class AccountManager {
    private Account[] accounts;
    private int accountCount;

    // Constructor
     AccountManager(){
         this.accounts= new Account[50];
         this.accountCount= 0;
     }
    public void addAccount(Account account){
        accounts[accountCount] = account;
        accountCount++;
    }
    //

}
