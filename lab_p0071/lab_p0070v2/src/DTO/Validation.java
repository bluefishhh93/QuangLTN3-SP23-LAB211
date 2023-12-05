/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    //nhap numberaccount cho den khi dung dinh dang
    public String checkAccountNumber(String msg,String errMsg){
        String user;
        String regex = "^[\\d]{10}$";
        System.out.print(msg);
        user = sc.nextLine();
        //throw new exception if the name doesn't match the pattern
        if (!user.matches(regex)) {
            System.out.println(errMsg);
            return checkAccountNumber(msg,errMsg);
        }
        return user;
        
    }
    //nhap password cho den khi dung dinh dang
    //Kiem tra password  duoc nhap phai bao gom so va chu cai, 
    //co the co ki tu dac biet va khong co ki tu khoang trang
    public String checkPassword(String msg,String errMsg){
        String password;
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?!.*\\s).{8,31}$";
        /*
        ^ matches the start of the string.
        (?=.*[0-9]) is a positive lookahead that checks if the string contains at least one digit.
        (?=.*[a-zA-Z]) is another positive lookahead that checks if the string contains at least one character (not including space).
        (?!.*\s) is a negative lookahead that checks if the string does not contain any whitespace characters.
        {8,31} matches any character (except newline) between 8 and 31 times.
        $ matches the end of the string.      
        */
        
        System.out.print(msg);
        password = sc.nextLine();
        //throw new exception if the name doesn't match the pattern
         if (!password.matches(regex)) {
            System.out.println(errMsg);
            return checkPassword(msg,errMsg);
        }
        return password;
    }
}
