/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static int getID(){
        int id;
        do {
            try {
                System.out.print("Enter ID: ");
                id = Integer.parseInt(sc.nextLine());
                return id;
            } catch (Exception e) {
                System.out.println("ID is digit");
            }
        } while (true);
    }
    
    public static String getStr(String msg){
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
            System.out.println("Please input only text!");
            return getStr(msg);
        }
        return str;
        
    }
    
    public static String getNonBlankStr(String msg) {
        Scanner sc = new Scanner(System.in);
        String result;
        System.out.print(msg);
        result = normalizeAndRecapitalize(sc.nextLine());
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
     
     public static String normalizeAndRecapitalize(String S) {
        //Check if the input is empty
        if (S.length() == 0) {
            return S;
        }
        StringTokenizer stk = new StringTokenizer(S, " ");
        String result = capitalizeFirstChar(stk.nextToken().toLowerCase());
        //Capitalize the first char of each token and merge them back into input
        while (stk.hasMoreElements()) {
            result += " " + capitalizeFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }
     public static String getPhone(){
         String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
         String phone;
           while (true) {
               System.out.print("Enter Phone: ");
            String result = sc.nextLine();
            if (result.matches(VALID_PHONE)) {
                return result.replaceAll("\\D+","").substring(0, 9);
            }
            System.err.println("Please input phone flow \n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.println("Enter again: ");
        }
    }
     
     public static Contact checkExistContact(ArrayList<Contact> List,int ID){
         if(List.isEmpty()){
             System.out.println("There are no contact do delete!");
             return null;
         }
         for (Contact x : List) {
             if(x.getID()==ID)
                 return x;
         }
         System.out.println("No found contact!");
         return null;
     }
     
}

