/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author xuant
 */
public class PersonManager {

    Validation validation = new Validation();

    public PersonManager() {
    }

    public void getPerson() {
        System.out.println("--------------Person info---------------");
        String path = validation.getFilePath();
        double money = validation.getMoney();
        try {
            showResult(getPerson(path, money));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Person> getPerson(String path, double money) throws Exception {

        File file = new File(path);
        if ((!file.exists()) || file.length() == 0) {
            throw new Exception("File doesn't exist or this file is empty!");
        }
        if (!file.canRead()) {
            throw new Exception("Can read file!");
        }
        ArrayList<Person> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null) {
            String arr[] = line.split(";");
            String name = arr[0];
            String adress = arr[1];
            double salary;
            try {
                salary = Double.parseDouble(arr[2]);
            } catch (Exception e) {
                salary = 0;
            }
            if(salary>=money)
            {
            list.add(new Person(name, adress, salary));
            }
            line = br.readLine();
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }

    public void showResult(ArrayList<Person> listt) {
        System.out.println("------------- Result ----------");
        Collections.sort(listt);
        System.out.printf("%-15s %-15s %-7s\n", "Name", "Address", "Salary");
        for (Person x : listt) {
                x.display();
        }
    }

    public void copyWordOneTimes() {
        String path = validation.getFilePath();

    }
//    public static boolean copyWordOneTimes(String source, String destination) throws Exception {
//        
//    }

}
