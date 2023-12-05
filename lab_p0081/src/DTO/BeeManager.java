/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author xuant
 */
public class BeeManager {

    List<Bee> beeList;

    public BeeManager() {
       
    }

    public void createBees() {
         beeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            beeList.add(new Worker());
        }
        for (int i = 0; i < 10; i++) {
            beeList.add(new Queen());
        }
        for (int i = 0; i < 10; i++) {
            beeList.add(new Drone());
        }
    }

    public void attackBees() {
        // Clear console
        clearConsole();
        Random rd = new Random();
        for (Bee bee : beeList) {
            bee.damage(rd.nextInt(100));
        }
        
        showStatus();
    }

    public void showStatus() {
        System.out.printf("%-10s %-10s %-10s","Type","Health","Status");
        System.out.println("");
        for (Bee x : beeList) {
            x.showStatus();
        }
    }
    
    public static void clearConsole() {
    // ANSI escape codes to clear the console
    System.out.print("\033[H\033[2J");
    System.out.flush();
}
    
}
