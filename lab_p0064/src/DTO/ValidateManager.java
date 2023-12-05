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
public class ValidateManager {
  private Scanner sc = new Scanner(System.in);
  Validation validation = new Validation();

    
  
    public String checkPhone(String phone){
        phone = validation.inputPhone();
        return phone;
    }
    
    
    public String checkDate(String date){
        date = validation.inputDate();
        return date;
    }
    
    public String checkEmail(String email){
        email = validation.inputEmail();
        return email;
    }
    //ham in ra cac input vua nhap
    public void display(String phone, String date, String email){
        System.out.println("phone: "+phone);
        System.out.println("date: "+date);
        System.out.println("email: "+email);
    }
}
