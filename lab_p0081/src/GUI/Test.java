/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.BeeManager;





/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Create bee list","Attack bees","Exit"};
        BeeManager bm = new BeeManager();
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    bm.createBees();
                    break;
                case 2:
                    bm.attackBees();
                    break;
                    
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
