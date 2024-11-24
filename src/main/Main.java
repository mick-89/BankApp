/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import core.models.storage.IdStorage;
import core.views.BankFrame;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Global.UserStorage = new IdStorage<>();
        Global.AccountStorage = new IdStorage<>();
        Global.TransactionStorage = new ArrayList<>();
        
        System.out.println("hello, moto");
        BankFrame view = new BankFrame();
        view.setVisible(true);
    }
}
