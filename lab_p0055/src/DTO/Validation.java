/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author xuant
 */
public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int checkAvailability() throws Exception {
        int availability;
        try {
            System.out.print("Enter availability: ");
            availability = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            throw new Exception("Invalid input\nPlease input integer!");
        }

        if (availability <= 0) {
            throw new Exception("Availability must larger than 0");
        }
        return availability;
    }
    
    public static String getCode(){
        String code;
        do{
            System.out.print("Enter Code: ");
            code = sc.nextLine();
            if(code.isEmpty())
                System.out.println("Empty input");
        }while(code.isEmpty());
        String regex = ("[Dd][Oo][Cc]\\s{1}\\d+");
        if(!code.matches(regex)){
            System.out.println("Invalid Code()");
            System.out.println("Example: DOC 1 or doc 1.");
            return getCode();
        }
        return code.toUpperCase();
    }
    
    public static String findExistedCode(HashMap<String, Doctor> doctorMap, String Code) throws Exception {
//        if(doctorMap.isEmpty()) return Code;
        if(doctorMap.containsKey(Code)) throw new Exception("Doctor code [Code] is duplicate");
        return Code;
    }
    
    public static String getStr(String msg){
        String str = getNonBlankStr(msg);
        String regex =(
            "^" //Start of line
            + "\\s*" //0 or many space
            + "([A-Za-z]+\\s?)*" //0 or many word that separate by 0 or 1 space
            + "\\s*" //0 or many space
            + "$");    
        if(!str.matches(regex)){
            System.out.println("Please input only text!");
            return getStr(msg);
        }
        return str;
    }
    
    public static String getNonBlankStr(String msg){
        System.out.println(msg);
        String result = capitalWord(sc.nextLine());
        if(result.isBlank()){
            System.out.print("Empty input!\n");
            return getNonBlankStr(msg);
        }
        return result;
    }
    
    public static String capitalFirstChar(String str){
        if(str.isEmpty()||str==null)
            return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
        
    }
    
    public static String capitalWord(String str){
        StringTokenizer stk = new StringTokenizer(str, " ");
        String result = capitalFirstChar(stk.nextToken().toLowerCase());
        while(stk.hasMoreElements()){
            result += " " + capitalFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }
    
    public static String getStrCanEmpty(String msg){
        System.out.println(msg);
        String str = sc.nextLine().trim();
        String regex =(
            "^" //Start of line
            + "\\s*" //0 or many space
            + "([A-Za-z]+\\s?)*" //0 or many word that separate by 0 or 1 space
            + "\\s*" //0 or many space
            + "$");    
        if(!str.matches(regex)){
            System.out.println("Please input only text!");
            return getStr(msg);
        }
        return str;
    }
    
    
    public static int checkAvailabilityCanEmpty() throws Exception {
        String number = sc.nextLine().trim();
        if(number==null||number.isEmpty()) return 0;
        int availability;
        try {
            System.out.print("Enter availability: ");
            availability = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            throw new Exception("Invalid input\nPlease input integer!");
        }

        if (availability <= 0) {
            throw new Exception("Availability must larger than 0");
        }
        return availability;
    }
    
    
}
