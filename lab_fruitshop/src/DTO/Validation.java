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
       private static Scanner sc = new Scanner(System.in);

    public static int getInteger(String inputMsg, String errorMsg){
        int id;
        do{
            try {
                System.out.print(inputMsg);
                id=Integer.parseInt(sc.nextLine());
                return id;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }while(true);
    }
    
    public static String getString(String inputMsg, String errorMsg) {
        String id;        
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();            
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else 
                return id;
        }
    }
    public static double getADouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getSelection(String inputMsg, String errorMsg) {
        String select="";
        do{
                System.out.println(inputMsg);
                select = sc.nextLine();            
                if(select.equalsIgnoreCase("N")||select.equalsIgnoreCase("Y"))
                    return select;
                else
                    System.out.println(errorMsg);
        }while(true);

    }
    
    public static int getFruitItem(int size){
        int select=0;
        do{
            //System.out.println("Choosing item number to order from("+1+"to"+size+")");
            try {
                System.out.print("Choosing item number to order from("+1+"to"+size+")");
                select=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Please input integer");
            }
        }while(select<0||select>size);
        return select;
    }
}
