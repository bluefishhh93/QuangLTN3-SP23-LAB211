/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.PersonManager;




/**
 *
 * @author xuant
 */
public class Test {

    public static void main(String[] args) {
        String[] options = {"Find person info","Copy Text to new file","Exit"};
        PersonManager pm = new PersonManager();
        int choice;
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    pm.getPerson();
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
