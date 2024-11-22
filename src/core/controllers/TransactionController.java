/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Account;
import core.models.Transaction;
import core.models.TransactionType;
import core.models.storage.TransactionStorage;
import java.util.ArrayList;

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
            destinationAccount.deposit(amountDouble);
            return new Response("amount deposited", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

    public static Response createWithdrawal(String sourceAccountId, String amount) {
        try {
            double amountDouble;
            Account sourceAccount = (Account) AccountController.getAccount(sourceAccountId).getObject();
            try {
                amountDouble = Double.parseDouble(amount);
                if (amountDouble < 0) {
                    return new Response("amount must be positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException e) {
                return new Response("amount must be numeric", Status.BAD_REQUEST);
            }
            if (!sourceAccount.withdraw(amountDouble)) {
                return new Response("insufficient money", Status.BAD_REQUEST);
            }
            return new Response("amount Withdrawed", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
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
