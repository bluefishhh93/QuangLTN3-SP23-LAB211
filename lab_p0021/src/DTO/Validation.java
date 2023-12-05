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
    public static String continueCreate(){
        String select="";
        do{
                System.out.println("Do you want to continue (Y/N)?");
                select = sc.nextLine();            
        }while(!select.equalsIgnoreCase("N")&&!select.equalsIgnoreCase("Y"));
        return select;
    }
    
    public static int getId(){
        int id;
        do{
            try {
                System.out.print("Enter Student ID: ");
                id=Integer.parseInt(sc.nextLine());
                return id;
            } catch (Exception e) {
                System.out.println("Invalid ID!");
            }
        }while(true);
    }
    
    public static String getCourseName(){    
        while (true) {
            String courseName = InputString();
            if (courseName.equalsIgnoreCase("java")|| courseName.equalsIgnoreCase(".net")|| courseName.equalsIgnoreCase("c/c++")) {
                return courseName;
            }
        }
    }
    public static String InputString(){
        
        while(true){
            String str = sc.nextLine().trim();
            if(str.length() == 0 ||str.isEmpty())
                System.out.println("No empty input!");
            else
                return str.toUpperCase();
        }
    }
    
    public static int getInteger(int size, String str){
        int select;
        while(true){
            try {
                System.out.println("Input your selection to"+str);
                System.out.println("From"+1+"-"+size);
                select=Integer.parseInt(sc.nextLine());
                if(select>=1&&select<=size)
                    return select;
                else
                    System.out.println("Only from"+1+"-"+size);
            } catch (Exception e) {
                System.out.println("Invalid input");
                System.out.println("Please input again");
            }
        }
        
    }
    
    public static String updateOrDelete(){
        String select="";
        do{
                System.out.println("Do you want to Update or Delete(U/D)?");
                select = sc.nextLine();            
        }while(!select.equalsIgnoreCase("U")&&!select.equalsIgnoreCase("D"));
        return select;
    }
}
