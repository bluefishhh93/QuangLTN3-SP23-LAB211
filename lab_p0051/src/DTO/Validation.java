/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.awt.BorderLayout;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class Validation {
    static Scanner sc = new Scanner(System.in);
   static Operator checkOperator(String operator) {
        switch (operator) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.EXPONENT;
            case "=":
                return Operator.EQUAL;
            default:
                System.out.println("Please input (+, -, *, /, ^)");
                System.out.println("Enter Operator: ");
                return checkOperator(sc.nextLine());
        }
    }
    
   static Double checkin(String inputVal){
       Pattern pattern = Pattern.compile("^[0-9]+([,.][0-9]?)?$");
       Matcher matcher = pattern.matcher(inputVal);
       if(!matcher.matches()){
           System.out.println("Please input number:");
           return checkin(sc.nextLine());
       }else
           return Double.parseDouble(inputVal);
   }
}
