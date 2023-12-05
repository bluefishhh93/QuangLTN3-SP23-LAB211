/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Account;
import DTO.AccountManager;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Create a new account","Login system","Exit"};
        int choice;
        AccountManager am = new AccountManager();
        Account account = null;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    account = new Account();
                {
                    try {
                        am.addAccount(account);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                    break;

                case 2:
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
