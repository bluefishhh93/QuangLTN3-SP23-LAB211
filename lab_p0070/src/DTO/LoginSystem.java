/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
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

    public LoginSystem() {
        validation = new Validation();
        
    }

    //dang nhap
    public void login(String path) {
        //goi ham readFileProperties(String path) va lay du lieu tu file
        try {
            readFileProperties(path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //kiem tra dang nhap number account
        validation.checkAccountNumber(userMsg, userErr);
        //kiem tra dang nhap password
        validation.checkPassword(passwordMSg, passwordErr);
        checkCaptcha();
        
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
    public void checkCaptcha() {
        String check;
        String captchaGenerate = enerateCaptcha();
        System.out.println("Catpcha: " + captchaGenerate);
        do {                   
            System.out.print(catpchaMsg);
            String captchaInput = sc.nextLine();
            check = checkCaptcha(captchaInput, captchaGenerate);
            if (check == null) {
                //khong tim thay input trong catpcha
                System.out.println(catpchaerr);
            }else{
                System.out.println("Login succesfull");
                return;
            }
        } while (true);
    }
    
    //kiem tra neu input co trong catpcha hay khong
    //tra ve null neu khong
    String checkCaptcha(String captchaInput, String captchaGenerate) {
        if(captchaGenerate.contains(captchaInput)){
            System.out.println(captchaGenerate);
            System.out.println(captchaInput);
            return captchaGenerate;
        }else{
            return null;
        }
    }

    //lay du lieu tu file duoi properties
    public void readFileProperties(String path) throws FileNotFoundException {
        FileReader language_properties = new FileReader(path);
        Properties p = new Properties();
        try {
            p.load(language_properties);
            userMsg = p.getProperty("userMsg");
            userErr = p.getProperty("userErr");
            passwordMSg = p.getProperty("passwordMSg");
            passwordErr = p.getProperty("passwordErr");          
            catpchaMsg = p.getProperty("catpchaMsg");
            catpchaerr = p.getProperty("catpchaerr");
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
