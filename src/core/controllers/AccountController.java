/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Account;
import core.models.User;
import java.util.ArrayList;
import java.util.Random;

public class AccountController {

    public static Response createAccount(String userId, String initialBalance) {
        try {
            int userIdInt, initialBalanceInt;

            try {
                userIdInt = Integer.parseInt(userId);
                if (userIdInt < 0) {
                    return new Response("ID must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            try {
                initialBalanceInt = Integer.parseInt(initialBalance);
                if (initialBalanceInt < 0) {
                    return new Response("initialBalance must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("initialBalance must be numeric", Status.BAD_REQUEST);
            }
            User selectedUser;
            selectedUser = (User) UserController.getUser(userId).getObject();
            if (selectedUser != null) {
                Random random = new Random();
                int first = random.nextInt(1000);
                int second = random.nextInt(1000000);
                int third = random.nextInt(100);

                String accountId = String.format("%03d", first) + "-" + String.format("%06d", second) + "-" + String.format("%02d", third);
                accountStorage storage = accountStorage.getInstance();
                storage.add(new Account(accountId, selectedUser, initialBalanceInt));

            }
            return new Response("account created successfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
        //return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }

    public static Response getAccount(String id) {
        try{
            int idInt;
            try{
                idInt = Integer.parseInt(id);
                if(idInt<0){
                    return new Response("Id must be positive", Status.BAD_REQUEST);
                }
            }catch(NumberFormatException e){
                 return new Response("Id must be numeric", Status.BAD_REQUEST);
            }
            AccountStorage storage = AccountStorage.getInstance();
            Account account = storage.getAccount(idInt);
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
            AccountStorage storage = AccountStorage.getInstance();
            ArrayList<Account> accounts = storage.getAccounts();
            return new Response("Account list found", Status.OK, accounts);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
