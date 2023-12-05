/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author xuant
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    public String getID() throws Exception {
        String id;
        System.out.print("Enter Code: ");
        id = sc.nextLine();
        if (id.isEmpty()) {
            throw new Exception("Empty input!");
        }
        String regex = ("[Ww]\\s+\\d+");
        if (!id.matches(regex)) {
            throw new Exception("Invalid Code()\nExample: W 1 or w 1.");
        }
        return id.toUpperCase();
    }

    public float getWorkerSalary() throws Exception {
        float salary;
        try {
            System.out.print("Enter Salary: ");
            salary = Float.parseFloat(sc.nextLine());
        } catch (Exception e) {
            throw new Exception("Please enter number");
        }
        if (salary <= 0) {
            throw new Exception("Salary must greater than 0");
        }
        return salary;
    }

    public int getWorkerAge() throws Exception {
        int age;
        try {
            System.out.print("Enter Age: ");
            age = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            throw new Exception("Please enter number!");
        }
        if (age < 18 || age > 50) {
            throw new Exception("Age must be in range 18 to 50");
        }
        return age;
    }

    public String isCodeExist(ArrayList<Worker> list, String id) throws Exception {
        for (Worker c : list) {
            if (c != null && c.getId().toLowerCase().equals(id.toLowerCase())) {
                throw new Exception("Name is already existed in the list");
            }
        }
        return id;
    }

    public Worker findWorker(ArrayList<Worker> list, String code) {
        for (Worker x : list) {
            if (x.getId().equals(code)) {
                return x;
            }
        }
        System.out.println("Not found!");
        return null;
    }

    public String getNonBlankStr(String msg) throws Exception {
        System.out.print(msg);
        String str = sc.nextLine();
        String regex = ("^" //Start of line
                + "\\s*" //0 or many space
                + "([A-Za-z]+\\s?)*" //0 or many word that separate by 0 or 1 space
                + "\\s*" //0 or many space
                + "$");
        if (str.isEmpty()) {
            throw new Exception("Empty input!");
        }
        if (!str.matches(regex)) {
            throw new Exception("Please input text!");
        }
        return capitalWord(str);
    }

    public String capitalFirstChar(String str) {
        if (str.isEmpty() || str == null) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);

    }

    public String capitalWord(String str) {
        StringTokenizer stk = new StringTokenizer(str, " ");
        String result = capitalFirstChar(stk.nextToken().toLowerCase());
        while (stk.hasMoreElements()) {
            result += " " + capitalFirstChar(stk.nextToken().toLowerCase());
        }
        return result;
    }

    public String getDate() {
        String date;
        LocalDate ld = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        date = ld.format(formatter);

        return date;
    }

}
