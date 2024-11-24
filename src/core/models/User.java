/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import java.util.ArrayList;

/**
 *
 * @author edangulo
 */
public class User implements Owner {
    
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private ArrayList<Account> accounts;

    public User(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.accounts = new ArrayList<>();
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public boolean hasMatchingId(Object id) {
        return this.id == (Integer)id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }
    
    public int getNumAccounts() {
        return this.accounts.size();
    }
    
    @Override
    public void addAccount(Account account) {
        this.accounts.add(account);
    }
    
}
