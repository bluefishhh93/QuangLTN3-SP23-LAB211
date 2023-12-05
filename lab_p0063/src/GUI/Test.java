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
        String[] options = {"Input information of person","Show 3 persons information by ascending of lalary","Exit"};
        int choice;
        PersonManager pm = new PersonManager();
        do {
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                   pm.inputPersonInfor();
                    break;
                case 2:
                    pm.displayPersonInfor();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}
