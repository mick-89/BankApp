/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package core.controllers;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Transaction;
import java.util.ArrayList;

public class TransactionController {
    switch (type) { // sí nada de esto va acá
            case "Deposit": {
                Account destinationAccount = null;
                for (Account account : this.accounts) {
                    if (account.getId().equals(destinationAccountId)) {
                        destinationAccount = account;
                    }
                }
                if (destinationAccount != null) {
                    destinationAccount.deposit(amount);

                    this.transactions.add(new Transaction(TransactionType.DEPOSIT, null, destinationAccount, amount));

                    sourceAccountTextField.setText("");
                    destinationAccountTextField.setText("");
                    amountTextField.setText("");
                }
                break;
            }
            case "Withdraw": {
                String sourceAccountId = sourceAccountTextField.getText();
                double amount = Double.parseDouble(amountTextField.getText());

                Account sourceAccount = null;
                for (Account account : this.accounts) {
                    if (account.getId().equals(sourceAccountId)) {
                        sourceAccount = account;
                    }
                }
                if (sourceAccount != null && sourceAccount.withdraw(amount)) {
                    this.transactions.add(new Transaction(TransactionType.WITHDRAW, sourceAccount, null, amount));

                    sourceAccountTextField.setText("");
                    destinationAccountTextField.setText("");
                    amountTextField.setText("");
                }
                break;
            }
            case "Transfer": {
                String sourceAccountId = sourceAccountTextField.getText();
                String destinationAccountId = destinationAccountTextField.getText();
                double amount = Double.parseDouble(amountTextField.getText());

                Account sourceAccount = null;
                Account destinationAccount = null;
                for (Account account : this.accounts) {
                    if (account.getId().equals(sourceAccountId)) {
                        sourceAccount = account;
                    }
                }
                for (Account account : this.accounts) {
                    if (account.getId().equals(destinationAccountId)) {
                        destinationAccount = account;
                    }
                }
                if (sourceAccount != null && destinationAccount != null && sourceAccount.withdraw(amount)) {
                    destinationAccount.deposit(amount);

                    this.transactions.add(new Transaction(TransactionType.TRANSFER, sourceAccount, destinationAccount, amount));

                    sourceAccountTextField.setText("");
                    destinationAccountTextField.setText("");
                    amountTextField.setText("");
                }
                break;
            }
            default: {
                sourceAccountTextField.setText("");
                destinationAccountTextField.setText("");
                amountTextField.setText("");
                break;
            }
        }
    public static Response createDeposit(String destinationAccount, String amount) {
        try{
             Account destinationAccount = null;
                for (Account account : this.accounts) {
                    if (account.getId().equals(destinationAccountId)) {
                        destinationAccount = account;
                    }
                }
                if (destinationAccount != null) {
                    destinationAccount.deposit(amount);

                    this.transactions.add(new Transaction(TransactionType.DEPOSIT, null, destinationAccount, amount));

                    sourceAccountTextField.setText("");
                    destinationAccountTextField.setText("");
                    amountTextField.setText("");
                }
                
            }try(Ex{
                
            }catch
        }catch(Exception e){
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);  
        }
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
