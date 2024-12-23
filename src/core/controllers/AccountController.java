/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Account;
import core.models.User;
import core.models.storage.IdStorage;

import java.util.ArrayList;
import java.util.Random;
import main.Global;
import static main.Global.AccountStorage;

public class AccountController {

    public static Response createAccount(String userId, String initialBalance) {
        try {
            int userIdInt;
            double initialBalanceInt;

            try {
                userIdInt = Integer.parseInt(userId);
                if (userIdInt < 0 || userIdInt>999999999) {
                    return new Response("ID must be positive and have less than 10 digits", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            try {
                initialBalanceInt = Double.parseDouble(initialBalance);
                if (initialBalanceInt < 0) {
                    return new Response("initial Balance must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("initial Balance must be numeric", Status.BAD_REQUEST);
            }
            User selectedUser;
            selectedUser = (User) UserController.getUser(userId).getObject();
            if (selectedUser != null) {
                Random random = new Random();
                int first = random.nextInt(1000);
                int second = random.nextInt(1000000);
                int third = random.nextInt(100);
                
                String accountId = String.format("%03d", first) + "-" + String.format("%06d", second) + "-" + String.format("%02d", third);
                IdStorage<Account> storage = Global.AccountStorage;
                Account a = new Account(accountId, selectedUser, initialBalanceInt);
 
                storage.add(a);
                return new Response("account created successfully", Status.CREATED);
            }
            return new Response ("User not found", Status.BAD_REQUEST);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
        //return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }

    public static Response getAccount(String id) {
        try{
            IdStorage<Account> storage = Global.AccountStorage;
            Account account = storage.get(id);
            if(account == null){
                return new Response("Account not found", Status.NOT_FOUND);
            }
            return new Response("Account found", Status.OK, account);
            
        }catch (Exception e) {
              return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
        //return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }

    public static Response getAccounts() {
        try {
            IdStorage<Account> storage = Global.AccountStorage;
            ArrayList<Account> accounts = storage.getList();
            accounts.sort((obj1, obj2) -> (obj1.getId().compareTo(obj2.getId())));            
            return new Response("Account list found", Status.OK, accounts);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
