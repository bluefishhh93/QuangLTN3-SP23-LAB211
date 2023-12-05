/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xuant
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    public double getSalary(){
        double salary;
        do {
            try {
                System.out.print("Enter salary: ");
                salary = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("You must input digit!");
            }
        } while (true);
        if(salary<=0){
            System.out.println("Salary is greater than zero!");
            return getSalary();
        }
        return salary;
    }
    
    public String getStr(String msg){
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
            System.out.println("You must input text!");
            return getStr(msg);
        }
        return normalizeAndRecapitalize(str);
        
    }
    
    public String getNonBlankStr(String msg) {
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
    
     public String capitalizeFirstChar(String str) {
        //If the string is null or empty return immediately.
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
     
     public String normalizeAndRecapitalize(String S) {
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
}
