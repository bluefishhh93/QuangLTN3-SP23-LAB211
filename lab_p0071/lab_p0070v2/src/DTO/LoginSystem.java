/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xuant
 */
public class LoginSystem {

    private Scanner sc = new Scanner(System.in);
    private String userMsg, userErr;
    private String passwordMSg, passwordErr;
    private String catpchaMsg, catpchaerr;
    Validation validation;
    Locate locate;
    HashSet<User> accounts;

    public LoginSystem() {
        
    }

    public LoginSystem(String path) {
        accounts = new HashSet<>();
        try {
            locate = new Locate(path);
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        validation = new Validation();
        //goi ham readFileProperties(String path) va lay du lieu tu file
        setLocate(locate);
       
    }

    public  void setLocate(Locate locale){
            userMsg = locale.p.getProperty("userMsg");
            userErr = locale.p.getProperty("userErr");
            passwordMSg = locale.p.getProperty("passwordMSg");
            passwordErr = locale.p.getProperty("passwordErr");
            catpchaMsg = locale.p.getProperty("catpchaMsg");
            catpchaerr = locale.p.getProperty("catpchaerr");
    }
    
    //dang nhap
    public void login() {
        String userName;
        String password;
        String catpcha;
        //kiem tra dang nhap number account
        userName = validation.checkAccountNumber(userMsg, userErr);
        //kiem tra dang nhap password
        password = validation.checkPassword(passwordMSg, passwordErr);
        catpcha = checkCaptcha();

        accounts.add(new User(userName, password, catpcha));

    }

    //tao ngau nhien catpcha
    public String enerateCaptcha() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(AlphaNumericString.length());
            char randomChar = AlphaNumericString.charAt(index);
            sb.append(randomChar);
        }

        return sb.toString();

    }

    //tao captcha ngau nhien
    //input vao ki tu hoac chuoi
    //kiem tra neu co input trong catpcha thi se break khong thi nhap lai
    public String checkCaptcha() {
        Scanner sc = new Scanner(System.in);
        String check;
        String captchaGenerate = enerateCaptcha();
        System.out.println("Catpcha: " + captchaGenerate);
        do {
            System.out.print(catpchaMsg);
            String captchaInput = sc.nextLine();
            check = checkCaptcha(captchaInput, captchaGenerate);
            if (check != null) {
                System.out.println("Login succesfull");
                break;
            } else {
                //khong tim thay input trong catpcha
                System.out.println(catpchaerr);
                
            }
        } while (check == null);
        return check;
    }

    //kiem tra neu input co trong catpcha hay khong
    //tra ve null neu khong
    String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaInput.isEmpty()) {
            return null;
        }
        if (captchaGenerate.contains(captchaInput)) {
            System.out.println(captchaGenerate);
            System.out.println(captchaInput);
            return captchaGenerate;
        } else {
            return null;
        }
    }

}
