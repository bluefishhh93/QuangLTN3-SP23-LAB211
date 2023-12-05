/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.StudentManager;

/**
 *
 * @author xuant
 */
public class Test {
    public static void main(String[] args) {
        String[] options = {"Create","Find and Sort","Update/Delete","Report","Exit"};
        int choice;
        StudentManager sm = new StudentManager();
        do{
            choice = Menu.getChoice(options);
            switch (choice) {
                case 1:
                    sm.create();
                    break;
                case 2:
                    sm.findAndSort();
                    break;
                case 3:
                    sm.updateOrDelete();
                    break;
                case 4:
                    sm.report();
                    break;
                case 5:
                    System.exit(0);
            }
        }while(true);
    }
}
