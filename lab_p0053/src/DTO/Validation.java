/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author xuant
 */
public class Validation {
    static Scanner sc = new Scanner(System.in);
    static Integer checkin(String inputVal){
      // Pattern pattern = Pattern.compile("^[0-9]+([,.][0-9]?)?$");
      Pattern pattern = Pattern.compile("^-?\\d+$");
       Matcher matcher = pattern.matcher(inputVal);
       if(!matcher.matches()){
           System.out.println("Please input integer:");
           return checkin(sc.nextLine().trim());
       }else
           return Integer.parseInt(inputVal);
   }
    
    static int getLength(){
        int result;
        System.out.println("Input Length Of Array");
        do{
        System.out.print("Enter number: ");
            result = checkin(sc.nextLine().trim());
        if(result<=0){
            System.out.println("Please input number and number is greater than zero");
        }
        }while(result<=0);
        return result;
    }
    
    static void getElement(int[] arr ){
        for(int i=0;i<arr.length;i++){
            System.out.println("Enter number "+(i+1));
            arr[i] = checkin(sc.nextLine().trim());
        }
    }
}
