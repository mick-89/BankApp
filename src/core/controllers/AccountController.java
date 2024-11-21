/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.controllers;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
public class AccountController {
    public static Response createAccount(String userId, String initialBalance) {
        return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
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
