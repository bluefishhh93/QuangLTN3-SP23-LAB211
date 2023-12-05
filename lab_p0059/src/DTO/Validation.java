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
    public String getFilePath(){
        String path;
        while(true){
        System.out.print("Enter Path: ");
        path = sc.nextLine().trim();
        if(path.length() == 0){
            System.err.println("Not empty!");
        }else if(!path.matches("^[a-zA-Z]:\\\\(?:[^\\\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\\\/:*?\"<>|\\r\\n]*$")){
            System.err.println("Invalid path format. Please enter a valid file path.");
        }else{
            break;
        }
        }
        return path;
    }
    
    public double getMoney(){
        double money;
        while(true){
            try {
                System.out.print("Enter money: ");
                money = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input number!");
            }
        }
        if(money < 0) return 0;
        else{
            return money;
        }
    }
}
