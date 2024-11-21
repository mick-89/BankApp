/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.controllers;
import core.controllers.utils.Response;
import core.controllers.utils.Status;

public class TransactionController {
    public static Response createDeposit(String destinationAccount, String amount) {
        return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    } 
    public static Response createWithdrawal(String sourceAccount, String amount) {
        return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }
    public static Response createTransferal(String sourceAccount, String targetAccount, String amount) {
        return new Response("cálmate ve", Status.NOT_IMPLEMENTED);
    }
    
    public static Response getTransactions() {
         try {
            TransactionStorage storage = TransactionStorage.getInstance();
            ArrayList<Transaction> transactions = storage.getTransactions();
            return new Response("Transaction list found", Status.OK, transactions);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);            
        }
    }
}
