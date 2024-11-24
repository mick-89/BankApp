/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Account;
import core.models.EventHandler;
import core.models.Transaction;
import core.models.TransactionType;

import java.util.ArrayList;
import java.util.Collections;
import main.Global;
import static main.Global.TransactionStorage;

public class TransactionController {

    public static Response createDeposit(String destinationAccountId, String amount) {
        try {
            double amountDouble;
            try {
                amountDouble = Double.parseDouble(amount);
            } catch (NumberFormatException e) {
                return new Response("amount must be numeric", Status.BAD_REQUEST);
            }
            if (amountDouble < 0) {
                return new Response("amount must be positive", Status.BAD_REQUEST);
            }
            Account destinationAccount = (Account) AccountController.getAccount(destinationAccountId).getObject();
            if (destinationAccount != null) {
                EventHandler e = new EventHandler(destinationAccount);
                e.deposit(amountDouble);
                ArrayList<Transaction> storage = Global.TransactionStorage;
                // sí sé que esto habrá que SOLID ificarlo luego
                if (storage.add(new Transaction(TransactionType.DEPOSIT, null, destinationAccount, amountDouble))) {
                    return new Response("amount deposited", Status.CREATED);
                } else{
                    return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);                    
                }
            } else {
                return new Response("Destination account not found", Status.NOT_FOUND);
            }
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response createWithdrawal(String sourceAccountId, String amount) {
        try {
            double amountDouble;
            try {
                amountDouble = Double.parseDouble(amount);
                if (amountDouble < 0) {
                    return new Response("amount must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("amount must be numeric", Status.BAD_REQUEST);
            }
            Account sourceAccount = (Account) AccountController.getAccount(sourceAccountId).getObject();
            if (sourceAccount != null) {
                EventHandler e = new EventHandler(sourceAccount);
                if (!e.withdraw(amountDouble)) {
                    return new Response("insufficient money", Status.BAD_REQUEST);
                }
                ArrayList<Transaction> storage = Global.TransactionStorage;
                // sí sé que esto habrá que SOLID ificarlo luego
                if (storage.add(new Transaction(TransactionType.WITHDRAW, sourceAccount, null, amountDouble))) {
                    return new Response("amount withdrawed", Status.CREATED);
                } else{
                    return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);                    
                }
            } else {
                return new Response("Source account not found", Status.NOT_FOUND);
            }
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response createTransferal(String sourceAccountId, String targetAccountId, String amount) {
        try {
            double amountDouble;
            try {
                amountDouble = Double.parseDouble(amount);
                if (amountDouble < 0) {
                    return new Response("amount must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("amount must be numeric", Status.BAD_REQUEST);
            }
            
            Account sourceAccount = (Account) AccountController.getAccount(sourceAccountId).getObject();
            if (sourceAccount == null) {
                return new Response("Source account not found", Status.NOT_FOUND);
            }
            Account targetAccount = (Account) AccountController.getAccount(targetAccountId).getObject();
            if (targetAccount == null) {
                return new Response("Target account not found", Status.NOT_FOUND);
            }
            EventHandler e1 = new EventHandler(sourceAccount);
            if (!e1.withdraw(amountDouble)) {
                return new Response("target account has insufficient money", Status.BAD_REQUEST);
            }
            EventHandler e2 = new EventHandler(targetAccount);
            e2.deposit(amountDouble);
            ArrayList<Transaction> storage = Global.TransactionStorage;
            
            // sí sé que esto habrá que SOLID ificarlo luego
            if (storage.add(new Transaction(TransactionType.TRANSFER, sourceAccount, targetAccount, amountDouble))) {
                return new Response("amount transfered", Status.CREATED);
            } else{
                return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);                    
            }
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response getTransactions() {
        try {
            ArrayList<Transaction> transactions = Global.TransactionStorage;
            ArrayList<Transaction> transactionsCopy = (ArrayList<Transaction>)transactions.clone();
            Collections.reverse(transactionsCopy);
            return new Response("Transaction list found", Status.OK, transactionsCopy);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
