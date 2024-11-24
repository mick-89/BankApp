/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.models;

public class EventHandler {
    // Personalmente me encantaría hacer esta clase estática pero el parcial no
    // es el momento ideal para ponerse a experimentar.
    private Account account;
    
    public EventHandler(final Account a) {
        account = a;
    }
    
    
    public void deposit(double amount) {
        account.balance += amount;
    }
    
    public boolean withdraw(double amount) {
        if (amount > account.balance) {
            return false;
        }
        account.balance -= amount;
        return true;
    }
}
