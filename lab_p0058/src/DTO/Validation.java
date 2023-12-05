/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class Validation {
    public String inputStr(String msg,String errMsg){
       String str;
        str = getNonBlankStr(msg);
        String regex =(
            "^" //Start of line
            + "\\s*" //0 or many space
            + "([A-Za-z]+\\s?)*" //0 or many word that separate by 0 or 1 space
            + "\\s*" //0 or many space
            + "$");              //end of line
        //throw new exception if the name doesn't match the pattern
        if (!str.matches(regex)) {
            System.out.println(errMsg);
            return inputStr(msg,errMsg);
        }
        return str;
    }
    
    
     public String getNonBlankStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String result;
        System.out.println(msg);
        result = capitalizeFirstChar(sc.nextLine());
        //throw new exception for empty input
        if (result.isEmpty()) {
            System.out.print("Empty input!\n");
            return getNonBlankStr(msg);
        }
        return result;
    }
     
     public static String capitalizeFirstChar(String str) {
        //If the string is null or empty return immediately.
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
     
     public String getChoice() {
        Scanner sc = new Scanner(System.in);
        String choice = "";      
            do {

                try {
                    System.out.println("This word is already exist!\nDo you want to update(Y/N)");
                    choice = sc.nextLine();
                    if (!choice.equalsIgnoreCase("Y") && !choice.endsWith("N")) {
                        throw new IllegalArgumentException("Please input (Y/N)");
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
        
        return choice;
    }

}
