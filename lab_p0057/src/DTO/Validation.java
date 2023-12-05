/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    
    public static String getUserName() throws Exception{
        String userName;
        System.out.print("Enter Username: ");
        userName = sc.nextLine();
        String regex = "^(?=\\\\S{5,}$).+";
        if(!userName.matches(regex)){
            throw new Exception("You must enter least at 5 character, and no space!");
        }
        return userName;
    }
    
    public static String getPassword() throws Exception{
        String passWord;
        System.out.print("Enter Password");
        passWord = sc.nextLine();
        String regex = "^(?=\\\\S{6,}$).+";
        if(!passWord.matches(regex)){
            throw new Exception("You must enter least at 6 character, and no space!");
        }
        return passWord;
    }
    
    public static String checkExistUserName(HashSet<Account> accounts,String userName) throws Exception{
        for (Account account : accounts) {
            if(account.getUserName().equals(userName)){
                throw new Exception("This user name was used!");
            }
        }
        return userName;
    }
    
}
