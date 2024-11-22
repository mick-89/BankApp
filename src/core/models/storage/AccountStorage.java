package core.models.storage;

import core.models.Account;
import java.util.ArrayList;

/*@author Juan Drive  desde de de dedede de dedeman*/
public class AccountStorage {
    
    // Instancia Singleton
    private static AccountStorage instance;
    
    // Atributos del Storage
    private ArrayList<Account> accounts;
    
    private AccountStorage() {
        this.accounts = new ArrayList<>();
    }
    
    public static AccountStorage getInstance() {
        if (instance == null) {
            instance = new AccountStorage();
        }
        return instance;
    }
    
    public boolean addAccount(Account account) {
        for (Account u : this.accounts) {
            if (u.getId() == account.getId()) {
                return false;
            }
        }
        this.accounts.add(account);
        return true;
    }
    
    public Account getAccount(String id) {
        for (Account account : this.accounts) {
            if (account.getId().equals( id)) {
                return account;
            }
        }
        return null;
    }
    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }
}
