/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import core.models.Account;
import core.models.Transaction;
import core.models.User;
import core.models.storage.IdStorage;
import java.util.ArrayList;

public class Global {
    public static IdStorage<User> UserStorage;
    public static IdStorage<Account> AccountStorage;
    public static ArrayList<Transaction> TransactionStorage;
}
