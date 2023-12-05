/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xuant
 */
public class Validation {
    private Scanner sc = new Scanner(System.in);
    
    
    
    //nhap va tra ve gioi tinh
    public String getGender(){
        String gender;
        while(true){
            gender = getNonBlankStr("Enter gender", "not empty!");
            if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
                break;
            else{
                System.out.println("Gender is only allowed to enter male or female");
            }
        }
        return gender;
    }
    
    //nhap va tra ve degree
    public String getDegree(){
        String degree;
        while(true){
            degree = getNonBlankStr("Enter degree", "not empty!");
            if(degree.equalsIgnoreCase("intermediate")||degree.equalsIgnoreCase("college")||degree.equalsIgnoreCase("university"))
                break;
            else{
                System.out.println("Degree is only allowed to enter intermediate, college or university");
            }
        }
        return degree;
    }
    
    //nhap va tra ve ngay sinh neu dung format
    public String getBirth() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        String birth;
        do {
            try {
                //nhap thoi gian
                birth = getNonBlankStr("Enter birth: ", "not empty");
                //neu ngay nhap sai thi se bao loi
                formatter.setLenient(false);
                //tao thoi gian theo format
                date = formatter.parse(birth);
                return birth;
            } catch (ParseException e) {
                System.err.println("Invalid date!");
            }
        } while (true);
    }
    
    //nhap va tra ve customer type
    public String getCusomterType(){
        String type;
         while(true){
            type = getNonBlankStr("Enter gender", "not empty!");
            if(type.equalsIgnoreCase("new")||type.equalsIgnoreCase("member")||type.equalsIgnoreCase("vip"))
                break;
            else{
                System.out.println("Customer type is only allowed to enter new, member, or vip.");
            }
        }
        return type;
    }
    
    //get a non empty string
    public String getNonBlankStr(String msg, String err) {
        Scanner sc = new Scanner(System.in);
        String result;
        System.out.println(msg);
        result = sc.nextLine().trim();
        //throw new exception for empty input
        if (result.isEmpty()) {
            System.out.println(err);
            return getNonBlankStr(msg, err);
        }

        return result;
    }
   
}
