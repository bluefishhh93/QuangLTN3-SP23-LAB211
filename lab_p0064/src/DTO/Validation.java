/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author xuant
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);
//ham nhap va kiem tra phone
    public String inputPhone() {
        //nhap phone
        System.out.print("Phone number: ");
        String phone = sc.nextLine();
        //bat dau bang so 0 va co 10 so
        String regex = "^0\\d{9}$";
        if (!phone.matches(regex)) {
            //neu co chua chu cai se bao loi
            if (phone.matches("[a-z]")) {
                System.out.println("Phone number must be number");
            }
            //neu it hoac nhieu hon 10 so thi se bao loi
            if (phone.length() != 10) {
                System.out.println("Phone number must be 10 digits");
            }
            //tra ve de quy inputPhone()
            return inputPhone();
        }
        return phone;
    }
//ham nhap va kiem tra thoi gian
    public String inputDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        String time;
        do {
            try {
                //nhap thoi gian
                System.out.print("Date: ");
                time = sc.nextLine();
                //neu ngay nhap sai thi se bao loi
                formatter.setLenient(false);
                //tao thoi gian theo format
                date = formatter.parse(time);
                return time;
            } catch (ParseException e) {
                System.err.println("Invalid date!");
            }
        } while (true);
    }
//ham nhap va kiem tra email
    public String inputEmail() {
        System.out.print("Mail: ");
        String email = sc.nextLine();
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(regex)) {
            System.err.println("Email must be correct format");
            return inputEmail();
        }
        return email;
    }
}
