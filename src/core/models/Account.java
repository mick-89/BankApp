/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

/**
 *
 * @author edangulo
 */
public class Account implements IdStorable {
    
    private String id;
    private Owner owner; // creo que también principio D?
    double balance; // visibilidad default por el EventHandler

    public Account(String id, Owner owner) {
        this.id = id;
        this.owner = owner;
        this.balance = 0;
        
        this.owner.addAccount(this);
    }
    
    public Account(String id, Owner owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        
        this.owner.addAccount(this);
    }
    
    @Override
    public String getId() {
        return id;
    }
    @Override
    public boolean hasMatchingId(Object id) {
        return this.id.equals(id);
    }
    public Owner getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    
    // no sé si estos rompan el Single responsibility
    
    // creo que se usaría como un event handler o algo así
    /*public void deposit(double amount) {
        this.balance += amount;
    }
    
    public boolean withdraw(double amount) { 
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }
    */
}
