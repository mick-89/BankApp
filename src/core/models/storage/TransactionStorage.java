package core.models.storage;

import core.models.Transaction;
import java.util.ArrayList;

/*@author Juan Drive  desde de de dedede de dedeman*/
public class TransactionStorage {
    
    // Instancia Singleton
    private static TransactionStorage instance;
    
    // Atributos del Storage
    private ArrayList<Transaction> transactions;
    
    private TransactionStorage() {
        this.transactions = new ArrayList<>();
    }
    
    public static TransactionStorage getInstance() {
        if (instance == null) {
            instance = new TransactionStorage();
        }
        return instance;
    }
    
    public boolean addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        return true;
    } 
    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }
    
    
    

}

