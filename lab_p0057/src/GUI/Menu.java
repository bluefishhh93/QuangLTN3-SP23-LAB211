/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class Menu {
     public static int getChoice(Object[] options){
        int choice = 0;
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        for(int i=0; i<options.length;i++){
            System.out.println((i+1)+"."+options[i]);
        }
        System.out.print("> Choose");
        Scanner sc = new Scanner(System.in);
        do{
        try {
            choice = Integer.parseInt(sc.nextLine());
            return choice;
        } catch (Exception e) {
            System.out.println("Please input integer!");
        }
        }while(true); 
    }
}
