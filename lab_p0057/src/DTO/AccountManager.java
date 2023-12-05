/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/**
 *
 * @author xuant
 */
public class AccountManager {
    HashSet<Account> accounts;

    public AccountManager() {
        accounts = new HashSet<>();
        loadAccountsFromFile();
    }
    
    
    public void addAccount(Account acc) throws Exception{      
        do{
            try {
                acc.setUserName(Validation.checkExistUserName(accounts, Validation.getUserName()));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(true);
        
        do{
            try {
                acc.setPassword(Validation.getPassword());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(true);     
        accounts.add(acc);      
    }
    
    public void loginAccount(){
        String userName;
        String password;
        do{
            try {
               userName=Validation.getUserName();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(true);
        
        do{
            try {
                password=Validation.getPassword();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(true);
        
        
        
    }
    
    public Account find(Account acc) throws Exception{
         return null;
     }
    
    
    public void loadAccountsFromFile() {
        try {
            File file = new File("src\\user.dat");
            if (!file.exists()) {
                return;
            }
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.accounts = (HashSet<Account>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveAccountsToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("src\\user.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.accounts);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
